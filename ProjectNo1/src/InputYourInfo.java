import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputYourInfo extends AFrame {
	private Frame nF, pF, tF;
	private Label nL, pL, tL;
	private Button nB, pB, tB;

	public void name() {
		nF = new Frame("Error");
		nF.setSize(250, 150);
		nF.setLayout(null);
		nF.addWindowListener(this);
		nF.setLocation(screenSize.width / 2 - 300, screenSize.height / 2 - 200);

		nL = new Label("성명을 입력하세요.", Label.CENTER);
		nL.setSize(250, 50);
		nL.setLocation(0, 45);

		nB = new Button("확인");
		nB.setSize(60, 30);
		nB.setLocation(95, 100);
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
		pF.setSize(250, 150);
		pF.setLayout(null);
		pF.addWindowListener(this);
		pF.setLocation(screenSize.width / 2 - 300, screenSize.height / 2 - 200);

		pL = new Label("비밀번호를 입력하세요.", Label.CENTER);
		pL.setSize(250, 50);
		pL.setLocation(0, 45);

		pB = new Button("확인");
		pB.setSize(60, 30);
		pB.setLocation(95, 100);
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
		tF.setSize(250, 150);
		tF.setLayout(null);
		tF.addWindowListener(this);
		tF.setLocation(screenSize.width / 2 - 300, screenSize.height / 2 - 200);

		tL = new Label("연락처를 입력하세요.", Label.CENTER);
		tL.setSize(250, 50);
		tL.setLocation(0, 45);

		tB = new Button("확인");
		tB.setSize(60, 30);
		tB.setLocation(95, 100);
		tB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tF.dispose();
			}
		});

		tF.add(tL);
		tF.add(tB);
		tF.setVisible(true);
	}

}
