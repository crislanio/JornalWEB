<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="Jornal Sapere Aude">
	<meta name="author" content="Crislânio Macêdo">

	<title>Seção Extra</title>
</head>
<body>
<c:import url="includes/cabecalho.jsp"/>
	<c:if test="${usuario!=null }">
		<h1>Bem vindo,${usuario.nome} </h1>
	</c:if>
	
	<p align="left">
		<h3>EFETUAR LOGIN </h3>
		<form  action="fazerLogin" method="post">
		Login :<input type="text" name="login"><br>
		Senha :<input type="password" name="senha"><br>
		<input type="submit" name="logar"> <br>

	</form>
	</p>
	
	
	<footer> <c:import url="includes/rodape.jsp" /> </footer>
</body>
</html>