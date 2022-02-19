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
import java.util.Calendar;

public class InputPasswordFrame extends AFrame {
	private Frame f, cefF;
	private TextField tf1;
	private Button b1, cefB1, cefB2;
	private Label lpw, cefL1, cefL2;
	private String PASSWORD;

	private Calendar now = Calendar.getInstance();
	private int ampm = now.get(Calendar.AM_PM);
	private String strampm = null;
	private int hour = now.get(Calendar.HOUR);
	private int minute = now.get(Calendar.MINUTE);

	SetPasswordFrame spf = new SetPasswordFrame();

	public void start() {
		f = new Frame("Input Password");
		f.setSize(300, 180);
		f.setLayout(null);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent E) {
				f.dispose();
			}
		});
		f.setLocation(screenSize.width / 2 - 300, screenSize.height / 2 - 200);

		tf1 = new TextField("");
		tf1.setSize(150, 20);
		tf1.setLocation(75, 80);

		b1 = new Button("Ok");
		b1.setSize(150, 50);
		b1.setLocation(75, 120);
		b1.addActionListener(this);
		lpw = new Label("비밀번호를 입력하세요.");
		lpw.setSize(130, 20);
		lpw.setLocation(85, 60);
		f.add(b1);
		f.add(tf1);
		f.add(lpw);
		f.setVisible(true);
	}

	public void checkExitFrame() {
		cefF = new Frame("프로그램 종료");
		cefF.setSize(250, 160);
		cefF.setLayout(null);
		cefF.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent E) {
				cefF.dispose();
			}
		});
		cefF.setLocation(screenSize.width / 2 - 300, screenSize.height / 2 - 200);

		if (ampm == Calendar.AM) {
			strampm = "오전 ";
		} else {
			strampm = "오후 ";
		}

		cefL1 = new Label("현재 시간은 " + strampm + hour + " 시 " + minute + "분 " + "입니다.", Label.CENTER);
		cefL2 = new Label("프로그램을 종료할까요?", Label.CENTER);
		cefL1.setSize(250, 20);
		cefL2.setSize(250, 20);
		cefL1.setLocation(0, 50);
		cefL2.setLocation(0, 80);

		cefB1 = new Button("네");
		cefB2 = new Button("아니요");
		cefB1.setSize(50, 30);
		cefB2.setSize(50, 30);
		cefB1.setLocation(75, 120);
		cefB2.setLocation(125, 120);
		cefB1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(PASSWORD + " " + tf1.getText());
				if (PASSWORD.equals(tf1.getText())) {
					System.exit(0);
				}
			}
		});
		cefB2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
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
//		String user = "c##february";
//		String password = "wl887087wl";
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

	public void actionPerformed(ActionEvent e) {
		joinDAO();
		checkExitFrame();
	}
}
