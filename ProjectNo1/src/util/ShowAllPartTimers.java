package util;
import java.util.ArrayList;

import dao.ShowAllDAO;
import dto.PartTimerVo;

public class ShowAllPartTimers {
	public ShowAllDAO dao = new ShowAllDAO();
	public String allPartTimers;

	public String getAllPartTimers() {
		return allPartTimers;
	}

	public void setAllPartTimers(String allPartTimers) {
		this.allPartTimers = allPartTimers;
	}

	public void start() {
		ArrayList<PartTimerVo> list = dao.list();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < list.size(); i++) {
			PartTimerVo data = (PartTimerVo) list.get(i);
			String name = data.getName();
			String role = data.getRole();

			sb.append(name + " " + role + "\n");
		}

		setAllPartTimers(sb.toString());
	}
}
