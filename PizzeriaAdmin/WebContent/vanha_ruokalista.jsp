<%@page import="fi.omapizzeria.admin.bean.Pizza"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>kotikoti kullan kallis</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/960.css">
<meta name="viewport" content="width=device-width" />
</head>
<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0"
	marginheight="0">
	<!-- Save for Web Slices (kotikoti kullan kallis.psd) -->
	<center>
		<div class="header">
			<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td width="1378" height="151" background="images/index_02.png"
						valign="bottom"><table align="center" width="1353" border="0">
							<tr>
								<td><p align="left" class="h">
										Otaniementie 9<br> Espoo <br> Puh: 0489154657
									</p></td>
								<td><p align="right" class="h">
										Aukioloajat <br>Ma-Pe 06-04 <br>La-Su 12-24
									</p></td>
							</tr>
						</table></td>
				</tr>
			</table>
			<img border="0" src="images/index_04.png" width="256"><a
				href="index.jsp"><img border="0" src="images/index_05.gif"
				width="115"></a><img border="0" src="images/index_06.png"
				width="95"><img border="0" src="images/index_072.gif"
				width="184"><img border="0" src="images/index_08.png"
				width="121"><a href="ruokalista"><img border="0"
				src="images/index_09.gif" width="172"></a><img border="0"
				src="images/index_10.png" width="75"><a href="me.jsp"><img
				border="0" src="images/index_11.gif" width="104"></a><img
				border="0" src="images/index_12.png" width="256">
		</div>


		<table id="Table_01" class="col" width="1050" height="650" border="0"
			cellpadding="0" cellspacing="0" align="center">
			<tr></tr>
			<tr>
				<td bgcolor="#DDCB9B" align="center"><div class="container_12">
						<br>
						<p class="s">Pizza Lista</p>

						<c:forEach items="${plista}" var="pl">

							<div class="grid_10">
								<table border="0" cellpadding="0" cellspacing="0" width="710">
									<tr>
										<td background="images/pissa.png" class="up">
											<p>
												<span style="font-size: 45px">&nbsp;<c:out
														value="${pl.id}" />. <c:out value="${pl.nimi}" /></span>
												<c:forEach items="${pl.taytteet}" var="tayte"
													varStatus="status">
    ${tayte}<c:if test="${!status.last}">,</c:if>
												</c:forEach>
											</p>
									</tr>
								</table>

							</div>
							<div class="grid_2">
								<p class="s">
									<c:out value="${pl.hinta}" />
									&#x20ac;
								</p>
							</div>
							<!-- end .grid_12 -->
							<div class="clear"></div>
						</c:forEach>

						<div class="grid_4">
							<p class="sp">Juomalista</p>
						</div>
						<table>
							<tr>
								<td align="left"><c:forEach items="${jlista}" var="jl">
										<div class=" grid_6">
											<table class="sp" border="0" cellpadding="0" cellspacing="0"
												width="440" align="left">
												<tr>
													<td align="left">&nbsp;<c:out value="${jl.id}" />.&nbsp;<c:out
															value="${jl.nimi}" /></td>
													<td align="right"><c:out value="${jl.hinta}" />&#x20ac;&nbsp;</td>
													<td class="c_nappula"><form action="controller"
															method="post">
															<input type="hidden" name="id" value="${jl.id}">
															<input type="hidden" name="action" value="del">
														</form></td>
												</tr>
											</table>
										</div>
									</c:forEach></td>
								<td valign="middle"><img class="ale"
									src="images/pizzale.gif" width="410" height="161" align="right"></td>
							</tr>
						</table>
					</div> <br>
				<br> <!-- end .container_12 --></td>
		</table>

	</center>
	<!-- End Save for Web Slices -->
	<br>
	<br>
	<br>
	<br>
	<br>
</body>
</html>