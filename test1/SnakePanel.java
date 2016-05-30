package test1;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SnakePanel extends JPanel{

	private location location[] = new location[1000];
	private int num;
	private int x;
	private int y;
	private int key = 4;
	private int score;
	private int x1=100;
	private int y1=200;
	private int UPDATE_RATE=1;
	
	Thread gameThread;
	
	private SnakeFrame snakeFrame;
	
	private final int w = 1;
	private final int a = 2;
	private final int s = 3;
	private final int d = 4;
	
	
	Random rand = new Random();
	
	public void paintComponent(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		super.paintComponent(g);
		this.setBackground(Color.BLACK);
		g.setColor(Color.RED);
		g2d.setStroke(new BasicStroke(5f));
		g.drawLine(793, 0, 793, 500);
		for(int i=0;i<num;i++){
			location[i].draw(g);
			location[999].draw(g);
		}
		
	}
	
	public void start(int x, int y){
		try{
		UPDATE_RATE=1;
		num = 10;
		score = 0;
		location[num++] = new Snake(x,y);	
		location[999]= new Food(x1,y1);
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
						Thread.sleep(100/UPDATE_RATE);
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
		
		if(x==-10||y==-10||x==790||y==500){
			JOptionPane.showMessageDialog(null, "You are DEAD. Your score is " + score, "GameOver", JOptionPane.DEFAULT_OPTION);
			UPDATE_RATE=0;
		}
		for(int i=2;i<=num;i++){
			if(location[i].getX()==x&&location[i].getY()==y){
				JOptionPane.showMessageDialog(null, "You are DEAD. Your score is " + score, "GameOver", JOptionPane.DEFAULT_OPTION);
				UPDATE_RATE=0;
			}
		}
		
		if(x==x1&&y==y1){
			x1 = rand.nextInt(77)*10;
			y1 = rand.nextInt(50)*10;
			location[999] = new Food(x1,y1);
			num++;
			score++;
			System.out.println(score);
			getScore();
			for(java.awt.Component item : getRootPane().getComponents())
				if(item instanceof SnakeFrame)
					((SnakeFrame)item).scoreadder(score);
			if(snakeFrame!=null)
			snakeFrame.scoreadder(score);
		}
		
		repaint();
		} catch (Exception ex){
			System.out.println(ex.getMessage());
		}
	}



	public int getScore() {
		return score;
	}

}
