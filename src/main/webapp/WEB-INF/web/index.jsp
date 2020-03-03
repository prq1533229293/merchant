<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-01-02
  Time: 9:26
--%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>商户入驻记录系统</title>
    <link rel="stylesheet" type="text/css" href="../../jquery/kkpager_blue.css"/>
</head>
<style type="text/css">
    /* 整体设计 */
    body {
        font-family: "微软雅黑";
        background-color: lavender;
    }

    .merchant {
        width: 500px;
        height: 30px;

    }

    .merchant-info {
        left: 150px;
        width: 150px;
        height: 20px;
    }

    .hints {
        color: red;
        position: absolute;
        left: 310px;
        display: none;
    }

</style>
<body>
<h3 id="rq"></h3>
<form id="add_info" method="post" action="/add">
    <div class="merchant">
        <span>所属代理商：</span>
        <input id="belong" class="merchant-info" type="text" name="belong" autocomplete="off">
        <span id="belong_hints" class="hints">不能为空</span>
        <span id="belong_hints_2" class="hints">输入的姓名不合法</span>
    </div>
    <div class="merchant">
        营业执照名称：
        <input id="merchantName" class="merchant-info" type="text" name="merchantName" autocomplete="off">
        <span id="merchantName_hints" class="hints">不能为空</span>
    </div>
    <div class="merchant">
        商户简称：
        <input id="merchantForshort" class="merchant-info" type="text" name="merchantForshort" autocomplete="off">
        <span id="merchantForshort_hints" class="hints">不能为空</span>
    </div>
    <div class="merchant">
        联系人姓名：
        <input id="contactName" class="merchant-info" type="text" name="contactName" autocomplete="off">
        <span id="contactName_hints" class="hints">不能为空</span>
        <span id="contactName_hints_2" class="hints">输入的姓名不合法</span>
    </div>
    <div class="merchant">
        联系电话：
        <input id="phone" class="merchant-info" type="text" name="phone" autocomplete="off">
        <span id="phone_hints" class="hints">不能为空</span>
        <span id="phone_hints_2" class="hints">输入的电话号码不合法</span>
    </div>
    <div class="merchant">
        申请入驻日期：<input id="applicationDate" class="merchant-info" type="date" name="applicationDate" value="2019-09-01">
        <span id="application_hints" class="hints">不能为空</span>
    </div>
    <div class="merchant">
        入驻状态：
        <select id="status" class="merchant-info" onchange="change_content()" name="status">
            <option style="color: #000000">请选择</option>
            <option style="color: green">审核中</option>
            <option style="color: orange">待账户验证</option>
            <option style="color: orange">微信待验证</option>
            <option style="color: orange">支付宝待验证</option>
            <option style="color: red">审核不通过</option>
            <option style="color: green">入驻完成</option>
        </select>
        <span id="status_hints" class="hints">不能为空</span>
    </div>
    <div class="merchant">
        微信费率：
        <input id="weChatRate" class="merchant-info" type="input" name="weChatRate" autocomplete="off">
    </div>

    <div class="merchant">
        支付宝账号所属：
        <input id="alipayTheir" class="merchant-info" type="input" name="alipayTheir" autocomplete="off">
    </div>
    <div class="merchant">
        支付宝费率：
        <input id="alipayRate" class="merchant-info" type="input" name="alipayRate" autocomplete="off">
    </div>
    <div class="merchant">
        备注：
        <input id="note" class="merchant-info" type="text" name="note" autocomplete="off">
    </div>
    <button id="submit" type="button" onclick="add()">提交</button>
</form>
<form id="selectInfo">
    商户名称：<input type="text" name="merchantName" autocomplete="off"/>
    微信商户号：<input type="text" name="wechatMerchant" autocomplete="off"/>
    入驻状态：
    <select class="merchant-info" onchange="change_content()" name="status">
        <option style="color: #000000">请选择</option>
        <option style="color: green">审核中</option>
        <option style="color: orange">待账户验证</option>
        <option style="color: orange">微信待验证</option>
        <option style="color: orange">支付宝待验证</option>
        <option style="color: red">审核不通过</option>
        <option style="color: green">入驻完成</option>
    </select>
    <button type="button" onclick="select()">查询</button>
</form>
<h3>商户信息</h3>
<div>
    <table border="1" style="border-collapse:collapse;">
        <tr>
            <th>ID序号</th>
            <th>所属代理商</th>
            <th>营业执照名称</th>
            <th>商户简称</th>
            <th>联系人姓名</th>
            <th>联系电话</th>
            <th>申请入驻日期</th>
            <th>入驻状态</th>
            <th>云支付子商户账号</th>
            <th>微信支付商户号</th>
            <th>微信费率</th>
            <th>微信费率生效日期</th>
            <th>支付宝账号</th>
            <th>支付宝商家PID</th>
            <th>支付宝商家名称</th>
            <th>支付宝费率</th>
            <th>备注</th>
            <th>操作</th>
        </tr>

        <c:forEach items="${merchants}" var="m">
            <tr>
                <td style="width:60px;">${m.id}</td>
                <td>
                    <input type="text" value="${m.belong}" style="width:90px; height:30px; border: 0;">
                </td>
                <td>
                    <input type="text" value="${m.merchantName}" style="width:100px; height:30px; border: 0;">
                </td>
                <td>
                    <input type="text" value="${m.merchantForshort}" style="width:100px; height:30px; border: 0;">
                </td>
                <td>
                    <input type="text" value="${m.contactName}" style="width:100px; height:30px; border: 0;">
                </td>
                <td>
                    <input type="text" value=" ${m.phone}" style="width:100px; height:30px; border: 0;">
                </td>
                <td>
                    <input type="text" value="${m.applicationDate}" style="width:100px; height:30px; border: 0;">
                </td>
                <td>
                    <select class="merchant-info" onchange="change_content()" name="status"
                            style="width:105px; height:30px; border: 0;">
                        <option style="color: #000000">${m.status}</option>
                        <option style="color: green">审核中</option>
                        <option style="color: orange">待账户验证</option>
                        <option style="color: orange">微信待验证</option>
                        <option style="color: orange">支付宝待验证</option>
                        <option style="color: red">审核不通过</option>
                        <option style="color: green">入驻完成</option>
                    </select>
                </td>
                <td>
                    <input type="text" value="${m.childMerchant}" style="width:150px; height:30px; border: 0;">
                </td>
                <td>
                    <input type="text" value="${m.wechatMerchant}" style="width:120px; height:30px; border: 0;">
                </td>
                <td>
                    <input type="text" value="${m.wechatRate}" style="width:80px; height:30px; border: 0;">
                </td>
                <td>
                    <input type="date" value="${m.wechatRateDate}" style="height:30px; border: 0;">
                </td>
                <td>
                    <input type="text" value="${m.alipayId}" style="width:100px; height:30px; border: 0;">
                </td>
                <td>
                    <input type="text" value="${m.alipayPid}" style="width:120px; height:30px; border: 0;">
                </td>
                <td>
                    <input type="text" value="${m.alipayTheir}" style="width:120px; height:30px; border: 0;">
                </td>
                <td>
                    <input type="text" value="${m.alipayRate}" style="width:100px; height:30px; border: 0;">
                </td>
                <td>
                    <input type="text" value="${m.note}" style="width:100px; height:30px; border: 0;">
                </td>
                <td>
                    <button onclick="updata(this)">修改</button>
                </td>
            </tr>
        </c:forEach>
    </table>
    <!-- 分页 -->
    <div style="width:1000px;margin:0 auto;">
        <div id="kkpager"></div>
    </div>
</div>
</body>
<script src="../../jquery/jquery-3.3.1.js"></script>
<script type="text/javascript" src="../../jquery/kkpager.min.js"></script>
<script type="text/javascript">
    /**
     * 页面初始化时执行的函数
     */
    jQuery(function () {
        $("#applicationDate").val(getNowDate());
        $.ajax({
            url: "/select",
            type: "post",
            dataType: "text",
            success: function (info) {

            }
        });
    })

    //申请状态下拉选颜色设置
    function change_content() {
        var content = $("#status").val();
        console.log(content);
        if (content === "请选择") {
            $("#status").css("color", "#000000");
        } else if (content === "审核中" || content === "入驻完成") {
            $("#status").css("color", "green");
        } else if (content === "待账户验证" || content === "微信待验证" || content === "支付宝待验证") {
            $("#status").css("color", "orange");
        } else {
            $("#status").css("color", "red");
        }
    }

    //获取当天日期的函数前
    function getNowDate() {
        var date = new Date();
        var sign1 = "-";
        var year = date.getFullYear() // 年
        var month = date.getMonth() + 1; // 月
        var day = date.getDate(); // 日

        // 给一位数数据前面加 “0”
        if (month >= 1 && month <= 9) {
            month = "0" + month;
        }
        if (day >= 0 && day <= 9) {
            day = "0" + day;
        }
        return year + sign1 + month + sign1 + day;
    }

    /**
     * 新增商户
     */
    function add() {
        var belong = $("#belong").val();
        var merchantName = $("#merchantName").val();
        var merchantForshort = $("#merchantForshort").val();
        var contactName = $("#contactName").val();
        var phone = $("#phone").val();
        var applicationDate = $("#applicationDate").val();
        var status = $("#status").val();
        // var note = $("#note").val();
        var a = verify(belong, merchantName, merchantForshort, contactName, phone, applicationDate, status);
        if (a === 1) {
            return;
        }
        console.log("666");
        $.ajax({
            url: "/add",
            type: "post",
            data: $("#add_info").serialize(),
            dataType: "json",
            success: function (info) {
                alert(info);
            }
        });

    }

    //信息填写校验
    function verify(belong, merchantName, merchantForshort, contactName, phone, applicationDate, status) {
        //校验姓名的正则
        var regexp = "[\u4e00-\u9fa5\\·]{2,20}";

        if (belong == "") {
            $("#belong_hints_2").css("display", "none");
            $("#belong_hints").css("display", "inline");
            return 1;
        } else {
            $("#belong_hints").css("display", "none");
            if (!belong.match(regexp)) {
                $("#belong_hints_2").css("display", "inline");
                return 1;
            } else {
                $("#belong_hints_2").css("display", "none");
            }
        }

        if (merchantName == "") {
            $("#merchantName_hints").css("display", "inline");
            return 1;
        } else {
            $("#merchantName_hints").css("display", "none");
        }

        if (merchantForshort == "") {
            $("#merchantForshort_hints").css("display", "inline");
            return 1;
        } else {
            $("#merchantForshort_hints").css("display", "none");
        }

        if (contactName == "") {
            $("#belong_hints_2").css("display", "none");
            $("#contactName_hints").css("display", "inline");
            return 1;
        } else {
            $("#contactName_hints").css("display", "none");
            if (!contactName.match(regexp)) {
                $("#contactName_hints_2").css("display", "inline");
                return 1;
            } else {
                $("#contactName_hints_2").css("display", "none");
            }
        }

        //手机号码验证
        var phoneNumReg = "/^1[3456789]\\d{9}$/";
        if (phone == "") {
            $("#phone_hints_2").css("display", "none");
            $("#phone_hints").css("display", "inline");
            return 1;
        } else {
            $("#phone_hints").css("display", "none");

            if (!/^1[3456789]\d{9}$/.test(phone)) {
                $("#phone_hints_2").css("display", "inline");
                return 1;
            } else {
                $("#phone_hints_2").css("display", "none");
            }
        }

        if (applicationDate == "") {
            $("#applicationDate_hints").css("display", "inline");
            return 1;
        } else {
            $("#applicationDate_hints").css("display", "none");
        }

        if (status == "" || status == "请选择") {
            $("#status_hints").css("display", "inline");
            return 1;
        } else {
            $("#status_hints").css("display", "none");
        }
    }

    //查询数据
    function select() {
        $("#selectInfo").serialize();
        $.ajax({
            url: "/select",
            method: "post",
            data: $("#selectInfo").serialize(),
            dataType: "json",
            success:function (data) {
                console.log(data);

            }
        })
    }

    // kkpager分页控件
    $(function () {
        //var pageNo = getParameter('pno');
        var pageNo = "${current}";
        if (!pageNo) {
            pageNo = 1;
        }
        //生成分页
        //有些参数是可选的，比如lang，若不传有默认值
        kkpager.generPageHtml({
            //当前页数
            pno: pageNo,
            //总页数
            total: "${pages}",
            //总数据条数
            totalRecords: "${total}",
            //链接前部
            hrefFormer: 'index',
            //链接尾部
            hrefLatter: '',
            getLink: function (n) {
                return this.hrefFormer + this.hrefLatter + "?currents=" + n;
            }
            /*,lang				: {
                firstPageText			: '首页',
                firstPageTipText		: '首页',
                lastPageText			: '尾页',
                lastPageTipText			: '尾页',
                prePageText				: '上一页',
                prePageTipText			: '上一页',
                nextPageText			: '下一页',
                nextPageTipText			: '下一页',
                totalPageBeforeText		: '共',
                totalPageAfterText		: '页',
                currPageBeforeText		: '当前第',
                currPageAfterText		: '页',
                totalInfoSplitStr		: '/',
                totalRecordsBeforeText	: '共',
                totalRecordsAfterText	: "条数据",
                gopageBeforeText		: '&nbsp;转到',
                gopageButtonOkText		: '确定',
                gopageAfterText			: '页',
                buttonTipBeforeText		: '第',
                buttonTipAfterText		: '页'
            }*/

            //,
            //mode : 'click',//默认值是link，可选link或者click
            //click : function(n){
            //	this.selectPage(n);
            //  return false;
            //}
        });
    });

    function updata(obj) {
        var id = $(obj).parent().siblings().eq(0).text();
        var belong = $(obj).parent().siblings().eq(1).children().val();
        var merchantName = $(obj).parent().siblings().eq(2).children().val();
        var merchantForshort = $(obj).parent().siblings().eq(3).children().val();
        var contactName = $(obj).parent().siblings().eq(4).children().val();
        var phone = $(obj).parent().siblings().eq(5).children().val();
        var applicationDate = $(obj).parent().siblings().eq(6).children().val();
        var status = $(obj).parent().siblings().eq(7).children().val();
        var childMerchant = $(obj).parent().siblings().eq(8).children().val();
        var wechatMerchant = $(obj).parent().siblings().eq(9).children().val();
        var wechatRate = $(obj).parent().siblings().eq(10).children().val();
        var wechatRateDate = $(obj).parent().siblings().eq(11).children().val();
        var alipayId = $(obj).parent().siblings().eq(12).children().val();
        var alipayPid = $(obj).parent().siblings().eq(13).children().val();
        var alipayTheir = $(obj).parent().siblings().eq(14).children().val();
        var alipayRate = $(obj).parent().siblings().eq(15).children().val();
        var note = $(obj).parent().siblings().eq(16).children().val();
        const info = [belong, merchantName, merchantForshort, contactName, phone, applicationDate, status];
        for (let i = 0; i < info.length; i++) {
            if (info[i] === "" || info[i] === null) {
                return alert("请输入前七个必须信息，再进行修改");
            }
        }
        const parameter = "id=" + id + "&belong=" + belong + "&merchantName=" + merchantName + "&merchantForshort=" + merchantForshort + "&contactName=" + contactName + "&phone=" + phone + "&applicationDate=" + applicationDate + "&status=" + status + "&childMerchant=" + childMerchant + "&wechatMerchant=" + wechatMerchant + "&wechatRate=" + wechatRate + "&wechatRateDate=" + wechatRateDate + "&alipayId=" + alipayId + "&alipayPid=" + alipayPid + "&alipayTheir=" + alipayTheir + "&alipayRate=" + alipayRate + "&note=" + note;
        console.log("数据：" + parameter);
        if (confirm("确定修改吗？")) {
            $.ajax({
                url: "/update",
                data: parameter,
                type: "post",
                dataType: "text",
                success: function (info) {
                    alert(info);
                    window.location.href = "/index";
                }
            });
        } else {
            return false;
        }


    }


</script>
</html>

