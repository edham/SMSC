/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.smsc.usuario.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.Toast;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import java.util.List;

/**
 *
 * @author Toditos
 */
public class MapaActivity extends FragmentActivity implements LocationListener {
 
    private GoogleMap googleMap;
//    private List<clsSucursal> ListSucursales;
    private Location Localizacion=null;
 
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
            // Getting LocationManager object from System Service LOCATION_SERVICE
            LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
 
            // Creating a criteria object to retrieve provider
            Criteria criteria = new Criteria();
 
            // Getting the name of the best provider
            String provider = locationManager.getBestProvider(criteria, true);
 
            // Getting Current Location
            Location location = locationManager.getLastKnownLocation(provider);
 
            if(location!=null){
                onLocationChanged(location);
            }
            locationManager.requestLocationUpdates(provider, 20000, 0, this);
        }
        addMaker();
    }
    @Override
    public void onLocationChanged(Location location) {
 
        Localizacion=location;
        // Getting latitude of the current location
        double latitude = location.getLatitude();
 
        // Getting longitude of the current location
        double longitude = location.getLongitude();
 
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
//    ListSucursales=clsSucursalDAO.ListarTodos(this);
//    if(ListSucursales!=null)
//    for(clsSucursal sucursal:ListSucursales)
        googleMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.icono_accidente)).title("Incendio").snippet(""+1).position(new LatLng(-8.1090524,-79.0215336)));
        googleMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.icono_homicidio)).title("Incendio").snippet(""+1).position(new LatLng( -8.107260007326138,-79.01472347131113 )));
        googleMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.icono_incendio)).title("Incendio").snippet(""+1).position(new LatLng( -8.107127237180672 , -79.01526259532312  )));


    
        googleMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                @Override
                public void onInfoWindowClick(Marker marker) {

//                   Intent i=new Intent(MapaActivity.this,EmpresaDetalleActivity.class);
//                   i.putExtra("idEmpresa",""+marker.getSnippet());
//                   startActivity(i); 
                }
            });
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
            return true;
        case R.id.MnuOpc2:  
            return true;
   
        default:
            return super.onOptionsItemSelected(item);
        }
    }
 
          
}