<%@page import="com.clsGestor"%>
<%@page import="entidades.clsVehiculo"%>
<%@page import="java.util.List"%>
<%
List<clsVehiculo> list=clsGestor.listarxXAsignarVehiculo();
if(list!=null)
{
    
%>
<div id="tablaVehiculo">
<table id="listaVehiculo" class="table table-striped table-bordered">
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
                <center> <a data-dismiss="modal" href="javascript:void(0)" onclick="add_vehiculo(<%=entidad.getInt_id_vehiculo()%>)" 
                            class="comp_edit btn btn-primary btn-mini">Agregar</a></center> 
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

   $('listaVehiculo').dataTable({
        "sPaginationType": "bootstrap",
        "sScrollY": "90px",
        "bDestroy": true,
        "bDeferRender": true
        }); 
 
});
</script>

<%}%>  
                                                                        
                                                                       
                           