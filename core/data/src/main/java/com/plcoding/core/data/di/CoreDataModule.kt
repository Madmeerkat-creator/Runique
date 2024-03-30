package com.plcoding.core.data.di

import android.content.SharedPreferences
import com.plcoding.core.data.auth.EncryptedSessionStorage
import com.plcoding.core.data.networking.HttpClientFactory
import com.plcoding.core.domain.SessionStorage
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
/* <6.5.7>
- HttpClientFactory 생성
<6.6.7>
- SharedPreferences 추가
 */
val coreDataModule = module {
    single {
        HttpClientFactory(get()).build()
    }
    singleOf(::EncryptedSessionStorage).bind<SessionStorage>()
}