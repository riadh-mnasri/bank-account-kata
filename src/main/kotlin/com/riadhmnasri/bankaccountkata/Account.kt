package com.riadhmnasri.bankaccountkata

import com.riadhmnasri.bankaccountkata.Type.DEPOSIT
import com.riadhmnasri.bankaccountkata.Type.WITHDRAW
import java.time.LocalDateTime.now

class Account(private var saving: Double) {

    private var operationsHistory = mutableMapOf<Long, Operation>()

    fun savingState() = saving

    fun deposit(amount: Double): Account {
        saving += amount
        operationsHistory[System.nanoTime()] = Operation(DEPOSIT, now(), amount, saving)
        return this
    }

    fun withdraw(amount: Double): Account {
        saving -= amount
        operationsHistory[System.nanoTime()] = Operation(WITHDRAW, now(), amount, saving)
        return this
    }

    fun history() = operationsHistory

}
