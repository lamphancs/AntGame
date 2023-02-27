package com.mycompany.a1;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener; 

public class Game extends Form{
	private boolean quitting = false;
	private GameWorld gw; 
	public Game() { 
		gw  = new GameWorld(); 
		gw.init(); 
		play(); 
	} 

	private void play() { 

		Label myLabel=new Label("Enter a Command:");
		this.addComponent(myLabel);
		final TextField myTextField=new TextField();
		this.addComponent(myTextField);
		this.show();
		myTextField.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {

				String sCommand=myTextField.getText().toString();
				myTextField.clear();
				// Check if input command is not empty
				if(sCommand.length() != 0)
					// Check if the player is not quitting
					if(quitting == false) {
						// Check the first character of the input command and execute the appropriate action
						switch (sCommand.charAt(0)) {
						case 'a':
							gw.accelerate();
							break;
						case 'b':
							gw.brake();
							break;
						case 'd':
							gw.display();
							break;
						case 'l':
							gw.left();
							break;
						case 'r':
							gw.right();
							break;
						case '1':
							gw.collision(1);
							break;
						case '2':
							gw.collision(2);
							break;
						case '3':
							gw.collision(3);
							break;
						case '4':
							gw.collision(4);
							break;
						case '5':
							gw.collision(5);
							break;
						case '6':
							gw.collision(6);
							break;
						case '7':
							gw.collision(7);
							break;
						case '8':
							gw.collision(8);
							break;
						case '9':
							gw.collision(9);
							break;
						case 'f':
							gw.reachFoodstation();
							break;
						case 'g':
							gw.collisionSpider();
							break;
						case 't':
							gw.tick();
							break;
						case 'm':
							gw.map();
							break;
						case 'x':
							gw.exit();
							// Set quitting flag to true
							quitting = true;
							break;
						default:
							gw.unrecognizedCommand();
							break;
							//add code to handle rest of the commands
						}	//switch
					}	// if not quitting
					else if(quitting == true) {
						// Check the first character of the input command when the player is quitting
						switch (sCommand.charAt(0)) {
						case 'y':
							// Exit the program
							System.exit(0);
							break;
						case 'n':
							// Don't exit and reset quitting flag to false
							gw.noExit();
							quitting = false;
							break;
						default:
							// Handle an unrecognized command
							gw.unrecognizedCommand();
							// Don't exit and reset quitting flag to false
							gw.noExit();
							quitting = false;
							break;
						}
					}
			} //actionPerformed
		} //new ActionListener()
				); //addActionListener
	} //play
} 

