package geb.nyasba.sample.story

import com.xlson.groovycsv.CsvParser
import geb.nyasba.sample.page.TopPage
import geb.spock.GebReportingSpec
import spock.lang.Unroll

@Unroll
class CsvSampleSearchGeb extends GebReportingSpec{

    def "#csvRecord.val1と#csvRecord.val2でBIGLOBE検索を行う"( def csvRecord ){
		
		expect:
            // TopPage にアクセスする
			to TopPage

            // TopPage にアクセスできたことを確認
            at TopPage

            // 検索キーワードにkeywordを入力
            searchKeyword.value( csvRecord.val1 + " " + csvRecord.val2 )

            // TOP画面をキャプチャにとる
            report("検索画面")

            // 検索ボタンをクリック
            searchButton.click()

            // 終了（この時点のキャプチャも自動的に取られている）

		where :
            // expectの処理を以下のパラメータ(keyword)で何度も繰り返す。複数定義も可能
            // input/sample.csvを読み込む。先頭行も取得する。カラムはval1,val2とする
			csvRecord << new CsvParser().parse( new FileReader("input/sample.csv"), readFirstLine: true, columnNames:["val1", "val2"]  )
	}
}
