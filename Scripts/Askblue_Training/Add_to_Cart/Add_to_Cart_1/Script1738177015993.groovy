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

TestObject addToCart = findTestObject('Object Repository/Page_Swag Labs/button_add_to_cart')
List addToCartList = WebUI.findWebElements(addToCart, 10)

TestObject itemNames = findTestObject('Object Repository/Page_Swag Labs/item_name')
List itemNameList = WebUI.findWebElements(itemNames, 10)
String name = itemNameList[0].getText()
//System.out.println(name)

TestObject itemPrices = findTestObject('Object Repository/Page_Swag Labs/item_price')
List itemPriceList = WebUI.findWebElements(itemPrices, 10)
String price = itemPriceList[0].getText()
//System.out.println(price)

addToCartList.get(0).click()

WebUI.verifyElementText(findTestObject('Object Repository/Page_Swag Labs/icone_carrinho'), '1')

WebUI.click(findTestObject('Object Repository/Page_Swag Labs/icone_carrinho'))

TestObject cartItemNames = findTestObject('Object Repository/Page_Swag Labs/cart_item_name')
List cartItemNameList = WebUI.findWebElements(cartItemNames, 10)
WebUI.verifyMatch(cartItemNameList[0].getText(), name, false)

TestObject cartItemPrices = findTestObject('Object Repository/Page_Swag Labs/cart_item_price')
List cartItemPriceList = WebUI.findWebElements(cartItemPrices, 10)
WebUI.verifyMatch(cartItemPriceList[0].getText(), price, false)

WebUI.click(findTestObject('Object Repository/Page_Swag Labs/button_Continue Shopping'))