package toLogin

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.aventstack.extentreports.Status

import internal.GlobalVariable

public class ForLogin {

	@Keyword
	def Login(extentTest) {

		def Browser = GlobalVariable.G_Browser
		//extentTest.log(Status.PASS, 'Navigated to Acces Instance - '+GlobalVariable.G_BaseUrl)


		if (Browser == 'Edge Chromium') {
			WebUI.click(findTestObject('Object Repository/GenericObjects/EdgeChromium_Details_link'))
			WebUI.delay(3)
			WebUI.click(findTestObject('Object Repository/GenericObjects/EdgeChromium_proceed_link'))
			WebUI.delay(3)
			WebUI.deleteAllCookies()
		}

		WebUI.setText(findTestObject('LoginPage/username_txtbx'), GlobalVariable.G_userName)
		WebUI.setText(findTestObject('LoginPage/password_txtbx'), GlobalVariable.G_Password)
		WebUI.click(findTestObject('LoginPage/login_btn'))
		extentTest.log(Status.PASS, 'Entered Creds - username - '+GlobalVariable.G_userName +' password - '+GlobalVariable.G_Password)

		extentTest.log(Status.PASS, 'Clicked on Login Button ')


		//def jobsTab = (new customWait.WaitForElement()).WaitForelementPresent(findTestObject('LoginPage/NewJobPage/AppList_ShellScript'),	10,extentTest, 'Application - ShellScript loaded ')

		//if (jobsTab) {
		WebUI.click(findTestObject('Object Repository/Landing_Page/LandigPage_AltairAccess_Link'))
		//}

		extentTest.log(Status.PASS, 'Verified AltairAccess Logo post login ')
	}
}
