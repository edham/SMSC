
<%@page import="entidades.clsVehiculo"%>
<%@page import="entidades.clsPersonal"%>
<%@page import="com.clsGestor"%>
<%  
clsPersonal objSession =(clsPersonal) request.getSession().getAttribute("SessionPersonal");
if(objSession!=null)
{
        if(request.getParameter("txtMarca") != null && request.getParameter("txtMarca") != "" &&
                request.getParameter("txtModelo") != null && request.getParameter("txtModelo") != "" &&
                request.getParameter("txtNPlaca") != null && request.getParameter("txtNPlaca") != "" &&
                request.getParameter("txtNumero") != null && request.getParameter("txtNumero") != "" )
        {
            clsVehiculo entidad = new clsVehiculo();
            entidad.setStr_marca(request.getParameter("txtMarca"));
            entidad.setStr_modelo(request.getParameter("txtModelo"));
            entidad.setStr_placa(request.getParameter("txtNPlaca"));
            entidad.setStr_numero(request.getParameter("txtNumero"));
             entidad.setInt_estado(0);
            if(request.getParameter("rbEstado").equals("0"))
                 entidad.setInt_estado(1);

            
            if(!request.getParameter("Id").equals("") && request.getParameter("Id") != null)
            {
                entidad.setInt_id_vehiculo(Integer.parseInt(request.getParameter("Id")));
                 if(clsGestor.actualizarVehiculo(entidad))
                     out.print(0);
                 else
                     out.print(-1);
            }
             else
             {
                 int id=clsGestor.insertarVehiculo(entidad);
                    if(id>0)
                        out.print(id);
                    else
                        out.print(-1);
             }
            
        }
}
 %>