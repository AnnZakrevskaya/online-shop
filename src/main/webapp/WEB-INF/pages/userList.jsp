<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Анна
  Date: 02.05.2018
  Time: 17:40
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
                <li><a href="${pageContext.request.contextPath}/login"><img src="${pageContext.request.contextPath}/resources/images/log.png" alt="">  Вход: <c:out value="${sessionScope.user}"/></a></li>
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
            <li><a href="${pageContext.request.contextPath}/adminUserList">Пользователи</a></li>
            <li><a href="${pageContext.request.contextPath}/ordersAdmin">Список заказов</a></li>
            <li><a href="${pageContext.request.contextPath}/rewiews">Отзывы</a></li>
        </ul>
    </div>
    <!-- / container -->
</nav>
<div id="breadcrumbs">
    <div class="containerr">
        <ul>
            <li><a href="${pageContext.request.contextPath}/index.jsp">Главная</a></li>
            <li>Список пользователей</li>
        </ul>
    </div>
    <!-- / container -->
</div>
<!-- / body -->

<div id="body">
    <div class="containerr">
        <div id="content" class="full">
            <c:choose>
                <c:when test="${sizeUserList!=0}">
                    <div class="cart-table">
                        <table style="margin: 0 auto;">
                            <tr>
                                <th class="numberOrder">№</th>
                                <th class="itemsUser">Пользователь</th>
                                <th class="items">ФИО</th>
                                <th class="priceNew">E-mail</th>
                                <th class="price">Телефон</th>
                            </tr>
                            <c:forEach items="${userList}" var="userEl" varStatus="i">
                                <tr>
                                    <td class="itemsNumber">${i.count}</td>
                                    <td class="itemsUser">${userEl.username}</td>
                                    <td class="itemsFIO">${userEl.fio}</td>
                                    <td class="priceNew">${userEl.email}</td>
                                    <td class="price">${userEl.phone}</td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </c:when>
                <c:otherwise>
                    <p class="styleError" style="text-align: center">Лист пользователей пустой!</p>
                </c:otherwise>
            </c:choose>
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
            <div class="col">
                <h3 style="margin-left: 30px">Frequently Asked Questions</h3>
                <ul style="margin-left: 30px">
                    <li><a href="#">Fusce eget dolor adipiscing </a></li>
                    <li><a href="#">Posuere nisl eu venenatis gravida</a></li>
                    <li><a href="#">Morbi dictum ligula mattis</a></li>
                    <li><a href="#">Etiam diam vel dolor luctus dapibus</a></li>
                    <li><a href="#">Vestibulum ultrices magna </a></li>
                </ul>
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