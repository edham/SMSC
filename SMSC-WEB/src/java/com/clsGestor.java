/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com;

import dao.clsEstadisticaDAO;
import dao.clsIncidenteDAO;
import dao.clsPersonalDAO;
import dao.clsRecorridoSesionPersonalVehiculoDAO;
import dao.clsRespuestaIncidenteDAO;
import dao.clsSesionPersonalVehiculoDAO;
import dao.clsUsuarioDAO;
import entidades.clsEstadistica;
import entidades.clsIncidente;
import entidades.clsPersonal;
import entidades.clsRecorridoSesionPersonalVehiculo;
import entidades.clsRespuestaIncidente;
import entidades.clsSesionPersonalVehiculo;
import entidades.clsUsuario;
import java.util.List;

/**
 *
 * @author EdHam
 */
public class clsGestor {
    public static byte[] getDecodeBase64(String input)
    {    
       return Base64.decode(input,Base64.NO_WRAP|Base64.URL_SAFE);
    }

    public static String getEncodeBase64(byte[] input)
    {
        return Base64.encodeToString(input,Base64.NO_WRAP|Base64.URL_SAFE);
    }
    public static clsUsuario loginUsuario(String dni,String clave) throws Exception 
    {
        return clsUsuarioDAO.login(dni, clave);
    }
     public  static int insertarUsuario(clsUsuario entidad) throws Exception
    {
        return clsUsuarioDAO.insertar(entidad);
    }
      public static List<clsIncidente> listarXUsuarioIncidente(int IdUsuario) throws Exception 
    {
        return clsIncidenteDAO.listarXUsuario(IdUsuario);
    }
    public  static int insertarIncidente(clsIncidente entidad) throws Exception
    {
        return clsIncidenteDAO.insertar(entidad);
    }
     public static List<clsIncidente> listarXEstadoIncidente(int estado,int IdUsuario) throws Exception 
    {
        return clsIncidenteDAO.listarXEstado(estado, IdUsuario);
    }
     public static clsSesionPersonalVehiculo loginSesionPersonalVehiculo(String dni,String clave) throws Exception 
     {
         return clsSesionPersonalVehiculoDAO.login(dni, clave);
     }
     public  static int insertarRespuestaIncidente(clsRespuestaIncidente entidad) throws Exception
     {
         return clsRespuestaIncidenteDAO.insertar(entidad);
     }
     public static clsRespuestaIncidente pendienteRespuestaIncidente(int IdSesion) throws Exception 
     {
         return clsRespuestaIncidenteDAO.pendiente(IdSesion);
     }
     public static boolean actualizarRespuestaIncidente(clsRespuestaIncidente entidad) throws Exception
     {
        return clsRespuestaIncidenteDAO.actualizar(entidad);
     }
     public static boolean cerrarSesionPersonalVehiculo(int IdSesion) throws Exception
     {
         return clsSesionPersonalVehiculoDAO.cerrar(IdSesion);
     }
     public  static int insertarRecorridoSesionPersonalVehiculo(clsRecorridoSesionPersonalVehiculo entidad) throws Exception
     {
        return clsRecorridoSesionPersonalVehiculoDAO.insertar(entidad);
     }
      public static clsPersonal loginPersonal(String dni,String clave) throws Exception 
      {
          return clsPersonalDAO.login(dni, clave);
      }
      public static List<clsSesionPersonalVehiculo> activasSesionPersonalVehiculo() throws Exception 
      {
        return clsSesionPersonalVehiculoDAO.activas();
     }
      
       public static clsEstadistica getEstadistica() throws Exception 
    {
        return clsEstadisticaDAO.get();
    }
}
