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
			s = "성명을 입력하세요.";
		}
		if (S == "password") {
			s = "직원번호를 입력하세요.";
		}
		if (S == "tel") {
			s = "연락처를 입력하세요.";
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
		
		B = new Button("확인");
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
