<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <title></title>
    <link href="css/H-ui.min.css" rel="stylesheet" type="text/css" />
    <link href="css/H-ui.admin.css" rel="stylesheet" type="text/css" />
    <link href="css/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
    <link href="skin/default/skin.css" rel="stylesheet" type="text/css" id="skin" />
    <script type="text/javascript" src="js/jquery/1.9.1/jquery.min.js"></script>
    <script type="text/javascript">
        function trclick(obj) {
            $("tr").on("click",function(){
                var data = $(this).children().first().children().val();
                alert
                $.ajax({
                    type: 'post',
                    url: 'User!TellerProperty',
                    data:{"datas":data},
                    dataType : "text",
                    success: function(data) {
                        $("#propertyIframe").html(data);
                    }
                });
            })}
        $().ready(function(){refreshsalemanlist();});
        function register(){
            var index = layer.open({
                type: 2,
                title: "<s:text name="register.reg" />",area: ['310px', '330px'],
                fix: false, //不固定
                maxmin: false,
                content: "/register.jsp?usertype=2"
            });}
        function refreshsalemanlist(){
            $.ajax({
                type: 'post',
                url: 'User!ListTeller',
                success: function(data) {
                    $("#parentIframe").html(data);
                    trclick();
                }
            });}
        function callback(params){
            refreshsalemanlist()
        }
    </script>
</head>
<body>
<div class="mt">
    <div class="panel panel-default" style="float: left;width: 44%">
        <div class="panel-header"><s:text name="teller.listtitle" /><span style="float:right;" ><a href="javascript:void(0);" class="btn btn-primary radius size-S " onclick="register();"><s:text name="salesman.addbutton" /></a></span></div>
        <div class="panel-body" id="parentIframe" ></div>
    </div>
    <div class="panel panel-default" style="float: right;width: 54%;">
        <div class="panel-header"><s:text name="teller.tellerProperty" /><span style="float:right"><input class="btn btn-primary radius size-S " type="button" value="<s:text name="salesman.savebutton" />" onclick="updatetellerinfo()"></span></div>
        <div class="panel-body" id="propertyIframe"></div>
    </div>
</div>
<script type="text/javascript" src="js/layer/1.9.3/layer.js"></script>
<script type="text/javascript" src="js/H-ui.js"></script>
<script type="text/javascript" src="js/H-ui.admin.js"></script>
</body>
</html>