import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CompleteAddFrame extends AFrame {
	private Frame f;
	private Button b;
	private Label fL1, l2;
	ValuesClass vc = new ValuesClass();

	public void start() {
		f = new Frame("��ϿϷ�");
		f.setSize(250, 150);
		f.setLayout(null);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent E) {
				f.dispose();
			}
		});
		f.setLocation(screenSize.width / 2 - 300, screenSize.height / 2 - 200);

		fL1 = new Label("��ϵǾ����ϴ�.", Label.CENTER);
		l2 = new Label(vc.getName() + "�� ȯ���մϴ�.", Label.CENTER);
		fL1.setSize(250, 20);
		fL1.setLocation(0, 40);
		l2.setSize(250, 20);
		l2.setLocation(0, 70);

		b = new Button("Ȯ��");
		b.setSize(60, 30);
		b.setLocation(95, 100);
		b.addActionListener(this);
		f.add(fL1);
		f.add(l2);
		f.add(b);
		f.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		f.dispose();

	}
}
