/*************************************轮播图*********************************************/

    var imgW = $(".imgList li").width();
    var length = $(".imgList li").length;
    var lis = $(".focusList li");
    var ins = 0;
    var tiemr;
    var idx = 0;

    //动态设置ul的宽
    //$(".imgList").css("width", length * imgW);

    //鼠标进入清楚定时器 离开开启定时器
    $(".carousel").hover(function () {
        clearInterval(tiemr)
    }, function () {
        clearInterval(tiemr);
        tiemr = setInterval(show, 3000);
    });

    //右边按钮
    $(".rightBtn").click(function () {
        show();
        clearInterval(tiemr);
    });

    //左边按钮
    $(".leftBtn").click(function () {
        ins--;
        ins = ins < 0 ? length - 1 : ins;
        lis.eq(ins).addClass("current").siblings().removeClass("current");
        $('.imgList').css('left', -imgW).children().last().prependTo('.imgList');
        $(".imgList").stop(true, true).animate({
            left: 0
        }, 500)
    });

    tiemr = setInterval(show, 3000);

    function show() {
        ins++;
        ins = ins > length - 1 ? 0 : ins;
        lis.eq(ins).addClass("current").siblings().removeClass("current");
        $(".imgList").stop(true, true).animate({
            left: -imgW
        }, 500, function () {
            $(this).children().first().appendTo('.imgList');
            $(this).css({
                left: 0
            })
        })
    }

    /*************************************楼层效果*********************************************/

    //1.楼层根据滑动自动变更
    $(window).scroll(function () {
        var scrollTop = document.documentElement.scrollTop;
        scrollTop >= 80 &&  scrollTop <= 1750?  $(".floor").fadeIn(500): $(".floor").fadeOut(500);

        if (scrollTop >= 100 && scrollTop < 640) {
            idx = 1;
            showl(idx)
        }
        if (scrollTop >= 640 && scrollTop < 1205) {
            idx = 2;
            showl(idx)
        }
        if (scrollTop >= 1205) {
            idx = 3;
            showl(idx)
        }


    });
    //2.点击楼层的效果出现对应的模块
    $(".floor ul li").click(function () {
        idx = $(this).index();
        if (idx == 1){
            $("html, body").animate({scrollTop: 200}, 100);
            show(idx);
        } else if(idx == 2){
            $("html, body").animate({scrollTop: 800}, 100);
            show(idx);
        }else if(idx == 3){
            $("html, body").animate({scrollTop: 1400}, 100);
            show(idx);
        }
    });

    //点击返回顶部
    $(".top").click(function () {
        $("html, body").animate({scrollTop: 0}, 1000);
    });

    function showl(a) {
        $(".floor ul li").eq(a).addClass("active").siblings().removeClass("active");
    }

    //鼠标进入时 li的背景 离开时 回到当前索引
    $(".floor ul li").hover(function () {
        var ins = $(this).index();
        ins = ins == 0 ? undefined : ins;
        showl(ins)
    }, function () {
        showl(idx)
    });






