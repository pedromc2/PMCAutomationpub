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
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType
import org.openqa.selenium.WebElement as WebElement

WebUI.callTestCase(findTestCase('Askblue_Training/Login_Logout/Login_Positivo'), [:], FailureHandling.STOP_ON_FAILURE)
WebUI.verifyElementText(findTestObject('Page_Swag Labs/icone_carrinho'), '')

TestObject addToCart = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//button[text()='Add to cart']")
List addToCartList = WebUI.findWebElements(addToCart, 10)
TestObject itemNames = findTestObject('Object Repository/Page_Swag Labs/item_name')
List itemNameList = WebUI.findWebElements(itemNames, 10)
TestObject itemPrices = findTestObject('Object Repository/Page_Swag Labs/item_price')
List itemPriceList = WebUI.findWebElements(itemPrices, 10)

// Store items added to cart
Set<String> addedItems = new HashSet<>()

//gera um número aleatorio entre 2 e o numero de itens da lista -1
int v = new Random().nextInt(addToCartList.size() - 2) + 2

//para o número de voltas v
for (int i = 0; i < v; i++) {


	List<WebElement> availableItems = WebUI.findWebElements(findTestObject('Object Repository/Page_Swag Labs/item_name'), 10)
	List<WebElement> availablePrices = WebUI.findWebElements(findTestObject('Object Repository/Page_Swag Labs/item_price'), 10)
	List<WebElement> availableButtons = WebUI.findWebElements(findTestObject('Object Repository/Page_Swag Labs/button_add_to_cart'), 10)

	List<Integer> validIndexes = []
	for (int j = 0; j < availableItems.size(); j++) {
		if (!addedItems.contains(availableItems[j].getText())) {
			validIndexes.add(j)
		}
	}
	
	if (validIndexes.isEmpty()) {
		break
	}
	
	// Pick a random item from the available ones
	int randomIndex = validIndexes.get(new Random().nextInt(validIndexes.size()))
	
	// Get name and price of selected item
	String name = availableItems[randomIndex].getText()
	String price = availablePrices[randomIndex].getText()

	// Click 'Add to Cart' button for the selected item
	availableButtons[randomIndex].click()
	
	// Verify cart icon count update
	WebUI.delay(1)
	WebUI.verifyElementText(findTestObject('Object Repository/Page_Swag Labs/icone_carrinho'), (i + 1).toString())

	// Open the cart
	WebUI.click(findTestObject('Object Repository/Page_Swag Labs/icone_carrinho'))
	WebUI.delay(1)

	// Get cart items and verify item is in cart
	List<WebElement> cartItemNameList = WebUI.findWebElements(findTestObject('Object Repository/Page_Swag Labs/cart_item_name'), 10)
	List<WebElement> cartItemPriceList = WebUI.findWebElements(findTestObject('Object Repository/Page_Swag Labs/cart_item_price'), 10)

	WebUI.verifyMatch(cartItemNameList[i].getText(), name, false)
	WebUI.verifyMatch(cartItemPriceList[i].getText(), price, false)

	// Add to the set of items added to the cart
	addedItems.add(name)

	// Go back to homepage
	WebUI.click(findTestObject('Object Repository/Page_Swag Labs/button_Continue Shopping'))
	
}



