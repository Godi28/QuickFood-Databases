import java.sql.*;
/** Holds method to create <code>database view </code> for all 
 *  corresponding entries with no missing data in <code>QuickFoodMS SQL database</code>
 *  
 *  @author Ogodiseng Sehoole
 *  @version 16.0.2,20-07-2021 
 */
public class Invoice {
  /** Creates <code>database view</code> called
    * <code>Customer_Invoice</code> using specific columns and data
    * from <code>Customer table</code> and <code>TrasnactionDetails table</code> as its own
    * based on <code>key</code> linked table entries with no missing information selected in
	* <code>QuickFoodMS SQL database</code>. Calls method <code>printView</code> 
	* from <code>Printer</code> class to print created view. 
    */
    public static void create()  {
		
	    try {
	    	/* connection created to interact with server holding specified QuickFoodMS database,
			 * using necessary credentials */
		    Connection connection = DriverManager.getConnection(
		    		"jdbc:sqlserver://DESKTOP-UHS24U0\\SQLEXPRESS:1433;databaseName=QuickFoodMS",
			        "Godi Sehoole",
			        "1Sambumbu#"
		     );
			
		    /* the SQL instruction executed to create a view using columns Customer_Name ,
		     * Customer_Contact_Number, Email,Total_Price from Customers table and
		     * TransactionDetails table as its own columns where key linked entries from all
		     * tables have no information missing in.*/
	        String query = "CREATE VIEW Customer_Invoice AS SELECT Customer_Name, Email,"
	        	+ "Customer_Contact_Number, Total_Price FROM Customers"
	        	+ " FULL JOIN Restaurants ON Customers.id = Restaurants.id FULL JOIN Orders"
	        	+ " ON Customers.id = Orders.id FULL JOIN TransactionDetails "
	        	+ "ON Customers.id = TransactionDetails.id FULL JOIN Drivers "
	        	+ "ON Customers.id = Drivers.id Where Order_Number IS NOT NULL "
	        	+ "OR Restaurant_Name IS NOT NULL OR Restaurant_Address IS NOT NULL "
	            + "OR Restaurant_Contact_Number IS NOT NULL OR Restaurant_Location IS NOT NULL "
	            + "OR Order_Placed IS NOT NULL OR Quantity IS NOT NULL OR Order_Price IS NOT NULL "
	            + "OR Order_Number IS NOT NULL OR Special_Instructions IS NOT NULL "
	            + "OR Total_Price IS NOT NULL OR Driver_Name IS NOT NULL "
	            + "OR Driver_Location IS NOT NULL OR Drivers.Load IS NOT NULL";
					 
	         // created to run query
	         Statement statement = connection.createStatement(); 
	         // executing the query
             statement.executeUpdate(query);

             /* stores executed query action for selecting the newly created columns from
             Customers_Invoice table as a ResultSet*/
	         ResultSet result = statement.executeQuery("SELECT Customer_Name,"
	         	  + "Customer_Contact_Number, Email,Total_Price FROM Customer_Invoice");
	         
	         // statement with condition for the ResultSet has next result
	         if (result.next()) {	
	        	 // calling printView method from Printer to print data contained in ResultSet
	              Printer.printView(result);
	              // statement with condition for while ResultSet has next result
	              while(result.next()) {
	            	  /* calling printView method from Printer to print data contained 
	            	   * in ResultSet*/
	            	  Printer.printView(result);
	              }
	         }
	         // clearing environment
	         result.close();
	         connection.close();
		}	    
		catch (SQLException e){
	    	e.printStackTrace();
	    }
    }
}
