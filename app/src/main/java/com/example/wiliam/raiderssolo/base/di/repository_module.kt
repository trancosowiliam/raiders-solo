package com.consultaremedios.base.di

//import com.consultaremedios.data.remote.cr.CRProductsApi
//import com.consultaremedios.data.remote.cr.CRProductsRepository
//import com.consultaremedios.data.remote.cr.CRProductsRepositoryImpl
//import org.koin.dsl.module.module
//import retrofit2.Retrofit
//
//val repositoryModule = module {
//
//    factory {
//        get<Retrofit>().create(CRProductsApi::class.java) as CRProductsApi
//    }
//
//    factory {
//        CRProductsRepositoryImpl(get()) as CRProductsRepository
//    }
//}