package com.pakonat.motor2d.activities;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;

public class MainActivityOpenGl extends Activity implements GLSurfaceView.Renderer {
	
	GLSurfaceView mGLSurfaceView;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		mGLSurfaceView = new GLSurfaceView(this);
		mGLSurfaceView.setRenderer(this);
		setContentView(mGLSurfaceView);
		
	}

	
	
	//Metodos del render
	
	// Called when the surface is created or recreated.
	public void onSurfaceChanged(GL10 arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	
	// Called to draw the current frame.
	public void onDrawFrame(GL10 arg0) {
		// TODO Auto-generated method stub
		
	}

	
	// Called when the surface changed size.
	public void onSurfaceCreated(GL10 arg0, EGLConfig arg1) {
		// TODO Auto-generated method stub
		
	}
	//FIN metodos del render

}
