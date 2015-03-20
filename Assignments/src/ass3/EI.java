package ass3;

public class EI extends Deductions {
	
	private final double RATE = 1.53;
	
	private final double MAX_RATE = 743.58;

	public EI(Employee employee){
		super(employee);
		calculateTax();
	}
	
	public void calculateTax(){
		double salary = super.getSalary();
		double tax = ((int)salary/100)*RATE;
		if(tax > MAX_RATE){
			super.setTax(MAX_RATE);
		} else {
			super.setTax(tax);
		}
	}
}
