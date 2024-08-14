package view;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

public class ExitFrame extends AFrame {
	private Frame f;
	private Button b1, b2;
	private Label l1, l2;
	private String password;

	SetPasswordFrame spf = new SetPasswordFrame();

	public String getPassword() {
		return password;
	}

	public void start(String password) {
		this.password = password;

		Calendar now = Calendar.getInstance();
		int ampm = now.get(Calendar.AM_PM);
		String strampm = null;
		int hour = now.get(Calendar.HOUR);
		int minute = now.get(Calendar.MINUTE);

		f = new Frame("Exit");
		f.setSize(250, 160);
		f.setLayout(null);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent E) {
				f.dispose();
			}
		});
		f.setLocation(screenSize.width / 2 - 300, screenSize.height / 2 - 200);

		if (ampm == Calendar.AM) {
			strampm = "���� ";
		} else {
			strampm = "���� ";
		}

		l1 = new Label("���� �ð��� " + strampm + hour + " �� " + minute + "�� " + "�Դϴ�.", Label.CENTER);
		l2 = new Label("���α׷��� �����ұ��?", Label.CENTER);
		l1.setSize(250, 20);
		l2.setSize(250, 20);
		l1.setLocation(0, 50);
		l2.setLocation(0, 80);

		b1 = new Button("��");
		b2 = new Button("�ƴϿ�");
		b1.setSize(50, 30);
		b2.setSize(50, 30);
		b1.setLocation(75, 110);
		b2.setLocation(125, 110);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
			}
		});

		f.add(b1);
		f.add(b2);
		f.add(l1);
		f.add(l2);
		f.setVisible(true);
	}
}
