<%@page import="com.clsGestor"%>
<%@page import="java.util.Date"%>
<%@page import="entidades.*"%>
<%@page import="java.util.List"%>
<%
if(request.getParameter("IdServicio") != null && request.getParameter("IdServicio") != "" )
{ 
    int idServicio=Integer.parseInt(request.getParameter("IdServicio"));

   
    if(idServicio==1)
    {
         String Datos="";   
         List<clsIncidente> listaIncidentes=clsGestor.listarXEstadoIncidente(0,0);
         if(listaIncidentes!=null)
         {
             for(clsIncidente objeto : listaIncidentes)
             {
                Datos+=objeto.getInt_id_incidente()+"<parametro>"+
                        objeto.getDou_latitud()+"<parametro>"+
                        objeto.getDou_longitud()+"<parametro>"+
                        objeto.getStr_detalle()+"<parametro>"+
                        objeto.getDat_fecha_registro().getTime()+"<parametro>"+
                        objeto.getInt_estado()+"<parametro>";
                        if(objeto.getByte_foto()==null)
                            Datos+="0<parametro>";
                        else
                             Datos+=clsGestor.getEncodeBase64(objeto.getByte_foto())+"<parametro>";
                        Datos+=objeto.getObjTipoIncidente().getInt_id_tipo_incidente()+"<parametro>"+
                        objeto.getObjTipoIncidente().getStr_nombre()+"<parametro>"+
                        objeto.getObjUsuario().getInt_id_usuario()+"<parametro>"+
                        objeto.getObjUsuario().getStr_nombre()+"<parametro>"+
                        objeto.getObjUsuario().getStr_apellido()+"<parametro>"+
                        objeto.getObjUsuario().getStr_celular()+"<parametro>"+
                        objeto.getObjUsuario().getStr_dni()+"<parametro>"+
                        objeto.getObjUsuario().getStr_email()+"<parametro>"+
                        objeto.getObjUsuario().getDat_fecha_nacimiento().getTime()+"<parametro>"+
                        objeto.getObjUsuario().isBool_sexo()+"<parametro>0<parametro><entidad>";
             }

         }
         else
             Datos+="0";   


         out.print(Datos);
    }   
    else if(idServicio==2 && request.getParameter("dni") != null && request.getParameter("dni") != "" 
                && request.getParameter("clave") != null && request.getParameter("clave") != "" )
        {
            clsSesionPersonalVehiculo entidad=clsGestor.loginSesionPersonalVehiculo(request.getParameter("dni"),request.getParameter("clave"));
            
            if(entidad!=null)
            {
                String Datos="";
                     Datos=entidad.getInt_sesion_personal_vehiculo()+"<parametro>"+
                     entidad.getDat_fecha_entrada().getTime()+"<parametro>"+
                     entidad.getObjPersonalVehiculo().getObjVehiculo().getStr_marca()+"<parametro>"+
                     entidad.getObjPersonalVehiculo().getObjVehiculo().getStr_modelo()+"<parametro>"+
                     entidad.getObjPersonalVehiculo().getObjVehiculo().getStr_placa()+"<parametro>"+
                     entidad.getObjPersonalVehiculo().getObjVehiculo().getStr_numero()+"<parametro><objeto>";
              
                     if( entidad.getObjPersonalVehiculo().getLista()!=null)
                     {
                         for(clsDetallePersonalVehiculo objeto : entidad.getObjPersonalVehiculo().getLista())
                         {
                            Datos+=objeto.getObjPersonal().getInt_id_personal()+"<parametro>"+
                                    objeto.getObjPersonal().getStr_nombre()+"<parametro>"+
                                    objeto.getObjPersonal().getStr_apellido_paterno()+"<parametro>"+
                                    objeto.getObjPersonal().getStr_apellido_materno()+"<parametro>"+
                                    objeto.getObjPersonal().getStr_dni()+"<parametro>"+
                                    objeto.getObjPersonal().getInt_puntos()+"<parametro>";
                                    if(objeto.getObjPersonal().getByte_foto()==null)
                                        Datos+="0<parametro>";
                                    else
                                         Datos+=clsGestor.getEncodeBase64(objeto.getObjPersonal().getByte_foto())+"<parametro>";
                                    Datos+=objeto.getObjPersonal().getDat_fecha_nacimiento().getTime()+"<parametro>"+
                                    objeto.getObjPersonal().getObjDistrito().getStr_nombre()+"<parametro>"+
                                    objeto.getObjPersonal().getObjTipoPersonal().getStr_nombre()+"<parametro><entidad>";
                         }

                     }
                     else
                         Datos+="0";   
                     
                     Datos+="<objeto>";
                     
                     clsRespuestaIncidente objRespuestaIncidente =clsGestor.pendienteRespuestaIncidente(entidad.getInt_sesion_personal_vehiculo());
                     if(objRespuestaIncidente!=null)
                     {
                        Datos+=objRespuestaIncidente.getObjIncidente().getInt_id_incidente()+"<parametro>"+
                        objRespuestaIncidente.getObjIncidente().getDou_latitud()+"<parametro>"+
                        objRespuestaIncidente.getObjIncidente().getDou_longitud()+"<parametro>"+
                        objRespuestaIncidente.getObjIncidente().getStr_detalle()+"<parametro>"+
                        objRespuestaIncidente.getObjIncidente().getDat_fecha_registro().getTime()+"<parametro>"+
                        objRespuestaIncidente.getObjIncidente().getInt_estado()+"<parametro>";
                        if(objRespuestaIncidente.getObjIncidente().getByte_foto()==null)
                            Datos+="0<parametro>";
                        else
                             Datos+=clsGestor.getEncodeBase64(objRespuestaIncidente.getObjIncidente().getByte_foto())+"<parametro>";
                        Datos+=objRespuestaIncidente.getObjIncidente().getObjTipoIncidente().getInt_id_tipo_incidente()+"<parametro>"+
                        objRespuestaIncidente.getObjIncidente().getObjTipoIncidente().getStr_nombre()+"<parametro>"+
                        objRespuestaIncidente.getObjIncidente().getObjUsuario().getInt_id_usuario()+"<parametro>"+
                        objRespuestaIncidente.getObjIncidente().getObjUsuario().getStr_nombre()+"<parametro>"+
                        objRespuestaIncidente.getObjIncidente().getObjUsuario().getStr_apellido()+"<parametro>"+
                        objRespuestaIncidente.getObjIncidente().getObjUsuario().getStr_celular()+"<parametro>"+
                        objRespuestaIncidente.getObjIncidente().getObjUsuario().getStr_dni()+"<parametro>"+
                        objRespuestaIncidente.getObjIncidente().getObjUsuario().getStr_email()+"<parametro>"+
                        objRespuestaIncidente.getObjIncidente().getObjUsuario().getDat_fecha_nacimiento().getTime()+"<parametro>"+
                        objRespuestaIncidente.getObjIncidente().getObjUsuario().isBool_sexo()+"<parametro>"+
                        objRespuestaIncidente.getInt_id_respuesta_incidente()+"<parametro><objeto>";
                
                     }
                     else
                      Datos+="0<objeto>";
                     
                     out.print(Datos);
            }else
                out.print("0");
    }
    else if(idServicio==3 && request.getParameter("IdSession") != null && request.getParameter("IdSession") != "" 
                && request.getParameter("IdIncidente") != null && request.getParameter("IdIncidente") != "" )
    {
        clsRespuestaIncidente entidad = new clsRespuestaIncidente();
        entidad.setObjSesionPersonalVehiculo(new clsSesionPersonalVehiculo(Integer.parseInt(request.getParameter("IdSession"))));
        entidad.setObjIncidente(new clsIncidente(Integer.parseInt(request.getParameter("IdIncidente"))));
        int id=clsGestor.insertarRespuestaIncidente(entidad);
        if(id>0)
            out.print(id);
        else
            out.print("0");
            
    }
    else if(idServicio==4 && request.getParameter("IdRespuesta") != null && request.getParameter("IdRespuesta") != "" 
            && request.getParameter("IdIncidente") != null && request.getParameter("IdIncidente") != "" 
            && request.getParameter("descripcion") != null && request.getParameter("descripcion") != "" 
            && request.getParameter("estado") != null && request.getParameter("estado") != "" )
    {
        clsRespuestaIncidente entidad = new clsRespuestaIncidente();
        entidad.setInt_id_respuesta_incidente(Integer.parseInt(request.getParameter("IdRespuesta")));
        entidad.setObjIncidente(new clsIncidente(Integer.parseInt(request.getParameter("IdIncidente"))));
        entidad.setStr_descripccion(request.getParameter("descripcion"));
        entidad.setInt_estado(Integer.parseInt(request.getParameter("estado")));
        
         if(request.getParameter("foto") != null && request.getParameter("foto") != "")
            entidad.setByte_foto(clsGestor.getDecodeBase64(request.getParameter("foto")));
         
        if(clsGestor.actualizarRespuestaIncidente(entidad))
            out.print("1");
        else
            out.print("0");
    }
    else if(idServicio==5 && request.getParameter("IdSesion") != null && request.getParameter("IdSesion") != "")
    {       
        if(clsGestor.cerrarSesionPersonalVehiculo(Integer.parseInt(request.getParameter("IdSesion"))))
            out.print("1");
        else
            out.print("0");
    }
    else if(idServicio==6 && request.getParameter("IdSesion") != null && request.getParameter("IdSesion") != "" 
            && request.getParameter("longitud") != null && request.getParameter("longitud") != "" 
            && request.getParameter("latitud") != null && request.getParameter("latitud") != "")
    {
        clsRecorridoSesionPersonalVehiculo entidad = new clsRecorridoSesionPersonalVehiculo();
        entidad.setInt_id_sesion_personal_vehiculo(Integer.parseInt(request.getParameter("IdSesion")));
        entidad.setDou_latitud(Double.parseDouble(request.getParameter("latitud")));
        entidad.setDou_longitud(Double.parseDouble(request.getParameter("longitud")));
        
        int id = clsGestor.insertarRecorridoSesionPersonalVehiculo(entidad);
        if(id>0)
            out.print(id);
        else
            out.print("0");
    }
    else
        out.print("0");
}
else
    out.print("0");
%>