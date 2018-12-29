package com.consultaremedios.base.di

//import com.consultaremedios.BuildConfig
//import com.consultaremedios.base.FilterProductDtoDeserializer
//import com.consultaremedios.data.model.dto.Filters
//import com.google.gson.GsonBuilder
//import okhttp3.Interceptor
//import okhttp3.OkHttpClient
//import okhttp3.logging.HttpLoggingInterceptor
//import org.koin.dsl.module.module
//import retrofit2.Converter
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//import java.util.concurrent.TimeUnit
//
//val retrofitClientModule = module {
//
//    single {
//        Retrofit.Builder()
//                .baseUrl(BuildConfig.BASE_URL)
//                .client(/* OkHttpClient */ get())
//                .addConverterFactory(get())
//                .build()
//    }
//
//    single {
//        OkHttpClient.Builder()
//                .connectTimeout(60, TimeUnit.SECONDS)
//                .readTimeout(60, TimeUnit.SECONDS)
//                .addInterceptor(get())
//                .addInterceptor(get<HttpLoggingInterceptor>())
//                .build() as OkHttpClient
//    }
//
//    single(override = true) {
//        Interceptor { chain ->
//            chain.proceed(chain.request().newBuilder()
//                    .addHeader("Accept", "application/json")
//                    .addHeader("Content-Type", "application/json")
//                    .addHeader("Authorization", BuildConfig.SERVICE_ATHORIZATION_KEY)
//                    .build())
//        }
//    }
//
//    single {
//        HttpLoggingInterceptor().apply {
//            level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
//        }
//    }
//
//    single {
//        GsonConverterFactory.create(GsonBuilder().apply {
//            registerTypeAdapter(Filters::class.java, FilterProductDtoDeserializer())
//        }.create()) as Converter.Factory
//    }
//}