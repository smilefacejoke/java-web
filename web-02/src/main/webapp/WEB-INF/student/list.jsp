<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 54350
  Date: 2021/11/2
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<html>
<head>
    <title>列表学生</title>
    <script src="webjars/jquery/3.6.0/dist/jquery.min.js"></script>
    <link rel="stylesheet" href="webjars/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="webjars/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <style>
        .table{
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <div class="panel-title">
                <h3>学生列表</h3>
            </div>
        </div>
        <table class="table table-hover table-striped">
            <tr>
                <td>学号</td>
                <td>姓名</td>
                <td>性别</td>
                <td>年龄</td>
                <td>住址</td>
                <td>所在班级</td>
                <td>操作</td>
            </tr>
            <c:forEach items="${students}" var="st">
                <tr>
                    <td>${st.sid}</td>
                    <td>${st.name}</td>
                    <td>${st.sex}</td>
                    <td>${st.age}</td>
                    <td>${st.addr}</td>
                    <td>${st.cname}</td>
                    <td>
                        <a href="" class="btn btn-success btn-sm" onclick="updateUI(${st.sid},'${st.name}','${st.sex}',${st.age},'${st.addr}',${st.cid})" data-toggle="modal" data-target="#myModal">修改</a>
                        <a href="" class="btn btn-danger btn-sm" onclick="delStudent(${st.sid})">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <div class="panel-footer text-right">
            <a href="" class="btn btn-info btn-sm" data-toggle="modal" data-target="#myModal" onclick="addStudent()">添加学生</a>
        </div>
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myTitle">添加学生</h4>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal" method="post">
                            <input type="hidden" name="sid" id="sid" value="${student.sid}">
                            <div class="form-group">
                                <label for="name" class="col-sm-2 control-label">学生姓名</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="name" name="name" placeholder="姓名">
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-2 control-label">性别:</label>
                                <div class="col-sm-10">
                                    <div class="radio">
                                        <label>
                                            <input type="radio" name="sex" id="sex1" value="男" checked>男
                                        </label>
                                        <label>
                                            <input type="radio" name="sex" id="sex2" value="女" >女
                                        </label>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="age" class="col-sm-2 control-label">学生年龄</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="age" name="age" placeholder="请输入年龄">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="addr" class="col-sm-2 control-label">学生住址</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="addr" name="addr" placeholder="请输入地址">
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-2 control-label">所在班级:</label>
                                <div class="col-sm-10">
                                    <select class="form-control" name="cid" id="cid">
                                        <c:forEach items="${classes}" var="c">
                                            <option value="${c.cid}">${c.cname}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="button" class="btn btn-primary" onclick="save()">保存 </button>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>
</body>
</html>

<script>
    //1.保存学生
    function save() {
        //1.1根据表单隐藏域，决定是添加还是修改
        let sid=$("#sid").val();
        //1.2定义action定址
        let url=""
        if(sid){
            //修改
            url="/student?cmd=update"
        }else {
            //添加
            url="/student?cmd=add"
        }
        //1.3为表单的action属性赋值
        document.forms[0].action=url;
        //1.4提交表单
        document.forms[0].submit();
    }
    //2.添加学生界面
    function addStudent() {
        //2.1修改标题
        $("#myTitle").html("添加学生");
        //2.2重置表单
         document.forms[0].reset();

    }

    //3.修改学生界面
    function updateUI(sid,name,sex,age,addr,cid) {
        //3.1
        if(sid) {
            //修改对话框标题
            $("#myTitle").html("修改学生");
        }
        //3.2显示当前修改的数据(为表单赋值）
        $("#sid").val(sid);
        $("#name").val(name);
        $("#age").val(age);
        $("#addr").val(addr);
        $("#cid").val(cid);
        if(sex=='男'){
            $('#sex1').prop("checked",true);
        };
        if(sex=='女'){
            $('#sex2').prop("checked",true);
        }
        //3.4为表单隐藏域sid赋值
        $("sid").val(sid);
    }

    //4.删除学生信息
    function delStudent(sid){
        console.log("sid:",sid);
        if(confirm("你真的要删除吗?")){
            location.href = "/student?cmd=delete&sid="+sid;
        }
    }
</script>
