<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="Jornal Sapere Aude">
	<meta name="author" content="Crislânio Macêdo">

	<title>Seção Extra</title>

	<!-- CSS -->
	<link href="assets/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
	<link href="assets/css/font-awesome.min.css" rel="stylesheet" media="screen">
	<link href="assets/css/simple-line-icons.css" rel="stylesheet" media="screen">
	<link href="assets/css/animate.css" rel="stylesheet">
    
	<!-- Custom styles CSS -->
	<link href="assets/css/style.css" rel="stylesheet" media="screen">
    
    <script src="assets/js/modernizr.custom.js"></script>

</head>
<body>
<c:import url="includes/cabecalho.jsp"/>
	<c:if test="${usuario!=null }">
		<h1>Bem vindo,${usuario.nome} </h1>
	</c:if>
	
	<p align="left">
		<h1>EFETUAR LOGIN </h1>
		<form  action="fazer_login" method="post">
		Login :<input type="text" name="login"><br>
		Senha :<input type="password" name="senha"><br>
		<input type="submit" name="logar"> <br>

	</form>
	</p>
	<section id="services" class="pfblock pfblock-gray">
	
	<div class="row">

				<div class="col-sm-3">

					<div class="iconbox wow slideInLeft">
						<div class="iconbox-icon">
							<span class="icon-magic-wand"></span>
						</div>
						<div class="iconbox-text">
							<h3 class="iconbox-title">Inserir Usuário</h3>
							<div class="iconbox-desc">
								<a href="formularioUsuario">Inserir Usuario no Jornal</a>
							</div>
						</div>
					</div>

				</div>
	</section>
	
	<footer> <c:import url="includes/rodape.jsp" /> </footer>

<!-- Javascript files -->

	<script src="assets/js/jquery-1.11.1.min.js"></script>
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>
	<script src="assets/js/jquery.parallax-1.1.3.js"></script>
	<script src="assets/js/imagesloaded.pkgd.js"></script>
	<script src="assets/js/jquery.sticky.js"></script>
	<script src="assets/js/smoothscroll.js"></script>
	<script src="assets/js/wow.min.js"></script>
    <script src="assets/js/jquery.easypiechart.js"></script>
    <script src="assets/js/waypoints.min.js"></script>
    <script src="assets/js/jquery.cbpQTRotator.js"></script>
	<script src="assets/js/custom.js"></script>
</body>
</html>