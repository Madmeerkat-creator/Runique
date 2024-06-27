package com.plcoding.auth.data

import com.plcoding.auth.domain.AuthRepository
import com.plcoding.core.data.networking.post
import com.plcoding.core.domain.util.DataError
import com.plcoding.core.domain.util.EmptyResult
import io.ktor.client.HttpClient

/* <6.5.2>
AuthRepository 가져와서 구현
- fun register
    주의해야될건 body를 넘기지 않고 email 과 pwd를 넘기는것
- httpClient.post
    response body에 대해서는 신경 안쓰니 Unit으로
 */
class AuthRepositoryImpl(
    private val httpClient: HttpClient
): AuthRepository {

    override suspend fun register(email: String, password: String): EmptyResult<DataError.Network> {
        return httpClient.post<RegisterRequest, Unit>(
            route = "/register",
            body = RegisterRequest(
                email = email,
                password = password
            )
        )
    }
}