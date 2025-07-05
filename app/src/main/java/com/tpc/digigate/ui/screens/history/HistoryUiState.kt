package com.tpc.digigate.ui.screens.history

data class HistoryUiState(
    val isLoading:Boolean = false,
    val yearData: List<Year> = emptyList()
)

data class Year(
    val year: Int,
    val monthData: List<Month> = emptyList()
)

data class Month(
    val month: Int,
    val dayEntries: List<DayEntry> = emptyList()
)

data class DayEntry(
    val day: Int,
    val inTime: String = "",
    val outTime: String = "",
    val isInVerified: Boolean = false,
    val isOutVerified: Boolean = false
)

val MonthOrder = mapOf(
    1 to "January",
    2 to "February",
    3 to "March",
    4 to "April",
    5 to "May",
    6 to "June",
    7 to "July",
    8 to "August",
    9 to "September",
    10 to "October",
    11 to "November",
    12 to "December",
)