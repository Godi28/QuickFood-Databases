import java.sql.*;
/** Holds methods to print different table data from 
 *  <code>QuickFoodMS SQL database</code>
 *  
 *  @author Ogodiseng Sehoole
 *  @version 16.0.2,20-07-2021
 */
public class Printer {
  /** Prints table data in <code>QuickFoodMS SQL database</code> from <code>Customers table</code>
    * 
    * @param statement a statement from an instance to run <code>query</code> that
    *        is used in printing that particular instance.
    */
	public static void printCustomers(Statement statement){
	    
		try {	
			/* stores ResultSet for SQL instruction executed using the statement that's passed as
			 * an argument. Query selects records from Customers table in QuickFoodMS database */
    	    ResultSet result = statement.executeQuery("SELECT id, Customer_Name, Customer_Address"
    		+ ",Customer_Contact_Number, Email,Customer_Location FROM Customers");
    	   
    	    // prints names of Customers table columns
    	    System.out.println("Customer Information(Name, Address, Email, Number, Location):\n");
    	    // statement to print values of selected columns while ResultSet has next result
            while (result.next()) {	
		        System.out.println(result.getString("Customer_Name") + ","
                    + result.getString("Customer_Address") + ", " + result.getString("Email")
                    + ", " + result.getString("Customer_Contact_Number") + ", " 
                    + result.getString("Customer_Location"));
		    }    
            // clearing ResultSet
            result.close();
	    }    
	    catch (SQLException e){
	    	e.printStackTrace();
	    } 
	}    
  /** Prints all <code>key</code> linked table entries in <code>QuickFoodMS SQL database</code>
    * 
    * @param result the result from executing the <code>query</code> from a given instance used 
    *        to print that given <code>ResultSet</code>.
    */	
    public static void printEntry(ResultSet result){ 
	    
		try {	
			    /* prints all key linked values from all columns selected in QuickFoodMS 
			     * database for a ResultSet used in the method as an argument*/
                System.out.println(
                    "Customer Information(Name, Address, Email, Number, Location):\n"                   
      			     +result.getString("Customer_Name") + "," 
                     + result.getString("Customer_Address") + ", " +result.getString("Email") 
                     + "," + result.getString("Customer_Contact_Number") 
      				 + ", " + result.getString("Customer_Location")
      				 + "\n\nRestaurant Information(Name, Address, Number, Location):\n " 
      				 + result.getString("Restaurant_Name") + ", "
      				 + result.getString("Restaurant_Address") + ", "
      				 + result.getString("Restaurant_Contact_Number") + ", "
      				 + result.getString("Restaurant_Location") 
      				 + "\n\nOrder Information(Order Placed, Quantity, Order Price):\n " 
      				 + result.getString("Order_Placed") + ", "
      				 + result.getInt("Quantity") + ", " + result.getString("Order_Price") 
      				 +"\n\nTransaction Information(Order Number, "
      				 + "Special Instructions, Total Price):"
      				 + "\n"
      				 + result.getString("Order_Number") + ", "  
      				 + result.getString("Special_Instructions") + ", " 
      				 + result.getString("Total_Price") 
      				 + "\n\nDriver Information(Name, Location, Load):\n " 
      				 + result.getString("Driver_Name") + ", " + result.getString("Driver_Location")
      				 + ", " + result.getString("Load"));		    
	    }    
	    catch (SQLException e){
	    	e.printStackTrace();
	    } 
	}
  /** Prints all View table data in <code>QuickFoodMS SQL database</code>
    * @param result the result from executing the <code>query</code> from a given instance used 
    *        to print that given <code>ResultSet</code>
    */
    public static void printView(ResultSet result){
		
		try {
			 /* statement to print values, for a ResultSet used in the method as an argument, of
			  * selected columns while ResultSet has next result*/
			 while (result.next()) {
		         System.out.println("Invoice created(Customer Name,Email,Contact Number,"
		             + "Total Order Price(R))");
		    	 System.out.println(result.getString("Customer_Name") + ","
		             + result.getString("Email") + ", " 
		    		 + result.getString("Customer_Contact_Number")+ ", " 
		             + result.getString("Total_Price"));
	         }	
		}
		catch (SQLException e){
		    	e.printStackTrace();
		}
	}
}
