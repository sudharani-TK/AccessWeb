import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.support.events.EventFiringWebDriver as EventFiringWebDriver
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.Capabilities
import org.openqa.selenium.remote.RemoteWebDriver
import com.kms.katalon.core.exception.StepErrorException as StepErrorException
import com.kms.katalon.core.util.KeywordUtil
import com.aventstack.extentreports.MediaEntityBuilder
import com.aventstack.extentreports.Status

//==================================================================
def Browser = GlobalVariable.G_Browser
//===============================================================
def extentTest=GlobalVariable.G_ExtentTest
//===========================================================
CustomKeywords.'toLogin.ForLogin.Login'(extentTest)
//=============================================================

TestObject newFileObj=null

//def navLocation = CustomKeywords.'generateFilePath.filePath.execLocation'()
//def location = navLocation + '/FilesModule/FileOps/'
def userChoice=null
def jobState = 'Running'
def AppName="ShellScript"



try {
	
	switch (UserChoice) {
	
		case 'FileUpload':
		           
		
		      WebUI.click(findTestObject('GenericObjects/TitleLink_Files'))
			  extentTest.log(Status.PASS, 'Navigated to Files Tab')
			  WebUI.delay(2)
			  
			  extentTest.log(Status.PASS, 'Click on the upload button in the Files tab')
			  WebUI.click(findTestObject('Object Repository/FilesPage/Upload_button_dropdown'))
			  extentTest.log(Status.PASS,'    AD-5036---Upload File/Folder options in Files Section - verify that two options are available for upload file and folder separately')
			  def value1=WebUI.waitForElementVisible(findTestObject('Object Repository/FilesPage/Uploadbtn_Folder'),10)
			  def value2=WebUI.waitForElementVisible(findTestObject('Object Repository/FilesPage/Uploadbtn_File'),10)
			  if(value1&&value2) {
				  extentTest.log(Status.PASS," user is able to view two options when user clicks on upload button- Folder and File")
			  }
			  else {
				  
				  extentTest.log(Status.PASS, 'Failed to verify the options')
			  }
			 
			 if (TestCaseName.contains('Tile View')) {
					WebUI.delay(2)

					TestObject viewIconTile = WebUI.modifyObjectProperty(findTestObject('Object Repository/FilesPage/Icon_ViewIcon'), 'title',
							'equals', 'Tile View', true)
					extentTest.log(Status.PASS, 'Changed the View to Tile View')
					def viewIconTilePresent=WebUI.waitForElementPresent(viewIconTile, 3, FailureHandling.CONTINUE_ON_FAILURE)

					if(viewIconTilePresent) {
						WebUI.click(viewIconTile)
						WebUI.delay(2)
					} 
			  } 
			  
			  CustomKeywords.'toupload.Forupload.UploadFolder'(extentTest, InputFolder, UserChoice,TestCaseName)
			  
			  break
			  
			  
		case 'JSUpload':
		
		      WebUI.click(findTestObject('GenericObjects/TitleLink_Jobs'))
		      extentTest.log(Status.PASS, 'Clicked on Jobs Tab')
			  WebUI.delay(2)
			  
				  TestObject newAppObj = WebUI.modifyObjectProperty(findTestObject('LoginPage/NewJobPage/AppList_ShellScript'), 'id', 'equals',AppName, true)
				  WebUI.click(newAppObj)
				  extentTest.log(Status.PASS, 'Navigated to Job Submission For for - ' + AppName)
				  WebUI.delay(2)
				  
				  extentTest.log(Status.PASS, 'Click upload button present in JSF - Files section')
				  WebUI.click(findTestObject('Object Repository/FilesPage/Upload_button_dropdown'))
				  extentTest.log(Status.PASS,'    AD-5036---Upload File/Folder options in Jobs  Section - verify that two options are available for upload file and folder separately')
				  def value1=WebUI.waitForElementVisible(findTestObject('Object Repository/FilesPage/Uploadbtn_Folder'),10)
				  def value2=WebUI.waitForElementVisible(findTestObject('Object Repository/FilesPage/Uploadbtn_File'),10)
				  if(value1&&value2) {
					  extentTest.log(Status.PASS," user is able to view two options when user clicks on upload button- Folder and File")
				  }
				  else {
					  
					  extentTest.log(Status.PASS, 'Failed to verify the options')
				  }
			  
				  def errorPanel = CustomKeywords.'customWait.WaitForElement.WaitForelementPresent'(findTestObject('JobSubmissionForm/JS_ErrorModalPanel'),
						  3, extentTest, 'Error Panel Close Icon')
				  if (errorPanel) {
					  WebUI.click(findTestObject('Object Repository/JobSubmissionForm/button_Close'))
				  }
				  WebUI.click(findTestObject('Object Repository/LoginPage/NewJobPage/GenericProfile'))
				  WebUI.delay(2)
				  CustomKeywords.'toupload.Forupload.UploadFolder'(extentTest, InputFolder,UserChoice,TestCaseName)
				  break
		
		 case 'RunningFolder':
		 
		 
		 
		 WebUI.click(findTestObject('GenericObjects/TitleLink_Jobs'))
		 extentTest.log(Status.PASS, 'Click on Jobs tab')
		 WebUI.delay(2)
		 WebUI.click(findTestObject('Object Repository/JobMonitoringPage/a_Reset'))
		 extentTest.log(Status.PASS, 'Click on reset')
		 
		 TestObject newJobFilter = WebUI.modifyObjectProperty(findTestObject('JobMonitoringPage/label_jobState'), 'text', 'equals',
				 jobState, true)
		 
		 WebUI.click(newJobFilter)
		 
		 WebUI.delay(2)
		 extentTest.log(Status.PASS, 'Clicked on job with state  - ' + jobState)
		 
		 println jobState
		 TestObject newJobRow = WebUI.modifyObjectProperty(findTestObject('JobMonitoringPage/div_Completed'), 'title', 'equals',jobState, true)
			 WebUI.rightClick(newJobRow)
			 
			 
		 
		 WebUI.click(findTestObject('JobMonitoringPage/ViewDetails_Jobs'))
		 
		 
		 //WebUI.waitForElementVisible(findTestObject('JobMonitoringPage/OutputFolder_File'), 5)
		 //WebUI.click(findTestObject('JobMonitoringPage/OutputFolder_File'))
		 WebUI.click(findTestObject('JobMonitoringPage/RunningFolder'))
		 extentTest.log(Status.PASS, 'Click on Running Folder') 
		 
		     
		 
		 if (TestCaseName.contains('context'))
		 {
			 extentTest.log(Status.PASS, 'Right click for context menu options > Click upload folder option')
			 TestObject Foldername = WebUI.modifyObjectProperty(findTestObject('JobSubmissionForm/File_InputFile'), 'data-automation-id', 'equals',"runtime", true)
			 WebUI.rightClick(Foldername)
		
		 }
		 
		 else {
			 extentTest.log(Status.PASS, 'Click upload button present in running folder tab')
			 WebUI.waitForElementVisible(findTestObject('Object Repository/JobDetailsPage/upload_button_Runningtab'),10)
		   WebUI.click(findTestObject('Object Repository/JobDetailsPage/upload_button_Runningtab'))
		   
		   extentTest.log(Status.PASS,'    AD-5036---Upload File/Folder options in Running Folder tab  Section - verify that two options are available for upload file and folder separately')
			 
		 
		 

			 def value1=WebUI.waitForElementVisible(findTestObject('Object Repository/JobDetailsPage/uploadbtn_File_Runningtab'),10)
			 def value2=WebUI.waitForElementVisible(findTestObject('Object Repository/JobDetailsPage/uploadbtn_Folder_Runningtab'),10)
			 if(value1&&value2) {
				 extentTest.log(Status.PASS," user is able to view two options when user clicks on upload button- Folder and File")
			 }
			 else {
				 
				 extentTest.log(Status.FAIL, 'Failed to verify the options')
			 }
		 }
	
		 WebUI.delay(2)
		 CustomKeywords.'toupload.Forupload.UploadFolder'(extentTest, InputFolder, UserChoice,TestCaseName)
		
	}
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



