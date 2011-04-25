package pakonat.citaprevia.main.threads;

import pakonat.citaprevia.NuevaCita;
import pakonat.citaprevia.NuevaCitaHora;
import pakonat.citaprevia.html.HtmlParser;
import pakonat.citaprevia.html.beans.FechaCita;
import pakonat.citaprevia.html.beans.HoraCita;
import pakonat.citaprevia.html.beans.InfoCita;
import pakonat.citaprevia.html.debug.H3hora;
import pakonat.citaprevia.html.debug.H4resumen;
import pakonat.citaprevia.main.Engine;
import pakonat.citaprevia.utils.Constants;
import pakonat.citaprevia.utils.PakoNetUtils;
import android.os.Handler;
import android.text.Html;
import android.widget.LinearLayout;

public class NuevaCitaHoraConfirmarThread extends Thread{


	private Handler mHandler;
	private String hora;
	
	private static final String TEXTO_CONFIRMAR="Le acabamos de dar cita";
	
	public NuevaCitaHoraConfirmarThread(Handler mHandler,String hora){
		super();		
		this.mHandler=mHandler;
		this.hora=java.net.URLEncoder.encode(hora);
			
			
	}
	



	@Override
	public void run() {
		
		String[] entrada=null;
		InfoCita infoCita=new InfoCita();
		
		if(Engine.debugMode){
			
			entrada=H4resumen.html.replaceAll("<", "\n<").split("\n");
			
		}else{	
			//enviamos la hora y nos devuelve la confirmacion de la cita, nos queda confirmar para terminar
			entrada=PakoNetUtils.nuevaConexionHttps(Constants.RUTA_NUEVA_CITA_HORA.replaceAll("##HORA##", hora) ,Constants.RUTA_NUEVA_CITA).toString().replaceAll("<", "\n<").split("\n");
			
		}
		
		HtmlParser html= new HtmlParser(entrada);
		
		for(int i=0;i<entrada.length;i++) {
			if(entrada[i].startsWith("<p")){
				if(entrada[i].contains(TEXTO_CONFIRMAR)){
					infoCita.setMsg(html.textoLinea(i));
				}
			}
		}
			
		mHandler.post(NuevaCitaHora.mUpdateResults);
	}
	
}
