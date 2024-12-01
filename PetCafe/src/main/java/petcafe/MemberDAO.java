package petcafe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
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
	
	public void insert(Member mem) {
		open();
		String sql = "INSERT INTO member(id, password, name, pw_question, pw_answer) values(?,?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mem.getId());
			pstmt.setString(2, mem.getPassword());
			pstmt.setString(3, mem.getName());
			pstmt.setString(4, mem.getPw_question());
			pstmt.setString(5, mem.getPw_answer());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
	public List<Member> getAll() {
		open();
		List<Member> members = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement("SELECT * FROM member");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Member mem = new Member();
				mem.setId(rs.getString("id"));
				mem.setPassword(rs.getString("password"));
				mem.setName(rs.getString("name"));
				mem.setPw_question(rs.getString("pw_question"));
				mem.setPw_answer(rs.getString("pw_answer"));
				
				members.add(mem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return members;
	}
	
	public boolean login(Member login_input) {
		open();
		boolean success = false;
		String sql = "SELECT password FROM member WHERE id=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, login_input.getId());
			
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				// 아이디가 존재
				if (rs.getString(1).equals(login_input.getPassword())) {
					// 비밀번호 일치
					success = true;
				
				} else {
					// 비밀번호 불일치
				}
			} else {
				// 아이디가 존재하지 않음
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return success;
	}
	
	public String getName(String input_id) {
		open();
		String name = "";
		String sql = "SELECT name FROM member WHERE id=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, input_id);
			
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.last()) {
				// 일치하는 아이디
				name = new String(rs.getString(1));
			} else {
				// 아이디가 존재하지 않음
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return name;
	}
}
