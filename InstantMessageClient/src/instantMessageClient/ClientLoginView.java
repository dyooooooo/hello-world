package instantMessageClient;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;


public class ClientLoginView extends JFrame implements ActionListener,Observer{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel labUser;
	JLabel labPass;
	JTextField txtUser;
	JPasswordField txtPass;
	JButton btnLogin;
	JButton btnReg;
	JButton btnCancel;
	
	JPanel panInput;
	JPanel panButton;
	
	JPanel panBlank;
	
	JPanel panEast;
	JPanel panWest;
	
	JLabel lbMessageJLabel;
	
	
	
	JPanel panMainJPanel;
	
	User user ;	
	
	private Collection<LoginListener> listeners;
	
	public void addLoginListener(LoginListener listener) {
		// TODO Auto-generated method stub
		if(this.listeners==null) {
			this.listeners = new HashSet<LoginListener>();
		}
		
		this.listeners.add(listener);

	}
	
	public void removeLoginListener(LoginListener listener) {
		if(this.listeners==null)
			return;
		listeners.remove(listener);
		
	}
	
	private void notifyLoginListeners(LoginEvent event) {
		Iterator<LoginListener> iterator = this.listeners.iterator();
		while(iterator.hasNext()) {
			LoginListener listener = (LoginListener)iterator.next();
			listener.loginPerformed(event);
			
		}
	}

	
	
	public ClientLoginView() throws HeadlessException {
		super();
		// TODO Auto-generated constructor stub
		try {
			
			//layout
			setLayout();
			
			//register action
			btnLogin.addActionListener(this);	
			
			//clModel = new ClientLoginModel();
			user = new User();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();			
		}
	}


	

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	
		if(e.getActionCommand().equals("Login")){					
			
			
			user.setUserNameString(txtUser.getText());
			user.setPassWordString(txtPass.getText());	
			
			LoginEvent event = new LoginEvent(this, user);
			this.notifyLoginListeners(event);
			
		}		
		
	}
	
private void setLayout() {
		
		
		this.setTitle("Login Window");
		this.setSize(500, 250);	

		Font fontinput=new Font(Font.SERIF,Font.PLAIN,18); 
		Font fontbtn=new Font(Font.SERIF,Font.LAYOUT_LEFT_TO_RIGHT,18); 
		
		//new object
		labUser = new JLabel("User");
		labUser.setFont(fontinput);
		labPass = new JLabel("Password");
		labPass.setFont(fontinput);
		txtUser = new JTextField();
		txtPass = new JPasswordField();
		btnLogin= new JButton("Login");	
		btnLogin.setFont(fontbtn);
		btnReg = new JButton("Register");
		btnReg.setFont(fontbtn);
		btnCancel = new JButton("Cancel");
		btnCancel.setFont(fontbtn);	
		lbMessageJLabel = new JLabel("Please input your name and password");
		lbMessageJLabel.setFont(fontbtn);
		
		
		panInput = new JPanel();
		panButton = new JPanel();			
		panBlank = new JPanel();			
		panEast = new JPanel();
		panWest= new JPanel();
		panMainJPanel= new JPanel();	
		
		
		
		
		
		
		//layout 
		GridLayout glGridLayout = new GridLayout(2, 2);		
		glGridLayout.setVgap(5);
		panInput.setLayout(glGridLayout);
		panInput.add(labUser);
		panInput.add(txtUser);
		panInput.add(labPass);
		panInput.add(txtPass);	
		
		
		
		panBlank.setLayout(new FlowLayout());
		panBlank.add(lbMessageJLabel);
		
		
		
		
		
		FlowLayout fllFlowLayout = new FlowLayout();
		fllFlowLayout.setHgap(50);
		fllFlowLayout.setVgap(20);
		panButton.setLayout(fllFlowLayout);			
		panButton.add(btnLogin);
		panButton.add(btnReg);
		panButton.add(btnCancel);
		
		BorderLayout bdLayout = new BorderLayout();		
		bdLayout.setVgap(20);
		bdLayout.setHgap(20);
		panMainJPanel.setLayout(bdLayout);
		panMainJPanel.add(panBlank, BorderLayout.NORTH);
		panMainJPanel.add(panInput, BorderLayout.CENTER);
		panMainJPanel.add(panButton,BorderLayout.SOUTH);
		panMainJPanel.add(panEast, BorderLayout.EAST);
		panMainJPanel.add(panWest, BorderLayout.WEST);
		
		
		
		
		this.setLayout(new BorderLayout());
		this.add(panMainJPanel);
		
		
		
		
		//JFrame configuration			
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setAlwaysOnTop(true);		
		this.setVisible(true);	
		//设置在屏幕中央
		this.setLocationRelativeTo(null);
		//自适应
		this.pack();
		
	}




@Override
public void update(Observable o, Object arg) {
	// TODO Auto-generated method stub
	
}


	
	
	
	
}
