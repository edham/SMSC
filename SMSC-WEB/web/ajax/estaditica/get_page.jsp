
<%@page import="com.clsGestor"%>
<%@page import="com.clsGestor"%>
<%@page import="entidades.clsEstadistica"%>
<div id="page" class="dashboard">
<%
clsEstadistica entidad= clsGestor.getEstadistica();
if(entidad!=null)
{  %>
<!-- BEGIN OVERVIEW STATISTIC BLOCKS-->
        <div class="row-fluid circle-state-overview">
        <div class="span2 responsive" data-tablet="span3" data-desktop="span2">
        <div class="circle-stat block">
            <div class="visual">
                <div class="circle-state-icon">
                    <i class="icon-upload turquoise-color"></i>
                </div>
                <input class="knob" data-width="100" data-height="100" data-displayPrevious=true  data-thickness=".2" value="<%=(int)(entidad.getInt_incidente_enviado()*100/(entidad.getInt_incidente_enviado()+entidad.getInt_incidente_progeso()))%>" data-fgColor="#4CC5CD" data-bgColor="#ddd">
            </div>
            <div class="details">
                <div class="number"><%=entidad.getInt_incidente_enviado()%></div>
                <div class="title">Incidentes Nuevos</div>
            </div>

        </div>
        </div>
       <div class="span2 responsive" data-tablet="span3" data-desktop="span2">
        <div class="circle-stat block">
            <div class="visual">
                <div class="circle-state-icon">
                    <i class="icon-refresh gray-color"></i>
                </div>
                <input class="knob"  data-width="100" data-height="100" data-displayPrevious=true  data-thickness=".2" value="<%=(int)(entidad.getInt_incidente_progeso()*100/(entidad.getInt_incidente_enviado()+entidad.getInt_incidente_progeso()))%>"  data-fgColor="#b9baba" data-bgColor="#ddd"/>
            </div>
            <div class="details">
                <div class="number"><%=entidad.getInt_incidente_progeso()%></div>
                <div class="title">Incidentes en Progreso</div>
            </div>

        </div>
        </div>
        <div class="span2 responsive" data-tablet="span3" data-desktop="span2">
        <div class="circle-stat block">
            <div class="visual">
                <div class="circle-state-icon">
                    <i class="icon-thumbs-up green-color"></i>
                </div>
                <input class="knob" data-width="100" data-height="100" data-displayPrevious=true  data-thickness=".2" value="<%=(int)(entidad.getInt_incidente_valido()*100/(entidad.getInt_incidente_valido()+entidad.getInt_incidente_invalido()))%>" data-fgColor="#a8c77b" data-bgColor="#ddd"/>
            </div>
            <div class="details">
                <div class="number"><%=entidad.getInt_incidente_valido()%></div>
                <div class="title">Incidentes Validos</div>
            </div>

        </div>
        </div>
         <div class="span2 responsive" data-tablet="span3" data-desktop="span2">
        <div class="circle-stat block">
            <div class="visual">
                <div class="circle-state-icon">
                    <i class="icon-thumbs-down red-color"></i>
                </div>
                <input class="knob" data-width="100" data-height="100" data-displayPrevious=true  data-thickness=".2" value="<%=(int)(entidad.getInt_incidente_invalido()*100/(entidad.getInt_incidente_valido()+entidad.getInt_incidente_invalido()))%>" data-fgColor="#e17f90" data-bgColor="#ddd"/>
            </div>
            <div class="details">
                <div class="number"><%=entidad.getInt_incidente_invalido()%></div>
                <div class="title">Incidentes Invalidos</div>
            </div>

        </div>
        </div>
        
        <div class="span2 responsive" data-tablet="span3" data-desktop="span2">
        <div class="circle-stat block">
            <div class="visual">
                <div class="circle-state-icon">
                    <i class="icon-ok purple-color"></i>
                </div>
                <input class="knob" data-width="100" data-height="100" data-displayPrevious=true  data-thickness=".2" value="100" data-fgColor="#c8abdb" data-bgColor="#ddd"/>
            </div>
            <div class="details">
                <div class="number"><%=entidad.getInt_incidente_valido()+entidad.getInt_incidente_invalido()%></div>
                <div class="title">Incidentes Atendidos</div>
            </div>

        </div>
        </div>
        <div class="span2 responsive" data-tablet="span3" data-desktop="span2">
        <div class="circle-stat block">
            <div class="visual">
                <div class="circle-state-icon">
                    <i class="icon-user blue-color"></i>
                </div>
                <input class="knob" data-width="100" data-height="100" data-displayPrevious=true  data-thickness=".2" value="100" data-fgColor="#93c4e4" data-bgColor="#ddd"/>
            </div>
            <div class="details">
                <div class="number"><%=entidad.getInt_total_sesiones()%></div>
                <div class="title">Sesiones Activas</div>
            </div>

        </div>
        </div>
        </div>
<!-- END OVERVIEW STATISTIC BLOCKS-->


    <script src="js/scripts.js"></script>
<div class="row-fluid">
    <div class="span6">
            <!-- BEGIN BASIC PORTLET-->
            <div class="widget">
                    <div class="widget-title">
                            <h4><i class="icon-reorder"></i>Incidentes</h4>
                            <span class="tools">
                            <a href="javascript:;" class="icon-chevron-down"></a>
                            <a href="javascript:;" class="icon-remove"></a>
                            </span>							
                    </div>
                    <div class="widget-body">
                            <div id="greafico_barras_incidentes" style="height:270px;width:90%;margin:15px auto 0"></div>
                    </div>
            </div>
            <!-- END BASIC PORTLET-->
    </div>
    <div class="span6">
            <!-- BEGIN MARKERS PORTLET-->
            <div class="widget">
                    <div class="widget-title">
                            <h4><i class="icon-reorder"></i>Incidentes Atendidos</h4>
                            <span class="tools">
                            <a href="javascript:;" class="icon-chevron-down"></a>
                            <a href="javascript:;" class="icon-remove"></a>
                            </span>							
                    </div>
                    <div class="widget-body">
                            <div id="greafico_pie_incidentes" style="height:270px;width:90%;margin:15px auto 0"></div>
                    </div>
            </div>
            <!-- END MARKERS PORTLET-->
    </div>
</div>
    
<script type="text/javascript">
$(function () { 
    var datos_pie = [
        <%
            out.print("{label: 'VALIDOS', data: "+entidad.getInt_incidente_valido()+"},");
            out.print("{label: 'INVALIDOS', data: "+entidad.getInt_incidente_invalido()+"}");
        %>
        
    ];
 
    var options_pie = {
            series: {
               pie: {
                                show: true,
                                innerRadius: 0.5,
                                highlight: {
                                    opacity: 0.2
                                }
                            }
                    },
             grid:{
                    hoverable: true,
                    clickable: true
                }
         };
 
    $.plot($("#greafico_pie_incidentes"), datos_pie, options_pie);  
    
       $("#greafico_pie_incidentes").qtip({
                prerender: true,
                content: 'Loading...', // Use a loading message primarily
                position: {
                    viewport: $(window), // Keep it visible within the window if possible
                    target: 'mouse', // Position it in relation to the mouse
                    adjust: { x: 7 } // ...but adjust it a bit so it doesn't overlap it.
                },
                show: false, // We'll show it programatically, so no show event is needed
                style: {
                    classes: 'ui-tooltip-shadow ui-tooltip-tipsy',
                    tip: false // Remove the default tip.
                }
            });
         
            // Bind the plot hover
            $("#greafico_pie_incidentes").on('plothover', function(event, pos, obj) {
                
                // Grab the API reference
                var self_pie = $(this),
                    api = $(this).qtip(),
                    previousPoint, content,
         
                // Setup a visually pleasing rounding function
                round = function(x) { return Math.round(x * 1000) / 1000; };
         
                // If we weren't passed the item object, hide the tooltip and remove cached point data
                if(!obj) {
                    api.cache.point = false;
                    return api.hide(event);
                }
         
                // Proceed only if the data point has changed
                previousPoint = api.cache.point;
                if(previousPoint !== obj.seriesIndex)
                {
                    percent = parseFloat(obj.series.percent).toFixed(2);
                    // Update the cached point data
                    api.cache.point = obj.seriesIndex;
                    // Setup new content
                    content = obj.series.label + ' ( ' + percent + '% )';
                    // Update the tooltip content
                    api.set('content.text', content);
                    // Make sure we don't get problems with animations
                    //api.elements.tooltip.stop(1, 1);
                    // Show the tooltip, passing the coordinates
                    api.show(pos);
                }
            });
            
            
            
    var data_barra = {  label: "Incidentes",  
    data:   [  
        <%    
            out.print("[1,"+entidad.getInt_incidente_enviado()+"],");
            out.print("[2,"+entidad.getInt_incidente_progeso()+"],");
            out.print("[3,"+entidad.getInt_incidente_invalido()+"],");
            out.print("[4,"+entidad.getInt_incidente_invalido()+"]");
        %>
        ]
};
var optioms_barra ={
        series: {
            bars: {
                show: true,
                 fillColor:  "#8cc7e0",
                 barWidth: 0.5,
                 align: "center"
            }
        },
        grid:{
                    hoverable: true,
                    clickable: true
                },
         xaxis: {ticks: [
                 <% 
                    out.print("[1,'Nuevos'],");
                    out.print("[2,'Progreso'],");
                    out.print("[3,'Validos'],");
                    out.print("[4,'Invalidos'],");
                 %>
            ]}
    };


 
    $.plot($("#greafico_barras_incidentes"), [data_barra],optioms_barra );
    
     $("#greafico_barras_incidentes").qtip({
                prerender: true,
                content: 'Loading...', // Use a loading message primarily
                position: {
                    viewport: $(window), // Keep it visible within the window if possible
                    target: 'mouse', // Position it in relation to the mouse
                    adjust: { x: 7 } // ...but adjust it a bit so it doesn't overlap it.
                },
                show: false, // We'll show it programatically, so no show event is needed
                style: {
                    classes: 'ui-tooltip-shadow ui-tooltip-tipsy',
                    tip: false // Remove the default tip.
                }
            });
         
            // Bind the plot hover
            $("#greafico_barras_incidentes").on('plothover', function(event, coords, item) {
                // Grab the API reference
                var self_barra = $(this),
                    api = $(this).qtip(),
                    previousPoint, content,
         
                // Setup a visually pleasing rounding function
                round = function(x) { return Math.round(x * 1000) / 1000; };
         
                // If we weren't passed the item object, hide the tooltip and remove cached point data
                if(!item) {
                    api.cache.point = false;
                    return api.hide(event);
                }
				
                // Proceed only if the data point has changed
                previousPoint = api.cache.point;
                if(previousPoint !== item.seriesIndex)
                {
                    // Update the cached point data
                    api.cache.point = item.seriesIndex;
					
                    // Setup new content
                    content = item.series.label +': '+ round(item.datapoint[1]);
         
                    // Update the tooltip content
                    api.set('content.text', content);
         
                    // Make sure we don't get problems with animations
                    api.elements.tooltip.stop(1, 1);
         
                    // Show the tooltip, passing the coordinates
                    api.show(coords);
                }
            });
    
});
</script>    
    
 <%
}
else
   out.print("<center id='titulo'><h1><p class='text-error'>No se Encontraron Datos</p></h1></center>");
%>    
</div>
       

	