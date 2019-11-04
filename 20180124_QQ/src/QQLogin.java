import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.io.*;
import java.net.*;

public class QQLogin extends JFrame implements ActionListener{
	

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
	Socket socket;
	
	public Socket getSocket() {
		return socket;
	}


	public void setSocket(Socket socket) {
		this.socket = socket;
	}


	QQLogin(){
		
		this.setTitle("Login Window");
		this.setSize(300, 150);
		
		
		//new object
		labUser = new JLabel("User");
		labPass = new JLabel("Password");
		txtUser = new JTextField();
		txtPass = new JPasswordField();
		btnLogin= new JButton("Login");
		btnReg = new JButton("Register");
		btnCancel = new JButton("Cancel");
		
		panInput = new JPanel();
		panButton = new JPanel();
		
		//layout 		
		panInput.setLayout(new GridLayout(2,2));
		panInput.add(labUser);
		panInput.add(txtUser);
		panInput.add(labPass);
		panInput.add(txtPass);		
		
		panButton.setLayout(new FlowLayout());
		panButton.add(btnLogin);
		panButton.add(btnReg);
		panButton.add(btnCancel);
		
		this.setLayout(new BorderLayout());
		this.add(panInput, BorderLayout.CENTER);
		this.add(panButton,BorderLayout.SOUTH);
		
		//register action 
		btnLogin.addActionListener(this);
		btnReg.addActionListener(this);
		btnCancel.addActionListener(this);
		
		
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
	}
	
	
	public static void main(String[] args){
		QQLogin w = new QQLogin();
		
		w.setLocation(512, 400);
		
		w.setVisible(true);
		
		try{
			w.setSocket(new Socket("localhost",7000));			
		}catch(Exception e){}
		
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("Login")){
			//System.out.println(e.getActionCommand());
			String user = txtUser.getText();
			@SuppressWarnings("deprecation")
			String psd = txtPass.getText();
			
			try{
			 
			 
			 OutputStream os =this.socket.getOutputStream();
			 OutputStreamWriter osr= new OutputStreamWriter(os);
			 PrintWriter pw = new PrintWriter(osr,true);
			 
			 pw.println("l%"+user+"&"+psd);
			 
			 InputStream is = this.socket.getInputStream();
			 InputStreamReader isr= new InputStreamReader(is);
			 BufferedReader br = new BufferedReader(isr);
			
			
			 int answer = br.read();
			 System.out.println(answer);
				
			 if(answer==1){
				 QQmain w = new QQmain();	
				 w.setSocket(this.socket);			
				 w.setVisible(true);
				 w.setTitle(user);
				 this.setVisible(false);
				 //this.setVisible(false);			
			 }
				
			 
			}catch(Exception ex){}	
			
		}
		
		
		
	}
	
}