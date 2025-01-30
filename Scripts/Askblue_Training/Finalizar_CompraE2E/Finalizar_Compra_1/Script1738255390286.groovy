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

WebUI.callTestCase(findTestCase('Askblue_Training/Add_to_Cart/Add_to_Cart_1'), [:], FailureHandling.STOP_ON_FAILURE)

//acede ao carrinho
WebUI.click(findTestObject('Page_Swag Labs/icone_carrinho'))

//obtem os nomes e preços dos itens do carrinho
TestObject cartItemNames = findTestObject('Object Repository/Page_Swag Labs/cart_item_name')

List cartItemNameList = WebUI.findWebElements(cartItemNames, 10)

TestObject cartItemPrices = findTestObject('Object Repository/Page_Swag Labs/cart_item_price')

List cartItemPriceList = WebUI.findWebElements(cartItemPrices, 10)

WebUI.delay(2)

//inicia o checkout
WebUI.click(findTestObject('Object Repository/Page_Swag Labs/button_Checkout'))

//preenche os dados
WebUI.setText(findTestObject('Object Repository/Page_Swag Labs/input_Checkout Your Information_firstName'), 'João')

WebUI.setText(findTestObject('Object Repository/Page_Swag Labs/input_Checkout Your Information_lastName'), 'Silva')

WebUI.setText(findTestObject('Object Repository/Page_Swag Labs/input_Checkout Your Information_postalCode'), '1000-001')

WebUI.click(findTestObject('Object Repository/Page_Swag Labs/input_Cancel_continue'))

List checkoutItemNameList = WebUI.findWebElements(findTestObject('Object Repository/Page_Swag Labs/checkout_item_price'),
	10)

List checkoutItemPriceList = WebUI.findWebElements(findTestObject('Object Repository/Page_Swag Labs/checkout_item_price'),
	10)

//to do
//para cada item do carrinho, verifica se estão no checkout com o mesmo preço
//for (int i = 0; i < cartItemNameList.size(); i++) {
//
//	// Verifica os itens
//	WebUI.verifyMatch(checkoutItemNameList[i].getText(), cartItemNameList[i].getText(), false)
//    WebUI.verifyMatch(checkoutItemPriceList[i].getText(), cartItemPriceList[i].getText(), false)
//
//}
double totalitemPrice = 0.00

for (int i = 0; i < checkoutItemNameList.size(); i++) {
	double itemPrice = Double.parseDouble((checkoutItemPriceList[i]).getText().replaceAll('[^0-9.]', '') // Ensure only numbers
		)

	totalitemPrice += itemPrice
}

//verifica o preço total
String expectedTotalItemPriceText = 'Item total: $' + String.format(Locale.US, '%.2f', totalitemPrice)

WebUI.verifyElementText(findTestObject('Object Repository/Page_Swag Labs/summary_item_total'), expectedTotalItemPriceText)

double taxRate = tax

double expectedTax = Math.round((totalitemPrice * taxRate) * 100.0) / 100.0

String expectedTaxText = 'Tax: $' + String.format(Locale.US, '%.2f', expectedTax)

WebUI.verifyElementText(findTestObject('Object Repository/Page_Swag Labs/summary_tax_total'), expectedTaxText)

double expectedFinalTotal = totalitemPrice + expectedTax

String expectedTotalText = 'Total: $' + String.format(Locale.US, '%.2f', expectedFinalTotal)

WebUI.verifyElementText(findTestObject('Object Repository/Page_Swag Labs/summary_total'), expectedTotalText)

WebUI.click(findTestObject('Object Repository/Page_Swag Labs/button_Finish'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_Swag Labs/h2_Thank you for your order'), 'Thank you for your order!')

WebUI.click(findTestObject('Object Repository/Page_Swag Labs/button_Back Home'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_Swag Labs/div_Swag Labs'), 'Swag Labs')

WebUI.closeBrowser()