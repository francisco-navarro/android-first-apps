package com.pakonat.motor2d.colisions.objects;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;

import com.pakonat.motor2d.beans.Coord;
import com.pakonat.motor2d.physic.PhysicObjectDrawable;

public class Suelo extends PhysicObjectDrawable implements Colisionable{

	public Suelo(Context context,Coord eje) {
		super(context);
		
		this.eje=eje;

		mDrawable = new ShapeDrawable(new RectShape());		
		mDrawable.getPaint().setColor(0xff74AC23);
		
		
		
		mDrawable.setBounds(eje.getX(), eje.getY(), eje.getX() + 100,eje.getY() + 1);
        
	}

	@Override
	public boolean colisiona(Coord c) {
		//Nunca colisinoa porque no se mueve
		return false;
	}

	@Override
	public Coord getEje() {
		
		return eje;
	}
	
	
	 public void onDraw(Canvas canvas) {
	    	
	    	super.onDraw(canvas);
	    	mDrawable.draw(canvas);
	 }
	

}
