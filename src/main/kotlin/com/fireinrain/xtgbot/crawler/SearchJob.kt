package com.fireinrain.xtgbot.crawler

import com.fireinrain.xtgbot.config.XtgBotConfig
import com.fireinrain.xtgbot.entity.SearchResult
import com.fireinrain.xtgbot.entity.StarIntro
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
@Description: 搜索
@Author  : fireinrain
@Site    : https://github.com/fireinrain
@File    : SearchJob
@Software: IntelliJ IDEA
@Time    : 2022/8/10 3:40 AM
 */

class SearchJob {

    suspend fun query(query: String, queryType: Int): List<SearchResult> {
        val starIntro = StarIntro("", "", "", "")
        val starIntro1 = StarIntro()
        return listOf(starIntro)
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>):Unit = runBlocking {
            launch {
                val searchJob = SearchJob()
                searchJob.query("", 1)
            }


        }
    }

}