package cinemamanager

import Utils.BACK_ROW_PRICE_PER_SEAT
import Utils.FRONT_ROW_PRICE_PER_SEAT
import Utils.GET_ROW_NUMBER
import Utils.GET_SEAT_NUMBER
import Utils.SMALL_CINEMA_MAX_SEATS
import Utils.getInput
import Utils.print
import Utils.Seat

class CinemaManagerWithStatistics: CinemaManager() {
    private var soldTickets = 0
    private var currentIncome  = 0
    private var totalIncome = 0

    init {
        val numOfRows = arrayOfSeats.size
        val seatsPerRow = arrayOfSeats.first().size
        val totalSeats = numOfRows * seatsPerRow
        totalIncome = when(totalSeats) {
            in 0..SMALL_CINEMA_MAX_SEATS -> totalSeats * FRONT_ROW_PRICE_PER_SEAT
            else -> {
                val frontRowSeats = numOfRows / 2 * seatsPerRow
                val backRowSeats = ((numOfRows / 2 ) + ( numOfRows % 2)) * seatsPerRow
                frontRowSeats * FRONT_ROW_PRICE_PER_SEAT + backRowSeats * BACK_ROW_PRICE_PER_SEAT
            }
        }
    }

    private val menu = StringBuilder().apply {
        appendLine("1. Show the seats")
        appendLine("2. Buy a ticket")
        appendLine("3. Statistics")
        appendLine("0. Exit")
    }

    override fun run() {
        printMenu()
        val input = readln().toInt()

        when(input) {
            1 -> arrayOfSeats.print()
            2 -> buyTicket()
            3 -> printStatistics()
        }
        if (input != 0) {
            run()
        }
    }

    override fun buyTicket() {
        var row = getInput(GET_ROW_NUMBER).toInt()
        var seatNumber = getInput(GET_SEAT_NUMBER).toInt()
        println()


        var seat = arrayOfSeats.getOrNull(row - 1)?.getOrNull(seatNumber - 1)

        while (seat == null || seat == Seat.SOLD) {
            println()
            println(if (seat == null) "Wrong input!" else "That ticket has already been purchased!")
            println()
            row = getInput(GET_ROW_NUMBER).toInt()
            seatNumber = getInput(GET_SEAT_NUMBER).toInt()
            seat = arrayOfSeats.getOrNull(row - 1)?.getOrNull(seatNumber - 1)
        }

        arrayOfSeats[row - 1][seatNumber - 1] = Seat.SOLD
        soldTickets++

        val totalSeats = arrayOfSeats.first().size * arrayOfSeats.size
        val seatPrice = if (totalSeats in 0..SMALL_CINEMA_MAX_SEATS) {
            FRONT_ROW_PRICE_PER_SEAT
        } else {
            val frontRows = 0..arrayOfSeats.size / 2
            if (row in frontRows) FRONT_ROW_PRICE_PER_SEAT else BACK_ROW_PRICE_PER_SEAT
        }
        currentIncome += seatPrice
        println("Ticket price: $$seatPrice")
        println()
    }

    private fun printStatistics() {
        val percentage = currentIncome * 100.0 / totalIncome
        val formatPercentage = "%.2f".format(percentage)
        println("Number of purchased tickets: $soldTickets")
        println("Percentage: $formatPercentage%")
        println("Current income: $$currentIncome")
        println("Total income: $$totalIncome")
        println()

    }

    override fun printMenu() {
        println(menu)
    }
}

fun main() {
    CinemaManagerWithStatistics().run()
}