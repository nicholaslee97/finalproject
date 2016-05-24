import javax.swing.JFrame;

public class SnakeTest {
	
	public static void main(String[] args) {
		SnakeFrame app = new SnakeFrame();
		app.setSize(800, 600);
		app.setResizable(false);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
    }
}
