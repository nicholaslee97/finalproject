
import java.awt.Color;
import java.awt.Graphics;

public class Snake extends location{

	public Snake(int x, int y){
		super(x,y);
	}
	
	public void draw(Graphics g){
		g.setColor(Color.GREEN);
		g.fillOval(x, y, 10, 10);
		}
}
