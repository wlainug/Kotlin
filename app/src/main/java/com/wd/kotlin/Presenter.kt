package com.wd.kotlin

import android.content.Context


class Presenter : Contract.ILoginPresenter {

    lateinit var loginModel:Model
    lateinit var iLoginView:Contract.ILoginView

    fun attach(iLoginView: Contract.ILoginView){
        this.iLoginView=iLoginView
        loginModel = Model()
    }

    override fun login(hashMap: HashMap<String, String>, context: Context) {
        loginModel.login(hashMap,context,object : IModelCallback<UserBean>{
            override fun sucess(data: UserBean) {
                iLoginView?.success(data)

            }
            override fun failed(string: String) {
                iLoginView.failed(string)
            }

        })
    }

    fun detach() {
        if(iLoginView !=null){
            iLoginView == null
        }

    }

}