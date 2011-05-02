package com.pakonat.motor2d.colisions.views;

import java.util.ArrayList;

import com.pakonat.motor2d.beans.Coord;
import com.pakonat.motor2d.colisions.objects.ObjetoMovimientoParabolico;
import com.pakonat.motor2d.colisions.objects.ObjetoPlasticoConAceleracion;
import com.pakonat.motor2d.colisions.objects.ObjetoPlasticoConGravedad;
import com.pakonat.motor2d.colisions.objects.Suelo;
import com.pakonat.motor2d.physic.PhysicObjectDrawable;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.View;

public class CustomDrawableView extends View {
   
	private boolean autoinvalidate=true;
	private ArrayList<PhysicObjectDrawable> listaObjetos;

    public CustomDrawableView(Context context) {
        super(context);
        
        
        //En esta vista drawable tenemos un conjunto de formas del tipo PhysicObjectDrawable
        listaObjetos=new ArrayList<PhysicObjectDrawable>();
        
        listaObjetos.add(
        		new Suelo()
        		);
        listaObjetos.add(
        		new ObjetoMovimientoParabolico(new Coord(0,100),(float)65.0,45)
        		);
    }

    protected void onDraw(Canvas canvas) {
    	
    	for(PhysicObjectDrawable objeto:listaObjetos)
    		for(PhysicObjectDrawable objetoEnColision:listaObjetos) 
    			//Como de momento esta solo dos objetos, no tiene importancia de orden ni de nada
    			if(!objetoEnColision.equals(objeto) && 
    					objetoEnColision.colisiona(objeto.getColisionablePoints()))
    				autoinvalidate=false;
    	
    	for(PhysicObjectDrawable objeto:listaObjetos)
    		objeto.draw(canvas);
        
        if(autoinvalidate)
        	invalidate();
        
    }

    
}