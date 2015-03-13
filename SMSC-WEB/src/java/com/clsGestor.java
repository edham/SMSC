/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com;


import dao.*;
import entidades.*;

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
    public static boolean calificarIncidente(clsIncidente entidad) throws Exception
    {
      return clsIncidenteDAO.calificar(entidad);
    }

    public static List<clsPersonal> listarPersonal(boolean estado) throws Exception
    {
      return clsPersonalDAO.listar(estado);
    }
    
    public  static int insertarPersonal(clsPersonal entidad) throws Exception
    {
      return clsPersonalDAO.insertar(entidad);
    }
    
     public static boolean actualizarPersonal(clsPersonal entidad) throws Exception
    {
      return clsPersonalDAO.actualizar(entidad);
    }
     
      public static List<clsTipoPersonal> listarTipoPersonal() throws Exception 
     {
      return clsTipoPersonalDAO.listar();
    }
      
      
       public static List<clsDepartamento> listarDepartamento() throws Exception
       {
           return clsDepartamentoDAO.listarDepartamento();
       }
     public static List<clsDistrito> listarDistritoXProvincia(int IdProvincia) throws Exception
     {
         return clsDistritoDAO.listarDistritoXProvincia(IdProvincia);
     }
     public static List<clsProvincia> listarProvinciaXDepartamento(int IdDepartamento) throws Exception
     {
         return clsProvinciaDAO.listarProvinciaXDepartamento(IdDepartamento);
     }
     public static clsDistrito buscarIdProvincia (int idDistrito) throws Exception
     {
         return clsDistritoDAO.buscarId(idDistrito);
     }
     
     
    
    
    public  static int insertarVehiculo(clsVehiculo entidad) throws Exception
    {
      return clsVehiculoDAO.insertar(entidad);
    }
    
     public static boolean actualizarVehiculo(clsVehiculo entidad) throws Exception
    {
      return clsVehiculoDAO.actualizar(entidad);
    }
     
    public static List<clsVehiculo> listarVehiculo(boolean estado) throws Exception
    {
      return clsVehiculoDAO.listar(estado);
    }
     
     
}
