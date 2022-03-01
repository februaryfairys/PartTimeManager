
import java.awt.*;
import java.awt.event.*;

public class CheckPasswordFrame extends AFrame {
	private Frame f;
	private Label l;
	private Button b;

	public void start() {
		f = new Frame("Error");
		f.setSize(250, 160);
		f.setLayout(null);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent E) {
				f.dispose();
			}
		});
		f.setLocation(screenSize.width / 2 - 300, screenSize.height / 2 - 200);

		l = new Label("올바른 비밀번호를 입력하세요.", Label.CENTER);
		l.setSize(250, 20);
		l.setLocation(0, 65);

		b = new Button("확인");
		b.setSize(50, 30);
		b.setLocation(100, 110);
		b.addActionListener(this);

		f.add(l);
		f.add(b);
		f.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		f.dispose();

	}

}
