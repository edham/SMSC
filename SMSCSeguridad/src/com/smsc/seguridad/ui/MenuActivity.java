/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.smsc.seguridad.ui;


import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.smsc.seguridad.conexion.http;
import com.smsc.seguridad.dao.clsIncidentesDAO;
import com.smsc.seguridad.dao.clsPersonalDAO;
import com.smsc.seguridad.dao.clsSesionPersonalVehiculoDAO;
import com.smsc.seguridad.entidades.clsIncidente;
import com.smsc.seguridad.fragment.DetalleSesionFragment;
import com.smsc.seguridad.fragment.IncidenteDatosFragment;
import com.smsc.seguridad.fragment.IncidenteRespuestaFragment;
import com.smsc.seguridad.fragment.InicioFragment;
import com.smsc.seguridad.fragment.ListaIncidentesFragment;
import com.smsc.seguridad.route.Routing;
import com.smsc.seguridad.route.RoutingListener;
import com.smsc.seguridad.servicio.GPSTrackService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Toditos
 */
public class MenuActivity extends FragmentActivity implements RoutingListener{
 
    private FragmentManager fragmentManager=null;
    private  FragmentTransaction fragmentTransaction=null;
    
    private IncidenteDatosFragment IncidenteDatosFragment;
    private InicioFragment InicioFragment;
    private IncidenteRespuestaFragment IncidenteRespuestaFragment;
    private ListaIncidentesFragment ListaIncidentesFragment;
    private DetalleSesionFragment DetalleSesionFragment;
    private GoogleMap googleMap;
    private ReceiverGPS receiverGPS;
    private IntentFilter filterGPS;
    
    private ReceiverFragment receiverFragment;
    private IntentFilter filterFragment;
    private boolean zoon=true;
    private boolean listaIncidentes=false;
//    private Marker myMarker;
    private List<clsIncidente> lista;
    public clsIncidente objIncidente=null;
    private  ProgressDialog pdGps ;
    
    private LatLng posicion;
    
    private int accion=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        
        objIncidente = clsIncidentesDAO.Buscar(this);
        googleMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();

        googleMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.icono_gps)).position(new LatLng(0.0, 0.0)));

        receiverGPS = new ReceiverGPS();
        filterGPS = new IntentFilter("GPSTrackService");
        registerReceiver(receiverGPS, filterGPS);

        receiverFragment = new ReceiverFragment();
        filterFragment = new IntentFilter("Fragment");
        registerReceiver(receiverFragment, filterFragment);
        
        if(clsSesionPersonalVehiculoDAO.Buscar(this)==null)
        {
            Intent i=new Intent(this,LoginActivity.class);
            startActivity(i); 
        }
        else
        {
        Intent svc = new Intent(MenuActivity.this, GPSTrackService.class);
        startService(svc);
        }

       fragmentManager = getSupportFragmentManager();



        googleMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                   @Override
                   public void onInfoWindowClick(Marker marker) {

                       accion=1;
                       getDatos(lista.get(Integer.parseInt(marker.getSnippet())));
                       //getDetalle();
                   }
               });   
           pdGps = new ProgressDialog(this);
           pdGps.setTitle("Iniciando GPS");
           pdGps.setMessage("Espere un momento");    
           pdGps.setCancelable(false);
           pdGps.show(); 

           if(objIncidente==null)
           {
               getInicio();              
           }
           else
           {
               fragmentTransaction = fragmentManager.beginTransaction();
               IncidenteRespuestaFragment = new IncidenteRespuestaFragment();
               fragmentTransaction.replace(R.id.myfragment, IncidenteRespuestaFragment);
               fragmentTransaction.commit();
               accion=1;
               cargarSeguimiento();
           }
    }
 
    public void getInicio()
    {
        fragmentTransaction = fragmentManager.beginTransaction();
        InicioFragment = new InicioFragment();
        fragmentTransaction.replace(R.id.myfragment, InicioFragment);
        fragmentTransaction.commit();
    }
     public void getListaIncidentes()
    {
        fragmentTransaction = fragmentManager.beginTransaction();
        ListaIncidentesFragment = new ListaIncidentesFragment(lista);
        fragmentTransaction.replace(R.id.myfragment, ListaIncidentesFragment);
        fragmentTransaction.commit();
    }
    
    public void getDetalleSessiom()
    {
        listaIncidentes=false;
        fragmentTransaction = fragmentManager.beginTransaction();
        DetalleSesionFragment = new DetalleSesionFragment();
        fragmentTransaction.replace(R.id.myfragment, DetalleSesionFragment);
        fragmentTransaction.commit();
    }
    
  public void getDatos(clsIncidente entidad)
    {
        objIncidente=entidad;
        fragmentTransaction = fragmentManager.beginTransaction();
        IncidenteDatosFragment = new IncidenteDatosFragment(entidad);
        fragmentTransaction.replace(R.id.myfragment, IncidenteDatosFragment);
        fragmentTransaction.commit();
        cargarSeguimiento();
      
    }
  public void getRespuesta()
    {
        
        clsIncidentesDAO.Agregar(this, objIncidente);
        fragmentTransaction = fragmentManager.beginTransaction();
        IncidenteRespuestaFragment = new IncidenteRespuestaFragment();
        fragmentTransaction.replace(R.id.myfragment, IncidenteRespuestaFragment);
        fragmentTransaction.commit();
      
    }
  
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
   
    
    return false;

    }
    
       @Override
    public boolean onCreateOptionsMenu(Menu menu) {
      
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menu, menu);   
            return true;
       
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        
        switch (item.getItemId()) {
        case R.id.MnuOpc0:  
            getDetalleSessiom();
            return true;
        case R.id.MnuOpc1:  
            listaIncidentes=true;
            getListaIncidentes();
            return true;
        case R.id.MnuOpc2:  
             AlertDialog.Builder alert = new AlertDialog.Builder(this);
             alert.setTitle("Cerrar Sesion");
                alert.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {  
                             String id=http.cerrarSesionPersonalVehiculo(clsSesionPersonalVehiculoDAO.Buscar(MenuActivity.this).getInt_sesion_personal_vehiculo());
                             if(!id.trim().equals("0"))
                             {
                                clsIncidentesDAO.Borrar(MenuActivity.this);
                                clsSesionPersonalVehiculoDAO.Borrar(MenuActivity.this);
                                clsPersonalDAO.Borrar(MenuActivity.this);
                                Intent svc = new Intent(MenuActivity.this, GPSTrackService.class);
                                stopService(svc); 
                                android.os.Process.killProcess(android.os.Process.myPid());

                             }
                           
                         
                        }});
                alert.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {  
                       public void onClick(DialogInterface dialog, int whichButton) {    
                    }});
                       alert.show();
            return true;
   
        default:
            return super.onOptionsItemSelected(item);
        }
    }
    @Override
    public boolean onPrepareOptionsMenu(Menu menu)
    {
       if(clsIncidentesDAO.Buscar(this)!=null)
       {
          menu.getItem(0).setVisible(false);
          menu.getItem(1).setVisible(false);
          menu.getItem(2).setVisible(false);
       }
       else
       {
          menu.getItem(0).setVisible(true); 
          menu.getItem(1).setVisible(true); 
          menu.getItem(2).setVisible(true); 
       }
      return super.onPrepareOptionsMenu(menu);
    }     
   public void CargarIncidentes()
   {
        lista = new ArrayList<clsIncidente>();    
        String cadena=http.listarXEstadoIncidente();
        if(!cadena.trim().equals("0"))
        {
            String [] entidad = cadena.trim().split("\\<+entidad+>");
             for(int i=0;i<entidad.length;i++)
                 lista.add(new clsIncidente(entidad[i]));
        }
        googleMap.clear();
        for(int i=0; i<lista.size();i++)
        {
            BitmapDescriptor bimap=BitmapDescriptorFactory.fromResource(R.drawable.icono_robo);
            if(lista.get(i).getInt_id_tipo_incidente()==2)
                bimap=BitmapDescriptorFactory.fromResource(R.drawable.icono_incendio);
            else if(lista.get(i).getInt_id_tipo_incidente()==3)
                bimap=BitmapDescriptorFactory.fromResource(R.drawable.icono_secuestro);
            else if(lista.get(i).getInt_id_tipo_incidente()==4)
                bimap=BitmapDescriptorFactory.fromResource(R.drawable.icono_homicidio);
            else if(lista.get(i).getInt_id_tipo_incidente()==5)
                bimap=BitmapDescriptorFactory.fromResource(R.drawable.icono_accidente);
            else if(lista.get(i).getInt_id_tipo_incidente()==6)
                bimap=BitmapDescriptorFactory.fromResource(R.drawable.icono_violacion);
            else if(lista.get(i).getInt_id_tipo_incidente()==7)
                bimap=BitmapDescriptorFactory.fromResource(R.drawable.icono_otros);

            googleMap.addMarker(new MarkerOptions().icon(bimap).title(lista.get(i).getStr_tipo_incidente_nombre()).snippet(""+i).position(new LatLng(lista.get(i).getDou_latitud(),lista.get(i).getDou_longitud())));
        }

        googleMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.icono_gps)).position(posicion));
        if(zoon)
        {
            googleMap.moveCamera(CameraUpdateFactory.zoomTo(18));
            pdGps.dismiss();             
            zoon=false;
        }
        googleMap.animateCamera(CameraUpdateFactory.newLatLng(posicion));
        Toast.makeText(MenuActivity.this,"TOTAL DE INCIDENTES: "+lista.size(), Toast.LENGTH_SHORT).show();
        
        if(listaIncidentes)
            getListaIncidentes();
   }
   
   public void cargarSeguimiento()
   {       
       Routing routing = new Routing(Routing.TravelMode.DRIVING);
       routing.registerListener(this);
       routing.execute(posicion, new LatLng(objIncidente.getDou_latitud(),objIncidente.getDou_longitud()));  

   }
    @Override
    public void onRoutingFailure() {
    }
    @Override
    public void onRoutingStart() {
    }
    @Override
    public void onRoutingSuccess(PolylineOptions mPolyOptions) {
        googleMap.clear();
        PolylineOptions polyoptions = new PolylineOptions();
        polyoptions.color(Color.RED);
        polyoptions.width(8);
        polyoptions.addAll(mPolyOptions.getPoints());
        googleMap.addPolyline(polyoptions);
    
        MarkerOptions GPS = new MarkerOptions();
        GPS = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.icono_gps)).position(posicion);
        googleMap.addMarker(GPS);
        BitmapDescriptor bimap=BitmapDescriptorFactory.fromResource(R.drawable.icono_robo);
            if(objIncidente.getInt_id_tipo_incidente()==2)
                bimap=BitmapDescriptorFactory.fromResource(R.drawable.icono_incendio);
            else if(objIncidente.getInt_id_tipo_incidente()==3)
                bimap=BitmapDescriptorFactory.fromResource(R.drawable.icono_secuestro);
            else if(objIncidente.getInt_id_tipo_incidente()==4)
                bimap=BitmapDescriptorFactory.fromResource(R.drawable.icono_homicidio);
            else if(objIncidente.getInt_id_tipo_incidente()==5)
                bimap=BitmapDescriptorFactory.fromResource(R.drawable.icono_accidente);
            else if(objIncidente.getInt_id_tipo_incidente()==6)
                bimap=BitmapDescriptorFactory.fromResource(R.drawable.icono_violacion);
            else if(objIncidente.getInt_id_tipo_incidente()==7)
                bimap=BitmapDescriptorFactory.fromResource(R.drawable.icono_otros);

        MarkerOptions Incidente = new MarkerOptions();
        Incidente = new MarkerOptions().icon(bimap).position(new LatLng(objIncidente.getDou_latitud(),objIncidente.getDou_longitud()));
        googleMap.addMarker(Incidente);

        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        builder.include(GPS.getPosition());
        builder.include(Incidente.getPosition());
        LatLngBounds bounds = builder.build();
        int padding = 100; // offset from edges of the map in pixels
        googleMap.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds, padding));
        
        
        if(zoon)
        {
            pdGps.dismiss();             
            zoon=false;
        }
    }
    
    
  private class ReceiverGPS extends BroadcastReceiver {
  @Override
  public void onReceive(Context context, Intent intent) {
 
    
    double Lat = intent.getDoubleExtra("Lat", 0.0);
    double Long = intent.getDoubleExtra("Long", 0.0);
//    myMarker.remove();
   posicion=new LatLng(Lat,Long);
   if(accion==0)
   CargarIncidentes();
   else if(accion==1)
   cargarSeguimiento();
  }     
 }        
  
  
   private class ReceiverFragment extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        int  parametro = intent.getIntExtra("parametro", 0);
        if(parametro==0)
        {
            ReloadIncidentes();
        }
        else if(parametro==1)
        {
            String id=http.insertarRespuestaIncidente(clsSesionPersonalVehiculoDAO.Buscar(MenuActivity.this).getInt_sesion_personal_vehiculo(), objIncidente.getInt_id_incidente());
            if(!id.trim().equals("0"))
             {
                 objIncidente.setInt_id_respuesta_incidente(Integer.parseInt(id));
                 getRespuesta();
             }
            else
            {
                ReloadIncidentes();
            }
            
        }
        else if(parametro==2)
        {
            int  pos = intent.getIntExtra("pos", 0);
            accion=1;
            getDatos(lista.get(pos));
        }
           
       
    }     
 }
   public void ReloadIncidentes()
   {
        clsIncidentesDAO.Borrar(MenuActivity.this);
        getInicio();
        accion=0;
        listaIncidentes=false;
        CargarIncidentes();
       
   }
}