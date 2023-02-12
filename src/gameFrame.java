import javax.swing.JFrame;   // here we are importing our JFrame

// this class will be used to extend the jFrame of the class
// out gameFrame class is extending the JFrame in the next line
public class gameFrame extends JFrame{  

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// making the constructor
	gameFrame(){
		
		// creating the instance of the gamePanel class
        //gamePanel panel = new gamePanel();
		
		// adding gamePanel to the gameFrame class
		this.add(new gamePanel());  // add will take instance of any class new gamePanel() also creates the instance of the class
		this.setTitle("Snake");//  this is used to set name of the frame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // this is used to set close operation on the JFrame
		this.setResizable(false);  // to remove the re sizable factor
		this.pack();
		this.setVisible(true);  // this is used to show the frame in the screen otherwise frame will not be showing on the screen
		this.setLocationRelativeTo(null);  // this is used to center the window or the frame which is going to appear if we give null then center otherwise some other position wil come
	}

}
