import java.sql.*;
import java.util.Scanner;
/** Holds method to update <code>Customers table</code>
 *  data in <code>QuickFoodMS SQL database</code>
 *  
 *  @author Ogodiseng Sehoole
 *  @version 16.0.2,20-07-2021
 */
public class CustomerDetailsUpdate {
  /** Updates table entries selected in
	* <code>QuickFoodMS SQL database</code> based on user inputed <code>key</code>. 
	* Handles incorrect user input and indicates number of rows affected by the update.
	* Calls method <code>printCustomer</code> from <code>Printer</code> class to print the updated 
	* table data.
	*/
	public static void update()  {
		
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
            
            /* the SQL instruction executed to select records from Customers table to be updated 
             * in QuickFoodMS database based on inputed customer id */
	     	String query = "UPDATE Customers SET Customer_Name = ?, Customer_Address = ?,"
	     	    + " Email = ?, Customer_Contact_Number = ?, Customer_Location = ?"
	     	    + " WHERE id = ?";
	     	
	     	/* PreparedStatement created to run query*/
	     	PreparedStatement statement = connection.prepareStatement(query);
            
	     	// prints request for user to enter customer id matching id in Customers table
	     	System.out.println("Please enter the customer id of the customer whose information"
	     	    + " you would like to update.");
	     	
	     	/* inputed row referencing number unique to each row in Customers table used to
	     	 *  select the row to update.*/
	     	int customerID = input.nextInt();
	     	
	     	// setting corresponding column in query with user input
	     	statement.setInt(6, customerID);

	     	// allowing scanner to read integer and string separately
	     	input.nextLine();
	     	
	        // prints request for user to enter customer name	 
	     	System.out.println("Please update the customer name.");
	     	
	     	/* reading user inputed name used to update Customer_Name column based
	     	 *  on customerID */
	     	String customerName = input.nextLine(); 
	        
	     	// setting corresponding column in query with user input
	     	statement.setString(1, customerName);
	     	
	        // prints request for user to enter customer address
	     	System.out.println("Please update the customer address.");
	     	
	     	/* reading user inputed address used to update Customer_Address column based on
	     	 * customerID */
            String customerAddress = input.nextLine(); 
            
            // setting corresponding column in query with user input
	     	statement.setString(2,customerAddress);
	     	
	        // prints request for user to enter customer email    
	        System.out.println("Please update the customer email");	  
	        
	        /* reading user inputed address used to update Email column based on customerID */
	     	String customerEmail = input.nextLine(); 
	     	
	     	// setting corresponding column in query with user input
	     	statement.setString(3, customerEmail);
	     	
	        // prints request for user to enter customer contact number
	     	System.out.println("Please update the customer contact number");  
	     	
	     	/* reading user inputed number used to update Customer_Contact_Number column
	     	 * based on customerID */
	     	String customerContact = input.nextLine(); 
	     	
	        // setting corresponding column in query with user input
	     	statement.setString(4, customerContact);
	     		
	     	
	        // prints request for user to enter customer location
	     	System.out.println("Please update the customer location");
	     	
	     	/* reading user inputed location used to update Customer_Location column based 
	     	 * on customerID */
	     	String customerLocation = input.nextLine();  
	     	
	     	// setting corresponding column in query with user input
	     	statement.setString(5, customerLocation);
	     			     		
	     	/* a number showing the amount of rows are affected by executing
	         * statement */
	     	int rowsAffected = statement.executeUpdate();
	     	
	     	/* statement with condition to print alert to user when no rows were affected and
	     	 * the entered id has no match*/ 
	     	if (rowsAffected == 0) {
	     	// prints conclusion
	     	System.out.println("\nThere is no matching customer with the entered id in the "
	     	    + "database, please try again.\n");
	     	}
	     	/* statement with condition to print the number of affected rows and call 
	     	 * method printCustomer from Printer class to print the updated 
	     	 * table when the entered id has a match**/
	        else {
	        	// prints affected rows
	     	    System.out.println("\nQuery complete, " + rowsAffected + " rows updated.\n");
	     	    // creating different statement to use as an argument to call printCustomers method
	     	    Statement stmnt = connection.createStatement();	   
	     	    // calling printCustomers method from Printer class to print Customers table data
	     	    Printer.printCustomers(stmnt);
	     	}
	     	// closing scanner
	     	input.close();
		}
	    catch (SQLException e){
	 	    	e.printStackTrace();
	 	}
	}
}
