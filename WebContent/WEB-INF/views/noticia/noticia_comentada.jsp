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
		     	  	<c:if test="${noticia.caminho_imagem != null}">
						<img src="/imagens_noticia/${noticia.caminho_imagem}" alt="img noticia" class="img-thumbnail">	
					</c:if>
   		   		
		     	    <h1> ${noticia.titulo } </h1>
   			   		<h3> ${noticia.subtitulo } </h3>
   		   			<h4><b>Autor da Noticia:</b> ${noticia.autor.nome }</h4>
		      		 <div id="texto_noticia">
						${noticia.texto}
				  	</div> 	
    		</div>
			<c:forEach var="role" items="${usuario.roles}">	
		   
        		<c:if test="${role.papel=='leitor'}">
				
					<div id="id_comentario" align="left">
       					  <c:forEach var="comentario" items="${comentarios}" >
			   	         <div>
            				    <div>
               		   				 <h5> Autor Comentário: </h5>
					                 <h4> ${comentario.autor.nome }</h4>
			   		             </div>
                
            				    <h4> Comentário: </h4>
              				   	<div>
									${comentario.texto }
								</div>
            				 </div> 			 
		 	      	  </c:forEach>
       				</div>
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