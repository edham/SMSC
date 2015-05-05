<%@page import="entidades.clsDetallePersonalVehiculo"%>
<%@page import="com.clsGestor"%>
<%@page import="entidades.clsPersonalVehiculo"%>
<%@page import="java.util.List"%>
<%
List<clsPersonalVehiculo> list=clsGestor.listarPersonalVehiculo(false);
if(list!=null)
{
    
%>
<div id="tabla">
    <center><a href="#ModalVehiculo" onclick="tablaVehiculo()" class="comp_edit btn btn-info"  data-toggle="modal">Agregar Vehiculo</a></center>
                              
					
<table id="lista" class="table table-striped table-bordered">
    <thead>
            <tr>
                    <th>Marca</th>
                    <th>Modelo</th>
                    <th>Placa</th>
                    <th>N° Vehiculo</th>
                    <th>Personal</th>
            </tr>
    </thead> 
     <tbody>      
    <%
    for(clsPersonalVehiculo entidad : list)
    {
    %>
                                                                   
        <tr>
            <td><%=entidad.getObjVehiculo().getStr_marca()%></td>
            <td><%=entidad.getObjVehiculo().getStr_modelo()%></td>
            <td><%=entidad.getObjVehiculo().getStr_placa()%></td>
            <td> <center><%=entidad.getObjVehiculo().getStr_numero()%> </center></td>
            <td>
                 <center><a href="#ModalPersonal" onclick="tablaPersonal(<%=entidad.getInt_id_personal_vehiculo()%>)" class="comp_edit btn btn-primary"  data-toggle="modal">Agregar Personal</a></center>
    
                <table class="table table-striped table-bordered">
                    <thead>
                            <tr>
                                    <th>DNI</th>
                                    <th>Nombres</th>
                                    <th>Email</th>
                                    <th>Acciones</th>
                            </tr>
                    </thead> 
                     <tbody>
                          <%
                            if(entidad.getLista()!=null)
                            for(clsDetallePersonalVehiculo detalle : entidad.getLista())
                            {
                            %>
                             <tr>
                                    <th><%=detalle.getObjPersonal().getStr_dni()%></th>
                                    <th><%=detalle.getObjPersonal().getStr_apellido_paterno()%> <%=detalle.getObjPersonal().getStr_apellido_materno()%> <%=detalle.getObjPersonal().getStr_nombre()%></th>
                                    <th><%=detalle.getObjPersonal().getStr_dni()%></th>
                                    
                                    <th>  <center> <a href="javascript:void(0)" onclick="quitar_personal(<%=detalle.getId_detalle_personal_vehiculo()%>)" 
                            class="comp_edit btn btn-danger btn-mini">Quitar</a></center> </th>
                             </tr>
                               
                            <%
                            }
                            %>
                        
                     </tbody>
                </table>
               
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
        "sScrollY": "400px",
        "bDestroy": true,
        "bDeferRender": true
        }); 
 
});
</script>

<%}%>  
                                                                        
                                                                       
                           