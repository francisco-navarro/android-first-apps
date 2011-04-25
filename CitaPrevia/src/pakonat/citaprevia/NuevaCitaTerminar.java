package pakonat.citaprevia;

import pakonat.citaprevia.utils.ActividadMenu;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

public class NuevaCitaTerminar extends ActividadMenu {
	
	private static Integer idCita;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); 
        setContentView(R.layout.nueva_cita_hora);
        
        inicializaObjetos();
        
        final Handler mHandler = new Handler();
        //Principal.engine.doShowTerminarCita(mHandler,NuevaCita.getDia());
        
    }

	private void inicializaObjetos() {
		
		
	}

	public void clickContinuar(View v){
		
	}
	
	public static Integer getIdCita(){
		return idCita;
	}

}