package petcafe;

public class Post {
	private int post_idx;
	private String member_id;
	private String postboard;
	private boolean only_member;
	private String post_date;
	private String title;
	private String body;
	private String image_str;
	private int image_idx;
	
	private String postboard_kr;
	private String member_name;
	
	public int getPost_idx() {
		return post_idx;
	}
	public void setPost_idx(int post_idx) {
		this.post_idx = post_idx;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getPostboard() {
		return postboard;
	}
	public void setPostboard(String postboard) {
		this.postboard = postboard;
	}
	public boolean isOnly_member() {
		return only_member;
	}
	public void setOnly_member(boolean only_member) {
		this.only_member = only_member;
	}
	public String getPost_date() {
		return post_date;
	}
	public void setPost_date(String post_date) {
		this.post_date = post_date;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getImage_str() {
		return image_str;
	}
	public void setImage_str(String image_str) {
		this.image_str = image_str;
	}
	public int getImage_idx() {
		return image_idx;
	}
	public void setImage_idx(int image_idx) {
		this.image_idx = image_idx;
	}
	public String getPostboard_kr() {
		return postboard_kr;
	}
	
	public void setPostboard_kr() {
		if (postboard != null) {
			if (postboard.equals("free")) {
				postboard_kr = "자유 게시판";
			} else {
				postboard_kr = "질문 게시판";
			}
		}
	}
	
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
}
