import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

public class JoinFrame extends AFrame {
	private Frame f, f2;
	private TextField tf1, tf2;
	private Button b1, b2, b3;
	private Label lid, lpw, l1, l2;
	private PartTimerJoinDAO dao = new PartTimerJoinDAO();
	private String name;

	private Calendar now = Calendar.getInstance();
	private int ampm = now.get(Calendar.AM_PM);
	private String strampm = null;
	private int hour = now.get(Calendar.HOUR);
	private int minute = now.get(Calendar.MINUTE);

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void start() {
		f = new Frame("출근하기");
		f.setSize(250, 240);
		f.setLayout(null);
		f.addWindowListener(this);
		f.setLocation(screenSize.width / 2 - 300, screenSize.height / 2 - 200);

		lid = new Label("성명");
		lpw = new Label("비밀번호");
		lid.setSize(55, 20);
		lpw.setSize(55, 20);
		lid.setLocation(30, 40);
		lpw.setLocation(30, 100);

		tf1 = new TextField();
		tf2 = new TextField();
		tf1.setSize(200, 20);
		tf2.setSize(200, 20);
		tf1.setLocation(25, 65);
		tf2.setLocation(25, 125);

		b1 = new Button("출근하기");
		b1.setSize(200, 50);
		b1.setLocation(25, 160);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				InputYourInfo iyi = new InputYourInfo();
				CheckNameOrPassword cnp = new CheckNameOrPassword();
				if (tf1.getText().equals("")) {
					iyi.name();
				} else if (tf2.getText().equals("")) {
					iyi.password();
				} else {
					ArrayList<PartTimerVo> list = dao.list(tf1.getText());
					if (list.size() == 0) {
						cnp.start();
					} else {
						PartTimerVo data = (PartTimerVo) list.get(0);
						String pswd = data.getPw();
						if (tf2.getText().equals(pswd)) {
							setName(tf1.getText());
							CheckJoinFrame();
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

	public void CheckJoinFrame() {
		f2 = new Frame("CheckJoin");
		f2.setSize(250, 160);
		f2.setLayout(null);
		f2.setLocation(screenSize.width / 2 - 300, screenSize.height / 2 - 200);
		f2.addWindowListener(this);

		if (ampm == Calendar.AM) {
			strampm = "오전 ";
		} else {
			strampm = "오후 ";
		}

		l1 = new Label("현재 시간은 " + strampm + hour + " 시 " + minute + "분 " + "입니다.", Label.CENTER);
		l2 = new Label("출근할까요?", Label.CENTER);
		l1.setSize(250, 20);
		l2.setSize(250, 20);
		l1.setLocation(0, 50);
		l2.setLocation(0, 80);

		b2 = new Button("네");
		b3 = new Button("아니요");
		b2.setSize(50, 30);
		b3.setSize(50, 30);
		b2.setLocation(75, 120);
		b3.setLocation(125, 120);
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				joinDAO();
				f2.dispose();
				CompleteJoinFrame cjf = new CompleteJoinFrame();
				cjf.start();

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

	public void windowClosing(WindowEvent E) {
		f.dispose();
	}

	public void joinDAO() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
//		String user = "c##ezen";
//		String password = "ezen1234";
		String user = "c##february";
		String password = "wl887087wl";
		String sql;

		try {

			Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("oracle connection sucess.\n");
			Statement stmt = conn.createStatement();

			sql = "insert into WORKINGPARTTIMERS VALUES ('" + tf1.getText() + "','" + tf2.getText() + "')";

			boolean b = stmt.execute(sql);
			if (!b) {
				System.out.println("JOIN SUCCSESS.\n");
			} else {
				System.out.println("JOIN FAIL.\n");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}
