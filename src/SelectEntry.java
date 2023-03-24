import java.sql.*;
import java.util.Scanner;
/** Holds methods that select and print <code>key</code> a 
 * single linked table entry from <code>SQL database</code>
 * 
 * @author Ogodiseng Sehoole
 * @version 16.0.2,20-07-2021 
 */
public class SelectEntry {
  /** Selects <code>key</code> linked table entries based on <code>customerName</code>
    * user input and prints the entry by calling <code>printEntry</code> method
    * from <code>Printer</code> class.
	*/
	public static void enterName()  {
		
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
		
		    /* SQL instruction executed to select a key linked record in QuickFoodMS database based
		     * on the user entered on customer name*/
	        String query ="SELECT Customer_Name, Customer_Address, Email, "
	        	+ "Customer_Contact_Number,"
			    + " Customer_Location, Restaurant_Name, Restaurant_Address,"
			    + " Restaurant_Contact_Number, Restaurant_Location, Order_Placed, Quantity, "
			    + "Order_Price, Order_Number, Special_Instructions, Total_Price, Driver_Name, "
			    + "Driver_Location, Load FROM Customers FULL JOIN Restaurants "
			    + " ON Customers.id=Restaurants.id FULL JOIN Orders ON Customers.id = Orders.id"
			    + " FULL JOIN TransactionDetails ON Customers.id = TransactionDetails.id "
			    + "FULL JOIN Drivers ON Customers.id = Drivers.id Where Customer_name = ? ";
 
	        // statement created to run the query
	        PreparedStatement statement = connection.prepareStatement(query);
	        
	        /* 47-50 requesting user to input customer name , reading user input and setting
	     	 *  corresponding column in query with user input*/
	        System.out.println("Please enter the customer name of the entry you would like"
	        		+ " to select");   
		    String customerName = input.nextLine();     
		    statement.setString(1, customerName);
		    
		    /* stores the executed query action as ResultSet */
		    ResultSet result = statement.executeQuery();

		    // statement with condition for when ResultSet has next result
		    if (result.next()) {	
		      // calling printEntry method from Printer to print data contained in ResultSet
              Printer.printEntry(result);
		   }	
		   /* statement for when ResultSet is empty and entered customer name does not match any
		    * name in the Customers table*/ 
		   else {
			   // prints conclusion
			    System.out.println("Customer with entered name not found.");
		   }	
		    // clearing environment
		    input.close();
		    result.close();
		    connection.close();
	    }		
		catch (SQLException e){
		    	e.printStackTrace();
		}    
	}
  /** Selects <code>key</code> linked table entry based on <code>orderNumber</code>
	* user input and prints the entry by calling <code>printEntry</code>method
	* from <code>Printer</code> class. Handles incorrect user input.
	*/
    public static void enterOrderNumber() {
	   
    	try {
    		/* SQL instruction executed to select a key linked record in QuickFoodMS database based
		     * the user entered on customer name*/
		     Connection connection = DriverManager.getConnection(
		        "jdbc:sqlserver://DESKTOP-UHS24U0\\SQLEXPRESS:1433;databaseName=QuickFoodMS",
		        "Godi Sehoole",
		        "1Sambumbu#"
		     );
		
		     /*allows scanner access to reading user input */
		     Scanner input = new Scanner(System.in);
		
		    /* SQL instruction executed to select a key linked record in QuickFoodMS database based 
		     * on the user entered on customer name*/
	         String query ="SELECT * FROM Customers FULL JOIN Restaurants "
			     + " ON Customers.id=Restaurants.id FULL JOIN Orders ON Customers.id = Orders.id"
			     + " FULL JOIN TransactionDetails ON Customers.id = TransactionDetails.id "
			     + "FULL JOIN Drivers ON Customers.id = Drivers.id Where Order_Number = ? ";   
	         
	         // statement created to run the query
	         PreparedStatement statement = connection.prepareStatement(query);    
	         
	        /* 107-110 requesting user to input order number , reading user input and setting
		     * corresponding column in query with user input*/
	         System.out.println("Please enter the order number of the entry you would like to"
	         		+ " select");  
		     String orderNumber = input.nextLine();     
		     statement.setString(1, orderNumber);

		    /* stores the executed query action as ResultSet*/
	         ResultSet result = statement.executeQuery();
		
	         // statement with condition for the ResultSet has next result
		     if (result.next()) {	
		    	// calling printEntry method from Printer to print data contained in ResultSet 
		       Printer.printEntry(result);		 
		    }
		   /* statement for when ResultSet is empty and entered order number does not match any
			* name in the Customers table*/
		    else {
		    	// prints conclusion
			    System.out.println("Order Number entered not found.");
		    }	
		     // clearing environment
		     result.close();
		     input.close();
		     connection.close();
        }    
	    catch (SQLException e){
	    	e.printStackTrace();
	    }    
    }
}