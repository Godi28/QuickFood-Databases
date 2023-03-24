# QuickFood
## Description
The project is an SQL database management project which simulates data management for the process of customers ordering food from restaurants. The process data is stored and managed in 5 related data tables on an SQL server namely Customers, Restaurants, Orders, TransactionDetails and Drivers. Once the tables are created and stored on a database on a SQL server,the project uses JDBC to interact with server in order to execute different queries that read and write data to and from the database.

## Installation
Create a QuickFood database on SQL server with data tables named as mentioned in the description and configure using a method of your choice. 
### Guidelines SSMS(SQL Server Management Studio)
1.Create Customers Table with the following columns and data types then enter any row data relevant to the column names and data types. Make sure to set the id column as the principal key.

![CustomersTable-Create](https://user-images.githubusercontent.com/88197915/144790458-eb820cf9-2331-4b46-abcb-f55a0e8ed720.PNG)
![CustomersTable-Insert](https://user-images.githubusercontent.com/88197915/144790519-4c8a7c4f-fbb7-4097-94bc-3c1592b25c1f.PNG)

2.Create Restaurant Table with the following columns and data types then enter any row data relevant to the column names and data types. Make sure to set Restaurants table id column as the principle key then add a key based relationship making the Restaurants Table id column a foreign key to The Customers Table's principle key set earlier therby creating a one-to-one relationship.   

![RestaurantsTable-Create](https://user-images.githubusercontent.com/88197915/144791660-1328d35d-a20f-4479-aa90-eb9b3b7e2f86.PNG)
![RestaurantsTable-Insert](https://user-images.githubusercontent.com/88197915/144791692-804fe36b-53e9-4d4c-994b-6d48760f24c2.PNG)
![Customer to Restauarnt key relationship](https://user-images.githubusercontent.com/88197915/144791747-92952343-d9c0-4a4c-8a97-8d717d9f10e6.PNG)

3.Create Orders Table with the following columns and data types then enter any row data relevant to the column names and data types. Make sure to set Orders Table id column as the principle key then add key based relationships making the Orders Table id column a foreign key to both Customers and Restaurants Tables' principle keys.

![OrdersTable-Create](https://user-images.githubusercontent.com/88197915/144793750-babfbb76-fbd5-4db5-aacb-0929c667522f.PNG)
![OrderTable-Insert](https://user-images.githubusercontent.com/88197915/144793796-5b2633df-52ca-41fa-b867-f9f215fba6b6.PNG)
![Restaurant to Orders key relationship](https://user-images.githubusercontent.com/88197915/144793835-bd9821e2-0502-4fa4-9ba8-1030fe8b4b2a.PNG)
![Customer to Order key relationship](https://user-images.githubusercontent.com/88197915/144793870-60d64c9c-9354-43ef-8176-07bb36d8b2d5.PNG)

4.Create TransactionDetails Table with the following columns and data types then enter any row data relevant to the column names and data types. Make sure to set TransactionDetails Table id column as the principle key then add key based relationships making the TransactionDetails Table id column a foreign key to Customers, Restaurants and Orders Tables' principle keys.

![TransactionDetailsTable-Create](https://user-images.githubusercontent.com/88197915/144794178-d66ac150-5309-468f-937b-f85863dd51fb.PNG)
![TransactionDetailsTable-Insert](https://user-images.githubusercontent.com/88197915/144794208-408e0d85-e466-4b7e-ba2c-13d9baa6750b.PNG)
![Order to TransactionDetails key relationship](https://user-images.githubusercontent.com/88197915/144794248-b2a097bd-e40f-4c74-bbf5-715305705d4e.PNG)
![Restaurant to TrasnactionDeatails key realtionship](https://user-images.githubusercontent.com/88197915/144794266-5005d47e-d3f9-465c-bb1a-11e0ba7e28f1.PNG)
![Customer to TrasnactionDetails key relationship](https://user-images.githubusercontent.com/88197915/144794323-a4ab11ed-8006-4fb3-8043-935e17407529.PNG)

5.Create Drivers Table with the following columns and data types then enter any row data relevant to the column names and data types. Make sure to set Drivers table id column as the principle key then add key based relationships making the Drivers table id column a foreign key to Customers, Restaurants, Orders and TransactionDetails Tables' principle keys.

![DriversTable-Create](https://user-images.githubusercontent.com/88197915/144794655-857a05f8-f1f9-4c61-9c37-0f2244504578.PNG)
![DriversTable-Insert](https://user-images.githubusercontent.com/88197915/144794677-666729bb-67a6-4661-b28f-0f4738a2ef46.PNG)
![TransactionDetails to Driver key relationship](https://user-images.githubusercontent.com/88197915/144794698-ab20074d-8e66-4745-a395-15c65b1a8134.PNG)
![Order to Drivers key relationship](https://user-images.githubusercontent.com/88197915/144794733-ce29ba25-660f-49fd-a45a-e3aae0251de7.PNG)
![Restaurant to Driver key relationship](https://user-images.githubusercontent.com/88197915/144794752-f364dabb-5428-4111-b146-fa6753620fba.PNG)
![Customers to Drivers key relationship](https://user-images.githubusercontent.com/88197915/144794799-aced9b04-5fae-4c45-8eaa-2339283336d1.PNG)

_NOTE: Enter the same id values as Customers Table in Restaurants,Orders,TransactionDetails and Drivers Tables to make it easier to track corresponding data._

6.Finally create a TRIGGER on Customers Table's id column so when a new id value is entered for Customers Table it is also entered into the other 4 Tables' id values and order the TRIGGER so it complies with the key relationship constraints.

![RestaurantTable-Trigger](https://user-images.githubusercontent.com/88197915/144795654-d23b4564-6b6c-4c14-b6e4-3912218f2e09.PNG)
![OrdersTable-Trigger](https://user-images.githubusercontent.com/88197915/144795675-506b7a38-7403-4b62-95bd-ead783791f65.PNG)
![TransactionDetailsTable-Trigger](https://user-images.githubusercontent.com/88197915/144795694-a6710773-c72b-442b-aa24-07824d8e7c0e.PNG)
![DriversTable-Trigger](https://user-images.githubusercontent.com/88197915/144795723-20bf6b9e-e322-42ab-a717-64717ee3a140.PNG)
![trigger-order](https://user-images.githubusercontent.com/88197915/144795744-082a5d7b-3c42-42fa-a664-9a6c4935daf5.PNG)


## Usage
1. Open Java project (Database - QuickFoodMS) and change the string text in the variable (connection) to details matching the SQL server on which you created the database in all the classes except Main and Printer and compile.

![CONNECTION](https://user-images.githubusercontent.com/88197915/144799592-a03d395d-cf56-4e6f-a79b-406f8c134e0e.PNG)

2. As per on screen instructions :

* Enter the number 1 to select a linked entry using the customer's name. 
* Enter the number 2 to select a linked entry using the order number.
* Enter the number 3 to add a new customer to the database.
* Enter the number 4 to update existing customer details in the database.
* Enter the number 5 to check for missing information in the database or to check if QuickFood Project is finalised and create Invoices.
* Enter the number 6 to update missing entry information.

3. Follow the follow-up instructions to implement the respective queries.

**Project maintained and designed by : Ogodiseng Sehoole**
 
**For help or any inquiries contact Ogodiseng Sehoole at godisehoole@hotmail.com** 
