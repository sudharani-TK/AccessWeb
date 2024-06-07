import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.Keys as Keys

import com.kms.katalon.core.exception.StepErrorException as StepErrorException
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.aventstack.extentreports.Status
import com.aventstack.extentreports.MediaEntityBuilder

import internal.GlobalVariable as GlobalVariable

if(TestCaseName.contains('tile view'))
{
	println('tile view not supported in this module')
}
else
{
	//====================================================================================
	def Browser = GlobalVariable.G_Browser
	//====================================================================================
	def extentTest=GlobalVariable.G_ExtentTest
	//====================================================================================
	CustomKeywords.'toLogin.ForLogin.Login'(extentTest)
	//=====================================================================================

	def navLocation = CustomKeywords.'generateFilePath.filePath.execLocation'()
	def location=null
	def result=null
	if (TestOperation.contains('icon'))
	{
		location = navLocation + '/FilesModule/FileOpsIcons'
	}
	else
	{
		location = navLocation + '/FilesModule/FileOps/'
	}

	try {

		def jobsTab = CustomKeywords.'customWait.WaitForElement.WaitForelementPresent'(findTestObject('LoginPage/NewJobPage/AppList_ShellScript'),
				20,extentTest,'Jobs Tab')

		if (jobsTab) {
			WebUI.click(findTestObject('GenericObjects/TitleLink_Jobs'))
		}

		extentTest.log(Status.PASS, 'Navigated Job Tab')
		WebUI.delay(2)

		TestObject newAppObj = WebUI.modifyObjectProperty(findTestObject('LoginPage/NewJobPage/AppList_ShellScript'), 'id', 'equals',
				AppName, true)

		WebUI.click(newAppObj)
		extentTest.log(Status.PASS, 'Navigated to Job Submission For for - '+AppName)

		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/LoginPage/NewJobPage/GenericProfile'))
		WebUI.delay(2)

	/*	WebUI.click(findTestObject('Object Repository/FilesPage/Icon_EditFilePath'))


		WebUI.setText(findTestObject('Object Repository/FilesPage/textBx_FilePath'), location)
		WebUI.sendKeys(findTestObject('Object Repository/FilesPage/textBx_FilePath'), Keys.chord(Keys.ENTER))
		extentTest.log(Status.PASS, 'Navigated to '+location)*/
		CustomKeywords.'generateFilePath.filePath.navlocation'(location, extentTest)
		WebUI.delay(2)
		WebUI.click(findTestObject('FilesPage/FilesSearch_filter'))
		WebUI.waitForElementVisible(findTestObject('FilesPage/FilesSearch_filter'), 2)
		WebUI.setText(findTestObject('FilesPage/FilesSearch_filter'), fileName)
		extentTest.log(Status.PASS, 'Looking for file to perfrom operation - ' +TestOperation)
		WebUI.sendKeys(findTestObject('JobDetailsPage/TextBx_DetailsFilter'), Keys.chord(Keys.ENTER))
		extentTest.log(Status.PASS, 'Clicked on File  - ' + fileName)

		newFileObj = WebUI.modifyObjectProperty(findTestObject('FilesPage/RowItem_File'), 'data-automation-id', 'equals',fileName, true)

		def fileItem = CustomKeywords.'customWait.WaitForElement.WaitForelementPresent'(newFileObj, 20,extentTest,fileName)
		if (TestOperation.contains('icon'))
		{
			WebUI.waitForElementPresent(newFileObj, 3)
			WebUI.click(newFileObj)
			extentTest.log(Status.PASS, 'Clicked on file ' + fileName)
			result = CustomKeywords.'operations_FileModule.fileOperations_Icon.executeFileOperations'(TestOperation, TestCaseName,extentTest)
		}

		else
		{
			WebUI.waitForElementPresent(newFileObj, 3)
			WebUI.click(newFileObj)
			WebUI.rightClick(newFileObj)
			extentTest.log(Status.PASS, 'Right Clicked File to invoke context menu on  - ' + fileName)
			result=CustomKeywords.'operations_FileModule.fileOperations.executeFileOperations'(Operation, TestCaseName , extentTest)
		}



		if (result)
		{
			extentTest.log(Status.PASS, ('Verified - ' + TestCaseName) + '  Sucessfully')
		} else {
			extentTest.log(Status.FAIL,  TestCaseName + ' - failed')
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


}