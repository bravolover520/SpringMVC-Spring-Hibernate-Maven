<html>
<head>
<meta charset="UTF-8">
<title>Maven整合Spring+SpringMVC+Hibernate+FreeMarker框架</title>
</title>
</head>
<body>
<h1>用户登录</h1>
	<form method="post" action="register">
		<input type="text" name="username" placeholder="用户名" value="${username?if_exists}" /><br />
		<input type="password" name="password" placeholder="密码" value="${password?if_exists}"/><br />
		<button>登录</button>
	</form>
	${error?if_exists}
</body>
</html> 