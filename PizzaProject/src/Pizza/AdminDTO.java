package Pizza;

public class AdminDTO {
	private int index;
	private String Time;
	private String PizzaName;
	private String Address;
	private String delCheck;
	private int price;


	public int getindex() {
		return index;
	}
	
	public void setindex(int index) {
		this.index = index	;
	}
	
	public String getTime() {
		return Time;
	}
	
	public void setTime(String Time) {
		this.Time = Time	;
	}
	
	public String getPizzaName() {
		return PizzaName;
	}
	
	public void setPizzaName(String PizzaName) {
		this.PizzaName = PizzaName	;
	}
	
	public String getAddress() {
		return Address;
	}
	
	public void setAddress(String Address) {
		this.Address = Address	;
	}
	
	public String getdelCheck() {
		return delCheck;
	}
	
	public void setdelCheck(String delCheck) {
		this.delCheck = delCheck	;
	}
	
	public int getprice() {
		return price;
	}
	
	public void setprice(int price) {
		this.price = price	;
	}
}

