<%@page import="com.clsGestor"%>
<%@page import="entidades.clsVehiculo"%>
<%@page import="java.util.List"%>
<%
List<clsVehiculo> list=clsGestor.listarVehiculo(true);
if(list!=null)
{
    
%>
<div id="tablaVehiculo">
<table id="lista" class="table table-striped table-bordered">
    <thead>
            <tr>
                    <th>Placa</th>
                    <th>N° Vehiculo</th>
                    <th>Acciones</th>
            </tr>
    </thead> 
     <tbody>      
    <%
    for(clsVehiculo entidad : list)
    {
    %>
                                                                   
        <tr>
            <td><%=entidad.getStr_placa()%></td>
            <td> <center><%=entidad.getStr_numero()%> </center></td>
            
            <td>
                <center> <a href="javascript:void(0)" onclick="edit_form(<%=entidad.getInt_id_vehiculo()%>,
                            '<%=entidad.getStr_marca()%>','<%=entidad.getStr_modelo()%>','<%=entidad.getStr_placa()%>',
                            '<%=entidad.getStr_numero()%>',<%=entidad.getInt_estado()%>)" 
                            class="comp_edit btn btn-primary btn-mini">Seleccionar</a></center> 
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
        "sScrollY": "90px",
        "bDestroy": true,
        "bDeferRender": true
        }); 
 
});
</script>

<%}%>  
                                                                        
                                                                       
                           