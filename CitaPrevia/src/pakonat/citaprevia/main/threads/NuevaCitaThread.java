package pakonat.citaprevia.main.threads;

import java.net.Authenticator;

import android.os.Handler;
import pakonat.citaprevia.NuevaCita;
import pakonat.citaprevia.html.beans.FechaCita;
import pakonat.citaprevia.main.Engine;
import pakonat.citaprevia.utils.Constants;
import pakonat.citaprevia.utils.PakoNetUtils;

public class NuevaCitaThread extends Thread{

	private Authenticator au;
	private Handler mHandler;
	
	public NuevaCitaThread(Handler mHandler){
		super();
		this.mHandler=mHandler;
	}


	@Override
	public void run() {
		
		String[] entrada=null;
		FechaCita fechaCita=new FechaCita();
		
		if(Engine.debugMode){
			fechaCita.setInformacionCita("<p>Informacion del centro");
			fechaCita.add("24/3/2011");
			fechaCita.add("22/3/2011");
			NuevaCita.setInfoCita(fechaCita);	
			mHandler.post(NuevaCita.mUpdateResults);
			return;
		}
		
		PakoNetUtils.getAuthenticator(au);
		entrada=PakoNetUtils.nuevaConexionHttps(Constants.RUTA_NUEVA_CITA,"https://sescam.jccm.es/web1/CitaPreviaInitial.do").toString().split("\n");
		for(int i=0;i<entrada.length;i++){
			String lin=entrada[i];
			if(lin!=null && !lin.equals(""))
			if(lin.startsWith(Constants.HTML_OPTION)){ //Leemos un bloque <option> que será el combo de las fechas
				fechaCita.add(lin);
			}else if(lin.startsWith(Constants.HTML_LEGEND)){ //Comienza bloque <legend>Información de la cita</legend>
				for(int j=i;j<entrada.length;j++){
					if(entrada[j].startsWith(Constants.HTML_SPAN)){ //Estamos en una linea <span> con informacion
						fechaCita.setInformacionCita(entrada[j]);
					}else if(entrada[j].startsWith(Constants.HTML_BR)){
						fechaCita.setInformacionCita(entrada[j]);
					}else if(entrada[j].startsWith(Constants.HTML_FIELDSET_CLOSE)){ //salimos del bucle porque se cierra el fieldset con </fieldset>
						
						break;
					}	
				}				
			}
		}
		
		NuevaCita.setInfoCita(fechaCita);
		mHandler.post(NuevaCita.mUpdateResults);
		
	}
	
	 
}
