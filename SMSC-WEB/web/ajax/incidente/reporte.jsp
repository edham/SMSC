<%@page import="com.clsGestor"%>
<%@page import="entidades.clsIncidente"%>
<%@page import="entidades.clsPersonal"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%
 clsPersonal objSession =(clsPersonal) request.getSession().getAttribute("SessionPersonal");
if(objSession!=null)
{
    SimpleDateFormat e=new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat fecha=new SimpleDateFormat("dd - MM - yyyy : HH:mm a");

List<clsIncidente> list=clsGestor.listarIncidente();
if(list!=null)
{
    SimpleDateFormat d=new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat h=new SimpleDateFormat("HH:mm a");
%>
<%response.setHeader("Content-Disposition", "attachment; filename=\"Reporte de Incidentes "+e.format(new Date())+".xls\"");%>
<center><h1>REPORTE DE INCIDENTES </h1></center>

<table border='1'>
    <thead>
            <tr>
                    <td><center> <strong>Tipo de Incidente</strong> </center></td>
                    <td><center> <strong>Estado</strong> </center></td>
                    <td><center> <strong>Fecha</strong> </center></td>
                    <td><center> <strong>Hora</strong> </center></td>
                    <td><center> <strong>Descripción</strong> </center></td>
                    <td><center> <strong>Usuario</strong> </center></td>
                    <td><center> <strong>E-Mail</strong> </center></td>
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


<%out.print(objSession.getStr_apellido_paterno()+" "+objSession.getStr_apellido_materno()+", "+objSession.getStr_nombre()+" "+fecha.format(new Date())); %>
<%} }%>  
           