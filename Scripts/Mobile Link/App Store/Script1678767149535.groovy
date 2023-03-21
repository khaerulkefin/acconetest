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

WebUI.openBrowser('https://os-test.acc.co.id/accone/')
WebUI.maximizeWindow()
WebUI.click(findTestObject('Object Repository/Header/MobileLink'))
WebUI.click(findTestObject('Object Repository/MobileLink-store/iOS'))
WebUI.switchToWindowTitle('ACC ONE di App Store')
//WebUI.switchToWindowUrl('https://apps.apple.com/id/app/acc-one/id1453382506?l=id#?platform=iphone')

assert WebUI.getWindowTitle() == 'ACC ONE di App Store'
assert WebUI.getUrl() == 'https://apps.apple.com/id/app/acc-one/id1453382506?l=id#?platform=iphone'

WebUI.closeBrowser()
