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

WebUI.callTestCase(findTestCase('Askblue_Training/Add_to_Cart/Add_to_Cart_Todos_Record'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Page_Swag Labs/button_Checkout'))

WebUI.setText(findTestObject('Object Repository/Page_Swag Labs/input_Checkout Your Information_firstName'), 'João')

WebUI.setText(findTestObject('Object Repository/Page_Swag Labs/input_Checkout Your Information_lastName'), 'Silva')

WebUI.setText(findTestObject('Object Repository/Page_Swag Labs/input_Checkout Your Information_postalCode'), '1000-001')

WebUI.click(findTestObject('Object Repository/Page_Swag Labs/input_Cancel_continue'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_Swag Labs/div_Sauce Labs Backpack'), 'Sauce Labs Backpack')

WebUI.verifyElementText(findTestObject('Object Repository/Page_Swag Labs/div_29.99'), '$29.99')

WebUI.verifyElementText(findTestObject('Object Repository/Page_Swag Labs/div_Sauce Labs Bike Light'), 'Sauce Labs Bike Light')

WebUI.verifyElementText(findTestObject('Object Repository/Page_Swag Labs/div_9.99'), '$9.99')

WebUI.verifyElementText(findTestObject('Object Repository/Page_Swag Labs/div_Sauce Labs Bolt T-Shirt'), 'Sauce Labs Bolt T-Shirt')

WebUI.verifyElementText(findTestObject('Object Repository/Page_Swag Labs/div_15.99'), '$15.99')

WebUI.verifyElementText(findTestObject('Object Repository/Page_Swag Labs/div_Sauce Labs Fleece Jacket'), 'Sauce Labs Fleece Jacket')

WebUI.verifyElementText(findTestObject('Object Repository/Page_Swag Labs/div_49.99'), '$49.99')

WebUI.verifyElementText(findTestObject('Object Repository/Page_Swag Labs/div_Sauce Labs Onesie'), 'Sauce Labs Onesie')

WebUI.verifyElementText(findTestObject('Object Repository/Page_Swag Labs/div_7.99'), '$7.99')

WebUI.verifyElementText(findTestObject('Object Repository/Page_Swag Labs/div_Test.allTheThings() T-Shirt (Red)'), 'Test.allTheThings() T-Shirt (Red)')

WebUI.verifyElementText(findTestObject('Object Repository/Page_Swag Labs/div_15.99'), '$15.99')

WebUI.verifyElementText(findTestObject('Object Repository/Page_Swag Labs/div_Item total 129.94'), 'Item total: $129.94')

WebUI.verifyElementText(findTestObject('Object Repository/Page_Swag Labs/div_Tax 10.40'), 'Tax: $10.40')

WebUI.verifyElementText(findTestObject('Object Repository/Page_Swag Labs/div_Total 140.34'), 'Total: $140.34')

WebUI.click(findTestObject('Object Repository/Page_Swag Labs/button_Finish'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_Swag Labs/h2_Thank you for your order'), 'Thank you for your order!')

WebUI.click(findTestObject('Object Repository/Page_Swag Labs/button_Back Home'))

WebUI.closeBrowser()

