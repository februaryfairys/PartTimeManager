import java.util.ArrayList;

public class ShowAllPartTimers {
	private ShowAllDAO dao = new ShowAllDAO();
	private String allPartTimers;

	public String getAllPartTimers() {
		return allPartTimers;
	}

	public void setAllPartTimers(String allPartTimers) {
		this.allPartTimers = allPartTimers;
	}

	public void start() {
		ArrayList<ShowAllVo> list = dao.list();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < list.size(); i++) {
			ShowAllVo data = (ShowAllVo) list.get(i);
			String NAME = data.getName();
			String ROLE = data.getRole();

			sb.append(NAME + " " + ROLE + "\n");
		}

		setAllPartTimers(sb.toString());
	}
}
