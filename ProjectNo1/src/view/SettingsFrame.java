package view;
import java.awt.*;
import java.awt.event.*;

public class SettingsFrame extends AFrame {

	private Frame f;
	private Button b1, b2, b3;
	SettingsFrame2 sf2 = new SettingsFrame2();
	SetPayFrame spf = new SetPayFrame();

	public void start() {
		f = new Frame("Setting");
		f.setSize(230, 305);
		f.setLayout(null);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent E) {
				f.dispose();
			}
		});
		f.setLocation(screenSize.width / 2 - 300, screenSize.height / 2 - 200);

		b1 = new Button("급여 설정");
		b2 = new Button("프로그램 설정");
		b3 = new Button("닫기");
		b1.setSize(160, 60);
		b2.setSize(160, 60);
		b3.setSize(160, 60);
		b1.setLocation(35, 50);
		b2.setLocation(35, 130);
		b3.setLocation(35, 210);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				spf.start();
			}
		});
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				sf2.start();
			}
		});
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
			}
		});
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.setVisible(true);

	}
}
