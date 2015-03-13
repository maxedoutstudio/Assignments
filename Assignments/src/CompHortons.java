/* Assignment #1 CompHortons
 * Author: Maksym Perepichka
 * Date: 20 September 2014  */

import java.util.Scanner;

public class CompHortons {

	public static void main(String[] args) {
		// This initiates the cost constants for the sizes incase the company wants to modify prices:
		final int extraSmall = 124, small = 178, medium = 233, large = 299;
		// Takes care of the input from user by asking for price of beverage and payment amount in cents
		Scanner myKeyboard = new Scanner(System.in);
		System.out.println("Enter the price of your beverage (in cents):");
		int price = myKeyboard.nextInt();
		
		/* Instructions weren't too clear on whether or not a price check is required. I made one just in case. If not
		 * required, I have set up the program in a way that simply commenting out the following set of if statements will
		 * remove this restriction.
		 */
		
		boolean invalidPrice = false;
		
		if (price == extraSmall){
			System.out.println("You have ordered a Extra Small coffee");
		}
		else if (price == small){
			System.out.println("You have ordered a Small coffee");
		}
		else if (price == medium){
			System.out.println("You have ordered a Medium coffee");
		}
		else if (price == large){
			System.out.println("You have ordered a Large coffee");
		} else {
			System.out.println("No drinking costing " + price + "¢ exists. Availible sizes are:");
			System.out.println("Extra Small: " + extraSmall + "¢");
			System.out.println("Small: " + small + "¢");
			System.out.println("Medium: " + medium + "¢");
			System.out.println("Large: " + large + "¢");
			invalidPrice = true;
		} //Comment out until here if you wish to remove restrictions
		
		
		//This if statement is rigged in a way to make the program still work if you wish to remove the restrictions on price of coffee
		if (invalidPrice == false){
			
		
			System.out.println("Enter your payment amount in cents:");
			int payAmount = myKeyboard.nextInt();
			
			
			/* This part initiates the values of the change returned to zero and
			 also calculates the value of the total change to be returned in cents */
			
			int tens = 0, fives = 0, toonies = 0, loonies = 0, quarters = 0, dimes = 0, nickels = 0, pennies = 0;
			int change = payAmount - price;
			
			/*This while loop detects what the highest denomination of money to be returned is and
			 * and adds 1 to the value of the denomination. This process is repeated until no change
			 * is left to be given to the user. */
			 
			while(change > 0) {
				if ((change - 1000) >= 0){
					change -= 1000;
					tens++;
				}
				else if ((change - 500) >= 0){
					change -= 500;
					fives++;
				}
				else if ((change - 200) >= 0){
					change -= 200;
					toonies++;
				}
				else if ((change - 100) >= 0){
					change -= 100;
					loonies++;
				}
				else if ((change - 25) >= 0){
					change -= 25;
					quarters++;
				}
				else if ((change - 10) >= 0){
					change -= 10;
					dimes++;
				}
				else if ((change - 5) >= 0){
					change -= 5;
					nickels++;
				}
				else if ((change - 1) >= 0){
					change -= 1;
					pennies++;		
				}
			}
			
			//This final part simply prints the change for the user
	
			System.out.println("You bought a beverage for " + price + "¢ using " + payAmount + "¢, therefore your change is:");
			System.out.println(tens + " Ten(s)");
			System.out.println(fives + " Five(s)");
			System.out.println(toonies + " Toonies(s)");
			System.out.println(loonies + " Loonies(s)");
			System.out.println(quarters + " Quarters(s)");
			System.out.println(dimes + " Dimes(s)");
			System.out.println(nickels + " Nickel(s)");
			System.out.println(pennies + " Penny(ies)");
			
		
		}
	}

}
