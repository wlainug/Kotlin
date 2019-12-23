package com.wd.kotlin


import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.Url
import rx.Observable

import kotlin.collections.HashMap


interface UserApiService{

    @POST
    @FormUrlEncoded
    fun login(@Url string: String, @FieldMap hashMap: HashMap<String,String>): Observable<UserBean>

}