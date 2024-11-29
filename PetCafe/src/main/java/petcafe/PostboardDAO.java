package petcafe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostboardDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	final String JDBC_URL = "jdbc:mysql://localhost:3306/petcafedb";
	
	public void open() {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(JDBC_URL, "root", "passwd");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insert(Postboard pb) {
		open();
		String sql = "INSERT INTO postboard(name) values(?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pb.getName());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
	public List<Postboard> getAll() {
		open();
		List<Postboard> postboards = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement("SELECT * FROM postboard");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Postboard pb = new Postboard();
				pb.setName(rs.getString("name"));
				
				postboards.add(pb);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return postboards;
	}
}
