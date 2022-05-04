
public interface OrderInterface {
/**
 * 
 * @return
 */
public boolean isWeekend();
/**
 * 
 * @param itemNo
 * @return
 */
public Beverage getBeverage(int itemNo);
/**
 * 
 * @param bevName
 * @param size
 * @param extraShot
 * @param extraSyrup
 */
public void addNewBeverage(String bevName,SIZE size, boolean extraShot,boolean extraSyrup);
/**
 * 
 * @param bevName
 * @param size
 */
public void addNewBeverage(String bevName,SIZE size);
/**
 * 
 * @param bevName
 * @param size
 * @param numOfFruits
 * @param addPRotien
 */
public void addNewBeverage(String bevName,SIZE size, int numOfFruits, boolean addPRotien);
/**
 * 
 * @return
 */
public double calcOrderTotal();
/**
 * 
 * @param type
 * @return
 */
public int findNumOfBeveType(TYPE type);
}
