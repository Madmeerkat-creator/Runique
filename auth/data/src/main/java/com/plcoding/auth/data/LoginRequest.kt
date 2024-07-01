package com.plcoding.auth.data

import kotlinx.serialization.Serializable

/* <6.9.3>
 */
@Serializable
data class LoginRequest(
    val email: String,
    val password: String
)
