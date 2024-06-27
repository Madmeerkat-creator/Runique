package com.plcoding.core.data.di

import com.plcoding.core.data.networking.HttpClientFactory
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
/* <6.5.7>
- HttpClientFactory 생성
 */
val coreDataModule = module {
    single {
        HttpClientFactory().build()
    }
}