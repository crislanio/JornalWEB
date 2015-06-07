
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
		Listar usuarios: <b>${tamanho}</b>
	</h1>

	<table align="center" border="1px" width="80%">
		<thead>
			<tr>
				<th>Login</th>
				<th>Senha</th>
				<th>Nome</th>
				<th>Email</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="usuario" items="${usuarios}">
				<tr ng-repeat="usuario in usuarios">

					<td>${usuario.login}</td>
					<td>${usuario.senha}</td>
					<td>${usuario.nome}</td>
					<td>${usuario.email}</td>
					<td><a href="deletarUsuario?login=${usuario.login}">
							Excluir </a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
<div class="linha">
		<section>
	<footer> <c:import url="/includes/rodape.jsp" /> </footer>
		</section>
	</div>
</body>
</html>