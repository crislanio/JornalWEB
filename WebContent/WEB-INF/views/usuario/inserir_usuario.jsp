<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="pt">
<head>
</head>

<body>
	<c:import url="/includes/cabecalho.jsp" />
	
	<h1>Inserir Usuario</h1>
	<form  action="adicionarUsuario" method="post">
		Nome: <input type="text" name="nome" /> <br />
		<form:errors cssStyle="color:red" path="usuario.nome"/> <br />
		Login: <input type="text" name="login"><br />
		<form:errors cssStyle="color:red" path="usuario.login"/> <br />
		Senha: <input type="text" name="senha" /> <br />
		<form:errors cssStyle="color:red" path="usuario.senha"/> <br />
		Email: <input type="text" name="email" /> <br />
		<form:errors cssStyle="color:red" path="usuario.email"/> <br />
		 <input type="hidden" name="id_role" value="1">
		
		<input type="submit" value="Inserir" /> <br />
	</form>
	<div class="linha">
		<section>
			<footer> 	
				<c:import url="/includes/feed_noticias.jsp" />		
				<c:import url="/includes/rodape.jsp" />
			 </footer>
		</section>
	</div>
	
</body>
</html>