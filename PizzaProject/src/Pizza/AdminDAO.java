package Pizza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.commons.dbcp2.BasicDataSource;


class AdminDAO {
	BasicDataSource ds;
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String userid = "scott";
	private String passwd = "tiger";
	
	AdminDAO (){
		ds = new BasicDataSource();
		//Connection Pool 기능과 Thread-safe 기능을 갖춤.
		ds.setDriverClassName(driver);
		ds.setUrl(url);
		ds.setUsername(userid);
		ds.setPassword(passwd);
		
		ds.setInitialSize(5);
	}
	public ArrayList<AdminDTO> select(int i) {
		 PreparedStatement pstmt=null;
		 Connection conn= null;
		 ResultSet rs = null;
		 String sql = "select * from orderCheck where index =+"+ i;
		 ArrayList<AdminDTO> list = new ArrayList<AdminDTO>();
		
		 try {
		conn = ds.getConnection();

		pstmt =conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
       
       		AdminDTO dto = new AdminDTO();
      	 
       		dto.setTime(rs.getString("Time"));
       		dto.setPizzaName(rs.getString("PizzaName"));
       		dto.setAddress(rs.getString("Address"));
       		dto.setdelCheck(rs.getString("delCheck"));
       		dto.setprice(rs.getInt("price"));
       		
       		list.add(dto);
        // dto => DB시스템의 여러 기능을 사용할 수 있도록 최적화
       	
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return list;
	}
	
	
}


