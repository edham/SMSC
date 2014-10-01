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
import com.smsc.seguridad.entidades.clsPersonal;
import com.smsc.seguridad.entidades.clsSesionPersonalVehiculo;
import com.smsc.seguridad.ui.R;
import com.smsc.seguridad.utilidades.Funciones;
import java.util.List;


public class DetalleSesionFragment extends Fragment {

  private  List<clsPersonal> itens=null;
  private ListView List;
     private AdaptadorTitulares adaptador;
     
     @Override
    public void onStart() 
    {
        super.onStart();
        clsSesionPersonalVehiculo entidad = clsSesionPersonalVehiculoDAO.Buscar(this.getActivity());
        
        TextView lblHora=(TextView)getView().findViewById(R.id.lblHora);
        lblHora.setText(Funciones.getHora(entidad.getDat_fecha_entrada()));
       
        TextView lblFecha=(TextView)getView().findViewById(R.id.lblFecha);
        lblFecha.setText(Funciones.getFecha(entidad.getDat_fecha_entrada()));
        
        TextView lblMarca=(TextView)getView().findViewById(R.id.lblMarca);
        lblMarca.setText(entidad.getStr_vehiculoe_marca());
        
        TextView lblModelo=(TextView)getView().findViewById(R.id.lblModelo);
        lblModelo.setText(entidad.getStr_vehiculoe_modelo());
        
        TextView lblPlaca=(TextView)getView().findViewById(R.id.lblPlaca);
        lblPlaca.setText(entidad.getStr_vehiculoe_placa());
        
        TextView lblNumero=(TextView)getView().findViewById(R.id.lblNumero);
        lblNumero.setText(entidad.getStr_vehiculoe_numero());

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
	  View myFragmentView = inflater.inflate(R.layout.fragmento_detalle_sesion, container, false);
          
	  return myFragmentView;
	 }
         
       public void Buscar()
  {    
      itens=clsPersonalDAO.Listar(this.getActivity());
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
    		super(context, R.layout.fragmento_detalle_sesion_lista, itens);
    		this.context = context;
    	}
    	
    	public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.fragmento_detalle_sesion_lista, null);
            //
            TextView lblNombres = (TextView)item.findViewById(R.id.lblNombres);
            lblNombres.setText(itens.get(position).getStr_nombre()+" "+itens.get(position).getStr_apellido_paterno()+" "+itens.get(position).getStr_apellido_materno());
            //
            TextView lblDNI = (TextView)item.findViewById(R.id.lblDNI);
            lblDNI.setText(itens.get(position).getStr_dni());
             
            TextView lblDistrito = (TextView)item.findViewById(R.id.lblDistrito);
            lblDistrito.setText(itens.get(position).getStr_nombre_distrito());

            TextView lblPersonal = (TextView)item.findViewById(R.id.lblPersonal);
            lblPersonal.setText(itens.get(position).getStr_nombre_tipo_personal());

            TextView lblEdad = (TextView)item.findViewById(R.id.lblEdad);
            lblEdad.setText(""+Funciones.getEdad(itens.get(position).getDat_fecha_nacimiento()));

            ImageView image = (ImageView)item.findViewById(R.id.image);
            if(itens.get(position).getByte_foto()!=null)
            image.setImageBitmap(Funciones.getBitmap(itens.get(position).getByte_foto()));

            return(item);
	}
    }
       
}
