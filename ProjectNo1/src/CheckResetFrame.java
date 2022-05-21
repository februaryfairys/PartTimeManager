import java.awt.*;
import java.awt.event.*;

import Project1.dao.DAO;

public class CheckResetFrame extends AFrame {
	private Frame f;
	private Label l1, l2;
	private Button b1, b2;
	DAO dao = new DAO();
	CompleteResetFrame crf = new CompleteResetFrame();

	public void start() {

		f = new Frame("Delete");
		f.setSize(250, 160);
		f.setLayout(null);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent E) {
				f.dispose();
			}
		});
		f.setLocation(screenSize.width / 2 - 300, screenSize.height / 2 - 200);

		l1 = new Label("※이 작업은 되돌릴 수 없습니다.※", Label.CENTER);
		l2 = new Label("프로그램과 데이터를 초기화할까요?", Label.CENTER);
		l1.setForeground(Color.red);
		l1.setSize(250, 20);
		l2.setSize(250, 20);
		l1.setLocation(0, 50);
		l2.setLocation(0, 80);

		b1 = new Button("네");
		b2 = new Button("아니요");
		b1.setSize(50, 30);
		b2.setSize(50, 30);
		b1.setLocation(75, 110);
		b2.setLocation(125, 110);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dao.reset();
				crf.start();
				f.dispose();
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
