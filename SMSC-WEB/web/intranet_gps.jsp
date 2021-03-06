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

	<link href="assets/fancybox/source/jquery.fancybox.css" rel="stylesheet" />
	<link rel="stylesheet" type="text/css" href="assets/uniform/css/uniform.default.css" />
	<link href="assets/fullcalendar/fullcalendar/bootstrap-fullcalendar.css" rel="stylesheet" />
	<link href="assets/jqvmap/jqvmap/jqvmap.css" media="screen" rel="stylesheet" type="text/css" />
        
        <link rel="stylesheet" href="assets/smoke/smoke.css" />
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
                                <li class="has-sub active">
                                    <a href="javascript:;" class="">
                                        <span class="icon-box"> <i class="icon-dashboard"></i></span> Dashboard
                                        <span class="arrow"></span>
                                    </a>
                                    <ul class="sub">
                                        <li><a class="" href="intranet.jsp">Estadisticas</a></li>
                                        <li><a class="" href="intranet_gps.jsp">GPS Track</a></li>

                                    </ul>
                                </li>
				<li class="has-sub ">
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
                                <a href="intranet.jsp"><i class="icon-home"></i></a><span class="divider">&nbsp;</span>
							</li>
                            <li>
                                <a href="#">GPS Track</a> <span class="divider">&nbsp;</span>
                            </li>
							
						</ul>
						<!-- END PAGE TITLE & BREADCRUMB-->
					</div>
				</div>
				<!-- END PAGE HEADER-->
				<!-- BEGIN PAGE CONTENT-->
				<div id="page" class="dashboard">
     
                    <!-- END OVERVIEW STATISTIC BLOCKS-->

				
					<!-- BEGIN SQUARE STATISTIC BLOCKS-->
                  
                                        
                                        <div class="row-fluid">
						<div class="span12">
							<!-- BEGIN BASIC PORTLET-->
							
                                                                    <center id='titulo'><h3><p class="text-error">Sesiones Activas:0</p></h3></center>
                                                                    <div id="gmap" style="width:100%;height:500px"></div>
                                                                    <div id="mapa"></div>
                                                                    <table class="table table-hover">

                                                                        <tr>
                                                                            <th>
                                                                                <center id='validos'><h4><p class="text-info">Total Incidentes Validos:0</p></h4></center>
                                                                            </th>
                                                                            <th>
                                                                               <center id='invalidos'><h4><p class="text-warning">Total Incidentes Invalidos:0</p></h4></center>
                                                                            </th>
                                                                            <th>
                                                                                <center id='total'><h4><p class="text-success">Total Incidentes:0</p></h4></center>
                                                                            </th>
                                                                            
                                                                        </tr>
                                                                    </table>
							<!-- END BASIC PORTLET-->
						</div>
						
					</div>
                    <!-- END SQUARE STATISTIC BLOCKS-->
 
                     
                     
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
	<script src="assets/fullcalendar/fullcalendar/fullcalendar.min.js"></script>
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>
	<script src="js/jquery.blockui.js"></script>
	<script src="js/jquery.cookie.js"></script>
	<!-- ie8 fixes -->
	<!--[if lt IE 9]>
	<script src="js/excanvas.js"></script>
	<script src="js/respond.js"></script>
	<![endif]-->
	<script src="assets/jqvmap/jqvmap/jquery.vmap.js" type="text/javascript"></script>
	<script src="assets/jqvmap/jqvmap/maps/jquery.vmap.russia.js" type="text/javascript"></script>
	<script src="assets/jqvmap/jqvmap/maps/jquery.vmap.world.js" type="text/javascript"></script>
	<script src="assets/jqvmap/jqvmap/maps/jquery.vmap.europe.js" type="text/javascript"></script>
	<script src="assets/jqvmap/jqvmap/maps/jquery.vmap.germany.js" type="text/javascript"></script>
	<script src="assets/jqvmap/jqvmap/maps/jquery.vmap.usa.js" type="text/javascript"></script>
	<script src="assets/jqvmap/jqvmap/data/jquery.vmap.sampledata.js" type="text/javascript"></script>
	<script src="assets/jquery-knob/js/jquery.knob.js"></script>
	<script src="assets/flot/jquery.flot.js"></script>
	<script src="assets/flot/jquery.flot.resize.js"></script>

    <script src="assets/flot/jquery.flot.pie.js"></script>
    <script src="assets/flot/jquery.flot.stack.js"></script>
    <script src="assets/flot/jquery.flot.crosshair.js"></script>
    
        <script src="http://maps.googleapis.com/maps/api/js?sensor=false" type="text/javascript"></script>
	<script src="js/gmap3.js"></script>
        
	<script src="js/jquery.peity.min.js"></script>
	<script type="text/javascript" src="assets/uniform/jquery.uniform.min.js"></script>
	<script src="js/scripts.js"></script>
        <script src="assets/smoke/smoke.js"></script>
	<script>
var count_up_val = 0;
	function count_up() {
		count_up_val++;
                get_mapa();       
		setTimeout(count_up,15000);
	}
	function thread_start(callback) {
		setTimeout(callback, 1);
		return true;
	}
thread_start(count_up);         
function get_mapa()
{
    $.ajax({
        url: 'ajax/recorrido_personal_vehiculo/get_mapa.jsp',
        type: 'POST',
        success: function (data) {     
                 $('#mapa').html(data);
        },
        contentType: false,
        processData: false
    });
};
function cerrarSesion(){
smoke.confirm('Desea Cerrar Sesión',function(e){
        if (e){
                window.location='ajax/personal/cerrar_sesion.jsp';
        }
}, {cancel:"No",ok:"Si"});
};
          

          
		jQuery(document).ready(function() {
			// initiate layout and plugins

                        $("#gmap").gmap3({
                            map:{
                              address: "Trujillo Peru",
                              options:{
                                zoom: 13
                              }                      
                          }
                      });			
                      App.init();
                        
                        
		});
               
	</script>
	<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>
<%}else  
    response.sendRedirect("index.jsp");%>   