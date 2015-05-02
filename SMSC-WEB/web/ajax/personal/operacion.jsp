
<%@page import="sun.misc.BASE64Decoder"%>
<%@page import="java.util.Date"%>
<%@page import="entidades.clsDistrito"%>
<%@page import="entidades.clsTipoPersonal"%>
<%@page import="entidades.clsPersonal"%>
<%@page import="com.clsGestor"%>
<%  
clsPersonal objSession =(clsPersonal) request.getSession().getAttribute("SessionPersonal");
if(objSession!=null)
{
        if(request.getParameter("txtNombres") != null && request.getParameter("txtNombres") != "" &&
                request.getParameter("txtAPaterno") != null && request.getParameter("txtAPaterno") != "" &&
                request.getParameter("txtAMaterno") != null && request.getParameter("txtAMaterno") != "" &&
                request.getParameter("txtDNI") != null && request.getParameter("txtDNI") != "" &&
                request.getParameter("txtTelefono") != null && request.getParameter("txtTelefono") != "" &&
                request.getParameter("txtCelular") != null && request.getParameter("txtCelular") != "" &&
                request.getParameter("txtClave") != null && request.getParameter("txtClave") != "" &&
                request.getParameter("txtEmail") != null && request.getParameter("txtEmail") != "" &&
                request.getParameter("txtFoto") != null && request.getParameter("txtFoto") != "" &&
                request.getParameter("txtDireccion") != null && request.getParameter("txtDireccion") != "" &&
                request.getParameter("cbTipoPersonal") != null && request.getParameter("cbTipoPersonal") != "" &&
                request.getParameter("cbDistrito") != null && request.getParameter("cbDistrito") != "" &&
                request.getParameter("txtFNacimiento") != null && request.getParameter("txtFNacimiento") != "" )
        {                       
            clsPersonal entidad = new clsPersonal();
            entidad.setStr_nombre(request.getParameter("txtNombres"));
            entidad.setStr_apellido_paterno(request.getParameter("txtAPaterno"));
            entidad.setStr_apellido_materno(request.getParameter("txtAMaterno"));
            entidad.setStr_dni(request.getParameter("txtDNI"));
            entidad.setStr_telefono(request.getParameter("txtTelefono"));
            entidad.setStr_celular(request.getParameter("txtCelular"));
            entidad.setStr_email(request.getParameter("txtEmail"));
            entidad.setStr_clave(request.getParameter("txtClave"));
            entidad.setStr_direccion(request.getParameter("txtDireccion"));
            entidad.setObjTipoPersonal(new clsTipoPersonal(Integer.parseInt(request.getParameter("cbTipoPersonal"))));
            entidad.setObjDistrito(new clsDistrito(Integer.parseInt(request.getParameter("cbDistrito")))); 
            entidad.setDat_fecha_nacimiento(new Date(request.getParameter("txtFNacimiento")));
            
            String foto=request.getParameter("txtFoto");
            foto=foto.replace("data:image/png;base64,", "");
            BASE64Decoder decoder = new BASE64Decoder();
            entidad.setByte_foto(decoder.decodeBuffer(foto));
             entidad.setInt_estado(0);
            if(request.getParameter("rbEstado").equals("0"))
                 entidad.setInt_estado(1);

            
            if(!request.getParameter("Id").equals("") && request.getParameter("Id") != null)
            {
                entidad.setInt_id_personal(Integer.parseInt(request.getParameter("Id")));
                 if(clsGestor.actualizarPersonal(entidad))
                     out.print(0);
                 else
                     out.print(-1);
            }
             else
             {
                 int id=clsGestor.insertarPersonal(entidad);
                    if(id>0)
                        out.print(id);
                    else
                        out.print(-1);
             }
            
        }
}
 %>