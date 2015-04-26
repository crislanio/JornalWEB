<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="css/estilo.css">
	<link rel="stylesheet" type="text/css" href='http://fonts.googleapis.com/css?familysRoboto:400,100,300,500,700'>		
	<title>Inserir Usuario</title>
</head>
<body>
	<c:import url="cabecalho.jsp" />
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
		
		<input type="submit" value="Inserir" /> <br />
	</form>
	
	<footer> <c:import url="feed_noticias.jsp" /> </footer>
	<footer> <c:import url="rodape.jsp" /> </footer>

</body>
</html>