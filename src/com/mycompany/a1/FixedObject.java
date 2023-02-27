package com.mycompany.a1;

import com.codename1.charts.models.Point;

public class FixedObject extends GameObject{

	// FLAG CONSTRUCTOR
	public FixedObject(int FLAG_COLOR,int SIZE) {
		super(FLAG_COLOR, SIZE);
	}

	// FOODSTATION CONSTRUCTOR
	public FixedObject(int FOODSTATIONCOLOR) {
		super(FOODSTATIONCOLOR);
	}

	// Fixed game objects are not allowed to change location once created
	public void setLocation(Point location) {
		// Throw an UnsupportedOperationException if someone tries to change the location
		throw new UnsupportedOperationException("Cannot change the location of a Fixed object");
	}

	public String toString() {
		return super.toString();
	}

}
