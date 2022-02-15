import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Label;
import java.awt.MenuBar;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainFrame extends AFrame {
	private Frame f;
	private Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension screenSize = tk.getScreenSize();
	private Button b1, b2, b3;
	private Label l1;
	private MenuBar mb;

	public void start() {
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 a HH시 mm분입니다.");
		f = new Frame("Part time Manager+");
		f.setSize(450, 400);
		f.setLayout(null);
		f.setLocation(screenSize.width / 2 - 300, screenSize.height / 2 - 200);
		mb = new MenuBar();
		
		b1 = new Button("출근체크");
		b2 = new Button("퇴근하기");
		b3 = new Button("직원관리");
//		b4 = new Button("종료하기");
		b1.setSize(150, 100);
		b2.setSize(150, 100);
		b3.setSize(150, 100);
//		b4.setSize(150, 100);
		b1.setLocation(0, 300);
		b2.setLocation(150, 300);
		b3.setLocation(300, 300);
//		b4.setLocation(450, 300);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
//		b4.addActionListener(this);

//	
//		l1 = new Label(year + "년 " + month + "월 " + date + "일 " + strampm + hour + "시 " + minute + "분" + "입니다."+day,
//				Label.LEFT);
		
		l1 = new Label(sdf.format(now));
		l1.setSize(300, 20);
		l1.setLocation(20, 40);
		f.add(b1);
		f.add(b2);
		f.add(b3);
//		f.add(b4);
		f.add(l1);

		f.setVisible(true);
		f.addWindowListener(this);
	}

	public void mb() {

	}

	public void windowClosing(WindowEvent E) {
		System.exit(0);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("출근체크")) {
			JoinFrame jf = new JoinFrame();
			jf.start();
		}
		if (e.getActionCommand().equals("퇴근하기")) {
			OutFrame of = new OutFrame();
			of.start();
		}
		if (e.getActionCommand().equals("직원관리")) {
			ManagingFrame mngf = new ManagingFrame();
			mngf.start();
		}

	}
}