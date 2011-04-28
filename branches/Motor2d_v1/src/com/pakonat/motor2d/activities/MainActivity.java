package com.pakonat.motor2d.activities;

import com.pakonat.motor2d.R;
import com.pakonat.motor2d.R.layout;
import com.pakonat.motor2d.colisions.objects.CustomDrawableView;
import com.pakonat.motor2d.colisions.objects.ObjetoPlastico;
import com.pakonat.motor2d.physic.PhysicObjectDrawable;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Gallery.LayoutParams;

public class MainActivity extends Activity {

	LinearLayout mLinearLayout;

	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(android.view.Window.FEATURE_NO_TITLE);
      
        
        mLinearLayout = new LinearLayout(this);
        mLinearLayout.setBackgroundColor(R.color.blanco);
        
        ImageView i = new ImageView(this);

        /*// Instantiate an ImageView and define its properties
        
        i.setImageResource(R.drawable.bola);
        i.setAdjustViewBounds(true); // set the ImageView bounds to match the Drawable's dimensions
        i.setLayoutParams(new Gallery.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        */
        // Add the ImageView to the layout and set the layout as the content view
        mLinearLayout.addView(i);
        mLinearLayout.addView(new ObjetoPlastico(this));
        
        setContentView(mLinearLayout);

    }
}