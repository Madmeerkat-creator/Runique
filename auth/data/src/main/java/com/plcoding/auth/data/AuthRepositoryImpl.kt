package com.plcoding.auth.data

import com.plcoding.auth.domain.AuthRepository
import com.plcoding.core.data.networking.post
import com.plcoding.core.domain.AuthInfo
import com.plcoding.core.domain.SessionStorage
import com.plcoding.core.domain.util.DataError
import com.plcoding.core.domain.util.EmptyResult
import com.plcoding.core.domain.util.Result
import com.plcoding.core.domain.util.asEmptyDataResult
import io.ktor.client.HttpClient

/* <6.5.2>
AuthRepository 가져와서 구현
- fun register
    주의해야될건 body를 넘기지 않고 email 과 pwd를 넘기는것
- httpClient.post
    response body에 대해서는 신경 안쓰니 Unit으로
 */
/* <6.9.5>
result에 대해 어디에 저장하지?
AuthInfo에 저장해야겠다.
저장하려면 sessionStorage가 필요함
param으로 넘겨받자
 */
class AuthRepositoryImpl(
    private val httpClient: HttpClient,
    private val sessionStorage: SessionStorage
): AuthRepository {

    /* <6.9.2>
     */
    override suspend fun login(email: String, password: String): EmptyResult<DataError.Network> {
        val result = httpClient.post<LoginRequest, LoginResponse>(
            route = "/login",
            body = LoginRequest(
                email = email,
                password = password
            )
        )
        if(result is Result.Success) {
            sessionStorage.set(
                AuthInfo(
                    accessToken = result.data.accessToken,
                    refreshToken = result.data.refreshToken,
                    userId = result.data.userId
                )
            )
        }
        return result.asEmptyDataResult()
    }

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