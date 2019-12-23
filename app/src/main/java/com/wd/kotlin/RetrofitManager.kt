package com.wd.kotlin


import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class RetrofitManager private constructor(){

    lateinit var retrofit:Retrofit

    companion object {
        val instance : RetrofitManager by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED){
            RetrofitManager()
        }
    }

    fun init(string: String){
        val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(
                if(BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
                else HttpLoggingInterceptor.Level.NONE))
                .connectTimeout(5,TimeUnit.SECONDS)
                .readTimeout(5,TimeUnit.SECONDS)
                .writeTimeout(5,TimeUnit.SECONDS)
                .build()

        retrofit = Retrofit.Builder()
                .baseUrl(string)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
    }

    fun <T> createService(tClass: Class<T>): T {

        return retrofit.create(tClass)
    }

}