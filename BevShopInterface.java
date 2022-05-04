
public interface BevShopInterface {
	int MIN_AGE_FOR_ALCOHOL =21; //minimum age for offerting alcohol
	int MAX_ORDER_FOR_ALCOHOL=3; //maximum number of alcohol 
	int MIN_TIME = 8;
	int MAX_TIME = 23;
	int MAX_FRUIT = 5;
	/**
	 * 
	 * @param time
	 * @return
	 */
	public boolean validTime(int time);
	/**
	 * 
	 * @return
	 */
	public boolean eligibleForMore();
	/**
	 * 
	 * @param age
	 * @return
	 */
	public boolean validAge(int age);
	/**
	 * 
	 * @param time
	 * @param day
	 * @param customerName
	 * @param customerAge
	 */
	public void startNewOrder(int time, DAY day, String customerName, int customerAge);
	/**
	 * 
	 * @param bevname
	 * @param size
	 * @param extraShot
	 * @param extraSyrup
	 */
	public void processCoffeeOrder(String bevname, SIZE size, boolean extraShot, boolean extraSyrup);
	/**
	 * 
	 * @param bevName
	 * @param size
	 * @param numOfFruits
	 * @param addProperties
	 */
	public void processSmoothieOrder(String bevName, SIZE size, int numOfFruits, boolean addProtien);
	
	public void processAlcoholOrder(String bevname, SIZE size);
	/**
	 * 
	 * @return
	 */
	public double totalMonthlySale();
	/**
	 * 
	 * @param index
	 * @return
	 */
	public Order getOrderAtIndex(int index);
	/**
	 * 
	 * @param orderNo
	 * @return
	 */
	public int findOrder(int orderNo);
	/**
	 * 
	 */
	public void sortOrders();
	public double totalOrderPrice(int orderNo);
	
}
