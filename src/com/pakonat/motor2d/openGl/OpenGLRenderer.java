package com.pakonat.motor2d.openGl;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import com.pakonat.motor2d.openGl.objects.CuadradoConAceleracion;
import com.pakonat.motor2d.openGl.objects.ObjetoOpenGl;
import com.pakonat.motor2d.openGl.objects.Triangulo;

import android.opengl.GLU;
import android.opengl.GLSurfaceView.Renderer;

public class OpenGLRenderer implements Renderer {
	
	
	private ObjetoOpenGl[] listaObjetos;
	

	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
		// Set the background color to black ( rgba ).
		gl.glClearColor(0.0f,0.0f, 0.0f, 0.5f);  
		// Enable Smooth Shading, default not really needed.
		gl.glShadeModel(GL10.GL_SMOOTH);
		// Depth buffer setup.
		gl.glClearDepthf(1.0f);
		// Enables depth testing.
		gl.glEnable(GL10.GL_DEPTH_TEST);
		// The type of depth testing to do.
		gl.glDepthFunc(GL10.GL_LEQUAL);
		// Really nice perspective calculations.
		gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, 
                          GL10.GL_NICEST);
		//Nos alejamos un poco del punto de vista
		
		
		listaObjetos=new ObjetoOpenGl[1];
		listaObjetos[0]=new CuadradoConAceleracion(1f,-1f,2,2);
				
	}
	
	
	@Override
	public void onDrawFrame(GL10 gl) {
		
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT | 
                           GL10.GL_DEPTH_BUFFER_BIT);
		gl.glLoadIdentity();
		gl.glTranslatef(0, 0, -100);
		
		//Aqu ya pongo en pantalla todo lo que tengo que dibujar
		for(ObjetoOpenGl objeto:listaObjetos)
			objeto.dibujar(gl);
	}

	
	// Called when the surface changed size.
	@Override
	public void onSurfaceChanged(GL10 gl,  int width, int height) {
		// Sets the current view port to the new size.
		gl.glViewport(0, 0, width, height);
		// Select the projection matrix
		gl.glMatrixMode(GL10.GL_PROJECTION);
		// Reset the projection matrix
		gl.glLoadIdentity();
		// Calculate the aspect ratio of the window
		GLU.gluPerspective(gl, 45.0f,
                                   (float) width / (float) height,
                                   0.1f, 100.0f);
		// Select the modelview matrix
		gl.glMatrixMode(GL10.GL_MODELVIEW);
		// Reset the modelview matrix
		gl.glLoadIdentity();
	}
	
}
