package com.fireinrain.xtgbot.crawler

import com.fireinrain.xtgbot.config.XtgBotConfig
import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.net.InetSocketAddress
import java.net.Proxy
import java.util.concurrent.TimeUnit

/**
@Description:
@Author  : fireinrain
@Site    : https://github.com/fireinrain
@File    : AbstractJob
@Software: IntelliJ IDEA
@Time    : 2022/8/12 2:47 AM
 */

abstract class AbstractJob {


    val okHttpClient = OkHttpClient.Builder().readTimeout(10, TimeUnit.SECONDS).retryOnConnectionFailure(false)
        .connectTimeout(5, TimeUnit.SECONDS).connectionPool(ConnectionPool(10, 10, TimeUnit.SECONDS)).proxy(
            Proxy(
                Proxy.Type.HTTP,
                InetSocketAddress(XtgBotConfig.getConfig("ProxyHost"), XtgBotConfig.getConfig("ProxyPort").toInt())
            )
        ).build()

    companion object {
        @JvmStatic
        val logger: Logger = LoggerFactory.getLogger(Companion::class.java)
    }

}