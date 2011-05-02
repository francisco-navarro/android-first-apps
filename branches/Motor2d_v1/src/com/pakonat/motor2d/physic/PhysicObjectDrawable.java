package com.pakonat.motor2d.physic;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ShapeDrawable;
import android.view.View;

import com.pakonat.motor2d.beans.Coord;
import com.pakonat.motor2d.colisions.objects.interfaces.Colisionable;

public abstract class PhysicObjectDrawable implements Colisionable{
	
	protected static Float gravedad = new Float(9.8);
	protected static Float t=new Float(0.05);//Es el paso de tiempo en segundos, cuando mas alto mas a trompicones es la simulacion
	
	
	protected ShapeDrawable mDrawable;
	protected Coord eje;	
	protected Float velocidadGravedad;//luego esta mierda se quita por una matriz de momentos
	
	
	public PhysicObjectDrawable() {		
		velocidadGravedad=new Float(0.0);
	}
	
	 public void onDraw(Canvas canvas) {
		 calculaFisica();
	 }
	
	public abstract void calculaFisica();
	
	public abstract void draw(Canvas canvas);

	
	public abstract boolean colisiona(Coord[] c);

	public abstract Coord[] getColisionablePoints();
	
	public Coord getEje() {		
		return eje;
	}
	
}
