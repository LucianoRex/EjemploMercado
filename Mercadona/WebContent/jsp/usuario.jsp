<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/estilomerca.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript" src="js/scrip-super.js"></script>

<title>TU ESPACIO</title>
</head>
<body>
	<header>
		<div class="col-md-12 text-center">
			<img  alt="" src="https://www.mercadona.es/imagenes/1415435237___esp/logomercavertical.gif">
		</div>
	</header>
	<br>
	<br>
<div class="row text-center">
	<h3><b><%= session.getAttribute("usuario") %></b> </h3>
</div>
	<div class=row>
		<div class= "col-md-6 text-center" method="get">
		<h2><b>LISTA DE PRODUCTOS</b></h2>
		<a name="lista" href="ControlLista">
		<button>Lista</button>
		</a><br>
		</div>
		<div class= "col-md-6 text-center">
			<h2><b>TU LISTA DE PEDIDOS</b></h2>
			<a name="pedido" href="ControlPedidos">
			<button>Tus pedidos</button>
			</a><br>
		</div>
	
	
	</div>

</body>
</html>