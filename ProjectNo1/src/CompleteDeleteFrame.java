import java.awt.*;
import java.awt.event.*;

public class CompleteDeleteFrame extends AFrame {

	private Frame f;
	private Label l1, l2;
	private Button b;
	private String name;

	public String getName() {
		return name;
	}

	public void start(String name) {
		this.name = name;
		
		f = new Frame("Complete");
		f.setSize(250, 160);
		f.setLayout(null);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent E) {
				f.dispose();
			}
		});
		f.setLocation(screenSize.width / 2 - 300, screenSize.height / 2 - 200);

		l1 = new Label("삭제되었습니다.", Label.CENTER);
		l2 = new Label(getName() + "님 수고하셨습니다.", Label.CENTER);
		l1.setSize(250, 20);
		l2.setSize(250, 20);
		l1.setLocation(0, 50);
		l2.setLocation(0, 80);

		b = new Button("확인");
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
