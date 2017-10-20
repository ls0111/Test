<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>启木论坛登录界面</title>
<script type="text/javascript" src="../js/jquery-1.11.1.min.js"></script>
</head>
<body>
	<c:if test="${!empty error }">
		<font color="red"><c:out value="${error }"></c:out></font>
	</c:if>
	<form action="<c:url value="/loginCheck.html"/>" method="post">
		用户名： <input type="text" name="userName" /> <br> 密码： <input
			type="password" name="password" /> <br> <input type="submit"
			value="登录" /> <input type="reset" value="重置" />
	</form>
	---------------------------------------------------------------------------------------------<br>
	---------------------------------------------------------------------------------------------<br>
	---------------------------------------------------------------------------------------------<br>
	<form id="uploadForm" enctype="multipart/form-data" method="post">
		上传用户：<input type="text" name="username"><br/> 
		上传文件1：<input type="file" name="file1"><br/> 
		上传文件2：<input type="file" name="file2"><br/> 
		<input id="submit" type="submit" value="提交">
	</form>
	<script type="text/javascript">
		$("#submit").click(function(){
			var formData = new FormData($("#uploadForm")[0]);
			$.ajax({
				url:'${pageContext.request.contextPath}/upload/file',
				type:"POST",
				data:formData,
				async:false,
				cache:false,
				contentType:false,
				processData:false,
				success:function(returndata){
					alert(returndata);
				},
				error:function(returndata){
					alert(returndata);
				}
			});
		});
	</script>
</body>
</html>