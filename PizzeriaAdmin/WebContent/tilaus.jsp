<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pizzeria Tyyni - Tilaus</title>
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
					<li class="nav-bar-active"><a href="kori.jsp">Kori</a></li>
					<li><a href="me.jsp">Me</a></li>
				</ul>
			</nav>
		</div>

		<div id="main">

			<div id="content">
				<p class="otsikko">Tilaus:</p>
				<hr class="viiva" />

				<form action="tilaus" method="post">
					<table>
						<tr>
							<th>Tilaajan tiedot:</th>
						</tr>
						<tr>
							<td class="tnimi">Etunimi: <input name="enimi" type="text">
							</td>
						</tr>
						<tr>
							<td class="tnimi">Sukunimi: <input name="snimi" type="text">
							</td>
						</tr>
						<tr>
							<td class="tnimi">Yritys: <input name="yr" type="text">
							</td>
						</tr>
						<tr>
							<td class="tnimi">Puhelin: <input name="puh" type="text">
							</td>
						</tr>
						<tr>
							<td class="tnimi">Sähköposti: <input name="email" type="text">
							</td>

						</tr>
						<tr>
							<td class="tnimi">Osoite: <input name="os" type="text">
							</td>
						</tr>
						<tr>
							<td class="tnimi">Postinumero: <input name="pnro" type="text">
							</td>
							<td class="tnimi">Kaupunki: <input name="kaup" type="text">
							</td>
						</tr>
												<tr>						
						<td>
						&nbsp;
						</td>
						</tr>
						<tr>
							<th>Toimitustapa:</th>
						</tr>
								<tr>
							<td><input type="radio" name="toimitus" value="koti" checked="checked">
								Kotiinkuljetus</td>
						</tr>
						<tr>
							<td><input type="radio" name="toimitus" value="paikka">
								Nouto</td>
						</tr>
												<tr>						
						<td>
						&nbsp;
						</td>
						</tr>
						<tr>
							<th>Maksutapa:</th>
						</tr>
						<tr>
							<td><input type="radio" name="maksu" value="cash" checked="checked">
								Käteinen</td>
						</tr>
						<tr>
							<td><input type="radio" name="maksu" value="luotto">
								Pankkikortti</td>
						</tr>
						<tr>
							<td><input type="radio" name="maksu" value="lounari">
								Lounasseteli</td>
								
						</tr>
						<tr>						
						<td>
						&nbsp;
						<input type="hidden" name="action" value="summary">
						</td>
						</tr>
						<tr>
							<td><input class="tnappula" type="submit" value="Takaisin"></td>
							<td><input class="tnappula" type="submit"
								value="Tilauksen yhteenvetoon"></td>
						</tr>
					</table>
				</form>
			</div>
		</div>

		<div id="footer">Copyright © 2014 Pizzeria Tyyni</div>

	</div>
</body>
</html>