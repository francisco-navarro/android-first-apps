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

public class ListarCitasThread extends Thread{

	
	private Handler mHandler;
	
	public ListarCitasThread(Handler mHandler){
		super();
		this.mHandler=mHandler;
	}


	@Override
	public void run() {
		
		String[] entrada=null;
		ArrayList<InfoCita> listaCitas = new ArrayList<InfoCita>();
		
		if(Engine.debugMode){
			entrada=H1listar.html.replaceAll("\n", "").replaceAll("<", "\n<").split("\n");
		}else{
			entrada=PakoNetUtils.nuevaConexionHttps(Constants.RUTA_CANCELAR_CITA,Constants.RUTA_NUEVA_CITA).toString().replaceAll("\n", "").replaceAll("<", "\n<").split("\n");
		}
		
		
		HtmlParser parser=new HtmlParser(entrada);
		
		parser.extraerFormulario();
		mHandler.post(CancelarCita.mUpdateResults);
		
	}
	
	 
}
