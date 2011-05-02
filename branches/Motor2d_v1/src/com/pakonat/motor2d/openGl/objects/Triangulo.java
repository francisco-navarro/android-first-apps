package com.pakonat.motor2d.openGl.objects;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

public class Triangulo implements ObjetoOpenGl{

	
	private float vertices[] = {
		      -1.0f,  1.0f, 0.0f,  // 0, Top Left
		      -1.0f, -1.0f, 0.0f,  // 1, Bottom Left
		       1.0f, -1.0f, 0.0f,  // 2, Bottom Right
		       1.0f,  1.0f, 0.0f,  // 3, Top Right
		};
	private ByteBuffer vbb;
	
	
	
	private short[] indices={ 0, 1, 2, 0, 2, 3 };
	
	private FloatBuffer vertexBuffer;

	private ShortBuffer indexBuffer;
	private ByteBuffer ibb;
	
	public Triangulo(){

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
	
	public void dibujar(GL10 gl){
		
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
	
}
