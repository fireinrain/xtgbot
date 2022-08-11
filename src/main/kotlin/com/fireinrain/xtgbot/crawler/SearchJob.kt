package com.fireinrain.xtgbot.crawler

import com.fireinrain.xtgbot.entity.StarIntro
import kotlinx.coroutines.*
import okhttp3.Request

/**
@Description: 搜索
@Author  : fireinrain
@Site    : https://github.com/fireinrain
@File    : SearchJob
@Software: IntelliJ IDEA
@Time    : 2022/8/10 3:40 AM
 */

class SearchJob : AbstractJob() {
    suspend fun query(query: String, queryType: Int): Deferred<List<StarIntro>> {
        val result = withContext(Dispatchers.IO) {
            val deferred = async {
                val url = Request.Builder().url("https://javbus.com").get().build()
                val respStr = okHttpClient.newCall(url).execute().body?.string()
                delay(5000)
                println(respStr)
                val starIntro1 = StarIntro()
                listOf(starIntro1)
            }
            deferred
        }
        // println(result)

        return result
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>): Unit = runBlocking {
            val searchJob = SearchJob()

            for (i in 1..1000) {
                val query = searchJob.query("", 1)
                query.await().apply {
                    println(this)
                }
            }


        }
    }

}


