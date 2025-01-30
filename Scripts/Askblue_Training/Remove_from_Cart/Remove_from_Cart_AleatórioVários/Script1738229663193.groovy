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

WebUI.callTestCase(findTestCase('Askblue_Training/Add_to_Cart/Add_to_Cart_AleatorioVarios'), [:], FailureHandling.STOP_ON_FAILURE)

//obtem a lista de botões remove
TestObject remove = findTestObject('Object Repository/Page_Swag Labs/button_remove')
List removeList = WebUI.findWebElements(remove, 10)

//gera um número aleatorio entre 1 e o numero de itens da lista -1
int v = new Random().nextInt(removeList.size() - 2) + 1

for (int i = 0; i < v; i++) {
	
	// Atualiza a lista após cada remoção
	removeList = WebUI.findWebElements(remove, 10)
	
	// Verifica se a lista ainda tem elementos antes de prosseguir
	if (removeList.isEmpty()) {
		break
	}
	
	//gera um numero aleatório entre 0 e o número de itens
	Random rand = new Random()
	int r = rand.nextInt(removeList.size())
	//clica no botão remove do item aleatorio
	removeList.get(r).click()
	// Aguarda um tempo curto para permitir a atualização da página
	WebUI.delay(1)

	// Obtém o texto atual do ícone do carrinho
	String cartIconText = WebUI.getText(findTestObject('Object Repository/Page_Swag Labs/icone_carrinho')).trim()
	
	   // Calcula a contagem esperada após a remoção
    int expectedCount = removeList.size() - 1
    
	// Verifica se o carrinho está vazio ou tem o número correto de itens
    if (expectedCount == 0) {
        WebUI.verifyMatch(cartIconText, "", false) // Ícone do carrinho vazio
    } else {
        WebUI.verifyMatch(cartIconText, expectedCount.toString(), false)
    }
		
}
