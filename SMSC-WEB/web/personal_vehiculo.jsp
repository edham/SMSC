<%-- 
    Document   : index
    Created on : 01-oct-2014, 11:24:23
    Author     : EdHam
--%>

<%@page import="sun.misc.BASE64Encoder"%>
<%@page import="entidades.clsPersonal"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
clsPersonal objPersonal =(clsPersonal) request.getSession().getAttribute("SessionPersonal");
if(objPersonal!=null)
{
    BASE64Encoder e = new BASE64Encoder();
%>
<html>
<head>
	<meta charset="utf-8" />
	  <title>Sistema Movil Seguridad Ciudadana</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport" />
        <meta content="SMSC" name="description" />
        <meta content="Servicios Ternologicos Integrales Sudamerica" name="author" />
	<link href="assets/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
	<link href="assets/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet" />
	<link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
	<link href="css/style.css" rel="stylesheet" />
	<link href="css/style_responsive.css" rel="stylesheet" />
	<link href="css/style_default.css" rel="stylesheet" id="style_color" />
         <link rel="stylesheet" type="text/css" href="assets/bootstrap-datepicker/css/datepicker.css" />
	<link href="assets/fancybox/source/jquery.fancybox.css" rel="stylesheet" />
	<link rel="stylesheet" type="text/css" href="assets/uniform/css/uniform.default.css" />
	<link href="assets/jqvmap/jqvmap/jqvmap.css" media="screen" rel="stylesheet" type="text/css" />
         <link rel="stylesheet" href="assets/qtip2/jquery.qtip.min.css" />
        <link rel="stylesheet" href="assets/smoke/smoke.css" />
        <link rel="stylesheet" type="text/css" href="assets/gritter/css/jquery.gritter.css" />
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="fixed-top">
	<!-- BEGIN HEADER -->
	<div id="header" class="navbar navbar-inverse navbar-fixed-top">
		<!-- BEGIN TOP NAVIGATION BAR -->
		<div class="navbar-inner">
			<div class="container-fluid">
				<!-- BEGIN LOGO -->
				<a class="brand" href="intranet.jsp">
				    <img src="img/logo.png" alt="Admin Lab" />
				</a>
				<!-- END LOGO -->
				<!-- BEGIN RESPONSIVE MENU TOGGLER -->
				<a class="btn btn-navbar collapsed" id="main_menu_trigger" data-toggle="collapse" data-target=".nav-collapse">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="arrow"></span>
				</a>
				<!-- END RESPONSIVE MENU TOGGLER -->
				<div id="top_menu" class="nav notify-row">
                    <!-- BEGIN NOTIFICATION -->
					
                </div>
                    <!-- END  NOTIFICATION -->
                <div class="top-nav ">
                    <ul class="nav pull-right top-menu" >
                    
						<!-- BEGIN USER LOGIN DROPDOWN -->
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">
                           
                             <img  style="height:30px;width:30px" src="data:image/png;base64,<%=e.encodeBuffer(objPersonal.getByte_foto())%>">
                                <span class="username"><%=objPersonal.getStr_nombre()%> <%=objPersonal.getStr_apellido_paterno()%> <%=objPersonal.getStr_apellido_materno()%></span>
							<b class="caret"></b>
							</a>
							<ul class="dropdown-menu">
                                                            <li><a href="#" onclick="cerrarSesion()" ><i class="icon-key"></i>Cerrar Sesión</a></li>
							</ul>
						</li>
						<!-- END USER LOGIN DROPDOWN -->
					</ul>
					<!-- END TOP NAVIGATION MENU -->
				</div>
			</div>
		</div>
		<!-- END TOP NAVIGATION BAR -->
	</div>
	<!-- END HEADER -->
	<!-- BEGIN CONTAINER -->
	<div id="container" class="row-fluid">
		<!-- BEGIN SIDEBAR -->
		<div id="sidebar" class="nav-collapse collapse">
			<!-- BEGIN SIDEBAR TOGGLER BUTTON -->
			<div class="sidebar-toggler hidden-phone"></div>
			<!-- BEGIN SIDEBAR TOGGLER BUTTON -->

			
			<!-- END RESPONSIVE QUICK SEARCH FORM -->
			<!-- BEGIN SIDEBAR MENU -->
			<ul class="sidebar-menu">
                                <li class="has-sub">
                                    <a href="javascript:;" class="">
                                        <span class="icon-box"> <i class="icon-dashboard"></i></span> Dashboard
                                        <span class="arrow"></span>
                                    </a>
                                    <ul class="sub">
                                        <li><a class="" href="intranet.jsp">Estadisticas</a></li>
                                        <li><a class="" href="intranet_gps.jsp">GPS Track</a></li>

                                    </ul>
                                </li>
				<li class="has-sub active">
					<a href="javascript:;" class="">
					    <span class="icon-box"> <i class="icon-tasks"></i></span> Resgistros
                                            <span class="arrow"></span>
                                        </a>
                                        <ul class="sub">
                                            <li class="active"><a class="" href="personal.jsp">Personal</a></li>
                                            <li><a class="" href="vehiculo.jsp">Vehiculo</a></li>
                                            <li><a class="" href="personal_vehiculo.jsp">Personal Vehiculo</a></li>

                                        </ul>
				</li>
				<li class="has-sub">
					<a href="javascript:;" class="">
					    <span class="icon-box"> <i class="icon-file-alt"></i></span> Reportes
					    <span class="arrow"></span>
					</a>
					<ul class="sub">
						<li><a class="" href="reporte_incidentes.jsp">Incidentes</a></li>
					</ul>
				</li>
			</ul>
			<!-- END SIDEBAR MENU -->
		</div>
		<!-- END SIDEBAR -->
		<!-- BEGIN PAGE -->
		<div id="main-content">
			<!-- BEGIN PAGE CONTAINER-->
			<div class="container-fluid">
				<!-- BEGIN PAGE HEADER-->
				<div class="row-fluid">
					<div class="span12">
					
						<ul class="breadcrumb">
							<li>
                                <a href="#"><i class="icon-home"></i></a><span class="divider">&nbsp;</span>
							</li>
                          
							<li><a href="#">Estadisticas</a><span class="divider-last">&nbsp;</span></li>
                           
						</ul>
						<!-- END PAGE TITLE & BREADCRUMB-->
					</div>
				</div>
				<!-- END PAGE HEADER-->
				<!-- BEGIN PAGE CONTENT-->
				 <div id="page" class="dashboard">
                                   <div class="row-fluid">
                       
                        <div class="span12">
                            <!-- BEGIN ALERTS PORTLET-->
                            <div class="widget">
                                <div class="widget-title">
                                    <h4><i class="icon-reorder"></i> Lista de Personal</h4>
									<span class="tools">
									<a href="javascript:;" class="icon-chevron-down"></a>
									</span>
                                </div>
                                <div class="widget-body">
                                    <div id="tabla"></div>
                                    			
                                        <div id="ModalVehiculo" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                                <div class="modal-header">
                                                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                                       						
                                                        <i class="icon-credit-card icon-7x"></i> 
                                                                <h4 id="myModalLabel" class="semi-bold">Lista de Vehiculos</h4>
                                                         
                                                </div>
                                                        <div class="modal-body">
                                                        <div id='tablaVehiculo'></div>
                                                </div>
                                                <div class="modal-footer">
                                                        <button class="btn" data-dismiss="modal" aria-hidden="true">Cerrar</button>
                                                </div>
                                        </div>
                                        <div id="ModalPersonal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                                <div class="modal-header">
                                                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                                       						
                                                        <i class="icon-credit-card icon-7x"></i> 
                                                                <h4 id="myModalLabel" class="semi-bold">Lista de Personal</h4>
                                                         
                                                </div>
                                                        <div class="modal-body">
                                                        <div id='tablaPersonal'></div>
                                                </div>
                                                <div class="modal-footer">
                                                        <button class="btn" data-dismiss="modal" aria-hidden="true">Cerrar</button>
                                                </div>
                                        </div>
                                </div>
                            </div>
                            <!-- END ALERTS PORTLET-->
                        </div>
                    </div>

                                </div>
				<!-- END PAGE CONTENT-->
			</div>
			<!-- END PAGE CONTAINER-->
		</div>
		<!-- END PAGE -->
	</div>
	<!-- END CONTAINER -->
	<!-- BEGIN FOOTER -->
	<div id="footer">
		2014 &copy; Servicios Ternologicos Integrales
		<div class="span pull-right">
			<span class="go-top"><i class="icon-arrow-up"></i></span>
		</div>
	</div>
	<!-- END FOOTER -->
	<!-- BEGIN JAVASCRIPTS -->
	<!-- Load javascripts at bottom, this will reduce page load time -->
	<script src="js/jquery-1.8.3.min.js"></script>
	<script src="assets/jquery-slimscroll/jquery-ui-1.9.2.custom.min.js"></script>
	<script src="assets/jquery-slimscroll/jquery.slimscroll.min.js"></script>
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>
	<script src="js/jquery.blockui.js"></script>
	<script src="js/jquery.cookie.js"></script>
	<!-- ie8 fixes -->
	<!--[if lt IE 9]>
	<script src="js/excanvas.js"></script>
	<script src="js/respond.js"></script>
	<![endif]-->
	<script src="assets/jquery-knob/js/jquery.knob.js"></script>

    <script src="assets/flot/jquery.flot.crosshair.js"></script>
 <script src="js/scripts.js"></script>
	<script src="js/jquery.peity.min.js"></script>
	<script type="text/javascript" src="assets/uniform/jquery.uniform.min.js"></script>
        <script src="assets/smoke/smoke.js"></script>
        <script src="assets/validation/jquery.validate.min.js"></script>
          <script type="text/javascript" src="assets/data-tables/jquery.dataTables.js"></script>
        <script type="text/javascript" src="assets/data-tables/DT_bootstrap.js"></script>        
        <script type="text/javascript" src="assets/gritter/js/jquery.gritter.js"></script>
        
   <script type="text/javascript" src="assets/bootstrap-datepicker/js/bootstrap-datepicker.js"></script> 
        <script src="assets/moment_js/moment.min.js"></script>
	<script>
            
 var idPersonalVehiculo;
 function tablaVehiculo()
{
     $('#tablaVehiculo').html('<center id="tablaVehiculo"><h4><img src="img/ajax-loader.gif" alt="" /> Espere un Momento ...</h4></center>');
   
     $.ajax({
        url: 'ajax/vehiculo/tabla_.jsp',
        type: 'POST',
        success: function (data) {     
                 $('#tablaVehiculo').html(data);
        },
        contentType: false,
        processData: false
    });          
 };
 
 
function tabla()
{
     $('#tabla').html('<center id="tabla"><h4><img src="img/ajax-loader.gif" alt="" /> Espere un Momento ...</h4></center>');
   
     $.ajax({
        url: 'ajax/personal_vehiculo/tabla.jsp',
        type: 'POST',
        success: function (data) {     
                 $('#tabla').html(data);
        },
        contentType: false,
        processData: false
    });          
 };
 function tablaPersonal(id)
{
    idPersonalVehiculo=id;
     $('#tablaPersonal').html('<center id="tablaPersonal"><h4><img src="img/ajax-loader.gif" alt="" /> Espere un Momento ...</h4></center>');
   
     $.ajax({
        url: 'ajax/personal/tabla_.jsp',
        type: 'POST',
        success: function (data) {     
                 $('#tablaPersonal').html(data);
        },
        contentType: false,
        processData: false
    });          
 };
 
 function add_vehiculo(id)
{
    smoke.confirm('Desea Agregar Vehiculo',function(e){
        if (e){
            var url = "ajax/personal_vehiculo/operacion.jsp?id="+id; 
            $.ajax({
               type: "POST",
               url: url,
               success: function(data)
               {

                   if(data>0)
                   {
                        $.gritter.add({text: 'Se grabo Correctamente.'});
                        tabla();    
                   }else if(data==0)
                   {
                       $.gritter.add({text: 'Problemas con el Sevidor intentelo mas tarde.'});
                   }

               }
             });   
        }
    }, {cancel:"No",ok:"Si"});  

    
};
function add_personal(id)
{
   smoke.confirm('Desea Agregar Personal',function(e){
        if (e){
            var url = "ajax/personal_vehiculo/operacion.jsp?id="+idPersonalVehiculo+"&idPersona="+id; 
            $.ajax({
               type: "POST",
               url: url,
               success: function(data)
               {

                   if(data>0)
                   {
                        $.gritter.add({text: 'Se grabo Correctamente.'});
                        tabla();    
                   }else if(data==0)
                   {
                       $.gritter.add({text: 'Problemas con el Sevidor intentelo mas tarde.'});
                   }

               }
             });   
        }
    }, {cancel:"No",ok:"Si"});  
};
function quitar_personal(id)
{
    alert(id);
     smoke.confirm('Desea Agregar Vehiculo',function(e){
        if (e){
            var url = "ajax/personal_vehiculo/quitar.jsp?id="+id; 
            $.ajax({
               type: "POST",
               url: url,
               success: function(data)
               {

                   if(data==1)
                   {
                        $.gritter.add({text: 'Se Quito Correctamente.'});
                        tabla();    
                   }else 
                   {
                       $.gritter.add({text: 'Problemas con el Sevidor intentelo mas tarde.'});
                   }

               }
             });   
        }
    }, {cancel:"No",ok:"Si"});  
};
  tabla();
          function limpiar(){
                smoke.confirm('Desea Lipiar Formulario',function(e){
                    if (e){
                            $('#form')[0].reset();
                             var validator = $( "#form" ).validate();
                            validator.resetForm();
                    }
            }, {cancel:"No",ok:"Si"});  
           
          };
          
         function cerrarSesion(){
            smoke.confirm('Desea Cerrar Sesión',function(e){
                    if (e){
                            window.location='ajax/personal/cerrar_sesion.jsp';
                    }
            }, {cancel:"No",ok:"Si"});
          }
		jQuery(document).ready(function() {
			// initiate layout and plugins
                     
			App.init();
           
    });
                
            function edit_form(id,marca,modelo,placa,numero,estado) {
                    $('#Id').val(id);
                    $('#txtNumero').val(numero);
                    $('#txtNPlaca').val(placa);
                    $('#txtModelo').val(modelo);
                    $('#txtMarca').val(marca);    
                    if(estado==0)
                        $('input:radio[name=rbEstado]')[0].checked = true;
                    else
                        $('input:radio[name=rbEstado]')[1].checked = true;
                };  
	</script>
	<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>
<%}else  
    response.sendRedirect("index.jsp");%>   