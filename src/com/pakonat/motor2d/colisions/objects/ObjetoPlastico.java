package com.pakonat.motor2d.colisions.objects;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;

import com.pakonat.motor2d.beans.Coord;
import com.pakonat.motor2d.physic.PhysicObjectDrawable;

/**
 * @author Pakonat
 *
 */
public class ObjetoPlastico extends PhysicObjectDrawable implements Colisionable{
	
	
	/**
	 * Usamos esta variable para saber si invalidamos el objeto siempre que lo dibujamos
	 */
	private boolean autoInvalidate=false;
	
	private int width ;
	private int height ;
	
	
	
	public ObjetoPlastico(Context context) {
		super(context);	
		//Creamos las coordenadas del eje
		eje=new Coord(10, 10);
		//Ponemos el tamaño, de momento por defecto
		width = 30;
		height = 50;
		
		//creamos la forma 
		mDrawable = new ShapeDrawable(new RectShape());
		mDrawable.setBounds(eje.getX(), eje.getY(), eje.getX() + width,eje.getY() + height);
		mDrawable.getPaint().setColor(0xff74AC23);
	}
	
    protected void onDraw(Canvas canvas) {
    	
    	//Primero calculo fisica y despues dibujo
    	
        mDrawable.draw(canvas);
        
        if(autoInvalidate)
        	invalidate();        
    }

	
	
	@Override
	public boolean colisiona(Coord c) {
		if(c.getX()>=eje.getX() && c.getX()<=width)
			if(c.getY()>=eje.getY() && c.getY()<height)
				return true;
			
		return false;
	}

	@Override
	public Coord getEje() {
		
		return eje;
	}
	
	
	
	
	

}
