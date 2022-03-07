import java.awt.*;
import java.awt.event.*;

public class InputYourInfo extends AFrame {
	private Frame nF, pF, tF;
	private Label nL, pL, tL;
	private Button nB, pB, tB;
	private String s;

	public void name() {
		nF = new Frame("Error");
		nF.setSize(250, 160);
		nF.setLayout(null);
		nF.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent E) {
				nF.dispose();
			}
		});
		nF.setLocation(screenSize.width / 2 - 300, screenSize.height / 2 - 200);

		nL = new Label("성명을 입력하세요.", Label.CENTER);
		nL.setSize(250, 20);
		nL.setLocation(0, 65);

		nB = new Button("확인");
		nB.setSize(50, 30);
		nB.setLocation(100, 110);
		nB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nF.dispose();
			}
		});

		nF.add(nL);
		nF.add(nB);
		nF.setVisible(true);
	}

	public void password() {
		pF = new Frame("Error");
		pF.setSize(250, 160);
		pF.setLayout(null);
		pF.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent E) {
				pF.dispose();
			}
		});
		pF.setLocation(screenSize.width / 2 - 300, screenSize.height / 2 - 200);

		pL = new Label("비밀번호를 입력하세요.", Label.CENTER);
		pL.setSize(250, 20);
		pL.setLocation(0, 65);

		pB = new Button("확인");
		pB.setSize(50, 30);
		pB.setLocation(100, 110);
		pB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pF.dispose();
			}
		});
		pF.add(pL);
		pF.add(pB);
		pF.setVisible(true);
	}

	public void tel() {
		tF = new Frame("Error");
		tF.setSize(250, 160);
		tF.setLayout(null);
		tF.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent E) {
				tF.dispose();
			}
		});
		tF.setLocation(screenSize.width / 2 - 300, screenSize.height / 2 - 200);

		tL = new Label("연락처를 입력하세요.", Label.CENTER);
		tL.setSize(250, 20);
		tL.setLocation(0, 65);

		tB = new Button("확인");
		tB.setSize(50, 30);
		tB.setLocation(100, 110);
		tB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tF.dispose();
			}
		});

		tF.add(tL);
		tF.add(tB);
		tF.setVisible(true);
	}

	public void start(String S) {

		s = "";

		if (S == "name") {
			s = "rr을 입력하세요.";
		}
		if (S == "password") {
			s = "직원번호를 입력하세요.";
		}
		if (S == "tel") {
			s = "연락처를 입력하세요.";
		}
		nF = new Frame("Error");
		nF.setSize(250, 160);
		nF.setLayout(null);
		nF.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent E) {
				nF.dispose();
			}
		});
		nF.setLocation(screenSize.width / 2 - 300, screenSize.height / 2 - 200);

		nL = new Label("성명을 입력하세요.", Label.CENTER);
		nL.setSize(250, 20);
		nL.setLocation(0, 65);

		nB = new Button("확인");
		nB.setSize(50, 30);
		nB.setLocation(100, 110);
		nB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nF.dispose();
			}
		});

		nF.add(nL);
		nF.add(nB);
		nF.setVisible(true);
	}

}
