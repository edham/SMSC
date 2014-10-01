/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smsc.seguridad.conexion;

import android.util.Base64;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;



public class http {

    private static String url="http://192.168.1.5:8084/servicio/servicio_seguridad.jsp";
    private static HttpClient client;
    private static HttpResponse responseGet;
    private static HttpEntity resEntityGet;
    


    public static String listarXEstadoIncidente() 
    {
    client = new DefaultHttpClient();
    HttpPost httppost = new HttpPost(url);

    try {
        List<NameValuePair> Value = new ArrayList<NameValuePair>(1);
        Value.add(new BasicNameValuePair("IdServicio","1"));
        httppost.setEntity(new UrlEncodedFormEntity(Value));
        responseGet = client.execute(httppost);
        resEntityGet = responseGet.getEntity();
        if (resEntityGet != null) {
                return  EntityUtils.toString(resEntityGet).trim();
        }
        } catch (ClientProtocolException e) {
            return "-1";
        } catch (IOException e) {
            return "-1";
        }
     return "-1";
    }
    public static String loginSesionPersonalVehiculo(String dni,String clave) 
    {
    client = new DefaultHttpClient();
    HttpPost httppost = new HttpPost(url);

    try {
        List<NameValuePair> Value = new ArrayList<NameValuePair>(3);
        Value.add(new BasicNameValuePair("IdServicio","2"));
        Value.add(new BasicNameValuePair("dni",dni));
        Value.add(new BasicNameValuePair("clave",clave));
        httppost.setEntity(new UrlEncodedFormEntity(Value));
        responseGet = client.execute(httppost);
        resEntityGet = responseGet.getEntity();
        if (resEntityGet != null) {
                return  EntityUtils.toString(resEntityGet).trim();
        }
        } catch (ClientProtocolException e) {
            return "-1";
        } catch (IOException e) {
            return "-1";
        }
     return "-1";
    }
    
    public static String insertarRespuestaIncidente(int IdSession,int IdIncidente) 
    {
    client = new DefaultHttpClient();
    HttpPost httppost = new HttpPost(url);

    try {
        List<NameValuePair> Value = new ArrayList<NameValuePair>(3);
        Value.add(new BasicNameValuePair("IdServicio","3"));
        Value.add(new BasicNameValuePair("IdSession",""+IdSession));
        Value.add(new BasicNameValuePair("IdIncidente",""+IdIncidente));
        httppost.setEntity(new UrlEncodedFormEntity(Value));
        responseGet = client.execute(httppost);
        resEntityGet = responseGet.getEntity();
        if (resEntityGet != null) {
                return  EntityUtils.toString(resEntityGet).trim();
        }
        } catch (ClientProtocolException e) {
            return "-1";
        } catch (IOException e) {
            return "-1";
        }
     return "-1";
    }
    
    public static String actualizarRespuestaIncidente(int IdRespuesta,int IdIncidente,String descripcion,int estado,byte[] foto) 
    {
    client = new DefaultHttpClient();
    HttpPost httppost = new HttpPost(url);
    
    try {
        List<NameValuePair> Value = new ArrayList<NameValuePair>(6);
        Value.add(new BasicNameValuePair("IdServicio","4"));
        Value.add(new BasicNameValuePair("IdRespuesta",""+IdRespuesta));
        Value.add(new BasicNameValuePair("IdIncidente",""+IdIncidente));
        Value.add(new BasicNameValuePair("descripcion",descripcion));
        Value.add(new BasicNameValuePair("estado",""+estado));
        if(foto!=null)
        Value.add(new BasicNameValuePair("foto",Base64.encodeToString(foto,Base64.NO_WRAP|Base64.URL_SAFE)));
        httppost.setEntity(new UrlEncodedFormEntity(Value));
        responseGet = client.execute(httppost);
        resEntityGet = responseGet.getEntity();
        if (resEntityGet != null) {
                return  EntityUtils.toString(resEntityGet).trim();
        }
        } catch (ClientProtocolException e) {
            return "-1";
        } catch (IOException e) {
            return "-1";
        }
     return "-1";
    }
    
    public static String cerrarSesionPersonalVehiculo(int IdSesion) 
    {
    client = new DefaultHttpClient();
    HttpPost httppost = new HttpPost(url);
    
    try {
        List<NameValuePair> Value = new ArrayList<NameValuePair>(2);
        Value.add(new BasicNameValuePair("IdServicio","5"));
        Value.add(new BasicNameValuePair("IdSesion",""+IdSesion));
        httppost.setEntity(new UrlEncodedFormEntity(Value));
        responseGet = client.execute(httppost);
        resEntityGet = responseGet.getEntity();
        if (resEntityGet != null) {
                return  EntityUtils.toString(resEntityGet).trim();
        }
        } catch (ClientProtocolException e) {
            return "-1";
        } catch (IOException e) {
            return "-1";
        }
     return "-1";
    }
    
    public static String insertarRecorridoSesionPersonalVehiculo(int IdSesion,double longitud,double latitud) 
    {
    client = new DefaultHttpClient();
    HttpPost httppost = new HttpPost(url);
    
    try {
        List<NameValuePair> Value = new ArrayList<NameValuePair>(4);
        Value.add(new BasicNameValuePair("IdServicio","6"));
        Value.add(new BasicNameValuePair("IdSesion",""+IdSesion));
        Value.add(new BasicNameValuePair("longitud",""+longitud));
        Value.add(new BasicNameValuePair("latitud",""+latitud));
        httppost.setEntity(new UrlEncodedFormEntity(Value));
        responseGet = client.execute(httppost);
        resEntityGet = responseGet.getEntity();
        if (resEntityGet != null) {
                return  EntityUtils.toString(resEntityGet).trim();
        }
        } catch (ClientProtocolException e) {
            return "-1";
        } catch (IOException e) {
            return "-1";
        }
     return "-1";
    }
       
}
