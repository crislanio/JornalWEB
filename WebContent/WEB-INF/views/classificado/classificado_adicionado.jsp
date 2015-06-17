<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Classificado Adicionado</title>
</head>
<body>
	<c:import url="/includes/cabecalho.jsp"/>

	O classificado <b>${param.titulo}</b> foi adicionado com sucesso!<br />
	<a href="index.jsp">Página principal</a>

	<div class="linha">
			<section>
				<footer> <c:import url="/includes/rodape.jsp" /> </footer>
			</section>
	</div>
	
</body>
</html>