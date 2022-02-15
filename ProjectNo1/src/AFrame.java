import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AFrame extends WindowAdapter implements ActionListener {
	private Frame f;
	private Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension screenSize = tk.getScreenSize();

	public void windowClosing(WindowEvent E) {
		f.dispose();
	}

	public void actionPerformed(ActionEvent e) {

	}
}