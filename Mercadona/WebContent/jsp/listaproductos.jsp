<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista Productos</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/estilomerca.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript" src="js/scrip-super.js"></script>
</head>
<body>
<header>
<div class="container-fluid">
		<div class="col-md-12 text-center">
			<img  alt="" src="https://www.mercadona.es/imagenes/1415435237___esp/logomercavertical.gif">
		</div>
</div>
</header>
<br>
<br>
<div class="row text-center">
	<h3><%= session.getAttribute("usuario") %> <%= session.getAttribute("id") %> </h3>
</div>

<div class="container-fluid">
		<div class="row  col-md-12 text-center">
			<h1><b>LISTA DE PRODUCTOS </b></h1>
		</div>
</div>
<br>
<br>

	<div class="container-fluid">
		<div class="row">
			
			<% 
			int i=0;
			ResultSet rs = (ResultSet) (request.getAttribute("producto"));
			while(rs.next()) {
				if(i%3==0){
					i=0;
					%>
					</div>
					<div class="row">
					<%		
				}
			%>
			
					<div class="col-md-4 text-center">
					<p><img class="col-md-12 text-center" src='<%= rs.getString("imagen") %>'></p><br><br>
					<h3><b>
					<p> <%= rs.getString("nombre") %></p><br>
					<p> <%= rs.getString("precio") %> euros </p><br></b></h3>
					<form action='ControlCesta?id=<%=rs.getString("id")  %>' method="post"> 
					<input name="cantidad" type="num" placeholder="Cantidad"><br><br>
					<input name="incluir" type="submit" value="Aceptar"><br>
					</form>
					</div>
			
			<%
			i++;
			} %>

			</div>
		</div>
	<br>
	<br>
	<br>
	<br>	
	<div class="row">
		<div class= "col-md-6 text-center" method="get">
			
			<a name="fin" href="ControlCesta">
			<button>Finalizar Pedido</button>
			</a><br>
		</div>
		<div class= "col-md-6 text-center" method="get">
			
			<a name="Cancelar" href="/Mercadona/index.jsp">
			<button>Cancelar</button>
			</a><br>
		</div>
	</div>
</body>
</html>