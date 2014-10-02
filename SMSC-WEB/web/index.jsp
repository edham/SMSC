<%-- 
    Document   : index
    Created on : 01-oct-2014, 12:37:34
    Author     : EdHam
--%>

<%@page import="entidades.clsPersonal"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
clsPersonal objPersonal =(clsPersonal) request.getSession().getAttribute("SessionPersonal");
if(objPersonal==null)
{
%>
<html>
<head>
  <meta charset="utf-8" />
  <title>Sistema Móvil Seguridad Ciudadana</title>
  <meta content="width=device-width, initial-scale=1.0" name="viewport" />
  <meta content="SMSC" name="description" />
  <meta content="Servicios Ternologicos Integrales Sudamerica" name="author" />
  <link href="assets/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
  <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
  <link href="css/style.css" rel="stylesheet" />
  <link href="css/style_responsive.css" rel="stylesheet" />
  <link href="css/style_default.css" rel="stylesheet" id="style_color" />
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body id="login-body">
  <div class="login-header">
      <!-- BEGIN LOGO -->
      <div id="logo" class="center">
          <img src="img/logo.png" alt="logo" class="center" />
      </div>
      <!-- END LOGO -->
  </div>
       <div id="login">
    <!-- BEGIN LOGIN FORM -->
    <form id="loginform" class="form-vertical no-padding no-margin" action="">
      <div class="lock">
          <i class="icon-lock"></i>
      </div>
      <div class="control-wrap">
          <h4>Login Usuario</h4>
          <div class="control-group">
              <div class="controls">
                  <div class="input-prepend">
                      <span class="add-on"><i class="icon-user"></i></span><input id="username" name="username" type="text" placeholder="usuario" required/>
                  </div>
              </div>
          </div>
          <div class="control-group">
              <div class="controls">
                  <div class="input-prepend">
                      <span class="add-on"><i class="icon-key"></i></span><input id="password" name="password" type="password" placeholder="clave" required/>
                  </div>
                  <div class="mtop10">
                       <div class="block-hint pull-left small">
                          <input type="checkbox" id="">Recordarme
                      </div>
                      <div class="block-hint pull-right">
                          <a href="javascript:;" class="" id="forget-password">Descarga APK Android</a>
                      </div>
                  </div>

                  <div class="clearfix space5"></div>
              </div>

          </div>
      </div>

      <input type="submit" id="login-btn" class="btn btn-block login-btn" value="Login" />
    </form>
    <!-- END LOGIN FORM -->        
    <!-- BEGIN FORGOT PASSWORD FORM -->
    <form id="forgotform" class="form-vertical no-padding no-margin hide" action="index.html">
      <p class="center">Descargar Aplicaciones</p>
      <div class="mtop10">
                       <div class="block-hint pull-left small">
                           <a href="apk/SMSCUsuario.apk"> <img src="img/apk/cell.png" alt="Admin Lab" /></a>
                      </div>
                      <div class="block-hint pull-right">
                            <a href="apk/SMSCSeguridad.apk"> <img src="img/apk/tablet.png" alt="Admin Lab" /></a>
                      </div>
       </div>      
      <input type="button" id="forget-btn" class="btn btn-block login-btn" value="Volver" />
    </form>
    <!-- END FORGOT PASSWORD FORM -->
  </div>
  <!-- BEGIN LOGIN -->

  <!-- BEGIN COPYRIGHT -->
  <div id="login-copyright">
      2014 &copy; Servicios Ternologicos Integrales Sudamerica
  </div>
  <!-- END COPYRIGHT -->
  <!-- BEGIN JAVASCRIPTS -->
  <script src="js/jquery-1.8.3.min.js"></script>
  <script src="assets/bootstrap/js/bootstrap.min.js"></script>
  <script src="js/jquery.blockui.js"></script>
   <script src="assets/validation/jquery.validate.min.js"></script>
   <script type="text/javascript" src="assets/gritter/js/jquery.gritter.js"></script>
   <link rel="stylesheet" type="text/css" href="assets/gritter/css/jquery.gritter.css" />
  <script src="js/scripts.js"></script>
  <script>
    jQuery(document).ready(function() {     
      App.initLogin();
      
      $('#loginform').validate({
            onkeyup: false,
            errorClass: 'error',
            validClass: 'valid',
            rules: {
                    username: { required: true},
                    password: { required: true }
            },
            submitHandler: function() {    
                 var url = "ajax/personal/login.jsp"; 
                $.ajax({
                       type: "POST",
                       url: url,
                       data: $("#loginform").serialize(), 
                       success: function(data)
                       {
                           if(data==1)
                           {
                                window.location='intranet.jsp'; 

                           }else if(data==0)
                           {
                               $.gritter.add({text: 'Error de Credenciales.'});
                           }else if(data==-1)
                           {
                               $.gritter.add({text: 'Problemas con el Sevidor intentelo mas tarde.'});
                           }


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
    });
  </script>
  <!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>
<%}else  
    response.sendRedirect("intranet.jsp");%>   