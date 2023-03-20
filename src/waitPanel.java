import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JPanel;

public class waitPanel extends JPanel  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// v a r r i a b l e s 
		static final int SCREEN_WIDTH = 600; 
		static final int SCREEN_HEIGHT = 600;
	
	waitPanel(){
		this.setPreferredSize(new Dimension(SCREEN_WIDTH , SCREEN_HEIGHT)); 
		this.setBackground(new Color(211,211,211));
        this.setFocusable(true);
        this.setLayout(null);
	}

	public void drawWaitScreen(Graphics g) {
		// game over text
				g.setColor(Color.black); // uska color red hoga
				g.setFont(new Font("Ink Free" , Font.BOLD , 75)); // font type and size of the font
				
				// ek font matrix nam ki cheez hoti hai hmari java me jo ki hme font ko center of the screen par lane me help kr deti hai kafi jyada
				
				FontMetrics metrics = getFontMetrics(g.getFont()); // jo font hme set krna graphics se use idhar bhej diya matrix me
				g.drawString("Press enter key to start.", (SCREEN_WIDTH - metrics.stringWidth("Press any enter to start."))/2 , SCREEN_HEIGHT / 2); // THIS LINE WILL GIVE US GAME OVER TEXT IN THE CNETER OF THE SCREEN
	            
	}

	
}
