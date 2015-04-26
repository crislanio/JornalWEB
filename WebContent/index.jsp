<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Crislanio Macedo - Desenvolvimento Web</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="css/estilo.css">
	<link rel="stylesheet" type="text/css" href='http://fonts.googleapis.com/css?familysRoboto:400,100,300,500,700'>
</head>
<body>
	<c:import url="cabecalho.jsp"/>
	
	<div class="linha">
		<section>
			<c:import url="secao_extra.jsp"/>
			
			<div class="coluna col9">
				<h2>Último trabalho: <em>PROJETO - APRENDIZAGEM COOPERATIVA</em></h2>
				
				<a target="_blank" href="https://www.quixada.ufc.br">
					<img class="ufc" src="img/logo1.JPG" alt=""/>			
				</a>
				<p>Bolsista do Programa de Aprendizagem Cooperativa em Células Estudantis – Ciência da
				Computação - Universidade Federal do Ceará - Quixadá</p>
				<h3><em>Título do Projeto:</em></h3>
				<p>Programação Funcional em Haskell.</p>
				<a href="clientes.html" class="botao">Ver outros trabalhos</a>
			</div>
		</section>
	</div>
    <footer> <c:import url="feed_noticias.jsp" /> </footer>
	<footer> <c:import url="rodape.jsp" /> </footer>
</body>
</html>







