<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pizzeria Tyyni</title>
<link href="css/Slider.css" rel="stylesheet" type="text/css" />
<script src="Javascript/Slider.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div id="wrapper">

		<div id="header">
			<div id="banner">
				<img class="logo" src="img/logo1.png" alt="logo">
			</div>
			<nav id="nav">
				<ul>
					<li class="nav-bar-active"><a href="index.jsp">Koti</a></li>
					<li><a href="menu">Menu</a></li>
					<li><a href="kori.jsp">Kori</a></li>
					<li><a href="me.jsp">Me</a></li>
				</ul>
			</nav>
		</div>

		<div id="main">

			<div id="main_col">
				<div id="sliderFrame">
					<div id="slider">
						<img src="img/Pizza.png" alt="" /> <img
							src="img/Limukka.png" alt="" /> <img
							src="img/kotiinkuljetus.png" alt="" /> <img
							src="img/Pizza 2.png" alt="" /> <img
							src="img/VikaPizza.png" alt="" />
					</div>

				</div>
			</div>

			<div id="left_col">
				<p class="otsikko">Palvelemme seuraavasti:</p>
				<hr class="viiva" />
				<table class="infotaulu">
					<tr>
						<td><img class="kuva" src="img/pizza7.png" alt="Opiskelija">
						</td>
						<td>Opiskelijakortilla kaikki pizzat -10%</td>
					<tr>
						<td class="irivi"><img class="kuva" src="img/round27.png"
							alt="Aukiolo"></td>
						<td>
							<table>
								<tr>
									<td>Ma-To</td>
									<td>10:00 - 23:00</td>
								</tr>
								<tr>
									<td>Pe-Su</td>
									<td>11:00 - 02:00</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td class="irivi"><img class="kuva" src="img/locator6.png"
							alt="Osoite"></td>
						<td>
							<table>
								<tr>
									<td>Otaniementie 9</td>
								</tr>
								<tr>
									<td>02150 Espoo</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td class="irivi"><img class="kuva" src="img/tablet41.png"
							alt="Puh"></td>
						<td>
							<table>
								<tr>
									<td>09 812 3456</td>
								</tr>
								<tr>
									<td>09 865 4321</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td class="irivi"><img class="kuva" src="img/bicycle5.png"
							alt="Puh"></td>
						<td>
							<table>
								<tr>
									<td>Toimitussäde 10km</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</div>
			<div id="right_col">
				<iframe class="s"
					src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d7935.176676219475!2d24.830083800000015!3d60.184139099999996!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x468df5ed5c13c5f3%3A0x2600b5523c18ef71!2sOtaniemi%2C+02150+Espoo!5e0!3m2!1sen!2sfi!4v1411368807431"
					width="432" height="265" style="border: 0"></iframe>
			</div>
			<div class="clear"></div>
		</div>

		<div id="footer">Copyright © 2014 Pizzeria Tyyni</div>

	</div>
</body>
</html>
