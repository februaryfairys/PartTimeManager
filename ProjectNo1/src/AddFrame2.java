import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AddFrame2 extends AFrame {
	private Frame f, f2, chaf, cafF;
	private TextField tf1, tf2, tf3, tf4;
	private Button b1, b2, bRd, b3, chafB1, chafB2, cafB;
	private Label lid, lid2, lpw, lpw2, ltel, ltel2, lchpw, lError, chafL2, cafL1, cafL2;
	private Choice r;
	private boolean c = false;
	private String NAME;
	private String PW;
	private String TEL;
	private String ROLE;

	InputYourInfo iyi = new InputYourInfo();

	public void start() {

		f = new Frame("Add");
		f.setSize(270, 465);
		f.setLayout(null);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent E) {
				f.dispose();
			}
		});
		f.setLocation(screenSize.width / 2 - 300, screenSize.height / 2 - 200);

		lid = new Label("성명");
		lid2 = new Label("");
		lpw = new Label("직원번호");
		lpw2 = new Label("직원번호 확인");
		ltel = new Label("연락처");
		ltel2 = new Label("");
		lchpw = new Label("직원번호를 입력하세요.");
		lid2.setForeground(Color.red);
		ltel2.setForeground(Color.RED);
		lid.setSize(30, 20);
		lid2.setSize(180, 20);
		lpw.setSize(55, 20);
		lpw2.setSize(80, 20);
		lchpw.setSize(200, 20);
		ltel.setSize(36, 20);
		ltel2.setSize(180, 20);

		lid.setLocation(40, 40);
		lid2.setLocation(40, 90);
		lpw.setLocation(40, 120);
		lpw2.setLocation(40, 180);
		lchpw.setLocation(40, 230);
		ltel.setLocation(40, 260);
		ltel2.setLocation(40, 310);

		tf1 = new TextField();
		tf2 = new TextField("버튼을 눌러 번호를 발급받으세요.");
		tf3 = new TextField();
		tf4 = new TextField();
		tf1.setSize(200, 20);
		tf2.setSize(200, 20);
		tf3.setSize(200, 20);
		tf4.setSize(200, 20);
		tf1.setLocation(35, 65);
		tf2.setLocation(35, 145);
		tf3.setLocation(35, 205);
		tf4.setLocation(35, 285);
		tf2.setEditable(false);

		b1 = new Button("등록");
		b2 = new Button("일치 확인");
		bRd = new Button("번호 발급");
		b1.setSize(200, 50);
		b2.setSize(60, 25);
		bRd.setSize(60, 25);
		b1.setLocation(35, 385);
		b2.setLocation(125, 175);
		bRd.setLocation(125, 115);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tf1.getText().equals("")) {
					iyi.name();
				} else if (!(tf1.getText().length() >= 2)) {
					lid2.setText("두 글자 이상 입력하세요.");
				} else if (tf3.getText().equals("")) {
					iyi.password();
				} else if (c != true) {
					checkPasswordcheckFrame();
				} else if (!(tf2.getText().equals(tf3.getText()))) {
					checkPasswordcheckFrame();
					c = false;
				} else if (tf4.getText().equals("")) {
					iyi.tel();
				} else if (tf4.getText().length() > 11 || tf4.getText().length() < 10) {
					ltel2.setText("올바른 연락처를 입력하세요.");
				} else {
					if (tf1.getText().length() >= 2 && tf2.getText().equals(tf3.getText()) && c == true
							&& tf4.getText().length() >= 10 && tf4.getText().length() <= 11) {
						setNAME(tf1.getText());
						setPW(tf2.getText());
						setTEL(tf4.getText());
						setROLE(r.getSelectedItem());
						checkAddFrame();
						c = false;
					}

				}
			}
		});
		b2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (tf2.getText().equals(tf3.getText()) && tf2.getText() != null) {
					c = true;
				} else {
					c = false;
				}

				if (c == true) {
					lchpw.setText("직원번호가 일치합니다.");
				} else {
					lchpw.setText("직원번호가 일치하지 않습니다.");
				}
			}
		});
		bRd.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int[] rd = new int[4];
				String[] Rd = new String[4];

				for (int i = 0; i < 4; i++) {

					rd[i] = (int) (Math.random() * 9) + 1;
					Rd[i] = rd[i] + " ";
				}
				String password = Rd[0].trim() + Rd[1].trim() + Rd[2].trim() + Rd[3].trim();
				tf2.setText(password);
			}
		});
		r = new Choice();
		r.add("직원");
		r.add("매니저");
		r.setSize(100, 100);
		r.setLocation(35, 345);

		f.add(lid);
		f.add(lid2);
		f.add(lpw);
		f.add(lpw2);
		f.add(ltel);
		f.add(ltel2);
		f.add(lchpw);
		f.add(tf1);
		f.add(tf2);
		f.add(tf3);
		f.add(tf4);
		f.add(b1);
		f.add(b2);
		f.add(bRd);
		f.add(r);
		f.setVisible(true);

	}

	public void checkPasswordcheckFrame() {

		f2 = new Frame("Error");
		f2.setSize(250, 160);
		f2.setLayout(null);
		f2.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent E) {
				f2.dispose();
			}
		});
		f2.setLocation(screenSize.width / 2 - 300, screenSize.height / 2 - 200);

		lError = new Label("직원번호 일치 확인을 해주세요.", Label.CENTER);
		lError.setSize(250, 20);
		lError.setLocation(0, 65);
		b3 = new Button("확인");
		b3.setSize(50, 30);
		b3.setLocation(100, 110);
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f2.dispose();
				lError.setText("직원번호 일치 확인을 해주세요.");
			}
		});
		f2.add(b3);
		f2.add(lError);
		f2.setVisible(true);
	}

	public void checkAddFrame() {

		chaf = new Frame("등록");
		chaf.setSize(250, 160);
		chaf.setLayout(null);
		chaf.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent E) {
				chaf.dispose();
			}
		});
		chaf.setLocation(screenSize.width / 2 - 300, screenSize.height / 2 - 200);

		chafL2 = new Label("새로운 직원을 등록할까요?", Label.CENTER);
		chafL2.setSize(250, 20);
		chafL2.setLocation(0, 65);

		chafB1 = new Button("네");
		chafB2 = new Button("아니요");
		chafB1.setSize(50, 30);
		chafB2.setSize(50, 30);
		chafB1.setLocation(75, 110);
		chafB2.setLocation(125, 110);
		chafB1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chaf.dispose();
				f.dispose();
				addDAO();
				completeAddFrame();
			}
		});
		chafB2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chaf.dispose();
			}
		});

		chaf.add(chafB1);
		chaf.add(chafB2);
		chaf.add(chafL2);
		chaf.setVisible(true);
	}

	public void completeAddFrame() {
		cafF = new Frame("등록완료");
		cafF.setSize(250, 160);
		cafF.setLayout(null);
		cafF.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent E) {
				cafF.dispose();
			}
		});
		cafF.setLocation(screenSize.width / 2 - 300, screenSize.height / 2 - 200);

		cafL1 = new Label("등록되었습니다.", Label.CENTER);
		cafL2 = new Label(getNAME() + "님 환영합니다.", Label.CENTER);
		cafL1.setSize(250, 20);
		cafL1.setLocation(0, 50);
		cafL2.setSize(250, 20);
		cafL2.setLocation(0, 80);

		cafB = new Button("확인");
		cafB.setSize(50, 30);
		cafB.setLocation(100, 110);
		cafB.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				cafF.dispose();
			}
		});
		cafF.add(cafL1);
		cafF.add(cafL2);
		cafF.add(cafB);
		cafF.setVisible(true);
	}

	public void addDAO() {

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "c##ezen";
		String password = "ezen1234";
		String sql;

		try {

			Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("oracle connection sucess.\n");
			Statement stmt = conn.createStatement();

			sql = "insert into PARTTIMERS VALUES ('" + getNAME() + "','" + getPW() + "','" + getTEL() + "' , '"
					+ getROLE() + "')";

			boolean b = stmt.execute(sql);
			if (!b) {
				System.out.println("INSERT SUCCSESS.\n");
			} else {
				System.out.println("INSERT FAIL.\n");
			}

		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String NAME) {
		this.NAME = NAME;
	}

	public String getPW() {
		return PW;
	}

	public void setPW(String PW) {
		this.PW = PW;
	}

	public String getTEL() {
		return TEL;
	}

	public void setTEL(String TEL) {
		this.TEL = TEL;
	}

	public String getROLE() {
		return ROLE;
	}

	public void setROLE(String ROLE) {
		this.ROLE = ROLE;
	}
}