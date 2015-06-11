<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:import url="/includes/cabecalho.jsp"/>
		<center>
	Classificado<br>
	<c:forEach var="classificado" items="${classificados}">
		<table border=1 cellspacing=1 cellpadding=3 bordercolor="780570">
			<tr>
				<td>Titulo</td>
				<td>${classificado.titulo }</td>
			</tr>
			<tr>	
				<td>Descrição</td>
				<td>${classificado.texto }</td>
			</tr>	
			<tr>
				<td>preço</td>
				<td>${classificado.preco }</td>
			</tr>
			<tr>
				<td>telefone</td>
				<td>${classificado.telefone}</td>
			</tr>	
			<tr>
				<td>Melhor oferta</td>
				<td>${classificado.melhor_oferta }</td>
			</tr>
			<tr>	
				<td>Data</td>
				<td>${classificado.data_oferta }</td>
			</tr>
			<c:forEach var="role" items="${usuario.roles}">
			
				<c:if test="${ role.papel=='leitor'}">
					<tr>	
						<td>Oferta</td>
						<td>
							${id_classificado}
							<a href="ofertar" >Ofertar</a>	
						</td>
					</tr>
			   </c:if>
					
			</c:forEach>
			
		<table><br>
	</c:forEach>
	
	</center>
	
	<section>
		<footer> <c:import url="/includes/rodape.jsp" /> </footer>
	</section>
	
	</div>
</body>
</html>