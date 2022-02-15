
public class WorkingPartTimerVo {
	private String name; // 이름
	private String pw; // 비밀번호

	public WorkingPartTimerVo() {
	}

	public WorkingPartTimerVo(String name, String pw) {
		this.name = name;
		this.pw = pw;

	}

	public String getName() {
		return name;
	}

	public String getPw() {
		return pw;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

}
