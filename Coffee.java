
public class Coffee extends Beverage {
	private boolean extraShot;
	private boolean extraSyrup;
	private final double SHOT_COST = .5;
	private final double SYRUP_COST = .5;

	// constructor
	public Coffee(String n, SIZE s, boolean shot, boolean syrup) {
		super(n, TYPE.COFFEE, s);
		extraShot = shot;
		extraSyrup = syrup;
	}

	// setters and getters
	public boolean getExtraShot() {
		return extraShot;
	}

	public void setExtraShot(boolean extraShot) {
		this.extraShot = extraShot;
	}

	public boolean getExtraSyrup() {
		return extraSyrup;
	}

	public void setExtraSyrup(boolean extraSyrup) {
		this.extraSyrup = extraSyrup;
	}

	public double getSHOT_COST() {
		return SHOT_COST;
	}

	public double getSYRUP_COST() {
		return SYRUP_COST;
	}

	// utility
	public String toString() {
		String s = getBevName() + ", " + getSize();
		if (extraShot) {
			s += "Extra shot";
		}
		if (extraSyrup) {
			s += ", $" + calcPrice();
		}
		return s;
	}

	public double calcPrice() {
		double price = super.getBasePrice();
		if (super.getSize() == SIZE.MEDIUM) {
			price += super.getSizePrice();
		} else if (super.getSize() == SIZE.LARGE) {
			price += 2 * super.getSizePrice();
		}
		if (extraShot) {
			price += SHOT_COST;
		}
		if (extraSyrup) {
			price += SYRUP_COST;
		}
		return price;
	}

	public boolean equals(Coffee c) {
		if (super.equals(c) && extraShot == c.getExtraShot() && extraSyrup == c.getExtraSyrup()) {
			return true;
		} else {
			return false;
		}
	}

}
