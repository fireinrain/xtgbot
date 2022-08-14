package com.fireinrain.xtgbot.crawler

import com.fireinrain.xtgbot.entity.FilmIntro
import com.fireinrain.xtgbot.entity.SearchResult
import com.fireinrain.xtgbot.entity.StarIntro
import kotlinx.coroutines.*
import okhttp3.Request
import org.jsoup.Jsoup

/**
@Description: 搜索
@Author  : fireinrain
@Site    : https://github.com/fireinrain
@File    : SearchJob
@Software: IntelliJ IDEA
@Time    : 2022/8/10 3:40 AM
 */

class SearchJob : AbstractJob() {
    suspend fun query(query: String, searchType: SearchTypeEnum): Deferred<List<SearchResult>> {
        val resultType = when (searchType) {
            SearchTypeEnum.AVSTAR -> StarIntro()
            else -> {
                FilmIntro()
            }
        }
        val result = withContext(Dispatchers.IO) {
            val deferred = async {
                var tempUrl = searchType.getQueryString(query)
                val url = Request.Builder().url(tempUrl).get().build()
                val resp = okHttpClient.newCall(url).execute()
                if (resp.code == 404) {
                    listOf(resultType)
                } else {
                    val document = resp.body?.string().let { Jsoup.parse(it) }
                    val elements = document.selectXpath("//*[@id=\"waterfall\"]/div/a")
                    when (resultType) {
                        is FilmIntro -> {
                            val resultList = ArrayList<FilmIntro>()
                            for (element in elements) {
                                val text = element.text()
                                val lastTorrentUpdateList = text.split(" ")

                                println(text)
                                val filmIntro = FilmIntro()
                                if ("高清" in text) {
                                    filmIntro.resolution = "高清"
                                }
                                if ("字幕" in text) {
                                    filmIntro.subtitle = "字幕"
                                }
                                if ("前新種" in text) {
                                    val info = lastTorrentUpdateList[lastTorrentUpdateList.size - 4]
                                    filmIntro.lastTorrentUpdate = info
                                }
                                // 番号
                                filmIntro.code = lastTorrentUpdateList[lastTorrentUpdateList.size - 3]
                                // 更新日期
                                filmIntro.publishDate = lastTorrentUpdateList[lastTorrentUpdateList.size - 1]
                                // 标题
                                val title = element.selectXpath("//div[2]/span/text()[1]")
                                println("title: $title")
                                // 详情页面url
                                val detailUrl = element.attr("href")
                                filmIntro.filmDetailUrl = detailUrl

                                // 封面url
                                val imageUrl = element.selectXpath("//div[1]/img").attr("src")
                                filmIntro.introPicUrl = imageUrl
                                resultList.add(filmIntro)
                            }
                            resultList
                        }

                        else -> {
                            for (element in elements) {
                                println(element.text())
                            }
                            listOf(StarIntro())
                        }
                    }
                }
            }
            deferred
        }

        return result
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>): Unit = runBlocking {
            val searchJob = SearchJob()
            val query = searchJob.query("朝", SearchTypeEnum.CENSORED)
            query.await().apply {
                println(this)
            }
        }


    }


}


