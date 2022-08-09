package com.fireinrain.xtgbot.bot

import com.fireinrain.xtgbot.config.XtgBotConfig
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.telegram.telegrambots.bots.DefaultBotOptions
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.TelegramBotsApi
import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession

/**
@Description:
@Author  : fireinrain
@Site    : https://github.com/fireinrain
@File    : JavbusBot
@Software: IntelliJ IDEA
@Time    : 2022/7/27 4:16 PM
 */


class JavbusBot(options: DefaultBotOptions?) : TelegramLongPollingBot(options) {

    override fun getBotToken(): String {
        return XtgBotConfig.getConfig("TelegramToken")
    }

    override fun getBotUsername(): String {
        return XtgBotConfig.getConfig("BotUserName")
    }

    override fun onUpdateReceived(update: Update?) {
        if (update != null) {
            if (update.hasMessage()) {
                logger.info("服务端获取到新消息: ${update.message.text}")
            }
        }

    }

    companion object {
        @JvmStatic
        val logger: Logger = LoggerFactory.getLogger(Companion::class.java)
    }
}


