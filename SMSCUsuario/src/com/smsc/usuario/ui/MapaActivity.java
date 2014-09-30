/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.smsc.usuario.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import static android.content.Context.LOCATION_SERVICE;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.smsc.usuario.dao.clsIncidentesDAO;
import com.smsc.usuario.dao.clsUsuarioDAO;
import com.smsc.usuario.entidades.clsIncidente;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 *
 * @author Toditos
 */
public class MapaActivity extends FragmentActivity implements LocationListener {
 
    private GoogleMap googleMap;
    private List<clsIncidente> lista;
    
    private double latitude;
    private double longitude;
    // flag for GPS status
    boolean isGPSEnabled = false;
 
    // flag for network status
    boolean isNetworkEnabled = false;
 
    // flag for GPS status
    boolean canGetLocation = false;
 
    Location location; // location
    
    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 0; // 10 meters
 
    // The minimum time between updates in milliseconds
    private static final long MIN_TIME_BW_UPDATES = 1000 * 10; // 1 minute
 
    // Declaring a Location Manager
    protected LocationManager locationManager;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapa);
        
        Button btnIncendio = (Button) findViewById(R.id.btnIncendio);
        OnTouchListener btnIncendioListener = new OnTouchListener() {
            public boolean  onTouch  (View  v, MotionEvent  event) {
                if (event.getAction() == MotionEvent.ACTION_UP && event.getEventTime() - event.getDownTime() >= 1000){
                    Toast.makeText(MapaActivity.this,"Incendio", Toast.LENGTH_SHORT).show(); 
                    Intent i=new Intent(MapaActivity.this,RegistrarIncidenteActivity.class);
                    i.putExtra("ID",""+2);
                    i.putExtra("latitude",""+latitude);
                    i.putExtra("longitude",""+longitude);
                    startActivity(i);
                }
                return false;
            }
        };
        btnIncendio.setOnTouchListener(btnIncendioListener);
        
        Button btnSecuestro = (Button) findViewById(R.id.btnSecuestro);
        OnTouchListener btnSecuestroListener = new OnTouchListener() {
            public boolean  onTouch  (View  v, MotionEvent  event) {
                if (event.getAction() == MotionEvent.ACTION_UP && event.getEventTime() - event.getDownTime() >= 1000){
                    Toast.makeText(MapaActivity.this,"Secuestro", Toast.LENGTH_SHORT).show(); 
                    Intent i=new Intent(MapaActivity.this,RegistrarIncidenteActivity.class);
                    i.putExtra("ID",""+3);
                    i.putExtra("latitude",""+latitude);
                    i.putExtra("longitude",""+longitude);
                    startActivity(i);
                }
                return false;
            }
        };
        btnSecuestro.setOnTouchListener(btnSecuestroListener);
        
        Button btnHomicidio = (Button) findViewById(R.id.btnHomicidio);
        OnTouchListener btnHomicidioListener = new OnTouchListener() {
            public boolean  onTouch  (View  v, MotionEvent  event) {
                if (event.getAction() == MotionEvent.ACTION_UP && event.getEventTime() - event.getDownTime() >= 1000){
                    Toast.makeText(MapaActivity.this,"Homicidio", Toast.LENGTH_SHORT).show(); 
                    Intent i=new Intent(MapaActivity.this,RegistrarIncidenteActivity.class);
                    i.putExtra("ID",""+4);
                    i.putExtra("latitude",""+latitude);
                    i.putExtra("longitude",""+longitude);
                    startActivity(i);
                }
                return false;
            }
        };
        btnHomicidio.setOnTouchListener(btnHomicidioListener);  
        
        Button btnAccidente = (Button) findViewById(R.id.btnAccidente);
        OnTouchListener btnAccidenteListener = new OnTouchListener() {
            public boolean  onTouch  (View  v, MotionEvent  event) {
                if (event.getAction() == MotionEvent.ACTION_UP && event.getEventTime() - event.getDownTime() >= 1000){
                    Toast.makeText(MapaActivity.this,"Accidente", Toast.LENGTH_SHORT).show(); 
                    Intent i=new Intent(MapaActivity.this,RegistrarIncidenteActivity.class);
                    i.putExtra("ID",""+5);
                    i.putExtra("latitude",""+latitude);
                    i.putExtra("longitude",""+longitude);
                    startActivity(i);
                }
                return false;
            }
        };
        btnAccidente.setOnTouchListener(btnAccidenteListener);  
        
        Button btnViolacion = (Button) findViewById(R.id.btnViolacion);
        OnTouchListener btnViolacionListener = new OnTouchListener() {
            public boolean  onTouch  (View  v, MotionEvent  event) {
                if (event.getAction() == MotionEvent.ACTION_UP && event.getEventTime() - event.getDownTime() >= 1000){
                    Toast.makeText(MapaActivity.this,"Violacion", Toast.LENGTH_SHORT).show(); 
                    Intent i=new Intent(MapaActivity.this,RegistrarIncidenteActivity.class);
                    i.putExtra("ID",""+6);
                    i.putExtra("latitude",""+latitude);
                    i.putExtra("longitude",""+longitude);
                    startActivity(i);
                }
                return false;
            }
        };
        btnViolacion.setOnTouchListener(btnViolacionListener);
        
        Button btnOtros = (Button) findViewById(R.id.btnOtros);
        OnTouchListener btnOtrosListener = new OnTouchListener() {
            public boolean  onTouch  (View  v, MotionEvent  event) {
                if (event.getAction() == MotionEvent.ACTION_UP && event.getEventTime() - event.getDownTime() >= 1000){
                    Toast.makeText(MapaActivity.this,"Otros", Toast.LENGTH_SHORT).show(); 
                    Intent i=new Intent(MapaActivity.this,RegistrarIncidenteActivity.class);
                    i.putExtra("ID",""+7);
                    i.putExtra("latitude",""+latitude);
                    i.putExtra("longitude",""+longitude);
                    startActivity(i);
                }
                return false;
            }
        };
        btnOtros.setOnTouchListener(btnOtrosListener);
        
        Button btnRobo = (Button) findViewById(R.id.btnRobo);
        OnTouchListener btnRoboListener = new OnTouchListener() {
            public boolean  onTouch  (View  v, MotionEvent  event) {
                if (event.getAction() == MotionEvent.ACTION_UP && event.getEventTime() - event.getDownTime() >= 1000){
                    Toast.makeText(MapaActivity.this,"Robo", Toast.LENGTH_SHORT).show(); 
                    Intent i=new Intent(MapaActivity.this,RegistrarIncidenteActivity.class);
                    i.putExtra("ID",""+1);
                    i.putExtra("latitude",""+latitude);
                    i.putExtra("longitude",""+longitude);
                    startActivity(i);
                }
                return false;
            }
        };
        btnRobo.setOnTouchListener(btnRoboListener);
        
        
        // Getting Google Play availability status
        int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getBaseContext());
 
        // Showing status
        if(status!=ConnectionResult.SUCCESS){ // Google Play Services are not available
 
            int requestCode = 10;
            Dialog dialog = GooglePlayServicesUtil.getErrorDialog(status, this, requestCode);
            dialog.show();
 
        }else { // Google Play Services are available
 
            // Getting reference to the SupportMapFragment of activity_main.xml
            SupportMapFragment fm = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
 
            // Getting GoogleMap object from the fragment
            googleMap = fm.getMap();
 
            // Enabling MyLocation Layer of Google Map
            googleMap.setMyLocationEnabled(true);

            googleMap.animateCamera(CameraUpdateFactory.zoomTo(16));
            
            getLocation();
        }
        addMaker();
    }
     public void getLocation() {
        try {
            locationManager = (LocationManager) this
                    .getSystemService(LOCATION_SERVICE);
 
            // getting GPS status
            isGPSEnabled = locationManager
                    .isProviderEnabled(LocationManager.GPS_PROVIDER);
 
            // getting network status
            isNetworkEnabled = locationManager
                    .isProviderEnabled(LocationManager.NETWORK_PROVIDER);
 
            if (!isGPSEnabled && !isNetworkEnabled) {
                // no network provider is enabled
                 Toast.makeText(this,"Por favor Active su GPS", Toast.LENGTH_SHORT).show();
            } else {
                this.canGetLocation = true;
                // First get location from Network Provider
                if (isNetworkEnabled) {
                    locationManager.requestLocationUpdates(
                            LocationManager.NETWORK_PROVIDER,
                            MIN_TIME_BW_UPDATES,
                            MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
                    Log.d("Network", "Network");
                    if (locationManager != null) {
                        location = locationManager
                                .getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                        if (location != null) {
                            onLocationChanged(location);
                        }
                    }
                }
                // if GPS Enabled get lat/long using GPS Services
                if (isGPSEnabled) {
                    if (location == null) {
                        locationManager.requestLocationUpdates(
                                LocationManager.GPS_PROVIDER,
                                MIN_TIME_BW_UPDATES,
                                MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
                        Log.d("GPS Enabled", "GPS Enabled");
                        if (locationManager != null) {
                            location = locationManager
                                    .getLastKnownLocation(LocationManager.GPS_PROVIDER);
                            if (location != null) {
                                onLocationChanged(location);
                            }
                        }
                    }
                }
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onLocationChanged(Location location) {
 
        
        latitude = location.getLatitude();
 
        // Getting longitude of the current location
        longitude = location.getLongitude();
 
        // Creating a LatLng object for the current location
        LatLng latLng = new LatLng(latitude, longitude);
        
        // Showing the current location in Google Map
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
 
        // Zoom in the Google Map
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(16));
 
 
    }
 
 @Override
    public void onProviderDisabled(String provider) 
    {
        // TODO Auto-generated method stub
        Toast.makeText(this, "provider disabled", Toast.LENGTH_SHORT).show();
    }
 
    @Override
    public void onProviderEnabled(String provider) 
    {
        // TODO Auto-generated method stub
        Toast.makeText(this, "provider enabled", Toast.LENGTH_SHORT).show();
    }
 
    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) 
    {
        
    }
 
public void addMaker()
{
    googleMap.clear();
    lista=clsIncidentesDAO.Listar(this,false);
    if(lista!=null)
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
     

    
        googleMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                @Override
                public void onInfoWindowClick(Marker marker) {

                  
                    getDetalle(Integer.parseInt(marker.getSnippet()));
                }
            });
        }
   public void getDetalle(int posicion)
   {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_incidente);
        
        TextView lblAsunto = (TextView)dialog.findViewById(R.id.lblAsunto);
        lblAsunto.setText(lista.get(posicion).getStr_detalle());

        TextView lblNombreInciente = (TextView)dialog.findViewById(R.id.lblNombreInciente);
        lblNombreInciente.setText(lista.get(posicion).getStr_tipo_incidente_nombre());

        TextView lblEstado = (TextView)dialog.findViewById(R.id.lblEstado);
        lblEstado.setText("En Progreso");
        if(lista.get(posicion).getInt_estado()==1)
            lblEstado.setText("Verificado");
        else if(lista.get(posicion).getInt_estado()==2)
            lblEstado.setText("Anulado");
        SimpleDateFormat  fecha=new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat hora=new SimpleDateFormat("h:mm a");

        TextView lblFecha = (TextView)dialog.findViewById(R.id.lblFecha);
        lblFecha.setText(fecha.format(lista.get(posicion).getDat_fecha_registro()));

        TextView lblHora = (TextView)dialog.findViewById(R.id.lblHora);
        lblHora.setText(hora.format(lista.get(posicion).getDat_fecha_registro()));


        Button btnAceptar = (Button) dialog.findViewById(R.id.btnAceptar);
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
         
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
        case R.id.MnuOpc1:  
            Intent i=new Intent(this,MisIncidentesActivity.class);
            startActivity(i);   
            return true;
        case R.id.MnuOpc2:  
             AlertDialog.Builder alert = new AlertDialog.Builder(this);
             alert.setTitle("Cerrar Sesion");
                alert.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {  
                            clsUsuarioDAO.Borrar(MapaActivity.this);
                            clsIncidentesDAO.Borrar(MapaActivity.this);
//                            Intent svc = new Intent(MenuActivity.this, clsServicio.class);
//                            stopService(svc); 
                            Intent i=new Intent(MapaActivity.this,LoginActivity.class);
                            startActivity(i); 
                         
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
 
          
}