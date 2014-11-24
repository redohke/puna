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
					<div>
						<ul id="muru_step" class="muru">

							<li class="muru_alkudone"><span class="muru_text_todo">Kori</span></li>
							<li class="muru_keskidone"><span class="muru_text_todo">Tilaus</span></li>
							<li class="muru_keskipuoldone"><span class="muru_text_current">Yhteenveto</span></li>
							<li id="muru_end" class="muru_loppu"><span class="muru_text_todo">Vahvistus</span></li>

						</ul>
					</div>
				<p class="otsikko">Tilauksen yhteenveto:</p>
				<hr class="viiva" />
				<table>
					<tr>
						<td><c:set var="ta" value="${tilaus.asiakas}" />
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
							<p class="pnimi">Maksu:</p>
						</td>
					</tr>
								<tr>
						<td>
							<p>Toimitustapa: <c:out value="${toimitus}"/></p>
						</td>
					</tr>
					<tr>
						<td>
							<p>Maksutapa: <c:out value="${maksu}"/></p>
						</td>
					</tr>
						<tr>
						<td>
							<p>&nbsp;</p>
						</td>
					</tr>

					<tr>
						<td>
							<p class="pnimi">Tuotteet:</p>
						</td>
					</tr>
					<tr>
						<td><c:forEach items="${tilaus.ostoskori.ostokset}" var="to"
								varStatus="looppi">
								<table>
									<tr>
										<td class="tnimi"><c:out value="${looppi.count}" /> <c:out
												value="${to.tuote.nimi}" /> x<c:out
												value="${ to.lkm}" /></td>
										<td><fmt:formatNumber type="number" minFractionDigits="2"
												maxFractionDigits="2" value="${to.rivihinta}" /> &#x20ac;</td>
									</tr>
									<tr>
										<td><c:if test="${to.tuote.getClass().simpleName == 'Pizza'}"><c:forEach items="${to.tuote.taytteet}" var="tayte"
												varStatus="status">
    								${tayte}<c:if test="${!status.last}">,</c:if>
											</c:forEach></c:if></td>
									</tr>
									<tr>
										<td><c:if test="${to.tuote.getClass().simpleName == 'Pizza'}"><c:if test="${to.tuote.valkosipuli == true}">
							valkosipuli</c:if><c:if test="${to.tuote.valkosipuli == true && to.tuote.oregano == true}">, 
							</c:if> <c:if test="${to.tuote.oregano == true}">
							oregano
							</c:if></c:if></td>
									</tr>
								</table>
								<br />
							</c:forEach></td>
					</tr>
					<tr>
								<td>
									<p class="pnimi">
										Yhteensä:
										<fmt:formatNumber type="number" minFractionDigits="2"
											maxFractionDigits="2" value="${hinta}" />
										&#x20ac; &#8199;
									</p>
								</td>
	</tr>
	<tr>
								<td>
									<p class="pnimi">
										Opiskelijalle:
										<fmt:formatNumber type="number" minFractionDigits="2"
											maxFractionDigits="2" value="${ohinta}" />
										&#x20ac; &#8199;
									</p>
								</td>
					</tr>
					<tr>
					<td>
					&#8199;
					</td>
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