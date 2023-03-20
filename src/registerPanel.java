import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.sql.*;
public class registerPanel extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// v a r r i a b l e s 
	static final int SCREEN_WIDTH = 600; 
	static final int SCREEN_HEIGHT = 600;
	JLabel name;
	JLabel userName;
	JLabel password;
//	JLabel confirmPass;
	JLabel logo;
	
	JButton registerB;
	JButton loginB;
	
	JTextField nameField;
	JTextField userNameField;
	JPasswordField passwordField;
//	JPasswordField confirmPassField;
	
	registerPanel(){
		this.setPreferredSize(new Dimension(SCREEN_WIDTH , SCREEN_HEIGHT)); 
		this.setBackground(new Color(211,211,211));
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
		
		
		name = new JLabel("Name:");
		name.setBounds(125,150,80,30);
		name.setForeground(Color.black);
		this.add(name);   // this line is mandatory to display every control and input field on the panel
		
		
		nameField = new JTextField();
		nameField.setBounds(200,150,150,30);
		nameField.setBorder(null);
		nameField.setBackground(Color.white);
		this.add(nameField);
		
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
	
	    
	    
	    registerB = new JButton("Register");
	    registerB.setBounds(250,350,80,30);
	    registerB.setBackground(Color.white);
	    registerB.setBorder(null);
	    registerB.addActionListener(this);
	    this.add(registerB);
	    
	    loginB = new JButton("Login");
	    loginB.setBounds(380,350,140,30);
	    loginB.setBackground(Color.white);
	    loginB.setBorder(null);
	    loginB.addActionListener(this);
	    this.add(loginB);
	    
	    
	}
	
//	public Connection getConnection() {
//		
//		Connection con;
//		
//		try {
//			// registering the driver
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			
//			
//			// creating the connection string
//		    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/blogapp","root" , "Suhel@123");
//		    return con;
//		}catch(Exception e) {
//			System.out.print(e.getMessage());
//		}
//		
//		return null;
//		
//	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		Object source = e.getSource();
		
		if(source == loginB) {
			new loginFrame();
		}
		if(source == registerB) {
		
			
			//making connection with db
			
			try {
				// registering the db driver
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				// creating connection string
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/blogapp" ,"root" ,"Suhel@123");
				
				// querry
				String query = "insert into users values(?,?,?)";
				
				// prepared statement
				PreparedStatement stmt = con.prepareStatement(query);
				
				System.out.print("inserting records");
				// adding values;
				stmt.setString(1, nameField.getText());
				stmt.setString(2, userNameField.getText());
				
				// getpassword gives char arr as ans chnage it to string
				char[] arr = passwordField.getPassword();
				String ps = String.copyValueOf(arr);
				
				stmt.setString(3, ps);
				
				
				// executing the query
				stmt.executeUpdate();
//				int total_records = stmt.executeUpdate();
				
				
				
				stmt.close();
				con.close();
			}catch(Exception ex) {
				System.out.print(ex);
			}
			
			JLabel registerMessage = new JLabel("You are registered successfully. Login now!");
			this.add(registerMessage);
			registerMessage.setBounds(250,400,300,30);
			
		
		}
	}

	
}

