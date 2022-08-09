package com.fireinrain.xtgbot.config

import java.io.FileReader
import java.util.*

/**
@Description: bot token  配置对象
@Author  : fireinrain
@Site    : https://github.com/fireinrain
@File    : Config
@Software: IntelliJ IDEA
@Time    : 2022/8/10 12:01 AM
 */

object XtgBotConfig {
    val properties: Properties

    init {
        val properties = Properties()
        // 以下方式也是可以读取的
        // val fileInputStream = FileInputStream("src/main/resources/setting.properties")
        // properties.load(fileInputStream)

        val resourceAsStream = this.javaClass.classLoader.getResource("setting.properties")
        val fileReader = FileReader(resourceAsStream!!.file)
        properties.load(fileReader)
        XtgBotConfig.properties = properties

        fileReader.close()
    }

    fun getConfig(key: String):String{
        return properties.getProperty(key)
    }
}