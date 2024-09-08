package cinemamanager

import Utils.GET_NUM_OF_SEATS
import Utils.TXT_GET_NUM_OF_ROWS
import Utils.getInput

const val BACK_ROW_PRICE_PER_SEAT = 8
const val FRONT_ROW_PRICE_PER_SEAT = 10
const val SMALL_CINEMA_MAX_SEATS = 60

fun calculateProfits(numOfRows: Int, seatsPerRow: Int) {
    // A simple functions that calculates and prints the profits, based on number of seats
    val totalSeats = numOfRows * seatsPerRow
    val totalPrice = when(totalSeats) {
        in 0..SMALL_CINEMA_MAX_SEATS -> totalSeats * FRONT_ROW_PRICE_PER_SEAT
        else -> {
            val frontRowSeats = numOfRows / 2 * seatsPerRow
            val backRowSeats = ((numOfRows / 2 ) + ( numOfRows % 2)) * seatsPerRow
            frontRowSeats * FRONT_ROW_PRICE_PER_SEAT + backRowSeats * BACK_ROW_PRICE_PER_SEAT
        }
    }
    println("Total income:")
    println("$$totalPrice")
}

fun main() {
    val rows = getInput(TXT_GET_NUM_OF_ROWS).toInt()
    val seatsPerRow = getInput(GET_NUM_OF_SEATS).toInt()
    calculateProfits(rows, seatsPerRow)
}