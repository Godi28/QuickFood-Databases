import java.sql.*;
import java.util.Scanner;
/** Holds method to update <code>key</code> linked
 *  records with missing information in <code>QuickFoodMS SQL database</code>
 *  
 *  @author Ogodiseng Sehoole
 *  @version 16.0.2,20-07-2021
 */
public class MissingInformationUpdate {
  /** Updates <code>key</code> linked table entries selected in
	* <code>QuickFoodMS SQL database</code> based on <code>key</code>
	* provided from user input. Handles incorrect user input and indicates number of rows 
	* affected by the update per data table. 
	*/
	public static void update() {
	    
		try {
			/* connection created to interact with server holding specified QuickFoodMS database,
			 * using necessary credentials */
	        Connection connection = DriverManager.getConnection(
		    "jdbc:sqlserver://DESKTOP-UHS24U0\\SQLEXPRESS:1433;databaseName=QuickFoodMS",
		    "Godi Sehoole",
		    "1Sambumbu#"
		    );
	       
	        /*allows scanner access to reading user input */
	        Scanner input = new Scanner(System.in);

	        // requesting user to input id 
	      	System.out.println("Please enter the id of the entry whose information"
		     	    + " you would like to update."); 
	      	
	      	/* reads number unique to each row in each table but equal in other rows in other tables
	      	 * that links rows of data records across tables. Used to reference rows
	      	 * to be updated */
		     int id = input.nextInt();
		     	
		   /*the SQL instruction executed to select records from Restaurants table to be updated in
	        * QuickFoodMS database based on id */
	     	String query1 = "UPDATE Restaurants SET Restaurant_Name = ?, Restaurant_Address = ?,"
	     	    + "Restaurant_Contact_Number = ?, Restaurant_Location = ?"
	     	    + " WHERE id = ?";
	     	
	     	//statement created to run the query
	     	PreparedStatement statement1 = connection.prepareStatement(query1);
	     	
	        // allowing scanner to read integer and string separately
	     	input.nextLine();
	     	
	        // setting corresponding column in query with user input
	     	statement1.setInt(5, id);  
	     	
	     	/* 57-59 requesting user to input restaurant name , reading user input and setting
	     	 * corresponding column in query with user input*/
	     	System.out.println("Please update the restaurant name.");
	     	String reataurantName = input.nextLine();
	     	statement1.setString(1, reataurantName);

	     	/* 63-65 requesting user to input restaurant address, reading user input and setting
	     	 * corresponding column in query with user input*/
	     	System.out.println("Please update the restaurant address.");
	     	String restaurantAddress = input.nextLine();
	     	statement1.setString(2,restaurantAddress);
	     		
	     	/* 69-71 requesting user to input restaurant contact number , reading user input and 
	     	 * setting corresponding column in query with user input*/
	     	System.out.println("Please update the restaurant contact number");  
	     	String restaurantContact = input.nextLine();  
	     	statement1.setString(3, restaurantContact);
	     		
	     	/* 75-77 requesting user to input restaurant location, reading user input and setting
	     	 * corresponding column in query with user input*/
	     	System.out.println("Please update the restaurant location");	  
	     	String restaurantLocation = input.nextLine();   
	     	statement1.setString(4, restaurantLocation);
 	     	
	     	/* a number showing the amount of rows are affected by executing statement */
	     	int rowsAffected = statement1.executeUpdate();
	     	
	     	/* statement with condition to print alert to user when no rows were affected and the
	     	 * entered id has no match*/
	     	if (rowsAffected == 0) {
	     	    System.out.println("\nThere is no matching id with the entered id in the "
	     	        + "database, please try again.\n");
	     	}
	     	/* statement with condition to print the number of affected rows after executing the
	     	 *  query when the entered id has a match*/
	        else {
	     	    System.out.println("\nQuery complete, " + rowsAffected + " rows updated.\n");	
	     	}
	     	
           /* SQL instruction executed to select records from Orders table to be updated in
	        * QuickFoodMS database based on id */
	     	String query2 = "UPDATE Orders SET Order_Placed = ?, Quantity = ?,"
	     	    + "Order_Price = ? WHERE id = ?";
	     	
	     	// statement created to run the query
	     	PreparedStatement statement2 = connection.prepareStatement(query2);
	       
	     	// setting corresponding column in query with user input
	     	statement2.setInt(4, id);
	     	  
	     	/* 107-109 requesting user to input order placed, reading user input and setting
	     	 *  corresponding column in query with user input*/
	     	System.out.println("Please update the order placed.");
	     	String orderPlaced = input.nextLine();
	     	statement2.setString(1, orderPlaced);
	     		
	     	/* 113-115 requesting user to input order quantity, reading user input and setting
	     	 *  corresponding column in query with user input*/
	     	System.out.println("Please update the order quantity."); 
	     	int quantity = input.nextInt();
	     	statement2.setInt(2,quantity);
	       
	     	// allowing scanner to read integer and string separately
	     	input.nextLine();
	     	
	     	/* 122-124 requesting user to input order price, reading user input and setting
	     	 *  corresponding column in query with user input*/
	     	System.out.println("Please update the order price.");	  
	     	String orderPrice = input.nextLine();  
	     	statement2.setString(3, orderPrice);
	     	
	     	/* a number showing the amount of rows are affected by executing statement */ 	     		
	     	int rowsAffected2 = statement2.executeUpdate();
	     	
	     	// prints the number of affected rows after executing the query
	     	System.out.println("\nQuery complete, " + rowsAffected2 + " rows updated.\n");
	     	
	     	/* SQL instruction executed to select records from TransactionDetails table to be
	     	 * updated in QuickFoodMS database based on id*/
	     	String query3 = "UPDATE TransactionDetails SET Order_Number = ?, "
	     			+ "Special_Instructions = ?, Total_Price = ? WHERE id = ?";
	     	
	     	//statement created to run the query
	     	PreparedStatement statement3 = connection.prepareStatement(query3);
	     		
	     	//setting corresponding column in query with user input
	     	statement3.setInt(4, id);
	     	 
	     	/* 145-147 requesting user to input order number, reading user input and setting
	     	 *  corresponding column in query with user input*/
	     	System.out.println("Please update the order number."); 
	     	String orderNumber = input.nextLine();  
	     	statement3.setString(1, orderNumber);
	     		  
	     	/* 151-153 requesting user to input special instructions, reading user input and
	     	 * setting corresponding column in query with user input*/
	     	System.out.println("Please update the order special instructions."); 
	     	String specialInstructions = input.nextLine();
	     	statement3.setString(2,specialInstructions);
	     		
	     	/* 157-159 requesting user to input total price, reading user input and setting
	     	 *  corresponding column in query with user input*/
	     	System.out.println("Please update the total price.");  
	     	String totalPrice = input.nextLine();  
	     	statement3.setString(3, totalPrice);
	     	
	     	/* a number showing the amount of rows are affected by executing statement */
	     	int rowsAffected3 = statement3.executeUpdate();
	     	
	     	// prints the number of affected rows after executing the query
	     	System.out.println("\nQuery complete, " + rowsAffected3 + " rows updated.\n");
	     	
	       /* SQL instruction executed to select records from Drivers table to be updated in
	        * QuickFoodMS  database based on id*/
	     	String query4 = "UPDATE Drivers SET Driver_Name = ?, Driver_Location = ?,"
	     	    + "Load = ? WHERE id = ?";  
	     	
	     	// statement created to run the query
	     	PreparedStatement statement4 = connection.prepareStatement(query4);
	     		  
	     	// setting corresponding column in query with user input
	     	statement4.setInt(4, id);
	     	 
	     	/* 180-182 requesting user to input driver name, reading user input and
	     	 * setting corresponding column in query with user input*/
	     	System.out.println("Please update the driver name.");
	     	String driverName = input.nextLine(); 
	     	statement4.setString(1, driverName);
	     		
	     	/* 186-188 requesting user to input driver location, reading user input and
	     	 * setting corresponding column in query with user input*/
	     	System.out.println("Please update the driver location.");  
	     	String driverLocation = input.nextLine();
	     	statement4.setString(2,driverLocation);
	     		
	     	/* 192-194 requesting user to input driver load, reading user input and
	     	 * setting corresponding column in query with user input*/
	     	System.out.println("Please update the driver load.");	  
	     	int load = input.nextInt();  
	     	statement4.setInt(3, load);
 	     	
	     	/* a number showing the amount of rows are affected by executing statement */
	     	int rowsAffected4 = statement4.executeUpdate();
	     	
	        // prints the number of affected rows after executing the query
	     	System.out.println("\nQuery complete, " + rowsAffected4 + " rows updated.\n");
	        
	     	// prints conclusion
	     	System.out.println("Entry updated.");
	     	
	     	//clearing environment
	     	input.close();
	     	connection.close();
	    }
	    catch (SQLException e){
	    	e.printStackTrace();
	    }    		
	}
}
