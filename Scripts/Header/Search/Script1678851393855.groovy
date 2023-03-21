import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.util.concurrent.ConcurrentHashMap.KeySetView

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
import org.openqa.selenium.WebElement as WebElement

WebUI.openBrowser('https://os-test.acc.co.id/accone/')
WebUI.maximizeWindow()

WebUI.click(findTestObject('Object Repository/Navbar/Search/img_Search'))
WebUI.setText(findTestObject('Object Repository/Navbar/Search/input_Search'), 'Mobil')
WebUI.sendKeys(findTestObject('Object Repository/Navbar/Search/input_Search'), Keys.chord(Keys.ENTER))

//Verifikasi pencarian sesuai
List<WebElement> cardSearch = WebUI.findWebElements(findTestObject('Object Repository/Navbar/Search/HasilPencarian'), 10)
List<WebElement> listSearch = new ArrayList()

for (dataCard in cardSearch) {
	listSearch.add(dataCard.getText())
}


for (int i = 0; i < listSearch.size(); i++) {
	if(listSearch.get(i).contains('Mobil')) {
		WebUI.comment(listSearch.get(i))
		KeywordUtil.markPassed('Pencarian berhasil')
	} else {
		WebUI.comment(listSearch.get(i))
		KeywordUtil.markFailed('Pencarian tidak berhasil')
	}
}

WebUI.closeBrowser()