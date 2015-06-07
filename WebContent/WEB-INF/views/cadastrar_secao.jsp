<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="pt">
<head>   	
</head>

<body>
	<c:import url="/includes/cabecalho.jsp"/>
	<h1>Inserir Seção</h1>
	
	
	<form  action="cadastrarSecao" method="post">
		Título: <input type="text" name="titulo" /> <br />
		<form:errors cssStyle="color:red" path="secao.titulo"/> <br />
		Descrição: <textarea name="texto" id="mensagem"></textarea><br />
		<form:errors cssStyle="color:red" path="secao.descricao"/> <br />
		
		<input type="submit" value="Inserir" /> <br />
	</form>
	
	
	<div class="linha">
		<section>
		 <footer> <c:import url="/includes/feed_noticias.jsp" /> </footer>
		<footer> <c:import url="/includes/rodape.jsp" /> </footer>
		</section>
	</div>
</body>
</html>