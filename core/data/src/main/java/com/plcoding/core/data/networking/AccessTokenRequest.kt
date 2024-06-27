package com.plcoding.core.data.networking

import kotlinx.serialization.Serializable

/* <6.7.2>

 */
@Serializable
data class AccessTokenRequest(
    val refreshToken: String,
    val userId: String
)
