<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/23 0023
  Time: 下午 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>上传附件</h1>

<form method="post" action="/hello/upload.do" enctype="multipart/form-data">
    <input type="file" name="file"/><%--这里的file对应后台上传文件的MultipartFile file--%>
    <input type="submit" value="上传"/>
</form>
</body>
</html>
