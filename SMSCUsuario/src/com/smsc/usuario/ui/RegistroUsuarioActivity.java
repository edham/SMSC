/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.smsc.usuario.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.smsc.usuario.entidades.clsUsuario;
import com.smsc.usuario.utilidades.Funciones;
import java.util.ArrayList;
import java.util.List;
//import com.app.med.finder.utilidades.Funciones;

/**
 *
 * @author ROSEMARY
 */
public class RegistroUsuarioActivity extends Activity {

    /**
     * Called when the activity is first created.
     */
    private boolean sexo=true;
    private Spinner ComboSexo;     
    private EditText txtNombres;
    private EditText txtApellidos;
    private EditText txtFNacimiento;
    private EditText txtDNI;
    private EditText txtTelefono;
    private EditText txtEmail;
    private EditText txtDireccion;
    private EditText txtClave;
    private EditText txtRClave;
    private CheckBox chbAcepto;
    

    
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        // ToDo add your GUI initialization code here    
         setContentView(R.layout.registro_usuario);
         ComboSexo = (Spinner)findViewById(R.id.ComboSexo);
        txtNombres = (EditText)findViewById(R.id.txtNombres);
        txtApellidos = (EditText)findViewById(R.id.txtApellidos);
        txtFNacimiento = (EditText)findViewById(R.id.txtFNacimiento);
        txtDNI = (EditText)findViewById(R.id.txtDNI);
        txtTelefono = (EditText)findViewById(R.id.txtTelefono);                
        txtEmail = (EditText)findViewById(R.id.txtEmail);                
        txtDireccion = (EditText)findViewById(R.id.txtDireccion);
        txtClave = (EditText)findViewById(R.id.txtClave);
        txtRClave = (EditText)findViewById(R.id.txtRClave);
        chbAcepto = (CheckBox)findViewById(R.id.chbAcepto);  
        

         llenarDDL ();
     
    }
     public void llenarDDL (){

        List<String> lista =new ArrayList<String>();
        lista.add("Hombre");
        lista.add("Mujer");
        
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,lista);       
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
            ComboSexo.setAdapter(adapter);     
        ComboSexo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {          
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
             if(position==0)
                 sexo=true;
             else
                 sexo=false;
            }
            public void onNothingSelected(AdapterView<?> parent) {
                //User selected same item. Nothing to do.
            }
        });
        ComboSexo.setSelection(0);
     }  
     
     
     public void btnCancelar(View v)
     {
         Intent i=new Intent(this,MapaActivity.class);
                                    startActivity(i);
     }
     
      public void btnAceptar(View v)
     {
          if(!txtNombres.getText().toString().equals("") &&  txtNombres.getText().toString()!=null )
          {
               if(!txtApellidos.getText().toString().equals("") &&  txtApellidos.getText().toString()!=null )
                {
                    if(Funciones.isDate(txtFNacimiento.getText().toString()))
                    {
                         if(Funciones.isDni(txtDNI.getText().toString()))
                        {
                            if(Funciones.isTelefono(txtTelefono.getText().toString()))
                            {
                                if(Funciones.isValidEmail(txtEmail.getText().toString()))
                                {
                                     if(!txtDireccion.getText().toString().equals("") && !txtDireccion.getText().toString().equals(null))
                                    {
                                          if(!txtClave.getText().toString().equals("") && !txtClave.getText().toString().equals(null))
                                            {
                                                if(txtRClave.getText().toString().equals(txtClave.getText().toString()))
                                                {    
                                                    if(chbAcepto.isChecked())
                                                    {
                                                        clsUsuario entidad =new clsUsuario();
                                                        entidad.setStr_nombre(txtNombres.getText().toString());
                                                        entidad.setStr_apellido(txtApellidos.getText().toString());
                                                        entidad.setStr_dni(txtDNI.getText().toString());                                
//                                                        entidad.setBol_sexo(sexo);
                                                        entidad.setDat_fecha_nacimiento(Funciones.getDate(txtFNacimiento.getText().toString()));
                                                        entidad.setStr_email(txtEmail.getText().toString());
                                            

                                                        
//                                                        String idusuario= http.setGrabarUsuarioMovil(entidad);
//
//                                                         if(!idusuario.trim().equals("0"))
//                                                         {
//                                                            entidad.setInt_id_usuario_movil(1);
//                                                            clsUsuarioMovilDAO.Agregar(this, entidad); 

//                                                            Toast.makeText(this,"El Usuario se Registro Correctamente", Toast.LENGTH_SHORT).show();
//                                                            Intent i=new Intent(this,MainActivity.class);
//                                                            startActivity(i);
//                                                         }       
//                                                         else
//                                                             Toast.makeText(this,"Error al Insertar intentelo mas tarde", Toast.LENGTH_SHORT).show();
                                                             }
                                                    else
                                                        Toast.makeText(this,"Tiene que aceptar Terminos y Condiciones", Toast.LENGTH_SHORT).show(); 
                                            }
                                                else
                                                    Toast.makeText(this,"La Clave no coincide", Toast.LENGTH_SHORT).show(); 
                                            }
                                            else
                                                Toast.makeText(this,"Ingrese una Clave", Toast.LENGTH_SHORT).show(); 
                                    }
                                    else
                                        Toast.makeText(this,"Ingrese una dirección", Toast.LENGTH_SHORT).show(); 
                                }
                                else
                                    Toast.makeText(this,"Ingrese un Telefono de 9 Digitos", Toast.LENGTH_SHORT).show();           
                            }
                            else
                                Toast.makeText(this,"Ingrese un Telefono de 9 Digitos", Toast.LENGTH_SHORT).show();
                        }
                        else
                            Toast.makeText(this,"Ingrese un DNI valido", Toast.LENGTH_SHORT).show();
                    }
                    else
                        Toast.makeText(this,"Ingrese una fecha en formato dd/mm/yyyy", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(this,"Ingrese Apellidos", Toast.LENGTH_SHORT).show();
          }
          else
              Toast.makeText(this,"Ingrese Nombres", Toast.LENGTH_SHORT).show(); 
     }
       
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
   
    
    return false;

    }
}
