package pakonat.citaprevia;

import pakonat.citaprevia.main.threads.ListarCitasThread;
import pakonat.citaprevia.utils.ActividadMenu;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

public class CancelarCita extends ActividadMenu {
	
	static ProgressBar loading;
	static LinearLayout capaLoading;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cancelar_cita);
        inicializaObjetos();
        
        final Handler mHandler = new Handler();
        new ListarCitasThread(mHandler).start();
    }
    
	private void inicializaObjetos() {

    	loading=(ProgressBar) findViewById(R.id.cargandoNuevaCita);
    	capaLoading=(LinearLayout) findViewById(R.id.linearLayout2);
		
	}
    
    public static final Runnable mUpdateResults = new Runnable() {
        public void run() {
        	loading.setVisibility(View.INVISIBLE);        	
        	//Pinto los resultados
        	
        }
    };

}
