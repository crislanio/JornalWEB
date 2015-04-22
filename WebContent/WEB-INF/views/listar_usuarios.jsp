
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listar Usuarios</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>

	<c:import url="cabecalho.jsp" />
	<div>
		<br /> <a href="index.jsp">Página principal</a> <br /> <a
			href="#fim"> Ir para o final</a> <br />
	</div>
	<h1 id="topo">
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
					<td><a href="deletarUsuario?login=${usuario.login}"> Excluir </a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<h2>Index</h2>
	<div>
		<a href="index.jsp">Página principal</a> <br /> <a id="fim"
			href="#topo">ir para o topo</a> <br />
	</div>
	<footer> <c:import url="rodape.jsp" /> </footer>

</body>
</html>