package ass3;

public class Employee {

	//Given data
	private long number;
	private String firstName;
	private String lastName;
	private double hoursWorked;
	private double hourlyWage;
	
	//Calculated data
	private double weeklyGrossSalary;
	private double annualGrossSalary;
	
	
	public Employee(long number,String firstName,String lastName,double hoursWorked,double hourlyWage){
		
		this.number = number;
		this.firstName = firstName;
		this.lastName = lastName;
		this.hoursWorked = hoursWorked;
		this.hourlyWage = hourlyWage;
		
		weeklyGrossSalary = (hoursWorked)*(hourlyWage);
		annualGrossSalary = 52*(weeklyGrossSalary);
		

		
	}
	
	
	
	public String toString(){
		return (number + " " + firstName + " " + lastName + " " + hoursWorked + " " + hourlyWage);
	}
	
}
