package com.fireinrain.xtgbot.crawler

import com.fireinrain.xtgbot.config.XtgBotConfig

/**
@Description:
@Author  : fireinrain
@Site    : https://github.com/fireinrain
@File    : SearchTypeEnum
@Software: IntelliJ IDEA
@Time    : 2022/8/10 3:51 AM
 */

enum class SearchTypeEnum(val index: Int, val desc: String, val apiTempUrl: String) {
    // @@ will be replaced by query string
    CENSORED(1, "有码影片", XtgBotConfig.getConfig("JavbusBaseUrl") + "search/@@&type=1"),
    UNCENSORED(-1, "无码影片", XtgBotConfig.getConfig("JavbusBaseUrl") + "uncensored/search/@@&type=1"),
    AVSTAR(-2, "女优", XtgBotConfig.getConfig("JavbusBaseUrl") + "searchstar/@@"),
    DIRECTOR(2, "导演", XtgBotConfig.getConfig("JavbusBaseUrl") + "search/@@&type=2"),
    PRODUCER(3, "制作商", XtgBotConfig.getConfig("JavbusBaseUrl") + "search/@@&type=3"),
    PUBLISER(4, "发行商", XtgBotConfig.getConfig("JavbusBaseUrl") + "search/@@&type=4"),
    SERIES(5, "系列", XtgBotConfig.getConfig("JavbusBaseUrl") + "search/@@&type=5");


    /**
     * 获取查询的链接地址
     */
    fun getQueryString(query: String): String {
        return this.apiTempUrl.replace("@@", query)
    }


}
