/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smsc.usuario.conexion;

import android.util.Base64;
import com.smsc.usuario.entidades.clsIncidente;
import com.smsc.usuario.entidades.clsUsuario;
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

    private static String url="http://192.168.1.5:8084/servicio/servicio_usuario.jsp";
    private static HttpClient client;
    private static HttpResponse responseGet;
    private static HttpEntity resEntityGet;
    


    public static String loginUsuario(String dni,String clave) 
    {
    client = new DefaultHttpClient();
    HttpPost httppost = new HttpPost(url);

    try {
        List<NameValuePair> Value = new ArrayList<NameValuePair>(3);
        Value.add(new BasicNameValuePair("IdServicio","1"));
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

    public static String insertarUsuario(clsUsuario entidad) 
    {
    client = new DefaultHttpClient();
    HttpPost httppost = new HttpPost(url);

    try {
        List<NameValuePair> Value = new ArrayList<NameValuePair>(9);
        Value.add(new BasicNameValuePair("IdServicio","2"));
        Value.add(new BasicNameValuePair("nombre",entidad.getStr_nombre()));
        Value.add(new BasicNameValuePair("apellido",entidad.getStr_apellido()));
        Value.add(new BasicNameValuePair("email",entidad.getStr_dni()));
        Value.add(new BasicNameValuePair("celular",entidad.getStr_celular()));
        Value.add(new BasicNameValuePair("dni",entidad.getStr_dni()));
        Value.add(new BasicNameValuePair("sexo",""+entidad.isBool_sexo()));
        Value.add(new BasicNameValuePair("nacimiento",""+entidad.getDat_fecha_nacimiento().getTime()));
        Value.add(new BasicNameValuePair("clave",entidad.getStr_clave()));
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
       public static String insertarIncidente(clsIncidente entidad) 
    {
    client = new DefaultHttpClient();
    HttpPost httppost = new HttpPost(url);
    
    try {
        List<NameValuePair> Value = new ArrayList<NameValuePair>(6);
        Value.add(new BasicNameValuePair("IdServicio","3"));
        Value.add(new BasicNameValuePair("idUsuario",""+entidad.getInt_id_usuario()));
        Value.add(new BasicNameValuePair("idTipo",""+entidad.getInt_id_tipo_incidente()));
        Value.add(new BasicNameValuePair("latitud",""+entidad.getDou_latitud()));
        Value.add(new BasicNameValuePair("longitud",""+entidad.getDou_longitud()));
        Value.add(new BasicNameValuePair("detalle",entidad.getStr_detalle()));
        if(entidad.getByte_foto()!=null)
        Value.add(new BasicNameValuePair("foto",Base64.encodeToString(entidad.getByte_foto(),Base64.NO_WRAP|Base64.URL_SAFE)));
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
