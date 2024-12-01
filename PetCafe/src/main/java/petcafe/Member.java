package petcafe;

public class Member {
	private String id;
	private String password;
	private String name;
	private String pw_question;
	private String pw_answer;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		// 앞뒤 공백 제거
		this.id = id;
	}
	public String getPassword() {
		// 암호화 과정 필요
		return password;
	}
	public void setPassword(String password) {
		// 앞뒤 공백 제거
		// 암호화 과정 필요
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		// 앞뒤 공백 제거
		this.name = name;
	}
	public String getPw_question() {
		return pw_question;
	}
	public void setPw_question(String pw_question) {
		// 앞뒤 공백 제거
		this.pw_question = pw_question;
	}
	public String getPw_answer() {
		return pw_answer;
	}
	public void setPw_answer(String pw_answer) {
		// 앞뒤 공백 제거
		this.pw_answer = pw_answer;
	}
}
