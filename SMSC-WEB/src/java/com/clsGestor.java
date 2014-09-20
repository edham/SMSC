/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com;

import dao.clsIncidenteDAO;
import dao.clsUsuarioDAO;
import entidades.clsIncidente;
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
      public static List<clsIncidente> listarXUsuarioIncidente(int IdUsuario) throws Exception 
    {
        return clsIncidenteDAO.listarXUsuario(IdUsuario);
    }
    
}
