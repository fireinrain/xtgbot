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
    // 作品封面url
    var introPicUrl: String = "",
    // 作品名称
    var filmName: String = "",
    // 当前作品有资源情况下最高的分辨率
    var resolution: String = "",
    // 番号
    var code: String = "",
    // 发行日期
    var publishDate: String = "",
    // 作品详情页面url
    var filmDetailUrl: String = "",
    // 几天前新种
    var lastTorrentUpdate: String = "",
    // 字幕
    var subtitle: String = "",

) : SearchResult
