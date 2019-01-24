<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: Анна
  Date: 24.04.2018
  Time: 18:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en"> <!--<![endif]-->
<head>
    <meta charset="utf-8">
    <title>Tigerlity</title>
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no">
    <link rel="stylesheet" media="all" href="${pageContext.request.contextPath}resources/css/style.css">
    <link rel="stylesheet" media="all" href="${pageContext.request.contextPath}resources/css/bootstrap.css">
    <script src="${pageContext.request.contextPath}resources/js/bootstrap.js"></script>
    <!--[if lt IE 9]>
    <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
</head>
<body>

<header id="header">
    <div class="containerr">
        <a href="../index.jsp" id="logo" title="Tigerlity">Tigerlity</a>
        <div class="right-links">
            <ul>
                <li><a href="${pageContext.request.contextPath}/cart"><img src="${pageContext.request.contextPath}/resources/images/box.png" alt=""> Товаров: ${sessionScope.cart.size()}
                    </a></li>
                <li><a href="${pageContext.request.contextPath}/login"><img
                        src="${pageContext.request.contextPath}/resources/images/log.png" alt=""> Вход</a></li>
                <li><a href="${pageContext.request.contextPath}/registr"><img
                        src="${pageContext.request.contextPath}/resources/images/registration.png" alt="">
                    Регистрация</a></li>
            </ul>
        </div>
    </div>
    <!-- / container -->
</header>
<!-- / header -->

<!--<nav id="menu">-->
    <div class="containerr">
        <%--<div class="trigger"></div>--%>
        <%--<ul>--%>
            <%--<li><a href="woman.jsp">Женщинам</a></li>--%>
            <%--<li><a href="man.jsp">Мужчинам</a></li>--%>
            <%--<li><a href="#">Блог</a></li>--%>
            <%--<li><a href="#">Отзывы</a></li>--%>
        <%--</ul>--%>
    </div>
<!-- / container -->
<!--</nav> -->
<!-- / navigation -->

<div id="breadcrumbs">
    <div class="containerr">
        <ul>
            <li><a href="${pageContext.request.contextPath}/index.jsp">Главная</a></li>
            <li>Вход</li>
        </ul>
    </div>
    <!-- / container -->
</div>
<!-- / body -->

<div id="body">
    <div class="containerr">
        <div id="content" class="full">
            <div class="wrapper">
                <div class="right_block">
                    <form role="form" action="${pageContext.request.contextPath}/login" method="post">
                        <div class="form-group">
                            <label for="login" class="style-product-name">Логин</label>
                            <input type="text" id="login" name="login" style="height:30px" class="form-control-param"
                                   pattern="^[a-zA-Z][a-zA-Z0-9-_\.]{1,20}$" placeholder="Введите логин..." required=""
                                   autofocus=""><br/>
                        </div>
                        <div class="form-group">
                            <label for="pass" class="style-product-name">Пароль</label>
                            <input type="password" style="height:30px" class="form-control-param" id="pass"
                                   name="password" placeholder="Введите пароль..."
                                   pattern="^[a-zA-Z][a-zA-Z0-9-_\.]{1,20}$" required="" autofocus=""><br/>
                        </div>
                        <label class="radio-inline"><input type="radio" name="role" value="USER"
                                                           checked>Пользователь</label>
                        <label class="radio-inline"><input type="radio" name="role" value="ADMIN">Администратор</label>
                        <button type="submit" style="width:100px" id="popover" class="btn btn-inverse">Войти</button>
                        <button type="reset" style="width:100px" id="p" class="btn btn-inverse">Очистить</button>
                        <c:if test="${sessionScope.logError ne null}">
                            <p class="styleError">${sessionScope.logError}</p>
                        </c:if>
                    </form>
                </div>

                <div class="left_block">
                    <p class="style-text-h">О нас</p>
                    <p class="style-text">Интернет-магазин элитной парфюмерии Tigerlity представляет только оригинальную
                        парфюмерную и косметическую продукцию
                        от известных элитных производителей:
                        туалетная вода для самых изысканных ценителей, духи! В нашем
                        каталоге парфюмерии сотни наименований товара! У нас
                        Вы можете найти и купить по выгодной цене последние новинки известных парфюмерных брэндов!Мы
                        являемся первым поставщиком в РБ, и вам не
                        придется переплачивать посредникам, при покупке парфюмерии за счет дополнительных оптовых
                        надбавок.</p>
                </div>
            </div>

        </div>
        <!-- / content -->
    </div>
    <!-- / container -->
</div>
<!-- / body -->

<footer id="footer">
    <div class="containerr" style="margin: 0 auto;">
        <div class="cols">
            <div class="col">
                <h3>Frequently Asked Questions</h3>
                <ul style="margin-left: 0;">
                    <li><a href="#">Fusce eget dolor adipiscing </a></li>
                    <li><a href="#">Posuere nisl eu venenatis gravida</a></li>
                    <li><a href="#">Morbi dictum ligula mattis</a></li>
                    <li><a href="#">Etiam diam vel dolor luctus dapibus</a></li>
                    <li><a href="#">Vestibulum ultrices magna </a></li>
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
<script>window.jQuery || document.write("<script src='../../resources/js/jquery-1.11.1.min.js'>\x3C/script>")</script>
<script src="${pageContext.request.contextPath}/resources/js/plugins.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/main.js"></script>
</body>
</html>
