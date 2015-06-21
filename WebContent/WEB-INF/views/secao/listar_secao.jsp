
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
		Listar Seções: <b>${tamanho}</b>
	</h1>
	
	<table align="center" border="1px" width="80%">
		<thead>
			<tr>
				<th>Título</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="secao" items="${secoes}">
				<tr ng-repeat="secao in secoes">
					<c:if test="${not empty secao.noticias}">
						<td> <a href="descSecao?id_secao=${secao.id_secao}">${secao.titulo }</a> </td>
					</c:if>
						<!--
					<td><a href="deletarNoticia?id_noticia=${noticia.id_noticia}">
							Excluir </a></td>
					 -->
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="linha">
		<footer> <c:import url="/includes/rodape.jsp" /> </footer>
	</div>
</body>
</html>