<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>有家花店|中国鲜花礼品网-中国鲜花网,鲜花速递网站,网上订花送花上门,鲜花快递网上花店</title>
    <meta name="description"
          content="有家花店,选中国鲜花专卖网-中国鲜花网领先品牌,youjia.com专注鲜花速递服务14年,销量居鲜花礼品网站首位！鲜花网可24小时预订鲜花，同城送花、异地送花服务,网上订花后最快3小时即可将鲜花快递上门,送花网站覆盖中国2000+城市！"/>
    <meta name="keywords" content="中国鲜花礼品网,鲜花,鲜花网,鲜花快递,网上订花送花,中国鲜花网,鲜花礼品,网上订花,送花网站"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/front/css/base.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/front/css/index.css">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/front/img/favicon.ico"/>

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
        <%--<div class="logo">
            <h1>
                <a href="${pageContext.request.contextPath}/flower/findAllCategoryAndFlower"><img src="${pageContext.request.contextPath}/front/img/logo.png" alt="有家花店" title="有家花店"></a>
            </h1>
        </div>--%>
    </div>
</header>
<!-- 头部结束 -->

<!--主题部分-->
<main>
    <div class="bx">
        <!-- 侧边栏开始 -->
        <aside>
            <ul class="aside_nav">
                <!-- 类别开始 -->
                <c:forEach items="${requestScope.map}" var="m">
                    <li>
                        <a href="#">${m.key}</a>
                        <!-- 类别内的鲜花-->
                        <ul class="nav_list">
                            <c:forEach items="${m.value}" var="flower" begin="0" end="6">
                                <li>
                                    <a name="link_prd_img"
                                       href='${pageContext.request.contextPath}/flower/findDetail?flowerId=${flower.id}'>
                                        <img src="${pageContext.request.contextPath}/back/images/img/${flower.image}"
                                             alt="${flower.language}" title="${flower.language}">
                                    </a>
                                    <span><a
                                            href="${pageContext.request.contextPath}/flower/findDetail?flowerId=${flower.id}">${flower.name}</a>&nbsp; &nbsp;&nbsp;<strong>¥${flower.myprice}</strong></span>
                                </li>
                            </c:forEach>
                        </ul>
                    </li>
                </c:forEach>
            </ul>
        </aside>
        <!-- 侧边栏结束 -->
        <!--轮播图-->
        <div class="carousel">
            <!--轮播图片-->
            <ul class="imgList">
                    <li><img src="${pageContext.request.contextPath}/front/img/lun_01.jpg" alt=""></li>
                    <li><img src="${pageContext.request.contextPath}/front/img/lun_02.jpg" alt=""></li>
                    <li><img src="${pageContext.request.contextPath}/front/img/lun_03.jpg" alt=""></li>
                </ul>
           <!--左右按钮-->
           <span class="leftBtn iconfont">&#xe606;</span>
           <span class="rightBtn iconfont">&#xe603;</span>
        </div>
    </div>
</main>
<!--主题结束-->

<!--产品详情-->
<div class="products">
    <div class="content bx">
        <div class="products1">
            <div class="pd_left">
                <div class="pd_left_top">
                    <img src="${pageContext.request.contextPath}/front/img/banner_love.jpg" alt="" title="鲜花热卖专区">
                </div>
                <div class="pd_left_bottom">
                    <span><a href="#">热卖鲜花专区</a></span>
                </div>
            </div>
            <div class="pd_right">
                <ul>
                    <c:forEach items="${requestScope.hotSaleFlowers}" var="hotSaleFlower">
                        <li>
                            <a name="link_prd_img"
                               href='${pageContext.request.contextPath}/flower/findDetail?flowerId=${hotSaleFlower.id}'>
                                <img src="${pageContext.request.contextPath}/back/images/img/${hotSaleFlower.image}"
                                     alt="${hotSaleFlower.language}" title="${hotSaleFlower.language}">
                            </a>
                            <a name="link_prd_img"
                               href='${pageContext.request.contextPath}/flower/findDetail?flowerId=${hotSaleFlower.id}'>
                                <p>${hotSaleFlower.name}</p>
                            </a>
                            <span>￥${hotSaleFlower.myprice}</span>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
        <div class="products2">
            <div class="pd_left">
                <div class="pd_left_top">
                    <img src="${pageContext.request.contextPath}/front/img/banner_parents.jpg" alt="" title="站长推荐">
                </div>
                <div class="pd_left_bottom">
                    <span><a href="#">推荐鲜花专区</a></span>
                </div>
            </div>
            <div class="pd_right">
                <ul>
                    <c:forEach items="${requestScope.recommendFlowers}" var="recommendFlower">
                        <li>
                            <a name="link_prd_img"
                               href='${pageContext.request.contextPath}/flower/findDetail?flowerId=${recommendFlower.id}'>
                                <img src="${pageContext.request.contextPath}/back/images/img/${recommendFlower.image}"
                                     alt="${recommendFlower.language}" title="${recommendFlower.language}">
                            </a>
                            <a name="link_prd_img"
                               href='${pageContext.request.contextPath}/flower/findDetail?flowerId=${recommendFlower.id}'>
                                <p>${recommendFlower.name}</p>
                            </a>
                            <span>￥${recommendFlower.myprice}</span>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
        <div class="products3">
            <div class="pd_left">
                <div class="pd_left_top">
                    <img src="${pageContext.request.contextPath}/front/img/banner_song.jpg" alt="" title="站长推荐">
                </div>
                <div class="pd_left_bottom">
                    <span><a href="#">推荐鲜花专区</a></span>
                </div>
            </div>
            <div class="pd_right">
                <ul>
                    <c:forEach items="${requestScope.secRecommendFlowers}" var="recommendFlower">
                        <li>
                            <a name="link_prd_img"
                               href='${pageContext.request.contextPath}/flower/findDetail?flowerId=${recommendFlower.id}'>
                                <img src="${pageContext.request.contextPath}/back/images/img/${recommendFlower.image}"
                                     alt="${recommendFlower.language}" title="${recommendFlower.language}">
                            </a>
                            <a name="link_prd_img"
                               href='${pageContext.request.contextPath}/flower/findDetail?flowerId=${recommendFlower.id}'>
                                <p>${recommendFlower.name}</p>
                            </a>
                            <span>￥${recommendFlower.myprice}</span>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>
    <!--楼层部分-->
    <div class="floor">
        <ul>
            <li><a href="javascript:;">导航</a></li>
            <li><a href="javascript:;">热卖鲜花</a></li>
            <li><a href="javascript:;">关爱父母</a></li>
            <li><a href="javascript:;">爱意浓浓</a></li>
            <li class="top"><a href="javascript:;">顶部</a></li>
        </ul>
    </div>

</div>
<!--产品详情结束-->

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
<script src="${pageContext.request.contextPath}/front/lib/jquery/jquery.js"></script>
<script src="${pageContext.request.contextPath}/front/js/index.js"></script>
</body>
</html>