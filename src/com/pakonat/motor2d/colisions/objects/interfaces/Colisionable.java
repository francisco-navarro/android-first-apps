package com.pakonat.motor2d.colisions.objects.interfaces;


import com.pakonat.motor2d.beans.Coord;

public interface Colisionable {
	
	
	public Coord getEje();
	
	public boolean colisiona(Coord[] c);
	
	public Coord[] getColisionablePoints();

}
