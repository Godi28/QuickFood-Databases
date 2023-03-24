import java.sql.*;
import java.util.Scanner;
/** Holds method to insert new data into
 *  <code>Customers table</code> in <code>QuickFoodMS SQL database</code>
 *  
 *  @author Ogodiseng Sehoole
 *  @version 16.0.2,20-07-2021
 */
public class NewCustomerInsert {
  /** Inserts table entry into
	* <code>QuickFoodMS SQL database</code> and indicates number of rows affected by the insert.
	*/
	public static void enter()  {
		
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
 
		    /*SQL instruction executed to insert data into Customers table in QuickFoodMS database*/
			String query = "INSERT INTO Customers (id, Customer_Name, Customer_Address, Email,"
					+ " Customer_Contact_Number, Customer_Location) VALUES (?,?,?,?,?,?)";
			
			// statement to run the query
			PreparedStatement statement = connection.prepareStatement(query,
					Statement.RETURN_GENERATED_KEYS);
			   
			/* 39-41 requesting user to input customer id, reading user input and setting
	     	 * corresponding column in query with user input*/
		    System.out.println("Please enter the new customer id of the new entry");
			int customerID = input.nextInt();     
			statement.setInt(1, customerID);

			// allowing scanner to read integer and string separately
			input.nextLine();
		   
			/* 48-50 requesting user to input customer name, reading user input and setting
	     	 *  corresponding column in query with user input*/
			System.out.println("Please enter the new customer name of the new entry");
			String customerName = input.nextLine();     
			statement.setString(2, customerName);
			
			/* 54-56 requesting user to input customer address, reading user input and setting
	     	 *  corresponding column in query with user input*/
			System.out.println("Please enter the new customer address of the new entry");  
			String customerAddress = input.nextLine();   
			statement.setString(3, customerAddress);
			  
			/* 60-62 requesting user to input customer email, reading user input and setting
	     	 *  corresponding column in query with user input*/
			System.out.println("Please enter the new customer email of the new entry");   
			String customerEmail = input.nextLine();   
		    statement.setString(4, customerEmail); 
		    
		    /* 66-68 requesting user to input customer contact number, reading user input and 
		     * setting corresponding column in query with user input*/
		    System.out.println("Please enter the customer contact number of the new entry");   
			String customerContact = input.nextLine(); 
		    statement.setString(5, customerContact); 
		    
		    /* 72-74 requesting user to input customer location, reading user input and setting
	     	 *  corresponding column in query with user input*/
		    System.out.println("Please enter the new customer location of the new entry");   
			String customerLocation = input.nextLine(); 
		    statement.setString(6, customerLocation); 

		    /* a number showing the amount of rows are affected by executing statement */
		    int rowsAffected = statement.executeUpdate();   
		    
		    // prints the number of affected rows after executing the query
		    System.out.println("\n Query complete, " + rowsAffected + " rows updated.");
		     
		    /* creating different statement that's used when calling printCustomer method from 
		     * Printer class*/
		    Statement stmnt = connection.createStatement();
		    
		    //calling printCustomer method from Printer class
		    Printer.printCustomers(stmnt);
		    
		    // closing scanner
		    input.close();
		}
		catch (SQLException e){
		    	e.printStackTrace();
		}
	}
}
