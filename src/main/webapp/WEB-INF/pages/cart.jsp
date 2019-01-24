<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Анна
  Date: 22.04.2018
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en"> <!--<![endif]-->
<head>
    <meta charset="utf-8">
    <title>Tigerlity</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no">
    <link rel="stylesheet" media="all" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link rel="stylesheet" media="all" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
    <!--[if lt IE 9]>
    <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
</head>
<body>

<header id="header">
    <div class="containerr">
        <a href="${pageContext.request.contextPath}/index.jsp" id="logo" title="Diana’s jewelry">Tigerlity</a>
        <div class="right-links">
            <ul>
                <li><a href="${pageContext.request.contextPath}/cart"><img src="${pageContext.request.contextPath}/resources/images/box.png" alt="">Товаров: ${sessionScope.cart.size()}</a></li>
                <li><a href="${pageContext.request.contextPath}/login"><img src="${pageContext.request.contextPath}/resources/images/log.png" alt="">  Вход</a></li>
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
            <li>Корзина</li>
        </ul>
    </div>
    <!-- / container -->
</div>
<!-- / body -->

<div id="body">
    <form action="${pageContext.request.contextPath}/cart" method="post" name="cart">
    <div class="containerr">
        <div id="content" class="full">
            <div class="cart-table">
                <table style="margin: 0 auto;">
                    <tr>
                        <th class="items">Товары</th>
                        <th class="price">Цена</th>
                        <th class="total">Объём</th>
                        <th class="delete"></th>
                    </tr>
                    <c:forEach items="${listCartsNew}" var="perfumeEl" varStatus="i">
                    <tr>
                        <td class="items">
                            <div class="image">
                                <img src="${perfumeEl.image_adress}" alt="" width="120" height="120">
                            </div>
                            <h3 >    ${perfumeEl.name_perfume}</h3>
                        </td>
                        <td><p class="price" id="price">${perfumeEl.price} BYN</p></td>
                        <td id="display"><p class="total" id="sum">${perfumeEl.size} мл</p></td>
                        <td class="delete"><button type="submit" class="btn btn-inverse" name="del" value="${perfumeEl.id_perfume}">Удалить</button></td>
                    </tr>
                    </c:forEach>
                </table>
            </div>

            <div class="total-count">
                <input type="hidden" value="${sessionScope.user}" name="userName">
                <h4>Сумма заказа без скидки: ${sumWithhout} BYN</h4>
                <c:if test="${sizeCart>2}">
                    <h4>Скидка 10%</h4>
                </c:if>
                <c:if test="${sizeCart == 2}">
                    <h4>Скидка 5%</h4>
                </c:if>
                <c:if test="${sizeCart!=1}">
                <h3>Сумма заказа со скидкой: ${orderPrice} BYN</h3></c:if>
                <button type="submit" class="btn-grey" name="toOrder" value="order">Заказать</button>
            </div>

        </div>
        <!-- / content -->
    </div>
    </form>
    <!-- / container -->
</div>
<!-- / body -->

<footer id="footer">
    <div class="containerr">
        <div class="cols">
            <div class="col">
                <h3>Полезные статьи</h3>
                <ul style="margin: 0 auto">
                    <li><a href="#">Как подобрать парфюм?</a></li>
                    <li><a href="#">Самые дорогие духи</a></li>
                    <li><a href="#">Самые удачные сочетания ароматов</a></li>
                    <li><a href="#">Самые стойкие духи</a></li>
                    <li><a href="#">Самые стойкие духи </a></li>
                </ul>
            </div>
            <div class="col media">
                <h3>Social media</h3>
                <ul class="social">
                    <li><a href="#"><span class="ico ico-fb"></span>Facebook</a></li>
                    <li><a href="#"><span class="ico ico-tw"></span>Twitter</a></li>
                    <li><a href="#"><span class="ico ico-gp"></span>Google+</a></li>
                    <li><a href="#"><span class="ico ico-pi"></span>Pinterest</a></li>
                </ul>
            </div>
            <div class="col contact">
                <h3>Contact us</h3>
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
        <p class="copy">Copyright 2013 Jewelry. All rights reserved.</p>
    </div>
    <!-- / container -->
</footer>
<!-- / footer -->
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script>window.jQuery || document.write("<script src='${pageContext.request.contextPath}/resources/js/jquery-1.11.1.min.js'>\x3C/script>")</script>
<script src="${pageContext.request.contextPath}/resources/js/plugins.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/main.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
</body>
</html>
