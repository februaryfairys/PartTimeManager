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
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd�� E���� a HH�� mm���Դϴ�.");
		f = new Frame("Part time Manager+");
		f.setSize(450, 400);
		f.setLayout(null);
		f.setLocation(screenSize.width / 2 - 300, screenSize.height / 2 - 200);

		mb = new MenuBar();
//		mb.setFont(new Font("���� ���", Font.PLAIN,12));
		Menu mParttimer = new Menu("����");
		MenuItem miJoin = new MenuItem("���");
		MenuItem miOut = new MenuItem("���");
		Menu mManage = new Menu("����");
		MenuItem miAdd = new MenuItem("���");
		MenuItem miEdit = new MenuItem("����/����");
		Menu mSetting = new Menu("����");
		MenuItem miPw = new MenuItem("��й�ȣ ����");
		MenuItem miExit = new MenuItem("���α׷� ����");
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

		b1 = new Button("���üũ");
		b2 = new Button("���üũ");
		b3 = new Button("��������");
//		b4 = new Button("�����ϱ�");
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
//		l1 = new Label(year + "�� " + month + "�� " + date + "�� " + strampm + hour + "�� " + minute + "��" + "�Դϴ�."+day,
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