package pizza;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

import org.apache.commons.dbcp2.BasicDataSource;

class BasketControl {
	Calendar date= Calendar.getInstance();	
	int day;
	static int indexi =1;
	ArrayList<Food> food = new ArrayList<Food>(); //음식 안에있는 정보들을 들고온다.
	PizzaPickControl ppc;
	
	BasicDataSource ds;
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String userid = "scott";
	private String passwd = "tiger";
	
	BasketControl(PizzaPickControl ppc) {
		ds = new BasicDataSource(); //Connection Pool 기능과 Thread-safe 기능을 갖춤.
		ds.setDriverClassName(driver);
		ds.setUrl(url);
		ds.setUsername(userid);
		ds.setPassword(passwd);
		
		ds.setInitialSize(5); // 5개의 Connection을 공유하면서 사용할 수 있음. /5개까지 미리 만들어 놓는것 5명이 넘으면 new해서 새로 만듦.
		this.ppc = ppc;
	}
	
	
	//가져온 피자의 정보를 입력
	public void inputPizza() {
		food.add(ppc.PickPizzaInfo());
	}
	
	
	//최종가격보여주기
	public void finalPrice() {
		int finalPr = 0;
		for(Food e : food) {
			finalPr += e.getPrice();
		}
	}
	
	//음식을  관리자에게 넘겨줘야한다.(DB)
	public void PayForBasket(int choice) {
//		if(day != date.get(Calendar.DAY_OF_MONTH)) {

//		indexi = 1;

//	}

	
	int month = date.get(Calendar.MONTH)+1;
	day = date.get(Calendar.DAY_OF_MONTH);
	int hour = date.get(Calendar.HOUR);
	int min = date.get(Calendar.MINUTE);
	String strMonth, strDay, strHour, strMin ; 

	strMonth = Integer.toString(month);
	strDay = Integer.toString(day);
	strHour = Integer.toString(hour);
	strMin = Integer.toString(min);

	String Timei = strMonth+"/"+strDay+" "+strHour+":"+strMin; 
	//DB에 저장할 시간( MM/DD HH:MM)형태
	
	

//	String PizzaName = ppc.PickPizzaInfo(choice).getName();
	//DB에 저장할 피자이름
	String PizzaName = "testPizza"+choice;
//	피자이름 입력 값 대입	

	
	String Address =null;
//	주소 입력 값 대입	
	

	//DB에 저장할 배송지 이름 -> 메소드 구현시 수정필요

	String delCheck ="X";

	//기본 값인 X로 무조건 다 저장하고, UI에서 배송완료 버튼을 이벤트로 지정
	//이벤트 발생시 O로 수정한다는 메소드를 추가 작성하면 될 듯.

	
//	int price = ppc.PickPizzaInfo(choice).getPrice();

	int price	= 10000*choice;
	
	
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	String sql = "insert into orderCheck values(orderCheck_seq.nextVal,?,?,?,?,?)";
	//orderCheck 라는 Table이 있다는 가정하에 작성.				

	

	try {

		conn = ds.getConnection();
		pstmt = conn.prepareStatement(sql);
//		pstmt.setString(1, "orderCheck_seq.nextVal");
		pstmt.setString(1, Timei);
		pstmt.setString(2, PizzaName);
		pstmt.setString(3, Address);
		pstmt.setString(4, delCheck);
		pstmt.setInt(5, price);

		int result = pstmt.executeUpdate();

		if(result ==1) {
			System.out.println("저장성공");
			indexi++;
		}else {
			System.out.println("저장실패");
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {     
        try {
        	if(pstmt!=null) {pstmt.close();}
        	if(conn!=null){conn.close();} 
        }
        catch (SQLException e) {
           System.out.println(e.getMessage());
        }
	}



	}

}
	
