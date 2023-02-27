package com.mycompany.a1;

import java.util.ArrayList;

import com.codename1.charts.util.ColorUtil;

public class GameWorld {

	private static final float WORLD_HEIGHT = 1000;
	private static final float WORLD_WIDTH = 1000;

	// The number of lives the player has left
	private int life;

	// The elapsed time in the game
	private int time;

	// The player-controlled ant in the game
	private Ant ant;

	// A list of all the food stations in the game
	private ArrayList<FoodStation> foodstationArr = new ArrayList<>();

	// A list of all the spiders in the game
	private ArrayList<Spider> spiderArr = new ArrayList<>();

	// A list of all the flags in the game
	private ArrayList<Flag> flagArr = new ArrayList<>();

	//private ArrayList<GameObject> gameObjectArr = new ArrayList<>();

	public void init() {

		life = 3; // Set the initial number of lives
		time = 0; // Set the initial time

		// Add two food stations to the game
		for (int i = 0; i < 2; i++) {
			FoodStation newFoodStation = new FoodStation();
			foodstationArr.add(newFoodStation);
			//gameObjectArr.add(newFoodStation);
		}

		// Add two spiders to the game
		for (int i = 0; i < 2; i++) {
			spiderArr.add(new Spider());
		}

		// Add nine flags to the game
		for (int i = 0; i < 9; i++) {
			flagArr.add(new Flag(i+1));
		}

		// Set the player-controlled ant's initial location and attributes
		ant  = new Ant(flagArr.get(0).getLocation(),10, 500, 20, 10, 0, 5);
	}

	public void accelerate() {
		// Increase the ant's speed by one unit
		ant.accelerate(1);
		System.out.println ("Ant has been accelerated.");
	}

	public void brake() {
		// Decrease the ant's speed by one unit
		ant.brake(1);
		System.out.println ("Ant has been reduced speed.");
	}

	public void left() {
		// Turn the ant left by 5 degrees
		ant.turnLeft();
		System.out.println ("Ant has turned left.");
	}

	public void right() {
		// Turn the ant right by 5 degrees
		ant.turnRight();
		System.out.println ("Ant has turned right.");
	}

	public void collision(int i) {
		// Check if the ant collided with the next flag in the sequence
		if(i - ant.getLastFlagReached() == 1) {
			// If the ant did reach the next flag, update its lastFlagReached attribute and print a notification
			ant.setLastFlagReached(i);
			System.out.println ("Ant got to flag " + i +".");
		}
		else
			// If the ant did not reach the next flag, print a notification with the last flag reached by the ant
			System.out.println ("Ant failed to get flag " + i +". The last reached flag is "+ ant.getLastFlagReached() + ".");
	}


	public void reachFoodstation() {

		//increase the ants food level by the capacity of the food station
		ant.setFoodLevel(ant.getFoodLevel() + foodstationArr.get(0).getCapacity());

		//Print the notification to the screen
		System.out.println ("Ant has reached a food station. Food level + " + foodstationArr.get(0).getCapacity() + ".");

		//Reduce the capacity of the food station to zero
		foodstationArr.get(0).setCapacity(0);

		//Fade the color of the food station
		foodstationArr.get(0).setColor(ColorUtil.LTGRAY);

		//Add a new food station with randomly-specified size and location into the game
		foodstationArr.remove(0);
		foodstationArr.add(new FoodStation());		
	} 

	public void collisionSpider() {

		//decrease the health level of the ant
		ant.setHealthLevel(ant.getHealthLevel() - 1);

		//Print the notification to the screen
		System.out.println ("Ant has collided with a spider. Healy level -1.");

		//fade the color of the ant


		//reduce the speed of the ant so that above-mentioned speed-limitation rule is enforced.
		ant.brake(1);
	}

	// This method displays the current status of the game including the ant's life, time, flag, food, and health
	public void display() {
		System.out.println ("Life: " + life);
		System.out.println ("Time: " + time);
		System.out.println ("Flag: " + ant.getLastFlagReached());
		System.out.println ("Food: " + ant.getFoodLevel());
		System.out.println ("Health: " + ant.getHealthLevel());		
	}

	// This method prints a map of the game world showing the current locations of flags, spiders, food stations, and the ant
	public void map() {

		// Output the locations of all the flags in the flag array
		for (int i = 0; i < flagArr.size(); i++) {
			System.out.println(flagArr.get(i).toString());
		}

		// Output the location of the ant
		System.out.println(ant.toString());

		// Output the locations of all the spiders in the spider array
		for (int i = 0; i < spiderArr.size(); i++) {
			System.out.println(spiderArr.get(i).toString());
		}	   

		// Output the locations of all the food stations in the foodstation array
		for (int i = 0; i < foodstationArr.size(); i++) {
			System.out.println(foodstationArr.get(i).toString());
		}
	}

	// This method prompts the user to exit the game
	public void exit() {
		System.out.println("Do you want to exit the game?(y/n)");
	}

	// This method informs the user that the exit command has been canceled
	public void noExit() {
		System.out.println("Exit canceled.");
	}

	// This method informs the user that the command they entered is not recognized
	public void unrecognizedCommand() {
		System.out.println("Unrecognized command.");	
	}

	// This method updates the game world by advancing one tick
	public void tick() {
		//Spiders update their heading
		for (int i = 0; i < spiderArr.size(); i++) {
			spiderArr.get(i).update(WORLD_WIDTH, WORLD_HEIGHT);
		}

		//All movable objects update their positions based on their current heading and speed
		//The ant's food level is reduced by its foodConsumptionRate
		ant.update(WORLD_WIDTH, WORLD_HEIGHT);

		//The game clock is incremented by one
		time += 1;

		//Print the notification to the screen
		System.out.println ("A tick has passed.");
	}
}
