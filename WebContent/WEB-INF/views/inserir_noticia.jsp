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
	<title>Inserir Noticia</title>
</head>
<body>
	<c:import url="cabecalho.jsp"/>
	<h1>Inserir Noticia</h1>
	<form  action="adicionarNoticia" method="post">
		Título: <input type="text" name="titulo" /> <br />
		<form:errors cssStyle="color:red" path="noticia.titulo"/> <br />
		Subtítulo: <input type="text" name="subtitulo" /> <br />
		<form:errors cssStyle="color:red" path="noticia.subtitulo"/> <br />
		Texto: <textarea name="texto" id="mensagem"></textarea><br />
		<form:errors cssStyle="color:red" path="noticia.texto"/> <br />
		Autor: <input type="text" name="autor" /> <br />
		<form:errors cssStyle="color:red" path="noticia.autor"/> <br />
		Data da Notícia: <input type="text" name="data_noticia" /> <br />
		<form:errors cssStyle="color:red" path="noticia.data_noticia"/> <br />
		
		<input type="submit" value="Inserir" /> <br />
	</form>
	 <footer> <c:import url="feed_noticias.jsp" /> </footer>
	<footer> <c:import url="rodape.jsp" /> </footer>
</body>
</html>