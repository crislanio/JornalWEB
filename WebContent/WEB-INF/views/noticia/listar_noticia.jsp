
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
</head>
<body>
	<c:import url="/includes/cabecalho.jsp" />

	<h1>
		Listar Noticias: <b>${tamanho}</b>
	</h1>
	
	<table align="center" border="1px" width="80%">
		<thead>
			<tr>
			<!-- 	<th>Autor</th>  -->
				<th>Título</th>
				<th>Subtítulo</th>
				<th>Data notícia</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="noticia" items="${noticias}">
				<tr ng-repeat="noticia in noticias">
			<!--	<td>${noticia.autor.nome }</td>  -->
					<td>${noticia.titulo }</td>
					<td>${noticia.subtitulo }</td>
					<td>${noticia.data_noticia }</td>
					<td><a href="deletarNoticia?id_noticia=${noticia.id_noticia}">
							Excluir </a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="linha">
		<footer> <c:import url="/includes/rodape.jsp" /> </footer>
	</div>
</body>
</html>