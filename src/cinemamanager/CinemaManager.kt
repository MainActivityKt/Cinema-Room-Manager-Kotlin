package cinemamanager

import Utils.BACK_ROW_PRICE_PER_SEAT
import Utils.FRONT_ROW_PRICE_PER_SEAT
import Utils.GET_ROW_NUMBER
import Utils.GET_SEAT_NUMBER
import Utils.SMALL_CINEMA_MAX_SEATS
import Utils.TXT_GET_NUM_OF_ROWS
import Utils.TXT_GET_NUM_OF_SEATS
import Utils.getInput
import Utils.Seat
import Utils.print


class CinemaManager {
    private var arrayOfSeats: Array<Array<Seat>>

    private val menu = StringBuilder().apply {
        appendLine("1. Show the seats")
        appendLine("2. Buy a ticket")
        appendLine("0. Exit")
    }

    init {
        val rows = getInput(TXT_GET_NUM_OF_ROWS).toInt()
        val seatsPerRow = getInput(TXT_GET_NUM_OF_SEATS).toInt()
        arrayOfSeats = Array(rows) { Array(seatsPerRow) { Seat.AVAILABLE } }
        println()
    }

    fun run() {
        printMenu()
        val input = readln().toInt()

        when(input) {
            1 -> arrayOfSeats.print()
            2 -> buyTicket()
        }
        if (input != 0) {
            run()
        }
    }

    private fun printMenu() {
        println(menu)
    }

    private fun buyTicket() {
        val row = getInput(GET_ROW_NUMBER).toInt()
        val seat = getInput(GET_SEAT_NUMBER).toInt()
        println()
        arrayOfSeats[row - 1][seat - 1] = Seat.SOLD

        val totalSeats = arrayOfSeats.first().size * arrayOfSeats.size
        val seatPrice = if (totalSeats in 0..SMALL_CINEMA_MAX_SEATS) {
            FRONT_ROW_PRICE_PER_SEAT
        } else {
            val frontRows = 0..arrayOfSeats.size / 2
            if (row in frontRows) FRONT_ROW_PRICE_PER_SEAT else BACK_ROW_PRICE_PER_SEAT
        }
        println("Ticket price: $$seatPrice")
        println()
    }
}

fun main() {
    CinemaManager().run()
}