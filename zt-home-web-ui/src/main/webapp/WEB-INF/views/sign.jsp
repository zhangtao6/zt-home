<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2019/6/14
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sign</title>
    <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet">

    <link rel='stylesheet prefetch' href='https://fonts.googleapis.com/icon?family=Material+Icons'>

    <link rel="stylesheet" href="/static/css/sign.css" />
    <!--站点图标-->
    <link rel="shortcut icon" type="image/x-icon" href='/static/img/favicon.ico' />
    <script src="/static/js/sign.js"></script>
</head>

<body>
<div class="cotn_principal">
    <div class="cont_centrar">

        <div class="cont_login">
            <div class="cont_info_log_sign_up">
                <div class="col_md_login">
                    <div class="cont_ba_opcitiy">
                        <c:if test="${baseResultLogin != null}">
                            <div style="color: red;">
                                    ${baseResultLogin.message}
                            </div>
                        </c:if>
                        <h2>LOGIN</h2>
                        <p>Let's go into.</p>
                        <button class="btn_login" onclick="cambiar_login()">LOGIN</button>
                    </div>
                </div>
                <div class="col_md_sign_up">
                    <div class="cont_ba_opcitiy">
                        <c:if test="${baseResultRegister != null}">
                            <div style="color: red;">
                                    ${baseResultRegister.message}
                            </div>
                        </c:if>
                        <h2>SIGN UP</h2>

                        <p>Start our account.</p>

                        <button class="btn_sign_up" onclick="cambiar_sign_up()">SIGN UP</button>
                    </div>
                </div>
            </div>

            <div class="cont_back_info">
                <div class="cont_img_back_grey">
                    <!--https://images.unsplash.com/photo-1453831362806-3d5577f014a4?dpr=1&auto=compress,format&fit=crop&w=1199&h=812&q=80&cs=tinysrgb&crop=-->
                    <img src="http://tgi13.jia.com/116/118/16118429.jpg" alt="" />
                </div>

            </div>
            <div class="cont_forms">
                <div class="cont_img_back_">
                    <img src="http://tgi13.jia.com/116/118/16118429.jpg" alt="" />
                </div>
                <div class="cont_form_login">
                    <a href="#" onclick="ocultar_login_sign_up()"><i class="material-icons">&#xE5C4;</i></a>
                    <h2>LOGIN</h2>
                    <form action="/login" method="post">
                        <input type="text" name="username" placeholder="Username" />
                        <input type="password" name="password" placeholder="Password" />
                        <button class="btn_login" type="submit">LOGIN</button>
                    </form>
                </div>

                <div class="cont_form_sign_up">
                    <a href="#" onclick="ocultar_login_sign_up()"><i class="material-icons">&#xE5C4;</i></a>
                    <h2>SIGN UP</h2>
                    <form action="/register" method="post">
                        <input type="text" name="email" placeholder="Email" />
                        <input type="text" name="username" placeholder="User" />
                        <input type="password" name="password" placeholder="Password" />
                        <input type="password" placeholder="Confirm Password" />
                        <button class="btn_sign_up" type="submit">SIGN UP</button>
                    </form>

                </div>

            </div>

        </div>
    </div>
</div>

</body>
</html>
