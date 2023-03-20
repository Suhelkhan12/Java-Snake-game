import javax.swing.JFrame;

public class registerFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	registerFrame(){
		this.add(new registerPanel());
		this.setTitle("Snake Game");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
	}
	
}
