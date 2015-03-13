<%@page import="entidades.clsDistrito"%>
<%@page import="java.util.List"%>
<%@page import="com.clsGestor"%>
<select id="cbDistrito" name="cbDistrito" title="Por favor selecione una provincia!" required>
   <option value="">Selecione un Distrito</option>
<%
    if(request.getParameter("id") != null && request.getParameter("id") != "")
    {
        List<clsDistrito> list =clsGestor.listarDistritoXProvincia(Integer.parseInt(request.getParameter("id") ));
        if(list!=null)
     
            for(clsDistrito entidad : list)
                out.print("<option value='"+entidad.getInt_id_distrito()+"'>"+entidad.getStr_nombre()+"</option>"); 
    }
 %>
</select>