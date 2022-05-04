
public class Alcohol extends Beverage{
	private Boolean isWeekend;
	private final double WEEKEND_FEE =.6;
	//costructors
	public Alcohol (String n, SIZE s, Boolean iw) {
		super(n,TYPE.ALCOHOL,s);
		isWeekend = iw;
	}
	//Utility 
	public String toString() {
		String s = getBevName () +", "+ getSize();
		if (isWeekend) {
			s+="Weekend";
		}
		s+= ", $" +calcPrice();
		return s;
	}
	
	public boolean equals(Alcohol a) {
		if (super.equals(a)&& isWeekend == a.getIsWeekend()) {
			return true; 
		}
		else {
			return false; 
		}
	}
	public double calcPrice() {
			double price = super.getBasePrice();
			if(super.getSize() == SIZE.MEDIUM) {
				price += super.getSizePrice();
			}
			else if (super.getSize() == SIZE.LARGE) {
				price += 2*super.getSizePrice();
			}
			if(isWeekend) {
				price+=WEEKEND_FEE;
			}
			return price;
		}
	//setters and getters
	public Boolean getIsWeekend() {
		return isWeekend;
	}
	public void setIsWeekend(Boolean isWeekend) {
		this.isWeekend = isWeekend;
	}
	public double getWEEKEND_FEE() {
		return WEEKEND_FEE;
	}
	
}
