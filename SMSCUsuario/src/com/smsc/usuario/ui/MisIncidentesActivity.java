/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smsc.usuario.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.smsc.usuario.dao.clsIncidentesDAO;
import com.smsc.usuario.entidades.clsIncidente;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Babsy Gamboa
 */
public class MisIncidentesActivity extends Activity {

    /**
     * Called when the activity is first created.
     */
    
     private  List<clsIncidente> itens=null;
     private ListView List;
     private AdaptadorTitulares adaptador;
     
    
     
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.mis_incidentes);
        
      
       
       itens=clsIncidentesDAO.Listar(this,true);
        
          List = (ListView)findViewById(R.id.list); 
          Buscar();    
    }
    public void Buscar()
  {    
      
      if(itens!=null && itens.size()!=0)
      {
            adaptador = new AdaptadorTitulares(this);
            List.setAdapter(adaptador);
            
      }
       else
      {
            Toast.makeText(this,"No se encontraron Itinerarios", Toast.LENGTH_SHORT).show(); 
      }
  }
     
      class AdaptadorTitulares extends ArrayAdapter {
    	
    	Activity context;
    	
    	AdaptadorTitulares(Activity context) {
    		super(context, R.layout.mis_incidentes_lista, itens);
    		this.context = context;
    	}
    	
    	public View getView(int position, View convertView, ViewGroup parent) {
            final int posicion = position;
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.mis_incidentes_lista, null);

            TextView lblAsunto = (TextView)item.findViewById(R.id.lblAsunto);
            lblAsunto.setText(itens.get(position).getStr_detalle());

            TextView lblNombreInciente = (TextView)item.findViewById(R.id.lblNombreInciente);
            lblNombreInciente.setText(itens.get(position).getStr_tipo_incidente_nombre());
            
            TextView lblEstado = (TextView)item.findViewById(R.id.lblEstado);
            lblEstado.setText("En Progreso");
            if(itens.get(position).getInt_estado()==1)
                lblEstado.setText("Verificado");
            else if(itens.get(position).getInt_estado()==2)
                lblEstado.setText("Anulado");
            SimpleDateFormat  fecha=new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat hora=new SimpleDateFormat("h:mm a");

            TextView lblFecha = (TextView)item.findViewById(R.id.lblFecha);
            lblFecha.setText(fecha.format(itens.get(position).getDat_fecha_registro()));

            TextView lblHora = (TextView)item.findViewById(R.id.lblHora);
            lblHora.setText(hora.format(itens.get(position).getDat_fecha_registro()));

            Button btnDetalle = (Button)item.findViewById(R.id.btnDetalle);

            btnDetalle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

    //               Intent i=new Intent(ItinerarioEmpresasActivity.this,EmpresaDetalleActivity.class);
    //                i.putExtra("idEmpresa",""+itens.get(posicion).getInt_id_empresa());
    //                startActivity(i); 
                }
            });

//          

            return(item);
		}
    }
        public void getBtnInformacion(int id)
        {
         
//         Toast.makeText(this,""+itens.get(id).getDou_precio(), Toast.LENGTH_SHORT).show(); 
        }
//         public void getBtnSiguiente(clsBus entidad)
//        {
//         clsBusDAO.Agregar(this,entidad);
//         Intent i=new Intent(this,SeleccionaAsientoActivity.class);
//         startActivity(i);
//        }
         

    
    
}
