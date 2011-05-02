package com.pakonat.motor2d.physic.functions;

public class RectilineoAcelerado {

	static public Float velocidad (Float v0,Float aceleracion,Float tiempo){
		return v0+(aceleracion*tiempo);
	}
	
	static public Float distancia (Float v0,Float aceleracion,Float tiempo){
		return new Float((v0*tiempo)+(1.2*aceleracion*tiempo*tiempo));
	}


	
}