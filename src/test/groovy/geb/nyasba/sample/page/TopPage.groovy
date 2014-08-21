package geb.nyasba.sample.page

import geb.Page

/**
 * Webサイト１ページ単位で作成するageObject
 */
class TopPage extends Page {

    // to TopPage でアクセスするURLを定義
	static url = "http://www.biglobe.ne.jp/"

    // at TopPage で満たすべきassert条件を記載
	static at = { title == "BIGLOBE" }

    // TopPageのコンテンツ
	static content = {

        // 検索キーワードのテキストボックスはid=txtbox
		searchKeyword { $('#txtbox') }

        // 検索ボタンはid=search-btn
		searchButton  { $('#search-btn') }
	}
}
