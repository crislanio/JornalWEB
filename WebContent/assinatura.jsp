<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt">
<head>
<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author" content="">

	<title>Jornal Sapere Aude - Assinatura</title>

	<!-- CSS -->
	<link href="assets/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
	<link href="assets/css/font-awesome.min.css" rel="stylesheet" media="screen">
	<link href="assets/css/simple-line-icons.css" rel="stylesheet" media="screen">
	<link href="assets/css/animate.css" rel="stylesheet">
    
	<!-- Custom styles CSS -->
	<link href="assets/css/style.css" rel="stylesheet" media="screen">
    
    <script src="assets/js/modernizr.custom.js"></script>
     
</head>
<body>
	<c:import url="includes/cabecalho.jsp"/> <!-- Verificar home -->
		 
	 
	<!-- Testimonials start -->

	<section id="testimonials"  class="pfblock pfblock-gray">

		<div class="container" s>
            
            <div class="row" >

				<div class="col-sm-6 col-sm-offset-3">

					<div class="pfblock-header wow fadeInUp">
						<h2 class="pfblock-title">Não perca tempo Assine já</h2>
						<div class="pfblock-line"></div>
						<div class="pfblock-subtitle">
								<h1><strong><strong><span style="color: #0088da;">Assinaturas para Quixadá</span></strong></strong></h1>
								<p><strong> </strong></p>
								<p><strong>06 meses - R$ 20,00</strong></p>
								<p><strong>01 ano - R$ 40,00</strong></p>
								<p> </p>
								<h1><strong><span style="color: #cc0000;">Assinaturas Externas</span></strong></h1>
								<p><strong>06 meses - R$ 40,00</strong></p>
								<p><strong>01 ano - R$ 80,00</strong></p>
								<p> </p>
								<p><em><strong>Nota:</strong>Ambos os planos já incluem entrega em Quixadá e despesas postais para qualquer parte do Ceará</em></p>
								<p> </p>
								<p><strong>Solicite sua assinatura:</strong> 3517.0000 ou +55(88)9949.3257 (Crislene Macêdo)</p>
						
						</div>
					</div>

				</div>

			</div><!-- .row -->

            <div class="row">

			<div id="cbp-qtrotator" class="cbp-qtrotator">
                <div class="cbp-qtcontent">
                    <img src="assets/images/client-1.jpg" alt="client-1" />
                    <blockquote>
                      <p>Work with John was a pleasure. He understood exactly what I wanted and created an awesome site for my company.</p>
                      <footer>Crislânio Macêdo</footer>
                    </blockquote>
                </div>
                <div class="cbp-qtcontent">
                    <img src="assets/images/client-1.jpg" alt="client-2" />
                    <blockquote>
                      <p>I'm really happy with the results. Get 100% satisfaction is difficult but Alex got it without problems.</p>
                      <footer>Crislânio Macêdo</footer>
                    </blockquote>
                </div>

            </div>		

            </div><!-- .row -->

					
		</div><!-- .row -->
	</section>

	<!-- Testimonial end -->
	
	 <footer> <c:import url="includes/feed_noticias.jsp" /> </footer>
	 <footer> <c:import url="includes/rodape.jsp" /> </footer>
 
</body>
</html>







