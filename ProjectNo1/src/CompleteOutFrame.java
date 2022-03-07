import java.awt.*;
import java.awt.event.*;

public class CompleteOutFrame extends AFrame {
	private Frame f;
	private Button b;
	private Label l1, l2;
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void start() {
		f = new Frame("Out");
		f.setSize(250, 160);
		f.setLayout(null);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent E) {
				f.dispose();
			}
		});
		f.setLocation(screenSize.width / 2 - 300, screenSize.height / 2 - 200);

		l1 = new Label("Åð±ÙÇß½À´Ï´Ù.", Label.CENTER);
		l2 = new Label(getName() + "´Ô ¼ö°íÇÏ¼Ì½À´Ï´Ù.", Label.CENTER);
		l1.setSize(250, 20);
		l2.setSize(250, 20);
		l1.setLocation(0, 50);
		l2.setLocation(0, 80);

		b = new Button("Ok");
		b.setSize(50, 30);
		b.setLocation(100, 110);
		b.addActionListener(this);
		f.add(l1);
		f.add(l2);
		f.add(b);
		f.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		f.dispose();

	}
}
