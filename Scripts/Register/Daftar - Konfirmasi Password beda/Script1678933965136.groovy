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
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('https://os-test.acc.co.id/accone/')
WebUI.maximizeWindow()

WebUI.waitForElementVisible(findTestObject('Object Repository/Header/Login'), 10)

WebUI.mouseOver(findTestObject('Object Repository/Header/Login'))
WebUI.click(findTestObject('Object Repository/Login/LoginForm-dropdown/span_Daftar'))
WebUI.click(findTestObject('Object Repository/Login/RegisterPage/btn_Daftar Pengguna Baru'))

//Mengisi Form Register
WebUI.setText(findTestObject('Object Repository/Login/RegisterForm/inputNama'), 'kefin khaerul')
WebUI.setText(findTestObject('Object Repository/Login/RegisterForm/inputEmail'), 'kefinkhaerul@gmail.com')
WebUI.setText(findTestObject('Object Repository/Login/RegisterForm/inputNoHP'), '87817463527')
WebUI.click(findTestObject('Object Repository/Login/RegisterForm/inputRadiobtnLaki'))
WebUI.setText(findTestObject('Object Repository/Login/RegisterForm/inputPass'), 'password1')
WebUI.setText(findTestObject('Object Repository/Login/RegisterForm/inputConfPass'), 'password')

//Verifikasi password sama atau tidak
if(WebUI.verifyElementPresent(findTestObject('Object Repository/Login/RegisterForm/Verifikasi/span_Kata Sandi yang dimasukkan tidak sama'), 10)) {
	KeywordUtil.markPassed('Password tidak match')
} else {
	KeywordUtil.markFailed('Password match')
}

WebUI.closeBrowser()
