package com.fireinrain.xtgbot.entity

/**
@Description: 演员简介
@Author  : fireinrain
@Site    : https://github.com/fireinrain
@File    : StarIntro
@Software: IntelliJ IDEA
@Time    : 2022/8/10 1:58 PM
 */

data class StarIntro(
    var imgPicUrl: String = "",
    var starName: String = "",
    var isCensor: String = "",
    var starPageUrl: String = ""
) : SearchResult
