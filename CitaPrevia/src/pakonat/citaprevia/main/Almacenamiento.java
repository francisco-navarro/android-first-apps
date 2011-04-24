package pakonat.citaprevia.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import pakonat.citaprevia.utils.Constants;
import android.content.Context;
import android.os.Environment;

public class Almacenamiento {
	
	boolean permisoEscritura ;
	boolean permisoLectura ;
	Context contexto;
	
	public Almacenamiento(Context contexto){
		
		this.contexto= contexto;
		
		boolean mExternalStorageAvailable = false;
		boolean mExternalStorageWriteable = false;

		
		String state = Environment.getExternalStorageState();

		if (Environment.MEDIA_MOUNTED.equals(state)) {		    
			//Tenemos lectura y escritura
		    mExternalStorageAvailable = mExternalStorageWriteable = true; 
		    
		} else if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
		    // Solo lectura
		    mExternalStorageAvailable = true;
		    mExternalStorageWriteable = false;
		} else {
		    // No tenemos acceso		    
		    mExternalStorageAvailable = mExternalStorageWriteable = false;
		}
		permisoEscritura=mExternalStorageWriteable;
		permisoLectura=mExternalStorageAvailable;
	}
	
	public boolean permisoEscritura(){
		return permisoEscritura;
	}
	
	public boolean permisoLectura(){
		return permisoLectura;
	}

	public void guardar(String CIP) {
		
		try{
			File file = new File(
					Environment.getExternalStorageDirectory().getAbsolutePath()+File.separator+ Constants.APP_RUTA_ALMACENAMIENTO);
			if(!file.exists())
				file.createNewFile();
			
			FileWriter fw = new FileWriter(file);
			fw.write(CIP);
			fw.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	public String leer() {
		if(permisoLectura){
			try{
				File file = new File(
						Environment.getExternalStorageDirectory().getAbsolutePath()+File.separator+ Constants.APP_RUTA_ALMACENAMIENTO);
				if(!file.exists())
					return "";

				BufferedReader br=new BufferedReader(new FileReader(file));
				String salida= br.readLine();
				br.close();
				
				return salida;
			}catch (Exception e) {
				e.printStackTrace();
			}
		}	
		return "";
	}
	

}
