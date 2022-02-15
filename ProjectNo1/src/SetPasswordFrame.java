import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

public class SetPasswordFrame extends WindowAdapter implements ActionListener {
	SetPasswordClass spc = new SetPasswordClass();
	private Frame f;
	private TextField tf1,tf2;
	private Button b1;
	private Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension screenSize = tk.getScreenSize();
		
	public void start() {
//		spc.setPassword("0000");
		f= new Frame ("비밀번호 재설정");
		f.setSize(null);
		f.setLayout(null);
		f.setLocation(screenSize.width / 2 - 300, screenSize.height / 2 - 200);
		f.addWindowListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
