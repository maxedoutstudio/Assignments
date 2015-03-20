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
	
	//Copy constructor
	public Employee(Employee other){
		number = other.number;
		firstName = other.firstName;
		lastName = other.lastName;
		hoursWorked = other.hoursWorked;
		hourlyWage = other.hourlyWage;
		
		weeklyGrossSalary = (hoursWorked)*(hourlyWage);
		annualGrossSalary = 52*(weeklyGrossSalary);
	}
	
	
	
	
	//Getters and Setters
	
	public long getNumber() {
		return number;
	}



	public void setNumber(long number) {
		this.number = number;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}




	public String getLastName() {
		return lastName;
	}




	public void setLastName(String lastName) {
		this.lastName = lastName;
	}




	public double getHoursWorked() {
		return hoursWorked;
	}




	public void setHoursWorked(double hoursWorked) {
		this.hoursWorked = hoursWorked;
	}




	public double getHourlyWage() {
		return hourlyWage;
	}




	public void setHourlyWage(double hourlyWage) {
		this.hourlyWage = hourlyWage;
	}




	public double getWeeklyGrossSalary() {
		return weeklyGrossSalary;
	}




	public void setWeeklyGrossSalary(double weeklyGrossSalary) {
		this.weeklyGrossSalary = weeklyGrossSalary;
	}




	public double getAnnualGrossSalary() {
		return annualGrossSalary;
	}




	public void setAnnualGrossSalary(double annualGrossSalary) {
		this.annualGrossSalary = annualGrossSalary;
	}




	public String toString(){
		return (number + " " + firstName + " " + lastName + " " + hoursWorked + " " + hourlyWage);
	}
	
}
