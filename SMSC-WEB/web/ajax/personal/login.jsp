
<%@page import="com.clsGestor"%>
<%@page import="entidades.clsPersonal"%>
<%  
    if( request.getParameter("username") != null && request.getParameter("username") != "" &&
            request.getParameter("password") != null && request.getParameter("password") != "")
    {
      clsPersonal objPersonal= clsGestor.loginPersonal(request.getParameter("username"), request.getParameter("password"));
        if(objPersonal!=null)
        {                 
                HttpSession sesion = request.getSession();
                sesion.setAttribute("SessionPersonal", objPersonal); 
                sesion.setMaxInactiveInterval(-1);
                out.print(1); 
        }  
        else
           out.print(0);
    }
    else
        out.print(-1);
 %>