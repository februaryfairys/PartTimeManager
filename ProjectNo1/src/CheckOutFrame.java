import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.Calendar;

public class CheckOutFrame extends AFrame {
	private Frame f;
	private Button b1, b2;
	private Label l1, l2;

	private Calendar now = Calendar.getInstance();
	private int ampm = now.get(Calendar.AM_PM);
	private String strampm = null;
	private int hour = now.get(Calendar.HOUR);
	private int minute = now.get(Calendar.MINUTE);

	public void start() {
		f = new Frame("CheckOut");
		f.setSize(250, 160);
		f.setLayout(null);
		f.addWindowListener(this);
		f.setLocation(screenSize.width / 2 - 300, screenSize.height / 2 - 200);

		if (ampm == Calendar.AM) {
			strampm = "오전 ";
		} else {
			strampm = "오후 ";
		}

		l1 = new Label("현재 시간은 " + strampm + hour + " 시 " + minute + "분 " + "입니다.",Label.CENTER);
		l2 = new Label("퇴근할까요?",Label.CENTER);
		l1.setSize(250, 20);
		l2.setSize(250, 20);
		l1.setLocation(0, 50);
		l2.setLocation(0, 80);

		b1 = new Button("네");
		b2 = new Button("아니요");
		b1.setSize(50, 30);
		b2.setSize(50, 30);
		b1.setLocation(75, 120);
		b2.setLocation(125, 120);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				CompleteOutFrame cof = new CompleteOutFrame();
				cof.start();
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

	public void windowClosing(WindowEvent E) {
		f.dispose();
	}

	public void actionPerformed(ActionEvent e) {

	}
}
