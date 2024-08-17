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
import java.util.ArrayList;

public class SetPayFrame extends AFrame {
	private Frame f;
	private TextField tf1, tf2;
	private Button b1, b2, b3;
	private Label l1, l2;

	public void start() {
		f = new Frame("Wage");
		f.setSize(215, 230);
		f.setLayout(null);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent E) {
				f.dispose();
			}
		});
		f.setLocation(screenSize.width / 2 - 300, screenSize.height / 2 - 200);

		l1 = new Label("올해의 최저임금 (단위 : ￦)");
		l2 = new Label("매니저 인센티브 (단위 : %)");

		l1.setSize(150, 20);
		l2.setSize(150, 20);
		l1.setLocation(35, 40);
		l2.setLocation(35, 100);

		tf1 = new TextField();
		tf2 = new TextField();
		tf1.setSize(100, 20);
		tf2.setSize(100, 20);
		tf1.setLocation(30, 65);
		tf2.setLocation(30, 125);

		b1 = new Button("적용");
		b2 = new Button("적용");
		b3 = new Button("닫기");
		b1.setSize(40, 20);
		b2.setSize(40, 20);
		b3.setSize(115, 40);
		b1.setLocation(140, 65);
		b2.setLocation(140, 125);
		b3.setLocation(50, 160);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mhw = "MHW";
				setPay(mhw);
			}
		});
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String role = "ROLE";
				setPay(role);
			}
		});
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
			}
		});
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(tf1);
		f.add(tf2);
		f.add(l1);
		f.add(l2);
		f.setVisible(true);
	}

	public void setPay(String wage) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "c##ezen";
		String dbPassword = "ezen1234";
		String sql;

		try {

			Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			Connection conn = DriverManager.getConnection(url, user, dbPassword);
			System.out.println("oracle connection sucess.\n");
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			if (wage == "MHW") {
				sql = "UPDATE WAGE SET MHW = '" + tf1.getText() + "'";
			} else {
				sql = "UPDATE WAGE SET ROLE ='" + tf2.getText() + "'";
			}
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

}
