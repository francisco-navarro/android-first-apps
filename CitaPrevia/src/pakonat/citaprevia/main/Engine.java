package pakonat.citaprevia.main;

import java.net.*;

import android.content.Context;
import android.os.Handler;

import pakonat.citaprevia.main.threads.NuevaCitaHoraConfirmarThread;
import pakonat.citaprevia.main.threads.NuevaCitaHoraThread;

import pakonat.citaprevia.main.threads.NuevaCitaThread;
import pakonat.citaprevia.utils.Constants;
import pakonat.citaprevia.utils.PakoNetUtils;

public class Engine implements java.io.Serializable{

	private static final long serialVersionUID = 1L;

	public static boolean debugMode=true;
	

	
	private Authenticator au;
	 
	
	public Engine(){		
		
	}
	
	public String doLogin(String CIP,Context contexto){
		
		//Primero de todo guardamos el numero en la SD para que se recuerde
		Almacenamiento almacenamiento=new Almacenamiento(contexto);
		almacenamiento.guardar(CIP);
		
		if(debugMode)
			return "";
		//String CIP="nvln850626911019";
		PakoNetUtils.getAuthenticator(au);
		StringBuffer entrada=PakoNetUtils.nuevaConexionHttps(Constants.RUTA_LOGIN.replaceAll("##CIP##", CIP),null);
		for(String lin: entrada.toString().split("\n"))
			if(lin.startsWith(Constants.HTML_P+"Bienvenido"))
				return lin.replaceAll(Constants.HTML_P, "");
		
		return null;
	}
	
	
	public void  doSelectNuevaCita(Handler mHandler){ //Este se corresponde a coger la opcion despues de login		
		new NuevaCitaThread(mHandler).start();		
	}
	
	public void doSelectHora(Handler mHandler,String dia){
		new NuevaCitaHoraThread(mHandler,dia).start();
	}

	public String doSelectCancelarCita(){ //Este se corresponde a coger la opcion despues de login

		StringBuffer result=null;


		result=PakoNetUtils.nuevaConexionHttps(Constants.RUTA_CANCELAR_CITA,null);


		return result.toString();
	}

	public void doShowConfirmarCita(Handler mHandler, String hora) {
		
		new NuevaCitaHoraConfirmarThread(mHandler, hora).start();
	}


	
	

}
