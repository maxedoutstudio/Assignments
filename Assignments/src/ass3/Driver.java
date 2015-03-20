package ass3;

import java.util.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;


public class Driver {
	//Creates the array of employee class
	public static Employee[] employees = new Employee[0];
	
	//Creates the array to store taxes for each employee
	
	public static double[] taxes;
	
	//Defines minimum wage for employee
	
	public static final double MIN_WAGE = 10.35;
	
	public static void main(String[] args){
		
		//TEMP REMOVE AFTER: Resets error file for each run
		PrintWriter out = null;
		try{
		out = new PrintWriter(new FileOutputStream("payrollError.txt"));
		out.print("");
		} catch(FileNotFoundException e) {
		}
		out.close();
		
		//END OF TEMP SECTION
		
	
		//Reads each employee from file, then stores them in employee array
		readFile();
		
		//Calculates tax for each employee
		
		calculateDeductions();
		
		

		
		
		for(int i = 0;i < employees.length;i++){
			System.out.println(employees[i] + " " + taxes[i]);
		}
		
		
		
	}
	
	
	//Adds employee to Array of employees
	
	public static void addEmployee(Employee employee){
		Employee[] temp = new Employee[employees.length+1];
		for(int i = 0;i<employees.length;i++){
			temp[i] = new Employee(employees[i]);
		}
		temp[employees.length] = new Employee(employee);
		employees = temp;
	}

	//Updates employee arraylist with data from file
	public static void readFile(){
		Scanner in = null; 
		try{

			in = new Scanner(new FileInputStream("payroll.txt"));

			while(in.hasNextLine()){
				//Second try block that attempts to read correct info from file
				String[] parts = in.nextLine().split(" ");
				try{
					/*We need to read the line and then split it since we need to have access to the whole line in String format in the
					 * event that the line throws an error and we need to output it into the error file. 
					 * Here is what each index corresponds to:
					 * 0 : number
					 * 1 : firstName
					 * 2 : lastName
					 * 3 : hoursWorked
					 * 4 : hourlyWage
					 */
					
					//Checks for min. wage exception
					if(Double.parseDouble(parts[4]) < MIN_WAGE)
						throw new MinimumWageException();
					Employee temp = new Employee(Integer.parseInt(parts[0]),parts[1],parts[2],Double.parseDouble(parts[3]),Double.parseDouble(parts[4]));
					System.out.println(temp); //Temporary, remove after
					addEmployee(temp);
					
				//Catches illegal arguments
				} catch(IllegalArgumentException e){
					writeError(sumParts(parts));
				} catch(InputMismatchException e){
					writeError(sumParts(parts));
				} catch(NoSuchElementException e){
					/*For the case that the last line is empty but java still detects it as a new line.
					 * Nothing needs to be done in this case, but we must still catch the exception. */
					
				}catch(MinimumWageException e){
					writeError(sumParts(parts));
				} 
			}

		} catch(IOException e) {
			System.out.println("Error: Failure opening file.");

		}
		
		


	}

	//Writes to error file
	public static void writeError(String employeeInfo){
		PrintWriter out = null;
		try{
			out = new PrintWriter(new FileOutputStream("payrollError.txt",true));
			out.println(employeeInfo);
			out.close();
		} catch(FileNotFoundException e) {
			System.out.println("Error opening payrollError.txt");
			System.exit(0);
		}
	}
	
	//Used to sum up parts for error outputting 
	public static String sumParts(String[] parts){
		String total = " ";
		for(int i = 0;i<parts.length;i++){
			total += parts[i] + " ";
		}
		return total;
	}
	
	//Calculates deductions for each employee
	public static void calculateDeductions(){
		
		//Makes the taxes array the same length as the employees array
		
		taxes = new double[employees.length];
		
		for(int i = 0;i<employees.length;i++){
			double totalTax = 0;
			
			Deductions[] tax = new Deductions[5];
			
			tax[0] = new ProvincialTax(employees[i]);
			tax[1] = new FederalTax(employees[i]);
			tax[2] = new EI(employees[i]);
			tax[3] = new QPIP(employees[i]);
			tax[4] = new RRQ(employees[i]);
			
			for(int c = 0;c<tax.length;c++){
				totalTax += tax[c].getTax();
			}
			
			taxes[i] = totalTax;
		}
	}
	
	


}
