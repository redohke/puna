<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html;charset=utf-8"/>
<meta charset="UTF-8"/>
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

				<form action="tilaus" method="post" autocomplete="on">
					<table>
						<tr>
							<th>Tilaajan tiedot:</th>
						</tr>
						<tr>
							<td class="tnimi">Etunimi: <input name="enimi" type="text" maxlength="30" required>
							</td>
						</tr>
						<tr>
							<td class="tnimi">Sukunimi: <input name="snimi" type="text" maxlength="30" required>
							</td>
						</tr>
						<tr>
							<td class="tnimi">Yritys: <input name="yr" type="text" maxlength="30">
							</td>
						</tr>
						<tr>
							<td class="tnimi">Puhelin: <input name="puh" type="tel" pattern="(\(?\+?\(?\d*\)?\d*)" maxlength="15" required>
							</td>
						</tr>
						<tr>
							<td class="tnimi">Sähköposti: <input name="email" type="email" maxlength="50" required>
							</td>

						</tr>
						<tr>
							<td class="tnimi">Osoite: <input name="os" type="text" maxlength="50" required>
							</td>
						</tr>
						<tr>
							<td class="tnimi">Postinumero: <input name="pnro" type="text" pattern="[\d*]{5}" maxlength="5"required>
							</td>
							<td class="tnimi">Kaupunki: <input name="kaup" type="text" maxlength="30" required>
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
							<td><input type="radio" name="toimitus" value="kotiinkuljetus" checked="checked">
								Kotiinkuljetus</td>
						</tr>
						<tr>
							<td><input type="radio" name="toimitus" value="nouto">
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
							<td><input type="radio" name="maksu" value="käteinen" checked="checked">
								Käteinen</td>
						</tr>
						<tr>
							<td><input type="radio" name="maksu" value="pankkikortti">
								Pankkikortti</td>
						</tr>
						<tr>
							<td><input type="radio" name="maksu" value="lounasseteli">
								Lounasseteli</td>
								
						</tr>
						<tr>						
						<td>
						&nbsp;
						<input type="hidden" name="action" value="summary">
						</td>
						</tr>
						<tr>
							<td><input class="tnappula" type="button" onclick="history.back(-1)" value="Takaisin"></td>
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