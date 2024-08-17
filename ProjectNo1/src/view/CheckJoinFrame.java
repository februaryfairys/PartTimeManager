package view;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;

public class CheckJoinFrame extends AFrame {
	private Frame f;
	private Label l1, l2;
	private Button b1, b2;

	public void start(String name, String password) {
		Calendar now = Calendar.getInstance();
		int ampm = now.get(Calendar.AM_PM);
		String strampm = null;
		int hour = now.get(Calendar.HOUR);
		int minute = now.get(Calendar.MINUTE);

		f = new Frame("CheckJoin");
		f.setSize(250, 160);
		f.setLayout(null);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent E) {
				f.dispose();
			}
		});
		f.setLocation(screenSize.width / 2 - 300, screenSize.height / 2 - 200);

		if (ampm == Calendar.AM) {
			strampm = "오전 ";
		} else {
			strampm = "오후 ";
		}

		l1 = new Label("현재 시간은 " + strampm + hour + " 시 " + minute + "분 " + "입니다.", Label.CENTER);
		l2 = new Label("출근할까요?", Label.CENTER);
		l1.setSize(250, 20);
		l2.setSize(250, 20);
		l1.setLocation(0, 50);
		l2.setLocation(0, 80);

		b1 = new Button("네");
		b2 = new Button("아니요");
		b1.setSize(50, 30);
		b2.setSize(50, 30);
		b1.setLocation(75, 110);
		b2.setLocation(125, 110);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JoinFrame jf = new JoinFrame();
				jf.checkDAO(name, password);
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
