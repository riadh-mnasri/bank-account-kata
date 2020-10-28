package com.riadhmnasri.bankaccountkata

import java.time.LocalDateTime

data class Operation(val operationType: Type, val operationDateTime: LocalDateTime, val amount: Double, val balance: Double)

enum class Type {
    DEPOSIT, WITHDRAW
}
