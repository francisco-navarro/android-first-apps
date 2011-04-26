package pakonat.citaprevia;

import pakonat.citaprevia.html.beans.InfoCita;
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
	static Context context;
	static InfoCita[] listaCitas;
	
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
		
	}
    
    public static final Runnable mUpdateResults = new Runnable() {
        public void run() {
        	loading.setVisibility(View.INVISIBLE);        	
        	//Pinto los resultados        	
        	capaInfo.addView(getRadioGroup(listaCitas));
        }
    };
    
    private static RadioGroup getRadioGroup(InfoCita[] listaCitas2){
    	RadioGroup rg=new RadioGroup(context);
    	
    	RadioButton[] rb = new RadioButton[10];
        for(int i=0; i<listaCitas2.length; i++){
            rb[i]  = new RadioButton(context);
            rg.addView(rb[i]); 
            rb[i].setText(listaCitas2[i].getDia()+" "+listaCitas2[i].getHora());
         }
        
        return rg;

    }

}
