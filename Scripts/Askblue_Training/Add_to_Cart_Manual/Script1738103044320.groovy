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

WebUI.callTestCase(findTestCase('Askblue_Training/Login_Positivo'), [('username') : 'standard_user', ('password') : 'secret_sauce'], 
    FailureHandling.STOP_ON_FAILURE)

// escolher um item
// obter o nome do item
// obter o preço do item
// adicionar ao carrinho
// verificar incremento do icone de carrinho
// aceder ao carrinho
// verificar que o item correto está presente, descrição correta e preço correto

// Get the list of all "Add to Cart" buttons
List<TestObject> addToCartButtons = []

// Dynamically locate all "Add to Cart" buttons using XPath
for (int i = 1; i <= 6; i++) { // Assuming there are 6 products displayed on the page
	TestObject button = new TestObject("addToCartButton_" + i)
	button.addProperty("xpath", com.kms.katalon.core.testobject.ConditionType.EQUALS, "(//button[contains(text(),'add-to-cart')])[" + i + "]")
	addToCartButtons.add(button)
}

System.out.println(addToCartButtons)

WebUI.click(findTestObject(addToCartButton_1))