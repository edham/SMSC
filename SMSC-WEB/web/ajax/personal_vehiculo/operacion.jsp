
<%@page import="entidades.clsVehiculo"%>
<%@page import="entidades.clsPersonal"%>
<%@page import="com.clsGestor"%>
<%  
clsPersonal objSession =(clsPersonal) request.getSession().getAttribute("SessionPersonal");
if(objSession!=null)
{
        if(request.getParameter("id") != null && request.getParameter("id") != "" )
        {
            int id;
            if(request.getParameter("idPersona") != null && request.getParameter("idPersona") != "" )
                id=clsGestor.insertarDetallePersonalVehiculo(Integer.parseInt(request.getParameter("id")),Integer.parseInt(request.getParameter("idPersona")));
            else
                id=clsGestor.insertarPersonalVehiculo(Integer.parseInt(request.getParameter("id")));
                 
                    if(id>0)
                        out.print(id);
                    else
                        out.print(0);
            
        }
}
 %>