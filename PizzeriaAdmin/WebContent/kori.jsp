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

          <div id="content">
          <p class="otsikko">Ostoskori:</p>
          <hr class="viiva" />
          
          </div>
         </div>

          <div id="footer">Copyright © 2014 Pizzeria Tyyni</div>

        </div>
      </body>
      </html>