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

	<c:if test="${usuario!=null }">
				<h1>Inserir Oferta,${usuario.nome}</h1>
	</c:if>
	
	   <form action="inserirOferta" method="post">
     	  Título:<br/> <h2>${classificado.titulo}</h2>
          <br/> <h2>${classificado.texto} </h2>
          Oferta:</b> <input type="text" name="oferta"></br>
          <input type="hidden" name="id" value="${classificado.id_classificado}"></br>
          <input type="hidden" name="idUser" value="${usuario.id_usuario}"></br>
          
          <input type="submit" value="Ofertar"></br>
          
          
     </form>
     
  
	 <c:import url="/includes/rodape.jsp" /> 
	        
	</div>
</body>
</html>