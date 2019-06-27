<%@ page pageEncoding="utf-8" contentType="text/html; charset=utf-8" import="java.util.*" isELIgnored="false"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>后台管理-首页</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/front/img/favicon.ico"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/back/css/base.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/back/css/index.css">
</head>
<body>
<header>
    <div class="bx">
        <div class="logo">
            <%--<h1>
                <a href="login.jsp">
                    <img src="${pageContext.request.contextPath}/back/images/img/logo.png" alt="有家后台">
                </a>
            </h1>--%>
        </div>
        <div class="right">
            <ul>
                <li><i class="iconfont">&#xe612;</i>货到付款</li>
                <li><i class="iconfont">&#xe602;</i>正品保障</li>
                <li><i class="iconfont">&#xe601;</i>上门退款</li>
            </ul>
        </div>
    </div>
</header>
<main>
    <div class="bx">
        <div class="banner">

        </div>
        <div class="login">
            <form action="${pageContext.request.contextPath}/admin/login" method="post">
                <div class="input-group">
                    <input type="text" name="admin.username">
                    <i class="iconfont">&#xe609;</i>
                </div>
                <div class="input-group">
                    <input type="password" name="admin.password">
                    <i class="iconfont">&#xe6a1;</i>
                </div>

                <input type="submit" value="登&nbsp;&nbsp;&nbsp;&nbsp;录">
            </form>
        </div>
    </div>
</main>
<!--底部部分-->
<footer>
    <div class="bx">
        <div class="footer-service">
            <ul>
                <li><a href="#"><i class="iconfont">&#xe62f;</i>售后服务</a></li>
                <li><a href="#"><i class="iconfont">&#xe60c;</i>7天无理由退货</a></li>
                <li><a href="#"><i class="iconfont">&#xe605;</i>15天免费换货</a></li>
                <li><a href="#"><i class="iconfont">&#xe604;</i>满150元包邮</a></li>
                <li><a href="#"><i class="iconfont">&#xe613;</i>520余家售后网点</a></li>
            </ul>
        </div>
        <div class="footer-links">
            <dl class="col-links">
                <dt>帮助中心</dt>
                <dd><a href="#">账户管理</a></dd>
                <dd><a href="">购物指南</a></dd>
                <dd><a href="">订单操作</a></dd>
            </dl>
            <dl class="col-links">
                <dt>服务支持</dt>
                <dd><a href="#">售后政策</a></dd>
                <dd><a href="">自助服务</a></dd>
                <dd><a href="">相关下载</a></dd>

            </dl>
            <dl class="col-links">
                <dt>关注我们</dt>
                <dd><a href="#">新浪微博</a></dd>
                <dd><a href="">官方微信</a></dd>
                <dd><a href="">联系我们</a></dd>
            </dl>
            <dl class="col-links">
                <dt>关于有家</dt>
                <dd><a href="#">了解有家</a></dd>
                <dd><a href="">加入有家</a></dd>
                <dd><a href="">有家投资者</a></dd>
            </dl>
            <dl class="col-links">
                <dt>特色服务</dt>
                <dd><a href="#">F 码通道</a></dd>
                <dd><a href="">礼物码</a></dd>
                <dd><a href="">防伪查询</a></dd>
            </dl>
            <div class="col-contact">
                <p class="phone">400-100-5678</p>
                <p>周一至周日 8:00-18:00 <br>（仅收市话费）</p>
                <a href="#"> 联系客服 </a>
            </div>
        </div>
        <div class="site-info">
            <p>&copy;<a href="#">京ICP证110507号</a><a href="#">京ICP证110507号</a><a href="#">京公网安备11010802020134号</a><a href="#">京网文[2017]1530-131号</a></p>
        </div>
    </div>
</footer>
<!--底部结束-->
</body>
</html>