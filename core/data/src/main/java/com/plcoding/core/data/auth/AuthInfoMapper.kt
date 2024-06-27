package com.plcoding.core.data.auth

import com.plcoding.core.domain.AuthInfo

/* <6.6.5>
AuthInfo를 Serializable로 변환하기 위해서
data class AuthInfoSerializable를 생성하고
여기서 변환 fun 생성
 */
fun AuthInfo.toAuthInfoSerializable(): AuthInfoSerializable {
    return AuthInfoSerializable(
        accessToken = accessToken,
        refreshToken = refreshToken,
        userId = userId
    )
}

fun AuthInfoSerializable.toAuthInfo(): AuthInfo {
    return AuthInfo(
        accessToken = accessToken,
        refreshToken = refreshToken,
        userId = userId
    )
}