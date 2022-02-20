import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CompletePasswordChangeFrame extends AFrame {
	private Frame f;
	private Button b;
	private Label l1, l2;

	public void start() {
		f = new Frame("변경완료");
		f.setSize(250, 150);
		f.setLayout(null);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent E) {
				f.dispose();
			}
		});
		f.setLocation(screenSize.width / 2 - 300, screenSize.height / 2 - 200);

		l1 = new Label("비밀번호가 변경되었습니다.", Label.CENTER);
		l2 = new Label("비밀번호가 변경되었습니다.", Label.CENTER);
		l1.setSize(250, 20);
		l1.setLocation(0, 40);
		l2.setSize(250, 20);
		l2.setLocation(0, 70);

		b = new Button("확인");
		b.setSize(60, 30);
		b.setLocation(95, 100);
		b.addActionListener(this);
//		f.add(l1);
		f.add(l2);
		f.add(b);
		f.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		f.dispose();

	}
}
