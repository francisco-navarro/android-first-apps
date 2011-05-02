package com.pakonat.motor2d.colisions.objects;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.PathShape;

import com.pakonat.motor2d.beans.Aceleracion;
import com.pakonat.motor2d.beans.Coord;
import com.pakonat.motor2d.physic.PhysicObjectDrawable;
import com.pakonat.motor2d.physic.functions.MovimientoParabolico;

public class ObjetoMovimientoParabolico extends PhysicObjectDrawable{
	
	private int width ;
	private int height ;
	private float velocidad;
	private int angulo;
	
	private Aceleracion[] aceleraciones;
	
	public ObjetoMovimientoParabolico(Coord c,float velocidad,int angulo){
		
		this.eje=c;
		this.velocidad=velocidad;
		this.angulo=angulo;
		//Ponemos el tamaño, de momento por defecto
		width = 20;
		height = 20;
		
		//creamos la forma 
		mDrawable = new ShapeDrawable(new OvalShape());		
		mDrawable.getPaint().setColor(0xff74AC23);
		mDrawable.getPaint().setStyle(Paint.Style.STROKE);
		mDrawable.getPaint().setStrokeWidth(4);
		
		MovimientoParabolico movimientoParabolico=new MovimientoParabolico(velocidad, angulo);
		//Le inserto las aceleraciones
		aceleraciones=new Aceleracion[3];
		aceleraciones[0]=new Aceleracion(new Coord(0,1), 9.8, 0.0);
		aceleraciones[1]=movimientoParabolico.getX();
		aceleraciones[2]=movimientoParabolico.getY();
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
	
	public void dibujaVector(Canvas canvas){
		Path camino = new Path(); 
		camino.moveTo(eje.x, eje.y);
		camino.lineTo((float)10.0*velocidad, (float)(1.0*200.0));
		
		ShapeDrawable vector=new ShapeDrawable(
				new PathShape(camino,(float)3.0,(float)3.0)
				);	
		vector.getPaint().setColor(Color.WHITE);
		vector.getPaint().setStyle(Paint.Style.STROKE);
		vector.getPaint().setStrokeWidth(6); 
		vector.setBounds(eje.getX(), eje.getY(), eje.getX() + width,eje.getY() + height);
		vector.draw(canvas);
	}

}
