package com.pakonat.motor2d.activities;

import com.pakonat.motor2d.R;
import com.pakonat.motor2d.R.layout;
import com.pakonat.motor2d.beans.Coord;
import com.pakonat.motor2d.colisions.objects.ObjetoPlasticoConGravedad;
import com.pakonat.motor2d.colisions.objects.Suelo;
import com.pakonat.motor2d.colisions.views.CustomDrawableView;
import com.pakonat.motor2d.physic.PhysicObjectDrawable;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Gallery.LayoutParams;

public class MainActivity extends Activity {

	LinearLayout mLinearLayout;

	public static int resX;
	public static int resY;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {    	
    	
        super.onCreate(savedInstanceState);
        requestWindowFeature(android.view.Window.FEATURE_NO_TITLE);
        guardaCoordenadas();
        
        mLinearLayout = new LinearLayout(this);
        mLinearLayout.setBackgroundColor(R.color.blanco);
        
   
       
        
        mLinearLayout.addView(new CustomDrawableView(this));
        
        setContentView(mLinearLayout);

    }

	private void guardaCoordenadas() {
		
		WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
	
		Display d = wm.getDefaultDisplay();

		resX=d.getHeight();
		resY=d.getWidth();


	}
}