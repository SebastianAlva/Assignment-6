import java.util.ArrayList;
public class BevShop implements BevShopInterface{

	private int numOfAlcoholInOrder; 
	private int curentOrderIndex; 
	private ArrayList<Order> Orders; 
	
	public BevShop() {
		Orders = new ArrayList<>();
	}
	public String toString() {
		String s = "Monthly Orders\n";
		for (Order o: Orders) {
			s+= o.toString();
		}
		s += "Total Sale: " + totalMonthlySale();
		return s;
	}
	public  boolean validTime (int time) {
		if (time >= MIN_TIME && time <= MAX_TIME) {
			return true; 
		}
		return false; 
	}
	@Override
	public boolean validAge(int age) {
		if(age > MIN_AGE_FOR_ALCOHOL) {
			return true;
		}
		return false;
	}
	public boolean eligibleForMore() {
		if(numOfAlcoholInOrder < 3) {
			return true ; 
		}
		return false;
	}
	public boolean isMaxFruit (int num) {
		if (num > MAX_FRUIT) {
			return true; 
		}
		return false; 
	}
	public void startNewOrder(int time, DAY day, String customerName, int customerAge) {
		Customer customer = new Customer (customerName, customerAge);
		Order order = new Order (time, day,customer);
		Orders .add(order);
		curentOrderIndex = Orders.indexOf(order);
		numOfAlcoholInOrder =0; 
	}
	@Override
	public void processCoffeeOrder(String bevname, SIZE size, boolean extraShot, boolean extraSyrup) {
		Orders.get(curentOrderIndex).addNewBeverage(bevname, size,extraShot,extraSyrup);
		
		
	}
	@Override
	public void processSmoothieOrder(String bevName, SIZE size, int numOfFruits, boolean addProtien) {
		Orders.get(curentOrderIndex).addNewBeverage(bevName, size,numOfFruits,addProtien);

	}
	@Override
	public void processAlcoholOrder(String bevname, SIZE size) {
		Orders.get(curentOrderIndex).addNewBeverage(bevname, size);
		
	}
	@Override
	public double totalMonthlySale() {
		double totalSale = 0 ; 
		for(Order o : Orders) {
			for(Beverage b : o.getBeverages())
			{
				totalSale +=b.calcPrice();
			}
		}
		return totalSale;
	}
	@Override
	public Order getOrderAtIndex(int index) {
		return Orders.get(index);
	}
	@Override
	public int findOrder(int orderNo) {
		for(int i=0 ; i<Orders.size();i++)
		{
			if(Orders.get(i).getOrderNo()== orderNo)
			{
				return i ;
			}
		}
		return -1;
	}
	@Override
	public void sortOrders() {
		for (int i = 0; i <Orders.size()-1;i++) {
			int minOrderNumIndex = i; 
			for(int j = i+1; j <Orders.size();j++) {
				if(Orders.get(j).getOrderNo()<Orders.get(minOrderNumIndex).getOrderNo()) {
					minOrderNumIndex = j;
				}
			}
			Order temp = Orders.get(minOrderNumIndex);
			Orders.set(minOrderNumIndex, Orders.get(i));
			Orders.set(i, temp);
		}
	}	
	public double totalOrderPrice(int orderNo) {
		double orderSale= 0 ;
		for (Order o :Orders) {
			if(o.getOrderNo()==orderNo) {
				for(Beverage b:o.getBeverages()) {
					orderSale+=b.calcPrice();
				}
			}
		}
		return orderSale;
	}
	public int totalNumOfMonthlyOrders() {
		return Orders.size();
	}
	public Order getCurrentOrder() {
		return Orders.get(curentOrderIndex);
	}
	public int getNumOfAlcoholDrink() {
		return numOfAlcoholInOrder;
	}
	public int getMaxOrderForAlcohol() {
		return MAX_ORDER_FOR_ALCOHOL;
	}
	public int getMinAgeForAlcohol() {
		return MIN_AGE_FOR_ALCOHOL;
	}

}
