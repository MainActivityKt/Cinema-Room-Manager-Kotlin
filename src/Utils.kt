object Utils {
    const val TXT_GET_NUM_OF_ROWS = "Enter the number of rows"
    const val GET_NUM_OF_SEATS = "Enter the number of seats in each row"

    fun getInput(message: String = ""): String {
        if (message.isNotEmpty()) {
            println("$message:")
        }
        return readln()
    }
}