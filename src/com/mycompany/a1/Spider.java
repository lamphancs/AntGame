package com.mycompany.a1;

import java.util.Random;

import com.codename1.charts.util.ColorUtil;

public class Spider extends MovableObject{

	// Define constants for the minimum and maximum heading and speed values for a spider
	private static final int MIN_HEADING = 0;
	private static final int MAX_HEADING = 359;
	private static final int MIN_SPEED= 5;
	private static final int MAX_SPEED = 10;

	// Define the color for a spider
	private static final int SPIDER_COLOR = ColorUtil.YELLOW;

	private int health;	// Declare an instance variable to store the spider's health level
	private static Random rand = new Random();	// Create a Random object for generating random values

	public Spider() {
		super(SPIDER_COLOR, generateRandomHeading(), generateRandomSpeed());	// Call the superclass constructor with the spider's color, heading, and speed
		this.health = 10;	// initializes health to 10
	}

	// Method for generating a random heading value for a spider
	public static int generateRandomHeading() {
		return rand.nextInt(MAX_HEADING - MIN_HEADING + 1) + MIN_HEADING;
	}

	// Method for generating a random speed value for a spider
	public static int generateRandomSpeed() {
		return rand.nextInt(MAX_SPEED - MIN_SPEED + 1) + MIN_SPEED;
	}

	// Method for updating the spider's position and heading
	public void update(float worldWidth, float worldHeight) {
		// updates the spider's position and heading
		super.update(worldWidth, worldHeight);

		// if the spider hits a side of the world, change heading to avoid going out of bounds
		if (this.getLocation().getX() <= 0 || this.getLocation().getX() >= worldWidth || this.getLocation().getY() <= 0 || this.getLocation().getY() >= worldHeight) {
			changeHeading();
		}

		// if the spider is at the same location as the ant, decrease the ant's health level
		//if (this.getLocation().getX() == ant.getLocation().getX() && this.getLocation().getY() == ant.getLocation().getY()) {
		//    ant.setHealthLevel(ant.getHealthLevel()-1);
		//}

		// Add a small random value to heading to avoid moving in a straight line
		int deviation = rand.nextInt(11) - 5; 	// Generate a random value between -5 and 5
		setHeading(getHeading() + deviation);	// Add the deviation to the spider's current heading
	}

	// Method for changing the spider's heading by a random amount
	private void changeHeading() {
		// changes the spider's heading by a random amount
		setHeading(rand.nextInt(MAX_HEADING - MIN_HEADING + 1) + MIN_HEADING);
	}

	// Override the toString method to return a string representation of the Spider object
	public String toString() {
		return "Spider: " + super.toString();
	}
}
