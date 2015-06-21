<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Notícia Detalhada</title>
</head>
<body>
<c:import url="/includes/cabecalho.jsp"/>
	
		<ul>
	
			<div id="manchete">
				<h2 align="left">  ${noticia.secao.titulo } <br/> ${noticia.data_noticia } </h2>
		     	    <h1> ${noticia.titulo } </h1>
   			   		<h3> ${noticia.subtitulo } </h3>
   		   			<h4><b>Autor da Noticia:</b> ${noticia.autor.nome }</h4>
		      		 <div id="texto_noticia">
						${noticia.texto}
				  	</div> 	
    		</div>
			<c:forEach var="role" items="${usuario.roles}">	
		   
        	   <c:if test="${role.papel=='editor'}"> 
           	   		<a href="deletarNoticiaGeral?id_noticia=${noticia.id_noticia}">Excluir </a> <!--  -->
           	    </c:if>
       			
       			<c:if test="${role.papel=='jornalista'}">        
	            	<a href="deletarNoticiaGeral?id_noticia=${noticia.id_noticia}">Excluir </a> <!--  -->
           	    </c:if>
           	
				
				
				<c:if test="${role.papel=='leitor'}">
						<form action="Comments">
							<div>
								<textarea name="texto" id="mensagem"></textarea>
							</div>
							<input type="hidden" name="id_usuario" value="${usuario.id_usuario}" > 
							<input type="hidden" name="id_noticia" value="${noticia.id_noticia}" > 
							<input type="submit"  name="Comentar" >
						</form> 
				</c:if>	
				
	   </c:forEach>
	</ul>
	

<div class="linha">
		<section>
				<footer> <c:import url="/includes/rodape.jsp" /> </footer>
		</section>
	</div>
	
</body>
</html>