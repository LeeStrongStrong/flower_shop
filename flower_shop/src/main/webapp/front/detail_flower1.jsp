<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>有家花店|中国鲜花礼品网-中国鲜花网,鲜花速递网站,网上订花送花上门,鲜花快递网上花店</title>
    <meta name="description"
          content="有家花店,选中国鲜花专卖网-中国鲜花网领先品牌,youjia.com专注鲜花速递服务14年,销量居鲜花礼品网站首位！鲜花网可24小时预订鲜花，同城送花、异地送花服务,网上订花后最快3小时即可将鲜花快递上门,送花网站覆盖中国2000+城市！"/>
    <meta name="keywords" content="中国鲜花礼品网,鲜花,鲜花网,鲜花快递,网上订花送花,中国鲜花网,鲜花礼品,网上订花,送花网站"/>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/front/img/favicon.ico"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/front/css/base.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/front/css/flower_detail.css">
</head>
<body>
<!-- 导航开始 -->
<nav>
    <div class="nav-inner bx">
        <h2><a href="javascript:;">欢迎&dzigrarr;<span style="color: red;">${sessionScope.loginUser.nickName}</span> ,
            祝您购花愉快！</a></h2>
        <ul>
            <c:if test="${sessionScope.loginUser ==null}">
                <li><a href="${pageContext.request.contextPath}/front/login1.jsp">登录</a></li>
                <li><a href="${pageContext.request.contextPath}/front/register1.jsp">注册</a></li>
            </c:if>
            <c:if test="${sessionScope.loginUser !=null}">
                <li><a href="${pageContext.request.contextPath}/user/exit">安全退出</a></li>
            </c:if>
            <li>
                <a href="${pageContext.request.contextPath}/front/shopping.jsp">购物车</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/front/protals.jsp">网站相关</a>
            </li>
        </ul>
    </div>
</nav>
<!-- 导航结束 -->
<!-- 头部开始 -->
<header>
    <div class="header-inner bx">
        <div class="logo">
           <%-- <h1>
                <a href="${pageContext.request.contextPath}/flower/findAllCategoryAndFlower"><img src="${pageContext.request.contextPath}/front/img/logo.png" alt="有家花店" title="有家花店"></a>
            </h1>--%>
        </div>
        <%--<form action="">
            <input type="text" placeholder="请输入您需要的花">
            <input type="button" value="搜索">
        </form>--%>
    </div>
</header>
<!-- 头部结束 -->
<main>
    <div class="bx product-wrapper">

        <div class="product-l">
            <div class="pro-preview" id="pro-preview">
                <img src="${pageContext.request.contextPath}/back/images/img/${detailFlower.image}" alt="" id="big">
            </div>
        </div>
        <div class="product-r">
            <section>
                <h3>${detailFlower.name}</h3>
                <span class="boo">爆款特惠！</span>
            </section>
            <section>
                <p><span>编号：</span>${detailFlower.id}</p>
                <p><span> 类 别：</span> ${detailFlower.category.name}</p>
                <p><span> 材 料：</span> ${detailFlower.material}</p>
                <p><span>花语：</span>${detailFlower.language}</p>
                <p><span>销量：</span>&nbsp;&nbsp;<strong><i>${detailFlower.sale}</i></strong></p>
            </section>
            <section class="price">
                <span><del>市场价：￥${detailFlower.price}</del></span>
                <span style="color: red;"><strong>花礼价：￥${detailFlower.myprice}</strong></span>
                <a href="${pageContext.request.contextPath}/cart/addCart?flowerId=${detailFlower.id}">立即购买</a>
            </section>
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
            <p>&copy;<a href="#">京ICP证110507号</a><a href="#">京ICP证110507号</a><a href="#">京公网安备11010802020134号</a><a
                    href="#">京网文[2017]1530-131号</a></p>
        </div>
    </div>
</footer>
<!--底部结束-->
</body>
<script src="js/register.js"></script>
</html>