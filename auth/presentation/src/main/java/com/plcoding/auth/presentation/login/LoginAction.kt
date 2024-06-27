package com.plcoding.auth.presentation.login
/* <6.8.1>
 */
sealed interface LoginAction {
    data object OnTogglePasswordVisibility: LoginAction
    data object OnLoginClick: LoginAction
    data object OnRegisterClick: LoginAction
}