<%@page import="com.clsGestor"%>
<%@page import="entidades.clsVehiculo"%>
<%@page import="java.util.List"%>
<%
List<clsVehiculo> list=clsGestor.listarVehiculo(false);
if(list!=null)
{
    
%>
<div id="tabla">
<table id="lista" class="table table-striped table-bordered">
    <thead>
            <tr>
                    <th>Marca</th>
                    <th>Modelo</th>
                    <th>Placa</th>
                    <th>N° Vehiculo</th>
                    <th>Estado</th>
                    <th>Acciones</th>
            </tr>
    </thead> 
     <tbody>      
    <%
    for(clsVehiculo entidad : list)
    {
    %>
                                                                   
        <tr>
            <td><%=entidad.getStr_marca()%></td>
            <td><%=entidad.getStr_modelo()%></td>
            <td><%=entidad.getStr_placa()%></td>
            <td> <center><%=entidad.getStr_numero()%> </center></td>
            <td>
                 <%
                   if(entidad.getInt_estado()==0)
                   out.print("<center> <span class='label label-success'>Activo</span></center>");
                   else
                       out.print("<center> <span class='label label-important'>Inactivo</span></center>");
                %>


            </td>
            <td>
                <center> <a href="javascript:void(0)" onclick="edit_form(<%=entidad.getInt_id_vehiculo()%>,
                            '<%=entidad.getStr_marca()%>','<%=entidad.getStr_modelo()%>','<%=entidad.getStr_placa()%>',
                            '<%=entidad.getStr_numero()%>',<%=entidad.getInt_estado()%>)" 
                            class="comp_edit btn btn-primary btn-mini">Editar</a></center> 
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
        "sScrollY": "120px",
        "bDestroy": true,
        "bDeferRender": true
        }); 
 
});
</script>

<%}%>  
                                                                        
                                                                       
                           