

	import java.awt.Button;
	import java.awt.Dimension;
	import java.awt.Frame;
	import java.awt.Label;
	import java.awt.Toolkit;
	import java.awt.event.ActionEvent;

	public class InputYourTel extends AFrame {
		private Frame f;
		private Label l;
		private Button b;
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();

		public void start() {
			f = new Frame("Error");
			f.setSize(250, 150);
			f.setLayout(null);
			f.addWindowListener(this);
			f.setLocation(screenSize.width / 2 - 300, screenSize.height / 2 - 200);
			
			l = new Label("연락처를 입력하세요.", Label.CENTER);
			l.setSize(250,50);
			l.setLocation(0,45);
			
			b = new Button("확인");
			b.setSize(60,30);
			b.setLocation(95,100);
			b.addActionListener(this);
			
			f.add(l);
			f.add(b);
			f.setVisible(true);
		}

		public void actionPerformed(ActionEvent e) {
			f.dispose();
		}
	}

