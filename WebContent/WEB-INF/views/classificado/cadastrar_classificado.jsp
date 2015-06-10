<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="Jornal Sapere Aude">
	<meta name="author" content="Crislanio">

	<title>Crislânio Macêdo | Desenvolvimmento Web</title>

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
	
	<h1>Cadastrar Classificado</h1>
	<form action="cadastrarClassificado" method="post">
		Titulo   :<input type="text" name="titulo"><br> 
		Texto    :<input type="text" name="texto"><br>
		Telefone :<input type="text" name="telefone"><br>
		Preço    :<input type="text" name="preco"><br>
		
				  <input  type="hidden" name="login" value="${usuario.login}"><br>
		<input type="submit"><br>
	</form>

  <div class="linha">
		<section>
	            <footer>
	            	 <c:import url="/includes/rodape.jsp" /> 
	            </footer>
		</section>
	</div>
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