package com.plcoding.auth.data

import kotlinx.serialization.Serializable

/* <6.9.4>
 */
@Serializable
data class LoginResponse(
    val accessToken: String,
    val refreshToken: String,
    val accessTokenExpirationTimestamp: Long,
    val userId: String
)
