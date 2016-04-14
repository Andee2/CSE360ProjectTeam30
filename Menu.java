/**
 * This Panel will first show the buttons: *clicked*
 * 		Menu:
 * 			Instructions
 * 			createProfileButton 	--> a text field and a create button
 * 			createButton       		--> save whatever is in the text field to newPlayerProfile
 * 														[--> show message if the profile is added or not
 * 			chooseButton			--> lock in the player profile and set battleButton visible
 * 														[--> Option 2: pop-up another text area and choose button
 * 															 Player can put in the profile they want, return an 
 * 															 error if no match
 * 			rankButton				--> nothing yet; (idea) show the player profiles and ranking in the textArea
 *			battleButton			--> set menu visibility to false and set battle visibility to true
 * 
 *		Battle:
 *			Instructions
 *			diceChoices				--> save the number that is currently selected to playerNum
 *			rollButton				--> need to be implemented ******** update the textArea
 *														[-->currently the only way to set backButton visible
 *			backButton				--> set menu visibility to true and set battle visibility to false
 *														[--> UPDATE information. Show when game finish
 *			giveUpButton			--> set menu visibility to false and set battle visibility to true
 *														[--> don't update or add a lost
 *
 *		ListOfPlayer:					a text field that show A list of Profile or ranking
 *
 *
 *
 *	The JLabel message and the JPanel createProfilePanel will be reset to "" and not visible, respectively,
 *	whenever a button in the Menu panel is selected.
 */


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Menu extends JPanel
{	
	//A Lot of private variable instantiated
	private JLabel menuLabel, menuInstruction1, menuInstruction2, battleInstruction1, battleInstruction2, battleLabel, message;
	private JButton backButton, giveUpButton, rankButton, createButton, chooseButton, battleButton, createProfileButton, rollButton, empty, empty2, empty3, empty4;
	private JPanel menuOption, battleOption, createProfilePanel, cutTopHalf, battlePanel, battleInstruction, quitPanel;
	private JTextField createTextField;
	private TextArea listOfPlayer;
	private JComboBox<String> diceChoices;
	
	private String[] dice = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
	private int playerNum;
	private String newPlayerProfile;
	
	public Menu()
	{
		
/*========================================[DECLARATION]========================================*/
		//The instructions For Menu
		menuLabel = new JLabel("Menu");
		menuInstruction1 = new JLabel("Please choose a profile before process to fighting");
		menuInstruction2 = new JLabel("Create a new profile or choose from existing profile");
		
		//Instructions for Battle
		battleInstruction1 = new JLabel("Select the number you think the dice will land on");
		battleInstruction2 = new JLabel("Hit Roll to roll the dice");
		
		message = new JLabel("");
		
		//Empty buttons to make the GUI look aligned
		empty = new JButton("This should not be shown");
		empty.setVisible(false);
		empty2 = new JButton("This should not be shown");
		empty2.setVisible(false);
		empty3 = new JButton("This should not be shown");
		empty3.setVisible(false);
		empty4 = new JButton("This should not be shown");
		empty4.setVisible(false);
		
		//Buttons in the menu
		rankButton = new JButton("ranking");
		createButton = new JButton("Create Profile");
		chooseButton = new JButton("Choose Profile");	//Will not be visible until the a profile is choose;
		battleButton = new JButton("Start Fight");		//Will not be visible until a profile is choose
		createTextField = new JTextField();
		createProfileButton = new JButton("Create");
		
		//Button in the Battle
		rollButton = new JButton("Roll");
		backButton = new JButton("Back");
		giveUpButton = new JButton("Give Up");
		diceChoices = new JComboBox<String>(dice);
		
		backButton.setVisible(false);					//This button will Not be shown until the "game" end
		
		//Text Area for different purposes
		listOfPlayer = new TextArea("testing");
		
		//Create a text field for the player to fill out name and create button
		createProfilePanel = new JPanel();
		createProfilePanel.setLayout(new BoxLayout(createProfilePanel, BoxLayout.X_AXIS));
		createProfilePanel.add(createTextField);
		createProfilePanel.add(createProfileButton);
		
		createProfilePanel.setVisible(false);			//This will show when the player click the the player click recreate 
		
		
/*===================================[BUTTON LISTENER]=================================*/
		//Menus Buttons
		rankButton.addActionListener(new ButtonListener());
		createButton.addActionListener(new ButtonListener());
		chooseButton.addActionListener(new ButtonListener());
		createProfileButton.addActionListener(new ButtonListener());
		
		//Battle Buttons
		battleButton.addActionListener(new ButtonListener());
		rollButton.addActionListener(new ButtonListener());
		backButton.addActionListener(new ButtonListener());
		giveUpButton.addActionListener(new ButtonListener());
		 
		
/*================================[PANEL SET-UP]=========================================*/
		menuOption = new JPanel();
		menuOption.setLayout(new GridLayout(12,1, 0, 5)); 	
		menuOption.add(menuLabel);
		menuOption.add(menuInstruction1);
		menuOption.add(menuInstruction2);
		menuOption.add(message);
		menuOption.add(createButton);
		menuOption.add(createProfilePanel);
		menuOption.add(empty);
		menuOption.add(chooseButton);
		menuOption.add(empty2);
		menuOption.add(rankButton);
		menuOption.add(empty);
		menuOption.add(battleButton);
		
		battlePanel = new JPanel();
		battlePanel.setLayout(new GridLayout(2, 2));
		battlePanel.add(diceChoices);
		battlePanel.add(rollButton);
		battlePanel.add(empty4);
		battleLabel = new JLabel("Battle");
		
		battleInstruction = new JPanel();
		battleInstruction.setLayout(new GridLayout(2, 1));
		battleInstruction.add(battleInstruction1);
		battleInstruction.add(battleInstruction2);
		
		quitPanel = new JPanel();
		quitPanel.setLayout(new GridLayout(2, 1));
		quitPanel.add(giveUpButton);
		quitPanel.add(backButton);
		
		battleOption = new JPanel();
		battleOption.setLayout(new GridLayout(4, 1));
		battleOption.add(battleLabel);
		battleOption.add(battleInstruction);
		battleOption.add(battlePanel);
		battleOption.add(quitPanel);
		battleOption.setVisible(false);
		
		
		cutTopHalf = new JPanel();
		cutTopHalf.setLayout(new GridLayout(1, 2));
		cutTopHalf.add(menuOption);
		cutTopHalf.add(battleOption);
		
		JSplitPane splitPanel = new JSplitPane(JSplitPane.VERTICAL_SPLIT, cutTopHalf, listOfPlayer);
		setLayout(new BorderLayout());
	    add(splitPanel);
	}
/*=======================================[ACTION LISTENER]===============================================*/
	/*~~~~~~~~~~FILL IN THE REQUIRE FUNCTION~~~~~~~~~*/
	
	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event) {
			Object action = event.getSource();		
			if (action == createProfileButton)
			{
				//Implement the "create a new profile" here
				
				newPlayerProfile = createTextField.getText();			//save whatever in the text field too newPlayerProfile and reset text field
				if (newPlayerProfile.isEmpty())
				{
					message.setText("Please fill in the create profile!");
					message.setForeground(Color.red);
				}
				else
				{
					message.setText("Profile added");
					message.setForeground(Color.green);
					createTextField.setText("");
					createProfilePanel.setVisible(false);
				}
			}	
			if (action == chooseButton)
			{
				message.setText("");
				createProfilePanel.setVisible(false);
				//Implement the "choose the player" here
			}
			if (action == rankButton)
			{
				message.setText("");
				createProfilePanel.setVisible(false);
				//Implement the "show the ranking" here
			}
			if (action == battleButton)									//set Visibility to Menu panel and Battle panel
			{
				message.setText("");
				createProfilePanel.setVisible(false);
				menuOption.setVisible(false);
				battleOption.setVisible(true);
			}
			if (action == createButton)								
			{
				message.setText("");
				createProfilePanel.setVisible(true);
			}
			if (action == backButton)									//set Visibility to Menu panel and Battle panel
			{
				menuOption.setVisible(true);
				battleOption.setVisible(false);
				//Update info. implementation
			}
			if	(action == rollButton)
			{
				backButton.setVisible(true);
				//Implementation
			}
			if	(action == giveUpButton)								//set Visibility to Menu panel and Battle panel
			{
				menuOption.setVisible(true);
				battleOption.setVisible(false);
				//Implementation if needed
			}
		}
	}
	
	
	
	
/*==================================[COMBO LISTENER]=============================================*/
	private class ComboListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			if (diceChoices.getSelectedItem().equals("2"))
				playerNum = 2;
			else if (diceChoices.getSelectedItem().equals("3"))
				playerNum = 3;
			else if (diceChoices.getSelectedItem().equals("4"))
				playerNum = 4;
			else if (diceChoices.getSelectedItem().equals("5"))
				playerNum = 5;
			else if (diceChoices.getSelectedItem().equals("6"))
				playerNum = 6;
			else if (diceChoices.getSelectedItem().equals("7"))
				playerNum = 7;
			else if (diceChoices.getSelectedItem().equals("8"))
				playerNum = 8;
			else if (diceChoices.getSelectedItem().equals("9"))
				playerNum = 9;
			else if (diceChoices.getSelectedItem().equals("10"))
				playerNum = 10;
			else if (diceChoices.getSelectedItem().equals("11"))
				playerNum = 11;
			else if (diceChoices.getSelectedItem().equals("12"))
				playerNum = 12;
		}
	}
}
