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

public class PostDAO {
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
	
	public boolean insert(Post new_post) {
		open();
		boolean is_success = false;
		int only_member = 0;
		if (new_post.isOnly_member()) {
			only_member = 1;
		}
		
		String sql = "";
		if (new_post.getImage_idx() > 0) {
			sql = "INSERT INTO post(member_id, postboard, only_member, title, body, image) values(?,?,?,?,?,?)";
		} else {
			sql = "INSERT INTO post(member_id, postboard, only_member, title, body) values(?,?,?,?,?)";
		}
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, new_post.getMember_id());
			pstmt.setString(2, new_post.getPostboard());
			pstmt.setInt(3, only_member);
			pstmt.setString(4, new_post.getTitle());
			pstmt.setString(5, new_post.getBody());
			if (new_post.getImage_idx() > 0) {
				pstmt.setInt(6, new_post.getImage_idx());
			}
			
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
	
	public boolean insert_image(Post new_post) {
		open();
		boolean is_success = false;
		String sql = "";
		new_post.setImage_idx(0);
		
		sql = "INSERT INTO image values()";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int success = pstmt.executeUpdate();
			if (success > 0) {
				sql = "SELECT img_idx FROM image ORDER BY img_idx DESC";
				pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				
				if (rs.next()) {
					new_post.setImage_idx(rs.getInt(1));
					is_success = true;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return is_success;
	}
	
	public List<Post> getByPostboard(String pb, boolean is_member) {
		open();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<Post> posts = new ArrayList<>();
		
		String sql = "";
		if (is_member) {
			if (pb.equals("all")) {
				sql = "SELECT * FROM post ORDER BY post_date DESC";
			} else {
				sql = "SELECT * FROM post WHERE postboard=? ORDER BY post_date DESC";
			}
		} else {
			if (pb.equals("all")) {
				sql = "SELECT * FROM post WHERE only_member=0 ORDER BY post_date DESC";
			} else {
				sql = "SELECT * FROM post WHERE postboard=? AND only_member=0 ORDER BY post_date DESC";
			}
		}
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			if (!pb.equals("all")) {
				pstmt.setString(1, pb);
			}
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Post post = new Post();
				post.setPost_idx(rs.getInt("post_idx"));
				post.setMember_id(rs.getString("member_id"));
				post.setPostboard(rs.getString("postboard"));
				
				if (rs.getInt("only_member") > 0) {
					post.setOnly_member(true);
				} else {
					post.setOnly_member(false);
				}
				
				String dateString = format.format(rs.getTimestamp("post_date"));
				post.setPost_date(dateString);
				
				post.setTitle(rs.getString("title"));
				post.setBody(rs.getString("body"));
				
				post.setImage_idx(rs.getInt("image"));
				
				posts.add(post);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return posts;
	}
	
	public List<Post> getByBookmark(String mem_id) {
		open();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<Post> posts = new ArrayList<>();
		
		String sql = "SELECT * FROM post WHERE post_idx=(SELECT post_idx FROM bookmark WHERE member_id=?) ORDER BY post_date DESC";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mem_id);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Post post = new Post();
				post.setPost_idx(rs.getInt("post_idx"));
				post.setMember_id(rs.getString("member_id"));
				post.setPostboard(rs.getString("postboard"));
				
				if (rs.getInt("only_member") > 0) {
					post.setOnly_member(true);
				} else {
					post.setOnly_member(false);
				}
				
				String dateString = format.format(rs.getTimestamp("post_date"));
				post.setPost_date(dateString);
				
				post.setTitle(rs.getString("title"));
				post.setBody(rs.getString("body"));
				post.setImage_idx(rs.getInt("image"));
				
				posts.add(post);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return posts;
	}
	
	public List<Post> searchByTitle(String title, String pb, boolean is_member) {
		open();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<Post> posts = new ArrayList<>();
		
		String sql = "";
		if (is_member) {
			if (pb.equals("all")) {
				sql = "SELECT * FROM post WHERE title LIKE '%" +  title + "%' ORDER BY post_date DESC";
			} else {
				sql = "SELECT * FROM post WHERE postboard=? ORDER BY post_date DESC";
			}
		} else {
			if (pb.equals("all")) {
				sql = "SELECT * FROM post WHERE only_member=0 ORDER BY post_date DESC";
			} else {
				sql = "SELECT * FROM post WHERE postboard=? AND only_member=0 ORDER BY post_date DESC";
			}
		}
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			if (!pb.equals("all")) {
				pstmt.setString(1, pb);
			}
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Post post = new Post();
				post.setPost_idx(rs.getInt("post_idx"));
				post.setMember_id(rs.getString("member_id"));
				post.setPostboard(rs.getString("postboard"));
				
				if (rs.getInt("only_member") > 0) {
					post.setOnly_member(true);
				} else {
					post.setOnly_member(false);
				}
				
				String dateString = format.format(rs.getTimestamp("post_date"));
				post.setPost_date(dateString);
				
				post.setTitle(rs.getString("title"));
				post.setBody(rs.getString("body"));
				
				post.setImage_idx(rs.getInt("image"));
				
				posts.add(post);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return posts;
	}
	
	public Post getByPostIdx(int post_idx) {
		open();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Post post = new Post();
		
		String sql = "SELECT * FROM post WHERE post_idx=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, post_idx);
			
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				post.setPost_idx(rs.getInt("post_idx"));
				post.setMember_id(rs.getString("member_id"));
				post.setPostboard(rs.getString("postboard"));
				
				if (rs.getInt("only_member") > 0) {
					post.setOnly_member(true);
				} else {
					post.setOnly_member(false);
				}
				
				String dateString = format.format(rs.getTimestamp("post_date"));
				post.setPost_date(dateString);
				
				post.setTitle(rs.getString("title"));
				post.setBody(rs.getString("body"));
				post.setImage_idx(rs.getInt("image"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return post;
	}
	
}
