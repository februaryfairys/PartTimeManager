import java.util.ArrayList;

public class ShowWorkingPartTimers {
	private PartTimerJoinDAO dao = new PartTimerJoinDAO();
	private String workingPartTimers;

	public String getWorkingPartTimers() {
		return workingPartTimers;
	}

	public void setWorkingPartTimers(String workingPartTimers) {
		this.workingPartTimers = workingPartTimers;
	}

	public void start() {
		ArrayList<PartTimerVo> list = dao.list(null);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			PartTimerVo data = (PartTimerVo) list.get(i);
			String NAME = data.getName();
			String ROLE = data.getRole();
			sb.append(NAME + " " + ROLE + "\n");
		}
		setWorkingPartTimers(sb.toString());
	}
}
