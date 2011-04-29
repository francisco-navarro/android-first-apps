package com.pakonat.motor2d.colisions.objects;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;

import com.pakonat.motor2d.activities.MainActivity;
import com.pakonat.motor2d.beans.Coord;
import com.pakonat.motor2d.colisions.objects.interfaces.Colisionable;
import com.pakonat.motor2d.physic.PhysicObjectDrawable;

public class Suelo extends PhysicObjectDrawable {

	public Suelo() {
		
		this.eje=new Coord(0, MainActivity.resY-2);

		mDrawable = new ShapeDrawable(new RectShape());		
		mDrawable.getPaint().setColor(0xff74AC23);
		
		
		
		mDrawable.setBounds(eje.getX(), eje.getY(), eje.getX() + MainActivity.resX,eje.getY() + 20);
        
	}

	@Override
	public boolean colisiona(Coord c) {
		
		if(c.getY()>=eje.getY())
				return true; //el suelo nunca colisiona?
		return false;
	}


	
	 public void draw(Canvas canvas) {	    	
	    	
	    	mDrawable.draw(canvas);
	 }

	@Override
	public void calculaFisica() {
		//No hace nada la fisica, solo es suelo
	}
	

}
