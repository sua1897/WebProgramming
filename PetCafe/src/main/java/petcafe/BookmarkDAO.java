package petcafe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookmarkDAO {
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
	
	public boolean insert(int post_idx, String member_id) {
		open();
		boolean is_success = false;
		
		String sql = "INSERT INTO bookmark(post_idx, member_id) values(?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, post_idx);
			pstmt.setString(2, member_id);
			
			int success = pstmt.executeUpdate();
			if (success > 0) {
				is_success = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return is_success;
	}
	
	public boolean delete(int post_idx, String member_id) {
		open();
		boolean is_success = false;
		
		String sql = "DELETE FROM bookmark WHERE post_idx=? AND member_id=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, post_idx);
			pstmt.setString(2, member_id);
					
			int success = pstmt.executeUpdate();
			if (success > 0) {
				is_success = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return is_success;
	}
	
	public int count(int post_idx) {
		open();
		int result = 0;
		
		String sql = "SELECT COUNT(*) FROM bookmark WHERE post_idx=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, post_idx);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return result;
	}
	
	public boolean isChecked(int post_idx, String member_id) {
		open();
		boolean result = false;
		
		String sql = "SELECT * FROM bookmark WHERE post_idx=? AND member_id=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, post_idx);
			pstmt.setString(2, member_id);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return result;
	}
	
}
