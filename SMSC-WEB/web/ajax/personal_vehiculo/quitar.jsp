
<%@page import="entidades.clsVehiculo"%>
<%@page import="entidades.clsPersonal"%>
<%@page import="com.clsGestor"%>
<%  
clsPersonal objSession =(clsPersonal) request.getSession().getAttribute("SessionPersonal");
if(objSession!=null)
{
        if(request.getParameter("id") != null && request.getParameter("id") != "" )
        {
                 
                    if(clsGestor.quitarDetallePersonalVehiculo(Integer.parseInt(request.getParameter("id"))))
                        out.print(1);
                    else
                        out.print(0);
            
        }
}
 %>