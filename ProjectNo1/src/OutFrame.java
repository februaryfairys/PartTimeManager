import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class OutFrame extends AFrame {
	private Frame f;
	private TextField tf1, tf2;
	private Button b1;
	private Label lid, lpw;
	private PartTimerJoinDAO dao = new PartTimerJoinDAO();
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void start() {
		f = new Frame("퇴근하기");
		f.setSize(250, 240);
		f.setLayout(null);
		f.addWindowListener(this);
		f.setLocation(screenSize.width / 2 - 300, screenSize.height / 2 - 200);

		lid = new Label("성명");
		lpw = new Label("비밀번호");
		lid.setSize(55, 20);
		lpw.setSize(55, 20);
		lid.setLocation(30, 40);
		lpw.setLocation(30, 100);

		tf1 = new TextField();
		tf2 = new TextField();
		tf1.setSize(200, 20);
		tf2.setSize(200, 20);
		tf1.setLocation(25, 65);
		tf2.setLocation(25, 125);

		b1 = new Button("퇴근하기");
		b1.setSize(200, 50);
		b1.setLocation(25, 160);
		b1.addActionListener(this);

		f.add(b1);
		f.add(tf1);
		f.add(tf2);
		f.add(lid);
		f.add(lpw);
		f.setVisible(true);

	}

	public void windowClosing(WindowEvent E) {
		f.dispose();
	}

	public void actionPerformed(ActionEvent e) {

		CheckOutFrame chof = new CheckOutFrame();
		InputYourInfo iyi = new InputYourInfo();
		CheckNameOrPassword cnp = new CheckNameOrPassword();
		if (tf1.getText().equals("")) {
			iyi.name();
		} else if (tf2.getText().equals("")) {
			iyi.password();
		} else {
			ArrayList<PartTimerVo> list = dao.list(tf1.getText());
			if (list.size() == 0) {
				cnp.start();
			} else {
				PartTimerVo data = (PartTimerVo) list.get(0);
				String pswd = data.getPw();
				if (tf2.getText().equals(pswd)) {

					chof.start();
					setName(tf1.getText());
					f.dispose();
				} else {
					cnp.start();
				}
			}
		}
	}
}