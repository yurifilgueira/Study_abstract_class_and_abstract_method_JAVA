package entities;

public class IndividualPayer extends TaxPayer {

	private Double healthCosts;

	public IndividualPayer(String name, Double anualIncome, Double healthCosts) {
		super(name, anualIncome);
        this.healthCosts= healthCosts;
	}
	
	public Double getHealthCosts() {
		return healthCosts;
	}

	public void setHealthCosts(Double healthCosts) {
		this.healthCosts = healthCosts;
	}

	@Override
	public final double taxValue() {
		if (getAnualIncome() <= 20000) {
			return (getAnualIncome() * 0.15) - (healthCosts * 0.50); 
		}
		else {
			return (getAnualIncome() * 0.25) - (healthCosts * 0.50);
		}
		
	}

}
