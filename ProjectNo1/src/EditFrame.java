import java.awt.*;
import java.awt.event.*;
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

		f = new Frame("Edit");
		f.setSize(270, 400);
		f.setLayout(null);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent E) {
				f.dispose();
			}
		});
		f.setLocation(screenSize.width / 2 - 300, screenSize.height / 2 - 200);

		l1 = new Label(getName() + "���� ���������� �����մϴ�", Label.CENTER);
		l2 = new Label("������ �׸�");
		l3 = new Label("������ ����");
		l4 = new Label();
		l5 = new Label("���ҵ� �����ұ��?");
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
		c.add("����");
		c.add("����ó");
		c.setSize(200, 20);
		c.setLocation(35, 120);

		tf = new TextField();
		tf.setSize(200, 20);
		tf.setLocation(35, 190);

		c2 = new Choice();
		c2.add("�ƴϿ�");
		c2.add("����");
		c2.add("�Ŵ���");

		c2.setSize(200, 20);
		c2.setLocation(35, 270);

		b = new Button("����");
		b.setSize(200, 60);
		b.setLocation(35, 310);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (c.getSelectedItem().equals("����") && tf.getText().equals("")) {
					iyi.name();
				} else if (c.getSelectedItem().equals("����ó") && tf.getText().equals("")) {
					iyi.tel();
				} else if (c.getSelectedItem().equals("����") && !(tf.getText().length() >= 2)) {
					l4.setText("�� ���� �̻� �Է��ϼ���.");
				} else if (c.getSelectedItem().equals("����ó")
						&& (tf.getText().length() > 11 || tf.getText().length() < 10)) {
					l4.setText("�ùٸ� ����ó�� �Է��ϼ���.");
				} else if ((c.getSelectedItem().equals("����") && tf.getText().length() >= 2)
						|| (c.getSelectedItem().equals("������")
								&& (tf.getText().length() == 11 || tf.getText().length() == 10))) {
					checkEditFrame();
				}
			}
		});

		f.add(l1);
		f.add(l2);
		f.add(l3);
		f.add(l4);
		f.add(l5);
		f.add(c);
		f.add(tf);
		f.add(c2);
		f.add(b);
		f.setVisible(true);

	}

	public void checkEditFrame() {

		chefF = new Frame("Edit");
		chefF.setSize(250, 160);
		chefF.setLayout(null);
		chefF.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent E) {
				chefF.dispose();
			}
		});
		chefF.setLocation(screenSize.width / 2 - 300, screenSize.height / 2 - 200);

		chefL2 = new Label("���� ������ �����ұ��?", Label.CENTER);
		chefL2.setSize(250, 20);
		chefL2.setLocation(0, 65);

		chefB1 = new Button("��");
		chefB2 = new Button("�ƴϿ�");
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
		cefF = new Frame("Complete");
		cefF.setSize(250, 160);
		cefF.setLayout(null);
		cefF.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent E) {
				cefF.dispose();
			}
		});
		cefF.setLocation(screenSize.width / 2 - 300, screenSize.height / 2 - 200);

		cefL1 = new Label("�����Ǿ����ϴ�.", Label.CENTER);
		cefL2 = new Label(tf.getText() + "���� ������ Ȯ�����ּ���.", Label.CENTER);
		cefL1.setSize(250, 20);
		cefL1.setLocation(0, 50);
		cefL2.setSize(250, 20);
		cefL2.setLocation(0, 80);

		cefB = new Button("Ȯ��");
		cefB.setSize(50, 30);
		cefB.setLocation(100, 110);
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
		String sql1, sql2, sql3;
		String v1 = "NAME";

		try {

			Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("oracle connection sucess.\n");
			Statement stmt = conn.createStatement();

			if (c.getSelectedItem().equals("����ó")) {
				v1 = "TEL";
			}

			sql1 = "update PARTTIMERS set " + v1 + " = '" + tf.getText() + "' where NAME = '" + getName() + "'";
			sql2 = "update WORKINGPARTTIMERS set " + v1 + " = '" + tf.getText() + "' where NAME = '" + getName() + "'";
			sql3 = "update WORKTIME set " + v1 + " = '" + tf.getText() + "' where NAME = '" + getName() + "'";
			
			if (!(c2.getSelectedItem().equals("�ƴϿ�"))) {
				sql1 = "update PARTTIMERS set " + v1 + "= '" + tf.getText() + "', ROLE = '" + c2.getSelectedItem()
						+ "' where NAME = '" + getName() + "'";
			}

			boolean b = stmt.execute(sql1);
			stmt.execute(sql2);
			stmt.execute(sql3);
			if (!b) {
				System.out.println("UPDATE SUCCSESS.\n");
			} else {
				System.out.println("UPDATE FAIL.\n");
			}

		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}
