package Pizza;

import org.apache.commons.dbcp2.BasicDataSource;

class BasketDAO {
BasicDataSource ds;
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String userid = "scott";
	private String passwd = "tiger";
	
	BasketDAO() {
		ds = new BasicDataSource(); //Connection Pool 기능과 Thread-safe 기능을 갖춤.
		ds.setDriverClassName(driver);
		ds.setUrl(url);
		ds.setUsername(userid);
		ds.setPassword(passwd);
		
		ds.setInitialSize(5); // 5개의 Connection을 공유하면서 사용할 수 있음. /5개까지 미리 만들어 놓는것 5명이 넘으면 new해서 새로 만듦.
	}
	//받은 최종 값들을 넣어준다.
	
}
