<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<head>
<meta http-equiv="content-type" content="text/html;charset=utf-8"/>
<meta charset="UTF-8"/>
<title>Pizzeria Tyyni - Yhteenveto</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div id="wrapper">

		<div id="header">
			<div id="banner">
				<img class="logo" src="img/logo.png" alt="logo">
			</div>
			<nav id="nav">
				<ul>
					<li><a href="index.jsp">Koti</a></li>
					<li><a href="menu">Menu</a></li>
					<li><a href="kori.jsp">Kori</a></li>
					<li class="nav-bar-active"><a href="me.jsp">Me</a></li>
				</ul>
			</nav>
		</div>

		<div id="main">

			<div id="main_col">
								<div>
						<ul id="muru_step" class="muru">

							<li class="muru_alkudone"><span class="muru_text_todo">Kori</span></li>
							<li class="muru_keskidone"><span class="muru_text_todo">Tilaus</span></li>
							<li class="muru_keskidone"><span class="muru_text_todo">Yhteenveto</span></li>
							<li id="muru_end" class="muru_loppudone"><span class="muru_text_current">Vahvistus</span></li>

						</ul>
					</div>
			
				<p class="otsikko">Tilausvahvistus:</p>
				<hr class="viiva" />
				<p>Tilauksesi on vastaanotettu!</p>
				<br/>
				<p>Arvioitu toimitusaika 30-60min</p>
				<br/>
				<a href="index.jsp">Palaa etusivulle</a>

			</div>

		</div>

		<div id="footer">Copyright © 2014 Pizzeria Tyyni</div>

	</div>
</body>
</html>