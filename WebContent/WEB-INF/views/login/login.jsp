<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	<c:import url="/includes/cabecalho.jsp" />

	<div class="container">

		<form class="form-signin" action="fazerLogin" method="post">
			<c:if test="${usuario!=null }">
				<h1>Bem vindo,${usuario.nome}</h1>
			</c:if>

			<h2 class="form-signin-heading">EFETUAR LOGIN</h2>

			<label for="inputEmail" class="sr-only">Email address</label> <input
				name="login" type="email" id="inputEmail" class="form-control"
				placeholder="Email address" required autofocus> <label
				for="inputPassword" class="sr-only">Password</label> <input
				name="senha" type="password" id="inputPassword" class="form-control"
				placeholder="Password" required>
			<div class="checkbox">
				<label> <input type="checkbox" value="remember-me">
					Remember me
				</label>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
				in</button>
		</form>

	</div>


	<%-- <form action="fazerLogin" method="post">
		<c:if test="${usuario!=null }">
			<h1>Bem vindo,${usuario.nome}</h1>
		</c:if>

		<p align="left">
		<h3>EFETUAR LOGIN</h3>
		<form action="fazerLogin" method="post">
			Login :<input type="text" name="login"><br> Senha :<input
				type="password" name="senha"><br> <input type="submit"
				name="logar"> <br>

		</form>
		</p>
	</form>
	 --%>

	<div class="linha">
		<section> <footer> <c:import
			url="/includes/feed_noticias.jsp" /> <c:import
			url="/includes/rodape.jsp" /> </footer> </section>
	</div>
</body>
</html>