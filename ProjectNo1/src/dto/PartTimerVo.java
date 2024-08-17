package dto;

public class PartTimerVo {

	private String name; // 이름
	private String pw;   // 비밀번호
	private String tel;  // 전화번호
	private String role; // 역할

	public PartTimerVo() {
	}

	public PartTimerVo(String name, String pw, String tel, String role) {
		this.name = name;
		this.pw = pw;
		this.tel = tel;
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public String getPw() {
		return pw;
	}

	public String getTel() {
		return tel;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getRole() {
		return role;
	}
}
