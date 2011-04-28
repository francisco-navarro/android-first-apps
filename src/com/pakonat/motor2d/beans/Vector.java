package com.pakonat.motor2d.beans;

import java.io.Serializable;

public class Vector implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int Fuerza;
	
	private Coord coord;

	public Vector(int fuerza, Coord coord) {
		super();
		Fuerza = fuerza;
		this.coord = coord;
	}

	public int getFuerza() {
		return Fuerza;
	}

	public void setFuerza(int fuerza) {
		Fuerza = fuerza;
	}

	public Coord getCoord() {
		return coord;
	}

	public void setCoord(Coord coord) {
		this.coord = coord;
	}

}
