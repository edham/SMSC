/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.smsc.seguridad.servicio;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import com.smsc.seguridad.conexion.http;
import com.smsc.seguridad.dao.clsSesionPersonalVehiculoDAO;
import com.smsc.seguridad.entidades.clsSesionPersonalVehiculo;
import com.smsc.seguridad.ui.R;
import com.smsc.seguridad.utilidades.Funciones;

/**
 *
 * @author Toditos
 */
public class GPSTrackService extends Service {
 private LocationManager lm;
 private MyLocationListener mll;
 boolean isGPSEnabled = false;
 private clsSesionPersonalVehiculo objSesionPersonalVehiculo;
    // flag for network status
    boolean isNetworkEnabled = false;
 
    // flag for GPS status
    boolean canGetLocation = false;
    private double latitud=0;
    private double longitud=0;
  private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 0; // 10 meters
 
    // The minimum time between updates in milliseconds
    private static final long MIN_TIME_BW_UPDATES = 1000 * 10; 
 @Override
 public IBinder onBind(Intent arg0) {
  // TODO Auto-generated method stub
  return null;
 }

 @Override
 public void onCreate() {
  super.onCreate();
  lm = (LocationManager)getSystemService(LOCATION_SERVICE);
  mll = new MyLocationListener();
  objSesionPersonalVehiculo=clsSesionPersonalVehiculoDAO.Buscar(this.getApplication());
 }

 @Override
 public int onStartCommand(Intent intent, int flags, int startId) {

        // getting GPS status
        isGPSEnabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);

        // getting network status
        isNetworkEnabled = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

        if (isGPSEnabled && isNetworkEnabled) {
             lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, MIN_TIME_BW_UPDATES,
                            MIN_DISTANCE_CHANGE_FOR_UPDATES, mll);
        }
        else if (!isGPSEnabled)
            NotificacionGPS();
  
 
  
  return super.onStartCommand(intent, flags, startId);
 }
 
 
 @Override
 public void onDestroy() {
  super.onDestroy();
  lm.removeUpdates(mll);
 }


 private class MyLocationListener implements LocationListener {

  @Override
  public void onLocationChanged(Location location) {
   Intent intent = new Intent("GPSTrackService");
   intent.putExtra("Lat", location.getLatitude());
   intent.putExtra("Long", location.getLongitude());
   sendBroadcast(intent);
   if(Funciones.getDistancia(location.getLatitude(), location.getLongitude(), latitud, longitud, 10))
   {
   
    String id=http.insertarRecorridoSesionPersonalVehiculo(objSesionPersonalVehiculo.getInt_sesion_personal_vehiculo(),location.getLongitude(),location.getLatitude());
    if(!id.trim().equals("0"))
     {
        latitud=location.getLatitude();
        longitud= location.getLongitude();
     }
   }
  }

  @Override
  public void onProviderDisabled(String provider) {
   // TODO Auto-generated method stub
   
  }

  @Override
  public void onProviderEnabled(String provider) {
   // TODO Auto-generated method stub
   
  }

  @Override
  public void onStatusChanged(String provider, int status, Bundle extras) {
   // TODO Auto-generated method stub
   
  }
  
 }

 public void borrarNotificacion()
 {
     String ns = Context.NOTIFICATION_SERVICE;
    NotificationManager notManager = 
    (NotificationManager) getSystemService(ns);
    notManager.cancelAll();
 }
public void borrarNotificacionxId(int Id)
 {
     String ns = Context.NOTIFICATION_SERVICE;
    NotificationManager notManager = 
    (NotificationManager) getSystemService(ns);
    notManager.cancel(Id);
 }
public void Notificacion(String Titulo,String Motivo,int id,int idCosulta)
{
    String ns = Context.NOTIFICATION_SERVICE;
    NotificationManager notManager = 
        (NotificationManager) getSystemService(ns);

    int icono = R.drawable.gps;
    CharSequence textoEstado = Titulo;
    long hora = System.currentTimeMillis();

    Notification notif = 
        new Notification(icono, textoEstado, hora);

    Context contexto = getApplicationContext();
    CharSequence titulo = Titulo;
    CharSequence descripcion = Motivo;
    Intent notIntent=null;
//    if(id==0)
//    notIntent = new Intent(contexto,MenuActivity.class);
//    else if(id==1)
//    {
//        notIntent = new Intent(contexto,RespuestasConsultasActivity.class);
//        notIntent.putExtra("Id",""+idCosulta);
//    }
//     else if(id==2)         
//        notIntent = new Intent(contexto,CitasActivity.class);
    
    PendingIntent contIntent = PendingIntent.getActivity(
                contexto, 0, notIntent, 0);

    notif.setLatestEventInfo(
                contexto, titulo, descripcion, contIntent);

    notif.flags |= Notification.FLAG_AUTO_CANCEL;
    notif.flags |= Notification.FLAG_ONGOING_EVENT;
    notif.defaults |= Notification.DEFAULT_SOUND;


    notManager.notify(id, notif);                                      
}

public void NotificacionGPS()
{
    String ns = Context.NOTIFICATION_SERVICE;
    NotificationManager notManager = 
        (NotificationManager) getSystemService(ns);

    int icono = R.drawable.gps;
    CharSequence textoEstado = "Active su GPS";
    long hora = System.currentTimeMillis();

    Notification notif = 
        new Notification(icono, textoEstado, hora);

    Context contexto = getApplicationContext();
    CharSequence titulo =  "Active su GPS";
    CharSequence descripcion =  "Por favor Active su GPS";
    Intent notIntent = new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
    
    
    PendingIntent contIntent = PendingIntent.getActivity(
                contexto, 0, notIntent, 0);

    notif.setLatestEventInfo(
                contexto, titulo, descripcion, contIntent);

    notif.flags |= Notification.FLAG_AUTO_CANCEL;
    notif.flags |= Notification.FLAG_ONGOING_EVENT;
    notif.defaults |= Notification.DEFAULT_SOUND;


    notManager.notify(0, notif);                                      
}

}