import java.awt.Button;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Project1.dto.VOWorkTime;

public class WorkTimeFrame extends AFrame {
	private Frame f;
	private Button b1, b2, b3;
	private Label l1, l2, l3, l4, l5, l6, l7;
	private Choice c1, c2, c3;
	private TextArea ta1, ta2;
	private TextField tf1;
	private String result, name;
	private int WTH = 0, WTM = 0, WT;
	private String MHW = "";
	private String ROLE = "";
	private String opt1 = "opt1";
	private String opt2 = "opt2";

	public void start(String name, ArrayList<VOWorkTime> list) {

		this.name = name;
		f = new Frame("Work Time");
		f.setSize(540, 400);
		f.setLayout(null);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent E) {
				f.dispose();
			}
		});
		f.setLocation(screenSize.width / 2 - 300, screenSize.height / 2 - 200);

		l1 = new Label(name + "님의 근무시간을 조회합니다.", Label.CENTER);
		l2 = new Label("아래 근무일부터");
		l3 = new Label("아래 근무일까지 조회합니다.");
		l4 = new Label(name + "님의 급여를 계산합니다.", Label.CENTER);
		l5 = new Label("책정된 시급은 얼마인가요?");
		l6 = new Label("원", Label.CENTER);
		l7 = new Label(name + "님의 역할은 무엇인가요?");

		l1.setSize(270, 20);
		l2.setSize(200, 20);
		l3.setSize(200, 20);
		l4.setSize(270, 20);
		l5.setSize(200, 20);
		l6.setSize(20, 20);
		l7.setSize(200, 20);
		l1.setLocation(0, 50);
		l2.setLocation(35, 90);
		l3.setLocation(35, 160);
		l4.setLocation(270, 50);
		l5.setLocation(305, 90);
		l6.setLocation(410, 120);
		l7.setLocation(305, 160);

		c1 = new Choice();
		c1 = new Choice();
		c2 = new Choice();
		c3 = new Choice();
		c1.setSize(200, 20);
		c2.setSize(200, 20);
		c3.setSize(200, 20);
		c1.setLocation(35, 120);
		c2.setLocation(35, 190);
		c3.setLocation(305, 190);
		c3.add("직원");
		c3.add("매니저");

		for (int i = 0; i < list.size(); i++) {
			VOWorkTime data = list.get(i);
			String DT = data.getDT();

			c1.add(DT);
			c2.add(DT);
		}

		ta1 = new TextArea();
		ta2 = new TextArea();
		ta1.setSize(200, 70);
		ta2.setSize(200, 70);
		ta1.setLocation(35, 240);
		ta2.setLocation(305, 240);
		ta1.setEditable(false);
		ta2.setEditable(false);

		tf1 = new TextField(MHW);
		tf1.setSize(100, 20);
		tf1.setLocation(305, 120);

		b1 = new Button("조회");
		b1.setSize(160, 40);
		b1.setLocation(55, 330);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dao(opt1);
				result = "해당 기간 동안의\n" + name + "님의 근무 시간은\n" + WTH + "시간 " + WTM + "분입니다.";
				ta1.setText(result);

			}
		});
		b2 = new Button("최저임금");
		b2.setSize(65, 20);
		b2.setLocation(440, 120);
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dao(opt2);

			}
		});

		b3 = new Button("계산");
		b3.setSize(160, 40);
		b3.setLocation(325, 330);
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int wage = Integer.parseInt(tf1.getText());
				result = "해당 기간 동안의\n" + name + "님의 급여는\n" + "'" + wageCal(WTH, WTM, wage) + "'원입니다.\n"
						+ "(원 단위 미만 절사)";
				ta2.setText(result);
			}
		});

		f.add(l1);
		f.add(l2);
		f.add(l3);
		f.add(l4);
		f.add(l5);
		f.add(l6);
		f.add(l7);
		f.add(c1);
		f.add(c2);
		f.add(c3);
		f.add(ta1);
		f.add(ta2);
		f.add(tf1);
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.setVisible(true);

	}

	public void start2() {
	}

	public void dao(String opt) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "c##ezen";
		String password = "ezen1234";
		String sql = "";

		int DTFrom = Integer.parseInt(c1.getSelectedItem());
		int DTTo = Integer.parseInt(c2.getSelectedItem());

		try {

			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, password);
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			if (opt == opt1) {
				sql = "SELECT sum(WORKTIMEH), sum(WORKTIMEM) FROM WORKTIME where NAME = '" + name + "'";
				if (DTFrom > DTTo) {
					int tmp;
					tmp = DTFrom;
					DTFrom = DTTo;
					DTTo = tmp;
				}
				sql += " AND (DT BETWEEN " + DTFrom + " AND " + DTTo + ")";

				ResultSet rs = stmt.executeQuery(sql);

				rs.first();
				if (rs.getRow() == 0) {
					System.out.println("0 row selected.....");
				} else {
					System.out.println(rs.getRow() + " rows selected.....");
					rs.previous();
					while (rs.next()) {
						WTH = rs.getInt("SUM(WORKTIMEH)");
						WTM = rs.getInt("SUM(WORKTIMEM)");
					}
					WT = WTH * 60 + WTM;
					WTH = workTimeH(WT);
					WTM = workTimeM(WT);
				}

			}

			else if (opt == opt2) {
				sql = "SELECT * FROM WAGE";
				ResultSet rs = stmt.executeQuery(sql);
				rs.first();
				if (rs.getRow() == 0) {
					System.out.println("0 row selected.....");
				} else {
					System.out.println(rs.getRow() + " rows selected.....");
					rs.previous();
					while (rs.next()) {

						MHW = rs.getString("MHW");
						ROLE = rs.getString("ROLE");
						tf1.setText(MHW);

					}

				}
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}

	}

	public int workTimeH(int WT) {

		int workTimeH;

		workTimeH = WT / 60;

		return workTimeH;
	}

	public int workTimeM(int WT) {

		int workTimeM;

		workTimeM = WT % 60;

		return workTimeM;
	}

	public int wageCal(int WTH, int WTM, int wage) {
		int wageH = wage * WTH;
		int wageM = wage / 60 * WTM;
		int wageHM = wageH + wageM;
		if (c3.getSelectedItem() == "매니저") {
			dao(opt2);
			wageHM = wageHM * (100 + Integer.parseInt(ROLE)) / 100;
		}
		return wageHM;
	}

	public void conn() {
	}
}
