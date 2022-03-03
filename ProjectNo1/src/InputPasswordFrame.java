import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InputPasswordFrame extends AFrame {
	private Frame f;
	private TextField tf1;
	private Button b1, b2;
	private Label lpw;
	private String PASSWORD = "0";

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

		lpw = new Label("비밀번호를 입력하세요.", Label.CENTER);
		lpw.setSize(250, 20);
		lpw.setLocation(0, 50);

		tf1 = new TextField("");
		tf1.setSize(100, 20);
		tf1.setLocation(75, 80);
		tf1.setEchoChar('●');

		b1 = new Button("확인");
		b2 = new Button("취소");
		b1.setSize(50, 30);
		b2.setSize(50, 30);
		b1.setLocation(75, 110);
		b2.setLocation(125, 110);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckPasswordFrame chpf = new CheckPasswordFrame();
				joinDAO();

				if (PASSWORD.equals(tf1.getText())) {
					LookUpFrame luf = new LookUpFrame();
					luf.start();
					f.dispose();
				}

				if (PASSWORD == "0") {
					chpf.start();
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
