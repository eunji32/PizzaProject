package Pizza;

class Food {
	private int category = 0; //피자 1, 사이드2, 음료3
	private String name = null;
	private int price = 0; //가격
	
	Food(int category, String name,int price){
		this.category = category;
		this.name = name;
		this.price = price;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
