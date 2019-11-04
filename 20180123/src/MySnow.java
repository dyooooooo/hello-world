import javax.swing.*;
import java.awt.*;

public class MySnow{
	public static void main(String[] args){
		JFrame w = new JFrame();
		w.setSize(1024, 768);	
		
		MyPanel mp= new MyPanel();
		mp.setBackground(Color.black);
		w.add(mp);
		
		Thread t = new Thread(mp);
		t.start();
		
		
		w.setVisible(true);
	}
}


class MyPanel extends JPanel implements Runnable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int x[]= new int[300];
	int y[]= new int[300];
	
	public MyPanel(){
		for(int i=0;i<300;i++){
			x[i]=(int)(Math.random()*1024);
			y[i]=(int)(Math.random()*768);
		}
	}
	
	public void paint(Graphics g){
		super.paint(g);
		g.setColor(Color.white);
		
		for(int i=0; i<300;i++){
			g.drawString("*", x[i], y[i]);
		}
		
		
	}

	public void run(){
		
		while(true){
			try{
				for(int i=0;i<300;i++){
					y[i]++;
					if(y[i]>768){
						y[i]=0;
						x[i]=(int)(Math.random()*1024);
					}
				}
				
				Thread.sleep(10);
			}catch(Exception e){}
			repaint();
		}	
		
	}
}