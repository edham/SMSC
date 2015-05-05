<%@page import="com.clsGestor"%>
<%@page import="entidades.clsPersonal"%>
<%@page import="java.util.List"%>
<%
List<clsPersonal> list=clsGestor.listarxAsignar();
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
                <center> <a  data-dismiss="modal" href="javascript:void(0)" onclick="add_personal(<%=entidad.getInt_id_personal()%>)" class="comp_edit btn btn-primary btn-mini">Seleccionar</a></center> 
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
                                                                        
                                                                       
                           