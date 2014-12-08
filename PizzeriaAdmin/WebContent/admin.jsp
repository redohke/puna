<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pizzeria Tyyni - Admin</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body link ="#FF0000" alink ="#FF0000" vlink ="#FF0000">
<p style="text-align: right; color: red;"><c:out value="${kayttajatiedot.username}"/><br/>
<a href="text-color: red; "kirjaudu_ulos">Kirjaudu ulos</a>

	<div id="wrapper">

		<div id="header">
			<div id="admin_banner">
				<p class="aotsikko">Menun hallinta</p>
			</div>
		</div>

		<div id="main">

			<div class="admin_col">
				<p class="otsikko">Pizzojen lisäys:</p>
				<hr class="pviiva" />
				<form name="input" action="admin" method="post">
					<input type="text" name="pizza" placeholder="Pizzan nimi">
					<input type="text" name="hinta" placeholder="Hinta" size="5">
					<button class="nappula" type="submit">Lisää</button>
					<table>
						<tr>
							<c:forEach items="${tayte}" var="t" varStatus="looppi">
								<c:if test="${(looppi.index) % 5 == 0}">
						</tr>
						<tr>
							</c:if>
							<td class="pmauste"><input type="checkbox" name="tayte"
								value="${t.id}"> <c:out value="${t.nimi}" /></td>
							</c:forEach>
						</tr>
					</table>
					<input type="hidden" name="action" value="add">
				</form>
			</div>
			
			<c:if test="${not empty param.added}">
			<div class="admin_msg">
				<p>
					<i>Uuden pizzan lisääminen onnistui!</i>
				</p>
			</div>
		</c:if>

		<c:if test="${not empty param.removed}">
			<div class="admin_msg">
				<p>
					<i>Pizzan poisto onnistui!</i>
				</p>
			</div>
		</c:if>
		
				<c:if test="${not empty param.palautettu or not empty param.piilotettu}">
			<div class="admin_msg">
				<p>
					<i>Pizzan tila muutettu!</i>
				</p>
			</div>
		</c:if>
		
			<div class="admin_col">
				<p class="otsikko">Juomien lisäys:</p>
				<hr class="pviiva" />
				<form name="input" action="admin" method="post">
					<input type="text" name="juoma" placeholder="Juoman nimi">
					<input type="text" name="hinta" placeholder="Hinta" size="5">
					<button class="nappula" type="submit">Lisää</button>
					<input type="hidden" name="action" value="add2">
				</form>
			</div>
			
						<c:if test="${not empty param.added2}">
			<div class="admin_msg">
				<p>
					<i>Uuden juoman lisääminen onnistui!</i>
				</p>
			</div>
		</c:if>

		<c:if test="${not empty param.removed2}">
			<div class="admin_msg">
				<p>
					<i>Juoman poisto onnistui!</i>
				</p>
			</div>
		</c:if>
		
				<c:if test="${not empty param.palautettu2 or not empty param.piilotettu2}">
			<div class="admin_msg">
				<p>
					<i>Juoman tila muutettu!</i>
				</p>
			</div>
		</c:if>

			<div class="admin_col">
				<p class="otsikko">Listalla olevat pizzat:</p>
				<hr class="pviiva" />
				<table class="taulukko">
					<tr>
						<th></th>
						<th>Nimi</th>
						<th>Täytteet</th>
						<th>Tarjolla</th>
						<th>Hinta</th>
						<th>Komennot*</th>
					</tr>
					<c:forEach items="${plista}" var="pl" varStatus="looppi">
						<tr>
							<td class="c_id"><c:out value="${looppi.count}." /></td>
							<td class="c_nimi"><c:out value="${pl.nimi}" /></td>
							<td class="c_tayte"><c:forEach items="${pl.taytteet}"
									var="tayte" varStatus="status">
    								${tayte}<c:if test="${!status.last}">,</c:if>
								</c:forEach></td>
								<td class="c_nimi">
								<c:if test="${pl.tarjolla eq 1}">Kyllä</c:if>
								<c:if test="${pl.tarjolla eq 0}">Ei</c:if>

								
								</td>
							<td class="c_hinta"><fmt:formatNumber type="number"
									minFractionDigits="2" maxFractionDigits="2" value="${pl.hinta}" />
								&#x20ac;</td>

							<td>
								<table class="napit">
									<tr>
										<td>
											<form action="admin" method="post">
												<input type="hidden" name="id" value="${pl.id}"> <input
													type="hidden" name="action" value="palauta2">
													<button class="hnappula" type="submit">Näytä</button>
											</form>
										</td>
										<td>
											<form action="admin" method="post">
												<input type="hidden" name="id" value="${pl.id}"> <input
													type="hidden" name="action" value="piilota2">
													<button class="hnappula" type="submit">Piilota</button>
											</form>
										</td>
										<td><form action="admin" method="post">
												<input type="hidden" name="id" value="${pl.id}"> <input
													type="hidden" name="action" value="del">
													<button class="hnappula" type="submit">Poista</button>
											</form></td>
									</tr>
								</table>
							</td>
						</tr>
					</c:forEach>
				</table>
								<br/>
				<p>*Näytä ja Piilota painikkeet hallitsevat tuotteen näkyvyyttä Menu-sivulla</p>
			</div>

			<div class="admin_col">
				<p class="otsikko">Listalla olevat juomat:</p>
				<hr class="pviiva" />
				<table class="taulukko">
					<tr>
						<th></th>
						<th>Nimi</th>
						<th>Tarjolla</th>
						<th>Hinta</th>
						<th>Komennot</th>
					</tr>
					<c:forEach items="${jlista}" var="jl" varStatus="looppi">
						<tr>
							<td class="c_id"><c:out value="${looppi.count}." /></td>
							<td class="c_nimi"><c:out value="${jl.nimi}" /></td>
															<td class="c_nimi">
								<c:if test="${jl.tarjolla eq 1}">Kyllä</c:if>
								<c:if test="${jl.tarjolla eq 0}">Ei</c:if>

								
								</td>
							<td class="c_hinta"><fmt:formatNumber type="number"
									minFractionDigits="2" maxFractionDigits="2" value="${jl.hinta}" />
								&#x20ac;</td>
							<td class="napit"><table>
									<tr>
										<td>
											<form action="admin" method="post">
												<input type="hidden" name="id" value="${jl.id}"> <input
													type="hidden" name="action" value="palauta"> <button class="hnappula" type="submit">Näytä</button>
											</form>
										</td>
										<td>
											<form action="admin" method="post">

												<input type="hidden" name="id" value="${jl.id}"> <input
													type="hidden" name="action" value="piilota"> <button class="hnappula" type="submit">Piilota</button>
											</form>
										</td>
										<td><form action="admin" method="post">
												<input type="hidden" name="id" value="${jl.id}"> <input
													type="hidden" name="action" value="del2"> <button class="hnappula" type="submit">Poista</button>
											</form></td>
									</tr>
								</table></td>
						</tr>
					</c:forEach>
				</table>
			</div>

		</div>

		<div id="footer">Copyright © 2014 Pizzeria Tyyni</div>

	</div>

</body>
</html>