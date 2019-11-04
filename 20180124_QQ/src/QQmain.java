import javax.swing.*;

import java.net.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class QQmain extends JFrame implements ActionListener,Runnable{
	JComboBox<String> cmbUser;
	JButton btnSend;
	JTextField txtMess;
	JPanel panSmall;
	JPanel panBig;
	JTextArea txtContent;
	JScrollPane spContent;
	
	Socket socket;



	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	QQmain(){
		cmbUser = new JComboBox();
		JButton btnSend = new JButton("send");
		txtMess = new JTextField();
		
		
		panSmall = new JPanel();		
		panSmall.setLayout(new GridLayout(1,2));		
		panSmall.add(cmbUser);
		panSmall.add(btnSend);
		
		
		panBig = new JPanel();		
		panBig.setLayout(new GridLayout(2,1));		
		panBig.add(txtMess);
		panBig.add(panSmall);
		
		txtContent = new JTextArea();
		txtContent.setLineWrap(true);
		txtContent.setWrapStyleWord(true);
		spContent = new JScrollPane(txtContent);
		
		this.setLayout(new BorderLayout());
		
		this.add(panBig, BorderLayout.NORTH);
		this.add(spContent, BorderLayout.CENTER);
		
		
		this.setSize(380,600);
		this.setLocation(512, 184);
		
		btnSend.addActionListener(this);
		
		
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		this.addWindowListener(new WindowAdapter() {  		  
			  
				public void windowClosing(WindowEvent e) {  
					
					//System.out.println(txtContent.getText().replaceAll("\n", "\r\n"));
					
					super.windowClosing(e);  
					//���붯��  
					 try{
						 
						//System.out.println(txtContent.getText().replaceAll("\n", "\r\n"));
						 
					    File fout = new File("c:/work/message.txt");					    
					    FileWriter fw = new FileWriter(fout);
					    PrintWriter pw = new PrintWriter(fw);			  			    
					    			    
					    
					    int length = txtContent.getText().length();
					    pw.println(txtContent.getText(0, length-1));
					    pw.close();     
					    
					    
					 }catch(Exception ex){}  
				 }  
			  
			}); 
		
		try{
			File fin = new File("c:/work/message.txt");
			FileReader fins = new FileReader(fin);
			BufferedReader br = new BufferedReader(fins);
			while(br.ready()){
				txtContent.append(br.readLine()+"\n");
			}			
			
		}catch(Exception e){}
		
		Thread t = new Thread(this);
		t.start();
		
		
		
	}
	
	
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("send")){
			
			try{
				
				
				OutputStream os = this.socket.getOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(os);
				PrintWriter pw = new PrintWriter(osw,true);
				
				pw.println("m%"+txtMess.getText());
				
				
				InputStream is = this.socket.getInputStream();
				InputStreamReader isr= new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				
				
				int answer = br.read();
				System.out.println(answer);
				
				if(answer == 1){
					txtContent.append(txtMess.getText()+"\n");
					txtMess.setText("");				
									
				}else{
					txtContent.append("Could not connect to Sever, Fail to send message \n");					
				}
				
				repaint();
				
				
				
			}catch(Exception ex){}
			
			
			
		}
		
	}





	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
			InputStream is = this.socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			while(true){
				String message = br.readLine();				
				cmbUser.addItem(message);
			}
			
		}catch(Exception e){}		
		
		
	}

}
