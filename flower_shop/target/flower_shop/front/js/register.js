$(function () {
    // <!--1. 邮箱验证 -->
    $("#txtEmail").blur(
        checkEmail
    );
    // <!--2. 昵称的验证 -->
    $("#txtNickName").blur(
        checkNickname
    );
    // <!--3. 密码验证-->
    $("#txtPassword").blur(
        checkPassword
    );
    // <!--4. 再次密码验证-->
    $("#txtRepeatPass").blur(
        checkPassword1
    );
    // <!--检查验证码是否为空-->
    $("#txtVerifyCode").blur(
        checkCode
    );

    // <!-- 1.邮箱验证 -->
    function checkEmail() {
        var email = $("#txtEmail").val();
        //邮箱验证的正则表达式
        var str = new RegExp("^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$");

        if (str.test(email)) {
            $("#prompt1").css({color: "green"}).text("邮箱格式正确!");
            return true;
        } else if (email == "") {
            $("#prompt1").css({color: "#ccc"}).text(" 6~18个字符，可使用字母、数字、下划线");

        } else {
            $("#prompt1").css({color: "red"}).text("您输入的邮箱格式错误,请重新输入!");
            return false;
        }
    }

    // <!-- 2.昵称的验证 -->
    function checkNickname() {
        var nickname = $("#txtNickName").val();
        var length = 0;//字符长度
        var charCode = -1;
        var reg = new RegExp("^[a-z0-9\u4E00-\u9FFF]+$");	//小写英文字母 数字 中文
        if (reg.test(nickname)) {
            for (var i = 0; i < nickname.length; i++) {
                //获取昵称字符串中的每一个字符
                charCode = nickname.charCodeAt(i);
                //判断字符是否是汉字
                if (charCode >= 0 && charCode <= 127) {
                    //不是汉字
                    length += 1;
                } else {
                    //是汉字
                    length += 2;
                }
            }

            if (length >= 4 && length <= 20) {
                $("#prompt2").css({color: "green"}).text("可以使用该昵称!");
                return true;
            } else if (length < 4) {
                $("#prompt2").css({color: "hotpink"}).text("昵称名字过短!");
                return false;
            } else if (length > 20) {
                $("#prompt2").css({color: "purple"}).text("昵称名字过长!");
                return false;
            }
        } else if (length == "") {
            $("#prompt2").css({color: "#ccc"}).text(" 4~20个字符，可使用字母、汉字");

        } else {
            $("#prompt2").css({color: "red"}).text("昵称格式错误,请重新输入");
            return false;
        }
    }

    // <!-- 3.密码验证-->
    function checkPassword() {
        var password = $("#txtPassword").val();
        var reg = new RegExp("^[A-Za-z0-9]+$");	//小写英文字母 数字
        if (reg.test(password)) {
            if (password.length >= 6 && password.length <= 20) {
                $("#prompt3").css({color: "green"}).text("密码可用");
                return true;
            } else {
                $("#prompt3").css({color: "purple"}).text("密码过短");
                return false;
            }
        } else if (password == "") {
            $("#prompt3").css({color: "#ccc"}).text("6~16个字符，区分大小写");
            return false;
        } else {
            $("#prompt3").css({color: "red"}).text("密码格式不正确");
            return false;
        }
    };

    // <!--再次密码验证-->
    function checkPassword1() {
        var password1 = $("#txtRepeatPass").val();
        //获取第一次输入的密码
        var password = $("#txtPassword").val();
        if (password === password1 && password !== '' && password1 !== '') {
            $("#prompt4").css({color: "green"}).text("密码一致");
            return true;
        } else if (password == "") {
            $("#prompt4").css({color: "#ccc"}).text("请再次填写密码");
            return false;
        } else {
            $("#prompt4").css({color: "red"}).text("两次填写的密码不一致");
            return false;
        }
    };

    // <!--检查验证码是否为空-->
    function checkCode() {
        var code = $("#txtVerifyCode").val();
        if (code == "") {
            $("#prompt5").css({color: "#ccc"}).text("请填写验证码");
            return false;
        } else {
            $("#prompt5").css({color: "green"}).text("");
            return true;
        }
    };


    function check() {
        if (checkEmail() && checkNickname() && checkPassword() && checkPassword1() && checkCode()) {
            return true;
        } else {
            return false;
        }
    }
    // 改变验证码
    function changeImage() {
        $("#imgVcode").attr({"src": "${pageContext.request.contextPath}/user/getImage?t=" + Math.random()});
    }
});






