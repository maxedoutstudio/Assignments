package ass3;

public class FederalTax extends Deductions {

	//The limits for the tax brackets
	private final double LIMIT_1 = 43953;
	private final double LIMIT_2 = 87907;
	private final double LIMIT_3 = 136271;

	//The tax rates

	private final double RATE_1 = 0.15;
	private final double RATE_2 = 0.22;
	private final double RATE_3 = 0.26;
	private final double RATE_4 = 0.29;


	public FederalTax(Employee employee){
		super(employee);
		calculateTax();
	}

	public void calculateTax(){
		double salary = super.getSalary();
		double tax = 0;
		
		if(salary > LIMIT_3){
			tax += (salary-LIMIT_3)*RATE_4;
			salary = LIMIT_3;
		}
		
		if(salary > LIMIT_2){
			tax += (salary-LIMIT_2)*RATE_3;
			salary = LIMIT_2;
		}
		
		if(salary > LIMIT_1){
			tax += (salary-LIMIT_1)*RATE_2;
			salary = LIMIT_1;
		}
		 
		tax += (salary)*RATE_1;
		
		super.setTax(tax);
	}
}
