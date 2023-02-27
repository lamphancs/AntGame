package com.mycompany.a1;

import com.codename1.charts.util.ColorUtil;

public class FoodStation extends FixedObject{

	private int capacity;
	private static final int FOODSTATION_COLOR = ColorUtil.GREEN;

	public FoodStation() {
		super(FOODSTATION_COLOR);	// call constructor of superclass
		this.capacity = super.getSize() * 10;	// set capacity to 10 times the size of the object
	}

	public int getCapacity() {
		return capacity;	// returns the capacity of the food station
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;	// sets the capacity of the food station to the specified value
	}

	public String toString() {
		String capacity = "capacity=" + this.getCapacity();
		return "FoodStation: " + super.toString() + " " + capacity;	// returns a string representation of the food station's attributes
	}
}
