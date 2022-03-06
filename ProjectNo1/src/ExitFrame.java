import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

public class ExitFrame extends AFrame {
	private Frame f, cefF;
	private TextField tf1;
	private Button b1, cefB1, cefB2;
	private Label lpw, cefL1, cefL2;
	private String PASSWORD = "0";

	SetPasswordFrame spf = new SetPasswordFrame();

	public void start() {
		f = new Frame("Input Password");
		f.setSize(250, 160);
		f.setLayout(null);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent E) {
				f.dispose();
			}
		});
		f.setLocation(screenSize.width / 2 - 300, screenSize.height / 2 - 200);

		lpw = new Label("��й�ȣ�� �Է��ϼ���.", Label.CENTER);
		lpw.setSize(250, 20);
		lpw.setLocation(0, 50);

		tf1 = new TextField("");
		tf1.setSize(100, 20);
		tf1.setLocation(75, 80);
		tf1.setEchoChar('��');

		b1 = new Button("Ȯ��");
		b1.setSize(50, 30);
		b1.setLocation(100, 110);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				joinDAO();
				checkExitFrame();
			}
		});

		f.add(b1);
		f.add(tf1);
		f.add(lpw);
		f.setVisible(true);
	}

	public void checkExitFrame() {
		Calendar now = Calendar.getInstance();
		int ampm = now.get(Calendar.AM_PM);
		String strampm = null;
		int hour = now.get(Calendar.HOUR);
		int minute = now.get(Calendar.MINUTE);

		cefF = new Frame("Exit");
		cefF.setSize(250, 160);
		cefF.setLayout(null);
		cefF.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent E) {
				cefF.dispose();
			}
		});
		cefF.setLocation(screenSize.width / 2 - 300, screenSize.height / 2 - 200);

		if (ampm == Calendar.AM) {
			strampm = "���� ";
		} else {
			strampm = "���� ";
		}

		cefL1 = new Label("���� �ð��� " + strampm + hour + " �� " + minute + "�� " + "�Դϴ�.", Label.CENTER);
		cefL2 = new Label("���α׷��� �����ұ��?", Label.CENTER);
		cefL1.setSize(250, 20);
		cefL2.setSize(250, 20);
		cefL1.setLocation(0, 50);
		cefL2.setLocation(0, 80);

		cefB1 = new Button("��");
		cefB2 = new Button("�ƴϿ�");
		cefB1.setSize(50, 30);
		cefB2.setSize(50, 30);
		cefB1.setLocation(75, 110);
		cefB2.setLocation(125, 110);
		cefB1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				if (tf1.getText().equals("")) {
//					
//				}
				if (PASSWORD.equals(tf1.getText())) {
					PASSWORD = "0";
					System.exit(0);

				}

				if (PASSWORD == "0") {
					CheckPasswordFrame chpf = new CheckPasswordFrame();
					chpf.start();
				}

			}
		});
		cefB2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cefF.dispose();
			}
		});

		cefF.add(cefB1);
		cefF.add(cefB2);
		cefF.add(cefL1);
		cefF.add(cefL2);
		cefF.setVisible(true);
	}

	public void joinDAO() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String user = "c##ezen";
		String password = "ezen1234";
		String sql = "SELECT * FROM PASSWORD WHERE PW = ('" + tf1.getText() + "')";

		try {
			Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("oracle connection sucess.\n");
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery(sql);

			rs.first();
			System.out.println("rs.getRow() : " + rs.getRow());

			if (rs.getRow() == 0) {
				System.out.println("0 row selected.....");
				System.out.println(PASSWORD);
			} else {
				System.out.println(rs.getRow() + " rows selected.....");
				rs.previous();
				while (rs.next()) {
					PASSWORD = rs.getString("PW");
				}
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

}
