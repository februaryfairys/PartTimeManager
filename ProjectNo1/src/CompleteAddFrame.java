import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

public class CompleteAddFrame extends AFrame {
	private Frame f;
	private Button b;
	private Label l1, l2;
	
	public void start() {
		f = new Frame("등록완료");
		f.setSize(250, 150);
		f.setLayout(null);
		f.addWindowListener(this);
		f.setLocation(screenSize.width / 2 - 300, screenSize.height / 2 - 200);

		l1 = new Label("등록되었습니다.",Label.CENTER);
		l2 = new Label("님 환영합니다.",Label.CENTER);
		l1.setSize(250, 20);
		l1.setLocation(0, 40);
		l2.setSize(250, 20);
		l2.setLocation(0, 70);

		b = new Button("Ok");
		b.setSize(60, 30);
		b.setLocation(95, 100);
		b.addActionListener(this);
		f.add(l1);
		f.add(l2);
		f.add(b);
		f.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		f.dispose();
		
		

	}

	public void windowClosing(WindowEvent E) {
		f.dispose();
	}

}
