package view;
import java.awt.*;
import java.awt.event.*;

public class AddFrame extends AFrame {
	private Frame f;
	private TextField tf1, tf2, tf3, tf4;
	private Button b1, b2, bRd;
	private Label lid, lid2, lpw, lpw2, ltel, ltel2, lchpw;
	private Choice r;
	private boolean c = false;
	private String name;

	InputYourInfo iyi = new InputYourInfo();
	CheckPasswordFrame chpf = new CheckPasswordFrame();
	CheckAddFrame chaf = new CheckAddFrame();

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
					iyi.start("name");
				} else if (!(tf1.getText().length() >= 2)) {
					lid2.setText("두 글자 이상 입력하세요.");
				} else if (tf3.getText().equals("")) {
					iyi.start("password");
				} else if (c != true) {
					chpf.start(1);
				} else if (!(tf2.getText().equals(tf3.getText()))) {
					chpf.start(1);
					c = false;
				} else if (tf4.getText().equals("")) {
					iyi.start("tel");
					;
				} else if (tf4.getText().length() > 11 || tf4.getText().length() < 10) {
					ltel2.setText("올바른 연락처를 입력하세요.");
				} else {
					if (tf1.getText().length() >= 2 && tf2.getText().equals(tf3.getText()) && c == true
							&& tf4.getText().length() >= 10 && tf4.getText().length() <= 11) {
						chaf.setNAME(tf1.getText());
						chaf.setPW(tf2.getText());
						chaf.setTEL(tf4.getText());
						chaf.setROLE(r.getSelectedItem());
						name = tf1.getText();
						chaf.start(name);
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

	public void dispose() {
		f.dispose();
	}

}