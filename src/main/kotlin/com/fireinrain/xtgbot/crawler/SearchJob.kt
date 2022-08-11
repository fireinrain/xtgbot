package com.fireinrain.xtgbot.crawler

import com.fireinrain.xtgbot.config.XtgBotConfig
import com.fireinrain.xtgbot.entity.SearchResult
import com.fireinrain.xtgbot.entity.StarIntro
import kotlinx.coroutines.*
import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import okhttp3.Request
import java.net.InetSocketAddress
import java.net.Proxy
import java.net.SocketAddress
import java.util.concurrent.TimeUnit

/**
@Description: 搜索
@Author  : fireinrain
@Site    : https://github.com/fireinrain
@File    : SearchJob
@Software: IntelliJ IDEA
@Time    : 2022/8/10 3:40 AM
 */

class SearchJob {
    val okHttpClient = OkHttpClient.Builder().readTimeout(10, TimeUnit.SECONDS).retryOnConnectionFailure(false)
        .connectTimeout(5, TimeUnit.SECONDS).connectionPool(ConnectionPool(10, 10, TimeUnit.SECONDS)).proxy(
            Proxy(
                Proxy.Type.HTTP,
                InetSocketAddress(XtgBotConfig.getConfig("ProxyHost"), XtgBotConfig.getConfig("ProxyPort").toInt())
            )
        ).build()

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