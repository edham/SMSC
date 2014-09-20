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
        if(request.getParameter("dni") != null && request.getParameter("dni") != "" 
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
        }else
            out.print("0");
    }   
   
}
else
    out.print("0");
%>