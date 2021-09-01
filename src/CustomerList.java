import java.util.ArrayList;

public class CustomerList {
	private ArrayList<Customer> theList;
	
	public CustomerList() {
		this.theList = new ArrayList<Customer>();
	}
	
	public ArrayList<Customer> getList() {
		return this.theList;
	}
	
	public Customer getCustomer(String id) {
		for (int i = 0; i < this.theList.size(); i++) {
			Customer temp = this.theList.get(i);
			if (temp.getID().equals(id))
				return temp;
		}
		System.out.println("Customer " + id + " not found");
		return null;
	}
	
	public boolean addCustomer(Customer cust) {
		for (int i = 0; i < this.theList.size(); i++) {
			Customer temp = this.theList.get(i);
			if (temp.getID().equals(cust.getID()))
				return false;
		}
		this.theList.add(cust);
		return true;
	}


	public class SuperVIP {
	private static SuperVIP INSTANCE = new SuperVIP();
	private SuperVIP() {}
	public static SuperVIP getInstance() {
	return INSTANCE;
	}
}

public class CustomerFactory {

	public static Customer create(String type, String name, String address, String iD, String phone) {
		switch (type) {
			case "guest": {
				return new GuestCustomer(name, address, iD, phone);
			}
			case "vip": {
				return new VIPCustomer(name, address, iD, phone);
			}
			case "supervip": {
				return SuperVip.getInstance();
			}
		}
		return null;
	}
}