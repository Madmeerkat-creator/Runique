package com.plcoding.core.data.auth

import kotlinx.serialization.Serializable

/* <6.6.4>

 */
@Serializable
data class AuthInfoSerializable(
    val accessToken: String,
    val refreshToken: String,
    val userId: String
)
