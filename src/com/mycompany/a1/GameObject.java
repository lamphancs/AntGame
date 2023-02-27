package com.mycompany.a1;

import java.util.Random;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;

public abstract class GameObject {

	// Constants to define the range of size and location for the game objects
	private static final int MIN_SIZE = 10;
	private static final int MAX_SIZE = 50;
	private static final float MIN_LOCATION = 0.0f;
	private static final float MAX_LOCATION = 1000.0f;

	// Attributes of the game object
	private final int size;	// size of the game object
	private Point location;	// location of the game object
	private int color;	// color of the game object

	// Constructor with size and color as parameters
	public GameObject(int color, int size) {
		this.size = size;
		this.location = generateRandomLocation();	// generate a random location for the game object
		this.color = color;
	}

	// Constructor with only color as parameter
	public GameObject(int color) {
		this.size = generateRandomSize();	// generate a random size for the game object
		location = generateRandomLocation();// generate a random location for the game object
		this.color = color;
	}

	public int getSize() {
		return size;
	}

	public Point getLocation() {
		return location;
	}

	public void setLocation(Point newLocation) {
		if (this instanceof FixedObject) {
			throw new UnsupportedOperationException("Cannot change location of a fixed object.");
		}
		location = newLocation;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int newColor) {
		// Check if the game object is a fixed object before changing its location
		if (this instanceof Flag || this instanceof Ant) {
			// Flags and Ants have a color that cannot be changed after creation
			throw new UnsupportedOperationException("Color cannot be changed for this type of game object.");
		}
		this.color = newColor;
	}


	// Static method to generate a random location within the range of MIN_LOCATION and MAX_LOCATION
	public static Point generateRandomLocation() {
		Random rand = new Random();
		float x = MIN_LOCATION + rand.nextFloat() * (MAX_LOCATION - MIN_LOCATION);
		float y = MIN_LOCATION + rand.nextFloat() * (MAX_LOCATION - MIN_LOCATION);
		return new Point(x, y);
	}


	// Static method to generate a random size within the range of MIN_SIZE and MAX_SIZE
	public static int generateRandomSize() {
		Random rand = new Random();
		return rand.nextInt(MAX_SIZE - MIN_SIZE + 1) + MIN_SIZE;
	}

	// TOSTRING METHOD
	// This method returns a string representation of the object, including its color, size, location.
	public String toString() {
		String location = "loc="+ Math.round(this.getLocation().getX()*10.0)/10.0 + "," + Math.round(this.getLocation().getY()*10.0)/10.0;
		String color = "color=["+ColorUtil.red(this.color)+","+ColorUtil.green(this.color)+","+ColorUtil.blue(this.color)+"]";
		String size = "size="+this.getSize();
		return location + " " + color + " " + size;
	}
}
