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
                        <div class="span3">
                            <!-- BEGIN PROGRESS BARS PORTLET-->
                            <div class="widget">
                                <div class="widget-title">
                                    <h4><i class="icon-reorder"></i>Agregar Personal</h4>
                                        <span class="tools">
                                        <a href="javascript:;" class="icon-chevron-down"></a>
                                                                                </span>
                                </div>
                                <div class="widget-body">
                               <!-- BEGIN FORM-->
                                   <form id="form"  class="form-horizontal" action="">
                                      <div class="control-group ">
                                                                                                   
                                       
                                        <div class="input-prepend">
                                            <input id="txtNombres" name="txtNombres" type="text" placeholder="Nombres" required/>
                                        </div>
                                        
                                        
                                        <div class="input-prepend">
                                            <input id="txtAPaterno" name="txtAPaterno" type="text" placeholder="Apellidos Paterno" required/>
                                        </div>
                                        
                                       
                                        <div class="input-prepend">
                                            <input id="txtAMaterno" name="txtAMaterno" type="text" placeholder="Apellidos Materno" required/>
                                        </div>
                                        
                                       
                                        <div class="input-prepend">
                                            <input id="txtDNI" name="txtDNI" type="text" placeholder="DNI" required/>
                                        </div>
                                         <div class="input-prepend">
                                            <input id="txtFNacimiento" name="txtFNacimiento" data-date-format="dd/mm/yyyy"  placeholder="Fecha de Nacimiento"size="16" type="text"/>
                                        </div>
                                     
                                       
                                        <div>                                                  
                                            <select id="cbTipoPersonal" name="cbTipoPersonal" title="Selecione un Tipo de Personal!" required>
                                                <option value="">espere un momento...</option>                                                       
                                            </select>
                                        </div>
                                        <div>                                                  
                                            <select id="cbDepartamento" name="cbDepartamento" onchange="getProvincia(this.value)" title="Por favor selecione un departamento!" required>
                                                <option value="">espere un momento...</option>                                                       
                                            </select>
                                        </div>
                                         
                                       
                                        <div>    
                                            <select id="cbProvincia" name="cbProvincia" onchange="getDistrito(this.value)" title="Por favor selecione una provincia!" required>
                                                <option value="">Selecione una opcción</option>
                                            </select>
                                        </div>

                                      
                                        <div>                                                  
                                            <select id="cbDistrito" name="cbDistrito" title="Por favor selecione un distrito!" required>
                                                <option value="">Selecione una opcción</option>
                                            </select>
                                        </div>

                                       
                                        <div class="input-prepend">        
                                            <input id="txtTelefono" name="txtTelefono" type="text" placeholder="Telefono" required/>
                                        </div>
                                        
                                      
                                        <div class="input-prepend">
                                            <input id="txtCelular" name="txtCelular" type="text" placeholder="Celular" required/>
                                        </div>
                                        
                                     
                                        <div class="input-prepend">
                                            <input id="txtEmail" name="txtEmail" type="text" placeholder="Email" required/>
                                        </div>
                                        
                                         <div class="input-prepend">
                                            <input id="txtClave" name="txtClave" type="text" placeholder="Clave" required/>
                                        </div>
                                        <div class="input-prepend">
                                            <textarea id="txtDireccion" name="txtDireccion" class="input-large" rows="3"  placeholder="Dirección" required></textarea>
                                           
                                        </div>
                                          <div class="input-prepend">
                                         <label class="radio inline">
                                            <input type="radio" value="1"  id="rbEstado" name="rbEstado" />
                                                Activo
                                        </label>
                                        <label class="radio inline">
                                                <input type="radio" value="0" id="rbEstado" name="rbEstado" />
                                                Inactivo
                                        </label> 
                                          </div>  
                                          
                                          
                                      </div>
                                       
                                        <div class="input-prepend">                                                                                                    
                                            <div id="foto"></div>    
                                            <input class="btn" type="file" name="archivo" id="archivo" />
                                            <br>
                                            <a id="Remover" data-dismiss="fileupload" class="btn" href="#">Remover</a>
                                        </div>
                                        <div class="input-prepend">
                                            <input type="text" name="txtFoto" id="txtFoto"/> 
                                        </div>
                                       <br>
                                      <input type="hidden" id="Id"  name="Id" value="" />
                                      <button type="submit" class="btn btn-success">Save</button>
                                      <button type="button" onclick="limpiar()" class="btn">Cancel</button>

                                    </form>
                        <!-- END FORM-->

                                </div>
                            </div>
                            <!-- END PROGRESS BARS PORTLET-->
                        </div>
                        <div class="span9">
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
function tabla()
{
     $('#tabla').html('<center id="tabla"><h4><img src="img/ajax-loader.gif" alt="" /> Espere un Momento ...</h4></center>');
   
     $.ajax({
        url: 'ajax/personal/tabla.jsp',
        type: 'POST',
        success: function (data) {     
                 $('#tabla').html(data);
        },
        contentType: false,
        processData: false
    });          
 };
function comboTipoPersonal()
{
     $.ajax({
        url: 'ajax/tipo_personal/combo.jsp',
        type: 'POST',
        success: function (data) {     
                 $('#cbTipoPersonal').html(data);
        },
        contentType: false,
        processData: false
    });          
 };
 function comboDepartamento()
{
     $.ajax({
        url: 'ajax/ubigeo/combo_departamento.jsp',
        type: 'POST',
        success: function (data) {     
                 $('#cbDepartamento').html(data);
        },
        contentType: false,
        processData: false
    });          
 };
 function getUbigeo(departamento,provincia,distrito){
                $("select#cbDepartamento").val(departamento);
                 
                $('#cbProvincia option[value=]').text('espere un momento...');               
                var url = "ajax/ubigeo/combo_provincia.jsp?id="+departamento; 

                                    $.ajax({
                                           type: "POST",
                                           url: url,
                                           success: function(data)
                                           {
                                               $("#cbProvincia").html(data);
                                               $("select#cbProvincia").val(provincia);
                                               url = "ajax/ubigeo/combo_distrito.jsp?id="+provincia; 

                                                $.ajax({
                                                       type: "POST",
                                                       url: url,
                                                       success: function(data)
                                                       {
                                                            $("#cbDistrito").html(data);
                                                            $("select#cbDistrito").val(distrito);

                                                       }
                                                     });    
                                           }
                                         });    
                  
  }
  function getProvincia(id){
     
                if(id!="")
                {
                 $('#cbProvincia option[value=]').text('espere un momento...');
                 $("#cbDistrito").val(0);
                var url = "ajax/ubigeo/combo_provincia.jsp?id="+id; 

                                    $.ajax({
                                           type: "POST",
                                           url: url,
                                           success: function(data)
                                           {
                                                $("#cbProvincia").html(data);
                                                $("#cbProvincia").change();
                                           }
                                         });    
                  }
                   else
                  {
                      $("#cbProvincia").val(0);
                  }
            }
  function getDistrito(id){
                
                if(id!="")
                {
                $('#cbDistrito option[value=]').text('espere un momento...');
                var url = "ajax/ubigeo/combo_distrito.jsp?id="+id; 

                                    $.ajax({
                                           type: "POST",
                                           url: url,
                                           success: function(data)
                                           {
                                                $("#cbDistrito").html(data);
                                                
                                           }
                                         });    
                  }
                  else
                  {
                      $("#cbDistrito").val(0);
                  }
            }
  tabla();
  comboTipoPersonal();
  comboDepartamento();
          function limpiar(){
                smoke.confirm('Desea Lipiar Formulario',function(e){
                    if (e){
                            $('#form')[0].reset();
                             var validator = $( "#form" ).validate();
                            validator.resetForm();
                            $("#foto").html('<div id="foto"></div>');
                            $( "#Remover" ).hide();
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
$( "#Remover" ).hide();
 $( "#txtFoto" ).hide();
 
 $('#archivo').change(function (e) {
    var input=e.target,fr=new FileReader(),
	tipos=/^image\/jpg|image\/jpeg|image\/png|image\/gif$/i;
	if(input.files.length===0)return;
	if(!tipos.test(input.files[0].type)){alert("El archivo selecionado es inválido");return;}
	fr.onload=function(evt){
		var im=evt.target.result;
		redimensionar(im,150,150);
	}
    fr.readAsDataURL(input.files[0]);
});
$( "#Remover" ).click(function() {
    $("#foto").html('<div id="foto"></div>');
    $('#txtFoto').val("");
    $( "#Remover" ).hide();
});

function redimensionar(im,maxWidth,maxHeight){
	var i=new Image();
	i.onload=function(){
		var w=this.width,
		h=this.height,
		scale=Math.min(maxWidth/w,maxHeight/h),
		canvas=document.createElement('canvas'),
		ctx=canvas.getContext('2d');
		canvas.width=w*scale;
		canvas.height=h*scale;
		ctx.drawImage(i,0,0,w*scale,h*scale);
                $("#foto").html('<img class="fileupload-preview thumbnail" src="'+canvas.toDataURL()+'">');
		$('#txtFoto').val(canvas.toDataURL());
                 $( "#Remover" ).show()();
		
	}
	i.src=im;
}  
			App.init();
                        
                        $('#form').validate({
            onkeyup: false,
            errorClass: 'error',
            validClass: 'valid',
            rules: {
                    txtNombres: { required: true},
                    txtAPaterno: { required: true},
                    txtAMaterno: { required: true},
                    txtDNI: { required: true},
                    txtTelefono: { required: true},
                    txtCelular: { required: true},                        
                    txtEmail: { required: true },
                    txtDireccion: { required: true },
                    rbEstado: { required: true },
                    txtClave: { required: true },
                    txtFNacimiento: { required: true },
                    txtFoto: { required: true }
                    
                            
            },
            submitHandler: function() {    
                 var url = "ajax/personal/operacion.jsp"; 
                $.ajax({
                       type: "POST",
                       url: url,
                       data: $("#form").serialize(), 
                       success: function(data)
                       {
                           if(data>0)
                           {
                                $.gritter.add({text: 'Se grabo Correctamente.'});
                                tabla();    
                                 $('#form')[0].reset();
                                 $("#foto").html('<div id="foto"></div>');
                                 $( "#Remover" ).hide();
                           }else if(data==0)
                           {
                                 $.gritter.add({text: 'Se actualizo Correctamente.'});
                                 tabla();
                                  $('#form')[0].reset();
                                  $("#foto").html('<div id="foto"></div>');
                                  $( "#Remover" ).hide();
                           }else if(data==-1)
                           {
                               $.gritter.add({text: 'Problemas con el Sevidor intentelo mas tarde.'});
                           }
                           $('#Id').val("");


                       }
                     });    
            },
            highlight: function(element) {
                    $(element).closest('div').addClass("f_error");
            },
            unhighlight: function(element) {
                    $(element).closest('div').removeClass("f_error");
            },
            errorPlacement: function(error, element) {
                    $(element).closest('div').append(error);
            }
        }); 
        
        $('#txtFNacimiento').datepicker();
		});
            function edit_form(id,nombre,materno,paterno,dni,idTipo,idDeprtamento,idProvincia,idDistrito,telefono,celular,email,direccion,nacimiento,clave,estado) {
                    $('#Id').val(id);
                    $('#txtNombres').val(nombre);
                    $('#txtAPaterno').val(paterno);
                    $('#txtAMaterno').val(materno);
                    $('#txtDNI').val(dni);
                    $("select#cbTipoPersonal").val(idTipo); 
                     getUbigeo(idDeprtamento,idProvincia,idDistrito);
                    $('#cbProvincia').val(nombre);
                    $('#txtTelefono').val(telefono);
                    $('#txtCelular').val(celular);
                    $('#txtEmail').val(email);
                    $('#txtDireccion').val(direccion);
                    $('#txtDescripcion').val(nacimiento);
                    $('#txtFNacimiento').val(nacimiento);              
                    $('#txtClave').val(clave); 
                    
                    var url = "ajax/personal/get_foto.jsp?Id="+id; 
                    $("#foto").html("<img  id='foto' style='height:150px;width:120px' <img src='"+url+"'>");
                    $( "#Remover" ).show();
                     $('#txtFoto').val(url); 
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