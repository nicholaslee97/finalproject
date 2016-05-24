
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SnakeFrame extends JFrame implements ActionListener{
	private JButton start; 
	private JPanel bottomPanel;
	private SnakePanel snakePanel;
	
	private JPanel movePanel;
	private JButton up;
	private JButton down;
	private JButton left;
	private JButton right;
	
	private final int w = 1;
	private final int a = 2;
	private final int s = 3;
	private final int d = 4;
	 
	GridBagConstraints gbc;
	
	public SnakeFrame(){
		super();
		
		SnakePanel snakePanel = new SnakePanel();
		add(snakePanel, BorderLayout.CENTER);
		
		bottomPanel = new JPanel();
		start = new JButton("Start");
		start.addActionListener(this);
		bottomPanel.add(start);
		
		movePanel = new JPanel(new GridBagLayout());
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		
		up = new JButton("w");
		up.addActionListener(this);
		setGridBagConstraints(1,0,1,1);
		movePanel.add(up,gbc);
		
		down = new JButton("s");
		down.addActionListener(this);
		setGridBagConstraints(1,1,1,1);
		movePanel.add(down,gbc);
		
		left = new JButton("a");
		left.addActionListener(this);
		setGridBagConstraints(0,1,1,1);
		movePanel.add(left,gbc);
		
		right = new JButton("d");
		right.addActionListener(this);
		setGridBagConstraints(2,1,1,1);
		movePanel.add(right,gbc);
		
		bottomPanel.add(movePanel);
		
		add(bottomPanel, BorderLayout.SOUTH);
		}
	
	void setGridBagConstraints(int gridx,int gridy, int gridheight, int gridwidth){
		gbc.gridx=gridx;
		gbc.gridy=gridy;
		gbc.gridheight=gridheight;
		gbc.gridwidth=gridwidth;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==start){
				for(java.awt.Component item : getContentPane().getComponents())
					if(item instanceof SnakePanel)
						((SnakePanel)item).start(400,300);
				//snakePanel.start();
			}
			if(e.getSource()==up){
				for(java.awt.Component item : getContentPane().getComponents())
					if(item instanceof SnakePanel)
						((SnakePanel)item).game(w);
			}
			if(e.getSource()==left){
				for(java.awt.Component item : getContentPane().getComponents())
					if(item instanceof SnakePanel)
						((SnakePanel)item).game(a);
			}
			if(e.getSource()==down){
				for(java.awt.Component item : getContentPane().getComponents())
					if(item instanceof SnakePanel)
						((SnakePanel)item).game(s);
			}
			if(e.getSource()==right){
				for(java.awt.Component item : getContentPane().getComponents())
					if(item instanceof SnakePanel)
						((SnakePanel)item).game(d);
			}
		
	}
}
