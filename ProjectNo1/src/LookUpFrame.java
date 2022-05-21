import java.awt.Button;
import java.awt.Frame;
import java.awt.List;
import java.awt.MenuItem;
import java.awt.PopupMenu;
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

import Project1.dao.JoinDAO;
import Project1.dto.PartTimerVo;
import Project1.dto.VOWorkTime;

public class LookUpFrame extends AFrame {
	private Frame f;
	private List lst;
	private Button b1, b2, b3, b4, b5;
	private TextField tf;
	private TextArea ta;
	private PopupMenu p;
	private MenuItem pi1, pi2;
	private String name;

	JoinDAO dao = new JoinDAO();
	EditFrame ef = new EditFrame();
	CheckDeleteFrame chdf = new CheckDeleteFrame();

	public void start() {
		f = new Frame("Look Up");
		f.setSize(460, 300);
		f.setLayout(null);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent E) {
				f.dispose();
			}
		});
		f.setLocation(screenSize.width / 2 - 300, screenSize.height / 2 - 200);
		b1 = new Button("조회");
		b2 = new Button("직원 정보 조회");
		b3 = new Button("직원 정보 수정");
		b4 = new Button("직원 정보 삭제");
		b5 = new Button("근무 시간 조회");
		b1.setSize(40, 20);
		b2.setSize(160, 40);
		b3.setSize(160, 40);
		b4.setSize(160, 40);
		b5.setSize(160, 40);
		b1.setLocation(195, 50);
		b2.setLocation(265, 50);
		b3.setLocation(265, 110);
		b4.setLocation(265, 170);
		b5.setLocation(265, 230);

		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tf.getText().length() > 1) {
					ArrayList<PartTimerVo> list = dao.list(tf.getText());
					PartTimerVo data = (PartTimerVo) list.get(0);
					lst.add(data.getName());
				}
			}
		});
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lst.getSelectedItem() != null) {
					ArrayList<PartTimerVo> list = dao.list(lst.getSelectedItem());
					PartTimerVo data = (PartTimerVo) list.get(0);
					String name = data.getName();
					String pw = data.getPw();
					String tel = data.getTel();
					String role = data.getRole();
					String info = name + " " + role + "\n직원번호 : " + pw + "\n연락처 : " + tel;
					ta.setText(info);
				}
			}
		});
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lst.getSelectedItem() != null) {

					ef.setName(lst.getSelectedItem());
					ef.start();
				}
			}
		});
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lst.getSelectedItem() != null) {
					name = lst.getSelectedItem();
					chdf.start(name);
				}
			}
		});

		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lst.getSelectedItem() != null) {
					timeDAO();
				}
			}
		});

		tf = new TextField(null);
		tf.setSize(150, 20);
		tf.setLocation(35, 50);
		tf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		p = new PopupMenu("편집");
		pi1 = new MenuItem("목록에서 삭제");
		pi2 = new MenuItem("목록 비우기");
		p.add(pi1);
		p.add(pi2);

		lst = new List();
		lst.setSize(200, 70);
		lst.setLocation(35, 90);

		ta = new TextArea();
		ta.setSize(200, 90);
		ta.setLocation(35, 180);
		ta.setEditable(false);

		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);
		f.add(b5);
		f.add(tf);
		f.add(lst);
		f.add(ta);
		f.setVisible(true);
	}

	public void deleteDAO(String name) {

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "c##ezen";
		String password = "ezen1234";
		String sql1, sql2, sql3;

		try {

			Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("oracle connection sucess.\n");
			Statement stmt = conn.createStatement();

			sql1 = "DELETE FROM PARTTIMERS where NAME = '" + name + "'";
			sql2 = "SELECT * FROM WORKINGPARTTIMERS WHERE NAME = '" + name + "'";
			sql3 = "DELETE FROM WORKINGPARTTIMERS where NAME = '" + name + "'";

			boolean b = stmt.execute(sql1);
			ResultSet rs = stmt.executeQuery(sql2);
			if (rs.getRow() != 0) {
				stmt.execute(sql3);
			}

			if (!b) {
				System.out.println("DELETE SUCCSESS.\n");
//				lst.remove(lst.getSelectedItem());
			} else {
				System.out.println("DELETE FAIL.\n");
			}

		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public void timeDAO() {

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "c##ezen";
		String password = "ezen1234";
		String sql1, name;

		ArrayList<VOWorkTime> list = new ArrayList<VOWorkTime>();

		try {

			Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("oracle connection sucess.\n");
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			name = lst.getSelectedItem();
			sql1 = "SELECT DISTINCT DT FROM WORKTIME WHERE NAME = '" + name + "' order by DT";

			ResultSet rs = stmt.executeQuery(sql1);
			rs.first();

			if (rs.getRow() == 0) {
				System.out.println("0 row selected.....");
			} else {
				System.out.println(rs.getRow() + " rows selected.....");
				rs.previous();
				while (rs.next()) {
					String DT = rs.getString("DT");
					VOWorkTime data = new VOWorkTime(DT);
					list.add(data);
				}
				WorkTimeFrame pf = new WorkTimeFrame();
				pf.start(lst.getSelectedItem(), list);
			}

		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}
