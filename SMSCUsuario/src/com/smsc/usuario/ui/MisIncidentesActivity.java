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
      private EditText txtFiltroHistorial;
     private ListView listItinerarioEmpresas;
     private AdaptadorTitulares adaptador;
     
    
     
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.mis_incidentes);
        
      
       
       itens= new ArrayList<clsIncidente>();
       itens.add(new clsIncidente() );
       itens.add(new clsIncidente() );
       itens.add(new clsIncidente() );
        
          listItinerarioEmpresas = (ListView)findViewById(R.id.list);  
         txtFiltroHistorial = (EditText) findViewById(R.id.txtFiltroHistorial);
		txtFiltroHistorial.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,int count) {                                
                            Buscar(s.toString().trim()); 
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,int after) {
			}

			@Override
			public void afterTextChanged(Editable s) {
			}
		});
                
                Buscar("");    
    }
         public void Buscar(String filtro)
  {    
      
      if(itens!=null && itens.size()!=0)
      {
            adaptador = new AdaptadorTitulares(this);
            listItinerarioEmpresas.setAdapter(adaptador);
            
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

//            TextView lblNombreEmpresa = (TextView)item.findViewById(R.id.lblNombreEmpresa);
//            lblNombreEmpresa.setText("Empresa "+itens.get(position).getNombreEmpresa());

//            TextView lblPrecio = (TextView)item.findViewById(R.id.lblPrecio);
//            lblPrecio.setText("S/."+itens.get(position).getDou_precio());
//            TextView lblDisponibilidad = (TextView)item.findViewById(R.id.lblDisponibilidad);
//            lblDisponibilidad.setText(""+itens.get(position).getInt_asientos_disponibles());
//
//            SimpleDateFormat  fecha=new SimpleDateFormat("dd/MM/yyyy");
//            SimpleDateFormat hora=new SimpleDateFormat("h:mm a");
//
//            TextView lblFecha = (TextView)item.findViewById(R.id.lblFecha);
//            lblFecha.setText(fecha.format(itens.get(position).getFecha()));
//
//            TextView lblHora = (TextView)item.findViewById(R.id.lblHora);
//            lblHora.setText(hora.format(itens.get(position).getFecha()));

//            Button btnInformacion = (Button)item.findViewById(R.id.btnInformacion);
//
//            btnInformacion.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
////               Intent i=new Intent(ItinerarioEmpresasActivity.this,EmpresaDetalleActivity.class);
////                i.putExtra("idEmpresa",""+itens.get(posicion).getInt_id_empresa());
////                startActivity(i); 
//            }
//            });

//            Button btnSiguiente = (Button)item.findViewById(R.id.btnSiguiente);
//            final int pos=position;
//            btnSiguiente.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
////              getBtnSiguiente(itens.get(pos));
//            }
//            });

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
