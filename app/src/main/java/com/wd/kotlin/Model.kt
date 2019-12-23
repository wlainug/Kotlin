package com.wd.kotlin

import android.content.Context


/**
 * @name: Kotlin
 * @class: name：com.wd.kotlin
 * @author: 王国圣
 * @time: 2019/12/20 20:47
 */
class Model : Contract.ILoginModel{
    override fun login(hashMap: HashMap<String, String>, context: Context, modelIModelCallback: IModelCallback<UserBean>) {
        RetrofitManager.instance.createService(UserApiService::class.java).login(Api.LOGIN_URL,hashMap)
            .subscribe(object : <UserBean>(context){
                override fun success(data: UserBean) {

                    modelIModelCallback?.sucess(data)

                }

               /* override fun failure(statusCode: Int, apiErrorModel: ApiErrorModel) {

                    modelIModelCallback?.failure(apiErrorModel.message)
                }*/

            })
    }
}