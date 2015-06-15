<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
	<title>Crislânio Macêdo | Desenvolvimmento Web</title>
</head>
<body>
	<c:import url="/includes/cabecalho.jsp"/>
	<h1>Cadastrar Classificado</h1>
	<form action="cadastrarClassificado" method="post">
		Titulo   :<input type="text" name="titulo"><br> 
		Texto    :<input type="text" name="texto"><br>
		Telefone :<input type="text" name="telefone"><br>
		Preço    :<input type="text" name="preco"><br>
		
				  <input  type="hidden" name="login" value="${usuario.login}"><br>
		<input type="submit"><br>
	</form>

	 <c:import url="/includes/rodape.jsp" /> 
	        
	</div>
</body>
</html>