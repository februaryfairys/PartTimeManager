import java.awt.*;
import java.awt.event.*;

import Project1.dao.DAO;

public class CheckAddFrame extends AFrame {
	private Frame f;
	private Label l;
	private Button b1, b2;
	private String name;
	private String NAME, PW, TEL, ROLE;

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

	public String getName() {
		return name;
	}

	public void start(String name) {
		this.name = name;

		f = new Frame("등록");
		f.setSize(250, 160);
		f.setLayout(null);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent E) {
				f.dispose();
			}
		});
		f.setLocation(screenSize.width / 2 - 300, screenSize.height / 2 - 200);

		l = new Label("새로운 직원을 등록할까요?", Label.CENTER);
		l.setSize(250, 20);
		l.setLocation(0, 65);

		b1 = new Button("네");
		b2 = new Button("아니요");
		b1.setSize(50, 30);
		b2.setSize(50, 30);
		b1.setLocation(75, 110);
		b2.setLocation(125, 110);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DAO dao = new DAO();
				CompleteAddFrame caf = new CompleteAddFrame();
				f.dispose();
				dao.add(getNAME(), getPW(), getTEL(), getROLE());
				caf.start(getName());
			}
		});
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
			}
		});

		f.add(b1);
		f.add(b2);
		f.add(l);
		f.setVisible(true);
	}
}
