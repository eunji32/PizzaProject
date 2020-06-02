package pizza;

import java.util.ArrayList;

import javax.swing.JFrame;



public class Admin {
	PizzaPickControl ppc = new PizzaPickControl();
	BasketControl info = new BasketControl(ppc);
	String ID ="admin";
	String PW = "admin" ;
	
	public Admin(String ID, String PW) {
		
		
				
	}
	
	public static Object[] RevenueData(AdminDAO info, int indexi) {
		ArrayList<AdminDTO>list = info.select(indexi);

		Object[] data= new Object[3];
		for(AdminDTO e :list) {
			
			String time =e.getTimei();
			String pizza = e.getPizzaName();
			int price = e.getprice();
			
			Object[] result = {time, pizza, price};			 
			data = result;
		}
		return data;
	}
	
	public static Object[] OrderData(AdminDAO info, int indexi) {
		ArrayList<AdminDTO>list = info.select(indexi);

		Object[] data= new Object[4];
		for(AdminDTO e :list) {
			
			String time =e.getTimei();
			String pizza = e.getPizzaName();
			String adress = e.getAddress();
			String delCheck = e.getdelCheck();
			
			
			Object[] result = {time, pizza, adress,delCheck};
			data = result;
		}
		return data;
	}
	
	
//	public static int readIndex(AdminDAO info, int indexi) {
//		int index = info.selectMax();
//		
//		return index;
//	}
	
	
	public static String readTime(AdminDAO info, int indexi) {
		ArrayList<AdminDTO>list = info.select(indexi);
		
		String time = null;
		for(AdminDTO e :list) {
		time = e.getTimei();
		}
		return time;
	}
	
	public static String readPizzaName(AdminDAO info, int indexi) {
		ArrayList<AdminDTO>list = info.select(indexi);
		
		String PizzaName = null;
		for(AdminDTO e :list) {
			PizzaName = e.getPizzaName();
		}
		return PizzaName;
	}

	public static String readAddress(AdminDAO info, int indexi) {
		ArrayList<AdminDTO>list = info.select(indexi);
		
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
	
	public static int readPrice(AdminDAO info, int indexi) {
		ArrayList<AdminDTO>list = info.select(indexi);
		
		int Price = 0;
		for(AdminDTO e :list) {
			Price = e.getprice();
		}
		return Price;
	}
	
	
}
