package com.smsc.seguridad.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.smsc.seguridad.conexion.http;
import com.smsc.seguridad.dao.clsIncidentesDAO;
import com.smsc.seguridad.dao.clsPersonalDAO;
import com.smsc.seguridad.dao.clsSesionPersonalVehiculoDAO;
import com.smsc.seguridad.entidades.clsIncidente;
import com.smsc.seguridad.entidades.clsPersonal;
import com.smsc.seguridad.entidades.clsSesionPersonalVehiculo;

public class LoginActivity extends Activity
{
    private  ProgressDialog pd ;
     private EditText txtDni;
    private EditText txtClave;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        txtDni = (EditText)findViewById(R.id.txtDni);
        txtClave = (EditText)findViewById(R.id.txtClave);
        if(clsSesionPersonalVehiculoDAO.Buscar(this)!=null)
        {
            Intent i=new Intent(this,MenuActivity.class);
            startActivity(i); 
        }
        
        
    }
     public void btnIngresar(View v)
     {
        if(!txtDni.getText().toString().equals(null) && !txtClave.getText().toString().equals(null)
           && !txtDni.getText().toString().equals("") && !txtClave.getText().toString().equals(""))
        {
	final String cadena=http.loginSesionPersonalVehiculo(txtDni.getText().toString(), txtClave.getText().toString());
        if(!cadena.trim().equals("0"))
          {
	     pd = new ProgressDialog(this);
            pd.setTitle("Cargando Datos");
            pd.setMessage("Espere un momento");     
            pd.show();        

                new Thread() { 
                    public void run() { 			  
                            String [] datos = cadena.split("\\<+objeto+>");   
                            clsSesionPersonalVehiculo objUsuario = new clsSesionPersonalVehiculo(datos[0].trim());
                            clsSesionPersonalVehiculoDAO.Agregar(LoginActivity.this, objUsuario);
                            if(!datos[1].trim().equals("0"))
                            {
                                String [] entidad = datos[1].trim().split("\\<+entidad+>");
                                for(int i=0;i<entidad.length;i++)
                                    clsPersonalDAO.Agregar(LoginActivity.this,new clsPersonal(entidad[i]));
                            }
                            if(!datos[2].trim().equals("0"))
                            {
                              clsIncidentesDAO.Agregar(LoginActivity.this,new clsIncidente(datos[2].trim()));
                            }
                            handler.sendEmptyMessage(0);                
                    } 
               }.start(); 
           

          }
	 else
	    Toast.makeText(this,"Error de Credenciales.", Toast.LENGTH_SHORT).show();
        }
        else
	    Toast.makeText(this,"Por favor ingrese todos los campos.", Toast.LENGTH_SHORT).show();
    }
    
     
    
        final Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            //update UI here depending on what message is received.
            super.handleMessage(msg);
            pd.dismiss();             
            Intent i=new Intent(LoginActivity.this,MenuActivity.class);
            startActivity(i); 
       
       
        }
    };
     
     @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
   
    
    return false;

    }
   
}
