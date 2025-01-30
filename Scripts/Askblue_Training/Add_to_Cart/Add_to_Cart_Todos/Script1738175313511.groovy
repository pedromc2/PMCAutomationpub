import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement as WebElement

WebUI.callTestCase(findTestCase('Askblue_Training/Login_Logout/Login_Positivo'), [('username') : 'standard_user', ('password') : 'secret_sauce'], 
    FailureHandling.STOP_ON_FAILURE)

//obtem a lista de botões add to cart
TestObject addToCart = findTestObject('Object Repository/Page_Swag Labs/button_add_to_cart')

List addToCartList = WebUI.findWebElements(addToCart, 10)

//para cada botão que exista
for (int i = 0; i < addToCartList.size(); i++) {
    TestObject itemNames = findTestObject('Object Repository/Page_Swag Labs/item_name')

    List itemNameList = WebUI.findWebElements(itemNames, 10)

    String name = (itemNameList[i]).getText()

    //System.out.println(name)
    TestObject itemPrices = findTestObject('Object Repository/Page_Swag Labs/item_price')

    List itemPriceList = WebUI.findWebElements(itemPrices, 10)

    String price = (itemPriceList[i]).getText()

    //System.out.println(price)
    //clica em adicionar ao carrinho	
    addToCartList.get(i).click()

    //verifica que o icone de carrinho incrementa uma unidade 
    WebUI.verifyElementText(findTestObject('Object Repository/Page_Swag Labs/icone_carrinho'), (i + 1).toString())

    //acede ao carrinho
    WebUI.click(findTestObject('Object Repository/Page_Swag Labs/icone_carrinho'))
	WebUI.delay(1)
	
    //obtem os nomes dos itens do carrinho
    TestObject cartItemNames = findTestObject('Object Repository/Page_Swag Labs/cart_item_name')

    List cartItemNameList = WebUI.findWebElements(cartItemNames, 10)

    //verifica se o produto adicionado está no carrinho, na ordem que foi adicionado	
    WebUI.verifyMatch((cartItemNameList[i]).getText(), name, false)

    //obtem os preços dos itens do carrinho
    TestObject cartItemPrices = findTestObject('Object Repository/Page_Swag Labs/cart_item_price')

    List cartItemPriceList = WebUI.findWebElements(cartItemPrices, 10)

    //verifica se o preço no carrinho corresponde ao preço da homepage
    WebUI.verifyMatch((cartItemPriceList[i]).getText(), price, false)

    //volta à homepage
    WebUI.click(findTestObject('Object Repository/Page_Swag Labs/button_Continue Shopping'))
	
	//refresca as listas
	addToCartList = WebUI.findWebElements(addToCart, 10)
	itemNameList = WebUI.findWebElements(itemNames, 10)
	itemPriceList = WebUI.findWebElements(itemPrices, 10)
}



