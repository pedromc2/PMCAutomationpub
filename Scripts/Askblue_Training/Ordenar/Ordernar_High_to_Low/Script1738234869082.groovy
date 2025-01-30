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

//obtem lista de preços
TestObject itemPrices = findTestObject('Object Repository/Page_Swag Labs/item_price')
List itemPriceList = WebUI.findWebElements(itemPrices, 10)

//guarda o preço mais alto
List<Double> prices = itemPriceList.collect { it.getText().replace('$', '').toDouble() }
double maxPrice = prices.max()

//reordena os preços e aguarda que a página refresque
WebUI.click(findTestObject('Object Repository/Page_Swag Labs/span_Name (A to Z)Name (A to Z)Name (Z to A_3f2346'))
WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Swag Labs/select_Name (A to Z)Name (Z to A)Price (low_f7e90a'), 
    'hilo', true)
WebUI.delay(2)

//obtem lista de preços reordenada e o primeiro preço
List<WebElement> sortedPrices = WebUI.findWebElements(itemPrices, 10)
String firstPriceText = sortedPrices[0].getText().replace('$', '').toDouble()

//compara o primeiro preço após reordenação com o preço máximo da lista inicial
WebUI.verifyEqual(firstPriceText, maxPrice)
