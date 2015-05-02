<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.clsGestor"%>
<%@page import="entidades.clsPersonal"%>
<%@page import="java.util.List"%>
<%
List<clsPersonal> list=clsGestor.listarPersonal(false);
if(list!=null)
{
    SimpleDateFormat e=new SimpleDateFormat("dd/MM/yyyy");
%>
<div id="tabla">
<table id="lista" class="table table-striped table-bordered">
    <thead>
            <tr>
                    <th>Nombres</th>
                    <th>Apellidos</th>
                    <th>DNI</th>
                    <th>EMail</th>
                    <th>Telefono</th>
                    <th>Celular</th>
                    <th>Estado</th>
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
             <td><%=entidad.getStr_email()%></td>
              <td><%=entidad.getStr_telefono()%></td>
               <td><%=entidad.getStr_celular()%></td>
            <td>
                 <%
                   if(entidad.getInt_estado()==0)
                   out.print("<center> <span class='label label-success'>Activo</span></center>");
                   else
                       out.print("<center> <span class='label label-important'>Inactivo</span></center>");
                %>


            </td>
            <td>
                <center> <a href="javascript:void(0)" onclick="edit_form(<%=entidad.getInt_id_personal()%>,
                            '<%=entidad.getStr_nombre()%>','<%=entidad.getStr_apellido_materno()%>','<%=entidad.getStr_apellido_paterno()%>',
                            '<%=entidad.getStr_dni()%>',<%=entidad.getObjTipoPersonal().getInt_id_tipo_personal()%>,
                            <%=entidad.getObjDistrito().getObjProvincia().getObjDepartamento().getInt_id_departamento()%>,
                            <%=entidad.getObjDistrito().getObjProvincia().getInt_id_provincia()%>,<%=entidad.getObjDistrito().getInt_id_distrito()%>,
                            '<%=entidad.getStr_telefono()%>','<%=entidad.getStr_celular()%>','<%=entidad.getStr_email()%>','<%=entidad.getStr_direccion()%>',
                            '<%=e.format(entidad.getDat_fecha_nacimiento())%>','<%=entidad.getStr_clave()%>',<%=entidad.getInt_estado()%>)" class="comp_edit btn btn-primary btn-mini">Editar</a></center> 
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

   $('#lista').dataTable({
        "sPaginationType": "bootstrap",
        "sScrollY": "390px",
        "bDestroy": true,
        "bDeferRender": true
        }); 
 
});
</script>

<%}%>  
                                                                        
                                                                       
                           