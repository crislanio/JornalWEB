<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Crislanio Macedo - Desenvolvimento Web</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="css/estilo.css">
	<link rel="stylesheet" type="text/css" href='http://fonts.googleapis.com/css?familysRoboto:400,100,300,500,700'>
</head>
<body>
	<c:import url="cabecalho.jsp"/>
	
	<div class="linha">
		<section>
			<div class="coluna col5 sidebar">
				<h3>Localização</h3>
				<img src="img/cris225x300.jpg" alt="autor">
				<ul class="sem-padding sem-marcador">
					<li>Rua Laerte Pinheiro, 10</li>
					<li>Centro</li>
					<li>Quixadá-CE</li>
				</ul>
				<h3>Contato direto</h3>
				<ul class="sem-padding sem-marcador">
					<li>fone:<strong>(88) 9949-3257</strong></li>
					<li>Email:<strong>crilaniomacedo@live.com</strong></li>
					</p>
				<b><span style="color: #ff6600;">Site Pessoal</span>
				</b>
				<ul>
					<li><span style="color: #0000ff;"><a style="color: #0000ff;" title="Blog Pessoal" href="https://www.crislaniomacedo.zz.vc" target="_blank" rel="nofollow">crislaniomacedo.zz.vc</a></span></li>
				</ul>
				
				<b><span style="color: #ff6600;">CV Lattes  LinkedIn e Twitter</span>
				</b>
				<ul>
					<li><span style="color: #0000ff;"><a style="color: #0000ff;" title="linkedin" href="https://www.linkedin.com/profile/view?id=281863658&amp;trk=nav_responsive_tab_profile_pic" target="_blank" rel="nofollow">linkedin</a></span></li>
					<li><span style="color: #0000ff;"><a style="color: #0000ff;" title="lattes capes" href="http://buscatextual.cnpq.br/buscatextual/visualizacv.do?id=K8754172J0" target="_blank" rel="nofollow">capes Lattes</a></span></li>
					<li><span style="color: #0000ff;"><a style="color: #0000ff;" title="twitter" href="https://twitter.com/crs_macedo" target="_blank" rel="nofollow">twitter</a></span></li>
				</ul>
				<span style="color: #ff6600;"><b>Compartilhamento</b></span>
				<ul>
					<li><span style="color: #0000ff;"><a style="color: #0000ff;" title="slide share" href="http://pt.slideshare.net/Crislanio_Souza" target="_blank" rel="nofollow">slideshare</a></span></li>
					<li><span style="color: #0000ff;"><a style="color: #0000ff;" title="youtube" href="https://www.youtube.com/channel/UCHg204hXu1yrrGwoT4Ge7lg" target="_blank" rel="nofollow">youtube</a></span></li>
					<li><span style="color: #0000ff;"><a style="color: #0000ff;" title="google sites" href="https://sites.google.com/site/crislaniocc/" target="_blank">google sites</a></span></li>
					<li><span style="color: #0000ff;"><a style="color: #0000ff;" title="academia.edu" href="https://ufc.academia.edu/CrislanioMacedo/Papers" target="_blank">academia</a></span></li>
				</ul>
				</ul>
			</div>
			<div class="coluna col7 contato">
				<h2>Envie sua mensagem</h2>
				<form>
					<label for="nome">Seu nome:</label>
					<input type="text" name="nome" id="nome" />
					<label for="email">Seu email:</label>
					<input type="text" name="email" id="email" />
					<label for="nome">Assunto:</label>
					<input type="text" name="assunto" id="assunto" />
					<label for="nome">Mensagem:</label>
					<textarea name="mensagem" id="mensagem"></textarea>
					<input type="submit" class="botao" name="enviar" value="Enviar mensagem &raquo;"/>
				</form>
			</div>
		</section>
	</div>
  <footer> <c:import url="feed_noticiasContato.jsp" /> </footer>
	<footer> <c:import url="rodape.jsp" /> </footer>
</body>
</html>







