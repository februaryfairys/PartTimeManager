package view;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import dao.DAO;

public class CheckEditFrame extends AFrame {
	private Frame f;
	private Label l;
	private Button b1, b2;
	private String name, sub, val, role;

	public String getName() {
		return name;
	}

	public String getVal() {
		return val;
	}

	public String getSub() {
		return sub;
	}

	public String getRole() {
		return role;
	}

	public void start(String name, String sub, String val, String role) {
		this.name = name;
		this.sub = sub;
		this.val = val;
		this.role = role;

		f = new Frame("Edit");
		f.setSize(250, 160);
		f.setLayout(null);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent E) {
				f.dispose();
			}
		});
		f.setLocation(screenSize.width / 2 - 300, screenSize.height / 2 - 200);

		l = new Label(getName() + "님의 직원 정보를 수정할까요?", Label.CENTER);
		l.setSize(250, 20);
		l.setLocation(0, 65);

		b1 = new Button("네");
		b2 = new Button("아니요");
		b1.setSize(50, 30);
		b2.setSize(50, 30);
		b1.setLocation(75, 110);
		b2.setLocation(125, 110);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DAO dao = new DAO();
				CompleteEditFrame cef = new CompleteEditFrame();
				f.dispose();
				dao.edit(getName(), getSub(), getVal(), getRole());
				if (sub.equals("성명")) {
					cef.start(getVal());
				} else {
					cef.start(getName());
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
		f.add(l);
		f.setVisible(true);
	}

}
