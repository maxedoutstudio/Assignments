package ass3;

public class RRQ extends Deductions{
	
	private final double RATE = 0.05175;
	
	private final double MAX_RATE = 2535.75;

	
	public RRQ(Employee employee){
		super(employee);
		calculateTax();
	}
	
	public void calculateTax(){
		double salary = super.getSalary();
		double tax = (salary)*(RATE);
		if(tax > MAX_RATE){
			super.setTax(MAX_RATE);
		} else {
			super.setTax(tax);
		}
		
	}
}
