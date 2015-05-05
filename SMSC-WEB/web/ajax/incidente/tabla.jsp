<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.clsGestor"%>
<%@page import="entidades.clsIncidente"%>
<%@page import="java.util.List"%>
<%
List<clsIncidente> list=clsGestor.listarIncidente();
if(list!=null)
{
    SimpleDateFormat d=new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat h=new SimpleDateFormat("HH:mm a");
%>
<div id="tabla">
<table id="lista" class="table table-striped table-bordered">
    <thead>
            <tr>
                    <th>Tipo de Incidente</th>
                    <th>Estado</th>
                    <th>Fecha</th>
                    <th>Hora</th>
                    <th>Descripción</th>
                    <th>Usuario</th>
                    <th>E-Mail</th>
            </tr>
    </thead> 
     <tbody>      
    <%
    for(clsIncidente entidad : list)
    {
    %>
                                                                   
        <tr>
            <td><%=entidad.getObjTipoIncidente().getStr_nombre()%></td>
            <td>
                <%
                    if(entidad.getInt_estado()==0)
                        out.print("Nuevo");
                    else if(entidad.getInt_estado()==1)
                        out.print("Por Atender");
                    else if(entidad.getInt_estado()==2)
                        out.print("Atendido");
                    else if(entidad.getInt_estado()==3)
                        out.print("Rechasado");
                %>
            </td>
            <td><%=d.format(entidad.getDat_fecha_registro())%></td>
              <td><%=h.format(entidad.getDat_fecha_registro())%></td>
              <td><%=entidad.getStr_detalle()%></td>
               <td><%=entidad.getObjUsuario().getStr_apellido()%><%=entidad.getObjUsuario().getStr_nombre()%></td>
                <td><%=entidad.getObjUsuario().getStr_email()%></td>
        
        </tr>


    <% }%>
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
                                                                        
                                                                       
                           