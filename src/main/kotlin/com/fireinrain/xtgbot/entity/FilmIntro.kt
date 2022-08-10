package com.fireinrain.xtgbot.entity

/**
@Description: 作品简介
@Author  : fireinrain
@Site    : https://github.com/fireinrain
@File    : FilmIntro
@Software: IntelliJ IDEA
@Time    : 2022/8/10 1:55 PM
 */

data class FilmIntro(
    var introPicUrl: String = "",
    var filmName: String = "",
    var resolution: String = "",
    var code: String = "",
    var publishDate: String = "",
    var filmDetailUrl: String = ""
) : SearchResult
