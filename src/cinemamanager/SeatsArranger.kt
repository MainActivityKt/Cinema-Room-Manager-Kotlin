package cinemamanager

import Utils.SPACE
import Utils.TITLE


fun addRow(rowNumber: Int): String {
    return buildString {
        append(rowNumber)
        append(SPACE)
        repeat(8) {
            append("S")
            append(SPACE)
        }
    }
}

fun main(args: Array<String>) {
    println("$TITLE:")
    val cinema = buildString {
        repeat(9) {
            append(if (it > 0) it else SPACE)
            append(SPACE)
        }
        appendLine()
        for (i in 1..7) {
            appendLine(addRow(i))
        }
    }
    print(cinema)
}
