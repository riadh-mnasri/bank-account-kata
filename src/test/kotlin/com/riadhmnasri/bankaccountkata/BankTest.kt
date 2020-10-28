package com.riadhmnasri.bankaccountkata

import com.riadhmnasri.bankaccountkata.Type.DEPOSIT
import com.riadhmnasri.bankaccountkata.Type.WITHDRAW
import org.assertj.core.api.Assertions
import org.assertj.core.api.SoftAssertions
import org.junit.jupiter.api.Test

class BankTest {

    @Test
    internal fun should_deposit_100_euro_in_my_account() {
        // Given
        val currentAccount = Account(5000.0)

        // When
        val changedAccount = currentAccount.deposit(100.0)

        // Then
        Assertions.assertThat(changedAccount.savingState()).isEqualTo(5100.0)
    }

    @Test
    internal fun should_withdraw_50_euro_from_my_account() {
        // Given
        val currentAccount = Account(5000.0)

        // When
        val changedAccount = currentAccount.withdraw(50.0)

        // Then
        Assertions.assertThat(changedAccount.savingState()).isEqualTo(4950.0)
    }

    @Test
    internal fun should_see_account_operation_history_after_deposit_100_and_withdraw_50() {
        // Given
        val account = Account(5000.0)

        // When
        account.deposit(100.0)
        account.withdraw(50.0)

        // Then
        val operations = account.history()

        val depositOperation = operations.entries.asSequence().first { it.value.operationType == DEPOSIT }
        val withdrawOperation = operations.entries.asSequence().first { it.value.operationType == WITHDRAW }

        val softAssertions = SoftAssertions()
        softAssertions.assertThat(operations.size).isEqualTo(2)
        softAssertions.assertThat(depositOperation.value.amount).isEqualTo(100.0)
        softAssertions.assertThat(depositOperation.value.balance).isEqualTo(5100.0)
        softAssertions.assertThat(withdrawOperation.value.amount).isEqualTo(50.0)
        softAssertions.assertThat(withdrawOperation.value.balance).isEqualTo(5050.0)
        softAssertions.assertAll()


    }
}
