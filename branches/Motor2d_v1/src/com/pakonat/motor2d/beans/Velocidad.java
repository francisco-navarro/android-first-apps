package com.pakonat.motor2d.beans;

import java.io.Serializable;

public class Velocidad implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Float Fuerza;
	
	private Coord coord;

	public Velocidad(Float fuerza, Coord coord) {
		super();
		Fuerza = fuerza;
		this.coord = coord;
	}

	public Float getFuerza() {
		return Fuerza;
	}

	public void setFuerza(Float fuerza) {
		Fuerza = fuerza;
	}

	public Coord getCoord() {
		return coord;
	}

	public void setCoord(Coord coord) {
		this.coord = coord;
	}

}
