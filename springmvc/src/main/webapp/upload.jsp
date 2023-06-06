<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/user/quick20" method="post" enctype="multipart/form-data">
        <div>
            <label for="username">名称</label>
            <input type="text" id="username" name="username">
        </div>
        <div>
            <label for="file">文件</label>
            <input type="file" id="file" name="file">
        </div>
        <div>
            <input type="submit" value="提交">
        </div>
    </form>
    <form action="${pageContext.request.contextPath}/user/quick21" method="post" enctype="multipart/form-data">
        <div>
            <label for="username">名称</label>
            <input type="text" id="username1" name="username">
        </div>
        <div>
            <label for="file">文件</label>
            <input type="file" multiple id="file1" name="files">
        </div>
        <div>
            <input type="submit" value="提交">
        </div>
    </form>
</body>
</html>
