


object Utils {
    const val TXT_GET_NUM_OF_ROWS = "Enter the number of rows"
    const val TXT_GET_NUM_OF_SEATS = "Enter the number of seats in each row"
    const val GET_ROW_NUMBER = "Enter a row number"
    const val GET_SEAT_NUMBER = "Enter a seat number in that row"
    const val TITLE: String = "Cinema"
    const val SPACE: String = " "

    const val BACK_ROW_PRICE_PER_SEAT = 8
    const val FRONT_ROW_PRICE_PER_SEAT = 10
    const val SMALL_CINEMA_MAX_SEATS = 60

    fun getInput(message: String = ""): String {
        if (message.isNotEmpty()) {
            println("$message:")
        }
        return readln()
    }
}