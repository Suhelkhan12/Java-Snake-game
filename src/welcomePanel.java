import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class welcomePanel extends JPanel implements ActionListener{
    

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static final int SCREEN_WIDTH = 600; 
	static final int SCREEN_HEIGHT = 600;
	
	JButton play;
	
    welcomePanel() {
		// TODO Auto-generated constructor stub
    	
    	this.setPreferredSize(new Dimension(SCREEN_WIDTH , SCREEN_HEIGHT)); 
    	this.setLayout(null);
    	this.setFocusable(true);
    	this.setBackground(new Color(60,179,113));
    	
    	addInputs();
	}

    public void addInputs() {
    	play = new JButton("Start Game");
    	play.setBounds(250,350,80,30);
    	play.setForeground(Color.black);
    	play.setBackground(Color.white);
    	play.setBorder(null);
    	play.addActionListener(this);
    	this.add(play);
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		Object source = e.getSource();
		
		if(source == play) {
			new gameFrame();
		}
		
	}

}
