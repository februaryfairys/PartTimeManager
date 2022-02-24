import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextArea;
import java.awt.TextField;
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
	private Button b1, b2, b3, b4, b5, b6;
	private Label l1, l2, l3;
	private MenuBar mb;
	private TextField tf1, tf2;
	private TextArea ta1, ta2;
	JoinFrame jf = new JoinFrame();
	OutFrame of = new OutFrame();
	EmpFrame emf = new EmpFrame();
	ManagingFrame mngf = new ManagingFrame();
	AddFrame2 af = new AddFrame2();
	SetPasswordFrame spf = new SetPasswordFrame();
	ExitFrame ef = new ExitFrame();
	ShowAllPartTimers sap = new ShowAllPartTimers();
	ShowWorkingPartTimers swp = new ShowWorkingPartTimers();
	SettingsFrame sf = new SettingsFrame();

	public void start() {
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd�� E���� a HH�� mm���Դϴ�.");
		f = new Frame("Part time Manager+");
		f.setSize(610, 410);
		f.setLayout(null);
		f.addWindowListener(this);
		f.setLocation(screenSize.width / 2 - 300, screenSize.height / 2 - 200);

		mb = new MenuBar();
		Menu mParttimer = new Menu("����");
		MenuItem miJoin = new MenuItem("���üũ");
		MenuItem miOut = new MenuItem("���üũ");
		Menu mManage = new Menu("����");
		MenuItem miAdd = new MenuItem("���� ���");
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
				spf.start();

			}
		});

		miExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ef.start();
			}
		});

		b1 = new Button("�����޴�");
		b2 = new Button("�����ڸ޴�");
		b3 = new Button("����");
		b4 = new Button("����");
		b5 = new Button("���ΰ�ħ");
		b6 = new Button("���ΰ�ħ");
		b1.setSize(160, 60);
		b2.setSize(160, 60);
		b3.setSize(160, 60);
		b4.setSize(160, 60);
		b5.setSize(120, 60);
		b6.setSize(120, 60);
		b1.setLocation(415, 80);
		b2.setLocation(415, 160);
		b3.setLocation(415, 240);
		b4.setLocation(415, 320);
		b5.setLocation(55, 320);
		b6.setLocation(245, 320);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				emf.start();
			}
		});
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mngf.start();

			}
		});
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sf.start();
			}
		});

		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ef.start();
			}
		});
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				swp.start();
				ta1.setText(swp.getWorkingPartTimers());
			}
		});
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sap.start();
				ta2.setText(sap.getAllPartTimers());
			}
		});
		l1 = new Label(sdf.format(now), Label.CENTER);
		l2 = new Label("�ٹ���", Label.CENTER);
		l3 = new Label("�������", Label.CENTER);
		l1.setSize(450, 20);
		l2.setSize(160, 20);
		l3.setSize(160, 20);
		l1.setLocation(0, 60);
		l2.setLocation(35, 300);
		l3.setLocation(225, 300);
		ta1 = new TextArea();
		ta2 = new TextArea();
		ta1.setSize(160, 220);
		ta2.setSize(160, 220);
		ta1.setLocation(35, 80);
		ta2.setLocation(225, 80);
		ta1.setEditable(false);
		ta2.setEditable(false);

		f.setMenuBar(mb);
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);
		f.add(b5);
		f.add(b6);
//		f.add(l1);
		f.add(l2);
		f.add(l3);
		f.add(ta1);
		f.add(ta2);
		f.setVisible(true);

	}

	public void windowClosing(WindowEvent E) {
//		InputPasswordFrame ipf = new InputPasswordFrame();
		ef.start();
	}
}