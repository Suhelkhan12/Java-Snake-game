import javax.swing.JFrame;

public class startPageFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	startPageFrame(){
		
		this.add(new startPanel());
		this.setTitle("Snake Game");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.pack(); // this sets the size of the frame to fit the component added it
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
		
	}

}
