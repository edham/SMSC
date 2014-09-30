 package com.smsc.seguridad.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.smsc.seguridad.entidades.clsIncidente;
import com.smsc.seguridad.ui.R;
import com.smsc.seguridad.utilidades.Funciones;


public class IncidenteDatosFragment extends Fragment {

    private clsIncidente Incidente;

    public IncidenteDatosFragment(clsIncidente Incidente) {
        this.Incidente = Incidente;
    }
    
     @Override
    public void onStart() 
    {
        super.onStart();
        TextView lblTitulo=(TextView)getView().findViewById(R.id.lblTitulo);
        lblTitulo.setText(Incidente.getStr_tipo_incidente_nombre());
        
        TextView lblAsunto=(TextView)getView().findViewById(R.id.lblAsunto);
        lblAsunto.setText(Incidente.getStr_detalle());
        
        TextView lblHora=(TextView)getView().findViewById(R.id.lblHora);
        lblHora.setText(Funciones.getHora(Incidente.getDat_fecha_registro()));
        
        TextView lblFecha=(TextView)getView().findViewById(R.id.lblFecha);
        lblFecha.setText(Funciones.getFecha(Incidente.getDat_fecha_registro()));
        
        TextView lblNombres=(TextView)getView().findViewById(R.id.lblNombres);
        lblNombres.setText(Incidente.getStr_usuario_nombre()+" "+Incidente.getStr_usuario_apellido());
        
        TextView lblDNI=(TextView)getView().findViewById(R.id.lblDNI);
        lblDNI.setText(Incidente.getStr_usuario_dni());
        
        TextView lblTelefono=(TextView)getView().findViewById(R.id.lblTelefono);
        lblTelefono.setText(Incidente.getStr_usuario_celular());
        
       
        
        TextView lblEdad=(TextView)getView().findViewById(R.id.lblEdad);
        lblEdad.setText(""+Funciones.getEdad(Incidente.getDat_usuario_fecha_nacimiento()));
        
        View ViewFoto = (View)getView().findViewById(R.id.ViewFoto);
        if(Incidente.getByte_foto()==null)
        {
             ViewFoto.setVisibility(View.GONE);
        }
        else
        {
            ImageView image = (ImageView)getView().findViewById(R.id.image);
            image.setImageBitmap(Funciones.getBitmap(Incidente.getByte_foto()));
        }
        
        Button btnAceptar = (Button) getView().findViewById(R.id.btnAceptar);
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            btnAceptar();
            }
        });
        Button btnCancelar = (Button) getView().findViewById(R.id.btnCancelar);
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            btnCancelar();
            }
        });
        
    }
   
	 @Override
	 public View onCreateView(LayoutInflater inflater, ViewGroup container,
	   Bundle savedInstanceState) {
	  View myFragmentView = inflater.inflate(R.layout.fragmento_incidente_datos, container, false);
          
	  return myFragmentView;
	 }
         

   
    public void btnAceptar()
    {
//        Fragment InicioFragment = new InicioFragment();
//        FragmentTransaction transaction = getFragmentManager().beginTransaction();
//        transaction.replace(R.id.myfragment, InicioFragment);
//        transaction.addToBackStack(null);
      AlertDialog.Builder alert = new AlertDialog.Builder(this.getActivity());
             alert.setTitle("Atender Incidente");
                alert.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {  
                            Intent intent=new Intent("Fragment");            
                            intent.putExtra("parametro", 1);
                            FragmentActivity activity = getActivity();
                            activity.sendBroadcast(intent);
                         
                        }});
                alert.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {  
                       public void onClick(DialogInterface dialog, int whichButton) {    
                    }});
                       alert.show();
           
    }

     public void btnCancelar()
    {
            Intent intent=new Intent("Fragment");            
            intent.putExtra("parametro", 0);
            FragmentActivity activity = getActivity();
            activity.sendBroadcast(intent);
    }
       
}
