package view;
import java.awt.*;
import java.awt.event.*;

public class CompletePasswordChangeFrame extends AFrame {
	private Frame f;
	private Button b;
	private Label l1, l2;

	public void start() {
		f = new Frame("Complete");
		f.setSize(250, 160);
		f.setLayout(null);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent E) {
				f.dispose();
			}
		});
		f.setLocation(screenSize.width / 2 - 300, screenSize.height / 2 - 200);

		l1 = new Label("��й�ȣ�� ����Ǿ����ϴ�.", Label.CENTER);
		l2 = new Label("���ο� ��й�ȣ�� ����ϼ���.", Label.CENTER);
		l1.setSize(250, 20);
		l2.setSize(250, 20);
		l1.setLocation(0, 50);
		l2.setLocation(0, 80);

		b = new Button("Ȯ��");
		b.setSize(50, 30);
		b.setLocation(100, 110);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
			}
		});
		f.add(l1);
		f.add(l2);
		f.add(b);
		f.setVisible(true);
	}
}
