package com.consultaremedios.base.di

//import androidx.room.Room
//import com.consultaremedios.data.local.dao.AppDatabase
//import org.koin.dsl.module.module
//
//@Suppress("USELESS_CAST")
//val roomDatabaseModule = module {
//    single {
//        Room.databaseBuilder(get(), AppDatabase::class.java, "database")
//                .allowMainThreadQueries()
//                .build() as AppDatabase
//    }
//
//    factory {
//        get<AppDatabase>().recentSearchDao()
//    }
//}