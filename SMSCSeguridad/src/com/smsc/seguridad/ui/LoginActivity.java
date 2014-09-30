package com.smsc.seguridad.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class LoginActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
    }
    public void btnIngresar(View v)
    {
        Intent i=new Intent(this,MenuActivity.class);
         startActivity(i);        
    }
}
