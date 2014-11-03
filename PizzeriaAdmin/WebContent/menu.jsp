<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
					<li><a href="#">Kori</a></li>
					<li><a href="#">Me</a></li>
				</ul>
			</nav>
		</div>

		<div id="main_lista">
			<div id="pizzalista">
				<p class="otsikko">Pizzalista:</p>

				<c:forEach items="${plista}" var="pl">
					<hr class="pviiva" />
					<form action=ruokalista method="post">
						<table class="ptaulu">
							<tr>
								<td class="pnimi"><c:out value="${pl.id}. " />
									<c:out value="${pl.nimi}" /></td>
								<td class="phinta"><c:out value="${pl.hinta}" />
									&#x20ac;</td>
							<tr>
								<td class="ptayte">
									<c:forEach items="${pl.taytteet}" var="tayte" varStatus="status">
    								${tayte}
    								<c:if test="${!status.last}">,</c:if>
									</c:forEach>
								</td>
							</tr>
							<tr>
								<td class="pmauste"><input type="checkbox" name="Oregano"
									value="1"> Oregano <input type="checkbox"
									name="Valkosipuli" value="2"> Valkosipuli</td>
								<td>Määrä: <input class="kentta" type="text" name="Määrä"
									value="1"> <input class="nappula" type="button"
									name="action" value="Tilaa">
								</td>
							</tr>
						</table>
					</form>
				</c:forEach>
				<hr class="pviiva" />
			</div>
		</div>



		<div id="footer">Copyright © 2014 Pizzeria Tyyni</div>
	</div>

</body>
</html>
