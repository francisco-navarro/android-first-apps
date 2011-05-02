package com.pakonat.motor2d.colisions.objects;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RectShape;

import com.pakonat.motor2d.beans.Coord;
import com.pakonat.motor2d.colisions.objects.interfaces.Colisionable;
import com.pakonat.motor2d.physic.PhysicObjectDrawable;
import com.pakonat.motor2d.physic.functions.RectilineoAcelerado;

/**
 * @author Pakonat
 *
 */
public class ObjetoPlasticoConGravedad extends PhysicObjectDrawable{
	
	

	private int width ;
	private int height ;
	
	
	
	public ObjetoPlasticoConGravedad(Coord eje) {		
		
		this.eje=eje;
		//Ponemos el tamaño, de momento por defecto
		width = 20;
		height = 20;
		
		//creamos la forma 
		mDrawable = new ShapeDrawable(new OvalShape());		
		mDrawable.getPaint().setColor(0xff74AC23);
		mDrawable.getPaint().setStyle(Paint.Style.STROKE);
		mDrawable.getPaint().setStrokeWidth(3);

	}
	
	public ObjetoPlasticoConGravedad(int x,int y) {
		this(new Coord(x, y));
	}
	
    public void draw(Canvas canvas) {
    	
    	super.onDraw(canvas);
    	//Primero calculo fisica y despues dibujo, pero esto ya lo hace la super clase
    	
    	mDrawable.setBounds(eje.getX(), eje.getY(), eje.getX() + width,eje.getY() + height);
        mDrawable.draw(canvas);
        
    }

	
	
	@Override
	public boolean colisiona(Coord[] c1) {
		
		for(Coord c : c1)
			if(c.getX()>=eje.getX() && c.getX()<=width)
				if(c.getY()>=eje.getY() && c.getY()<height)
					return true;
			
		return false;
	}

	@Override
	public Coord getEje() {
		
		return eje;
	}
	
	
	//Este metodo es obligatorio si queremos que tenga fisica
	public void calculaFisica(){		
		//recalculamos la velocidad de la gravedad y la posicion del objeto 
		eje.y+=RectilineoAcelerado.distancia(velocidadGravedad, gravedad, t);
		velocidadGravedad=RectilineoAcelerado.velocidad(velocidadGravedad, gravedad, t);
	}

	@Override
	public Coord[] getColisionablePoints() {
		
		return  new Coord[]{
			eje,
			new Coord(eje.getX() + width, eje.getY() + height)
		};
	}
	
	
}
