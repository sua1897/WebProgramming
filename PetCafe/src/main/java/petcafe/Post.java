package petcafe;

public class Post {
	private int post_idx;
	private String member_id;
	private String postboard;
	private boolean only_member;
	private String post_date;
	private String title;
	private String body;
	private String image;
	
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
}
