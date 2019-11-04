import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ServerControlFrame extends JFrame implements Runnable,ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] arg0) {
		ServerControlFrame scf = new ServerControlFrame();
		scf.setLocationRelativeTo(null);
	}

	public ServerControlFrame() throws HeadlessException {
		super();
		// TODO Auto-generated constructor stub
		setTitle("Instant Message Server");
		setSize(400, 500);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}	

}


