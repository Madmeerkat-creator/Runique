package com.plcoding.auth.data.di

import com.plcoding.auth.data.AuthRepositoryImpl
import com.plcoding.auth.data.EmailPatternValidator
import com.plcoding.auth.domain.AuthRepository
import com.plcoding.auth.domain.PatternValidator
import com.plcoding.auth.domain.UserDataValidator
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
/* <6.5.7>
AuthRepository를 사용할때 AuthRepositoryImpl가 필요함을 Koin이 알게됨.
아직까지 koin이 어떤 역할을 하는지 잘 모르겠음
 */
val authDataModule = module {
    single<PatternValidator> {
        EmailPatternValidator
    }
    singleOf(::UserDataValidator)
    singleOf(::AuthRepositoryImpl).bind<AuthRepository>()
}