<%@page import="entidades.clsTipoPersonal"%>
<%@page import="com.clsGestor"%>
<%@page import="java.util.List"%>
<select id="cbTipoPersonal" name="cbTipoPersonal" title="Selecione un Tipo de Personal!" required>                               
   <option value="">Selecione un Tipo Personal</option>
<%
    List<clsTipoPersonal> list=clsGestor.listarTipoPersonal();
    if(list!=null)
        for(clsTipoPersonal entidad : list)
            out.print("<option value='"+entidad.getInt_id_tipo_personal()+"'>"+entidad.getStr_nombre()+"</option>");
 %>
</select>