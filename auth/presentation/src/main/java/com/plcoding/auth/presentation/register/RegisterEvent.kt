package com.plcoding.auth.presentation.register

import com.plcoding.core.presentation.ui.UiText

/* <6.5.5>
- 성공한 경우
- 실패한 경우 -> show error on the toast
 */
sealed interface RegisterEvent {
    data object RegistrationSuccess: RegisterEvent
    data class Error(val error: UiText): RegisterEvent
}