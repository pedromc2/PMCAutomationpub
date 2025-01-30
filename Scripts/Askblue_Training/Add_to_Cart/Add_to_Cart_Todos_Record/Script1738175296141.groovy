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

WebUI.callTestCase(findTestCase('Askblue_Training/Login_Logout/Login_Positivo'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Page_Swag Labs/button_Add to cart_0'))

WebUI.verifyElementText(findTestObject('Page_Swag Labs/icone_Carrinho'), '1')

WebUI.click(findTestObject('Page_Swag Labs/button_Add to cart_2'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_Swag Labs/icone_Carrinho'), '2')

WebUI.click(findTestObject('Object Repository/Page_Swag Labs/button_Add to cart_2'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_Swag Labs/icone_Carrinho'), '3')

WebUI.click(findTestObject('Object Repository/Page_Swag Labs/button_Add to cart_3'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_Swag Labs/icone_Carrinho'), '4')

WebUI.click(findTestObject('Object Repository/Page_Swag Labs/button_Add to cart_4'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_Swag Labs/icone_Carrinho'), '5')

WebUI.click(findTestObject('Object Repository/Page_Swag Labs/button_Add to cart_5'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_Swag Labs/icone_Carrinho'), '6')

WebUI.closeBrowser()

