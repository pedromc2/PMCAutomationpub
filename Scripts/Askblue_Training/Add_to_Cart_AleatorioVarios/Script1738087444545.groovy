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

WebUI.callTestCase(findTestCase('Askblue_Training/Login_Positivo'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Page_Swag Labs/icone_Carrinho'), '')

List listaAddToCart = Arrays.asList('Object Repository/Page_Swag Labs/button_Add to cart_0', 'Object Repository/Page_Swag Labs/button_Add to cart_1', 
    'Object Repository/Page_Swag Labs/button_Add to cart_2', 'Object Repository/Page_Swag Labs/button_Add to cart_3', 'Object Repository/Page_Swag Labs/button_Add to cart_4', 
    'Object Repository/Page_Swag Labs/button_Add to cart_5')

//Número aleatório entre 2 e 5
int i = new Random().nextInt(listaAddToCart.size() - 2) + 2

listaAddToCart.shuffle()

def selectedItems = listaAddToCart.subList(0, i)

for (def index : (0..i-1)) {

//	System.out.println(index)
//	System.out.println(i)
	
    WebUI.click(findTestObject(selectedItems[index]))
    WebUI.verifyElementText(findTestObject('Page_Swag Labs/icone_Carrinho'), (index + 1).toString())
}