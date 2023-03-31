import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class loginPanel extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// v a r r i a b l e s 
		static final int SCREEN_WIDTH = 600; 
		static final int SCREEN_HEIGHT = 600;
		JLabel userName;
		JLabel password;
		JLabel logo;
		JLabel nouser;
		
		
	
		JButton loginB;
		JButton registerB;
		
		JTextField userNameField;
		JPasswordField passwordField;
		
		loginPanel(){
			this.setPreferredSize(new Dimension(SCREEN_WIDTH , SCREEN_HEIGHT)); 
			this.setBackground(new Color(150,251,152));
	        this.setFocusable(true);
	        this.setLayout(null);
	        
	        //adding input field and lables
	        addInputs();
		}
	    
		public void addInputs() {
			
			logo = new JLabel("Fill up your details...");
			logo.setBounds(125 , 50 , 350 , 80);
			logo.setBackground(new Color(211,211,211));
			logo.setFont(new Font("Verdana", Font.PLAIN, 30));
			this.add(logo);
			
		
			
			userName = new JLabel("Username:");
			userName.setBounds(125,200,80,30);
			userName.setForeground(Color.black);
			this.add(userName);
			
			userNameField = new JTextField();
			userNameField.setBounds(200,200,150,30);
			userNameField.setBorder(null);
			userNameField.setBackground(Color.white);
			this.add(userNameField);
			
			password = new JLabel("Password:");
			password.setBounds(125,250,80,30);
			password.setForeground(Color.black);
			this.add(password);
			
			passwordField = new JPasswordField();
			passwordField.setBounds(200,250,150,30);
			passwordField.setBorder(null);
			passwordField.setBackground(Color.white);
			this.add(passwordField);
			

			loginB = new JButton("Login");
			loginB.setBounds(225,350,100,30);
			loginB.setBackground(Color.white);
			loginB.setBorder(null);
			loginB.addActionListener(this);
			this.add(loginB);
		
			registerB = new JButton("Have'nt registered. Click me!");
			registerB.setBounds(375,350,200,30);
			registerB.setBackground(Color.white);
			registerB.setBorder(null);
			registerB.addActionListener(this);
			this.add(registerB);
			
			
			nouser = new JLabel("");
			nouser.setBounds(125,400,230,30);
			nouser.setForeground(Color.black);
			this.add(nouser);
//			
//			startGame = new JButton("Play");
//			startGame.setBounds(225,450,100,30);
//			startGame.setBackground(Color.white);
//			startGame.setBorder(null);
//			startGame.addActionListener(this);
//			this.add(startGame);
		    
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		    Object source = e.getSource();
		    
		    if(source == loginB)
		    {
		    	String uname = userNameField.getText();
		    	char arr[] = passwordField.getPassword();
		    	String ps = String.copyValueOf(arr);
		    	
		    	try {
		    		
		    		// opening connection
		    		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/blogapp","root" , "Suhel@123");
		    		
		    		// making the query
		    		String query = "select username , passwordl from users where username=? and passwordl=?";
		    		
		    		// making the statement
		    		PreparedStatement stmt = con.prepareStatement(query);
		    		
		    		stmt.setString(1,uname);
		    		stmt.setString(2, ps);
		    		
		    		ResultSet rs = stmt.executeQuery();
		    		
		    		if(rs.next()) {
//		    			System.out.print("Successful login ");
		    			new welcomeFrame();
		    		}
		    		else {
		    			nouser.setText("No such user exist. Please register.");
		    		}
		    		
		    	}catch(Exception ex) {
		    		System.out.print(ex.getMessage());
		    	}
		    	
		    }
		    else {
		    	new registerFrame();
		    }
		    
			
		}
}
