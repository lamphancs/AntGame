package com.mycompany.a1;

import com.codename1.charts.models.Point;

public class MovableObject extends GameObject{

	private int heading;// the current heading of the movable object
	private int speed;	// the current speed of the movable object

	// ANT CONSTRUCTOR
	public MovableObject(int size, Point location, int color, int heading, int speed) {
		super(color);	// call the constructor of the parent class (GameObject) and pass it the color parameter
		this.heading = heading;	// initialize the heading field with the provided heading parameter
		this.speed = speed;	// initialize the speed field with the provided speed parameter
	}

	// SPIDER CONSTRUCTOR
	public MovableObject(int SPIDER_COLOR, int heading, int speed) {
		super(SPIDER_COLOR);	// call the constructor of the parent class (GameObject) and pass it the SPIDER_COLOR constant
		this.heading = heading;	// initialize the heading field with the provided heading parameter
		this.speed = speed;	// initialize the speed field with the provided speed parameter
	}

	public int getHeading() {
		return heading;	// return the current heading of the movable object
	}

	public int getSpeed() {
		return speed;	// return the current speed of the movable object
	}

	public void setSpeed(int newSpeed) {
		this.speed = newSpeed;	// set the speed of the movable object to the provided newSpeed value
	}

	public void setHeading(int newHeading) {
		this.heading = newHeading;	// set the heading of the movable object to the provided newHeading value
	}

	//currently unused
	public void move() {
		Point oldLocation = new Point();
		Point newLocation = new Point();
		oldLocation = getLocation();
		newLocation.setX((float) (oldLocation.getX()+Math.cos(Math.toRadians(heading))*speed));
		newLocation.setY((float) (oldLocation.getY()+Math.sin(Math.toRadians(heading))*speed));
		setLocation(newLocation);
	}

	// UPDATE METHOD
	// This method updates the object's position based on its speed and heading, and adjusts
	// the position if the object goes out of bounds.
	public void update(float worldWidth, float worldHeight) {
		// calculate the change in x and y coordinates based on speed and heading
		double dx = speed * Math.cos(Math.toRadians(heading));
		double dy = speed * Math.sin(Math.toRadians(heading));

		// update the position based on the calculated change in x and y coordinates
		Point newLocation = new Point();
		newLocation.setX(this.getLocation().getX() + (int) dx);
		newLocation.setY(this.getLocation().getY() + (int) dy);
		this.setLocation(newLocation);

		// check if the object is out of bounds and adjust its position if necessary
		if (this.getLocation().getX() < 0) {
			newLocation.setX(0);
			this.setLocation(newLocation);
		} else if (this.getLocation().getX() > worldWidth) {
			newLocation.setX(worldWidth);
			this.setLocation(newLocation);
		}
		if (this.getLocation().getY() < 0) {
			newLocation.setY(0);
			this.setLocation(newLocation);
		} else if (this.getLocation().getY() > worldHeight) {
			newLocation.setY(worldHeight);
			this.setLocation(newLocation);
		}
	}

	// TOSTRING METHOD
	// This method returns a string representation of the object, including its color, size,
	// location, heading, and speed.
	public String toString() {
		String heading = "heading=" + this.getHeading();
		String speed = "speed=" + this.getSpeed();
		return super.toString() + " " + heading + " " + speed;
	}
}
