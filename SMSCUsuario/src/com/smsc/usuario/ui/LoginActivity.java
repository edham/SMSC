package com.smsc.usuario.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.smsc.usuario.conexion.http;
import com.smsc.usuario.dao.clsIncidentesDAO;
import com.smsc.usuario.dao.clsUsuarioDAO;
import com.smsc.usuario.entidades.clsIncidente;
import com.smsc.usuario.entidades.clsUsuario;

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
        
        
    }
     public void btnIngresar(View v)
     {
	  final String cadena=http.loginUsuario(txtDni.getText().toString(), txtClave.getText().toString());
        if(!cadena.trim().equals("0"))
          {
	     pd = new ProgressDialog(this);
            pd.setTitle("Cargando Datos");
            pd.setMessage("Espere un momento");     
            pd.show();        

                new Thread() { 
                    public void run() { 			  
                            String [] datos = cadena.split("\\<+objeto+>");   
                            clsUsuario objUsuario = new clsUsuario(datos[0].trim());
                            clsUsuarioDAO.Agregar(LoginActivity.this, objUsuario);
                            if(!datos[1].trim().equals("0"))
                            {
                                String [] entidad = datos[1].trim().split("\\<+entidad+>");
                                for(int i=0;i<entidad.length;i++)
                                    clsIncidentesDAO.Agregar(LoginActivity.this,new clsIncidente(entidad[i],objUsuario.getInt_id_usuario()));
                            }
                            handler.sendEmptyMessage(0);                
                    } 
               }.start(); 
           

          }
	 else
	    Toast.makeText(this,"Error de Credenciales.", Toast.LENGTH_SHORT).show();
       
    }
    
    
        final Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            //update UI here depending on what message is received.
            super.handleMessage(msg);
            pd.dismiss();             
            Intent i=new Intent(LoginActivity.this,MapaActivity.class);
            startActivity(i); 
       
       
        }
    };
     public void btnRegistrarme(View v)
    {
       Intent i=new Intent(this,RegistroUsuarioActivity.class);
         startActivity(i);        
    }
    
    
   
}
