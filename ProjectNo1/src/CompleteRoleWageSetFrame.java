import java.awt.*;
import java.awt.event.*;

public class CompleteRoleWageSetFrame extends AFrame {
	private Frame f;
	private Label l;
	private Button b;

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

		l = new Label("���ҿ� ���� �ӱ� ������ �Ϸ�Ǿ����ϴ�.", Label.CENTER);
		l.setSize(250, 20);
		l.setLocation(0, 65);

		b = new Button("Ȯ��");
		b.setSize(50, 30);
		b.setLocation(100, 110);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();

			}
		});
		f.add(l);
		f.add(b);
		f.setVisible(true);
	}

}
