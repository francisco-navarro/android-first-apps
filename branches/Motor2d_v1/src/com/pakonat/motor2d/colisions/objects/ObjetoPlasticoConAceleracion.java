package com.pakonat.motor2d.colisions.objects;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;

import com.pakonat.motor2d.beans.Aceleracion;
import com.pakonat.motor2d.beans.Coord;
import com.pakonat.motor2d.physic.PhysicObjectDrawable;
import com.pakonat.motor2d.physic.functions.MovimientoParabolico;

public class ObjetoPlasticoConAceleracion extends PhysicObjectDrawable{
	
	private int width ;
	private int height ;
	
	private Aceleracion[] aceleraciones;
	
	public ObjetoPlasticoConAceleracion(Coord c){
		
		this.eje=c;
		//Ponemos el tamaño, de momento por defecto
		width = 20;
		height = 20;
		
		//creamos la forma 
		mDrawable = new ShapeDrawable(new OvalShape());		
		mDrawable.getPaint().setColor(0xff74AC23);
		mDrawable.getPaint().setStyle(Paint.Style.STROKE);
		mDrawable.getPaint().setStrokeWidth(4);
		
		MovimientoParabolico movimientoParabolico=new MovimientoParabolico(65.0, 45);
		//Le inserto las aceleraciones
		aceleraciones=new Aceleracion[3];
		aceleraciones[0]=new Aceleracion(new Coord(0,1), 9.8, 0.0);
		aceleraciones[1]=movimientoParabolico.getX();
		aceleraciones[2]=movimientoParabolico.getY();
	}
	
	public ObjetoPlasticoConAceleracion(int x,int y){
		this(new Coord(x, y));
	}

	@Override
	public void calculaFisica() {
		
		
		for(int i=0;i<aceleraciones.length;i++){
			Coord r=aceleraciones[i].calculaR(t);
			eje.suma(r);
		}
		
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
	public void draw(Canvas canvas) {
		super.onDraw(canvas);
		mDrawable.setBounds(eje.getX(), eje.getY(), eje.getX() + width,eje.getY() + height);
        mDrawable.draw(canvas);
	}

	@Override
	public Coord[] getColisionablePoints() {
		return  new Coord[]{
				eje,
				new Coord(eje.getX() + width, eje.getY() + height)
			};
	}

}
