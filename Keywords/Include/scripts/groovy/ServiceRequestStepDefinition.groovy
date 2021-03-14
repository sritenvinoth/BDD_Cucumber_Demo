import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.util.concurrent.Delayed

import org.openqa.selenium.Keys

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class ServiceRequestStepDefinition {
	@Given("Customer Opens the browser and enters valid VP demo (.*)")
	public void customer_Opens_the_browser_and_enters_valid_VP_demo_URL(String URL) {
		WebUI.openBrowser('')

		WebUI.deleteAllCookies()

		WebUI.navigateToUrl(URL)

		WebUI.maximizeWindow()
	}

	@When("Customer enter valid (.*) and (.*)")
	public void customer_enter_valid_username_and_password(String username, String password) {
		WebUI.setText(findTestObject('Page_Sign/Input_UserName'), username)

		WebUI.click(findTestObject('Page_Sign/Btn_Next'))

		WebUI.setEncryptedText(findTestObject('Page_Sign/Input_Password'), password)

		WebUI.click(findTestObject('Page_Sign/Btn_SignIn'))
	}

	@When("Customer Clicks on the Login button")
	public void customer_Clicks_on_the_Login_button() {
		WebUI.click(findTestObject('Page_Sign/CB_DontShowMsg'))
		
		WebUI.click(findTestObject('Page_Sign/Btn_No'))
		
		print('Logged in')
	}

	@Then("Customer should be navigated to the Home Page")
	public void customer_should_be_navigated_to_the_Home_Page() {
		WebUI.waitForElementPresent(findTestObject('Page_RM Dashboard - Dynamics 365/Menu_Customer Search'), 0)
	}

	@Given("Customer in to the home page of VP demo application")
	public void customer_in_to_the_home_page_of_VP_demo_application() {
		//WebUI.click(findTestObject('Page_Apps - Dynamics 365/App_VeriTouch'))
		
		WebUI.delay(5)
		
		//WebUI.switchToDefaultContent()
	}

	@When("Customer click on the Customer search")
	public void customer_click_on_the_Customer_search() {
		WebUI.click(findTestObject('Page_RM Dashboard - Dynamics 365/Menu_Customer Search'))
		
		WebUI.delay(7)
	}

	@When("Enters the Customer Name as (.*) and clicks the Search button")
	public void enters_the_Customer_Name_and_clicks_the_Search_button(String customerName) {
		WebUI.clearText(findTestObject('Page_Customer Search/input_Customer Name'))
		
		WebUI.sendKeys(findTestObject('Page_Customer Search/input_Customer Name'), Keys.chord(customerName, Keys.TAB))
		
		WebUI.scrollToElement(findTestObject('Page_Customer Search/Label_Passport_No'), 0)
		
		WebUI.delay(2)
		
		WebUI.scrollToElement(findTestObject('Page_Customer Search/Label_IDCardNo'), 0)
		
		WebUI.delay(2)
		
		WebUI.scrollToElement(findTestObject('Page_Customer Search/Label_CustomerGrid'), 0)
		
		WebUI.delay(3)
		
		WebUI.click(findTestObject('Page_Customer Search/Btn_Search'))
		
		WebUI.delay(3)
		
		WebUI.switchToDefaultContent()
	}

	@Then("Search result should be displayed with the given customer")
	public void search_result_should_be_displayed_with_the_given_customer() {
		WebUI.waitForElementPresent(findTestObject('Page_Customer Search/Click_Customer_From_Result'), 0)
		WebUI.click(findTestObject('Page_Customer Search/Click_Customer_From_Result'))
		
		WebUI.delay(5)
		
		WebUI.switchToDefaultContent()
	}

	@Given("Customer in to new service request page")
	public void select_the_customer_from_customer_search_result() {
		//WebUI.waitForElementVisible(findTestObject('Thomas_Page/Menu_New Service Request'), 0)
		WebUI.delay(3)
	}

	@When("Customer selects the New Service request")
	public void customer_selects_the_New_Service_request() {
		
		WebUI.click(findTestObject('Thomas_Page/Menu_New Service Request'))
		
		WebUI.delay(5)
	}
	
	@When("Click on the subject drop down from Case Details")
	public void click_on_the_subject_drop_down_from_Case_Details() {
		WebUI.click(findTestObject('Case_Details/Click_Subject_DD'))
		
		WebUI.delay(3)

	}

	@When("Select the value as Cheque book request under Retail service requests--> Accounts--> Cheque book request")
	public void select_the_value_as_Cheque_book_request_under_Retail_service_requests_Accounts_Cheque_book_request() {
		
		WebUI.scrollToElement(findTestObject('Case_Details/Arrow_RetailSR'), 0)
		
		WebUI.click(findTestObject('Case_Details/Arrow_RetailSR'))
		
		WebUI.click(findTestObject('Case_Details/Arrow_Accounts'))
		
		WebUI.click(findTestObject('Case_Details/Select_ChequeBookRequest'))
		
		WebUI.delay(2)
		}

	@When("Select the value from Cheque book delivery drop down and select the Cheque book leaves")
	public void select_the_value_from_Cheque_book_delivery_drop_down_and_select_the_Cheque_book_leaves_as() {
		WebUI.scrollToElement(findTestObject('Case_Details/Click_ChqueBookDelivery'), 0)
		
		WebUI.click(findTestObject('Case_Details/Click_ChqueBookDelivery'))
		
		WebUI.sendKeys(findTestObject('Case_Details/Click_ChqueBookDelivery'), Keys.chord('Mailing Address', Keys.TAB))
		
		WebUI.delay(2)
		
		WebUI.click(findTestObject('Case_Details/Click_ChequeBookLeaves'))
		
		WebUI.sendKeys(findTestObject('Case_Details/Click_ChequeBookLeaves'), Keys.chord('25', Keys.TAB))
		
		WebUI.delay(2)
		}

	@When("Click on the Ingenius link on the top right corner to validate the track number as --")
	public void click_on_the_Ingenius_link_on_the_top_right_corner_to_validate_the_track_number_as() {
		WebUI.click(findTestObject('Case_Details/Lbl_InGenius'))
		
		WebUI.verifyElementPresent(findTestObject('Case_Details/Lbl_BeforeTrackingNo'), 0)
		}

	@When("Click the Save button")
	public void click_the_Save_button() {
		WebUI.click(findTestObject('Case_Details/Btn_Save'))
	}

	@Then("Click on the Administration page and validat the Tracking number and status")
	public void click_on_the_Administration_page_and_validat_the_Tracking_number_and_status() {
		WebUI.waitForElementVisible(findTestObject('Case_Details/Tab_Administration'), 0)
		
		WebUI.click(findTestObject('Case_Details/Tab_Administration'))
		
		WebUI.verifyElementPresent(findTestObject('Case_Details/Lbl_StatusReason'), 0)
		
		String trackingNumber = WebUI.getText(findTestObject('Case_Details/Lbl_TrackingNo'))
		
		print(trackingNumber)
		
		//CustomKeywords.'RegEx.onlyDigits'(trackingNumber)
		}

	@Given("when customer raise the cheque book request")
	public void when_customer_raise_the_cheque_book_request() {
		WebUI.waitForElementPresent(findTestObject('Page_SignOut/Menu_Profile'), 0)
	}

	@When("Click on the Profile button and Click the Signout")
	public void click_on_the_Profile_button_and_Click_the_Signout() {
		WebUI.click(findTestObject('Page_SignOut/Menu_Profile'))
		
		WebUI.click(findTestObject('Page_SignOut/Btn_SignOut'))
		
		WebUI.waitForElementVisible(findTestObject('Page_SignOut/Btn_AccountSelection'), 0)
		WebUI.click(findTestObject('Page_SignOut/Btn_AccountSelection'))
		WebUI.waitForElementVisible(findTestObject('Page_SignOut/Btn_Forget'),0)
		
		WebUI.click(findTestObject('Page_SignOut/Btn_Forget'))
	}

	@Then("Close the browser")
	public void close_the_browser() {
		WebUI.closeBrowser()
	}
}