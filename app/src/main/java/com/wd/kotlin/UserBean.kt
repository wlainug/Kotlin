package com.wd.kotlin

/**
 * @name: Kotlin
 * @class: name：com.wd.kotlin
 * @author: 王国圣
 * @time: 2019/12/20 20:27
 */
data class UserBean(
    val message: String,
    val result: Result,
    val status: String
) {
    data class Result(
        val headPic: String,
        val nickName: String,
        val phone: String,
        val sessionId: String,
        val sex: Int,
        val userId: Int
    )
}
