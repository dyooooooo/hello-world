import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import org.apache.logging.log4j.*;

public class MyChar {
	
	private static Logger logger = LogManager.getLogger(MyChar.class);
	public static void main(String[] args){	
		
		
		logger.debug("hello");
	
		
		
		
		JFrame w = new JFrame();
		w.setSize(300, 400);
		
		MyPanel mp = new MyPanel();
		w.add(mp);
		
		Thread t = new Thread(mp);		
		t.start();
		
		w.addKeyListener(mp);
		mp.addKeyListener(mp);
		
		
		
		w.setVisible(true);
	}

}

class MyPanel extends JPanel implements KeyListener,Runnable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger logger = LogManager.getLogger(MyPanel.class);
	int x[]= new int[10];
	int y[]= new int[10];
	char zm[] = new char[10];
	int score=1000;
	
	
	public MyPanel(){
		for(int i=0;i<10;i++){
			x[i]=(int)(Math.random()*290);
			y[i]=(int)(Math.random()*400);
			zm[i]=(char)(Math.random()*26+97);
		}
		
	}
	
	public void paint(Graphics g){
		super.paint(g);
		
		for(int i=0;i<10;i++){
			g.drawString(new Character(zm[i]).toString(), x[i], y[i]);
		}
		
		g.setColor(Color.red);
		g.drawString("Score "+score, 5, 15);
		
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		
		while(true){
			
			try{
				
				for(int i=0;i<10;i++){
					y[i]++;
					
					if(y[i]>361){
						y[i]=0;
						x[i]=(int)(Math.random()*290);
						zm[i]=(char)(Math.random()*26+97);
						score-=20;						
					}
				}
				
				Thread.sleep(30);
				
			}catch(Exception e){}
			
			
			repaint();
			
			
			
		}
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println(arg0.getKeyCode());
		logger.debug(arg0.getKeyCode());
		
		int yMax=0;	
		int count=0;
		boolean mark=false;
		
		char keyC=arg0.getKeyChar();
		for(int i=0;i<10;i++){
			if(zm[i]==keyC){
				if(yMax<y[i]){
					yMax=y[i];
					count=i;					
				}
				mark=true;
			}
		}
		
		
		if(mark==true){
			y[count]=0;
			x[count]=(int)(Math.random()*290);
			zm[count]=(char)(Math.random()*26+97);	
			score+=10;
		}else{
			score-=20;			
		}
		
			
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
