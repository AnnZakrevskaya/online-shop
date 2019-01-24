<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Анна
  Date: 22.04.2018
  Time: 13:40
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
        <a href="../index.jsp" id="logo" title="Diana’s jewelry">Tigerlity</a>
        <div class="right-links">
            <ul>
                <li><a href="${pageContext.request.contextPath}/cart"><img src="${pageContext.request.contextPath}/resources/images/box.png" alt="">   Товаров: ${sessionScope.cart.size()}</a></li>
                <li><a href="${pageContext.request.contextPath}/login"><img src="${pageContext.request.contextPath}/resources/images/log.png" alt="">  Вход <c:out value="${sessionScope.user}"/></a></li>
                <li><a href="${pageContext.request.contextPath}/registr"><img src="${pageContext.request.contextPath}/resources/images/registration.png" alt="">  Регистрация</a></li>
            </ul>
        </div>
    </div>
    <!-- / container -->
</header>
<!-- / header -->

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
<!-- / navigation -->

<div id="breadcrumbs">
    <div class="containerr">
        <ul>
            <li><a href="${pageContext.request.contextPath}/index.jsp">Главная</a></li>
            <li>Мужчинам</li>
        </ul>
    </div>
    <!-- / container -->
</div>
<!-- / body -->

<div id="body">
    <div class="containerr">
        <div class="products-wrap">
            <aside id="sidebar">
                <div class="widget">
                    <h3>Объём:</h3>
                    <fieldset>
                        <input type="checkbox"/>
                        <label>30 мл</label>
                        <input type="checkbox"/>
                        <label>50 мл</label>
                        <input type="checkbox"/>
                        <label>100 мл</label>
                    </fieldset>
                </div>
                <div class="widget">
                    <h3>Сортировать по:</h3>
                    <fieldset>
                        <input type="checkbox"/>
                        <label>Цене</label>
                        <input type="checkbox"/>
                        <label>Объёму</label>
                    </fieldset>
                </div>
                <div class="widget">
                    <h3>Диапазон цены:</h3>
                    <fieldset>
                        <div id="price-range"></div>
                    </fieldset>
                </div>
            </aside>
            <form action="${pageContext.request.contextPath}/manPerfume" method="post" class="frm">
            <div id="content">
                <section class="products">
                    <c:forEach items="${listAllPerfume}" var="perfumeEl" varStatus="i">
                        <c:if test="${perfumeEl.type == 'м'}">
                    <article>
                        <img src="${perfumeEl.image_adress}" alt="">
                        <h3>${perfumeEl.name_perfume}</h3>
                        <p class="style-product-name">${perfumeEl.size}мл</p>
                        <h4>${perfumeEl.price} BYN</h4>
                        <button type="submit" style="width: 180px"  class="btn-add" name="nam" value=${perfumeEl.id_perfume}>В корзину</button>
                    </article>
                        </c:if>
                    </c:forEach>
                </section>
            </div>
            </form>
            <!-- / content -->
        </div>
    </div>
    <!-- / container -->
</div>
<!-- / body -->

<footer id="footer">
    <div class="containerr">
        <div class="cols">
            <div class="col">
                <h3>Frequently Asked Questions</h3>
                <ul>
                    <li><a href="#">Fusce eget dolor adipiscing </a></li>
                    <li><a href="#">Posuere nisl eu venenatis gravida</a></li>
                    <li><a href="#">Morbi dictum ligula mattis</a></li>
                    <li><a href="#">Etiam diam vel dolor luctus dapibus</a></li>
                    <li><a href="#">Vestibulum ultrices magna </a></li>
                </ul>
            </div>
            <div class="col media">
                <h3>Социальные сети:</h3>
                <ul class="social">
                    <li><a href="#"><span class="ico ico-fb"></span>Facebook</a></li>
                    <li><a href="#"><span class="ico ico-tw"></span>Twitter</a></li>
                    <li><a href="#"><span class="ico ico-gp"></span>Google+</a></li>
                    <li><a href="#"><span class="ico ico-pi"></span>Pinterest</a></li>
                </ul>
            </div>
            <div class="col contact">
                <h3>Контакты:</h3>
                <p>Diana’s Jewelry INC.<br>54233 Avenue Street<br>New York</p>
                <p><span class="ico ico-em"></span><a href="#">contact@dianasjewelry.com</a></p>
                <p><span class="ico ico-ph"></span>(590) 423 446 924</p>
            </div>
            <div class="col newsletter">
                <h3>Join our newsletter</h3>
                <p>Sed ut perspiciatis unde omnis iste natus sit voluptatem accusantium doloremque laudantium.</p>
                <form action="#">
                    <input type="text" placeholder="Your email address...">
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
