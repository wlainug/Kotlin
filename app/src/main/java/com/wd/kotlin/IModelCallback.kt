package com.wd.kotlin

interface IModelCallback<T>{

    fun sucess(data: T)
    fun failed(string: String)

}