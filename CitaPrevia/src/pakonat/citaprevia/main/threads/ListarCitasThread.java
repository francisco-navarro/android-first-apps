package pakonat.citaprevia.main.threads;

import java.net.Authenticator;

import android.os.Handler;
import pakonat.citaprevia.CancelarCita;
import pakonat.citaprevia.NuevaCita;
import pakonat.citaprevia.html.beans.FechaCita;
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
		
		if(Engine.debugMode){
			
		}else{
			
		}
		
		mHandler.post(CancelarCita.mUpdateResults);
		
	}
	
	 
}
