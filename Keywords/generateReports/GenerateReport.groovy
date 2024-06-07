package generateReports
import java.text.SimpleDateFormat

import com.aventstack.extentreports.ExtentReports
import com.aventstack.extentreports.reporter.ExtentSparkReporter
import com.aventstack.extentreports.reporter.configuration.ViewName
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.configuration.RunConfiguration

import internal.GlobalVariable as GlobalVariable



public class GenerateReport {


	@Keyword
	def createSpark(String ReportName , String BrowserName , String BrowserVersion) {
		def date = new Date()
		def filePath = (RunConfiguration.getProjectDir() + '/ExtentReports/')
		def path = filePath+ReportName
		//def TestSuite=ReportName.split("1")
		String TestSuite=ReportName
		TestSuite=ReportName.toLowerCase()
		String[] Ts=TestSuite.split("_")
		String TestSuiteName = Ts[0];
		String TestSuite1 = Ts[1];
		String TestSuite2 = Ts[2].split("\\.")[0];

		TestSuiteName.toUpperCase()

		//	def path = GlobalVariable.G_ReportFolder+'/'+ReportName
		println ("********************* - "+path+" - *********************")
		ExtentReports extent = new ExtentReports();
		//List<ViewName> list = new ArrayList<ViewName>();
		ExtentSparkReporter spark = new ExtentSparkReporter(path)

		extent.setSystemInfo("BrowserName",BrowserName)
		extent.setSystemInfo("BrowserVersion", BrowserVersion)
		extent.setSystemInfo("TestSuite", TestSuiteName )
		//extent.setSystemInfo("T", TestSuite)
		extent.attachReporter(spark);
		return extent
	}


	@Keyword
	def getDate() {
		def date = new Date()
		def sdf = new SimpleDateFormat("dd_MM_yyyy_HHmmss")
		def start_time = sdf.format(date)
		println start_time
	}
}
