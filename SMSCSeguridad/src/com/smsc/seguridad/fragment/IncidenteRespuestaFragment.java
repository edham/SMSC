 package com.smsc.seguridad.fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.smsc.seguridad.conexion.http;
import com.smsc.seguridad.dao.clsIncidentesDAO;
import com.smsc.seguridad.entidades.clsIncidente;
import com.smsc.seguridad.ui.R;
import static com.smsc.seguridad.ui.R.drawable.foto;
import com.smsc.seguridad.utilidades.Funciones;


public class IncidenteRespuestaFragment extends Fragment {

    private clsIncidente Incidente;
    private EditText txtAsunto;
     private  ImageView imageResuesta;
     private Bitmap bp;
    
    
     @Override
    public void onStart() 
    {
        super.onStart();
        Incidente =clsIncidentesDAO.Buscar(this.getActivity());
        txtAsunto = (EditText)getView().findViewById(R.id.txtAsunto);
         imageResuesta = (ImageView)getView().findViewById(R.id.imageRespuesta);
         
        TextView lblTitulo=(TextView)getView().findViewById(R.id.lblTitulo);
        lblTitulo.setText("Respuesta "+Incidente.getStr_tipo_incidente_nombre());
        
        TextView lblAsunto=(TextView)getView().findViewById(R.id.lblAsunto);
        lblAsunto.setText(Incidente.getStr_detalle());
        
        TextView lblHora=(TextView)getView().findViewById(R.id.lblHora);
        lblHora.setText(Funciones.getHora(Incidente.getDat_fecha_registro()));
        
        TextView lblFecha=(TextView)getView().findViewById(R.id.lblFecha);
        lblFecha.setText(Funciones.getFecha(Incidente.getDat_fecha_registro()));
        
      
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
        Button btnTomarFoto = (Button) getView().findViewById(R.id.btnTomarFoto);
        btnTomarFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            btnTomarFoto();
            }
        });
        
    }
   
	 @Override
	 public View onCreateView(LayoutInflater inflater, ViewGroup container,
	   Bundle savedInstanceState) {
	  View myFragmentView = inflater.inflate(R.layout.fragmento_incidente_respuesta, container, false);
          
	  return myFragmentView;
	 }
         

   public void btnTomarFoto()
    {
        Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
      startActivityForResult(intent, 0);
    }
   @Override
   
   public void onActivityResult(int requestCode, int resultCode, Intent data) {
      // TODO Auto-generated method stub
      super.onActivityResult(requestCode, resultCode, data);
      bp = (Bitmap) data.getExtras().get("data");
      imageResuesta.setImageBitmap(bp);
   }
    public void btnAceptar()
    {
         if(!txtAsunto.getText().toString().equals(null) && !txtAsunto.getText().toString().equals(""))
        {           
            AlertDialog.Builder alert = new AlertDialog.Builder(this.getActivity());
            alert.setTitle("Validar Incidente");
            alert.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {  
                
                    ActulizaIncidente(2);

                }});
            alert.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {  
               public void onClick(DialogInterface dialog, int whichButton) {    
            }});
            alert.show();
        }
         else
              Toast.makeText(this.getActivity(),"Por favor ingrese un Asunto", Toast.LENGTH_SHORT).show();
    }

    public void btnCancelar()
    {
          if(!txtAsunto.getText().toString().equals(null) && !txtAsunto.getText().toString().equals(""))
        {
            AlertDialog.Builder alert = new AlertDialog.Builder(this.getActivity());
            alert.setTitle("Rechazar Incidente");
            alert.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {  

                    ActulizaIncidente(3);

                }});
            alert.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {  
               public void onClick(DialogInterface dialog, int whichButton) {    
            }});
            alert.show();
        }
         else
              Toast.makeText(this.getActivity(),"Por favor ingrese un Asunto", Toast.LENGTH_SHORT).show();
            
    } 
    
    public void ActulizaIncidente(int estado)
    {
        
        String id=http.actualizarRespuestaIncidente(Incidente.getInt_id_respuesta_incidente(), Incidente.getInt_id_incidente(), txtAsunto.getText().toString(),estado,Funciones.getByte(bp));
        if(!id.trim().equals("0"))
         {
            Intent intent=new Intent("Fragment");            
            intent.putExtra("parametro", 0);
            FragmentActivity activity = getActivity();
            activity.sendBroadcast(intent);
         }
        
        
    }
}
