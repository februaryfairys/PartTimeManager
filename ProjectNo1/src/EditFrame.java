import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EditFrame extends AFrame {
	private Frame f, chefF, cefF;
	private TextField tf;
	private Label l1, l2, l3, l4, l5, chefL2, cefL1, cefL2;
	private Choice c, c2;
	private Button b, chefB1, chefB2, cefB;
	private String name;
	InputYourInfo iyi = new InputYourInfo();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void start() {

		f = new Frame("직원 정보 수정");
		f.setSize(270, 400);
		f.setLayout(null);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent E) {
				f.dispose();
			}
		});
		f.setLocation(screenSize.width / 2 - 300, screenSize.height / 2 - 200);

		l1 = new Label(getName() + "님의 개인정보를 수정합니다", Label.CENTER);
		l2 = new Label("수정할 항목");
		l3 = new Label("수정할 내용");
		l4 = new Label();
		l5 = new Label("역할도 수정할까요?");
		l1.setSize(270, 20);
		l2.setSize(200, 20);
		l3.setSize(200, 20);
		l4.setSize(200, 20);
		l5.setSize(200, 20);
		l1.setLocation(0, 50);
		l2.setLocation(35, 90);
		l3.setLocation(35, 160);
		l4.setLocation(35, 215);
		l5.setLocation(35, 240);

		c = new Choice();
		c.add("성명");
		c.add("연락처");
		c.setSize(200, 20);
		c.setLocation(35, 120);

		tf = new TextField();
		tf.setSize(200, 20);
		tf.setLocation(35, 190);

		c2 = new Choice();
		c2.add("아니요");
		c2.add("직원");
		c2.add("매니저");

		c2.setSize(200, 20);
		c2.setLocation(35, 270);

		b = new Button("수정");
		b.setSize(200, 60);
		b.setLocation(35, 310);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (c.getSelectedItem().equals("성명") && tf.getText().equals("")) {
					iyi.name();
				} else if (c.getSelectedItem().equals("연락처") && tf.getText().equals("")) {
					iyi.tel();
				} else if (c.getSelectedItem().equals("성명") && !(tf.getText().length() >= 2)) {
					l4.setText("두 글자 이상 입력하세요.");
				} else if (c.getSelectedItem().equals("연락처")
						&& (tf.getText().length() > 11 || tf.getText().length() < 10)) {
					l5.setText("올바른 연락처를 입력하세요.");
				} else if ((c.getSelectedItem().equals("성명") && tf.getText().length() >= 2)
						|| (c.getSelectedItem().equals("연락차")
								&& (tf.getText().length() == 11 || tf.getText().length() == 10))) {
					f.dispose();
					checkEditFrame();
				}
			}
		});

		f.add(l1);
		f.add(l2);
		f.add(l3);
		f.add(l4);
		f.add(c);
		f.add(tf);
		f.add(cb1);
		f.add(cb2);
		f.add(cb3);
		f.add(b);
		f.setVisible(true);

	}

	public void checkEditFrame() {

		chefF = new Frame("수정");
		chefF.setSize(250, 160);
		chefF.setLayout(null);
		chefF.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent E) {
				chefF.dispose();
			}
		});
		chefF.setLocation(screenSize.width / 2 - 300, screenSize.height / 2 - 200);

		chefL2 = new Label("직원 정보를 수정할까요?", Label.CENTER);
		chefL2.setSize(250, 20);
		chefL2.setLocation(0, 60);

		chefB1 = new Button("네");
		chefB2 = new Button("아니요");
		chefB1.setSize(50, 30);
		chefB2.setSize(50, 30);
		chefB1.setLocation(75, 110);
		chefB2.setLocation(125, 110);
		chefB1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chefF.dispose();
				f.dispose();
				editDAO();
				completeEditFrame();
			}
		});
		chefB2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chefF.dispose();
			}
		});

		chefF.add(chefB1);
		chefF.add(chefB2);
		chefF.add(chefL2);
		chefF.setVisible(true);
	}

	public void completeEditFrame() {
		cefF = new Frame("등록완료");
		cefF.setSize(250, 150);
		cefF.setLayout(null);
		cefF.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent E) {
				cefF.dispose();
			}
		});
		cefF.setLocation(screenSize.width / 2 - 300, screenSize.height / 2 - 200);

		cefL1 = new Label("수정되었습니다.", Label.CENTER);
		cefL2 = new Label(getName() + "님의 정보를 확인해주세요.", Label.CENTER);
		cefL1.setSize(250, 20);
		cefL1.setLocation(0, 40);
		cefL2.setSize(250, 20);
		cefL2.setLocation(0, 70);

		cefB = new Button("확인");
		cefB.setSize(60, 30);
		cefB.setLocation(95, 100);
		cefB.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				cefF.dispose();
			}
		});
		cefF.add(cefL1);
		cefF.add(cefL2);
		cefF.add(cefB);
		cefF.setVisible(true);
	}

	public void editDAO() {

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

			sql = "insert into PARTTIMERS VALUES ('" + getNAME() + "','" + getPW() + "','" + getTEL() + "' , '"
					+ getROLE() + "')";

			boolean b = stmt.execute(sql);
			if (!b) {
				System.out.println("INSERT SUCCSESS.\n");
			} else {
				System.out.println("INSERT FAIL.\n");
			}

		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}
