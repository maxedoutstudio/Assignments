package ass3;

import java.util.*;
import java.io.FileInputStream;
import java.io.IOException;


public class Driver {
	
	public static void main(String[] args){
		//Creates the array of employee class
		
		ArrayList <Employee> employees = new ArrayList();
	
		//Reads each employee from file
		Scanner in = null; 
		
		try{
			
			in = new Scanner(new FileInputStream("payroll.txt"));
			
			int lineCounter = 0;
			
			while(in.hasNextLine()){
				int number = in.nextInt();
				String firstName = in.next();
				String lastName = in.next();
				double hoursWorked = in.nextDouble();
				double hourlyWage = in.nextDouble();
				Employee temp = new Employee(number,firstName,lastName,hoursWorked,hourlyWage);
				System.out.println(temp);
				employees.add(temp);
			}
			
			
			
		} catch(IOException e) {
			System.out.println("Fail");
		} catch(IllegalArgumentException e){
			
		}	
			/* catch(MinimumWageException e){
		
			
			
		} */
		
		
		for(int i = 0;i < employees.size();i++){
			System.out.println(employees.get(i));
		}
		
		
		
	}
	
	//Writes to error file
	public static void writeError(Employee employee){
		
		
	}


}
