import java.awt.Button;
import java.awt.Frame;
import java.awt.List;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class LookUpFrame extends AFrame {
	private Frame f;
	private List lst;
	private Button b1, b2, b3, b4;
	private TextField tf;
	private TextArea ta;

	PartTimerJoinDAO dao = new PartTimerJoinDAO();
	EditFrame ef = new EditFrame();

	public void start() {
		f = new Frame("직원조회");
		f.setSize(460, 300);
		f.setLayout(null);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent E) {
				f.dispose();
			}
		});
		f.setLocation(screenSize.width / 2 - 300, screenSize.height / 2 - 200);
		b1 = new Button("조회");
		b2 = new Button("개인정보 조회");
		b3 = new Button("개인정보 수정");
		b4 = new Button("삭제");
		b1.setSize(40, 20);
		b2.setSize(160, 60);
		b3.setSize(160, 60);
		b4.setSize(160, 60);
		b1.setLocation(195, 50);
		b2.setLocation(265, 50);
		b3.setLocation(265, 130);
		b4.setLocation(265, 210);

		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tf.getText().length() > 1) {
					ArrayList<PartTimerVo> list = dao.list(tf.getText());
					PartTimerVo data = (PartTimerVo) list.get(0);
					lst.add(data.getName());
				}

			}
		});
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lst.getSelectedItem() != null) {
					ArrayList<PartTimerVo> list = dao.list(lst.getSelectedItem());
					PartTimerVo data = (PartTimerVo) list.get(0);
					String name = data.getName();
					String pw = data.getPw();
					String tel = data.getTel();
					String role = data.getRole();
					String info = name + " " + role + "\n직원번호 : " + pw + "\n연락처 : " + tel;
					ta.setText(info);
				}

			}
		});
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lst.getSelectedItem() != null) {

					ef.setName(lst.getSelectedItem());
					ef.start();
				}
			}
		});
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		tf = new TextField(null);
		tf.setSize(150, 20);
		tf.setLocation(35, 50);
		tf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		lst = new List();
		lst.setSize(200, 70);
		lst.setLocation(35, 90);

		ta = new TextArea();
		ta.setSize(200, 90);
		ta.setLocation(35, 180);
		ta.setEditable(false);

		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);
		f.add(tf);
		f.add(lst);
		f.add(ta);
		f.setVisible(true);
	}
}
