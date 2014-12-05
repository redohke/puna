<%@page import="fi.omapizzeria.admin.bean.Pizza"%>
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
			<h1>Pizzojen Hallinta</h1>
			<br/>
			<p>
				
			</p>
		</div>


		<div class="lisays_col">
			<h2>Pizzojen lisäys</h2>
			<br />
			<form name="input" action="admin" method="post">
				<input type="text" name="pizza" placeholder="Pizzan nimi"> <input
					type="text" name="hinta" placeholder="Hinta" size="5">
					
					
					<br>

							<c:forEach items="${tayte}" var="t">
							<td class="pmauste"><input type="checkbox" name="tayte" value="${t.id}"> 
									<c:out value="${t.nimi}" /> </td>
        						
        						
    						</c:forEach><br/>
 
				<button class="nappula" type="submit">Lisää</button>
				<input type="hidden" name="action" value="add">
			</form>Pizzoihin vain 2-4 täytettä.
			
					<div class="lisays_col">
			<h2>Juomien lisäys</h2>
			<br />
			<form name="input" action="admin" method="post">
				<input type="text" name="juoma" placeholder="Juoman nimi"> <input
					type="text" name="hinta" placeholder="Hinta" size="5">
					
					
					<br>
	
					
				<button class="nappula" type="submit">Lisää</button>
				<input type="hidden" name="action" value="add2">
			</form>
		</div>
		</div>

		<c:if test="${not empty param.added}">
			<div class="lisays_col">
				<p>
					<i>Uuden pizzan lisääminen onnistui!</i>
				</p>
			</div>
		</c:if>

		<c:if test="${not empty param.removed}">
			<div class="lisays_col">
				<p>
					<i>Pizzan poisto onnistui!</i>
				</p>
			</div>
		</c:if>

		<div class="otsikko_col">
			<h2>Listalla olevat pizzat:</h2>
			<br />
			<table class="taulukko">
				<c:forEach items="${plista}" var="pl">
					<tr>
						<td class="c_id"><c:out value="${pl.id}" /></td>
						<td class="c_nimi"><c:out value="${pl.nimi}" /></td>
						<td class="c_hinta"><c:out value="${pl.hinta}" /></td>
						<td class="c_nappula"><form action="admin" method="post">
								<input class="del_nappi" type="image" src="img/Delete.png">
								<input type="hidden" name="id" value="${pl.id}"> 
								<input type="hidden" name="action" value="del">
								<input class="del_nappi" type="image" src="img/Piilota.png">
								<input type="hidden" name="action" value="piilota">
								<input class="del_nappi" type="image" src="img/Palauta.png">
								<input type="hidden" name="action" value="palauta">

						</form></td>
					</tr>
				</c:forEach>
			</table>
			
			
			
						<h2>Listalla olevat Juomat:</h2>
			<br />
			<table class="taulukko">
				<c:forEach items="${jlista}" var="jl">
					<tr>
						<td class="c_id"><c:out value="${jl.id}" /></td>
						<td class="c_nimi"><c:out value="${jl.nimi}" /></td>
						<td class="c_hinta"><c:out value="${jl.hinta}" /></td>
						<td class="c_nappula"><form action="admin" method="post">
								<input class="del_nappi" type="image" src="img/Delete.png">
								<input type="hidden" name="id" value="${jl.id}"> 
								<input type="hidden" name="action" value="del2">
								</form>
								<form action="admin" method="post">
								<input class="del_nappi" type="image" src="img/Piilota.png">
								<input type="hidden" name="id" value="${jl.id}"> 
								<input type="hidden" name="action" value="piilota">
								</form>
								<form action="admin" method="post">
								<input class="del_nappi" type="image" src="img/Palauta.png">
								<input type="hidden" name="id" value="${jl.id}"> 
								<input type="hidden" name="action" value="palauta">
								</form>
								
						</td>
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