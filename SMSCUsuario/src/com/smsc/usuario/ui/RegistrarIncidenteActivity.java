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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

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
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        // ToDo add your GUI initialization code here       
         setContentView(R.layout.registrar_incidente);
         txtAsunto = (EditText)findViewById(R.id.txtAsunto);
         image = (ImageView)findViewById(R.id.image);

    }
    
   
    public void btnAceptar(View v)
    {
                if(!txtAsunto.getText().toString().equals("") &&  txtAsunto.getText().toString()!=null )
                {
//                    clsPreguntaPaciente entidad = new clsPreguntaPaciente();
//                    entidad.setObjPaciente(objPaciente);
//                    entidad.setObjEspecialidad(objEspecialidad);
//                    entidad.setStr_asunto(txtAsunto.getText().toString());
//                    entidad.setStr_paciente_detalle(txtSintomas.getText().toString());
//                    if(bp!=null)
//                    entidad.setByte_imagen(Funciones.getByte(bp));
//                    
//                    String cadena= http.insertarPreguntaPacuente(entidad);
//                     if(!cadena.trim().equals("0"))
//                     {
//                        entidad.setInt_id_pregunta_paciente(Integer.parseInt(cadena));
//                        clsPreguntaPacienteDAO.Agregar(this, entidad);                    
//                        Toast.makeText(this,"Su consulta se envio Satisfactoriamente", Toast.LENGTH_SHORT).show(); 
//                        Intent i=new Intent(this,MenuActivity.class);
//                        startActivity(i); 
//                     }
                }
                else
                    Toast.makeText(this,"Ingrese Sintomas", Toast.LENGTH_SHORT).show(); 
            
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
