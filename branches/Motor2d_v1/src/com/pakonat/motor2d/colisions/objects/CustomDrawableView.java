package com.pakonat.motor2d.colisions.objects;

import com.pakonat.motor2d.beans.Coord;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.View;

public class CustomDrawableView extends View implements Colisionable {
    private ShapeDrawable mDrawable;
    
    int x ;
    int y ;
    int width = 30;
    int height = 50;

    public CustomDrawableView(Context context) {
        super(context);

        x=50;
        y=10;
        
        
        

        mDrawable = new ShapeDrawable(new OvalShape());
        mDrawable.getPaint().setColor(0xff74AC23);
        
    }

    protected void onDraw(Canvas canvas) {
    	x--;
    	mDrawable.setBounds(x, y, x + width, y + height);
        mDrawable.draw(canvas);
        
        invalidate();
        
    }

	@Override
	public boolean colisiona(Coord c) {
		if(c.getX()>=x && c.getX()<=width)
			if(c.getY()>=y && c.getY()<height)
				return true;
			
		return false;
	}

	@Override
	public Coord getEje() {
		
		return new Coord(x, y);
	}
    
    


    
}