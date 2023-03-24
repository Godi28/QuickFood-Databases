import java.util.Scanner;
/** Holds method to drive program
 * 
 * @author Ogodiseng Sehoole
 * @version 16.0.2,20-07-2021 
 */
public class Main {
  /** Drives program by calling methods ,based on instructed user input, to interact 
   *  with <code>QuickFoodMS SQL database</code>. This method handles incorrect user input.
   * 
   * @param args default parameter for method
   */
   public static void main(String args[]) {
       /* Allows scanner access to reading user input */
	   Scanner input = new Scanner(System.in);
	   
	   /* Prints out program instructions to users*/
	   System.out.println("Please enter the number 1 to select an entry using the customer's name."
	   		+ " \nPlease enter the number 2 to select an entry using the order number."
	   		+ "\nPlease enter the number 3 to add a new customer to the database."
	   		+ "\nPlease enter the number 4 to update existing customer details in the database."
	   		+ "\nPlease enter the number 5 to check for missing information in the database or "
	   		+ "to check if QuickFood Project is finalised and create Invoices."
	   		+ "\nPlease enter the number 6 to update missing entry information."); 
	   
	   /* reads user input that decides which method will be called to interact
	      with QuickFoodMS SQL database*/
	   int choice = input.nextInt();
	   
	   /* The first 6 statements are used to call the respective methods to execute the
	      respective functions represented by user inputed numbers.
	      Method calls are made when their conditions are true and their conditions are based on 
	      the user inputed number.The last statement alerts the user when an invalid number 
	      is entered.*/ 
	   if (choice == 1) {
	       SelectEntry.enterName();
       }
       else if (choice == 2) {
	       SelectEntry.enterOrderNumber();
       }
       else if(choice == 3) {
	       NewCustomerInsert.enter();
        }
       else if(choice == 4) {
	       CustomerDetailsUpdate.update();
       }
       else if(choice == 5) {
	       MissingInformation.find();
       }	   
       else if(choice == 6) {
    	   MissingInformationUpdate.update();    
       }
       else {
	       System.out.println("You have not entered a valid number, Please try again.");
       }	 
	   // closing scanner
       input.close(); 
  }     	
}

