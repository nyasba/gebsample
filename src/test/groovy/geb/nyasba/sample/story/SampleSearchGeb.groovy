package geb.nyasba.sample.story

import geb.nyasba.sample.page.TopPage
import geb.spock.GebReportingSpec
import spock.lang.Unroll

class SampleSearchGeb extends GebReportingSpec{

    @Unroll("#keywordを検索する")
    def "BIGLOBE検索を行う"( String keyword ){
		
		expect:
            // TopPage にアクセスする
			to TopPage

            // TopPage にアクセスできたことを確認
            at TopPage

            // 検索キーワードにkeywordを入力
            searchKeyword.value(keyword)

            // TOP画面をキャプチャにとる
            report("検索画面")

            // 検索ボタンをクリック
            searchButton.click()

            // 終了（この時点のキャプチャも自動的に取られている）

		where :
            // expectの処理を以下のパラメータ(keyword)で何度も繰り返す。複数定義も可能
			keyword << ["geb", "spock"]
	}
}
