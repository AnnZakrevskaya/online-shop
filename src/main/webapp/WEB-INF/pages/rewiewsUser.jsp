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
        <a href="../index.jsp" id="logo" title="Diana’s jewelry">Tigerlity</a>
        <div class="right-links">
            <ul>
                <li><a href="${pageContext.request.contextPath}/cart"><img src="../../resources/images/box.png" alt="">Товаров: ${sessionScope.cart.size()}</a></li>
                <li><a href="${pageContext.request.contextPath}/login"><img src="../../resources/images/log.png" alt="">  Вход <c:out value="${sessionScope.user}"/></a></li>
                <li><a href="${pageContext.request.contextPath}/registr"><img src="../../resources/images/registration.png" alt="">  Регистрация</a></li>
            </ul>
        </div>
    </div>
    <!-- / container -->
</header>
<!-- / header -->
<c:if test="${sessionScope.user != 'admin'}">
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
<c:if test="${sessionScope.user =='admin'}">
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

<div id="breadcrumbs">
    <div class="containerr">
        <ul>
            <li><a href="${pageContext.request.contextPath}/index.jsp">Главная</a></li>
            <li>Отзывы</li>
        </ul>
    </div>
    <!-- / container -->
</div>
<!-- / body -->

<div id="body">
    <div class="containerr">
        <div id="content" class="full">
          <c:choose>
            <c:when test="${sizeRewiewList!=0}">
            <div class="rew-table">
                <table style="margin: 0 auto;">
                    <c:forEach items="${rewiewsList}" var="userEl" varStatus="i">
                    <tr>
                        <td class="users">
                            <p class="style-rewiews">${userEl.username}</p>
                            <p class="style-rewiews">${userEl.date}</p>
                         </td>
                        <td class="itemss">
                            <p class="style-rewiews">${userEl.rewiew}</p>
                        </td>
                    </c:forEach>
                </table>
            </div>
            </c:when>
              <c:otherwise>
                  <p class="styleError" style="text-align: center"> Нет отзывов!</p>
              </c:otherwise>
          </c:choose>
          <c:if test="${sessionScope.user =='admin'}"></c:if>
          <c:if test="${sessionScope.user != 'admin'}">
            <form role="form" action="${pageContext.request.contextPath}/rewiews" accept-charset="windows-1251" method="post">
            <div class="total-count">
                <input type="hidden" value="${sessionScope.user}" name="userName">
                <h4>Оставьте свой отзыв:</h4>
                 <textarea name="rewUser" style="width: 500px; height: 150px;"></textarea><br/>
                <button type="submit" class="btn-grey" name="toRewiews" value="rewiew">Добавить отзыв</button>
            </div>
            </form>
          </c:if>
        </div>
        <!-- / content -->
    </div>
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
