<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MERCADONA</title>
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
		<div class="col-md-12 text-center">
			<img  alt="" src="https://www.mercadona.es/imagenes/1415435237___esp/logomercavertical.gif">
		</div>
</header>
<br>
<br>

<div class="row">
	
	<div class="col-md-6 text-center">
		<h2><b>USUARIOS</b></h2>
			<form action="Login" method="post">
			<input name="usuario" type="text" placeholder="NOMBRE DEL CLIENTE"><br><br>
			<input name="pasrword" type="password" placeholder="Contraseña"><br><br>
			<input name="entrar" type="submit" value="Aceptar"><br>
			</form>
	</div>
	<div class="col-md-6 text-center">
			<form action="Login" method="post">
			<h2><b>NUEVO USUARIO</b></h2>
			<input name="nombre" type="text" placeholder="NOMBRE DEL CLIENTE"><br><br>
			<input name="apellido1" type="text" placeholder="Primer Apellido"><br><br>
			<input name="apellido2" type="text" placeholder="Segundo Apellido"><br><br>
			<input name="direccion" type="text" placeholder="Direccion"><br><br>
			<input name="edad" type="number" placeholder="edad"><br><br>
			<input name="usuario" type="text" placeholder="usuario"><br><br>
			<input name="pasrword" type="password" placeholder="Contraseña"><br><br>		
			<input name="registrarte" type="submit" value="Aceptar"><br>
			</form>
	</div>

</div>

</body>
</html>