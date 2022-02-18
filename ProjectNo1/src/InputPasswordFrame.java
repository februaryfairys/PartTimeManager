import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

public class InputPasswordFrame extends AFrame {
	private Frame f;
	private TextField tf1;
	private Button b1;
	private Label lpw;

	public void start() {
		f = new Frame("Input Password");
		f.setSize(300, 180);
		f.setLayout(null);
		f.addWindowListener(this);
		f.setLocation(screenSize.width / 2 - 300, screenSize.height / 2 - 200);

		tf1 = new TextField("");
		tf1.setSize(150, 20);
		tf1.setLocation(75, 80);

		b1 = new Button("Ok");
		b1.setSize(150, 50);
		b1.setLocation(75, 120);
		b1.addActionListener(this);
		lpw = new Label("비밀번호를 입력하세요.");
		lpw.setSize(130, 20);
		lpw.setLocation(85, 60);
		f.add(b1);
		f.add(tf1);
		f.add(lpw);
		f.setVisible(true);
	}

	public void windowClosing(WindowEvent E) {
		f.dispose();
	}

	public void actionPerformed(ActionEvent e) {
		


	}
}
