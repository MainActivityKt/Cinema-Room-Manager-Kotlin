# Cinema Room Manager

Cinema has been a part of the entertainment industry for
a long time: a good movie is a way to escape reality and live through a variety of emotions.
The best cinema experience you can get is probably in a cinema theatre. In this project,
our program will be able to help manage a
cinema theatre: sell tickets, check available seats, see sales statistics, and more.

## Stage 1/5: Arrangement
In this stage, a simple cinema room of fixed number of rows and seats per row, is created. 

Running the program will output a title and an arrangement of the cinema room. 

Stage implementation: [SeatsArranger.kt](src/cinemamanager/SeatsArranger.kt)

**Example:** 

    Cinema:
    1 2 3 4 5 6 7 8
    1 S S S S S S S S
    2 S S S S S S S S
    3 S S S S S S S S
    4 S S S S S S S S
    5 S S S S S S S S
    6 S S S S S S S S
    7 S S S S S S S S

## Stage 2/5: Sold!

In this stage, two positive integers are read from input, the number of rows, and the number of seats per row.

Then, the program calculates profits by adding the price of each seat. The price of a seat is calculated as follows:

* If the total number of seats in the screen room is not more than `60`, then the price of each ticket is `10` dollars.
* In a larger room, the tickets are `10` dollars for the front half of the rows and `8` dollars for the back half.
* `Front half row = number of rows / 2` (integer division)
* `Back half row = number of rows / 2` + `remainder` (if any)

Stage implementation: [ProfitsCalculator.kt](src/cinemamanager/ProfitsCalculator.kt)

**Example 1:**

    Enter the number of rows:
    > 8
    Enter the number of seats in each row:
    > 9
    Total income:
    $648

**Example 2:**

    Enter the number of rows:
    > 4
    Enter the number of seats in each row:
    > 5
    Total income:
    $200

## Stage 3/5: Tickets

This stage puts two previous stages together. Two positive integers representing number of rows, and 
number of seats per row, are read from the input.

A cinema room arrangement is created and printed out based on those values. 
Then, two positive integers representing the row number and column number of a seat are read
from the input, which simulates selling the ticket for that seat.

That specific seat is sold, and the ticket price is determined by the same rules as the previous stage and printed to the console. 

The modified cinema room arrangement is printed, lastly. Note that the letter `S` represents an available
seat, and the letter `B` represents an unavailable (sold out) seat.

Stage implementation: [TicketSimulator.kt](src/cinemamanager/TicketSimulator.kt)

**Example:** 

    Enter the number of rows:
    > 7
    Enter the number of seats in each row:
    > 8
    
    Cinema:
    1 2 3 4 5 6 7 8
    1 S S S S S S S S
    2 S S S S S S S S
    3 S S S S S S S S
    4 S S S S S S S S
    5 S S S S S S S S
    6 S S S S S S S S
    7 S S S S S S S S
    
    Enter a row number:
    > 3
    Enter a seat number in that row:
    > 6
    
    Ticket price: $10
    
    Cinema:
    1 2 3 4 5 6 7 8
    1 S S S S S S S S
    2 S S S S S S S S
    3 S S S S S B S S
    4 S S S S S S S S
    5 S S S S S S S S
    6 S S S S S S S S
    7 S S S S S S S S

## Stage 4/5: Menu, please!
Now, our program runs in a loop and prints a menu on each iteration, from which the user can
choose any of the following actions: Buying a ticket, or showing the current seats arrangement

The user can exit out of the program by choosing the exit option from the menu.

Stage implementation: [CinemaManager.kt](src/cinemamanager/CinemaManager.kt)

**Example:**

    Enter the number of rows:
    > 7
    Enter the number of seats in each row:
    > 7
    
    1. Show the seats
    2. Buy a ticket
    0. Exit
    > 1
    
    Cinema:
    1 2 3 4 5 6 7
    1 S S S S S S S
    2 S S S S S S S
    3 S S S S S S S
    4 S S S S S S S
    5 S S S S S S S
    6 S S S S S S S
    7 S S S S S S S
    
    1. Show the seats
    2. Buy a ticket
    0. Exit
    > 2
    
    Enter a row number:
    > 4
    Enter a seat number in that row:
    > 5
    Ticket price: $10
    
    1. Show the seats
    2. Buy a ticket
    0. Exit
    > 1
    
    Cinema:
    1 2 3 4 5 6 7
    1 S S S S S S S
    2 S S S S S S S
    3 S S S S S S S
    4 S S S S B S S
    5 S S S S S S S
    6 S S S S S S S
    7 S S S S S S S
    
    1. Show the seats
    2. Buy a ticket
    0. Exit
    > 2
    
    Enter a row number:
    > 6
    Enter a seat number in that row:
    > 6
    Ticket price: $10
    
    1. Show the seats
    2. Buy a ticket
    0. Exit
    > 1
    
    Cinema:
    1 2 3 4 5 6 7
    1 S S S S S S S
    2 S S S S S S S
    3 S S S S S S S
    4 S S S S B S S
    5 S S S S S S S
    6 S S S S S B S
    7 S S S S S S S
    
    1. Show the seats
    2. Buy a ticket
    0. Exit
    > 0

## Stage 5/5: Errors!

In this stage:

- A new option is added to the menu, which prints the current statistics. It contains 
calculations such the number of sold tickets, current income which is the sum of the sold 
tickets' prices, and the total income that shows how much money the theatre will get
if all the tickets are sold.
- The buying ticket function can now handle some errors such as inputting the wrong seat coordinates, and
trying to buy an already sold out seat, and gives feedback to the user. 

Because this stage is build upon the last stage, inheritance is used, the modified behaviours 
are overridden and the new function(s) are added.

Stage implementation: [CinemaManagerWithStatistics.kt](src/cinemamanager/CinemaManagerWithStatistics.kt)

**Example:**
    Enter the number of rows:
    > 6
    Enter the number of seats in each row:
    > 6
    
    1. Show the seats
    2. Buy a ticket
    3. Statistics
    0. Exit
    > 3
    
    Number of purchased tickets: 0
    Percentage: 0.00%
    Current income: $0
    Total income: $360
    
    1. Show the seats
    2. Buy a ticket
    3. Statistics
    0. Exit
    > 2
    
    Enter a row number:
    > 1
    Enter a seat number in that row:
    > 1
    
    Ticket price: $10
    
    1. Show the seats
    2. Buy a ticket
    3. Statistics
    0. Exit
    > 3
    
    Number of purchased tickets: 1
    Percentage: 2.78%
    Current income: $10
    Total income: $360
    
    1. Show the seats
    2. Buy a ticket
    3. Statistics
    0. Exit
    > 2
    
    Enter a row number:
    > 1
    Enter a seat number in that row:
    > 1
    
    That ticket has already been purchased!
    
    Enter a row number:
    > 10
    Enter a seat number in that row:
    > 20
    
    Wrong input!
    
    Enter a row number:
    > 4
    Enter a seat number in that row:
    > 4
    
    Ticket price: $10
    
    1. Show the seats
    2. Buy a ticket
    3. Statistics
    0. Exit
    > 1
    
    Cinema:
    1 2 3 4 5 6
    1 B S S S S S
    2 S S S S S S
    3 S S S S S S
    4 S S S B S S
    5 S S S S S S
    6 S S S S S S
    
    1. Show the seats
    2. Buy a ticket
    3. Statistics
    0. Exit
    > 3
    
    Number of purchased tickets: 2
    Percentage: 5.56%
    Current income: $20
    Total income: $360
    
    1. Show the seats
    2. Buy a ticket
    3. Statistics
    0. Exit
    > 0
