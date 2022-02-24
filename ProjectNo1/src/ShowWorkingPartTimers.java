import java.util.ArrayList;

public class ShowWorkingPartTimers {
	private WorkingPartTimerDAO dao = new WorkingPartTimerDAO();
	private String workingPartTimers;

	public String getWorkingPartTimers() {
		return workingPartTimers;
	}

	public void setWorkingPartTimers(String workingPartTimers) {
		this.workingPartTimers = workingPartTimers;
	}

	public void start() {
		ArrayList<WorkingPartTimerVo> list = dao.list();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < list.size(); i++) {
			WorkingPartTimerVo data = (WorkingPartTimerVo) list.get(i);
			String NAME = data.getName();
			String ROLE = data.getRole();

			sb.append(NAME + " " + ROLE + "\n");
		}
		setWorkingPartTimers(sb.toString());
	}
}
