/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.smsc.usuario.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.smsc.usuario.conexion.http;
import com.smsc.usuario.dao.clsIncidentesDAO;
import com.smsc.usuario.dao.clsUsuarioDAO;
import com.smsc.usuario.entidades.clsIncidente;
import com.smsc.usuario.utilidades.Funciones;
import java.util.Date;

import java.util.List;

/**
 *
 * @author ROSEMARY
 */
public class RegistrarIncidenteActivity extends Activity {

    /**
     * Called when the activity is first created.
     */
     private EditText txtAsunto;
     private  ImageView image;
     private Bitmap bp;
     private int idTipoIncidente;
     private double latitude;
     private double longitude;
     
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        // ToDo add your GUI initialization code here       
         setContentView(R.layout.registrar_incidente);
          Bundle bundle=getIntent().getExtras();
          idTipoIncidente=Integer.valueOf(bundle.getString("ID"));
          latitude=Double.parseDouble(bundle.getString("latitude"));
          longitude=Double.parseDouble(bundle.getString("longitude"));
         TextView lblTitulo = (TextView)findViewById(R.id.lblTitulo);
         txtAsunto = (EditText)findViewById(R.id.txtAsunto);
         image = (ImageView)findViewById(R.id.image);
         lblTitulo.setText(Funciones.getNombreIncidente(idTipoIncidente));

    }
    
   
    public void btnAceptar(View v)
    {
                if(!txtAsunto.getText().toString().equals("") &&  txtAsunto.getText().toString()!=null )
                {
                    clsIncidente entidad = new clsIncidente();
                    entidad.setStr_detalle(txtAsunto.getText().toString());
                    entidad.setInt_id_usuario(clsUsuarioDAO.Buscar(this).getInt_id_usuario());
                    entidad.setInt_id_tipo_incidente(idTipoIncidente);
                    entidad.setStr_tipo_incidente_nombre( Funciones.getNombreIncidente(idTipoIncidente));
                    entidad.setDat_fecha_registro(new Date());
                    entidad.setDou_latitud(latitude);
                    entidad.setDou_longitud(longitude);
                    entidad.setInt_estado(0);
                    if(bp!=null)
                    entidad.setByte_foto(Funciones.getByte(bp));
                    
                    String cadena= http.insertarIncidente(entidad);
                     if(!cadena.trim().equals("0"))
                     {
                        entidad.setInt_id_incidente(Integer.parseInt(cadena));
                        clsIncidentesDAO.Agregar(this, entidad);                    
                        Toast.makeText(this,"Su Incidente se envio Satisfactoriamente", Toast.LENGTH_SHORT).show(); 
                        Intent i=new Intent(this,MapaActivity.class);
                        startActivity(i); 
                     }
                }
                else
                    Toast.makeText(this,"Ingrese Asunto", Toast.LENGTH_SHORT).show(); 
            
    }
    public void btnCancelar(View v)
    {
         Intent i=new Intent(this,MapaActivity.class);
         startActivity(i); 
    }
    
    public void btnTomarFoto(View v)
    {
        Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
      startActivityForResult(intent, 0);
    }
    
   @Override
   protected void onActivityResult(int requestCode, int resultCode, Intent data) {
      // TODO Auto-generated method stub
      super.onActivityResult(requestCode, resultCode, data);
      bp = (Bitmap) data.getExtras().get("data");
      image.setImageBitmap(bp);
   }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
   
    
    return false;

    }
    
   
}
