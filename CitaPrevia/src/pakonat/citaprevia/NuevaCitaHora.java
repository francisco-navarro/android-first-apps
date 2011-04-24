package pakonat.citaprevia;

import pakonat.citaprevia.html.beans.HoraCita;
import pakonat.citaprevia.utils.ActividadMenu;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

public class NuevaCitaHora extends ActividadMenu {
	
	private static LinearLayout capaLoading;
	private static HoraCita hora;
	
	static Spinner comboHoras;
	static ArrayAdapter<String> aa;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); 
        setContentView(R.layout.nueva_cita_hora);
        
        inicializaObjetos();
        
        final Handler mHandler = new Handler();
        Principal.engine.doSelectHora(mHandler,NuevaCita.getDia());
        
    }
    
	public static void setHora(HoraCita hora) {
		NuevaCitaHora.hora = hora;
	}

	private void inicializaObjetos(){
		capaLoading=(LinearLayout) findViewById(R.id.layoutCargando);
		comboHoras=(Spinner)findViewById(R.id.comboHoras);
	}
    
    public static final Runnable mUpdateResults = new Runnable() {
        public void run() {
        	
        	capaLoading.setVisibility(View.INVISIBLE);
        	aa=new ArrayAdapter<String>(capaLoading.getContext(), android.R.layout.simple_spinner_item,hora.getHoras());
        	aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            comboHoras.setAdapter(aa);
        }
    };

    public void clickContinuar(View v){
    	
    	
    }
}
