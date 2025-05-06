# JavaBnb
Simulation of a booking holiday acomodation application
There will be a login and registration to three different type of users: admins, clients and hosts; each one with different functions and access.
The application was made with Swing graphics.
For admins:
 - Consult users: list of all registerd users in the application and all of their information, reservations, etc.
 - Consult estate: list off all houses and apartments with its info.
 - Consult all reservvations ordered by date

For particular clients:
- Search estate: entering a city, dates of arriving and leaving, ordered by price, type of state or calification. When a house or apartment is selected and reserved, it proceed to simulate a paycheck and calculates the total price from counting the number of nights and the house's rate. VIP clients will have 10% discount.
  Then it will automatically generate a .txt bill with all the details and save all data in the application.
- Score a state with a punctuation from 1 to 5 (stars) and a comment
- Consult reservations
- Modify personal data

For hosts:
- Create new state (including image loading)
- Modify state info
- Modify personal info
- Consult reservation
- Be a Superhost if the media from all of their houses and reviews are more than a 4

It uses a serialization in files for the data storage in the application. 
