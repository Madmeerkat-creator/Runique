package com.plcoding.core.domain

/* <6.6.2>
 */
data class AuthInfo(
    val accessToken: String,
    val refreshToken: String,
    val userId: String
)
