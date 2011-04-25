package pakonat.citaprevia;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import pakonat.citaprevia.html.beans.InfoCita;
import pakonat.citaprevia.utils.ActividadMenu;

public class NuevaCitaConfirmar extends ActividadMenu {
	
	private static Integer idCita;
	private static InfoCita infoCita;
	
	

	static TextView textoInfo;
	static ProgressBar loading;
	static LinearLayout capaLoading;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); 
        setContentView(R.layout.nueva_cita_hora);
        
        inicializaObjetos();
        
        final Handler mHandler = new Handler();
        Principal.engine.doShowConfirmarCita(mHandler,NuevaCitaHora.getHora());
        
    }

	private void inicializaObjetos() {
		
		textoInfo = (TextView) findViewById(R.id.textViewInfoCita);
    	loading=(ProgressBar) findViewById(R.id.cargandoNuevaCita);
    	capaLoading=(LinearLayout) findViewById(R.id.linearLayout2);
		
	}
	
	 public static final Runnable mUpdateResults = new Runnable() {
	        public void run() {
	        	//Ocultar la barra de progreso
	        	loading.setVisibility(View.INVISIBLE);
	        	capaLoading.setVisibility(View.INVISIBLE);        	
	        	//Mostar los datos
	        	textoInfo.setText(infoCita.getMsg()+" "+infoCita.getDia()+" "+infoCita.getHora());
	        }      	        	
	 };

	public void clickContinuar(View v){
		startActivity(new Intent(this,NuevaCitaTerminar.class));
	}
	
	public static Integer getIdCita(){
		return idCita;
	}
	public static InfoCita getInfoCita() {
		return infoCita;
	}

	public static void setInfoCita(InfoCita infoCita) {
		NuevaCitaConfirmar.infoCita = infoCita;
	}

}
