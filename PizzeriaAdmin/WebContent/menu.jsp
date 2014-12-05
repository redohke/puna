<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="Javascript/js.js"></script>
<title>Pizzeria Tyyni - Menu</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/Animate.css">
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
					<li class="nav-bar-active"><a href="menu">Menu</a></li>
					<li><a href="kori.jsp">Kori</a></li>
					<li><a href="me.jsp">Me</a></li>
				</ul>
			</nav>
		</div>

		<div id="main">
			<div id="pizzalista">
				<div id="pizzablock">
					<p class="otsikko">Pizzalista:</p>

					<c:forEach items="${plista}" var="pl">
						<hr class="pviiva" />
						<form action="menu" method="post">
							<table class="ptaulu">
								<tr>
									<td class="pnimi"><c:out value="${pl.id}. " /> <c:out
											value="${pl.nimi}" /></td>
									<td class="phinta"><fmt:formatNumber type="number"
											minFractionDigits="2" maxFractionDigits="2"
											value="${pl.hinta}" /> &#x20ac;</td>
								</tr>
								<tr>
									<td class="ptayte"><c:forEach items="${pl.taytteet}"
											var="tayte" varStatus="status">
    								${tayte}<c:if test="${!status.last}">,</c:if>
										</c:forEach></td>
								</tr>
								<tr>
									<td class="pmauste"><input type="checkbox" name="oregano"
										value="1"> oregano <input type="checkbox"
										name="valkosipuli" value="1"> valkosipuli</td>
									<td>Määrä: <select name="lkm">
											<option value="1">1 kpl</option>
											<option value="2">2 kpl</option>
											<option value="3">3 kpl</option>
											<option value="4">4 kpl</option>
											<option value="5">5 kpl</option>
											<option value="6">6 kpl</option>
											<option value="7">7 kpl</option>
											<option value="8">8 kpl</option>
											<option value="9">9 kpl</option>
									</select> <input type="hidden" name="action" value="add"> <input
										type="hidden" name="id" value="${pl.id}">
										<button class="nappula" type="submit" value="add">Tilaa</button>
									</td>
								</tr>
							</table>
						</form>
					</c:forEach>
					<hr class="pviiva" />
				</div>
			</div>
			<div id="juomalista">
				<div id="pizzablock">
					<p class="otsikko">Juomalista:</p>

					<c:forEach items="${jlista}" var="jl">
						<hr class="pviiva" />
						<form action=menu method="post">
							<table class="ptaulu">
								<tr>
									<td class="pnimi"><c:out value="${jl.id}. " /> <c:out
											value="${jl.nimi}" /></td>
									<td class="phinta"><fmt:formatNumber type="number"
											minFractionDigits="2" maxFractionDigits="2"
											value="${jl.hinta}" /> &#x20ac;</td>
								<tr>
								</tr>
								<tr>
									<td class="pmauste"></td>
									<td>Määrä: <select name="lkm">
											<option value="1">1 kpl</option>
											<option value="2">2 kpl</option>
											<option value="3">3 kpl</option>
											<option value="4">4 kpl</option>
											<option value="5">5 kpl</option>
											<option value="6">6 kpl</option>
											<option value="7">7 kpl</option>
											<option value="8">8 kpl</option>
											<option value="9">9 kpl</option>
									</select> <input type="hidden" name="action" value="jadd"> <input
										type="hidden" name="id" value="${jl.id}">
										<button class="nappula" type="submit" value="jadd">Tilaa</button>


									</td>
								</tr>
							</table>
						</form>
					</c:forEach>
					<hr class="pviiva" />
				</div>
			</div>
		</div>

		<div id="footer">Copyright © 2014 Pizzeria Tyyni</div>
		<%-- TÄSTÄ ALKAA LEIJUVA OSTOSKORI --%>

		<c:if test="${not empty kori.ostokset}">
			<%-- Tästä alkaa vihreä nappi --%>

			<p id="greenKori">
				TUOTTEITA OSTOSKORISSA <img src="img/koriv.png" width="52px"
					height="40px"></img>
			</p>


			<%-- Tähän loppuu vihreä nappi --%>
			<div>
				<div id="openCart" class="cart animated bounce">
					<div id="leijuvaKori">

						<p class="otsikko">Ostoskori:</p>

						<hr class="viiva" />
						<c:if test="${empty kori.ostokset}">
							<p>
								<i>Kori on tyhjä.</i>
							</p>
						</c:if>
						<c:forEach items="${kori.ostokset}" var="k" varStatus="looppi">

							<table class="ktaulu">
								<tr>
									<td class="pnimi"><c:out value="${k.tuote.id}. " /> <c:out
											value="${k.tuote.nimi}" /> <c:out value=" x${k.lkm}" /></td>
									<td></td>
									<td class="phinta"><fmt:formatNumber type="number"
											minFractionDigits="2" maxFractionDigits="2"
											value="${k.rivihinta}" /> &#x20ac;</td>
								</tr>

								<tr>

									<td><c:if
											test="${k.tuote.getClass().simpleName == 'Pizza'}">
											<c:forEach items="${k.tuote.taytteet}" var="tayte"
												varStatus="status">
                                                                ${tayte}<c:if
													test="${!status.last}">,</c:if>
											</c:forEach>
										</c:if></td>
								</tr>
								<tr>
									<td class="mnimi"><c:if
											test="${k.tuote.getClass().simpleName == 'Pizza'}">
											<c:if test="${k.valkosipuli == true}">                                                   
                                                        valkosipuli<c:if
													test="${k.valkosipuli == true && k.oregano == true}">,
                                                        </c:if>

											</c:if>
											<c:if test="${k.oregano == true}">
                                                        oregano
                                                        </c:if>
										</c:if></td>

									<td></td>

									<td class="c_nappula">
										<form action="menu" method="post">
										<input type="hidden" name="action" value="quickDel">
											<input type="hidden" name="rivinumero"
												value="<c:out value="${looppi.index}"/>">
											<button class="pnappula" type="submit" value="quickDel">Poista</button>
										</form>
									</td>
								</tr>
							</table>
							<br />

						</c:forEach>
						<br />
						<hr class="viiva" />
						<c:if test="${not empty kori.ostokset}">
							<table>
								<tr>
								<td>
									<img id="lLogo" class="floatLogo" src=img/charLogo.png
										width="200" height="150"></img></td>
									<td id="TyhOst">
										<div>
											<form action="menu" method="post">
												<input type="hidden" name="action" value="clear">
												<button id="nappi" type="submit" value="clear">Tyhjennä</button>
											</form>
											<form action="tilaus.jsp">
												<input id="nappi2" type="submit" value="Osta">
											</form>
										</div>

									</td>

								</tr>
							</table>
						</c:if>

					</div>

				</div>
			</div>
		</c:if>

		<c:if test="${not empty kori.ostokset}">
			<div id="TyhOstSmall" class="animated bounce">
				<form action="menu" method="post">
					<input type="hidden" name="action" value="clear">
					<button id="nappi" style="float: left;" type="submit" value="clear">Tyhjennä</button>
				</form>
				<form action="tilaus.jsp">
					<input id="nappi2" style="float: left;" type="submit" value="Osta">
				</form>
			</div>
		</c:if>
		<%-- TÄHÄN LOPPUU LEIJUVA OSTOSKORI --%>

	</div>


</body>
</html>
