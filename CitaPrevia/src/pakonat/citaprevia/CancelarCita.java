package pakonat.citaprevia;

import java.util.HashMap;

import pakonat.citaprevia.html.beans.InfoCita;
import pakonat.citaprevia.main.threads.CancelarCitaThread;
import pakonat.citaprevia.main.threads.ListarCitasThread;
import pakonat.citaprevia.utils.ActividadMenu;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class CancelarCita extends ActividadMenu {
	
	static ProgressBar loading;
	static LinearLayout capaLoading;
	static LinearLayout capaInfo;
	static LinearLayout capaNoCitas;
	static Context context;
	static InfoCita[] listaCitas;
	static RadioGroup rg;
	static HashMap<String, InfoCita> mapaCitas;
	
    public static InfoCita[] getListaCitas() {
		return listaCitas;
	}

	public static void setListaCitas(InfoCita[] listaCitas) {
		CancelarCita.listaCitas = listaCitas;
	}

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cancelar_cita);
        inicializaObjetos();
        
        final Handler mHandler = new Handler();
        new ListarCitasThread(mHandler).start();
    }
    
	private void inicializaObjetos() {
		
		context=this.getApplicationContext();

    	loading=(ProgressBar) findViewById(R.id.cargandoNuevaCita);
    	capaLoading=(LinearLayout) findViewById(R.id.linearLayout2);
		capaInfo=(LinearLayout) findViewById(R.id.capaInfo);
		capaNoCitas=(LinearLayout) findViewById(R.id.capaNoCitas);
		
	}
    
    public static final Runnable mUpdateResults = new Runnable() {
        public void run() {
        	loading.setVisibility(View.INVISIBLE);        	
        	//Pinto los resultados        	
        	capaInfo.addView(getRadioGroup(listaCitas));
        }
    };
    
    private static RadioGroup getRadioGroup(InfoCita[] listaCitas2){
    	rg=new RadioGroup(context);
    	mapaCitas=new HashMap<String, InfoCita>();
    	
    	RadioButton[] rb = new RadioButton[listaCitas2.length];
        for(int i=0; i<listaCitas2.length; i++){
            rb[i]  = new RadioButton(context);
            
            rb[i].setText(listaCitas2[i].getDia()+" "+listaCitas2[i].getHora());
            
            rg.addView(rb[i]); 
            mapaCitas.put( ""+rb[i].getId(), listaCitas2[i]);
         }
        if(listaCitas2.length==0)
        	capaNoCitas.setVisibility(View.VISIBLE);
        return rg;

    }
    
    public boolean onClickTerminar(View v){
    	
    	if(listaCitas.length==0)
    		return true;
    	
    	//Sacamos primero el i de la cita
    	int i=mapaCitas.get(""+rg.getCheckedRadioButtonId()).getId();
    	
    	while(rg.getChildCount()>0){
    		RadioButton rb = (RadioButton)rg.getChildAt(0);
    		rg.removeView(rb);
    	}
    	
    	loading.setVisibility(View.VISIBLE);     
    	capaNoCitas.setVisibility(View.INVISIBLE);
    	
    	final Handler mHandler = new Handler();
    	new CancelarCitaThread(mHandler,i).start();
    	
    	return false;
    }

}
