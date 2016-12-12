<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tu pedido</title>
</head>
<body>
	<header>
	<div class="container-fluid">
		<div class="col-md-12 text-center">
			<img alt=""
				src="https://www.mercadona.es/imagenes/1415435237___esp/logomercavertical.gif">
		</div>
	</div>
	</header>
	<br>
	<br>
	<div class="row text-center">
		<h3><%=session.getAttribute("usuario")%>
		</h3>
	</div>
	<div class="container-fluid">
		<div class="row">
			
			<% 
			int i=0;
			ResultSet rs = (ResultSet) (request.getAttribute("producto"));
			while(rs.next()) {
				if(i%2==0){
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
					<p> <%= rs.getString("cantidad") %>  </p><br></b></h3>
					<form action='confirmar' method="post"> 
					<input name="aceptar" type="submit" value="Aceptar"><br>
					<input name="cancelar" type="submit" value="Cancelar"><br>
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



</body>
</html>