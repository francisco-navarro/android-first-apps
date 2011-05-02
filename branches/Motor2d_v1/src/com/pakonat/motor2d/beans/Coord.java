package com.pakonat.motor2d.beans;

import java.io.Serializable;

public class Coord implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Float x,y;
	
	public int getX() {
		return Math.round(x);
	}

	public void setX(float x) {
		this.x = x;
	}

	public int getY() {
		return  Math.round(y);
	}

	public void setY(float y) {
		this.y = y;
	}
	
	public Coord(Float x, Float y) {
		
		this.x = x;
		this.y = y;
	}

	public Coord(int x,int y){
		this.x=new Float(x);
		this.y=new Float(y);
	}

	public String toString(){
		return "("+x.toString()+","+y.toString()+")";
	}

	public Coord suma(Coord c1){
		
		this.x+=c1.x;
		this.y+=c1.y;
		return this;
	}
}
