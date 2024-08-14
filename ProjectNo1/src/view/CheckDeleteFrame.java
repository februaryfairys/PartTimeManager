package view;
import java.awt.*;
import java.awt.event.*;

public class CheckDeleteFrame extends AFrame {

	private Frame f;
	private Label l1, l2;
	private Button b1, b2;
	private String name;

	public String getName() {
		return name;
	}



	public void start(String name) {
		this.name = name;

		f = new Frame("Delete");
		f.setSize(250, 160);
		f.setLayout(null);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent E) {
				f.dispose();
			}
		});
		f.setLocation(screenSize.width / 2 - 300, screenSize.height / 2 - 200);

		l1 = new Label("���� �۾��� �ǵ��� �� �����ϴ�.��", Label.CENTER);
		l2 = new Label("���� ������ ���������� �����ұ��?", Label.CENTER);
		l1.setForeground(Color.red);
		l1.setSize(250, 20);
		l2.setSize(250, 20);
		l1.setLocation(0, 50);
		l2.setLocation(0, 80);

		b1 = new Button("��");
		b2 = new Button("�ƴϿ�");
		b1.setSize(50, 30);
		b2.setSize(50, 30);
		b1.setLocation(75, 110);
		b2.setLocation(125, 110);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LookUpFrame luf = new LookUpFrame();
				CompleteDeleteFrame cdf = new CompleteDeleteFrame();
				luf.deleteDAO(getName());
				cdf.start(getName());
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
