<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt">
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
</body>
</html>

<header class="header"  >

		<nav class="navbar navbar-custom" role="navigation">

			<div class="container">

				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#custom-collapse">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="index.jsp"><b>${param.nome}</b> Crislanio Macêdo</a>
				</div>

				<div class="collapse navbar-collapse" id="custom-collapse">
					<ul class="nav navbar-nav navbar-right">
						<li><a href="/Jornal/">home</a></li>
						<li><a href="/Jornal/consultar_no_dominio_ufc.jsp">consulte no dominio ufc</a></li>
						<li><a href="/Jornal/noticias.jsp">Ver Notícias</a></li>
						<li><a href="/Jornal/contato.jsp">contato</a></li>
						<li><a href="/Jornal/formularioLogin">login</a></li>
					
						<li>
							<!-- INICIO PLUGIN FACEBOOK -->	
								<div class="fb-login-button" data-max-rows="1" data-size="medium" data-show-faces="true" data-auto-logout-link="false"></div>
							<!-- FINAL PLUGIN FACEBOOK -->
						</li>

						<!-- 
						
						<li>
						
							<div class="container">
							<div class="row">
    					    <div class="span12">
				        	    <form id="custom-search-form" class="form-search form-horizontal pull-right">
                					<div class="input-append span12">
			    	            	    <input type="text" class="search-query mac-style" placeholder="você quer encontrar o quê na UFC?">
            				       	 <button type="submit" class="btn"><i class="icon-search"></i></button>	
	    	            			</div>
    	       				 </form>
	    			    	</div>
    			    	</li>
				 -->	
						
						
					</ul>
				</div>

			</div><!-- .container -->

		</nav>

	</header>



