import java.util.ArrayList;

public class ShowAllPartTimers {
	private PartTimerJoinDAO dao = new PartTimerJoinDAO();
	private String allPartTimers;

	public String getAllPartTimers() {
		return allPartTimers;
	}

	public void setAllPartTimers(String allPartTimers) {
		this.allPartTimers = allPartTimers;
	}

	public void start() {
		ArrayList<PartTimerVo> list = dao.list(null);
		StringBuilder sb = new StringBuilder();
		String info = " ";
		
		for (int i = 0; i < list.size(); i++) {
			PartTimerVo data = (PartTimerVo) list.get(i);
			String NAME = data.getName();
			String ROLE = data.getRole();

			info += NAME + " " + ROLE + "\n";
		}
//		System.out.println(sb.toString());
//		setAllPartTimers(sb.toString());
		System.out.println(info);
	}
}
