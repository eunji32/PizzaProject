package pizza;

import java.sql.Connection;
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
		 String sql = "select * from orderCheck where indexi = ?";
		 ArrayList<AdminDTO> list = new ArrayList<AdminDTO>();
		
		 try {
		conn = ds.getConnection();
		
		
		pstmt =conn.prepareStatement(sql);
		pstmt.setInt(1, i);
		
		rs = pstmt.executeQuery();
		
       
       		AdminDTO dto = new AdminDTO();
       	while(rs.next()) {
       		dto.setTimei(rs.getString("Timei"));
       		dto.setPizzaName(rs.getString("PizzaName"));
       		dto.setAddress(rs.getString("Address"));
       		dto.setdelCheck(rs.getString("delCheck"));
       		dto.setprice(rs.getInt("price"));
       		
       		list.add(dto);
       	}
       	
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return list;
	}
	
	public void update(AdminDTO dto) {
		String sql = "update dept01 set delCheck = ? where indexi = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
	
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getdelCheck());
			pstmt.setInt(2, dto.getindexi());
			
			pstmt.executeUpdate();
			int result = pstmt.executeUpdate();
			
			if(result ==1) {
				System.out.println("수정성공");
				
			}else {
				System.out.println("수정실패");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
	         
            try {
               if(conn!=null){conn.close();} 
               if(pstmt!=null) {pstmt.close();}
            }
            catch (SQLException e) {
               System.out.println(e.getMessage());
            }
		}	
	}
}


