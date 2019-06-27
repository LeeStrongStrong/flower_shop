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
    <title>后台管理-首页</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/front/img/favicon.ico"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/back/css/base.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/back/css/go-new.css">
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
        <div class="right">
            <ul>
                <li><i class="iconfont">&#xe612;</i>货到付款</li>
                <li><i class="iconfont">&#xe602;</i>正品保障</li>
                <li><i class="iconfont">&#xe601;</i>上门退款</li>
            </ul>
        </div>
    </div>
</header>
<!--/头部部分-->

<!--主体部分-->
<main>
    <div class="bx">
        <div class="add">更新花蕊</div>
        <div class="group">
            <form action="${pageContext.request.contextPath}/flower/updateFlower" method="post" enctype="multipart/form-data">
                <table>
                        <input hidden="hidden" type="text" name="flower.id" value="${detailFlower.id}">
                    <!---->
                    <tr>
                        <td>鲜花名称 :</td>
                        <td>
                            <input type="text" name="flower.name" value="${detailFlower.name}">
                        </td>
                        <td rowspan="14" style="width: 300px">
                        <td>鲜花材料 :</td>
                        <td><input type="text" name="flower.material" value="${detailFlower.material}"></td>
                    </tr>
                    <tr>
                        <td>鲜花类别 :</td>
                        <td>
                            <select name="flower.CategoryId">
                                <c:forEach items="${requestScope.categories}" var="category">
                                    <option value="${category.id }"
                                    <c:if test="${detailFlower.categoryId eq category.id }">selected="selected"</c:if>
                                    >${category.name }</option>
                                </c:forEach>
                            </select>
                        </td>
                        <td>花语 :</td>
                        <td><input type="text" name="flower.language" value="${detailFlower.language}"></td>
                    </tr>

                    <tr>
                        <td>原价 :</td>
                        <td><input type="number" name="flower.price" value="${detailFlower.price}"></td>
                        <td>封面 :</td>
                        <td rowspan="3">
                            <label id="file_upload1_label" for="file_upload1">
                                <img name="" id="uploadimg" src="${pageContext.request.contextPath}/back/images/img/${detailFlower.image}" alt="" width="118px" height="143px"/>
                            </label>
                            <input type="file" name="cover" class="" id="file_upload1" onchange="upload_review()">
                        </td>
                    </tr>

                    <tr>
                        <td>优惠价 :</td>
                        <td><input type="number" name="flower.myprice" value="${detailFlower.myprice}"></td>
                        <td></td>
                    </tr>
                </table>
                <input type="submit" value="提交"/>&emsp;
                <input type="button" value="返回上级" onclick="history.go(-1);"/>
            </form>
        </div>

    </div>
</main>
<!--/主体部分-->

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
<script>
    function upload_review() {
        var img = document.getElementById("uploadimg");
        var input = document.getElementById("file_upload1");
        var tip = document.getElementById("uploadtip");

        var file = input.files.item(0);
        var freader = new FileReader();
        freader.readAsDataURL(file);
        freader.onload = function (e) {
            img.src = e.target.result;
            tip.style.display = "none";
        };
    }
</script>
</body>
</html>