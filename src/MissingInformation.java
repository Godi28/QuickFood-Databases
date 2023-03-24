import java.sql.*;
/** Holds method to find missing information in 
 * <code>QuickFoodMS SQL database</code>
 * 
 * @author Ogodiseng Sehoole
 * @version 16.0.2,20-07-2021 
 */
public class MissingInformation {
  /** Finds records in linked tables of <code>QuickFoodMS SQL database</code> that are missing information
    * and prints them by calling <code>printEntry</code> method from <code> Printer</code> class.
    * Alerts user when there is no missing information then calls <code>create</code> method
    * from <code>Invoice</code> class to create invoices.
	*/
	public static void find()  {
		
		try {
			/* connection created to interact with server holding specified QuickFoodMS database,
			 * using necessary credentials */
		    Connection connection = DriverManager.getConnection(
		       "jdbc:sqlserver://DESKTOP-UHS24U0\\SQLEXPRESS:1433;databaseName=QuickFoodMS",
		       "Godi Sehoole",
		       "1Sambumbu#"
		    );
		    
		   /* the SQL instruction executed to select key linked records with missing data
			* in QuickFoodMS database*/	
	        String query ="SELECT * FROM Customers FULL JOIN Restaurants "
	         	+ "ON Customers.id = Restaurants.id FULL JOIN Orders "
	         	+ "ON Customers.id = Orders.id FULL JOIN TransactionDetails"
	         	+ " ON Customers.id = TransactionDetails.id FULL JOIN Drivers"
	         	+ " ON Customers.id = Drivers.id Where Order_Number IS NULL "
	         	+ "OR Restaurant_Name IS NULL OR Restaurant_Address IS NULL "
	         	+ "OR Restaurant_Contact_Number IS NULL OR Restaurant_Location IS NULL "
	         	+ "OR Order_Placed IS NULL OR Quantity IS NULL OR Order_Price IS NULL "
	         	+ "OR Order_Number IS NULL OR Special_Instructions IS NULL "
	         	+ "OR Total_Price IS NULL OR Driver_Name IS NULL OR Driver_Location IS NULL "
	         	+ "OR Drivers.Load IS NULL";	
	        
	        //statement created to run the query
		    Statement statement = connection.createStatement();
		    
		    /* result stores the executed query action as ResultSet */
	        ResultSet result = statement.executeQuery(query);
	        
	        // statement with condition for the ResultSet has next result
		    if (result.next()) {
		     // calling printView method from Printer to print data contained in ResultSet
		     Printer.printEntry(result);
		        // statement with condition for while ResultSet has next result
		        while (result.next()) {
		        	  /* calling printView method from Printer to print data contained 
	            	   * in ResultSet*/
			         Printer.printEntry(result);
		         }
		    }
		    /* statement for when ResultSet is empty and no missing information is found on the 
		     * database*/
		    else {
		    	// prints conclusion.
			    System.out.println("There is no missing information in the data base. "
			    	 + "Project is finalised.Creating Invoices");
			    //calls create method from Invoice to create invoices
			    Invoice.create();
		    }
		    // clearing environment
		    connection.close();
		    result.close();
		}		
		catch (SQLException e){
		    	e.printStackTrace();
		} 
	}
}
