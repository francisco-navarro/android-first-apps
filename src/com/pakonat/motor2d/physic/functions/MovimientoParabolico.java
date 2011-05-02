package com.pakonat.motor2d.physic.functions;

import com.pakonat.motor2d.beans.Aceleracion;
import com.pakonat.motor2d.beans.Coord;

public class MovimientoParabolico {
	
	float velocidad;
	int angulo;
	

	
	public MovimientoParabolico(float velocidad, int angulo) {
		
		this.velocidad = velocidad;
		this.angulo = angulo;
	}
	
	public MovimientoParabolico(double velocidad, int angulo) {
		this((float)velocidad,angulo);
	}

	public Aceleracion getY(){
		float velocidad;
		velocidad=(float) (this.velocidad*Math.sin(angulo));
		Aceleracion result=new Aceleracion(new Coord(0,-1), -9.8, velocidad);
		return result;
	}
	
	public Aceleracion getX(){
		float velocidad;
		velocidad=(float) (this.velocidad*Math.cos(angulo));
		Aceleracion result=new Aceleracion(new Coord(1,0),0.0, velocidad);
		return result;
	}

}
