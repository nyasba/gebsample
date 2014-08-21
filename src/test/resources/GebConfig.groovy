
import geb.report.CompositeReporter
import geb.report.ScreenshotReporter

import org.openqa.selenium.chrome.ChromeDriver


reportsDir = "./report"

// 環境にあったChromeDriverを以下からダウンロードして指定して下さい。
// https://code.google.com/p/selenium/wiki/ChromeDriver
System.setProperty("webdriver.chrome.driver", "driver/chromedriver")

driver = {
	return new ChromeDriver()
}

reporter = new CompositeReporter(
	new ScreenshotReporter(){
		@Override
		protected escapeFileName(String name) {
			name.replaceAll('[\\\\/:\\*?\\"&lt;>\\|]', '_')
		}
	},
	new ScreenshotReporter(){
		@Override
		protected escapeFileName(String name) {
			name.replaceAll('[\\\\/:\\*?\\"&lt;>\\|]', '_')
		}
	}
)