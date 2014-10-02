
<%@page import="entidades.clsDetallePersonalVehiculo"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="sun.misc.BASE64Encoder"%>
<%@page import="com.clsGestor"%>
<%@page import="entidades.clsSesionPersonalVehiculo"%>
<%@page import="java.util.List"%>
<div id="mapa">
<%
List<clsSesionPersonalVehiculo> lista=  clsGestor.activasSesionPersonalVehiculo();
if(lista!=null)
{
    BASE64Encoder e = new BASE64Encoder();
    SimpleDateFormat fecha=new SimpleDateFormat("dd/MM/yyyy : HH:mm a");
    int size=lista.size();
    int validos=0;
    int invalidos=0;
%>   
<script type="text/javascript">
    $('#titulo').html('<center id="titulo"><h3><p class="text-error">Sesiones Activas:<%=size%></p></h3></center>'); 
$(function () {    
$("#gmap").gmap3({
    clear: {
      name:["marker"]
    },
  marker:{
    values:[
       <%
        for(int i=0;i<size;i++ )
        if(i==size-1){
           validos+=lista.get(i).getInt_validos();
           invalidos+=lista.get(i).getInt_invalidos();
       %>
            {
                latLng:[<%=lista.get(i).getLista().get(0).getDou_latitud()%>,<%=lista.get(i).getLista().get(0).getDou_longitud()%>] ,
                data:"<table border='1'>"
                       +  "<tr>"
                         +    "<th colspan='4'>Sesion Vehiculo</th>"
                        + "</tr>"
                        + "<tr>"
                          +   "<th colspan='2'>Hora Inicio</th><td colspan='2'><%=fecha.format(lista.get(i).getDat_fecha_entrada())%></td>"
                        + "</tr>"
                        +  "<tr>"
                         +    "<th colspan='4'>Datos Vehiculo</th>"
                       + "</tr>"
                        + "<tr>"
                           +  "<th>Número</th><th><%=lista.get(i).getObjPersonalVehiculo().getObjVehiculo().getStr_numero()%></th><th>Placa</th><th><%=lista.get(i).getObjPersonalVehiculo().getObjVehiculo().getStr_placa()%></th>"
                        + "</tr>"
                         + "<tr>"
                           +  "<th colspan='4'>Total Incidentes <%=lista.get(i).getInt_validos()+lista.get(i).getInt_invalidos()%></th>"
                        + "</tr>"
                         + "<tr>"
                           + "<th>Validos</th><th><%=lista.get(i).getInt_validos()%></th><th>Invalidos</th><th><%=lista.get(i).getInt_invalidos()%></th>"
                         +"</tr>"      
                        + "<tr>"
                         +   "<th colspan='4'>Agentes de Seguridad</th>"
                        + "</tr>"
                       <% for(clsDetallePersonalVehiculo entidad : lista.get(i).getObjPersonalVehiculo().getLista())
                        {%>
                        + "<tr>"
                          +  "<th colspan='2'>"
                              +    "<img  style='height:50px;width:50px' <img src='ajax/personal/get_foto.jsp?Id=<%=entidad.getObjPersonal().getInt_id_personal()%>'>"
                             +"</th>"
                              +"<th colspan='2'><%=entidad.getObjPersonal().getStr_nombre()%><br><%=entidad.getObjPersonal().getStr_apellido_paterno()%><br><%=entidad.getObjPersonal().getStr_apellido_materno()%></th>"
                         +"</tr>"
                        <%}%>
                     +"</table>" 
           }
       <%}else{%>
           {
                latLng:[<%=lista.get(i).getLista().get(0).getDou_latitud()%>,<%=lista.get(i).getLista().get(0).getDou_longitud()%>] ,
                data:"<table border='1'>"
                       +  "<tr>"
                         +    "<th colspan='4'>Sesion Vehiculo</th>"
                        + "</tr>"
                        + "<tr>"
                          +   "<th colspan='2'>Hora Inicio</th><td colspan='2'><%=fecha.format(lista.get(i).getDat_fecha_entrada())%></td>"
                        + "</tr>"
                        +  "<tr>"
                         +    "<th colspan='4'>Datos Vehiculo</th>"
                       + "</tr>"
                        + "<tr>"
                           +  "<th>Número</th><th><%=lista.get(i).getObjPersonalVehiculo().getObjVehiculo().getStr_numero()%></th><th>Placa</th><th><%=lista.get(i).getObjPersonalVehiculo().getObjVehiculo().getStr_placa()%></th>"
                        + "</tr>"
                         + "<tr>"
                           +  "<th colspan='4'>Total Incidentes <%=lista.get(i).getInt_validos()+lista.get(i).getInt_invalidos()%></th>"
                        + "</tr>"
                         + "<tr>"
                           + "<th>Validos</th><th><%=lista.get(i).getInt_validos()%></th><th>Invalidos</th><th><%=lista.get(i).getInt_invalidos()%></th>"
                         +"</tr>"      
                        + "<tr>"
                         +   "<th colspan='4'>Agentes de Seguridad</th>"
                        + "</tr>"
                       <% for(clsDetallePersonalVehiculo entidad : lista.get(i).getObjPersonalVehiculo().getLista())
                        {%>
                        + "<tr>"
                          +  "<th colspan='2'>"
                              +    "<img  style='height:50px;width:50px' <img src='ajax/personal/get_foto.jsp?Id=<%=entidad.getObjPersonal().getInt_id_personal()%>'>"
                             +"</th>"
                              +"<th colspan='2'><%=entidad.getObjPersonal().getStr_nombre()%><br><%=entidad.getObjPersonal().getStr_apellido_paterno()%><br><%=entidad.getObjPersonal().getStr_apellido_materno()%></th>"
                         +"</tr>"
                        <%}%>
                     +"</table>" 
           },
           <%}%>
    ],
    options:{
      draggable: false,
      icon: "img/gps/icono_gps.png"
     
    },
    events:{
      mouseover: function(marker, event, context){
        var map = $(this).gmap3("get"),
          infowindow = $(this).gmap3({get:{name:"infowindow"}});
        if (infowindow){
          infowindow.open(map, marker);
          infowindow.setContent(context.data);
        } else {
          $(this).gmap3({
            infowindow:{
              anchor:marker, 
              options:{content: context.data}
            }
          });
        }
      },
      mouseout: function(){
        var infowindow = $(this).gmap3({get:{name:"infowindow"}});
        if (infowindow){
          infowindow.close();
        }
      }
    }
  }
});


});

$('#validos').html('<center id="validos"><h4><p class="text-info">Total Incidentes Validos:<%=validos%></p></h4></center>'); 
$('#invalidos').html('<center id="invalidos"><h4><p class="text-warning">Total Incidentes Invalidos:<%=invalidos%></p></h4></center>');
$('#total').html('<center id="total"><h4><p class="text-success">Total Incidentes:<%=validos+invalidos%></p></h4></center>');
</script>
<%
}
else
{
%> 
<script type="text/javascript">
    $('#validos').html('<center id="validos"><h4><p class="text-info">Total Incidentes Validos:0</p></h4></center>'); 
    $('#invalidos').html('<center id="invalidos"><h4><p class="text-warning">Total Incidentes Invalidos:0</p></h4></center>');
    $('#total').html('<center id="total"><h4><p class="text-success">Total Incidentes:0</p></h4></center>');
    $('#titulo').html('<center id="titulo"><h3><p class="text-error">No se Encontraron Sesiones Activas</p></h3></center>');


$(function () {    
$("#gmap").gmap3({
    clear: {
      name:["marker"]
    }
});
});


</script>
<%
}
%> 
</div>
                                                                       
                                                                            