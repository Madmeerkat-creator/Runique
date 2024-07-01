package com.plcoding.auth.domain

import com.plcoding.core.domain.util.DataError
import com.plcoding.core.domain.util.EmptyResult
/* <6.5.1>
data 와 presentation에서 접근해야 돼서 여기에 구현
 */
interface AuthRepository {
    /* <6.9.1>
     */
    suspend fun login(email: String, password: String): EmptyResult<DataError.Network>
    suspend fun register(email: String, password: String): EmptyResult<DataError.Network>
}