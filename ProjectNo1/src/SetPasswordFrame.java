import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SetPasswordFrame extends AFrame {

	private Frame f, f2;
	private Label l1, l2, l3, l4, l5, ccpfL1, ccpfL2;
	private TextField tf1, tf2, tf3;
	private Button b1, b2, ccpfB1, ccpfB2;
	private String PASSWORD = "0";
	InputYourInfo iyi = new InputYourInfo();
	CheckPasswordFrame chpf = new CheckPasswordFrame();
	CompletePasswordChangeFrame cpcf = new CompletePasswordChangeFrame();

	public void start() {
		f = new Frame("비밀번호 재설정");
		f.setSize(250, 330);
		f.setLayout(null);
		f.setLocation(screenSize.width / 2 - 300, screenSize.height / 2 - 200);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent E) {
				f.dispose();
			}
		});

		l1 = new Label("<초기 비밀번호는 0000입니다.>", Label.CENTER);
		l2 = new Label("현재 비밀번호를 입력해주세요.", Label.CENTER);
		l3 = new Label("새로운 비밀번호를 입력해주세요.", Label.CENTER);
		l4 = new Label("새로운 비밀번호를 다시 입력해주세요.", Label.CENTER);
		l5 = new Label("", Label.CENTER);
		l1.setSize(250, 20);
		l2.setSize(250, 20);
		l3.setSize(250, 20);
		l4.setSize(250, 20);
		l5.setSize(250, 20);
		l1.setLocation(0, 40);
		l2.setLocation(0, 70);
		l3.setLocation(0, 130);
		l4.setLocation(0, 190);
		l5.setLocation(0, 250);
		l5.setForeground(Color.red);

		tf1 = new TextField();
		tf2 = new TextField();
		tf3 = new TextField();
		tf1.setSize(190, 20);
		tf2.setSize(190, 20);
		tf3.setSize(190, 20);
		tf1.setLocation(30, 100);
		tf2.setLocation(30, 160);
		tf3.setLocation(30, 220);
		tf1.setEchoChar('●');
		tf2.setEchoChar('●');
		tf3.setEchoChar('●');

		b1 = new Button("확인");
		b2 = new Button("취소");
		b1.setSize(50, 30);
		b2.setSize(50, 30);
		b1.setLocation(75, 280);
		b2.setLocation(125, 280);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tf1.getText().equals("")) {
					iyi.start("password");
				} else if (tf2.getText().equals("") || tf3.getText().equals("")) {
					iyi.start("password");
				} else if (tf2.getText().length() != 4 || tf3.getText().length() != 4) {
					chpf.start(0);
					l5.setText("<비밀번호는 4자리로 설정해주세요.>");
				} else {
					if (tf2.getText().equals(tf3.getText())) {
						joinDAO();
						CheckChangePasswordFrame();
					} else if (tf2.getText() != tf3.getText()) {
						chpf.start(0);
						l5.setText("<새로운 비밀번호가 일치하지 않습니다.>");
					}
				}
			}
		});
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
			}
		});

		f.add(l1);
		f.add(l2);
		f.add(l3);
		f.add(l4);
		f.add(l5);
		f.add(tf1);
		f.add(tf2);
		f.add(tf3);
		f.add(b1);
		f.add(b2);
		f.setVisible(true);

	}

	public void CheckChangePasswordFrame() {
		f2 = new Frame("재설정 확인");
		f2.setSize(250, 160);
		f2.setLayout(null);
		f2.setLocation(screenSize.width / 2 - 300, screenSize.height / 2 - 200);
		f2.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent E) {
				f2.dispose();
			}
		});
		ccpfL1 = new Label("변경할 비밀번호는 " + tf2.getText() + "입니다.", Label.CENTER);
		ccpfL2 = new Label("비밀번호를 변경할까요?", Label.CENTER);
		ccpfL1.setSize(250, 20);
		ccpfL2.setSize(250, 20);
		ccpfL1.setLocation(0, 50);
		ccpfL2.setLocation(0, 80);

		ccpfB1 = new Button("네");
		ccpfB2 = new Button("아니요");
		ccpfB1.setSize(50, 30);
		ccpfB2.setSize(50, 30);
		ccpfB1.setLocation(75, 110);
		ccpfB2.setLocation(125, 110);
		ccpfB1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (PASSWORD.equals(tf1.getText())) {
					changePasswordDAO();
					f.dispose();
					f2.dispose();
					cpcf.start();
				} else {
					chpf.start(0);
					l5.setText("<현재 비밀번호가 일치하지 않습니다.>");
				}
			}
		});
		ccpfB2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f2.dispose();
			}
		});
		f2.add(ccpfL1);
		f2.add(ccpfL2);
		f2.add(ccpfB1);
		f2.add(ccpfB2);
		f2.setVisible(true);
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

	public void changePasswordDAO() {

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
			Statement stmt = conn.createStatement();

			sql = "UPDATE PASSWORD SET PW = '" + tf2.getText() + "'WHERE PW = '" + tf1.getText() + "'";

			boolean b = stmt.execute(sql);
			if (!b) {
				System.out.println("CHANGE SUCCSESS.\n");
			} else {
				System.out.println("CHANGE FAIL.\n");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public void windowClosing(WindowEvent E) {
		f.dispose();
	}

	public String getPASSWORD() {
		return PASSWORD;
	}

	public void setPASSWORD(String PASSWORD) {
		this.PASSWORD = PASSWORD;
	}
}
