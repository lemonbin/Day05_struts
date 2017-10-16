<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: dllo
  Date: 2017/10/16
  Time: 上午10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工</title>

</head>
<body>
<h1>员工列表</h1>

部门:
<select id="depart" onchange="showPost(this)">
    <option value="-1">---请选择---</option>
    <%-- 遍历数据集合, 显示下拉条数 --%>
    <s:iterator value="departList" var="depart">
        <option value="${depart.id}">${depart.dname}</option>

    </s:iterator>

</select>

职务:
<select id="post">
    <option value="-1">---请选择---</option>

</select>
<script type="text/javascript">
    function createXMLHttpRequest() {
        try {
            return new XMLHttpRequest();
        } catch (e) {
            try {
                return new ActiveXObject("Msxml2.HTTP");
            } catch (e) {
                try {
                    return new ActiveXObject("Microsoft.HTTP");
                } catch (e) {
                    throw e;
                }
            }
        }
    }

    //根据部门选择状况, 发起职务查询请求
    function showPost(obj) {
        var departId = obj.value;

        //1.创建ajax请求对象
        var httpRequest = createXMLHttpRequest();

        var url="${pageContext.request.contextPath}/findPostsByPid2.action";
        //2.打开链接
        httpRequest.open("POST", url, true);

        //3.POST请求需要设置请求头
        httpRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

        //4.发起请求
        httpRequest.send("departId=" + departId);

        //5.设置请求响应的监听器
        httpRequest.onreadystatechange = function () {
            if (httpRequest.readyState == 4 && httpRequest.status == 200) {
                //6.成功响应 处理响应结果
                /* 6.1 将响应数据转换为json格式解析 */
                var jsonData = eval("(" + httpRequest.responseText + ")");

                /* 6.2 根据主键id 获得职务下拉列表对象 */
                var postSelect = document.getElementById("post");

                /* 6.3 添加请选择*/
                postSelect.innerHTML = "<option value='-1'>---请选择---</option>";

                /* 3.4 遍历json数据集合, 添加下拉选项 */
                for (var i = 0; i < jsonData.length; i++) {
                    var id = jsonData[i].id;
                    var pname = jsonData[i].pname;
                    postSelect.innerHTML += "<option value='" + id + "'>" + pname + "</option>";
                }

            }
        }
    }
</script>
</body>
</html>
