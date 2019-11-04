import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MyNote {
	public static void main(String[] args){
		JFrame w = new JFrame("Notebook");
		w.setSize(600, 800);
		w.setLocation(400, 100);
		
		MyPanel mp = new MyPanel();
		w.add(mp);
		
		w.addKeyListener(mp);
		mp.addKeyListener(mp);		
		
		
		w.setVisible(true);
	}

}


class MyPanel extends JPanel implements KeyListener{
	
	/**
	 * 
	 */
	
	
	private static final long serialVersionUID = 1L;
	
	private char c[] =new char[1000];
	int size=0;

	public void paint(Graphics g){
		super.paint(g);
		for(int i=0;i<size;i++){
			g.drawString(""+c[i], 10+8*i, 10);
		}
		
		g.drawLine(10+size*8, 0, 10+size*8, 10);
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		c[size]=arg0.getKeyChar();
		size ++;
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
	
}