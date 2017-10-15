<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello</title>
</head>
<body>
	<h1>欢迎~</h1>
	<form action="upload2" enctype="multipart/form-data" method="post">
		<input type="file" name="img" value="选择图片" accept="image/jpeg,image/png,image/gif"/>
		<input type="submit" value="上传"/>
	</form>
</body>
</html>