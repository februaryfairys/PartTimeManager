import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EditFrame extends AFrame {
	private Frame f;
	private TextField tf;
	private Label l1, l2, l3, l4;
	private Choice c;
	private Button b;
	private String name;
	private CheckboxGroup cg;
	private Checkbox cb1, cb2, cb3;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void start() {

		f = new Frame("���� ���� ����");
		f.setSize(270, 430);
		f.setLayout(null);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent E) {
				f.dispose();
			}
		});
		f.setLocation(screenSize.width / 2 - 300, screenSize.height / 2 - 200);

		l1 = new Label(getName() + "���� ���������� �����մϴ�", Label.CENTER);
		l2 = new Label("������ �׸�");
		l3 = new Label("������ ����");
		l4 = new Label("���ҵ� �����ұ��?");
		l1.setSize(270, 20);
		l2.setSize(200, 20);
		l3.setSize(200, 20);
		l4.setSize(200, 20);
		l1.setLocation(0, 50);
		l2.setLocation(35, 90);
		l3.setLocation(35, 160);
		l4.setLocation(35, 230);

		c = new Choice();
		c.add("����");
		c.add("����ó");
		c.setSize(200, 20);
		c.setLocation(35, 120);

		tf = new TextField();
		tf.setSize(200, 20);
		tf.setLocation(35, 190);

		cg = new CheckboxGroup();
		cb1 = new Checkbox("����", cg, false);
		cb2 = new Checkbox("�Ŵ���", cg, false);
		cb3 = new Checkbox("�ƴϿ�", cg, false);
		cb1.setSize(50, 20);
		cb2.setSize(50, 20);
		cb3.setSize(50, 20);
		cb1.setLocation(35, 260);
		cb2.setLocation(35, 280);
		cb3.setLocation(35, 300);

		b = new Button("����");
		b.setSize(200, 60);
		b.setLocation(35, 340);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
			}
		});

		f.add(l1);
		f.add(l2);
		f.add(l3);
		f.add(l4);
		f.add(c);
		f.add(tf);
		f.add(cb1);
		f.add(cb2);
		f.add(cb3);
		f.add(b);
		f.setVisible(true);

	}
}
