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
import org.openqa.selenium.WebElement as WebElement

WebUI.callTestCase(findTestCase('Navbar-Jualbeli/Mobil Baru/Beli Mobil Baru'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Object Repository/MobilBaru/MobilBaru-Search'), 'Daihatsu')
WebUI.click(findTestObject('Object Repository/MobilBaru/btn_Cari Mobil Impian'))

//Verifikasi pencarian berhasil
//Verifikasi brand yang dipilih
//Mobil List
List<WebElement> cardMobil = WebUI.findWebElements(findTestObject('Object Repository/MobilBaru/Daftar Mobil Baru/Mobil List'), 10)
List<WebElement> listMobil = new ArrayList()

for (dataCard in cardMobil) {
	listMobil.add(dataCard.getText())
}


for (int i = 0; i < listMobil.size(); i++) {
	if(listMobil.get(i).contains('DAIHATSU')) {
		KeywordUtil.markPassed('Pencarian berhasil')
	} else {
		KeywordUtil.markFailed('Pencarian tidak berhasil')
	}
}

WebUI.closeBrowser()