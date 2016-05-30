package test1;


import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Food extends location{

	public Food(int x, int y){
		super(x,y);
	}
	
	public void draw(Graphics g){
		g.setColor(Color.WHITE);
		g.fillOval(x, y, 10, 10);
		}

}
