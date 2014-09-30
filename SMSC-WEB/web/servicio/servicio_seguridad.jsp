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
                        objeto.getObjUsuario().isBool_sexo()+"<parametro><entidad>";
             }

         }
         else
             Datos+="0";   


         out.print(Datos);
    }   

    else
        out.print("0");
}
else
    out.print("0");
%>