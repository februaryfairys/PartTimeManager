
public class VOWorkingPartTimer {

	private String name; // �̸�
	private String pw; // ��й�ȣ
	private String tel; // ����ó
	private String role; // ����

	public VOWorkingPartTimer() {
	}

	public VOWorkingPartTimer(String name, String pw, String tel, String role) {
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
