package com.mycompany.a1;

import com.codename1.charts.util.ColorUtil;

public class Flag extends FixedObject{

	// A unique sequence number to identify the flag
	private final int sequenceNumber;

	// Constants for the flag size and color
	private static final int SIZE = 10;
	private static final int FLAG_COLOR = ColorUtil.BLUE;

	// Constructor for Flag object, calls superclass constructor
	public Flag(int sequenceNumber) {
		super(FLAG_COLOR, SIZE);
		this.sequenceNumber = sequenceNumber;
	}

	// Getter method for sequenceNumber
	public int getSequenceNumber() {
		return sequenceNumber;
	}

	// Override toString method to display information about the Flag
	public String toString() {
		String sqnumber = "seqNum=" + this.getSequenceNumber();
		return "Flag: " + super.toString() + " " + sqnumber;
	}
}
