package ass3;

public abstract class Deductions  {
	
	private Employee employee;
	private double tax;
	
	public Deductions(Employee employee){
		this.employee = new Employee(employee);
	}
	
	
	protected double getSalary(){
		return employee.getAnnualGrossSalary();
	}
	
	protected void setTax(double tax){
		this.tax = tax;
	}
	
	public double getTax(){
		return tax;
	}
	
	public abstract void calculateTax();
	
}
