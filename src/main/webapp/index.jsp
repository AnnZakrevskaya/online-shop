<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Анна
  Date: 28.03.2018
  Time: 12:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en"> <!--<![endif]-->
<head>
  <meta charset="utf-8">
  <title>Tigerlity</title>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no">
  <link rel="stylesheet" media="all" href="${pageContext.request.contextPath}/resources/css/style.css">
  <!--[if lt IE 9]>
  <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
  <![endif]-->
</head>
<body>

<header id="header">
  <div class="containerr">
    <a href="index.jsp" id="logo" title="Tigerlity">Tigerlity</a>
    <div class="right-links">
      <ul>
        <li><a href="${pageContext.request.contextPath}/cart"><img src="${pageContext.request.contextPath}resources/images/box.png" alt="">  Товаров: ${sessionScope.cart.size()}</a></li>
        <li><a href="${pageContext.request.contextPath}/login"><img src="${pageContext.request.contextPath}resources/images/log.png" alt="">  Вход: <c:out value="${sessionScope.user}"/></a></li>
        <li><a href="${pageContext.request.contextPath}/registr"><img src="${pageContext.request.contextPath}resources/images/registration.png" alt="">  Регистрация</a></li>
      </ul>
    </div>
  </div>
  <!-- / container -->
</header>
<!-- / header -->
<c:if test="${empty user}">
</c:if>
<c:if test="${not empty user && user!='admin'}">
  <nav id="menu">
    <div class="containerr">
      <div class="trigger"></div>
      <ul>
        <li><a href="${pageContext.request.contextPath}/womanPerfume">Женщинам</a></li>
        <li><a href="${pageContext.request.contextPath}/manPerfume">Мужчинам</a></li>
        <li><a href="${pageContext.request.contextPath}/ordersUser">Мои заказы</a></li>
        <li><a href="${pageContext.request.contextPath}/rewiews">Отзывы</a></li>
      </ul>
    </div>
    <!-- / container -->
  </nav>
</c:if>
<c:if test="${user=='admin'}">
  <nav id="menu">
    <div class="containerr">
      <div class="trigger"></div>
      <ul>
        <li><a href="${pageContext.request.contextPath}/adminUserList">Пользователи</a></li>
        <li><a href="${pageContext.request.contextPath}/ordersAdmin">Список заказов</a></li>
        <li><a href="${pageContext.request.contextPath}/rewiews">Отзывы</a></li>
      </ul>
    </div>
    <!-- / container -->
  </nav>
</c:if>
<!-- / navigation -->

<div id="slider">
  <ul>
    <li><img src="${pageContext.request.contextPath}/resources/images/0.jpg"></li>
    <li><img src="${pageContext.request.contextPath}/resources/images/01.jpg"></li>
    <li><img src="${pageContext.request.contextPath}/resources/images/02.jpg"></li>
  </ul>
</div>
<!-- / body -->

<div id="body">
  <div class="containerr">
    <div class="last-products">
      <h2>Популярные товары</h2>
      <section class="products">
        <article>
          <img src="${pageContext.request.contextPath}/resources/images/1.jpg" alt="">
          <h3>CHRISTIAN DIOR Miss Dior Blooming Bouqet</h3>
          <p class="style-product-name">50 ml</p>
          <h4>180 BYN</h4>
          <!-- <a href="cart.html" class="btn-add">Add to cart</a> -->
        </article>
        <article>
          <img src="${pageContext.request.contextPath}/resources/images/2.jpg" alt="">
          <h3>DOLCE & GABBANA Dolce</h3>
          <p class="style-product-name">30 ml</p>
          <h4>105 BYN</h4>
        </article>
        <article>
          <img src="${pageContext.request.contextPath}/resources/images/3.jpg" alt="">
          <h3>DOLCE & GABBANA  Intense</h3>
          <p class="style-product-name">50 ml</p>
          <h4>120 BYN</h4>
        </article>
        <article>
          <img src="${pageContext.request.contextPath}/resources/images/4.jpg" alt="">
          <h3>CHANEL Chance Eau Tendre</h3>
          <p class="style-product-name">50 ml</p>
          <h4>196 BYN</h4>
        </article>
        <article>
          <img src="${pageContext.request.contextPath}/resources/images/5.jpg" alt="">
          <h3>VERSACE Bright Crystal</h3>
          <p class="style-product-name">30 ml</p>
          <h4>92 BYN</h4>
        </article>
        <article>
          <img src="${pageContext.request.contextPath}/resources/images/6.jpg" alt="">
          <h3>CHRISTIAN DIOR J`adore</h3>
          <p class="style-product-name">50 ml</p>
          <h4>150 BYN</h4>
        </article>
        <article>
          <img src="${pageContext.request.contextPath}/resources/images/8.jpg" alt="">
          <h3>GIVENCHY Play for her</h3>
          <p class="style-product-name">50 ml</p>
          <h4>190 BYN</h4>
        </article>
        <article>
          <img src="${pageContext.request.contextPath}/resources/images/7.jpg" alt="">
          <h3>LACOSTE - Eau de Lacoste L.12.12 Pour Elle Natural</h3>
          <p class="style-product-name">100 ml</p>
          <h4>120 BYN</h4>
        </article>
      </section>
    </div>
  </div>
  <!-- / container -->
</div>
<!-- / body -->

<footer id="footer">
  <div class="containerr">
    <div class="cols">
      <div class="col">
        <h3>Интересные статьи</h3>
        <ul>
          <li><a href="#">Как подобрать парфюм?</a></li>
          <li><a href="#">Самые дорогие духи</a></li>
          <li><a href="#">Самые удачные сочетания ароматов</a></li>
          <li><a href="#">Самые стойкие духи</a></li>
          <li><a href="#">Самые стойкие духи </a></li>
        </ul>
      </div>
      <div class="col media">
        <h3>Социальные сети</h3>
        <ul class="social">
          <li><a href="#"><span class="ico ico-fb"></span>Facebook</a></li>
          <li><a href="#"><span class="ico ico-tw"></span>Twitter</a></li>
          <li><a href="#"><span class="ico ico-gp"></span>Google+</a></li>
          <li><a href="#"><span class="ico ico-pi"></span>Pinterest</a></li>
        </ul>
      </div>
      <div class="col contact">
        <h3>Контакты</h3>
        <p>Tigerlity INC.<br>пр-т. Дзержинского<br>Минск</p>
        <p><span class="ico ico-em"></span><a href="#">contact@tigerlity.com</a></p>
        <p><span class="ico ico-ph"></span>(33) 648 77 23</p>
      </div>
      <div class="col newsletter">
        <h3>Присоединяйтесь к нашей рассылке</h3>
        <p>Подписаться на нашу рассылку новостей.</p>
        <form action="#">
          <input type="text" placeholder="Ваш email адрес...">
          <button type="submit"></button>
        </form>
      </div>
    </div>
    <p class="copy">Copyright 2018 by Ann Zakrevskaya.</p>
  </div>
  <!-- / container -->
</footer>
<!-- / footer -->


<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script>window.jQuery || document.write("<script src='${pageContext.request.contextPath}/resources/js/jquery-1.11.1.min.js'>\x3C/script>")</script>
<script src="${pageContext.request.contextPath}/resources/js/plugins.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/main.js"></script>
</body>
</html>