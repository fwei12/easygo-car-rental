## EasyGo: Car Rental Application
### Description (P1)

Name of the project  
EasyGO.    

Name of the team and names of the team members.   
Team 777. Yiwei Cheng, Feng Wei, Yufan Zou.

Brief description of the project  
EasyGo is a car rental web application which helps people book a car easily. 
EasyGo also can help admins to manage their clients and vehicles.

Description of the two user data models    
Client: keep detailed info of clients.    
Admin: keep detailed info of admins.     

Description of the three domain object data models   
Booking: keep detailed info on bookings.    
Vehicle: keep detailed info about vehicles.   
Bill: keep details info of booking bills.    

Description of the user to domain object relationship   
Client-Booking: clients can make bookings.    
Admin-Vehicle: admins can manage vehicles' data.    

Description of the domain object to domain object relationship    
Booking-Vehicle: book vehicles, booking contains which vehicles to rent.     
Booking-Bill: booking contains a bill of the booking.    

Description of the portable enumeration(s)     
The brand enumeration contains several predefined vehicle brands.    

Description of the user interface requirements    
Allow clients to browse vehicles' info and book vehicles.    
Allow admins to manage data of clients, vehicles, booings and bills.      

### Description (P3)

#### Problem statement
In the traditional car rental model, the customers must call the rental car company to rent a car. And they know very little about the car's info. For adminstrators, it's inconvient to manage the customers information and the cars statement. Especially when the companies are at large, they are in desperate need of a application to help them manage all the stuffs.

#### Solution statement
Our team developed an application for the rental company to help the customers book a car conveniently. And also the administrators can use it to manage their customers and vehicles. Our website allows clients to browse vehicles' info and book vehicles and help admins to manage data of clients, vehicles, booings and bills.   

#### Users
Client: keep detailed info of clients.    
Admin: keep detailed info of admins. 

#### Domain objects
Booking: keep detailed info on bookings.    
Vehicle: keep detailed info about vehicles.   
Bill: keep details info of booking bills.  

### Visit our Application Website: [https://easygo-cs5200.square.site/](https://easygo-cs5200.square.site/)
![img](http)
### FrontEnd: 
#### Start
- Please run **npm run serve** in terminal to start
#### Two Different users and port numbers
- admin -> BookVue-master -> Port: http://localhost:8081;
- client-> BookVue-client -> Port: http://localhost:8080
### BackEnd: 
#### Start
- Please run CarRentalApplication.java to start
#### Port number
- car_rental -> Port: http://localhost:8081
