package pakonat.citaprevia;

import pakonat.citaprevia.html.beans.FechaCita;
import pakonat.citaprevia.utils.ActividadMenu;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

public class NuevaCita extends ActividadMenu {
	
	
	
	static TextView textoInfo;
	static ProgressBar loading;
	static LinearLayout capaLoading;
	
	static Spinner comboDias;
	static ArrayAdapter<String> aa;
	
	static FechaCita msg;	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nueva_cita);
        inicializaObjetos();
        
        //Vamos a realizar esta operacion en segundo plano por si falla
        final Handler mHandler = new Handler();
        Principal.engine.doSelectNuevaCita(mHandler);
        
        
        
    }
    
    private void inicializaObjetos(){
    	textoInfo = (TextView) findViewById(R.id.textViewInfoCita);
    	loading=(ProgressBar) findViewById(R.id.cargandoNuevaCita);
    	capaLoading=(LinearLayout) findViewById(R.id.linearLayout2);
    	comboDias=(Spinner) findViewById(R.id.comboDias);
    	
    	aa = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item);
    }
    

    
    public static final Runnable mUpdateResults = new Runnable() {
        public void run() {
        	        	
        	//Ocultar la barra de progreso
        	loading.setVisibility(View.INVISIBLE);
        	capaLoading.setVisibility(View.INVISIBLE);        	
        	//Mostar los datos
        	textoInfo.setText(msg.getInformacionCita());
        	
        	cargaComboConValores(msg.getLista().toArray(new String[0]));
        	
        }
    };
    
    public static void cargaComboConValores(String[] valores){
    	
    	
    	aa=new ArrayAdapter<String>(aa.getContext(), android.R.layout.simple_spinner_item,valores);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        comboDias.setAdapter(aa);
    }
    
    public synchronized static void setInfoCita(FechaCita s){
    	msg=s;    	
    }
    
    
    public void clickContinuar(View v){
    	
    	startActivity(new Intent(this,NuevaCitaHora.class));
    }
    
    public static String getDia(){
    	
    	return comboDias.getSelectedItem().toString();
    }

}
