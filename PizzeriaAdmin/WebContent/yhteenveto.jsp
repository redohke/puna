<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
					<li class="nav-bar-active"><a href="kori.jsp">Kori</a></li>
					<li><a href="me.jsp">Me</a></li>
				</ul>
			</nav>
		</div>

		<div id="main">

			<div id="content">
				<p class="otsikko">Tilauksen yhteenveto:</p>
				<hr class="viiva" />
				<table>
					<tr>
						<td><c:set var="ta" value="${tilaus.asiakas}" /> <c:set
								var="tk" value="${tilaus.ostoskori.ostokset}" />
							<p class="pnimi">Tilaaja:</p></td>
					</tr>
					<tr>
						<td>Etunimi: <c:out value="${ta.etunimi}" />
						</td>
					</tr>
					<tr>
						<td>Sukunimi: <c:out value="${ta.sukunimi}" />
						</td>
					</tr>
					<tr>
						<td>Yritys: <c:out value="${ta.yritys}" />
						</td>
					</tr>
					<tr>
						<td>Puhelinnumero: <c:out value="${ta.puh}" />
						</td>
					</tr>
					<tr>
						<td>Sähköposti: <c:out value="${ta.email}" />
						</td>
					</tr>
					<tr>
						<td>Osoite: <c:out value="${ta.osoite} " />
						</td>
					</tr>
					<tr>
						<td><c:out value="${ta.postnro} " /> <c:out
								value="${ta.kaupunki}" /></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td>
							<p class="pnimi">Tuotteet:</p>
						</td>
					</tr>
					<tr>
						<td><c:out value="${tk}" /> <c:out value="${tilaus}" /></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
					</tr>
				</table>
				<hr class="viiva" />
				<div>
					<form action="tilaus" method="post">
						<table>
							<tr>
								<td><input class="tnappula" type="button"
									onclick="history.back(-1)" value="Takaisin"></td>
								<td><input type="hidden" name="action" value="valmis">
									<input class="tnappular" type="submit" value="Vahvista tilaus">
								</td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</div>

		<div id="footer">Copyright © 2014 Pizzeria Tyyni</div>

	</div>
</body>
</html>