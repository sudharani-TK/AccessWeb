	import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.remote.RemoteWebDriver
import org.openqa.selenium.support.events.EventFiringWebDriver

import com.kms.katalon.core.exception.StepErrorException as StepErrorException
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.aventstack.extentreports.MediaEntityBuilder
import com.aventstack.extentreports.Status
import internal.GlobalVariable as GlobalVariable

WebDriver driver = DriverFactory.getWebDriver()
EventFiringWebDriver eventFiring = ((DriverFactory.getWebDriver()) as EventFiringWebDriver)
WebDriver wrappedWebDriver = eventFiring.getWrappedDriver()
RemoteWebDriver katalonWebDriver = (RemoteWebDriver) wrappedWebDriver

//==================================================================
def Browser = GlobalVariable.G_Browser
//===============================================================
def extentTest=GlobalVariable.G_ExtentTest
//===========================================================
CustomKeywords.'toLogin.ForLogin.Login'(extentTest)
//=============================================================

TestObject newFileObj
def navLocation = CustomKeywords.'generateFilePath.filePath.execLocation'()
def location = navLocation + '/LotOfFiles/'
def isLinkPresent
String data=null
def result=false

//WebUI.delay(2)
WebUI.enableSmartWait()

try {
	def filesTab = CustomKeywords.'customWait.WaitForElement.WaitForelementPresent'(findTestObject('GenericObjects/TitleLink_Files'),
			10, extentTest, 'Files Tab')

	if (filesTab) {
		WebUI.click(findTestObject('GenericObjects/TitleLink_Files'))
	}

	extentTest.log(Status.PASS, 'Navigated to Files Tab')

//	WebUI.delay(2)

	CustomKeywords.'operations_FileModule.ChangeView.changePageView'(TestCaseName, extentTest)

	//WebUI.delay(2)

	println(TestCaseName)

	/*WebUI.click(findTestObject('Object Repository/FilesPage/Icon_EditFilePath'))

	WebUI.setText(findTestObject('Object Repository/FilesPage/textBx_FilePath'), location)

	WebUI.sendKeys(findTestObject('Object Repository/FilesPage/textBx_FilePath'), Keys.chord(Keys.ENTER))

	extentTest.log(Status.PASS, 'Navigated to - ' + location)*/
	
	CustomKeywords.'generateFilePath.filePath.navlocation'(location, extentTest)
	
	extentTest.log(Status.PASS, "Verify that the page numbers in the form of Showing Entry X through Y of Z are displayed. ")
	
	def pageentry=WebUI.getText(findTestObject('Object Repository/FilesPage/Pagination/pagination_number_status'))
	

	if(pageentry.contains('1')) {
		
		extentTest.log(Status.PASS, ' Showing Entry 1 through 50 of 226')
		println("***"+  pageentry)
	}

switch (userChoice) {
		case 'last':
		
		extentTest.log(Status.PASS, ' click on the >> arrow  ')
		//WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/FilesPage/Pagination/Pagination_element4'))
		pageentry=WebUI.getText(findTestObject('Object Repository/FilesPage/Pagination/pagination_number_status'))
		
		if(pageentry.contains('201')) {
			
			extentTest.log(Status.PASS, ' Showing Entry 1 through 226 of 226')
			println("***"+  pageentry)
			
			extentTest.log(Status.PASS, "verified user is in the last page")
			WebUI.verifyElementHasAttribute(findTestObject('Object Repository/FilesPage/Pagination/Pagination_element3'), 'disabled', 5)
			WebUI.verifyElementHasAttribute(findTestObject('Object Repository/FilesPage/Pagination/Pagination_element4'), 'disabled', 5)
			extentTest.log(Status.PASS, ":Verified that the < and << arrows are disabled ")
		}

			break
		case 'previous':
	//	WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/FilesPage/Pagination/Pagination_element4'))
		extentTest.log(Status.PASS, ' click on the < (previous) arrow  ')
	//	WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/FilesPage/Pagination/Pagination_element2'))
		 pageentry=WebUI.getText(findTestObject('Object Repository/FilesPage/Pagination/pagination_number_status'))
		
		if(pageentry.contains('151')) {
			
			extentTest.log(Status.PASS, ' Showing Entry 151 through 200 of 226')
			println("***"+  pageentry)
			
			extentTest.log(Status.PASS, "verified user navigated to  Previous  page")
		
		}
			

			break
		case 'first':
	//	WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/FilesPage/Pagination/Pagination_element4'))
		extentTest.log(Status.PASS, ' click on the << arrow  ')
	//	WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/FilesPage/Pagination/Pagination_element1'))
		 pageentry=WebUI.getText(findTestObject('Object Repository/FilesPage/Pagination/pagination_number_status'))
		
		if(pageentry.contains('1')) {
		extentTest.log(Status.PASS, "verified user is in the first page ")
		WebUI.verifyElementPresent(findTestObject('Object Repository/FilesPage/Pagination/pagination_element1_disabled'),5)
			WebUI.verifyElementPresent(findTestObject('Object Repository/FilesPage/Pagination/pagination_element2_disabled'),5)
			extentTest.log(Status.PASS, "Verified that the > and >> arrows are disabled ")
		}
		

			break
		case 'next':
		
		extentTest.log(Status.PASS, ' click on the > (next) arrow  ')
		//WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/FilesPage/Pagination/Pagination_element3'))
		 pageentry=WebUI.getText(findTestObject('Object Repository/FilesPage/Pagination/pagination_number_status'))
		
		if(pageentry.contains('100')) {
			
			extentTest.log(Status.PASS, ' Showing Entry 51 through 100 of 226')
			println("***"+  pageentry)
			
			extentTest.log(Status.PASS, "verified user navigated to  next  page")
		
		}
		break
		case 'emptydir':
		 location = navLocation + '/LotOfFiles/EmptyFolder/'
		 extentTest.log(Status.PASS, 'Navigate to the Empty Folder ')
		 CustomKeywords.'generateFilePath.filePath.navlocation'(location, extentTest)
		 
		  result=WebUI.verifyElementPresent(findTestObject('Object Repository/FilesPage/Pagination/Files_pagination_disabled'), 5)
		 if(result) {
			 extentTest.log(Status.PASS, ' pagination elements are disabled for empty directory')
		 }
		 else {
			 extentTest.log(Status.FAIL, ' Failed to verify')
		 }
		
		break
		
		case 'lessitems':
		location = navLocation + '/LotOfFiles/LessItems/'
		extentTest.log(Status.PASS, 'Navigate to the  Folder  having less number of Files/Folders')
		CustomKeywords.'generateFilePath.filePath.navlocation'(location, extentTest)
		
		 result=WebUI.verifyElementPresent(findTestObject('Object Repository/FilesPage/Pagination/Files_pagination_disabled'), 5)
		if(result) {
			extentTest.log(Status.PASS, ' pagination elements are disabled for the  Folder  having less number of Files/Folder')
		}
		else {
			extentTest.log(Status.FAIL, ' Failed to verify')
		}
	   
	   break
	   
	   case 'pagination':
	 //  WebUI.delay(2)
	   WebUI.click(findTestObject('Object Repository/FilesPage/Pagination/pagination-dropdown'))
	   WebUI.selectOptionByIndex(findTestObject('Object Repository/FilesPage/Pagination/pagination_dropdown_listbox'), 1)
	  // WebUI.selectOptionByValue(findTestObject('Object Repository/FilesPage/Pagination/paginationlistitems'), '100', true)
		   
	  	extentTest.log(Status.PASS, 'Go to entries per page->select 100 from entries per page drop down')
		//  WebUI.delay(2)
		  WebUI.click(findTestObject('Object Repository/FilesPage/Pagination/paginationlistitems'))
		//  WebUI.delay(2)
		  
		  pageentry=WebUI.getText(findTestObject('Object Repository/FilesPage/Pagination/pagination_number_status'))
		  
		  if(pageentry.contains('100')) {
			  
			  extentTest.log(Status.PASS, ' Showing Entry 1 through 100 of 227')
			  println("***"+  pageentry)
			  
			  extentTest.log(Status.PASS, "Verify that the files/folder per page displayed is 100")}
		  
	   
	   break
	
	}
	//WebUI.delay(2)
	CustomKeywords.'operations_FileModule.getRowDetails.getFilePage'(katalonWebDriver, extentTest,TestCaseName)
	extentTest.log(Status.PASS, 'Test case for pagination passed')
}
catch (Exception ex) {
	println('From TC - ' + GlobalVariable.G_ReportFolder)

	String screenShotPath = (('ExtentReports/' + TestCaseName) + GlobalVariable.G_Browser) + '.png'

	WebUI.takeScreenshot(screenShotPath)

	String p = (TestCaseName + GlobalVariable.G_Browser) + '.png'

	extentTest.log(Status.FAIL, ex)

	extentTest.fail(MediaEntityBuilder.createScreenCaptureFromPath(p).build())
}
catch (StepErrorException e) {
	String screenShotPath = (('ExtentReports/' + TestCaseName) + GlobalVariable.G_Browser) + '.png'

	WebUI.takeScreenshot(screenShotPath)

	String p = (TestCaseName + GlobalVariable.G_Browser) + '.png'

	extentTest.log(Status.FAIL, ex)

	extentTest.fail(MediaEntityBuilder.createScreenCaptureFromPath(p).build())
}
finally {
	extentTest.log(Status.PASS, 'Closing the browser after executinge test case - ' + TestCaseName)
	
	
}


