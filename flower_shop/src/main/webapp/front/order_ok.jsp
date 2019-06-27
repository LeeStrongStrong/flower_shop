<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>有家花店|中国鲜花礼品网-中国鲜花网,鲜花速递网站,网上订花送花上门,鲜花快递网上花店</title>
    <meta name="description" content="有家花店,选中国鲜花专卖网-中国鲜花网领先品牌,youjia.com专注鲜花速递服务14年,销量居鲜花礼品网站首位！鲜花网可24小时预订鲜花，同城送花、异地送花服务,网上订花后最快3小时即可将鲜花快递上门,送花网站覆盖中国2000+城市！"
    />
    <meta name="keywords" content="中国鲜花礼品网,鲜花,鲜花网,鲜花快递,网上订花送花,中国鲜花网,鲜花礼品,网上订花,送花网站" />
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/front/img/favicon.ico"/>
    <style>
        *{
            margin: 0;
            padding: 0;
        }
        body{
            background-color: #ccc;
        }
        .success {
            width: 600px;
            margin: 100px auto;
        }
        #time{
            margin-left: 25px;
        }
        .go{
            width: 300px;
            margin: 15px auto;
        }
    </style>
</head>
<body>
<div class="success">
    <p>下单成功,您的订单号是
        <span class="OrderId"><font color="red"><strong>${sessionScope.orderNo}</strong></font></span>
    <hr>
    总计金额: <font color="red"><strong>${sessionScope.total}</strong></font>
        <span id="time">3</span>
        秒后自动调转到首页
    <div class="go"><a href="./index.html">点击自动跳转</a></div>
    </p>
</div>
</body>
<script>
    var count = 3;
    var timer = null;
    var timeVal = document.getElementById('time');

    timer = setInterval(function () {
        count--;
        timeVal.innerText = count;
        if (count == 0){
            clearInterval(timer)
            location.href = '${pageContext.request.contextPath}/flower/findAllCategoryAndFlower';
        }
    },1000);

</script>
</html>
