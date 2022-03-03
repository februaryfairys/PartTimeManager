import java.awt.Button;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class PayFrame extends AFrame {
	private Frame f;
	private Button b1, b2;
	private Label l1, l2, l3, l4, l5, l6, l7;
	private Choice c1, c2, c3;
	private TextArea ta1, ta2;
	private TextField tf1;

	public void start(String name, ArrayList<WorkTimeVo> list) {

		f = new Frame("Work Time");
		f.setSize(540, 400);
		f.setLayout(null);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent E) {
				f.dispose();
			}
		});
		f.setLocation(screenSize.width / 2 - 300, screenSize.height / 2 - 200);

		l1 = new Label(name + "님의 근무시간을 조회합니다.", Label.CENTER);
		l2 = new Label("아래 근무일부터");
		l3 = new Label("아래 근무일까지 조회합니다.");
		l4 = new Label(name + "님의 급여를 계산합니다.", Label.CENTER);
		l5 = new Label("책정된 시급은 얼마인가요?");
		l6 = new Label("원");
		l7 = new Label(name + "님의 역할은 무엇인가요?");

		l1.setSize(270, 20);
		l2.setSize(200, 20);
		l3.setSize(200, 20);
		l4.setSize(270, 20);
		l5.setSize(200, 20);
		l6.setSize(50, 20);
		l7.setSize(200, 20);
		l1.setLocation(0, 50);
		l2.setLocation(35, 90);
		l3.setLocation(35, 160);
		l4.setLocation(270, 50);
		l5.setLocation(305, 90);
		l6.setLocation(460, 120);
		l7.setLocation(305, 160);

		c1 = new Choice();
		c2 = new Choice();
		c3 = new Choice();
		c1.setSize(200, 20);
		c2.setSize(200, 20);
		c3.setSize(200, 20);
		c1.setLocation(35, 120);
		c2.setLocation(35, 190);
		c3.setLocation(305, 190);
		c3.add("직원");
		c3.add("매니저");

		for (int i = 0; i < list.size(); i++) {
			WorkTimeVo data = list.get(i);
			String DT = data.getDT();
			c1.add(DT);
			c2.add(DT);
		}

		ta1 = new TextArea();
		ta2 = new TextArea();
		ta1.setSize(200, 70);
		ta2.setSize(200, 70);
		ta1.setLocation(35, 240);
		ta2.setLocation(305, 240);
		ta1.setEditable(false);
		ta2.setEditable(false);

		tf1 = new TextField();
		tf1.setSize(150, 20);
		tf1.setLocation(305, 120);

		b1 = new Button("조회");
		b1.setSize(160, 40);
		b1.setLocation(55, 330);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		b2 = new Button("계산");
		b2.setSize(160, 40);
		b2.setLocation(325, 330);
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		f.add(l1);
		f.add(l2);
		f.add(l3);
		f.add(l4);
		f.add(l5);
		f.add(l6);
		f.add(l7);
		f.add(c1);
		f.add(c2);
		f.add(c3);
		f.add(ta1);
		f.add(ta2);
		f.add(tf1);
		f.add(b1);
		f.add(b2);
		f.setVisible(true);

	}
}
