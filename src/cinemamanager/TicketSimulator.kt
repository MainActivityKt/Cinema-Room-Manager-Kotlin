package cinemamanager

import Utils.BACK_ROW_PRICE_PER_SEAT
import Utils.FRONT_ROW_PRICE_PER_SEAT
import Utils.GET_ROW_NUMBER
import Utils.GET_SEAT_NUMBER
import Utils.SMALL_CINEMA_MAX_SEATS
import Utils.TXT_GET_NUM_OF_SEATS
import Utils.TXT_GET_NUM_OF_ROWS
import Utils.getInput
import Utils.print
import Utils.Seat


class TicketSimulator {
    private lateinit var arrayOfSeats: Array<Array<Seat>>

    fun start() {
        initializeSeats()
        arrayOfSeats.print()
        sellSeat()
        arrayOfSeats.print()
    }

    private fun initializeSeats() {
        val rows = getInput(TXT_GET_NUM_OF_ROWS).toInt()
        val seatsPerRow = getInput(TXT_GET_NUM_OF_SEATS).toInt()
        arrayOfSeats = Array(rows) { Array(seatsPerRow) { Seat.AVAILABLE } }
        println()
    }



    private fun sellSeat() {
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
    TicketSimulator().start()
}