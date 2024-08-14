package view;
import java.awt.*;
import java.awt.event.*;

import Project1.dao.DAO;

public class InputPasswordFrame extends AFrame {
	private Frame f;
	private TextField tf1;
	private Button b1, b2;
	private Label lpw;
	private String PASSWORD = "0";
	private String password = "0";
	DAO dao = new DAO();

	public void start(int key) {
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
		b2 = new Button("���");
		b1.setSize(50, 30);
		b2.setSize(50, 30);
		b1.setLocation(75, 110);
		b2.setLocation(125, 110);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckPasswordFrame chpf = new CheckPasswordFrame();
				password = tf1.getText();
				dao.joinPassword(password);
				PASSWORD = dao.getPASSWORD();
				if (PASSWORD.equals(password)) {
					if (key == 0) {
						LookUpFrame luf = new LookUpFrame();
						luf.start();
						f.dispose();
					} else if (key == 1) {
						ExitFrame ef = new ExitFrame();
						ef.start(password);
						f.dispose();
					} else if (key == 2) {
						CheckResetFrame chrf = new CheckResetFrame();
						chrf.start();
						f.dispose();
					}
				} else {
					chpf.start(0);
				}

			}
		});
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
			}
		});

		f.add(b1);
		f.add(b2);
		f.add(tf1);
		f.add(lpw);
		f.setVisible(true);
	}

//
//	public void joinDAO(String key) {
//		String driver = "oracle.jdbc.driver.OracleDriver";
//		String url = "jdbc:oracle:thin:@localhost:1521/xe";
//		String user = "c##ezen";
//		String password = "ezen1234";
//		String sql = "SELECT * FROM PASSWORD WHERE PW = ('" + key + "')";
//
//		try {
//			Class.forName(driver);
//			System.out.println("jdbc driver loading success.");
//			Connection conn = DriverManager.getConnection(url, user, password);
//			System.out.println("oracle connection sucess.\n");
//			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
//			ResultSet rs = stmt.executeQuery(sql);
//
//			rs.first();
//			System.out.println("rs.getRow() : " + rs.getRow());
//
//			if (rs.getRow() == 0) {
//				System.out.println("0 row selected.....");
//			} else {
//				System.out.println(rs.getRow() + " rows selected.....");
//				rs.previous();
//				while (rs.next()) {
//					setPASSWORD(rs.getString("PW"));
//				}
//			}
//		} catch (ClassNotFoundException e) {
//			System.out.println(e);
//		} catch (SQLException e) {
//			System.out.println(e);
//		}
//	}
}
