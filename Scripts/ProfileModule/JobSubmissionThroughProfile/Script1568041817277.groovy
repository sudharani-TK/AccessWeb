import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.Keys as Keys

import com.kms.katalon.core.exception.StepErrorException as StepErrorException
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.aventstack.extentreports.Status
import com.aventstack.extentreports.MediaEntityBuilder

import internal.GlobalVariable as GlobalVariable

//====================================================================================
def Browser = GlobalVariable.G_Browser
//===============================================================
def extentTest=GlobalVariable.G_ExtentTest
//===============================================================
CustomKeywords.'toLogin.ForLogin.Login'(extentTest)
//=====================================================================================
def navLocation = CustomKeywords.'generateFilePath.filePath.execLocation'()
def location = navLocation + '/ForProfiles/InputDeck/'
//=====================================================================================

//WebUI.delay(2)

WebUI.enableSmartWait()
try {
	//WebUI.delay(2)
	//def jobsTab = CustomKeywords.'customWait.WaitForElement.WaitForelementPresent'(findTestObject('GenericObjects/JobsTab_disabled'),
			//20,extentTest,'Jobs Tab')
	//if (jobsTab) {
		WebUI.click(findTestObject('GenericObjects/TitleLink_Jobs'))
	//}

	//WebUI.delay(2)
	TestObject newAppObj = WebUI.modifyObjectProperty(findTestObject('LoginPage/NewJobPage/AppList_ShellScript'), 'id', 'equals', AppName, true)
	WebUI.click(newAppObj)
	extentTest.log(Status.PASS, 'Navigated to Job Submission For for - '+AppName)
	/*def errorPanel = CustomKeywords.'customWait.WaitForElement.WaitForelementPresent'(findTestObject('JobSubmissionForm/JS_ErrorModalPanel'),
			3,extentTest,'ErrorPanel')
	if (errorPanel) {
		WebUI.click(findTestObject('Object Repository/JobSubmissionForm/button_Close'))
	}*/

	//WebUI.delay(2)
	extentTest.log(Status.PASS, 'Switched to Generic Profile')
	WebUI.click(findTestObject('Object Repository/LoginPage/NewJobPage/GenericProfile'))
	//WebUI.delay(2)
	TestObject LeftNavAppIdentifier = CustomKeywords.'buildTestObj.CreateTestObjJobs.myLeftNavAppIdentifier'(proName)
	WebUI.disableSmartWait()
	
	
	WebUI.waitForElementPresent(LeftNavAppIdentifier, 5)
	WebUI.click(LeftNavAppIdentifier)
	extentTest.log(Status.PASS, 'Switched to Profile - '+proName)


	TestObject JobFileIdentifier = CustomKeywords.'buildTestObj.CreateJobSubmissionObjs.myJobFile'(fileName)
	def isFilePresent=WebUI.verifyElementPresent(JobFileIdentifier, 3,FailureHandling.CONTINUE_ON_FAILURE)
	if (isFilePresent)
	{
		extentTest.log(Status.PASS, 'Job file for Profile Present -  '+fileName)
	}
	else
	{
		extentTest.log(Status.PASS, 'Profiles does not have files added')
		
		WebUI.enableSmartWait()
		CustomKeywords.'generateFilePath.filePath.navlocation'(location, extentTest)
		extentTest.log(Status.PASS, 'Navigated to '+location+' in RFB ')
		//WebUI.delay(3)
		WebUI.waitForElementPresent(findTestObject('Object Repository/JobSubmissionForm/textBx_file_filter'), 5)
		WebUI.click(findTestObject('Object Repository/JobSubmissionForm/textBx_file_filter'))
		WebUI.setText(findTestObject('Object Repository/JobSubmissionForm/textBx_file_filter'), fileName)
		WebUI.sendKeys(findTestObject('JobSubmissionForm/textBx_file_filter'), Keys.chord(Keys.ENTER))
		//WebUI.delay(3)
		TestObject newFileObj = WebUI.modifyObjectProperty(findTestObject('JobSubmissionForm/File_InputFile'), 'data-automation-id', 'equals',
				fileName, true)
		//WebUI.click(newFileObj)
		WebUI.rightClick(newFileObj)
		//WebUI.delay(2)
		String idForCntxtMn="Add as "+FileArg
		TestObject newRFBContextMnOption = WebUI.modifyObjectProperty(findTestObject('Object Repository/LoginPage/NewJobPage/ContextMenu_RFB_FilePicker'),'id' , 'equals' , idForCntxtMn , true)
		WebUI.click(newRFBContextMnOption)
		extentTest.log(Status.PASS, 'Selected Context Menu option - '+idForCntxtMn)
	}
	
	if(AppName.contains('InComplete'))
	{
		WebUI.click(findTestObject('Object Repository/JobSubmissionForm/TxtBox_ReqFiled_ToFill'))
		WebUI.setText(findTestObject('Object Repository/JobSubmissionForm/TxtBox_ReqFiled_ToFill'), 'testString')
		extentTest.log(Status.PASS, 'Entered text for required field')
		
	}
	WebUI.disableSmartWait()
	def isElemenetPresent=CustomKeywords.'customWait.WaitForElement.WaitForelementPresent'(findTestObject('JobSubmissionForm/button_Submit_Job'),20,extentTest,'SubmitButton')
	if (isElemenetPresent)
	{
		WebUI.click(findTestObject('JobSubmissionForm/button_Submit_Job'))
	}
	//WebUI.disableSmartWait()
	
	def result=WebUI.waitForElementPresent(findTestObject('Notificactions/Notification_JobSubmission'), 5)
	if (result)
	{
		def jobText = WebUI.getText(findTestObject('Notificactions/Notification_JobSubmission'))
		GlobalVariable.G_JobID=CustomKeywords.'operations_JobsModule.GetJobRowDetails.getJobID'(jobText)
		extentTest.log(Status.PASS, 'Job Submitted through profile , JobID - ' + GlobalVariable.G_JobID)
		println('********************************************')
		extentTest.log(Status.PASS, ('Verified ::  ' + TestCaseName) + ' :: Sucessfully')
	}
	else
	{
		extentTest.log(Status.FAIL,'Job Submission notification not generated')
		extentTest.log(Status.FAIL,  TestCaseName + ' :: failed')
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
//=====================================================================================

