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
	<h1>Inserir Noticia</h1>
	
	
	<form  method="POST" enctype="multipart/form-data" action="add_noticia">
		Título: <br /> <input type="text" name="titulo" /> 
		<form:errors cssStyle="color:red" path="noticia.titulo"/>
		
		<select name="id_sec" >
			<c:forEach var="secao" items = "${categoriaNoticias}">
				<option value=" ${secao.id_secao} ">${secao.titulo}</option>
			</c:forEach>
		</select>
			<br />
			
		Subtítulo: <br /><input type="text" name="subtitulo" /> <br />
		<form:errors cssStyle="color:red" path="noticia.subtitulo"/> <br />
		
		Texto: <br /><textarea name="texto" id="mensagem"></textarea><br />
		<form:errors cssStyle="color:red" path="noticia.texto"/> <br />
		 
		 <div>
			<label for="exampleInputEmail1">Imagem</label> 
			<input type="file" name="file">		
		</div>
		 
		Data da Notícia:<br /> <input type="date" name="data_noticia" /> <br />
		<form:errors cssStyle="color:red" path="noticia.data_noticia"/> <br />
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