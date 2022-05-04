
public class Customer {
	private String name; 
	private int age; 
	//constructors
	public Customer (String n, int a) {
		name = n ;
		age = a ; 
	}
	public Customer (Customer c) {
		name = c.getName();
		age = c.getAge();
	}
	//utility
	public String toString() {
		 return name + ", " + age + "y/o"; 
	}
	//accessors
	public String getName() {
		return name; 
	}
	public int getAge() {
		return age; 
	}
	//mutators 
	public void setName(String n) {
		name = n; 
	}
	public void setAge(int a) {
		age =a; 
	}

}
