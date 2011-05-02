package com.pakonat.motor2d.activities;



import com.pakonat.motor2d.openGl.OpenGLRenderer;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class MainActivityOpenGl extends Activity  {
	
	GLSurfaceView mGLSurfaceView;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
	            WindowManager.LayoutParams.FLAG_FULLSCREEN); 

		mGLSurfaceView = new GLSurfaceView(this);
		mGLSurfaceView.setRenderer(new OpenGLRenderer());
		setContentView(mGLSurfaceView);
		
	}

	
}
