<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    <!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>花蕊管理页面</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/front/img/favicon.ico"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/back/css/base.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/back/css/stamen.css">
</head>
<body>
<!--头部部分-->
<header>
    <div class="bx">
        <div class="logo">
            <h1>
                <a href="../login.jsp">
                    <img src="${pageContext.request.contextPath}/back/images/img/logo.png" alt="有家后台">
                </a>
            </h1>
        </div>
        <h2>"有家花店"后台管理系统</h2>
        <input type="button" onclick="window.parent.location.href='${pageContext.request.contextPath}/admin/safeOut'" value="安全退出">
    </div>
</header>
<!--头部结束-->
<!--主体部分-->
<main>
    <div class="bx">
        <aside>
            <h3>系统主菜单</h3>
            <ul>
                <li><a href="${pageContext.request.contextPath}/category/findAll">类别管理</a></li>
                <li><a href="${pageContext.request.contextPath}/user/selectAllUser">用户管理</a></li>
                <li><a href="${pageContext.request.contextPath}/order/selectAllOrder">订单管理</a></li>
                <li class="current"><a href="${pageContext.request.contextPath}/flower/findAll">花蕊管理</a></li>
            </ul>
        </aside>
        <!--主体右边部分-->
        <div class="right">
            <h3>花蕊管理</h3>
            <div class="group">
                <form action="${pageContext.request.contextPath}/flower/findBySth" method="post">
                    <select name="key">
                        <option value="name">名称</option>
                        <option value="material">材料</option>
                        <option value="language">花语</option>
                    </select>
                    <input type="text" placeholder="请输入查询条件"name="content" >
                    <input type="submit" value="查询">
                </form>
                <a href="${pageContext.request.contextPath}/flower/selectAllCategory" class="new">上架鲜花</a>
            </div>
            <table>
                <tr>
                    <th colspan="4">鲜花编号</th>
                    <th>鲜花名称</th>
                    <th>鲜花材料</th>
                    <th>鲜花图片</th>
                    <th colspan="2">花语</th>
                    <th>原价</th>
                    <th>优惠价</th>
                    <th colspan="2">操作</th>
                </tr>
            <c:forEach items="${requestScope.flowers}" var="flower">
                <tr>
                    <td colspan="4">${flower.id}</td>
                    <td>${flower.name}</td>
                    <td>${flower.material}</td>
                    <td><img src="${pageContext.request.contextPath}/back/images/img/${flower.image}" alt="" height="35"></td>
                    <td colspan="2">${flower.language}</td>
                    <td>￥${flower.price}</td>
                    <td>￥${flower.myprice}</td>
                    <td><span class="change" onclick="location.href='${pageContext.request.contextPath}/flower/selectOneAndCategory?flowerId=${flower.id}'">更新</span></td>
                    <td><span class="delete" onclick="location.href='${pageContext.request.contextPath}/flower/remove?flowerId=${flower.id}'">删除</span></td>
                </tr>
            </c:forEach>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
            </table>
        </div>
    </div>
</main>
<!--主体结束-->
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
</html>