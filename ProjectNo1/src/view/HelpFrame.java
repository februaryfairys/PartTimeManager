package view;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class HelpFrame extends AFrame {
	private Frame f;
	private Label l1, l2;
	private Button b1, b2, b3, b4, b5, b6, b7, b8;
	private TextArea ta;
	private String exp;

	public void start() {
		f = new Frame("Help");
		f.setSize(750, 550);
		f.setLayout(null);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent E) {
				f.dispose();
			}
		});
		f.setLocation(screenSize.width / 2 - 300, screenSize.height / 2 - 200);

		l1 = new Label("<����>", Label.CENTER);
		l2 = new Label("<���α׷� ����>", Label.CENTER);
		l1.setSize(150, 20);
		l2.setSize(450, 20);
		l1.setLocation(30, 60);
		l2.setLocation(220, 60);

		ta = new TextArea();
		ta.setSize(500, 390);
		ta.setLocation(220, 100);
		ta.setEditable(false);

		b1 = new Button("����ȭ��");
		b2 = new Button("�������");
		b3 = new Button("��� �� ���");
		b4 = new Button("������ȸ");
		b5 = new Button("��������");
		b6 = new Button("��й�ȣ");
		b7 = new Button("�޿�����");
		b8 = new Button("���α׷��ʱ�ȭ");

		b1.setSize(150, 40);
		b2.setSize(150, 40);
		b3.setSize(150, 40);
		b4.setSize(150, 40);
		b5.setSize(150, 40);
		b6.setSize(150, 40);
		b7.setSize(150, 40);
		b8.setSize(150, 40);
		b1.setLocation(30, 100);
		b2.setLocation(30, 150);
		b3.setLocation(30, 200);
		b4.setLocation(30, 250);
		b5.setLocation(30, 300);
		b6.setLocation(30, 350);
		b7.setLocation(30, 400);
		b8.setLocation(30, 450);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exp = "\n ���� ȭ�鿡�� ���� �ٹ����� ���� ��ϰ� ��ü ���� ����� ǥ�õ˴ϴ�." + "\n��� �ϴ��� ���ΰ�ħ ��ư�� ������ ����� �ֽ� ���·� ������Ʈ �˴ϴ�."
						+ "\n\n\n ������ ���� ����� ��Ƶ� ��ư���� �ֽ��ϴ�." + "\n�����޴����� ������ ��ٰ� ����� üũ�� �� �ֽ��ϴ�."
						+ "\n�����ڸ޴����� ���ο� ������ ����ϰų� ������ ��ȸ,����, ������ �� �ֽ��ϴ�. "
						+ "\n�����޴����� ���α׷� ��й�ȣ�� �����ϰų� ���α׷��� �ʱ�ȭ �� �� �ֽ��ϴ�."
						+ "\n\n\n ����� �޴���Ͽ��� ���� ��ư�� ������ ������ �޴��� ��ġ�Ǿ��ֽ��ϴ�.";

				ta.setText(exp);
			}
		});
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exp = "\n ���� ��ο� ���ο� ������ �߰��մϴ�." + "\n\n �̸�(�Ǵ� �г���), ����ó�� ������ �Է��ϰ� ������ȣ�� �߱޹޽��ϴ�."
						+ "\n�̸��� �������ε� ���� �����մϴ�." + "\n����ó�� 10~11�ڸ� �̳����� �Է��մϴ�."
						+ "\n\n\n �̸�(�Ǵ� �г���), ������ȣ, ������ �ߺ��� �� ������," + "\n���� �ٸ� ������ ���� ����ó�� �����ϴ� ���� �Ұ��� �մϴ�.";
				ta.setText(exp);
			}
		});
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exp = "\n ��ٽð��� ��ٽð��� ����մϴ�." + "\n\n ����� �̸�(�Ǵ� �г���)�� ������ȣ�� �Է��Ͽ� ����ϰ�,"
						+ "\n��� �� ������ ���� ������� ����մϴ�." + "\n\n\n ����� �� �ڵ����� ��ٽð��� ��ٽð��� ����ϸ�,"
						+ "\n�ٹ� �ð��� ��, �� ������ ����Ͽ� �����մϴ�.";
				ta.setText(exp);
			}
		});
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exp = "\n �������� ���������� �����ϰų� ������ �� �ֽ��ϴ�." + "\n\n ���α׷��� ��й�ȣ�� �Է��Ͽ� ����� ����� �� �ֽ��ϴ�."
						+ "\n������ �� �ִ� ������ �̸�, ������ȣ, ����ó, �Ⱓ�� �ٹ��ð��Դϴ�.";
				ta.setText(exp);
			}
		});
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exp = "\n ������ ������ ��� ������ ���������� �����մϴ�." + "\n\n �� ��� �̹� ������ �۾��� �ǵ��� �� �����ϴ�.";
				ta.setText(exp);
			}
		});
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exp = "\n �ʱ� ��й�ȣ�� 0000�̸� �����ڰ� ���Ƿ� ������ �� �ֽ��ϴ�." + "\n\n ���α׷��� ������ ��, ���� ������ ������ ��, ���α׷��� �ʱ�ȭ�� ��"
						+ "\n���α׷� ��ü�� ��й�ȣ�� �䱸�մϴ�.";
				ta.setText(exp);
			}
		});
		b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exp = "\n ���� �޿��� �����մϴ�." + "\n\n ���� �����ӱ��̳� ��ü������ ���� �⺻�ñ��� ������ �� �ֽ��ϴ�." + "\n\n ���ҿ� ���� �μ�Ƽ�긦 ������ �� �ֽ��ϴ�."
						+ "\n������ ������ �ۼ������� ��ŭ \"���Ͽ�\" �����մϴ�." + "\n�μ�Ƽ�긦 �����ϰ� ���� �ʴٸ� 0�� �Է��Ͽ� �����մϴ�.";
				ta.setText(exp);
			}
		});
		b8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exp = "\n ���α׷��� �ʱ�ȭ�մϴ�." + "\n\n ��ϵ� �������� ���������� �ٹ������ ��� �����˴ϴ�." + "\n��й�ȣ�� �ʱ⼳������ �ǵ��ư��ϴ�."
						+ "\n��, ������ �޿��� �μ�Ƽ��� �ʱ�ȭ���� �ʽ��ϴ�.";
				ta.setText(exp);
			}
		});

		f.add(l1);
		f.add(l2);
		f.add(ta);
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);
		f.add(b5);
		f.add(b6);
		f.add(b7);
		f.add(b8);
		f.setVisible(true);
	}
}
