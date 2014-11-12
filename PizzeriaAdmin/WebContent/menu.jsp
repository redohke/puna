<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pizzeria Tyyni - Menu</title>
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
								<td class="phinta"><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${pl.hinta}"/> &#x20ac;</td>
							</tr>
							<tr>
								<td class="ptayte">							<c:forEach items="${pl.taytteet}" var="tayte" varStatus="status">
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
								</select>
									<input type="hidden" name="action" value="add"> 
									<input type="hidden" name="id" value="${pl.id}">
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
								<td class="phinta"><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${jl.hinta}"/> &#x20ac;</td>
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
										<option value="9">9 kpl</option></select>
										
										<input type="hidden" name="action" value="jadd"> 
										<input type="hidden" name="id" value="${jl.id}">
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
		<div id="openCart" class="cart">
		<c:if test="${not empty kori.ostokset}">

<div id="leijuvaKori" >
   
          <div id="pizzalista">
				<div id="pizzablock">
					<p >Ostoskori:</p>
					<c:if test="${empty kori}">
						<p>
							<i>Ostoskori on tyhjä.</i>
						</p>
						<br />
					</c:if>
					<c:forEach items="${kori.ostokset}" var="k">

						<table>
							<tr>
								<td><c:out value="${k.pizza.id}. " /> <c:out
										value="${k.pizza.nimi}" />
									<c:out value=" x${k.lkm}" /></td>
								<td></td>
								<td><fmt:formatNumber type="number"
										minFractionDigits="2" maxFractionDigits="2"
										value="${k.rivihinta}" /> &#x20ac;</td>
							</tr>
							<tr>
								<td><c:if test="${k.valkosipuli == true}">
							valkosipuli
							</c:if> <c:if test="${k.oregano == true}">
							oregano
							</c:if></td>
								<td></td>

								<td class="c_nappula">
									<form action="menu" method="post">
										<button class="pnappula" type="submit" value="userDel">Poista</button>
										<input type="hidden" name="oId" value="${k.oId}"> <input
											type="hidden" name="action" value="userDel">
									</form>
								</td>
							</tr>

						</table>

					</c:forEach>
				
				</div>
			</div>
          </div>

</c:if><c:if test="${not empty kori.ostokset}">
					<form action="menu" method="post">
										<button class="pnappula" type="submit" value="clear">Tyhj</button>
										 <input type="hidden" name="action" value="clear">
									</form>
						<form action="tilaus.jsp">
						<div align="right">
							<input class="nappula" type="submit" value="Osta" >
							</div>
						</form>
					</c:if>
</div>	
		<%-- TÄHÄN LOPPUU LEIJUVA OSTOSKORI --%>
	</div>

</body>
</html>
