package Pizza;

import java.util.ArrayList;

import javax.swing.JFrame;


public class Admin {
	BasketControl info = new BasketControl();
	String ID = "admin";
	String PW = "admin";
	
	public Admin(String ID, String PW) {
		this.ID = ID;
		this.PW = PW;
				
	}
	
	public static String readTime(AdminDAO info, int index) {
		ArrayList<AdminDTO>list = info.select(index);
		
		String time = null;
		for(AdminDTO e :list) {
		time = e.getTime();
		}
		return time;
	}
	
	public static String readPizzaName(AdminDAO info, int index) {
		ArrayList<AdminDTO>list = info.select(index);
		
		String PizzaName = null;
		for(AdminDTO e :list) {
			PizzaName = e.getPizzaName();
		}
		return PizzaName;
	}

	public static String readAddress(AdminDAO info, int index) {
		ArrayList<AdminDTO>list = info.select(index);
		
		String Address = null;
		for(AdminDTO e :list) {
			Address = e.getAddress();
		}
		return Address;
	}
	
	public static String readDelCheck(AdminDAO info, int index) {
		ArrayList<AdminDTO>list = info.select(index);
		
		String delCheck = null;
		for(AdminDTO e :list) {
			delCheck = e.getdelCheck();
		}
		return delCheck;
	}
	
	public static int readPrice(AdminDAO info, int index) {
		ArrayList<AdminDTO>list = info.select(index);
		
		int Price = 0;
		for(AdminDTO e :list) {
			Price = e.getprice();
		}
		return Price;
	}
	
}
