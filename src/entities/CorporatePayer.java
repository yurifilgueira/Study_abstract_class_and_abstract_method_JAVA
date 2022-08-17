package entities;

public class CorporatePayer extends TaxPayer{
	
	private Integer numbEmployees;

	public CorporatePayer(String name, Double anualIncome, Integer numbEmployees) {
		super(name, anualIncome);
		this.numbEmployees = numbEmployees;
	}

	public Integer getNumbEmployees() {
		return numbEmployees;
	}

	public void setNumbEmployees(Integer numbEmployees) {
		this.numbEmployees = numbEmployees;
	}
	
	@Override
	public final double taxValue() {
		if (getNumbEmployees() <= 10) {
			return (getAnualIncome() * 0.16);
		}
		else {
			return (getAnualIncome() * 0.14);
		}
	}

}
