package view;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EditFrame extends AFrame {
	private Frame f;
	private TextField tf;
	private Label l1, l2, l3, l4, l5;
	private Choice c, c2;
	private Button b;
	private String name, sub, val, role;

	InputYourInfo iyi = new InputYourInfo();
	CheckEditFrame chef = new CheckEditFrame();

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

		l1 = new Label(getName() + "님의 직원정보를 수정합니다", Label.CENTER);
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
					iyi.start("name");
				} else if (c.getSelectedItem().equals("연락처") && tf.getText().equals("")) {
					iyi.start("tel");
				} else if (c.getSelectedItem().equals("성명") && !(tf.getText().length() >= 2)) {
					l4.setText("두 글자 이상 입력하세요.");
				} else if (c.getSelectedItem().equals("연락처")
						&& (tf.getText().length() > 11 || tf.getText().length() < 10)) {
					l4.setText("올바른 연락처를 입력하세요.");
				} else if ((c.getSelectedItem().equals("성명") && tf.getText().length() >= 2)
						|| (c.getSelectedItem().equals("연락처")
								&& (tf.getText().length() == 11 || tf.getText().length() == 10))) {
					name = getName();
					sub = c.getSelectedItem();
					val = tf.getText();
					role = c2.getSelectedItem();
					chef.start(name, sub, val, role);
					f.dispose();
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
}
