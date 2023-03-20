
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class startPanel extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// v a r r i a b l e s 
	static final int SCREEN_WIDTH = 600; 
	static final int SCREEN_HEIGHT = 600;
	// varriable for button and other things
	JButton b1;  // for register
	JButton b2;   // for login
	
	ImageIcon image;
	
	startPanel(){
		this.setPreferredSize(new Dimension(SCREEN_WIDTH , SCREEN_HEIGHT)); 
		this.setBackground(new Color(60,179,113));
        this.setFocusable(true);
        this.setLayout(null);
        
        
        // to add buttons
        
        addButtons();
        addImage();
        
        
        
	}
	
	public void addImage() {
		try {
			image = new ImageIcon(ClassLoader.getSystemResource("snake/snake.png"));
			Image i2 = image.getImage().getScaledInstance(600, 600, Image.SCALE_SMOOTH);
			ImageIcon i3 = new ImageIcon(i2);
		    JLabel back = new JLabel(i3);
		    back.setBounds(0,0,600,600);
		    this.add(back);
	
		}catch(Exception e) {
			System.out.print("No image here");
		}
	}
	public void addButtons() {
		
		
        // for register purpose
		b1 = new JButton("Register");
        b1.setBounds(150,400,80,30);
        b1.setBackground(new Color(152,251,152));
        b1.setBorder(null);
        b1.addActionListener(this);
        this.add(b1);
        
        
        // for login purpose
        b2 = new JButton("Login");
        b2.setBounds(350,400,80,30);
        b2.setBackground(new Color(152,251,152));
        b2.setBorder(null);
        b2.addActionListener(this);
        this.add(b2);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		welcomeMessage(g);
	}
	
	public void welcomeMessage(Graphics g) {
		
//		JLable label = new JLabel();
		g.setColor(new Color(240,240,240));
		g.setFont(new Font("Devanagri MT", Font.BOLD , 20));
		
		FontMetrics metrics = getFontMetrics(g.getFont()); // jo font hme set krna graphics se use idhar bhej diya matrix me
		g.drawString("Good Old! Classic Snake Game!", (SCREEN_WIDTH - metrics.stringWidth("Good Old! Classic Snake Game!"))/2 , SCREEN_HEIGHT - 120); // THIS LINE WILL GIVE US WELCOME MESSAGE ON THE SCREEN
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		
		Object source = e.getSource();
		
		if(source == b1) {
			new registerFrame();
		}
		
		if(source == b2) {
			new loginFrame();
		}
	}

}
