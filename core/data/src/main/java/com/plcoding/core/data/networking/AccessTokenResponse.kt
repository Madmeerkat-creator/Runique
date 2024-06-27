package com.plcoding.core.data.networking

import kotlinx.serialization.Serializable

/* <6.7.3>

 */
@Serializable
data class AccessTokenResponse(
    val accessToken: String,
    val expirationTimestamp: String
)
