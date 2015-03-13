<%@page import="entidades.clsProvincia"%>
<%@page import="java.util.List"%>
<%@page import="com.clsGestor"%>
<select id="cbProvincia" name="cbProvincia"  onchange="getDistrito(this.value)"  title="Por favor selecione una provincia!" required>
   <option value="">Selecione una Provincia</option>

<%
    if(request.getParameter("id") != null && request.getParameter("id") != "")
    {
        List<clsProvincia> list =clsGestor.listarProvinciaXDepartamento(Integer.parseInt(request.getParameter("id") ));
        if(list!=null)
     
            for(clsProvincia entidad : list)
                out.print("<option value='"+entidad.getInt_id_provincia()+"'>"+entidad.getStr_nombre()+"</option>");
          
    }
 %>
</select>