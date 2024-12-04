package petcafe;

import java.sql.Connection;
import java.sql.Timestamp;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ReplyDAO {
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
	
	public boolean insert(Reply new_reply) {
		open();
		boolean is_success = false;
		
		String sql = "INSERT INTO reply(post_idx, member_id, body) values(?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, new_reply.getPost_idx());
			pstmt.setString(2, new_reply.getMember_id());
			pstmt.setString(3, new_reply.getBody());
			
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
	
	public boolean delete(int reply_idx) {
		open();
		boolean is_success = false;
		
		String sql = "DELETE FROM reply WHERE reply_idx=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, reply_idx);
					
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
	
	public List<Reply> getAll(int now_post_idx) {
		open();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<Reply> replys = new ArrayList<>();
		MemberDAO mem_dao = new MemberDAO();
		
		String sql = "SELECT * FROM reply WHERE post_idx=? ORDER BY reply_date DESC";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, now_post_idx);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Reply reply = new Reply();
				reply.setReply_idx(rs.getInt("reply_idx"));
				reply.setPost_idx(rs.getInt("post_idx"));
				reply.setMember_id(rs.getString("member_id"));
				
				String dateString = format.format(rs.getTimestamp("reply_date"));
				reply.setReply_date(dateString);
				
				reply.setBody(rs.getString("body"));
				
				reply.setMember_name(mem_dao.getName(reply.getMember_id()));
				
				replys.add(reply);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return replys;
	}
	
}
