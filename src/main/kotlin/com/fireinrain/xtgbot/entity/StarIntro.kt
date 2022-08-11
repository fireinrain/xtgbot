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
    // 演员大头贴
    var imgPicUrl: String = "",
    // 演员名字
    var starName: String = "",
    // 是否为有码或是无码演员
    var isCensor: String = "",
    // 演员的个人作品主页
    var starPageUrl: String = "",
    // 下一个页面的url 当没有下一页后 设置为 ""
    var nextFetchPageUrl: String? = null
) : SearchResult
