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

		nL = new Label("������ �Է��ϼ���.", Label.CENTER);
		nL.setSize(250, 20);
		nL.setLocation(0, 65);

		nB = new Button("Ȯ��");
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

		pL = new Label("��й�ȣ�� �Է��ϼ���.", Label.CENTER);
		pL.setSize(250, 20);
		pL.setLocation(0, 65);

		pB = new Button("Ȯ��");
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

		tL = new Label("����ó�� �Է��ϼ���.", Label.CENTER);
		tL.setSize(250, 20);
		tL.setLocation(0, 65);

		tB = new Button("Ȯ��");
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
			s = "rr�� �Է��ϼ���.";
		}
		if (S == "password") {
			s = "������ȣ�� �Է��ϼ���.";
		}
		if (S == "tel") {
			s = "����ó�� �Է��ϼ���.";
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

		nL = new Label("������ �Է��ϼ���.", Label.CENTER);
		nL.setSize(250, 20);
		nL.setLocation(0, 65);

		nB = new Button("Ȯ��");
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
