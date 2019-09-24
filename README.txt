
README
-------------------------
Name: Darshan Patil
email id: patild@usc.edu
-----------------------------------------------------------------------------------------------------------
Airline-Reservation-System
-----------------------------------------------------------------------------------------------------------
Database Tables:
- Create a schema called test_db and import the 3 tables;
- FlightsDetails.sql
- login.sql
- N1Flight.sql

FlightsDetails.sql:  Stores Flight details such as  FlightNumber,Departure Airport,Arrival Airport,Departure Time, Arrival Time,Price(Economy),Price(First Class),Date, Available Seats(Foreign key linked to N1Flight.sql)

login.sql: Stores username, password for admin and users authentication

Example for Flight Number: N1 --> N1Flight.sql table is created, similarly each flight has its own table for seat allocation
N1Flight.sql: stores flight seat allocation details such as seat number, Type(E->Economy,F->First Class), Availability(X->Reserved,O->Open for booking), AllocatedUser
----------------------------------------------------------------------------------------------------------
Instructions:
- Start MySQL server
- Please check JDBC is installed
- Note down SQL Server HostName (localhost),Port Number(3306), Username(root), Password
- Create Schema named test_db in Database
- Import Tables: FlightsDetails.sql, login.sql, N1Flight.sql
- Compile the java Program and run
- Compile cmd: javac Login.java Flights.java
- run cmd: java Login
----------------------------------------------------------------------------------------------------------
Program Flow
- run cmd: java Login
- enter hostname(localhost),port number(3306),database schema name(test_db), username(root), password
- If successfully connected to database you'll receive a message "Successfully connected to Database!"
- Main Menu has 4 option, Select
	- Admin: to Enter in administration mode (default username:admin, password: admin Stored in login.sql)
	- User: to Enter in user mode to book flights
	- display all available flights stored in FlightsDetails.sql
	- Exit the System
- Admin Mode
	- Login (username: admin, password: admin)
	- Insert Flight Details: Admin can enter the new flight details
		- Insert Flight Details such as FlightNumber,Departure Airport, Arrival Airport, Departure Time, Arrival Time,Price(Economy),Price(First Class),Date, Available Seats
	- Use 11/11/2019 for booking date for demo purpose
	- Search Flight to Book: Search the flight and do booking for customer
	- Display all Available Flights: Displays available flights for particular source and destination on required date
	- Display Seats(For Demo purpose type--> N1): Displays Seats in N1 flight (Similarily can be implemented for all flights)
- User Mode
	- Register: enter username and password which gets stored in login.sql database
	- use the username and password which you registered to login
	- Display all Available Flights
	- Use 11/11/2019 for booking date for demo purpose
	- Search the Flight by entering source and destionation and date
	- Enter the number of seats, and required available seat number (X->Reserved, O->open for booking)
	- Enter User Details
	- Get the Confirmation with bill
------------------------------------------------------------------------------------------------------------
Algorithm Output: Please refer to screenshots attached.
