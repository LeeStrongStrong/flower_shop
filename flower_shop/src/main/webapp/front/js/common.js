// 点小图 切换大图
var aObj = document.getElementById("uu").getElementsByTagName("a");
for (var i = 0; i < aObj.length; i++){
    aObj[i].onclick = function () {
        document.getElementById("big").src = this.href;
        return false;
    };
};
