package com.tpc.digigate.ui.screens.authentication.emailVerificationEmailSentConfirmation

data class EmailConfirmationUIState(
    val isLoading: Boolean = false,
    val canResend: Boolean = false,
    val countdown: Int = 30,
    val message: String? = null,
)