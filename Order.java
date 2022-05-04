import java.util.ArrayList; 
import java.util.Random; 
public class Order implements OrderInterface, Comparable <Order> {
	//Fields 
	private int orderNo;
	private int orderTime;
	private DAY orderDay;
	private Customer customer;
	private ArrayList<Beverage> beverages;
	
	//constructors 
	public Order(int ot,DAY od, Customer c) {
		orderNo = genOrderNum();
		orderTime =ot;
		orderDay = od;
		customer = c ;
		beverages =new ArrayList<>();
		
	}
	//setters and getters 
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public int getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(int orderTime) {
		this.orderTime = orderTime;
	}
	public DAY getOrderDay() {
		return orderDay;
	}
	public void setOrderDay(DAY orderDay) {
		this.orderDay = orderDay;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public ArrayList<Beverage> getBeverages() {
		return beverages;
	}
	public void setBeverages(ArrayList<Beverage> beverages) {
		this.beverages = beverages;
	}
	//utility 
	public int genOrderNum() {
		Random rand= new Random();
		//[10_000;90_000)
		int randInt =rand.nextInt(90_000-10_000)+10_000;
		return randInt;
	}
	public String toString() {
		String s = "__________________________________________"
				+ orderDay.toString()+ ", "+orderTime+"\n"
				+ customer.toString()+"Order Num: "+ orderNo;
		for(Beverage b: beverages) {
			s+= "\n" +b.toString();
		}
		s+= "\n Orden Total: "+calcOrderTotal();
		return s;
	}
	@Override
	public boolean isWeekend() {
		if(orderDay == DAY.SATURDAY|| orderDay == DAY.SUNDAY) {
			return true; 
		}
		return false; 
	}
	@Override
	public Beverage getBeverage (int itemNum) {
		return beverages.get(itemNum);
	}
	@Override
	public int compareTo(Order o) {
		if (orderNo == o.getOrderNo()) {
			return 0; 
		}
		else if (orderNo > o.getOrderNo()) {
			return 1;
		}
		else {
		return -1;
		}
	}
	public int getTotalItems() {
		return beverages.size();
	}
	@Override
	public double calcOrderTotal() {
		double orderTotal = 0; 
		for (Beverage b: beverages) {
			orderTotal+= b.calcPrice();
		}
		return orderTotal;
	}
	@Override
	public int findNumOfBeveType(TYPE type) {
		int count = 0;
		for (Beverage b: beverages) {
			if (b.getType()==type) {
				count++;
			}
		}
		return count;
	}
	
	//add Beverages
	@Override
	public void addNewBeverage(String bevname, SIZE size, boolean extraShot, boolean extraSyrup) {
		Coffee c= new Coffee(bevname,size,extraShot,extraSyrup);
		beverages.add(c);
	}

	@Override
	public void addNewBeverage(String bevName, SIZE size) {
		boolean isWeekend=false; 
		if(orderDay == DAY.SATURDAY|| orderDay ==DAY.SUNDAY)
		{
			isWeekend=true;
		}
		Alcohol a = new Alcohol(bevName, size, isWeekend );
		beverages.add(a);
		
	}

	@Override
	public void addNewBeverage(String bevName, SIZE size, int numOfFruits, boolean addPRotien) {
		Smoothie s =new Smoothie (bevName, size, numOfFruits,addPRotien);
		beverages.add(s);
		
	}



}
