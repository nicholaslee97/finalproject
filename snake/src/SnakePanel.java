
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SnakePanel extends JPanel{

	private location location[] = new location[1000];
	private int num;
	private int x;
	private int y;
	private int key = 4;
	
	private final int w = 1;
	private final int a = 2;
	private final int s = 3;
	private final int d = 4;
	
	public void paintComponent(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		super.paintComponent(g);
		this.setBackground(Color.BLACK);
		g.setColor(Color.RED);
		g2d.setStroke(new BasicStroke(5f));
		g.drawLine(793, 0, 793, 500);
	//	g.drawRect(0, 0, 790, 500);
		for(int i=0;i<num;i++){
			location[i].draw(g);
		}
	}
	
	public void start(int x, int y){
		try{
		num = 10;
		location[num++] = new Snake(x,y);
		for(int i=0;i<=num;i++){
			location[i] = new Snake(x-i*10,y);
		}
		update();
		repaint();
		} catch (Exception ex){
			System.out.println(ex.getMessage());
		}
	}
	
	public void update(){
		Thread gameThread = new Thread(){
		public void run(){
			while(true){
				game(key);
				repaint();
				try {
					Thread.sleep(100);
				} catch (InterruptedException ex) {}
				}
			}
		};
		gameThread.start();
	}
	
	public void game(int key){
	
		for(int i=num;i>0;i--){
			location[i]=location[i-1];
		}
		x = location[0].getX();
		y = location[0].getY();
		this.key = key;
		try{
		switch(key){
		case w:
			location[0]= new Snake(x,y-10);
			break;
		case a:
			location[0]= new Snake(x-10,y);
			break;
		case s:
			location[0]= new Snake(x,y+10);
			break;
		case d:
			location[0]= new Snake(x+10,y);
			break;
		}
		if(x<0||y<0||x>780||y>500){
			JOptionPane.showMessageDialog(null, "You are DEAD", "GameOver", JOptionPane.DEFAULT_OPTION);
		}
		for(int i=2;i<=num;i++){
			if(location[i].getX()==x&&location[i].getY()==y)
			JOptionPane.showMessageDialog(null, "You are DEAD", "GameOver", JOptionPane.DEFAULT_OPTION);

		}
		repaint();
		} catch (Exception ex){
			System.out.println(ex.getMessage());
		}
	}
}
