<%@page import="com.clsGestor"%>
<%@page import="java.util.Date"%>
<%@page import="entidades.*"%>
<%@page import="java.util.List"%>
<%
if(request.getParameter("IdServicio") != null && request.getParameter("IdServicio") != "" )
{ 
    int idServicio=Integer.parseInt(request.getParameter("IdServicio"));

   
    if(idServicio==1 && request.getParameter("dni") != null && request.getParameter("dni") != "" 
                && request.getParameter("clave") != null && request.getParameter("clave") != "" )
        {
            clsUsuario entidad=clsGestor.loginUsuario(request.getParameter("dni"),request.getParameter("clave"));
            if(entidad!=null)
            {
                String Datos="";
                     Datos=entidad.getInt_id_usuario()+"<parametro>"+
                     entidad.getStr_nombre()+"<parametro>"+
                     entidad.getStr_apellido()+"<parametro>"+
                     entidad.getStr_email()+"<parametro>"+
                     entidad.getStr_celular()+"<parametro>"+
                     entidad.getStr_dni()+"<parametro>"+
                     entidad.getDat_fecha_nacimiento().getTime()+"<parametro>"+
                     entidad.isBool_sexo()+"<parametro><objeto>";
                     
                     List<clsIncidente> listaIncidentes=clsGestor.listarXUsuarioIncidente(entidad.getInt_id_usuario());
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
                                    objeto.getObjTipoIncidente().getStr_nombre()+"<parametro><entidad>";
                         }

                     }
                     else
                         Datos+="0";   
                     
                     Datos+="<objeto>";
                      
                     out.print(Datos);
            }else
                out.print("0");
    }   
    else if(idServicio==2 && request.getParameter("nombre") != null && request.getParameter("nombre") != "" 
            && request.getParameter("apellido") != null && request.getParameter("apellido") != "" 
            && request.getParameter("email") != null && request.getParameter("email") != "" 
            && request.getParameter("celular") != null && request.getParameter("celular") != "" 
            && request.getParameter("dni") != null && request.getParameter("dni") != "" 
            && request.getParameter("sexo") != null && request.getParameter("sexo") != "" 
            && request.getParameter("nacimiento") != null && request.getParameter("nacimiento") != "" 
            && request.getParameter("clave") != null && request.getParameter("clave") != "" )
    {
        clsUsuario entidad = new clsUsuario();
        entidad.setBool_sexo(Boolean.parseBoolean(request.getParameter("sexo")));
        entidad.setDat_fecha_nacimiento(new Date(Long.parseLong(request.getParameter("nacimiento"))));
        entidad.setStr_apellido(request.getParameter("apellido"));
        entidad.setStr_celular(request.getParameter("celular"));
        entidad.setStr_clave(request.getParameter("clave"));
        entidad.setStr_dni(request.getParameter("dni"));
        entidad.setStr_email(request.getParameter("email"));
        entidad.setStr_nombre(request.getParameter("nombre"));
        
        int id=clsGestor.insertarUsuario(entidad);
        if(id>0)
            out.print(id);
        else
            out.print("0");
    }
     else if(idServicio==3 && request.getParameter("idUsuario") != null && request.getParameter("idUsuario") != "" 
            && request.getParameter("idTipo") != null && request.getParameter("idTipo") != "" 
            && request.getParameter("latitud") != null && request.getParameter("latitud") != "" 
            && request.getParameter("longitud") != null && request.getParameter("longitud") != "" 
            && request.getParameter("detalle") != null && request.getParameter("detalle") != "" )
    {
        clsIncidente entidad = new clsIncidente();
        entidad.setDou_latitud(Double.parseDouble(request.getParameter("latitud")));
        entidad.setDou_longitud(Double.parseDouble(request.getParameter("longitud")));
        entidad.setObjUsuario(new clsUsuario(Integer.parseInt(request.getParameter("idUsuario"))));
        entidad.setObjTipoIncidente(new clsTipoIncidente(Integer.parseInt(request.getParameter("idTipo"))));
        entidad.setStr_detalle(request.getParameter("detalle"));
         if(request.getParameter("foto") != null && request.getParameter("foto") != "")
            entidad.setByte_foto(clsGestor.getDecodeBase64(request.getParameter("foto")));
        int id=clsGestor.insertarIncidente(entidad);
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