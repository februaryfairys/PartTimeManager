import java.awt.Button;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class AddFrame extends AFrame {
	private Frame f;
	private Frame f2 = new Frame("Error");
	private TextField tf1, tf2, tf3, tf4;
	private Button b1, b2, b3;
	private Label lid, lpw, lpw2, ltel, lchpw, l2;
	private Choice r;
//	private Toolkit tk = Toolkit.getDefaultToolkit();
//	Dimension screenSize = tk.getScreenSize();
	private boolean c = false;
	private String name = " ";
	private String pw = " ";
	private String tel = " ";
	private String role = " ";

	CheckAddFrame chaf = new CheckAddFrame();
	InputYourName iyn = new InputYourName();
	InputYourPassword iyp = new InputYourPassword();
	InputYourTel iyt = new InputYourTel();

	public void start() {
		
		f = new Frame("등록");
		f.setSize(250, 420);
		f.setLayout(null);
		f.addWindowListener(this);
		f.setLocation(screenSize.width / 2 - 300, screenSize.height / 2 - 200);

		lid = new Label("성명");
		lpw = new Label("비밀번호");
		lpw2 = new Label("비밀번호 확인");
		ltel = new Label("연락처");
		lchpw = new Label("비밀번호를 입력하세요.");
		lid.setSize(55, 20);
		lpw.setSize(55, 20);
		lpw2.setSize(80, 20);
		lchpw.setSize(200, 20);
		ltel.setSize(55, 20);

		lid.setLocation(30, 40);
		lpw.setLocation(30, 100);
		lpw2.setLocation(30, 160);
		lchpw.setLocation(30, 210);
		ltel.setLocation(30, 240);

		tf1 = new TextField();
		tf2 = new TextField();
		tf3 = new TextField();
		tf4 = new TextField();
		tf1.setSize(200, 20);
		tf2.setSize(200, 20);
		tf3.setSize(200, 20);
		tf4.setSize(200, 20);
		tf1.setLocation(25, 65);
		tf2.setLocation(25, 125);
		tf3.setLocation(25, 185);
		tf4.setLocation(25, 265);

		b1 = new Button("등록");
		b2 = new Button("일치 확인");
		b1.setSize(200, 50);
		b2.setSize(60, 25);
		b1.setLocation(25, 340);
		b2.setLocation(115, 155);
		b1.addActionListener(this);
		b2.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tf2.getText().equals(tf3.getText()) && tf2.getText() != null) {
					c = true;
				} else {
					c = false;
				}

				if (c == true) {
					lchpw.setText("비밀번호가 일치합니다.");
				} else {
					lchpw.setText("비밀번호가 일치하지 않습니다.");
				}
			}
		});

		r = new Choice();
		r.add("직원");
		r.add("매니저");
		r.setSize(100, 100);
		r.setLocation(25, 300);

		f.add(lid);
		f.add(lpw);
		f.add(lpw2);
		f.add(ltel);
		f.add(lchpw);
		f.add(tf1);
		f.add(tf2);
		f.add(tf3);
		f.add(tf4);
		f.add(b1);
		f.add(b2);
		f.add(r);
		f.setVisible(true);

	}

	public void frame2() {

		l2 = new Label("비밀번호 일치 확인을 해주세요.", Label.CENTER);
		f2.setSize(250, 150);
		f2.setLayout(null);
		f2.addWindowListener(this);
		f2.setLocation(screenSize.width / 2 - 300, screenSize.height / 2 - 200);

		l2.setSize(250, 20);
		l2.setLocation(0, 55);
		b3 = new Button("확인");
		b3.setSize(60, 30);
		b3.setLocation(95, 100);
		b3.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f2.dispose();

			}
		});

		f2.add(b3);
		f2.add(l2);
		f2.setVisible(true);
	}

	public void windowClosing(WindowEvent E) {
		f.dispose();
	
	}

	public void actionPerformed(ActionEvent e) {

		if (tf1.getText().equals("")) {
			iyn.start();
		} else if (tf2.getText().equals("")) {
			iyp.start();
		} else if (tf3.getText().equals("")) {
			iyp.start();
		} else if (tf4.getText().equals("")) {
			iyt.start();
		} else {
			if (c != true) {
				frame2();
			} else {
				name = tf1.getText();
				name = tf1.getText();
				pw = tf2.getText();
				tel = tf4.getText();
				role = r.getSelectedItem();
				setName(name);
				setPw(pw);
				setTel(tel);
				setRole(role);
				chaf.start();
				f.dispose();
			}
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}