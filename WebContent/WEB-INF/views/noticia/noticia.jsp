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
		<ul>
		<c:forEach var="noticia" items="${noticias}">
			<li>
			<div id="div_noticia">
				<h1>${noticia.titulo }</h1>
				<h3>${noticia.subtitulo}</h3>
				<div id="texto_noticia">
					${noticia.texto}
				</div>
				<h6>${noticia.autor.nome}</h6>
			</div>
			</li>
		</c:forEach>
	</ul>
	
<div class="linha">
		<section>
				<footer> <c:import url="/includes/rodape.jsp" /> </footer>
		</section>
	</div>
	
</body>
</html>