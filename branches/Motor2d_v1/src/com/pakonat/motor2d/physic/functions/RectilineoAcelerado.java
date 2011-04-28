package com.pakonat.motor2d.physic.functions;

public class RectilineoAcelerado {

	static public Float velocidad (Float v0,Float aceleracion,Float tiempo){
		return v0+(aceleracion*tiempo);
	}
	
	static public Float distancia (Float v0,Float aceleracion,Float tiempo){
		return new Float((v0*tiempo)+(1.2*aceleracion*tiempo*tiempo));
	}

	public static Float distancia(Float v0, Float aceleracion,double d) {
		return distancia(v0, aceleracion, new Float(d));
	}

	public static Float velocidad(Float v0, Float aceleracion, double tiempo) {
		return velocidad(v0, aceleracion, new Float(tiempo));
	}
	
}