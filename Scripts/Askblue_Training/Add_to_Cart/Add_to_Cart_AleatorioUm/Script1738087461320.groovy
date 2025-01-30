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
import org.openqa.selenium.WebElement

WebUI.callTestCase(findTestCase('Askblue_Training/Login_Logout/Login_Positivo'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Page_Swag Labs/icone_Carrinho'), '')


//obtem a lista de botões add to cart
TestObject addToCart = findTestObject('Object Repository/Page_Swag Labs/button_add_to_cart')
List addToCartList = WebUI.findWebElements(addToCart, 10)
//obtem a lista de nomes dos itens
TestObject itemNames = findTestObject('Object Repository/Page_Swag Labs/item_name')
List itemNameList = WebUI.findWebElements(itemNames, 10)
//obtem a lista de preços
TestObject itemPrices = findTestObject('Object Repository/Page_Swag Labs/item_price')
List itemPriceList = WebUI.findWebElements(itemPrices, 10)

//gera um numero aleatório entre 0 e o número de itens
Random rand = new Random()
int r = rand.nextInt(addToCartList.size())

//guarda o nome do item aleatorio
String name = itemNameList[r].getText()
//guarda o preço do item aleatorio
String price = itemPriceList[r].getText()
//clica no botão add to cart do item aleatorio
addToCartList.get(r).click()

//verfica que o icone do carrinho mostra '1'
WebUI.verifyElementText(findTestObject('Page_Swag Labs/icone_carrinho'), '1')
//acede ao carrinho
WebUI.click(findTestObject('Object Repository/Page_Swag Labs/icone_carrinho'))
//obtem os nomes dos itens do carrinho
TestObject cartItemNames = findTestObject('Object Repository/Page_Swag Labs/cart_item_name')
List cartItemNameList = WebUI.findWebElements(cartItemNames, 10)
//verifica se o produto adicionado está no carrinho
WebUI.verifyMatch((cartItemNameList[0]).getText(), name, false)
//obtem os preços dos itens do carrinho
TestObject cartItemPrices = findTestObject('Object Repository/Page_Swag Labs/cart_item_price')
List cartItemPriceList = WebUI.findWebElements(cartItemPrices, 10)
//verifica se o preço no carrinho corresponde ao preço da homepage
WebUI.verifyMatch((cartItemPriceList[0]).getText(), price, false)

WebUI.click(findTestObject('Object Repository/Page_Swag Labs/button_Continue Shopping'))