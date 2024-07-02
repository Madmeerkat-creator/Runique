package com.plcoding.run.presentation.run_overview

/* <7.1.1>
 */
sealed interface RunOverviewAction {
    data object OnStartClick: RunOverviewAction
    data object OnLogoutClick: RunOverviewAction
    data object OnAnalyticsClick: RunOverviewAction
}