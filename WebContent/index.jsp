<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt">
<head>
</head>
<body>
	<c:import url="includes/apresentacao.jsp"/>
	<c:import url="includes/cabecalho.jsp"/>
	
		<a href="autenticacao_login"> Logar</a> <br><br>
		
	<div class="linha">
		<section>
			<c:import url="includes/secao_extra.jsp"/>
			
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
	
	
	<!-- begin PAGE SAPERE AUDE FACEBOOK -->
	<div class="fb-page" data-href="https://www.facebook.com/pages/Sapere-aude-Dare-To-Know-Ouse-saber/1430881630544157" data-width="1500" data-height="750" data-hide-cover="true" data-show-facepile="true" data-show-posts="true"><div class="fb-xfbml-parse-ignore"><blockquote cite="https://www.facebook.com/pages/Sapere-aude-Dare-To-Know-Ouse-saber/1430881630544157"><a href="https://www.facebook.com/pages/Sapere-aude-Dare-To-Know-Ouse-saber/1430881630544157">Sapere aude: Dare To Know , Ouse saber</a></blockquote></div></div>
	<!-- end PAGE SAPERE AUDE FACEBOOK -->
	
	
    <footer> <c:import url="includes/feed_noticias.jsp" /> </footer>
	<footer> <c:import url="includes/rodape.jsp" /> </footer>

</body>
</html>







