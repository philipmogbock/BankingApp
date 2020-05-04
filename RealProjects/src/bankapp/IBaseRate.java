package bankapp;

public interface IBaseRate {
	
	public final double baseRate=2.5;
	
	
	
	//method that returns the base rate
	
	public default double getBaseRate() {
		return baseRate;
	}

}
