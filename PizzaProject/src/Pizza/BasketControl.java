package Pizza;

import java.util.ArrayList;

import org.apache.commons.dbcp2.BasicDataSource;

class BasketControl {
	ArrayList<Food> food = new ArrayList<Food>(); //음식 안에있는 정보들을 들고온다.
	PizzaPickControl ppc = new PizzaPickControl();
	
	BasicDataSource ds;
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String userid = "scott";
	private String passwd = "tiger";
	
	BasketControl() {
		ds = new BasicDataSource(); //Connection Pool 기능과 Thread-safe 기능을 갖춤.
		ds.setDriverClassName(driver);
		ds.setUrl(url);
		ds.setUsername(userid);
		ds.setPassword(passwd);
		
		ds.setInitialSize(5); // 5개의 Connection을 공유하면서 사용할 수 있음. /5개까지 미리 만들어 놓는것 5명이 넘으면 new해서 새로 만듦.
	}
	
	
	//가져온 피자의 정보를 입력
	public void inputFood() {
		food.add(ppc.PickPizzaInfo()); //피자의 정보를 입력
	}
	
	
	//최종가격보여주기
	public void finalPrice() {
		int finalPr = 0;
		for(Food e : food) {
			finalPr += e.getPrice();
		}
	}
	
	//음식을  관리자에게 넘겨줘야한다.(DB)
	public void PayForBasket() {
		
	}
}
