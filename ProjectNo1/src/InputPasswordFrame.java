import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class InputPasswordFrame extends AFrame {
	private Frame f;
	private TextField tf1;
	private Button b1;
	private Label lpw;
	private String PASSWORD = "0";
	
	public void start() {
		f = new Frame("Input Password");
		f.setSize(300, 180);
		f.setLayout(null);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent E) {
				f.dispose();
			}
		});
		f.setLocation(screenSize.width / 2 - 300, screenSize.height / 2 - 200);

		tf1 = new TextField("");
		tf1.setSize(150, 20);
		tf1.setLocation(75, 80);

		b1 = new Button("Ȯ��");
		b1.setSize(150, 40);
		b1.setLocation(75, 120);
		b1.addActionListener(this);
		lpw = new Label("��й�ȣ�� �Է��ϼ���.");
		lpw.setSize(130, 20);
		lpw.setLocation(85, 60);
		f.add(b1);
		f.add(tf1);
		f.add(lpw);
		f.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
	
	}
}