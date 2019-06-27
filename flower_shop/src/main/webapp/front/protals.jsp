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
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/front/img/favicon.ico" />
    <!-- Bootstrap -->
    <link href="lib/bootstrap/css/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/front/css/protals.css">
</head>
<body>
    <!--头部-->
    <header id="yj_header">
        <!--上部分  栅格系统 一共分为12栏 小 超小 中 大 container版心居中-->
        <div class="top-bar hidden-sm hidden-xs text-center text-muted">
            <div class="container">
                <div class="row">
                    <div class="top-bar-1 col-md-2">
                        <a href="" class="text-muted">
                            <i class="iconfont">&#xe627;</i>
                            <span>关注微信号</span>
                            <span class="caret"></span>
                            <img src="${pageContext.request.contextPath}/front/imgs/ewm_xzh.jpg" alt="旋之华" width="130">
                        </a>
                    </div>
                    <div class="top-bar-2 col-md-5">
                        <i class="iconfont">&#xe607;</i>
                        <span>8888-555-6666（服务时间：9:00-21:00）</span>
                    </div>
                    <div class="top-bar-3 col-md-2">
                        <a href="" class="text-muted">一花一世界</a>
                    </div>
                    <div class="top-bar-4 col-md-3">
                        <a class="btn btn-default btn-sm btn-register" href="#" role="button">免费注册</a>
                        <a href="#" role="button" class="text-muted" style="margin-left: 10px" data-toggle="modal" data-target="#yj_login">立即登录</a>
                    </div>
                </div>
            </div>
        </div>
        <!--下部分 导航-->
        <nav class="navbar navbar-default navbar-static-top navbar-yj">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#yj_nav" aria-expanded="false">
                        <span class="sr-only"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="${pageContext.request.contextPath}/flower/flower/findAllCategoryAndFlower">
                        <img src="${pageContext.request.contextPath}/front/img/logo.png" alt="有家" width="70">
                    </a>
                </div>

                <div class="collapse navbar-collapse" id="yj_nav">
                    <ul class="nav navbar-nav">
                        <li class="active">
                            <a href="javascript:;">关于我们 </a>
                        </li>
                        <li>
                            <a href="javascript:;">热门专区</a>
                        </li>
                        <li>
                            <a href="javascript:;">孝敬长辈</a>
                        </li>
                        <li>
                            <a href="javascript:;">爱意浓浓</a>
                        </li>
                        <li>
                            <a href="javascript:;">友谊长存</a>
                        </li>
                        <li>
                            <a href="javascript:;">花束常识</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </header>
    <!--/头部-->
    <!--轮播图-->
    <section id="yj_carousel" class="carousel slide" data-ride="carousel">
        <!-- 指示器 -->
        <ol class="carousel-indicators">
            <li data-target="#yj_carousel" data-slide-to="0" class="active"></li>
            <li data-target="#yj_carousel" data-slide-to="1"></li>
            <li data-target="#yj_carousel" data-slide-to="2"></li>
        </ol>

        <!-- 中间滚动的内容 -->
        <div class="carousel-inner" role="listbox">
            <div class="item active" data-sm-img="imgs/slide_01_640x340.jpg" data-lg-img="imgs/slide_01_2000x410.jpg">
            </div>
            <div class="item" data-sm-img="imgs/slide_02_640x340.jpg" data-lg-img="imgs/slide_02_2000x410.jpg">
            </div>
            <div class="item" data-sm-img="imgs/slide_03_640x340.jpg" data-lg-img="imgs/slide_03_2000x410.jpg">
            </div>
        </div>

        <!-- 左右控制 -->
        <a class="left carousel-control" href="#yj_carousel" role="button" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#yj_carousel" role="button" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </section>
    <!--/轮播图-->
    <!--关于我们-->
    <section id="yj_about" class="hidden-xs hidden-sm">
        <!--标题-->
        <div class="title text-center">
            <h1>
                <strong>关于我们</strong>
            </h1>
            <img src="${pageContext.request.contextPath}/front/imgs/star.png" alt="" class="img-responsive">
        </div>
        <!--主要内容-->
        <div class="container">
            <div class="row">
                <div class="col-md-8">
                    <p class="text-muted">
                        有家花店是一个全网线上线下一体的购花网站。成立于1996年06月，聚集了丰富的线下供应链，独家研发的鲜花保存技术，通过实验保证了鲜花较长时间存放依旧鲜艳如新。为喜欢花卉的人们提供了丰富的选择空间。</p>
                    <p class="text-muted">有家花店工作团队达到了数百人，经过专业的技术培训，精通花卉知识，线上线下竭尽全力为您服务，你的满意使我们毕生的追求。</p>
                    <p class="text-muted">
                        有家花店花卉种类包括了玫瑰花，百合，康乃馨 、郁金香，香雪兰、扶郎花外、剑兰、大丽、风信子等等上百种花卉。</p>
                </div>
                <div class="col-md-4">
                    <img src="${pageContext.request.contextPath}/front/imgs/team.jpg" alt="核心团队" class="img-rounded img-responsive">
                </div>
                <div></div>
            </div>
        </div>

    </section>
    <!--/关于我们-->
    <!--产品特色-->
    <section id="yj_product">
        <div class="container">
            <div class="row">
                <!-- 头部选项 -->
                <div style="overflow: auto;">
                    <ul class="nav nav-tabs" role="tablist">
                        <li role="presentation" class="active">
                            <a href="#product1" aria-controls="home" role="tab" data-toggle="tab">亲密爱人</a>
                        </li>
                        <li role="presentation">
                            <a href="#product2" aria-controls="profile" role="tab" data-toggle="tab">生日计划</a>
                        </li>
                        <li role="presentation">
                            <a href="#product3" aria-controls="messages" role="tab" data-toggle="tab">友谊万岁</a>
                        </li>
                        <li role="presentation">
                            <a href="#product4" aria-controls="messages" role="tab" data-toggle="tab">亲情无价</a>
                        </li>
                        <li role="presentation">
                            <a href="#product5" aria-controls="messages" role="tab" data-toggle="tab">探病慰问</a>
                        </li>
                        <li role="presentation">
                            <a href="#product6" aria-controls="messages" role="tab" data-toggle="tab">开业大吉</a>
                        </li>
                        <li class="pull-right hidden-sm hidden-xs">
                            <a href="#" aria-controls="settings" role="tab" data-toggle="tab">更多</a>
                        </li>
                    </ul>
                </div>

                <!-- 展示的内容 -->
                <div class="tab-content">
                    <div role="tabpanel" class="tab-pane fade in active" id="product1">
                        <div class="container">
                            <div class="row">
                                <div class="col-md-8 pd-left">
                                    <img src="${pageContext.request.contextPath}/front/imgs/66.jpg" alt="">
                                </div>
                                <div class="col-md-4 hidden-xs hidden-sm">
                                    <div class="quot">
                                        <p>当爱不能完美，我宁愿选择无悔；不管来生多么美丽，我不愿失去今生对你的记忆。我不求天长地久的美景，我只要生生世世的轮回有你！</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div role="tabpanel" class="tab-pane fade" id="product2">
                        <div class="container">
                            <div class="row">
                                <div class="col-md-4 hidden-sm hidden-xs">
                                    <div class="quot">
                                        <p>让快乐充满心田，让幸福铺满时空，你的快乐，就是我的快乐，带一份祝福给你，说一句祝愿给你，让我们心心相印，祝你生日快乐!</p>
                                    </div>
                                </div>
                                <div class="col-md-8 pd-left">
                                    <img src="${pageContext.request.contextPath}/front/imgs/55.png" alt="">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div role="tabpanel" class="tab-pane fade" id="product3">
                        <div class="container">
                            <div class="row">
                                <div class="col-md-8 pd-left">
                                    <img src="${pageContext.request.contextPath}/front/imgs/44.jpg" alt="">
                                </div>
                                <div class="col-md-4 hidden-xs hidden-sm">
                                    <div class="quot">
                                        <p>朋友就像是你生命中的一盏灯，在你最需要温暖的时候给你送来温暖，没错，我们在逆境中认识了朋友，认识了他们的伟大。友谊是用心感受，用心传递的，只有亲身体验过，才会知道友谊的珍贵。</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div role="tabpanel" class="tab-pane fade" id="product4">
                        <div class="container">
                            <div class="row">
                                <div class="col-md-4 hidden-xs hidden-sm">
                                    <div class="quot">
                                        <p>没有阳光，就没有日子的温暖;没有雨露，就没有五谷丰登;没有水源，就没有生命;没有父母，就没有我们自己。滴水之恩，涌泉相报。关爱父母，使我们的责任。</p>
                                    </div>
                                </div>
                                <div class="col-md-8 pd-right">
                                    <img src="${pageContext.request.contextPath}/front/imgs/33.jpg" alt="">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div role="tabpanel" class="tab-pane fade" id="product5">
                        <div class="container">
                            <div class="row">
                                <div class="col-md-8 pd-left">
                                    <img src="${pageContext.request.contextPath}/front/imgs/22.jpg" alt="">
                                </div>
                                <div class="col-md-4 hidden-xs hidden-sm">
                                    <div class="quot">
                                        <p>人在旅途，难免会遇到荆棘和坎坷，但风雨过后，一定会有美丽的彩虹。我希望看到一个坚强的我，更希望看到一个坚强的你。</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div role="tabpanel" class="tab-pane fade" id="product6">
                        <div class="container">
                            <div class="row">
                                <div class="col-md-4 hidden-xs hidden-sm">
                                    <div class="quot">
                                        <p> 幽香拂面，紫气兆祥，花篮簇拥，开业典礼，祝事业有大成，生意更长久，生意如春浓，财源似水来。</p>
                                    </div>
                                </div>
                                <div class="col-md-8 pd-right ">
                                    <img src="${pageContext.request.contextPath}/front/imgs/11.jpg" alt="">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!--/产品特色-->
    <!--热门花卉-->
    <section id="yj_hot">
        <!--标题-->
        <div class="title text-center">
            <h1>
                <strong>热门花卉</strong>
            </h1>
            <img src="${pageContext.request.contextPath}/front/imgs/star.png" alt="" class="img-responsive">
        </div>
        <!--内容-->
        <div class="container">
            <div class="row">
                <div class="col-md-6 lesson">
                    <div class="media">
                        <div class="media-left">
                            <img src="${pageContext.request.contextPath}/front/imgs/r1.jpg" alt="" class=" media-object img-responsive img-circle img-thumbnail" width="130">
                        </div>
                        <div class="media-body">
                            <h4 class="media-heading">
                                <span class="text-danger">
                                    【热】</span>
                                一心一意--玫瑰11枝
                            </h4>
                            <p class="text-muted" style="margin-top: 10px;">
                                11枝玫瑰，寓意一心一意！ 有情之人，天天是节。一句寒暖，一线相喧；一句叮咛，一笺相传；一份相思，一心相盼；一份爱意，一生相恋。
                            </p>
                        </div>
                        <div class="media-right text-danger">
                            ￥666
                        </div>
                    </div>
                </div>
                <div class="col-md-6 lesson">
                    <div class="media">
                        <div class="media-left">
                            <img width="130" class="media-object img-circle img-thumbnail" src="${pageContext.request.contextPath}/front/imgs/r2.jpg" alt="">
                        </div>
                        <div class="media-body">
                            <h4 class="media-heading">
                                <span class="text-danger">【热】</span>
                                忘情巴黎--33枝红玫瑰
                            </h4>
                            <p class="text-muted" style="margin-top: 10px;">
                                只想和你忘掉一切烦恼，尽情沉醉在最浪漫的气氛中。
                            </p>
                        </div>
                        <div class="media-right text-danger">
                            ￥666
                        </div>
                    </div>
                </div>
                <div class="col-md-6 lesson">
                    <div class="media">
                        <div class="media-left">
                            <img width="130" class="media-object img-circle img-thumbnail" src="${pageContext.request.contextPath}/front/imgs/r3.jpg" alt="">
                        </div>
                        <div class="media-body">
                            <h4 class="media-heading">
                                <span class="text-danger">【热】</span>
                                爱在心头--玫瑰50枝
                            </h4>
                            <p class="text-muted" style="margin-top: 10px;">
                                “此情无计可消除，才下眉头，却上心头。”李清照《一剪梅》
                            </p>
                        </div>
                        <div class="media-right text-danger">
                            ￥888
                        </div>
                    </div>
                </div>
                <div class="col-md-6 lesson">
                    <div class="media">
                        <div class="media-left">
                            <img width="130" class="media-object img-circle img-thumbnail" src="${pageContext.request.contextPath}/front/imgs/r4.jpg" alt="">
                        </div>
                        <div class="media-body">
                            <h4 class="media-heading">
                                <span class="text-danger">【热】</span>
                                真爱--红玫瑰9枝
                            </h4>
                            <p class="text-muted" style="margin-top: 10px;">

                                我用回忆温暖了想你的每一刻　 不让你离我太遥远 走在这个适合拥抱的季节　 爱在心裡所以我不可怜 紧紧抱着你说过的誓言 等待着我们说好的永远
                            </p>
                        </div>
                        <div class="media-right text-danger">
                            ￥999
                        </div>
                    </div>
                </div>
                <div class="col-md-6 lesson">
                    <div class="media">
                        <div class="media-left">
                            <img width="130" class="media-object img-circle img-thumbnail" src="${pageContext.request.contextPath}/front/imgs/r5.jpg" alt="">
                        </div>
                        <div class="media-body">
                            <h4 class="media-heading">
                                <span class="text-danger">【热】</span>
                                爱你如初--雪山白玫瑰66枝
                            </h4>
                            <p class="text-muted" style="margin-top: 10px;">
                                岁月匆匆如白驹过隙，即使时光往复，我依然爱你如初。
                            </p>
                        </div>
                        <div class="media-right text-danger">
                            ￥777
                        </div>
                    </div>
                </div>
                <div class="col-md-6 lesson">
                    <div class="media">
                        <div class="media-left">
                            <img width="130" class="media-object img-circle img-thumbnail" src="${pageContext.request.contextPath}/front/imgs/r6.jpg" alt="">
                        </div>
                        <div class="media-body">
                            <h4 class="media-heading">
                                <span class="text-danger">【热】</span>
                                阳光海岸--19枝香槟玫瑰
                            </h4>
                            <p class="text-muted" style="margin-top: 10px;">
                                和你手牵手漫步海边，在沙滩上画两颗心，心心相印，永不分离。
                            </p>
                        </div>
                        <div class="media-right text-danger">
                            ￥555
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!--/热门花卉-->
    <!--友情链接-->
    <section id="yj_link">
        <!--标题-->
        <div class="title text-center">
            <h1>
                <strong>友情链接</strong>
            </h1>
            <img src="${pageContext.request.contextPath}/front/imgs/star.png" alt="" class="img-responsive">
        </div>
        <ul class="logos">
            <li>
                <a href="">
                    <img src="${pageContext.request.contextPath}/front/imgs/ibm-logo.png" width="100" alt="">
                </a>
            </li>
            <li>
                <a href="">
                    <img src="${pageContext.request.contextPath}/front/imgs/facebook-logo.png" width="50" alt="">
                </a>
            </li>
            <li>
                <a href="">
                    <img src="${pageContext.request.contextPath}/front/imgs/google-logo.png" width="50" alt="">
                </a>
            </li>
            <li>
                <a href="">
                    <img src="${pageContext.request.contextPath}/front/imgs/airbnb-logo.png" width="100" alt="">
                </a>
            </li>
            <li>
                <a href="">
                    <img src="${pageContext.request.contextPath}/front/imgs/swift-logo.png" width="50" alt="">
                </a>
            </li>
            <li>
                <a href="">
                    <img src="${pageContext.request.contextPath}/front/imgs/paypal-logo.png" width="100" alt="">
                </a>
            </li>
            <li>
                <a href="">
                    <img src="${pageContext.request.contextPath}/front/imgs/walmart-logo.png" width="100" alt="">
                </a>
            </li>
        </ul>
    </section>
    <!--/友情链接-->
    <!--尾部-->
    <footer id="yj_footer">
        <div class="container">
            <div class="row" style="padding-top: 20px;">
                <div class="col-md-3 col-md-offset-1 one">
                    <div class="row">
                        <ul class="col-md-6">
                            <li>
                                <a href="">关于我们</a>
                            </li>
                            <li>
                                <a href="">帮助中心</a>
                            </li>
                            <li>
                                <a href="">服务支持</a>
                            </li>
                        </ul>
                        <ul class="col-md-6">
                            <li>
                                <a href="">关注我们</a>
                            </li>
                            <li>
                                <a href="">特色服务</a>
                            </li>
                            <li>
                                <a href="">我们有家</a>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="col-md-3 two">
                    <h5>公司地址: 郑州大学西亚斯国际学院</h5>
                    <h5>联系电话: 1681688888</h5>
                    <h5>地址邮箱: youjia@168.com</h5>
                </div>
                <div class="col-md-3 three">
                    <h5>联系我们:</h5>
                    <a href="">
                        <img src="${pageContext.request.contextPath}/front/imgs/weixin-h.png" alt="" width="50" data-toggle="tooltip" data-placement="bottom" title="lsh666666">
                        <img src="${pageContext.request.contextPath}/front/imgs/xinlang-h.png" alt="" width="50" data-toggle="tooltip" data-placement="bottom" title="lsh888888">
                    </a>
                </div>
            </div>
        </div>
    </footer>
    <!--/尾部-->    
    <script src="${pageContext.request.contextPath}/front/lib/jquery/jquery.js"></script>
    <!-- 引入所有的Bootstrap的JS插件 -->
    <script src="${pageContext.request.contextPath}/front/lib/bootstrap/js/bootstrap.js"></script>
    <!-- 你自己的脚本文件 -->
    <script src="${pageContext.request.contextPath}/front/js/protals.js"></script>
</body>

</html>