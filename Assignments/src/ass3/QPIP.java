package ass3;

public class QPIP extends Deductions{
	
	private final double RATE = 0.00559;
	
	private final double MAX_RATE = 385.71;

	public QPIP(Employee employee){
		super(employee);
		calculateTax();
	}
	
	public void calculateTax(){
		double salary = super.getSalary();
		double tax = (RATE)*(salary);
		
		if(tax > MAX_RATE){
			super.setTax(MAX_RATE);
		} else {
			super.setTax(tax);
		}
		
	}
	
}
