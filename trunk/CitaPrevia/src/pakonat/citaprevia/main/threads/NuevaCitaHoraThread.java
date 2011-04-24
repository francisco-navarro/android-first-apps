package pakonat.citaprevia.main.threads;

import pakonat.citaprevia.NuevaCita;
import pakonat.citaprevia.NuevaCitaHora;
import pakonat.citaprevia.html.HtmlParser;
import pakonat.citaprevia.html.beans.FechaCita;
import pakonat.citaprevia.html.beans.HoraCita;
import pakonat.citaprevia.html.debug.H3hora;
import pakonat.citaprevia.main.Engine;
import pakonat.citaprevia.utils.Constants;
import pakonat.citaprevia.utils.PakoNetUtils;
import android.os.Handler;
import android.text.Html;
import android.widget.LinearLayout;

public class NuevaCitaHoraThread extends Thread{


	private Handler mHandler;
	private String dia;
	
	public NuevaCitaHoraThread(Handler mHandler,String dia){
		super();		
		this.mHandler=mHandler;
		this.dia=java.net.URLEncoder.encode(dia);
			
			
	}
	



	@Override
	public void run() {
		
		String[] entrada=null;
		HoraCita hora=new HoraCita();
		
		if(Engine.debugMode){
			
			entrada=H3hora.html.replaceAll("<", "\n<").split("\n");
			
		}else{	
			
			entrada=PakoNetUtils.nuevaConexionHttps(Constants.RUTA_NUEVA_CITA_DIA.replaceAll("##DIA##", dia) ,Constants.RUTA_NUEVA_CITA).toString().replaceAll("<", "\n<").split("\n");
			
		}
		
		HtmlParser htmlParser=new HtmlParser(entrada);
		hora.addHoras(htmlParser.getOptions());
		
		NuevaCitaHora.setHora(hora);		
		mHandler.post(NuevaCitaHora.mUpdateResults);
	}
	
}
