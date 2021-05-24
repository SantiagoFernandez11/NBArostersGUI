package AppAssignment;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;


public class NBAplayers extends JFrame implements ActionListener{
	
	JButton starters, fullRoster, back, exit, exit2;
	JPanel textFieldPanel, mainPanel, leftPanel, leftPanelImg, rightPanel, printingPanel, ComboBoxPanel, textPanel1, buttonPanel, startersPanel, fullTeamPanel, exitButtonPanel;
	JLabel leftLabel, rightLabeltxt, startersLabel, txtFieldLabel;
	JComboBox teams;
	JTextField usersName;
	File file;
	String user;
	
	public NBAplayers() {
		setTitle("NBA ROSTERS");
		setSize(500,350);
		setResizable(false);
		

		mainPanel = new JPanel();
		setContentPane(mainPanel);
		mainPanel.setBackground(Color.decode("#0253A4"));
		
		leftPanel = new JPanel();
		rightPanel = new JPanel();
		leftPanel.setBackground(Color.decode("#0253A4"));
		rightPanel.setBackground(Color.decode("#0253A4"));
		
		//image of NBA logo resized
		ImageIcon img = new ImageIcon(getClass().getResource("/NBAlogo.jpg"));
		Image image = img.getImage(); // make an Image object from the ImageIcon object
		Image newImage = image.getScaledInstance(250, 250, Image.SCALE_SMOOTH); // transform it
		img = new ImageIcon(newImage); // make an ImageIcon object from the Image object
		
				
		//image label in flow layout Panel
		leftPanelImg = new JPanel();
		leftLabel = new JLabel();
		leftLabel.setIcon(img);
		leftPanelImg.setLayout(new FlowLayout());
		leftPanelImg.add(leftLabel);
		leftPanelImg.setBackground(Color.decode("#0253A4"));
				
		//Combo box that has all the NBA team options
		String[] teamsoptions = {"Atlanta Hawks","Boston Celtics","Brooklyn Nets", "Charlotte Hornets","Chicago Bulls","Cleveland Cavaliers","Dallas Mavericks","Denver Nuggets","Detroit Pistons","Golden State Warriors","Houston Rockets","Indiana Pacers","Los Angeles Clippers","Los Angeles Lakers","Memphis Grizzlies","Miami Heat","Milwaukee Bucks","Minnesota Timberwolves","New Orleans Pelicans","New York Knicks","Oklahoma City Thunder","Orlando Magic","Philadelphia 76ers","Phoenix Suns","Portland Trail Blazers","Sacramento Kings","San Antonio Spurs","Toronto Raptors","Utah Jazz","Washington Wizards"};
		
		teams = new JComboBox<Object>(teamsoptions);
		teams.setMaximumSize(teams.getPreferredSize());
		teams.addActionListener(this);
		
		//Text field asking the user for their name
		usersName = new JTextField(10);
		usersName.setMaximumSize(usersName.getPreferredSize());
		user = "";
		
		
		txtFieldLabel = new JLabel("Enter your name");
		txtFieldLabel.setForeground(Color.white);
		
		textFieldPanel = new JPanel();
		textFieldPanel.setLayout(new BoxLayout(textFieldPanel, BoxLayout.X_AXIS));
		textFieldPanel.setBackground(Color.decode("#0253A4"));
		textFieldPanel.add(txtFieldLabel);
		textFieldPanel.add(usersName);
				
		//panel with label that asks user to select an NBA team
		textPanel1 = new JPanel();
		rightLabeltxt = new JLabel("Select an NBA team");
		rightLabeltxt.setAlignmentX(CENTER_ALIGNMENT);
		rightLabeltxt.setForeground(Color.white);
		textPanel1.add(rightLabeltxt);
	    textPanel1.setLayout(new BoxLayout(textPanel1, BoxLayout.Y_AXIS));
		textPanel1.setBackground(Color.decode("#0253A4"));
				
		//panel that has combo box with NBA teams
		ComboBoxPanel =  new JPanel();
	    ComboBoxPanel.setLayout(new BoxLayout(ComboBoxPanel, BoxLayout.Y_AXIS));
	    ComboBoxPanel.add(teams);
	    
	    
	    //right panel with buttons 
	    starters = new JButton("Starters");
	    starters.addActionListener(this);
		fullRoster = new JButton("Full Roster");
		fullRoster.addActionListener(this);
	    buttonPanel = new JPanel();
	    buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
	    buttonPanel.add(starters);
	    buttonPanel.add(fullRoster);
	    
	    //exit button
	    exit = new JButton("Exit");
	    exit.addActionListener(this);
	    exitButtonPanel = new JPanel();
	    exitButtonPanel.setLayout(new BoxLayout(exitButtonPanel, BoxLayout.X_AXIS));
	    exitButtonPanel.add(exit);

	    
	    
		//adding components to left panel and creating left panel layout 
		leftPanel.setLayout(new BoxLayout(leftPanel,BoxLayout.Y_AXIS));
		leftPanel.add(leftPanelImg);
		
		
		//adding components to right panel and creating right panel layout
		rightPanel.setLayout( new BoxLayout(rightPanel,BoxLayout.Y_AXIS ) );
		rightPanel.add(textFieldPanel);
		rightPanel.add(Box.createRigidArea(new Dimension(0,10)));
		rightPanel.add(textPanel1);
		rightPanel.add(Box.createRigidArea(new Dimension(0,10)));
		rightPanel.add(ComboBoxPanel);
		rightPanel.add(Box.createRigidArea(new Dimension(0,40)));
		rightPanel.add(buttonPanel);
		rightPanel.add(Box.createRigidArea(new Dimension(0,40)));
		rightPanel.add(exitButtonPanel);
						
		//setting the layout of the content pane to horizontal
		mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.X_AXIS));
		mainPanel.add(leftPanel);
		mainPanel.add(rightPanel);
		mainPanel.add(Box.createHorizontalGlue());
		
		
				
		validate();
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);	
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == starters) {
			String selectedTeam = (String)teams.getSelectedItem();
	        starterTeamPanelDesign(selectedTeam);
		}
		else if(e.getSource() == fullRoster) {
	        String selectedTeam = (String)teams.getSelectedItem(); 
	        fullTeamPanelDesign(selectedTeam);
		}
		else if(e.getSource() == back) {
			setContentPane(mainPanel);
		}else if(e.getSource() == exit || e.getSource() == exit2) {
			int exit = JOptionPane.showConfirmDialog(null,"I hope you enjoyed!", "Exit", JOptionPane.CLOSED_OPTION);
			if(exit == 0) {
				System.exit(0);
			}
		}
		
		
		
	}
	
	//method that makes the new team panel design using selected team in combo box
	public void starterTeamPanelDesign(String selectedTeam){
		
		//new panel with starters
		printingPanel = new JPanel();
		setContentPane(printingPanel);
		setVisible(true);
		printingPanel.setBackground(Color.decode("#0253A4"));
		printingPanel.setLayout(new BoxLayout(printingPanel, BoxLayout.Y_AXIS));
		
		//exit button
	    exit2 = new JButton("Exit");
	    exit2.addActionListener(this);
				
		//back button and respective panel
		JPanel backButtonPanel = new JPanel();
		backButtonPanel.setLayout(new BoxLayout(backButtonPanel,BoxLayout.X_AXIS));
		backButtonPanel.setBackground(Color.red); 
		back = new JButton("Back");
		back.addActionListener(this);
		backButtonPanel.add(back);
		backButtonPanel.add(exit2);
		        
		//Starters text label and respective panel
		user = (usersName.getText());
		JLabel startersTxtLabel = new JLabel("Hello "+ user + ", here is a list of the "+ selectedTeam+ " starting lineup");
		startersTxtLabel.setFont(new Font(null, Font.PLAIN, 14));

		JPanel startersTxtPanel = new JPanel();
		startersTxtPanel.setLayout(new BoxLayout(startersTxtPanel,BoxLayout.X_AXIS));
		startersTxtPanel.setBackground(Color.yellow); 
		startersTxtPanel.add(startersTxtLabel);
				     
		//adding panel to the main panel
		printingPanel.add(startersTxtPanel);
		printingPanel.add(Box.createRigidArea(new Dimension(0,20)));
		printingPanel.add(backButtonPanel);
		validate();
		
		//file reader and scanner
		try {
			file = new File("NBArosters.txt");
			FileReader in = new FileReader(file);
			String textLine = "";
			BufferedReader br = new BufferedReader(in);
			ArrayList<String> startersList = new ArrayList<String>();	
			
			//scanner loops through file until it finds selected team and it prints the next 5 names after the team name
			while((textLine = br.readLine()) != null) {
				if(textLine.equals(selectedTeam)) {
					for(int i = 0; i <5;i++) {
						startersList.add(br.readLine());
					}
				}
			}
			
			System.out.println(startersList);
			//System.out.println(textLine);

		}
		catch(FileNotFoundException e){
		
		}catch(IOException e) {
			
		}
	

		
		
	}
	
	//method that makes the new team panel design using selected team in combo box
	public void fullTeamPanelDesign(String selectedTeam){
		
		//new panel with full team
		printingPanel = new JPanel();
		setContentPane(printingPanel);
        setVisible(true);
        printingPanel.setBackground(Color.decode("#0253A4"));
		printingPanel.setLayout(new BoxLayout(printingPanel, BoxLayout.Y_AXIS));
		
		//exit button
	    exit2 = new JButton("Exit");
	    exit2.addActionListener(this);
		
		//back button and respective panel
		JPanel backButtonPanel = new JPanel();
		backButtonPanel.setLayout(new BoxLayout(backButtonPanel,BoxLayout.X_AXIS));
		backButtonPanel.setBackground(Color.red); 
        back = new JButton("Back");
        back.addActionListener(this);
        backButtonPanel.add(back);
        backButtonPanel.add(exit2);
        
        //Starters text label and respective panel
        user = (usersName.getText());
        JLabel startersTxtLabel = new JLabel("Hello "+ user + ", here is a list of the full "+ selectedTeam +" roster");
        System.out.println(user);
        startersTxtLabel.setFont(new Font(null, Font.PLAIN, 14));

        JPanel startersTxtPanel = new JPanel();
        startersTxtPanel.setLayout(new BoxLayout(startersTxtPanel,BoxLayout.X_AXIS));
		startersTxtPanel.setBackground(Color.yellow); 
		startersTxtPanel.add(startersTxtLabel);
				        
		printingPanel.add(startersTxtPanel);
		printingPanel.add(Box.createRigidArea(new Dimension(0,20)));
        printingPanel.add(backButtonPanel);
        validate();
	}
	
	
	
	public static void main (String [] args) throws IOException {
		new NBAplayers();
	}
	

}
