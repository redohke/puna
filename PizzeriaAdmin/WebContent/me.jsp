<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pizzeria Tyyni - Meistä</title>
<link href="css/Slider.css" rel="stylesheet" type="text/css" />
<script src="Javascript/Slider.js" type="text/javascript"></script>
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
				<p class="otsikko">Meistä lyhyesti:</p>
				<hr class="viiva" />
				<p> Sijaitsemme teekkarikylän sydämessä osoitteessa
				Otaniementie 9.<br> Olemme ensisijaisesti take away -ravintola,
				joten meillä<br> on ainoastaan 8 asiakaspaikkaa itse
				ravintolassa.<br>
				<br> Meiltä saat pizzat myös kotiin kuljetettuna.<br>
				<br> Muistathan myös opiskelija-alennuksemme!<br>
				</p>


			</div>

		
		

					<div id="me">

				<div id="sliderFrame">
					<div id="slider">
						<img src="images/uuni.jpg" alt="" /> <img
							src="images/pizzasisa.png" alt="" /> <img
							src="images/kotiinkuljetus.png" alt="" /> <img
							src="images/pizzeriaexterior.png" alt="" /> <img
							src="images/VikaPizza.png" />
					</div>
				</div>
				
			</div>

		
		</div>

		<div id="footer">Copyright © 2014 Pizzeria Tyyni</div>

	</div>
</body>
</html>