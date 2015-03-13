/* Assignment #1 CompHortons
 * Author: Maksym Perepichka
 * Date: 20 September 2014  */

//Imports the Scanner needed to get data from the user
import java.util.Scanner;

public class CustomizedBeverageSizing {

	public static void main(String[] args) {
		
		Scanner myKeyboard = new Scanner(System.in);
		System.out.println("Welcome to CompHortons, please input your height in inches:");
		int height = myKeyboard.nextInt();
		int cupUnits = 0;
		
		//This part calculates the cup size based on user's height input
		if (height <= 60) {
			 /*We divide the height by twelve to get the height in feet and multiply by ten 
			since the ratio between height in feet and units is 1 to 10 between 0 and 5 feet */
			cupUnits = ((height/12)*10);
		} else {
			/*We substract 60 to only calculate the units for the the height above 5 feet (60 inches), then
			 * we divide by 12 to convert to feet and then we multiply by 8 since the ratio between feet and 
			 * units above 5 ft is 1 to 8. Finally, we add 50 since that is the amount of units we get from 
			 * the 5ft that we did not yet account for*/
			cupUnits += ((((height-60)/12.0)*8) + 50);
		}
		
		
		//This part determines which size to give the customer and then outputs it.
		if (cupUnits <= 25){
			System.out.println("Based on your height, your beverage size is Extra Small. Enjoy your drink!");
		}
		else if ((cupUnits > 25) && (cupUnits <= 50)){
			System.out.println("Based on your height, your beverage size is Small. Enjoy your drink!");
		}
		else if ((cupUnits > 50) && (cupUnits <= 75)){
			System.out.println("Based on your height, your beverage size is Medium. Enjoy your drink!");
		}	
		else if (cupUnits > 75){
			System.out.println("Based on your height, your beverage size is Large. Enjoy your drink!");
		}	
			


		
	}

}
