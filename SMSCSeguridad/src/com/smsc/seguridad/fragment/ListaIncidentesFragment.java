 package com.smsc.seguridad.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.smsc.seguridad.dao.clsPersonalDAO;
import com.smsc.seguridad.dao.clsSesionPersonalVehiculoDAO;
import com.smsc.seguridad.entidades.clsIncidente;
import com.smsc.seguridad.entidades.clsSesionPersonalVehiculo;
import com.smsc.seguridad.ui.R;
import com.smsc.seguridad.utilidades.Funciones;
import java.util.List;


public class ListaIncidentesFragment extends Fragment {

  private  List<clsIncidente> itens=null;
  private ListView List;
  private AdaptadorTitulares adaptador;
  
  public ListaIncidentesFragment(List<clsIncidente> lista) {
        this.itens = lista;
  }
     @Override
    public void onStart() 
    {
        super.onStart();
       

        Button btnCancelar = (Button) getView().findViewById(R.id.btnCancelar);
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            btnCancelar();
            }
        });
         List = (ListView)getView().findViewById(R.id.list); 
        Buscar();
    }
   
	 @Override
	 public View onCreateView(LayoutInflater inflater, ViewGroup container,
	   Bundle savedInstanceState) {
	  View myFragmentView = inflater.inflate(R.layout.fragmento_lista_incidentes, container, false);
          
	  return myFragmentView;
	 }
         
       public void Buscar()
  {    
      if(itens!=null && itens.size()!=0)
      {
            adaptador = new AdaptadorTitulares(this.getActivity());
            List.setAdapter(adaptador);
            
      }
       else
      {
            Toast.makeText(this.getActivity(),"No se encontraron Itinerarios", Toast.LENGTH_SHORT).show(); 
      }
  }
   
         

     public void btnCancelar()
    {
            Intent intent=new Intent("Fragment");            
            intent.putExtra("parametro", 0);
            FragmentActivity activity = getActivity();
            activity.sendBroadcast(intent);
    }
     
         class AdaptadorTitulares extends ArrayAdapter {
    	
    	Activity context;
    	
    	AdaptadorTitulares(Activity context) {
    		super(context, R.layout.fragmento_lista_incidentes_lista, itens);
    		this.context = context;
    	}
    	
    	public View getView(int position, View convertView, ViewGroup parent) {
            final int pos=position;
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.fragmento_lista_incidentes_lista, null);
            //
            TextView lblUsuario = (TextView)item.findViewById(R.id.lblUsuario);
            lblUsuario.setText(itens.get(position).getStr_usuario_nombre()+" "+itens.get(position).getStr_usuario_apellido());
            //
            TextView lblAsunto = (TextView)item.findViewById(R.id.lblAsunto);
            lblAsunto.setText(itens.get(position).getStr_detalle());
            
            TextView lblTipo = (TextView)item.findViewById(R.id.lblTipo);
            lblTipo.setText(itens.get(position).getStr_tipo_incidente_nombre());

            TextView lblFecha = (TextView)item.findViewById(R.id.lblFecha);
            lblFecha.setText(""+Funciones.getFecha(itens.get(position).getDat_fecha_registro()));

            TextView lblHora = (TextView)item.findViewById(R.id.lblHora);
            lblHora.setText(""+Funciones.getHora(itens.get(position).getDat_fecha_registro()));
            
            Button btnIncidente = (Button)item.findViewById(R.id.btnIncidente);
            btnIncidente.setBackgroundResource(R.drawable.icono_robo);            
            if(itens.get(position).getInt_id_tipo_incidente()==2)
                btnIncidente.setBackgroundResource(R.drawable.icono_incendio);
            else if(itens.get(position).getInt_id_tipo_incidente()==3)
                 btnIncidente.setBackgroundResource(R.drawable.icono_secuestro);
            else if(itens.get(position).getInt_id_tipo_incidente()==4)
                 btnIncidente.setBackgroundResource(R.drawable.icono_homicidio);
            else if(itens.get(position).getInt_id_tipo_incidente()==5)
                 btnIncidente.setBackgroundResource(R.drawable.icono_accidente);
            else if(itens.get(position).getInt_id_tipo_incidente()==6)
                 btnIncidente.setBackgroundResource(R.drawable.icono_violacion);
            else if(itens.get(position).getInt_id_tipo_incidente()==7)
                 btnIncidente.setBackgroundResource(R.drawable.icono_otros);
           
            
            btnIncidente.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                  getIncidente(pos);
                }
            });


            return(item);
	}
    }
         
   public void getIncidente(int pos)
   {
       Intent intent=new Intent("Fragment");            
        intent.putExtra("parametro",2);
        intent.putExtra("pos", pos);
        FragmentActivity activity = getActivity();
        activity.sendBroadcast(intent);
       
   }
       
}
