
import java.awt.*; // everything which is in a w t graphics etc
import java.awt.event.*;  // all thing like event listener , action listener
import java.util.Random;
//import java.util.Random.*;

import javax.swing.*; // to import the swing controls

// it will extend j panel and it will implements the action listener interface  for our game
public class gamePanel extends JPanel implements ActionListener {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// v a r r i a b l e s 
	static final int SCREEN_WIDTH = 600; 
	static final int SCREEN_HEIGHT = 600;
	
	ImageIcon image1 ,image2 , image3 , image4 , image5 , image6 , image7 , image8 , image9 , image10;

	// in snake game we have matrix like structure which is used to display the apples this will decide the 4sides of that cube or apple imagine matrix here and then one of the cube as apple
	static final int UNIT_SIZE = 25;
	
	// THIS WILL DECIDE THE NUMBER OF CUBES OF THE MATRIX
	static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)*UNIT_SIZE;
	
	static final int DELAY = 100;  // delay of game
	
	// these are the two arrays which will be used to  X and Y 	they will
	// hold all the x and y for all the bodyParts of our snake and also the head of the snake 
	// snake will move here and there and continuously everything will change in snake's body to maintain a record 
	// of that these arrays will be used.
	final int x[] = new int[GAME_UNITS];  // GAME_UNITS is taken because length of snake is not going to be larger than that game
	final int y[] = new int[GAME_UNITS];
	
	int bodyParts = 4; // initial size of the snake
	int applesEaten; // number of apples eaten by the snake default in java 0;
	int appleX; int appleY; // these are x and y of the apple where it is going to be appear randomly
	
	char direction = 'R';  // initial direction for the movement of snake will be right U = up , D = down , L = left R = right
	boolean running = false; // this is used to tell whether the game is running at any instance or not
	
	Timer timer , timer1 ; // Timer is a defined in u t i l package which is used to run a thread of a program after the specified amount of 
	// the time. this is done with help of a functions. timer basically works on the MULTITHREADING concepts so the functions which were there are also available here too like start , end etc
	Random random; // creating the instance of the class i.e. RANDOM
	
	JButton restartB;
	
	// making the constructor
	gamePanel(){
		random = new Random();  // giving memory to the reference in 38 line
		
		//  this will be used to set the desire able size of the window
		this.setPreferredSize(new Dimension(SCREEN_WIDTH , SCREEN_HEIGHT)); 
		
		// setting the color
		this.setBackground(new Color(143,188,143));
		
		// changing the focus
		this.setFocusable(true);
		
		// adding keyListener
		this.addKeyListener(new MyKeyAdapter());
		
		this.setLayout(null);
		
		// starting game
		startGame();
	}
	 
	// this will be used to start
	public void startGame()  {
		
//		new waitFrame();
		
//		registrationScreen(g);
		newApple(); // creating new apple or the cube of matrix just when the game starts
		running = true;  // running the game
		
		timer = new Timer(DELAY , this); // this is passed here because after any kind of 
		// action game will start with a DELAY 
		timer.start(); // start function of mutithreading is called here
		putTiles();
	}
	
	// this will be used to paint things in screen
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}
	
	// to draw shapes
	public void draw(Graphics g) {
		
		
		if(running) {
			// creating the matrix for apples
			
			// this was just made to see the grids inorder to create the apples.
			
//			for(int i = 0; i< SCREEN_HEIGHT/UNIT_SIZE;i++) {
//				
//				// PUTS LINES ON X AXIS
//				g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, SCREEN_HEIGHT);
//				
//				// PUTS LINE ON Y AXIZ 
//				g.drawLine(0, i*UNIT_SIZE, SCREEN_WIDTH, i*UNIT_SIZE);
//			}
			
			
			// TO DRAW THE APPLE
			g.setColor(Color.red);
			g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);  // fillOval is method in java which fills the oval inside a rectangle with specified color and cordinates
			
			// to draw snake and body
			
			for(int i = 0; i < bodyParts; i++) {
				if(i == 0) {  // this refers to head of snake
					g.setColor(Color.black);
					g.fillOval(x[i], y[i], UNIT_SIZE, UNIT_SIZE); // THIS FILLS THE RECTANGLE OF THE SNAKE
				}else {
					
				     g.setColor(new Color(59,75,33)); // this line will only generate a snake of a static color
					//g.setColor(new Color(random.nextInt(255) , random.nextInt(255) , random.nextInt(255))); // this will generate a snake of random color
					g.fillOval(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
				}
			}
		}else {
			// these two lines will draw game over message and score on the screen if the game gets over.
			gameOver(g);
			drawScore(g);  
		}
		
	}
    
	// this is used to display the new apple EVERY TIME an apple is eaten by the snake or when the game starts.
	public void newApple() {
		appleX = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))* UNIT_SIZE;  // THESE TWO ARE PASSED SO THAT THE APPLE WHICH Will be generated stays in the screen only
        appleY = random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE)) *UNIT_SIZE;  
	}
	
	// to move the snake
	public void move() {
		for(int i = bodyParts; i >0; i--) {
			x[i] = x[i -1];  // shifting coordinates and moving the snake
			y[i] = y[i-1];
		}
		
		switch(direction) {
		case 'U':
			y[0] = y[0] - UNIT_SIZE;
			break;
		case 'D':
			y[0] = y[0] + UNIT_SIZE;
			break;
		case 'L':
			x[0] = x[0] - UNIT_SIZE;
			break;
		case 'R':
			x[0] = x[0] + UNIT_SIZE;
			break;
			
		}
	}
	
	// this will be used to see if the snake have eaten the apple or dot which is appeared on the screen or not
	public void checkApple() {
		
		
		// NOTHING much to be done here we will just check if the head's coordinates are collided with coordinates of 
		// apple 
		if((x[0] == appleX) &&(y[0] == appleY)) {
			bodyParts++;  // snake ka body part ek se badh gya
			applesEaten++; // kitne apple snake kha chuka hai vo badh gye ye hmara score maintain krne me use hoga
			newApple(); // this the method defined here in file which will generate the apple at new co ordinates, 
		}
	}
	
	// this will be used to check that if snake has not eaten itself
	public void checkCollisions() {
		
		// this will check if snakes colldies with its body itself for that we have to iterate through all the body parts
		for(int i = bodyParts; i>0; i--) {
			// x[0] and y[0] means head of snake
			if((x[0] == x[i]) && y[0]==y[i]) {
				running = false;
			}
		}
		
		// checks if head touches left border
		if(x[0] < 0) {
			running = false;
		}
		
		// checks if head touches right border
		if(x[0] > SCREEN_WIDTH) {
			running = false;
		}
		
		if((x[0] >= 200 && x[0] <=260) && (y[0] >=0 && y[0] <= 38)) {
			running = false;
		}
		
//		if() {
//			running = false;
//		}
		// head touches top border
		if(y[0] < 0) {
			running = false;
		}
		
		// head touches bottom border
		if(y[0] > SCREEN_HEIGHT) {
			running = false;
		}
		
		
		if(!running) {
			timer.stop();  // as timer is a multi threading function that is why its a thread and have all the thread functions
		}
	}
	
	// this will be used to tell the Game over
	public void gameOver(Graphics g) {
		// game over text
		g.setColor(new Color(0,100,0)); // uska color red hoga
		g.setFont(new Font("Ink Free" , Font.BOLD , 40)); // font type and size of the font
		
		// ek font matrix nam ki cheez hoti hai hmari java me jo ki hme font ko center of the screen par lane me help kr deti hai kafi jyada
		
		FontMetrics metrics = getFontMetrics(g.getFont()); // jo font hme set krna graphics se use idhar bhej diya matrix me
		g.drawString("Game Over!", (SCREEN_WIDTH - metrics.stringWidth("Game Over!"))/2 , SCREEN_HEIGHT / 2); // THIS LINE WILL GIVE US GAME OVER TEXT IN THE CNETER OF THE SCREEN
	}
	
	public void drawScore(Graphics g) {
		// game over text
		g.setColor(new Color(0,100,0)); // uska color red hoga
		g.setFont(new Font("Ink Free" , Font.BOLD , 20)); // font type and size of the font
				
		// ek font matrix nam ki cheez hoti hai hmari java me jo ki hme font ko screen par kahi bhi set krne me help krti  help kr deti hai kafi jyada
				
		FontMetrics metrics = getFontMetrics(g.getFont()); // jo font hme set krna graphics se use idhar bhej diya matrix me
		g.drawString("Score = "+applesEaten, (SCREEN_WIDTH - metrics.stringWidth("Score = "+applesEaten))/2 , SCREEN_HEIGHT - 250); // THIS LINE WILL display score at the bottom of the screen
		
		restartB = new JButton("Restart");
		this.add(restartB);
		restartB.setBounds(300,400,60,30);
		restartB.setBackground(Color.black);
		restartB.setForeground(Color.white);
		restartB.setBorder(null);
		restartB.addActionListener(this);
		
	}
	
	// for putting tiles 
	public void putTiles() {
		try {
			image1 = new ImageIcon(ClassLoader.getSystemResource("tiles/wall.png"));
			Image i2 = image1.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
			ImageIcon i3 = new ImageIcon(i2);
		    JLabel back = new JLabel(i3);
		    back.setBounds(200,0,40,40);
		    this.add(back);
		    
		    image2 = new ImageIcon(ClassLoader.getSystemResource("tiles/wall.png"));
			Image i21 = image1.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
			ImageIcon i31 = new ImageIcon(i21);
		    JLabel back2 = new JLabel(i31);
		    back2.setBounds(240,0,40,40);
		    this.add(back2);
		    
		    image3 = new ImageIcon(ClassLoader.getSystemResource("tiles/wall.png"));
			Image i22 = image3.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
			ImageIcon i32 = new ImageIcon(i22);
		    JLabel back3 = new JLabel(i32);
		    back3.setBounds(380,200,40,40);
		    this.add(back3);
		    
		    image4 = new ImageIcon(ClassLoader.getSystemResource("tiles/wall.png"));
			Image i23 = image4.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
			ImageIcon i33 = new ImageIcon(i23);
		    JLabel back4 = new JLabel(i33);
		    back4.setBounds(380,240,40,40);
		    this.add(back4);
		    
		    image5 = new ImageIcon(ClassLoader.getSystemResource("tiles/wall.png"));
			Image i24 = image4.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
			ImageIcon i34 = new ImageIcon(i24);
		    JLabel back5 = new JLabel(i34);
		    back5.setBounds(300,560,40,40);
		    this.add(back5);
		    
		    image6 = new ImageIcon(ClassLoader.getSystemResource("tiles/wall.png"));
			Image i25 = image4.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
			ImageIcon i35 = new ImageIcon(i25);
		    JLabel back6 = new JLabel(i35);
		    back6.setBounds(340,560,40,40);
		    this.add(back6);
		    
		    image7 = new ImageIcon(ClassLoader.getSystemResource("tiles/wall.png"));
			Image i26 = image7.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
			ImageIcon i36 = new ImageIcon(i26);
		    JLabel back7 = new JLabel(i36);
		    back7.setBounds(100,280,40,40);
		    this.add(back7);
		    
		    image8 = new ImageIcon(ClassLoader.getSystemResource("tiles/wall.png"));
			Image i27 = image4.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
			ImageIcon i37 = new ImageIcon(i27);
		    JLabel back8 = new JLabel(i37);
		    back8.setBounds(100,320,40,40);
		    this.add(back8);
	
		}catch(Exception e) {
			System.out.print("No image here");
		}
	}
	
	// as we are implementing our ActionListener interface and the functions in that will the abstract that is why we are over riding one of them here
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(running) {
			move();
			checkApple(); // this checks if we have eaten apple or not
			checkCollisions(); // this checks if snake has eaten itself or not.
		}
		repaint(); // it is in applet jab b call hoga cheeze erase ho kr dubara print ho jaygi
		
		Object source = e.getSource();
		if(source == restartB) {
			new welcomeFrame();
//			System.out.print(source);
		}
;		
	}
	
    // this is the inner class which will be used to see which of the following is pressed and listen the event attached to it.
	public class MyKeyAdapter extends KeyAdapter{
		@Override 
		public void keyPressed(KeyEvent e) {
			
			// going to control the keys events
			
			//For key pressed and key released events, the getKeyCode method returns the event's keyCode. For key typed events, the getKeyCode method always
			//returns VK_UNDEFINED. The getExtendedKeyCode method may also be used with many international keyboard layouts.
			switch(e.getKeyCode()) {
			case KeyEvent.VK_LEFT:   // THIS vk_left is used to listen the left arrow when it is pressed
				
				// hme user ko bas 90 degree turn krna hai na ki use 180 degree turn krna agar use 180 degree turn kar diya to vo khud me bhid jyga jaa kr
				// next line means agar snake hmar right ja rha AND hmne left key press kr di to vo immediate left mud juga and khud se takra jaygaIMGAINE this thing inside your head
				if(direction != 'R') {
					direction = 'L';
				}
				break;
			
			case KeyEvent.VK_RIGHT: // THIS vk_right is used to listen the right arrow when it is pressed
				
				// hme user ko bas 90 degree turn krna hai na ki use 180 degree turn krna agar use 180 degree turn kar diya to vo khud me bhid jyga jaa kr
				// next line means agar snake hmar LEFT  ja rha and hmne right dba di key to khud me bhid jayga IMGAINE this thing inside your head
				if(direction != 'L') {
					direction = 'R';
				}
				break;
				
            case KeyEvent.VK_UP: // THIS vk_up is used to listen the up arrow when it is pressed
				
				// hme user ko bas 90 degree turn krna hai na ki use 180 degree turn krna agar use 180 degree turn kar diya to vo khud me bhid jyga jaa kr
				// next line means agar snake hmar DOWN  ja rha and hmne UP dba di key to khud me bhid jayga IMGAINE this thing inside your head
				if(direction != 'D') {
					direction = 'U';
				}
				break;
				
            case KeyEvent.VK_DOWN: // THIS vk_left is used to listen the left arrow when it is pressed
				
				// hme user ko bas 90 degree turn krna hai na ki use 180 degree turn krna agar use 180 degree turn kar diya to vo khud me bhid jyga jaa kr
				// next line means agar snake hmar UP  ja rha and hmne DOWN dba di key to khud me bhid jayga IMGAINE this thing inside your head
				if(direction != 'U') {
					direction = 'D';
				}
				break;
				
				
			}
		}
	}
}
