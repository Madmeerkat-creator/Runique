package com.plcoding.auth.presentation.login

import com.plcoding.core.presentation.ui.UiText

/* <6.8.3>
 */
sealed interface LoginEvent {
    data class Error(val error: UiText): LoginEvent
    data object LoginSuccess: LoginEvent
}