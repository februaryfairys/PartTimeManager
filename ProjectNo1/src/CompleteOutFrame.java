import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

public class CompleteOutFrame extends AFrame {
	private Frame f;
	private Button b;
	private Label l1, l2;
	OutFrame of = new OutFrame();
	public void start() {
		f = new Frame("Checked Out");
		f.setSize(250, 150);
		f.setLayout(null);
		f.addWindowListener(this);
		f.setLocation(screenSize.width / 2 - 300, screenSize.height / 2 - 200);

		l1 = new Label("Åð±ÙÇß½À´Ï´Ù.", Label.CENTER);
		l2 = new Label(of.getName() + "´Ô ¼ö°íÇÏ¼Ì½À´Ï´Ù.", Label.CENTER);
		l1.setSize(250, 50);
		l2.setSize(250, 50);
		l1.setLocation(0, 40);
		l2.setLocation(0, 40);

		b = new Button("Ok");
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

	public void windowClosing(WindowEvent E) {
		f.dispose();
	}

}
