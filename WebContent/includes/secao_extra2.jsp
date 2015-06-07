<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="Jornal Sapere Aude">
<meta name="author" content="Crislânio Macêdo">

<title>Seção Extra</title>

<!-- CSS -->
<link href="assets/bootstrap/css/bootstrap.min.css" rel="stylesheet"
	media="screen">
<link href="assets/css/font-awesome.min.css" rel="stylesheet"
	media="screen">
<link href="assets/css/simple-line-icons.css" rel="stylesheet"
	media="screen">
<link href="assets/css/animate.css" rel="stylesheet">

<!-- Custom styles CSS -->
<link href="assets/css/style.css" rel="stylesheet" media="screen">

<script src="assets/js/modernizr.custom.js"></script>

</head>
<body>
	<a href="classificado">Classificados </a>
	<br>
	<a href="listarNoticia">Listar Noticia </a>
	<br>
	<a href="formularioSecao">Cadastrar Seção no Jornal</a> <!--  TESTE A SEÇÃO TÁ VINDO NULA-->
	<br>		
	<a href="formularioClassificado">Cadastrar Classificado</a>  <!--  TESTE ao cadastrar-->
	<br>		
	<a href="formularioUsuario">Cadastrar Jornalista</a> <!--  TESTE ao cadastrar-->
	<br>
				

	<section id="services" class="pfblock pfblock-gray">
	<div class="container">
		<c:forEach var="role" items="${usuario.roles}">
			<c:if test="${role.role=='editor'}">
				<a href="listarUsuario">Listar Usuários Cadastrados</a>
				<br>
				<a href="formularioNoticia">Inserir uma Notícia no Jornal</a>
				<br>
				<a href="formularioUsuario">Cadastrar Jornalista</a>
				<br>
				<a href="formularioClassificado">Cadastrar Classificado</a>
				<br>
				<a href="formularioSecao">Cadastrar Seção no Jornal</a>
				<br>

			</c:if>

			<c:if test="${ role.role=='jornalista'}">

				<a href="formulario_noticia">Cadastrar Noticia </a>
				<br>
				<a href="lista_noticia">Apagar Noticia </a>
				<br>
			</c:if>
		</c:forEach>
	</div>
	<!-- .container --> </section>

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