<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pizzeria Tyyni - Ostoskori</title>
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
			
			<div id="pizzalista">
			<div id="pizzablock">
				<p class="otsikko">Ostoskori:</p>
				<hr class="pviiva" />
				<c:forEach items="${kori.ostokset}" var="k">

					<table>
						<tr>
							<td class="pnimi"><c:out value="${k.pizza.id}. " /> <c:out
									value="${k.pizza.nimi}" /></td>
									<td></td>
							<td class="phinta"><fmt:formatNumber type="number"
									minFractionDigits="2" maxFractionDigits="2" value="${k.rivihinta}" />
								&#x20ac;</td>
						</tr>
						<tr>
							<td>
							<c:if test="${k.valkosipuli == true}">
							valkosipuli
							</c:if>
							<c:if test="${k.oregano == true}">
							oregano
							</c:if>
							</td>
							<td>
							<c:out value="Määrä: ${k.lkm }"/>
							</td>
							
							<td class="c_nappula">
								<form action="menu" method="post">
									<button class="pnappula" type="submit" value="del">Poista</button>
									<input type="hidden" name="oId" value="${k.oId}"> <input
										type="hidden" name="action" value="del">
								</form>
							</td>
						</tr>

					</table>

				</c:forEach>
				<hr class="pviiva" />
					<form action="tilaus.jsp">
					<input class="nappula" type="submit" value="Osta">
				</form>
				</div>
				</div>
		</div>

		<div id="footer">Copyright © 2014 Pizzeria Tyyni</div>

	</div>
</body>
</html>