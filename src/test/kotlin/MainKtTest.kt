import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun calcDiscount_VK_0_0() {
        val cardT = "Vk Pay"
        val transactionHistoryT = 0
        val transactionSumT = 0

        val result = calcDiscount(
            card = cardT,
            transactionHistory = transactionHistoryT,
            transactionSum = transactionSumT
        )

        assertEquals("Комиссия 0 копеек", result)
    }

    @Test
    fun calcDiscount_VK_4000000_0() {
        val cardT = "Vk Pay"
        val transactionHistoryT = 4000000
        val transactionSumT = 0

        val result = calcDiscount(
            card = cardT,
            transactionHistory = transactionHistoryT,
            transactionSum = transactionSumT
        )

        assertEquals("Превышен лимит", result)
    }

    @Test
    fun calcDiscount_VK_3900000_0() {
        val cardT = "Vk Pay"
        val transactionHistoryT = 3900000
        val transactionSumT = 0

        val result = calcDiscount(
            card = cardT,
            transactionHistory = transactionHistoryT,
            transactionSum = transactionSumT
        )

        assertEquals("Комиссия 0 копеек", result)
    }

    @Test
    fun calcDiscount_Mastercard_0_0() {
        val cardT = "Mastercard"
        val transactionHistoryT = 0
        val transactionSumT = 0

        val result = calcDiscount(
            card = cardT,
            transactionHistory = transactionHistoryT,
            transactionSum = transactionSumT
        )

        assertEquals("Комиссия 0 копеек", result)
    }

    @Test
    fun calcDiscount_Mastercard_7500000_0() {
        val cardT = "Mastercard"
        val transactionHistoryT = 7500000
        val transactionSumT = 0

        val result = calcDiscount(
            card = cardT,
            transactionHistory = transactionHistoryT,
            transactionSum = transactionSumT
        )

        assertEquals("Комиссия 20 копеек", result)
    }
}