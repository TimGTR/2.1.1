fun main() {
    println(calcDiscount(card = "Visa", transactionHistory = 1500000, transactionSum = 1500000))
    println(calcDiscount(transactionHistory = 15000000, transactionSum = 15000000))
    println(calcDiscount(card = "Mastercard", transactionHistory = 3500, transactionSum = 3500))
}

fun calcDiscount(card: String = "Vk Pay", transactionHistory: Int = 0, transactionSum: Int): String {
    if (inLimits(card, transactionHistory, transactionSum)) {
        return when (card) {
            "Mastercard", "Maestro" -> if ((transactionHistory < 7500000) && (transactionSum < 7500000)) {
                return "Комиссия 0 копеек"
            } else {
                return "Комиссия ${((transactionSum * 0.006 + 2000) / 100).toInt()} копеек"
            }
            "Visa", "Мир" -> return when {
                transactionSum * 0.0075 > 3500 -> "Комиссия ${transactionSum * 0.0075.toInt()} копеек"
                else -> "Комиссия 3500 копеек"
            }
            else -> "Комиссия 0 копеек"
        }
    } else {
        return "Превышен лимит"
    }
}

fun inLimits(card: String, transactionHistory: Int, transactionSum: Int): Boolean {
    return when {
        card == "Vk Pay" -> return when {
            transactionHistory < 4000000 && transactionSum < 1500000 -> true
            else -> false
        }
        transactionSum < 15000000 && transactionHistory < 60000000 -> true
        else -> false
    }
}
