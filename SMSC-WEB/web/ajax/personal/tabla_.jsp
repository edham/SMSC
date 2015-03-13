<%@page import="com.clsGestor"%>
<%@page import="entidades.clsPersonal"%>
<%@page import="java.util.List"%>
<%
List<clsPersonal> list=clsGestor.listarPersonal(true);
if(list!=null)
{    
%>
<div id="tablaPersonal">
<table id="listaPersonal" class="table table-striped table-bordered">
    <thead>
            <tr>
                    <th>Nombres</th>
                    <th>Apellidos</th>
                    <th>DNI</th>                   
                    <th>Acciones</th>
            </tr>
    </thead> 
     <tbody>      
    <%
    for(clsPersonal entidad : list)
    {
    %>
                                                                   
        <tr>
            <td><%=entidad.getStr_nombre()%></td>
            <td><%=entidad.getStr_apellido_paterno()%> <%=entidad.getStr_apellido_materno()%></td>
            <td><%=entidad.getStr_dni()%></td>

            <td>
                <center> <a href="javascript:void(0)" onclick="edit_form(<%=entidad.getInt_id_personal()%>,
                            '<%=entidad.getStr_nombre()%>','<%=entidad.getStr_apellido_materno()%>','<%=entidad.getStr_apellido_paterno()%>',
                            '<%=entidad.getStr_dni()%>',<%=entidad.getObjTipoPersonal().getInt_id_tipo_personal()%>,
                            <%=entidad.getObjDistrito().getObjProvincia().getObjDepartamento().getInt_id_departamento()%>,
                            <%=entidad.getObjDistrito().getObjProvincia().getInt_id_provincia()%>,<%=entidad.getObjDistrito().getInt_id_distrito()%>,
                            '<%=entidad.getStr_telefono()%>','<%=entidad.getStr_celular()%>','<%=entidad.getStr_email()%>','<%=entidad.getStr_direccion()%>',
                            <%=entidad.getInt_estado()%>)" class="comp_edit btn btn-primary btn-mini">Seleccionar</a></center> 
            </td>
        </tr>


    <%
    }
    %>
     </tbody>
    </table>
</div>
<script type="text/javascript">
$(function () { 

   $('#listaPersonal').dataTable({
        "sPaginationType": "bootstrap",
        "sScrollY": "90px",
        "bDestroy": true,
        "bDeferRender": true
        }); 
 
});
</script>

<%}%>  
                                                                        
                                                                       
                           