import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MyBall {
	public static void main(String[] args){
		JFrame w = new JFrame();
		
		w.setSize(300, 400);
		
		MyPanel mp = new MyPanel();
		
		w.add(mp);		
		
		
		w.addKeyListener(mp);
		mp.addKeyListener(mp);
		
		
		Thread t = new Thread(mp);
		t.start();
		
		w.setVisible(true);
	}
}


class MyPanel extends JPanel implements KeyListener,Runnable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	int x;
	int y;
	int att=0;
	
	public MyPanel(){
		x=(int)(Math.random()*250);
		y=(int)(Math.random()*350);		
	}
	
	public void paint(Graphics g){
		super.paint(g);
		g.setColor(Color.black);
		g.fillOval(x, y, 20, 20);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println(arg0.getKeyCode());
		
		
		try{
			
			
			if(arg0.getKeyCode()==37){
				if(x>0){
					x--;
				}						
			}
			
			if(arg0.getKeyCode()==38){
				if(y>0){
					y--;
				}						
			}
			
			if(arg0.getKeyCode()==39){
				if(x<264){
					x++;
				}						
			}
			
			if(arg0.getKeyCode()==40){
				if(y<340){
					y++;
				}						
			}	
			
		}catch(Exception e){}
		
		
		
		repaint();
		
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			
			if(att==0){
				x++;
				y++;
			}
			
			if(att==1){			
				x--;
				y++;
			}
			
			if(att==2){			
				x--;
				y--;
			}
			
			if(att==3){			
				x++;
				y--;
			}	
			
			if(x>263){
				if(att==0){
					att=1;
				}else{
					att=2;
				}
			}
			
			if(y>341){
				if(att==1){
					att=2;
				}else{
					att=3;
				}
			}
			
			if(x<0){
				if(att==2){
					att=3;
				}else{
					att=0;
				}
			}
			
			if(y<0){
				if(att==3){                                                                       
					att=0;
				}else{
					att=1;
				}
			}
		
		
			
			try{
				Thread.sleep(30);				
			}catch(Exception e){}
			
			
			repaint();			
		}
		
	}
	
}
