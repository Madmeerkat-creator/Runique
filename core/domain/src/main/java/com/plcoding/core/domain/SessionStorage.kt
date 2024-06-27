package com.plcoding.core.domain
/* <6.6.1>

 */
interface SessionStorage {
    suspend fun get(): AuthInfo?
    suspend fun set(info: AuthInfo?)
}