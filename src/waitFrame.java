import javax.swing.JFrame;

public class waitFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	waitFrame(){
		
			this.add(new waitPanel());
			this.setTitle("Snake Game");//  this is used to set name of the frame
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // this is used to set close operation on the JFrame
			this.setResizable(false);  // to remove the re sizable factor
			this.pack();
			this.setVisible(true);  // this is used to show the frame in the screen otherwise frame will not be showing on the screen
			this.setLocationRelativeTo(null); 
		
	}

}
