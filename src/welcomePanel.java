import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class welcomePanel extends JPanel implements ActionListener{
    

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static final int SCREEN_WIDTH = 600; 
	static final int SCREEN_HEIGHT = 600;
	
	JButton play;
	ImageIcon image;
	
    welcomePanel() {
		// TODO Auto-generated constructor stub
    	
    	this.setPreferredSize(new Dimension(SCREEN_WIDTH , SCREEN_HEIGHT)); 
    	this.setLayout(null);
    	this.setFocusable(true);
    	this.setBackground(new Color(60,179,113));
    	
    	addInputs();
    	addImage();
	}
    
	public void addImage() {
		try {
			image = new ImageIcon(ClassLoader.getSystemResource("snake/start.jpg"));
			Image i2 = image.getImage().getScaledInstance(600, 600, Image.SCALE_SMOOTH);
			ImageIcon i3 = new ImageIcon(i2);
		    JLabel back = new JLabel(i3);
		    back.setBounds(0,0,600,600);
		    this.add(back);
	
		}catch(Exception e) {
			System.out.print("No image here");
		}
	}

    public void addInputs() {
    	play = new JButton("Start Game");
    	play.setBounds(250,300,80,30);
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
