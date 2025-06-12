package com.tangwong.project.di

import com.tangwong.project.BuildConfig
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

var apiModule = module {
//        single { LoggingInterceptor() }
//        single { provideOkHttpClient(get(), get(), get(), get()) }
//        single { providerRetrofit(get()) }
//        single { get<Retrofit>().create(ApiService::class.java) }
//
//    fun provideOkHttpClient(
//        loggingInterceptor: LoggingInterceptor,
//    ): OkHttpClient {
//        val timeOut = 900000L
//        return OkHttpClient.Builder()
//            .addInterceptor(loggingInterceptor)
//            .connectTimeout(timeOut, TimeUnit.MILLISECONDS)
//            .writeTimeout(timeOut, TimeUnit.MILLISECONDS)
//            .readTimeout(timeOut, TimeUnit.MILLISECONDS)
//            .build()
//    }
//
//    fun providerRetrofit(okHttpClient: OkHttpClient): Retrofit {
//        return Retrofit.Builder()
//            .client(okHttpClient)
//            .baseUrl(BuildConfig.BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//    }
}