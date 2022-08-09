package com.fireinrain.xtgbot

import com.fireinrain.xtgbot.bot.JavbusBot
import com.fireinrain.xtgbot.config.XtgBotConfig
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.telegram.telegrambots.bots.DefaultBotOptions
import org.telegram.telegrambots.meta.TelegramBotsApi
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession

/**
@Description: 程序运行入口
@Author  : fireinrain
@Site    : https://github.com/fireinrain
@File    : Main
@Software: IntelliJ IDEA
@Time    : 2022/8/10 3:32 AM
 */

object Main {
    @JvmStatic
    val logger: Logger = LoggerFactory.getLogger(Main::class.java)

    @JvmStatic
    fun main(args: Array<String>) {
        val defaultBotOptions = DefaultBotOptions()
        defaultBotOptions.proxyHost = XtgBotConfig.getConfig("ProxyHost")
        defaultBotOptions.proxyPort = XtgBotConfig.getConfig("ProxyPort").toInt()
        defaultBotOptions.proxyType = DefaultBotOptions.ProxyType.HTTP

        val telegramBotsApi = TelegramBotsApi(DefaultBotSession::class.java)
        telegramBotsApi.registerBot(JavbusBot(defaultBotOptions))
        logger.info("----------------- start xtgbot -----------------")
    }
}