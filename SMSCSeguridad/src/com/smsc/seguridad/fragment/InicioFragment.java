 package com.smsc.seguridad.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.smsc.seguridad.ui.R;


public class InicioFragment extends Fragment {


     @Override
    public void onStart() 
    {
        super.onStart();
      
    }
   
	 @Override
	 public View onCreateView(LayoutInflater inflater, ViewGroup container,
	   Bundle savedInstanceState) {
	  View myFragmentView = inflater.inflate(R.layout.fragmento_inicio, container, false);
          
	  return myFragmentView;
	 }

}
