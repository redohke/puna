<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PizzAdmin</title>
<link rel="stylesheet" type="text/css" href="css/styles.css">
<link href='http://fonts.googleapis.com/css?family=Roboto:300italic,900,100italic,400italic,400,500italic,300,700italic,100,700,500,900italic' rel='stylesheet' type='text/css'>
</head>
<body>
	<div id="wrapper">
	
		<div class="left_col"></div>

		<div class="otsikko_col">
			<h1>Pizza Menu</h1>
		</div>

		<div class="otsikko_col">
			<h2>Listalla olevat pizzat:</h2>
			<br />
			<table class="taulukko">
				<c:forEach items="${plista}" var="pl">
					<tr>
						<td class="c_id"><c:out value="${pl.id}" /></td>
						<td class="c_nimi"><c:out value="${pl.nimi}" /></td>
						<td class="c_hinta"><c:out value="${pl.hinta}" /></td>
						<td class="c_hinta"><c:out value="${pl.tayte1}" /></td>
						<td class="c_hinta"><c:out value="${pl.tayte2}" /></td>
						<td class="c_hinta"><c:out value="${pl.tayte3}" /></td>
						<td class="c_hinta"><c:out value="${pl.tayte4}" /></td>						
						<td class="c_nappula"><form action="controller" method="post">
								<input class="del_nappi" type="image" src="img/Delete.png">
								<input type="hidden" name="id" value="${pl.id}"> 
								<input type="hidden" name="action" value="del">
						</form></td>
					</tr>
				</c:forEach>
			</table>
			</div>
			<div class="otsikko_col">
			<h2>Listalla olevat juomat:</h2>
			<br />
				<table class="taulukko">
				<c:forEach items="${jlista}" var="jl">
					<tr>
						<td class="c_id"><c:out value="${jl.id}" /></td>
						<td class="c_nimi"><c:out value="${jl.nimi}" /></td>
						<td class="c_hinta"><c:out value="${jl.hinta}" /></td>				
						<td class="c_nappula"><form action="controller" method="post">
								<input class="del_nappi" type="image" src="img/Delete.png">
								<input type="hidden" name="id" value="${jl.id}"> 
								<input type="hidden" name="action" value="del">
						</form></td>
					</tr>
				</c:forEach>
			</table>
			<p class="p_alas">
				Linkki hallinnan <a href="img/admin.png" target="_blank">rautalankaan</a>
			</p>
		</div>
		
	</div>

</body>
</html>