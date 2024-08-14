package view;
import java.awt.*;
import java.awt.event.*;

public class InputYourInfo extends AFrame {
	private Frame f;
	private Label L;
	private Button B;
	private String s;

	public void start(String S) {

		s = "";

		if (S == "name") {
			s = "������ �Է��ϼ���.";
		}
		if (S == "password") {
			s = "������ȣ�� �Է��ϼ���.";
		}
		if (S == "tel") {
			s = "����ó�� �Է��ϼ���.";
		}
		f = new Frame("Error");
		f.setSize(250, 160);
		f.setLayout(null);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent E) {
				f.dispose();
			}
		});
		f.setLocation(screenSize.width / 2 - 300, screenSize.height / 2 - 200);
		
		L = new Label(s, Label.CENTER);
		L.setSize(250, 20);
		L.setLocation(0, 65);
		
		B = new Button("Ȯ��");
		B.setSize(50, 30);
		B.setLocation(100, 110);
		B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
			}
		});

		f.add(L);
		f.add(B);
		f.setVisible(true);
	}
}
