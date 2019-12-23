package com.wd.kotlin

import android.content.Context

/**
 * @name: Kotlin
 * @class: name：com.wd.kotlin
 * @author: 王国圣
 * @time: 2019/12/20 20:28
 */
interface Contract {
    //Presenter层接口
    interface ILoginPresenter{
        fun login(hashMap: HashMap<String,String>,context: Context)
    }

    //Model层接口
    interface ILoginModel{
        fun login(hashMap: HashMap<String, String>, context: Context, modelIModelCallback: IModelCallback<UserBean>)
    }

    //接口回调
    interface ILoginView{
        fun success(userBean: UserBean)
        fun failed(string: String)
    }
}