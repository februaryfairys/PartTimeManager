import java.awt.Button;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	JoinFrame jf = new JoinFrame();
	OutFrame of = new OutFrame();
	ManagingFrame mngf = new ManagingFrame();
	AddFrame2 af = new AddFrame2();

	public void start() {
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 a HH시 mm분입니다.");
		f = new Frame("Part time Manager+");
		f.setSize(450, 400);
		f.setLayout(null);
		f.setLocation(screenSize.width / 2 - 300, screenSize.height / 2 - 200);

		mb = new MenuBar();
//		mb.setFont(new Font("맑은 고딕", Font.PLAIN,12));
		Menu mParttimer = new Menu("직원");
		MenuItem miJoin = new MenuItem("출근");
		MenuItem miOut = new MenuItem("퇴근");
		Menu mManage = new Menu("관리");
		MenuItem miAdd = new MenuItem("등록");
		MenuItem miEdit = new MenuItem("수정/삭제");
		Menu mSetting = new Menu("설정");
		MenuItem miPw = new MenuItem("비밀번호 변경");
		MenuItem miExit = new MenuItem("프로그램 종료");
		mParttimer.add(miJoin);
		mParttimer.add(miOut);
		mManage.add(miAdd);
		mManage.add(miEdit);
		mSetting.add(miPw);
		mSetting.add(miExit);
		mb.add(mParttimer);
		mb.add(mManage);
		mb.add(mSetting);
		miJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jf.start();

			}
		});
		miOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				of.start();

			}
		});
		miAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				af.start();

			}
		});
		miEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jf.start();

			}
		});
		miPw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jf.start();

			}
		});
		miExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});

		b1 = new Button("출근체크");
		b2 = new Button("퇴근체크");
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
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jf.start();

			}
		});
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				of.start();

			}
		});
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mngf.start();

			}
		});
//		b4.addActionListener(this);

//	
//		l1 = new Label(year + "년 " + month + "월 " + date + "일 " + strampm + hour + "시 " + minute + "분" + "입니다."+day,
//				Label.LEFT);

		l1 = new Label(sdf.format(now), Label.CENTER);
		l1.setSize(450, 20);
		l1.setLocation(0, 60);
		f.setMenuBar(mb);
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

	}
}