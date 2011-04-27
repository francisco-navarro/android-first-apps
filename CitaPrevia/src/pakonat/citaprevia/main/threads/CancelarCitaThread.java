package pakonat.citaprevia.main.threads;

import java.net.Authenticator;
import java.util.ArrayList;

import android.os.Handler;
import pakonat.citaprevia.CancelarCita;
import pakonat.citaprevia.NuevaCita;
import pakonat.citaprevia.html.HtmlParser;
import pakonat.citaprevia.html.beans.FechaCita;
import pakonat.citaprevia.html.beans.InfoCita;
import pakonat.citaprevia.html.debug.H3hora;
import pakonat.citaprevia.html.debug.anular.H1listar;
import pakonat.citaprevia.main.Engine;
import pakonat.citaprevia.utils.Constants;
import pakonat.citaprevia.utils.PakoNetUtils;

public class CancelarCitaThread extends Thread{

	
	private Handler mHandler;
	private int idCita;
	
	public CancelarCitaThread(Handler mHandler,int idCita){
		super();
		this.mHandler=mHandler;
		this.idCita=idCita;
	}


	@Override
	public void run() {
		
		
		
		
		StringBuffer entrada=null;
		if(Engine.debugMode){
			entrada=null;
		}else {
			entrada=PakoNetUtils.nuevaConexionHttps(Constants.RUTA_ELIMINAR_CITA.replaceAll("##ID_CITA##", idCita+""),Constants.RUTA_NUEVA_CITA);
		}
		
		//Ya que la hemos borrado, listamos otra
		new ListarCitasThread(mHandler).start();
		
	}
	
	 
}
