package com.pakonat.motor2d.physic;

import android.content.Context;
import android.graphics.drawable.ShapeDrawable;
import android.view.View;

import com.pakonat.motor2d.beans.Coord;

public  class PhysicObjectDrawable extends View{
	//En un mundo en 2d el objeto tiene coordenadas 2d
	
	protected ShapeDrawable mDrawable;
	protected Coord eje;
	
	public PhysicObjectDrawable(Context context) {
		super(context);
	}
	
	
	protected void calculaFisica(){
		
	}
	
}
