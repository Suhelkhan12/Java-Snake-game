import javax.swing.JFrame;

public class welcomeFrame extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	   
	welcomeFrame() {
		// TODO Auto-generated constructor stub
		// creating the instance of the gamePanel class
        //gamePanel panel = new gamePanel();
		
		// adding gamePanel to the gameFrame class
		this.add(new welcomePanel());  // add will take instance of any class new gamePanel() also creates the instance of the class
		this.setTitle("Snake Game");//  this is used to set name of the frame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // this is used to set close operation on the JFrame
		this.setResizable(false);  // to remove the re sizable factor
		this.pack();
		this.setVisible(true);  // this is used to show the frame in the screen otherwise frame will not be showing on the screen
		this.setLocationRelativeTo(null);  // this is used to center the window or the frame which is going to appear if we give null then center otherwise some other position wil come
	}

}
