package com.pakonat.motor2d.beans;

import java.io.Serializable;

import com.pakonat.motor2d.physic.functions.RectilineoAcelerado;

public class Aceleracion implements Serializable{
	
	private Coord vector;
	private float aceleracion,velocidad0;
	
	public Aceleracion(Coord vector, float aceleracion, float velocidad0) {
		
		this.vector = vector;
		this.aceleracion = aceleracion;
		this.velocidad0 = velocidad0;
	}
	
	public Aceleracion(Coord vector, double aceleracion, double velocidad0) {
		this(vector,(float)aceleracion,(float)velocidad0);
	}
	
	public Aceleracion(Coord vector, int aceleracion, int velocidad0){
		this(vector, Float.parseFloat(""+aceleracion),  Float.parseFloat(""+velocidad0));
	}

	public Coord getVector() {
		return vector;
	}

	public void setVector(Coord vector) {
		this.vector = vector;
	}

	public float getAceleracion() {
		return aceleracion;
	}

	public void setAceleracion(float aceleracion) {
		this.aceleracion = aceleracion;
	}

	public float getVelocidad0() {
		return velocidad0;
	}

	public void setVelocidad0(float velocidad0) {
		this.velocidad0 = velocidad0;
	}
	
	public Coord calculaR(Float t){
		Coord result=new Coord(0, 0);
		float r=RectilineoAcelerado.distancia(velocidad0, aceleracion, t);
		result.y=(vector.y*r);
		result.x=(vector.x*r);
		if(aceleracion!=0)
			velocidad0=RectilineoAcelerado.velocidad(velocidad0, aceleracion, t);
		
		return result;
	}

}
