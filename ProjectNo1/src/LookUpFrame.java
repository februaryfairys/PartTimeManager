import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;

public class LookUpFrame extends AFrame {
	private Frame f, chdfF, cdfF;
	private List lst;
	private Button b1, b2, b3, b4, chdfB1, chdfB2, cdfB;
	private TextField tf;
	private TextArea ta;
	private Label chdfL1, chdfL2, cdfL1, cdfL2;
	private PopupMenu p;
	private MenuItem pi1, pi2;

	PartTimerJoinDAO dao = new PartTimerJoinDAO();
	EditFrame ef = new EditFrame();

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
		b1 = new Button("��ȸ");
		b2 = new Button("�������� ��ȸ");
		b3 = new Button("�������� ����");
		b4 = new Button("����");
		b1.setSize(40, 20);
		b2.setSize(160, 60);
		b3.setSize(160, 60);
		b4.setSize(160, 60);
		b1.setLocation(195, 50);
		b2.setLocation(265, 50);
		b3.setLocation(265, 130);
		b4.setLocation(265, 210);

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
					String info = name + " " + role + "\n������ȣ : " + pw + "\n����ó : " + tel;
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
					checkDeleteFrame();
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

		p = new PopupMenu("����");
		pi1 = new MenuItem("��Ͽ��� ����");
		pi2 = new MenuItem("��� ����");
		p.add(pi1);
		p.add(pi2);

		lst = new List();
		lst.setSize(200, 70);
		lst.setLocation(35, 90);
//		lst.add(p);
//		lst.addMouseListener(new MouseAdapter() {
//			public void mousePressed(MouseEvent me) {
//				if (me.getModifiers() == me.BUTTON3_MASK) {
//					p.show(f, me.getX(), me.getY());
//				}
//			}
//		});

		ta = new TextArea();
		ta.setSize(200, 90);
		ta.setLocation(35, 180);
		ta.setEditable(false);

		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);
		f.add(tf);
		f.add(lst);
		f.add(ta);
		f.setVisible(true);
	}

	public void checkDeleteFrame() {

		chdfF = new Frame("Delete");
		chdfF.setSize(250, 160);
		chdfF.setLayout(null);
		chdfF.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent E) {
				chdfF.dispose();
			}
		});
		chdfF.setLocation(screenSize.width / 2 - 300, screenSize.height / 2 - 200);

		chdfL1 = new Label("���� �۾��� �ǵ��� �� �����ϴ�.��", Label.CENTER);
		chdfL2 = new Label("���� ������ ���������� �����ұ��?", Label.CENTER);
		chdfL1.setForeground(Color.red);
		chdfL1.setSize(250, 20);
		chdfL2.setSize(250, 20);
		chdfL1.setLocation(0, 50);
		chdfL2.setLocation(0, 80);

		chdfB1 = new Button("��");
		chdfB2 = new Button("�ƴϿ�");
		chdfB1.setSize(50, 30);
		chdfB2.setSize(50, 30);
		chdfB1.setLocation(75, 110);
		chdfB2.setLocation(125, 110);
		chdfB1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chdfF.dispose();
				deleteDAO();
				lst.remove(lst.getSelectedItem());
				completeDeleteFrame();
			}
		});
		chdfB2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chdfF.dispose();
			}
		});

		chdfF.add(chdfB1);
		chdfF.add(chdfB2);
		chdfF.add(chdfL1);
		chdfF.add(chdfL2);
		chdfF.setVisible(true);
	}

	public void completeDeleteFrame() {
		cdfF = new Frame("Complete");
		cdfF.setSize(250, 160);
		cdfF.setLayout(null);
		cdfF.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent E) {
				cdfF.dispose();
			}
		});
		cdfF.setLocation(screenSize.width / 2 - 300, screenSize.height / 2 - 200);

		cdfL1 = new Label("�����Ǿ����ϴ�.", Label.CENTER);
		cdfL2 = new Label(tf.getText() + "�� �����ϼ̽��ϴ�.", Label.CENTER);
		cdfL1.setSize(250, 20);
		cdfL2.setSize(250, 20);
		cdfL1.setLocation(0, 50);
		cdfL2.setLocation(0, 80);

		cdfB = new Button("Ȯ��");
		cdfB.setSize(50, 30);
		cdfB.setLocation(100, 110);
		cdfB.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				cdfF.dispose();
			}
		});
		cdfF.add(cdfL1);
		cdfF.add(cdfL2);
		cdfF.add(cdfB);
		cdfF.setVisible(true);
	}

	public void deleteDAO() {

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "c##ezen";
		String password = "ezen1234";
		String sql1, sql2;

		try {

			Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("oracle connection sucess.\n");
			Statement stmt = conn.createStatement();

			sql1 = "DELETE FROM PARTTIMERS where NAME = '" + lst.getSelectedItem() + "'";
			sql2 = "DELETE FROM WORKINGPARTTIMERS where NAME = '" + lst.getSelectedItem() + "'";

			boolean b = stmt.execute(sql1);
			stmt.execute(sql2);

			if (!b) {
				System.out.println("DELETE SUCCSESS.\n");
			} else {
				System.out.println("DELETE FAIL.\n");
			}

		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}
