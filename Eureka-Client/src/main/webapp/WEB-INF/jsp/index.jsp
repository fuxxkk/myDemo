<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html  xmlns:th="http://www.thymeleaf.org">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登录页面</title>
    <script type="text/javascript" src="js/jquery-1.11.3.js"></script>
</head>
<style type="text/css">
    .d1{
        opacity:0.4;
        filter:alpha(opacity=50);

        background-color:#C0C0C0;
        width:260px;/*(一定要设置这个值)*/
        height:220px;/*(一定要设置这个值)*/
        margin-left: auto;
        margin-right: auto;
        text-align:center;
        vertical-align:middle;
        /*想要两个滚动条的话就把下面的去掉*/
        left:95%;/*FF IE7*/
        top: 50%;/*FF IE7*/
        margin-left:-240px!important;/*FF IE7 该值为本身宽的一半(一定要设置这个值)*/
        margin-top:-160px!important;/*FF IE7 该值为本身高的一半(一定要设置这个值)*/
        margin-top:0px;
        position:fixed!important;/*FF IE7*/
        position:absolute;/*IE6*/
        _top:       expression(eval(document.compatMode &&
				document.compatMode=='CSS1Compat') ?
				documentElement.scrollTop + (document.documentElement.clientHeight-this.offsetHeight)/2 :/*IE6*/
				document.body.scrollTop + (document.body.clientHeight - this.clientHeight)/2);/*IE5 IE5.5*/
    }
    .d2{

        width:215px;/*(一定要设置这个值)*/
        height:180px;/*(一定要设置这个值)*/
        margin: auto;

        position: absolute;
        top: 0; left: 0; bottom: 0; right: 0;
        #background-color:#003300;
    }
    .d3,.d4,.d5,.d8{
        margin-top: 13px;

        text-align: center;



    }

    .d6{
        width:100px;/*(一定要设置这个值)*/
        height:25px;/*(一定要设置这个值)*/
        margin: auto;

        position: absolute;
        left: 3.5px;


    }
    .d7{
        width:100px;/*(一定要设置这个值)*/
        height:25px;/*(一定要设置这个值)*/
        margin: auto;

        position: absolute;
        right: 2.5px;


    }

    #img1{
        cursor:pointer;
    }

    #usernameId,#passwordId,#code{



        background: #ccc;

        color: #666;
    }
    body{
        font-size:12px;
        font-family:"宋体";
        background-image:url(/image/f072302c421ad96c35ac97640497ef3e.jpg);
        background-repeat:repeat-x;
        COLOR: #0C2B30;

    }


    form{margin-top:25%!important}


</style>
<script type="text/javascript">
    $(document).ready(function(){
        // 在这里写你的代码...
       /* $("#btn").click(function(){

            var username = $("#usernameId").val();
            var password = $("#passwordId").val();
            var data = {
                username: username,
                password: password
            };

            $.ajax({
                type: "POST",
                //contentType:"application/json",
                url: "HTTP://localhost:9999/login",
                data:data,     //JSON.stringify(data),
                dataType : "json",
                async : true,
                success: function(data){
                    //window.location.replace("www.baidu.com");
                    alert( "登录 " + data.msg );
                }
            });
        });*/


        $("#img1").click(function(){
            var img = document.getElementById("img1");
            img.src = "validatecode?rnd=" + Math.random();
        });
    });
    //    function login(){
    //        var username = document.getElementById("usernameId").value;
    //        var password = document.getElementById("passwordId").value;
    //
    //        //alert(username+password);
    //        var xmlhttp;
    //        if(window.XMLHttpRequest){
    //            xmlhttp=new XMLHttpRequest();
    //        }else{
    //            xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    //        }
    //    }

</script>
<body>
<div>

    <form action="/login" method="post">
        <div  class="d1">
            <div class="d2">
                <div class="d3">
                    <input type="text" name="username" id="usernameId" style="width:205px;height:25px" placeholder="请输入账号" ></br>
                    <div/>
                    <div class="d4">
                        <input type="text" name="password" id="passwordId" style="width:205px;height:25px" placeholder="请输入密码"  ></br>

                    </div>
                    <div class="d7" style="float:right;width:102px">
                        <span>${error}</span>
                    </div>
                    <div class="d8" style="height: 30px;">
                        <div class="d6" style="float:left;width:100px;" >
                            <input type="text" id="code" placeholder="验证码" style="width:100px;height:25px" >

                        </div>
                        <div class="d7" style="float:right;width:102px">
                            <img src="http://localhost:9999/validatecode" width="100px" height="32px" id="img1" >
                        </div>
                    </div>

                    <div class="d5">
                        <a >
                            <input type="submit" id="btn" value="登录" style="width:210px;height:35px" >
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </form>


</div>

</body>
</html>