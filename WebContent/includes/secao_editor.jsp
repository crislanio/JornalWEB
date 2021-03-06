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


	<section id="services" class="pfblock pfblock-gray"> <c:forEach
		var="role" items="${usuario.roles}">

		<c:if test="${ role.papel=='editor'}">

			<div class="container">
				<div class="row">

					<div class="col-sm-3">

						<div class="iconbox wow slideInLeft">
							<div class="iconbox-icon">
								<span class="icon-puzzle"></span>
							</div>
							<div class="iconbox-text">
								<h3 class="iconbox-title">Inserir Jornalista</h3>
								<div class="iconbox-desc">
									<a href="formularioJornalista">Inserir Jornalista no Jornal</a>
								</div>
							</div>
						</div>

					</div>

					<div class="col-sm-3">

						<div class="iconbox wow slideInLeft">
							<div class="iconbox-icon">
								<span class="icon-puzzle"></span>
							</div>
							<div class="iconbox-text">
								<h3 class="iconbox-title">ainda n</h3>
								<div class="iconbox-desc">
									<a href="ckkk">ainda n</a>
								</div>
							</div>
						</div>

					</div>

					<div class="col-sm-3">

						<div class="iconbox wow slideInRight">
							<div class="iconbox-icon">
								<span class="icon-badge"></span>
							</div>
							<div class="iconbox-text">
								<h3 class="iconbox-title">Inserir Classificado</h3>
								<div class="iconbox-desc">
									<a href="formularioClassificado">Inserir Classificado</a>
								</div>
							</div>
						</div>

					</div>

					<div class="col-sm-3">

						<div class="iconbox wow slideInRight">
							<div class="iconbox-icon">
								<span class="icon-question"></span>
							</div>
							<div class="iconbox-text">
								<h3 class="iconbox-title">Inserir Seção</h3>
								<div class="iconbox-desc">
									<a href="formularioSecao">Inserir Seção</a>
								</div>
							</div>
						</div>

					</div>

				</div>
				<!-- .row -->
			</div>
			<!-- .container -->

		</c:if>
	</c:forEach> </section>

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