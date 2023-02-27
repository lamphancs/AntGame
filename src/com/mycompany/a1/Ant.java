package com.mycompany.a1;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;

//Ant class inherits from MovableObject and implements ISteerable
public class Ant extends MovableObject implements ISteerable{

	// Constant variables
	private static final int SIZE = 20;	// size of the ant
	private static final int ANT_COLOR = ColorUtil.GRAY;	// color of the ant

	private int maximumSpeed;	// maximum speed the ant can travel
	private int foodLevel;	// amount of food the ant has
	private int foodConsumptionRate;	// rate at which the ant consumes food
	private int healthLevel;	// health level of the ant
	private int lastFlagReached;	// last flag reached by the ant

	// Constructor
	public Ant(Point location, int maximumSpeed, int foodLevel, int foodConsumptionRate, int healthLevel, int heading, int speed) {
		super(SIZE, location, ANT_COLOR, heading, speed);	// calls the constructor of MovableObject
		super.setLocation(location);
		this.maximumSpeed = maximumSpeed;
		this.foodLevel = foodLevel;
		this.foodConsumptionRate = foodConsumptionRate;
		this.healthLevel = healthLevel;
		this.lastFlagReached = 1;
	}

	public int getMaximumSpeed() {
		return maximumSpeed;
	}

	public void setMaximumSpeed(int maximumSpeed) {
		this.maximumSpeed = maximumSpeed;
	}

	public int getFoodLevel() {
		return foodLevel;
	}

	public void setFoodLevel(int foodLevel) {
		this.foodLevel = foodLevel;
	}

	public int getFoodConsumptionRate() {
		return foodConsumptionRate;
	}

	public void setFoodConsumptionRate(int foodConsumptionRate) {
		this.foodConsumptionRate = foodConsumptionRate;
	}

	public int getHealthLevel() {
		return healthLevel;
	}

	public void setHealthLevel(int healthLevel) {
		this.healthLevel = healthLevel;
		// adjust speed based on health level
		int adjustedSpeed = (int) (maximumSpeed * ((double) healthLevel / 10));
		setSpeed(adjustedSpeed);
	}

	public int getLastFlagReached() {
		return lastFlagReached;
	}

	public void setLastFlagReached(int lastFlagReached) {
		this.lastFlagReached = lastFlagReached;
	}

	@Override
	public void update(float worldWidth, float worldHeight ) {
		// update location based on heading and speed
		super.update(worldWidth,worldHeight);
		// decrement food level based on consumption rate
		foodLevel -= foodConsumptionRate;
		// limit speed based on health level
		int adjustedSpeed = (int) (maximumSpeed * ((double) healthLevel / 10));
		setSpeed(Math.min(getSpeed(), adjustedSpeed));
	}

	// Method to accelerate the ant by a small amount, limited by health level, food level, and maximum speed
	public void accelerate(int acceleration) {

		// Calculate the maximum increase in speed based on health level and food level
		int maxIncrease = (int) ((100 - healthLevel) / 10.0 + (100 - foodLevel) / 10.0);

		// Calculate the new speed after acceleration
		int newSpeed = (int) (getSpeed() + acceleration);
		if (newSpeed > this.getMaximumSpeed()) {
			newSpeed = this.getMaximumSpeed();
		} else if (newSpeed - getSpeed() > maxIncrease) {
			newSpeed = getSpeed() + maxIncrease;
		}

		// Set the new speed
		setSpeed(newSpeed);
	}

	// Method to accelerate the ant by a small amount
	public void brake(int brake) {    	

		// Calculate the new speed after acceleration
		int newSpeed = (int) (getSpeed() - brake);
		if (newSpeed < 0) {
			newSpeed = 0;
		}

		// Set the new speed
		setSpeed(newSpeed);
	}

	// Method to change the heading of the ant by 5 degrees to the left
	public void turnLeft() {
		this.setHeading(this.getHeading() - 5);
	}

	// Method to change the heading of the ant by 5 degrees to the right
	public void turnRight() {
		this.setHeading(this.getHeading() + 5);
	}

	@Override
	public void steer(int heading) {
		setHeading(heading);	// Sets the heading of the Ant to the specified value
	}

	public String toString() {

		// Gets the maximum speed of the Ant and stores it in a String
		String maxSpeed = "maxSpeed=" + this.getMaximumSpeed();

		// Gets the food consumption rate of the Ant and stores it in a String
		String foodConsumption = "foodConsumptionRate=" + this.getFoodConsumptionRate();	

		// Returns a string that contains the Ant's name, super.toString() (which calls the parent class's toString() 
		// method), and the max speed and food consumption rate Strings
		return "Ant: " + super.toString() + " " + maxSpeed + " " + foodConsumption;
	}
}
