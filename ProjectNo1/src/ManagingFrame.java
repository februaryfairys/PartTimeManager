import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ManagingFrame extends AFrame {

	private Frame f;
	private Button b1, b2, b3;
	AddFrame2 af = new AddFrame2();
	ExitFrame ef = new ExitFrame();

	public void start() {
		f = new Frame("Management");
		f.setSize(250, 300);
		f.setLayout(null);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent E) {
				f.dispose();
			}
		});
		f.setLocation(screenSize.width / 2 - 300, screenSize.height / 2 - 200);

		b1 = new Button("직원등록");
		b2 = new Button("수정/삭제");
		b3 = new Button("프로그램종료");
		b1.setSize(210, 75);
		b1.setLocation(20, 50);
		b2.setSize(210, 75);
		b2.setLocation(20, 130);
		b3.setSize(210, 75);
		b3.setLocation(20, 210);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				af.start();
			}
		});
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
			}
		});
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ef.start();
			}
		});
		f.add(b1);
		f.add(b2);
//		f.add(b3);
		f.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {

	}
}
