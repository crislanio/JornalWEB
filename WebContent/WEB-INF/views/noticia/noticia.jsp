<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Notícia</title>
</head>
<body>
<c:import url="/includes/cabecalho.jsp"/>
	<h4>
	${noticia.secao.titulo }<br>
	${noticia.data_noticia }<br>
	Autor :${noticia.autor.nome }<br>
	</h4>
	<center>
	<div>
		<h1> ${noticia.titulo }</h1><br>	
		<h2> ${noticia.subtitulo }</h2><br>
		<h2> ${noticia.texto}</h2><br>
	</div>	
	</center>
		
<div class="linha">
		<section>
				<footer> <c:import url="/includes/rodape.jsp" /> </footer>
		</section>
	</div>
	
</body>
</html>