package com.pakonat.motor2d.openGl.objects;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

import com.pakonat.motor2d.beans.Aceleracion;
import com.pakonat.motor2d.beans.Coord;


public class CuadradoConAceleracion implements ObjetoOpenGl{

	
	private boolean lock;
	
	private float[] vertices;
	private ByteBuffer vbb;
	
	private float x,y,ancho,alto;
	private Aceleracion aceleracion;
	
	
	private short[] indices={ 0, 1, 2, 0, 2, 3 };
	
	private FloatBuffer vertexBuffer;

	private ShortBuffer indexBuffer;
	private ByteBuffer ibb;
	
	public CuadradoConAceleracion(float x,float y,float ancho,float alto){
		
		lock=false;
		
		this.x=x;
		this.y=y;
		this.ancho=ancho;
		this.alto=alto;
		aceleracion=new Aceleracion(new Coord(0,1), 9.8, 0.0);
	
		
		vertices = new float[]{ //Vease imagen http://blog.jayway.com/wordpress/wp-content/uploads/2009/12/poly1.png
	      		x,  	y, 0.0f,  // 0, Top Left
	       x+alto, 		y, 0.0f,  // 1, Bottom Left
	       x+alto,y+ancho, 0.0f,  // 2, Bottom Right
	       		x,y+ancho, 0.0f,  // 3, Top Right
		};
	
		//Metemos los 4 vertices en un byte buffer para ganar rendimiento		
		vbb = ByteBuffer.allocateDirect(vertices.length * 4);//Un float son 4bytes, asique multiplico por 4 
		vbb.order(ByteOrder.nativeOrder());
		vertexBuffer = vbb.asFloatBuffer();
		vertexBuffer.put(vertices);
		vertexBuffer.position(0);
		
		//Tenemos los indices de los bytes en short. 
		ibb = ByteBuffer.allocateDirect(indices.length * 2);//Un short son 2bytes, asique multiplico por 2
		ibb.order(ByteOrder.nativeOrder());
		indexBuffer = ibb.asShortBuffer();
		indexBuffer.put(indices);
		indexBuffer.position(0);
		
		
	}
	
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
	
	public synchronized boolean isLock(){
		return lock;
	}
	
	public synchronized void lock(){
		lock=true;
	}
	public synchronized void unLock(){
		lock=false;
	}

	public void dibujar(GL10 gl){
		
		while(isLock());
		
		//---OPCIONES 		
		gl.glFrontFace(GL10.GL_CCW);//Define la cara visible de los triangulos		
		gl.glEnable(GL10.GL_CULL_FACE); //Dice que los triangulos al otro lado no se vean		
		gl.glCullFace(GL10.GL_BACK);//
		//--FIN OPCIONES
		
		
		//Inicio renderizacion de vertices
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		//Especifico localización y el formato de el array de vertices
		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, 
                vertexBuffer);
                
		//Dibujo
		gl.glDrawElements(GL10.GL_TRIANGLES, indices.length,
				  GL10.GL_UNSIGNED_SHORT, indexBuffer);

		// Desactivo la renderizacion de vertices
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY); 

		// Disable face culling.
		gl.glDisable(GL10.GL_CULL_FACE); 
		
				
	}
	
	public void calculaVertices(){
		
		vertices[0]=x;  	vertices[1]=y;  // 0, Top Left
		vertices[3]=x+alto;	vertices[4]=y;  // 1, Bottom Left
		vertices[6]=x+alto;	vertices[7]=y+ancho;  // 2, Bottom Right
		vertices[9]=x;		vertices[10]=y+ancho;  // 3, Top Right		

		vertexBuffer.put(vertices);
		vertexBuffer.position(0);		
		
		//indexBuffer.put(indices);
		//indexBuffer.position(0);

	}
	
}
