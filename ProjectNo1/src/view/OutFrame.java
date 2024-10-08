package view;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import dao.JoinDAO;
import dto.PartTimerVo;

public class OutFrame extends AFrame {
	private Frame f, f2;
	private TextField tf1, tf2;
	private Button b1, b2, b3;
	private Label lid, lpw, l1, l2;
	private JoinDAO dao = new JoinDAO();
	private AlreadyOutFrame aof = new AlreadyOutFrame();
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void start() {

		f = new Frame("Out");
		f.setSize(250, 240);
		f.setLayout(null);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent E) {
				f.dispose();
			}
		});
		f.setLocation(screenSize.width / 2 - 300, screenSize.height / 2 - 200);

		lid = new Label("성명");
		lpw = new Label("직원번호");
		lid.setSize(50, 20);
		lpw.setSize(50, 20);
		lid.setLocation(35, 40);
		lpw.setLocation(35, 100);

		tf1 = new TextField();
		tf2 = new TextField();
		tf1.setSize(190, 20);
		tf2.setSize(190, 20);
		tf1.setLocation(30, 65);
		tf2.setLocation(30, 125);
		tf2.setEchoChar('●');

		b1 = new Button("퇴근하기");
		b1.setSize(160, 50);
		b1.setLocation(45, 160);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				InputYourInfo iyi = new InputYourInfo();
				CheckNameOrPassword cnp = new CheckNameOrPassword();
				if (tf1.getText().equals("")) {
					iyi.start("name");
				} else if (tf2.getText().equals("")) {
					iyi.start("password");
				} else {
					ArrayList<PartTimerVo> list = dao.list(tf1.getText());
					if (list.size() == 0) {
						cnp.start();
					} else {
						PartTimerVo data = (PartTimerVo) list.get(0);
						String pswd = data.getPw();
						if (tf2.getText().equals(pswd)) {
							checkOutFrame();
							setName(tf1.getText());
							f.dispose();
						} else {
							cnp.start();
						}
					}
				}
			}
		});

		f.add(b1);
		f.add(tf1);
		f.add(tf2);
		f.add(lid);
		f.add(lpw);
		f.setVisible(true);

	}

	public void checkOutFrame() {
		Calendar now = Calendar.getInstance();
		int ampm = now.get(Calendar.AM_PM);
		String strampm = null;
		int hour = now.get(Calendar.HOUR);
		int minute = now.get(Calendar.MINUTE);

		f2 = new Frame("CheckOut");
		f2.setSize(250, 160);
		f2.setLayout(null);
		f2.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent E) {
				f2.dispose();
			}
		});
		f2.setLocation(screenSize.width / 2 - 300, screenSize.height / 2 - 200);

		if (ampm == Calendar.AM) {
			strampm = "오전 ";
		} else {
			strampm = "오후 ";
		}

		l1 = new Label("현재 시간은 " + strampm + hour + " 시 " + minute + "분 " + "입니다.", Label.CENTER);
		l2 = new Label("퇴근할까요?", Label.CENTER);
		l1.setSize(250, 20);
		l2.setSize(250, 20);
		l1.setLocation(0, 50);
		l2.setLocation(0, 80);

		b2 = new Button("네");
		b3 = new Button("아니요");
		b2.setSize(50, 30);
		b3.setSize(50, 30);
		b2.setLocation(75, 110);
		b3.setLocation(125, 110);
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkDAO();
				f2.dispose();
			}
		});
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f2.dispose();
			}
		});

		f2.add(b2);
		f2.add(b3);
		f2.add(l1);
		f2.add(l2);
		f2.setVisible(true);
	}

	public void checkDAO() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "c##ezen";
		String password = "ezen1234";
		String sql;

		try {

			Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("oracle connection sucess.\n");
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			sql = "SELECT * FROM WORKINGPARTTIMERS WHERE NAME = '" + tf1.getText() + "'" + "AND PW = " + "'"
					+ tf2.getText() + "'";
			ResultSet rs = stmt.executeQuery(sql);
			rs.first();
			if (rs.getRow() == 0) {
				System.out.println("0 row selected.....");
				aof.start();
			} else {
				System.out.println(rs.getRow() + " rows selected.....");
				rs.previous();
				outDAO();
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);

		}
	}

	public void outDAO() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "c##ezen";
		String password = "ezen1234";
		String sql1, sql2, sql3, joinTime, outTime;

		Date now = new Date();
		SimpleDateFormat sdfNow = new SimpleDateFormat("HHmm");

		try {

			Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("oracle connection sucess.\n");
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			outTime = sdfNow.format(now);
			joinTime = "0";
			sql1 = "select JOINTIME from WORKINGPARTTIMERS where name = '" + tf1.getText() + "' AND PW = '"
					+ tf2.getText() + "'";

			ResultSet rs = stmt.executeQuery(sql1);

			rs.last();
			System.out.println("rs.getRow() : " + rs.getRow());
			if (rs.getRow() == 0) {
				System.out.println("0 row selected.....");
			} else {
				System.out.println(rs.getRow() + " rows selected.....");
				rs.previous();
				while (rs.next()) {
					joinTime = rs.getString("JOINTIME");
				}
			}

			sql2 = "delete from WORKINGPARTTIMERS where name = '" + tf1.getText() + "' AND PW = '" + tf2.getText()
					+ "'";

			sql3 = "UPDATE WORKTIME SET OUTTIME =" + outTime + ", WORKTIMEH =" + workTimeH(joinTime, outTime)
					+ ", WORKTIMEM = " + workTimeM(joinTime, outTime) + " WHERE JOINTIME = '" + joinTime + "'";
			boolean b2 = stmt.execute(sql2);
			boolean b3 = stmt.execute(sql3);
			if (!b2) {
				System.out.println("OUT SUCCSESS.\n");
				CompleteOutFrame cof = new CompleteOutFrame();
				cof.setName(tf1.getText());
				cof.start();
			} else {
				System.out.println("OUT FAIL.\n");
			}

			if (!b3) {
				System.out.println("CHECK OUTTIME SUCCSESS.\n");

			} else {
				System.out.println("CHECK OUTTIME FAIL.\n");
			}
		}

		catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public String workTimeH(String joinTime, String outTime) {

		String workTimeH;

		int joinTimeH = Integer.parseInt(joinTime.substring(0, 2));
		int outTimeH = Integer.parseInt(outTime.substring(0, 2));
		int joinTimeM = Integer.parseInt(joinTime.substring(2));
		int outTimeM = Integer.parseInt(outTime.substring(2));

		int joinTimeHM = joinTimeH * 60;
		int outTimeHM = outTimeH * 60;

		int joinTime2 = joinTimeHM + joinTimeM;
		int outTime2 = outTimeHM + outTimeM;

		int workTimeHM = outTime2 - joinTime2;

		int workTimeH2 = workTimeHM / 60;

		workTimeH = workTimeH2 + "";

		return workTimeH;

	}

	public String workTimeM(String joinTime, String outTime) {

		String workTimeM;

		int joinTimeH = Integer.parseInt(joinTime.substring(0, 2));
		int outTimeH = Integer.parseInt(outTime.substring(0, 2));
		int joinTimeM = Integer.parseInt(joinTime.substring(2));
		int outTimeM = Integer.parseInt(outTime.substring(2));

		int joinTimeHM = joinTimeH * 60;
		int outTimeHM = outTimeH * 60;

		int joinTime2 = joinTimeHM + joinTimeM;
		int outTime2 = outTimeHM + outTimeM;

		int workTimeHM = outTime2 - joinTime2;

		int workTimeM2 = workTimeHM % 60;

		workTimeM = workTimeM2 + "";

		return workTimeM;

	}
}