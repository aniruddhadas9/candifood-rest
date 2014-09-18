<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title><s:property value="user.name"/><s:property value="user.email"/></title>
</head>
<body>
login=<a href="<s:property value="user.loginUrl"/>">Login</a><br>
logout=<a href="<s:property value="user.logoutUrl"/>">Login</a><br>
userId=<s:property value="user.iserId"/><br>
name=<s:property value="user.name"/><br>
email=<s:property value="user.email"/><br>
nickname=<s:property value="user.nickname"/><br>
authDomain=<s:property value="user.authDomain"/><br>
federatedIdentity=<s:property value="user.federatedIdentity"/><br>

<s:if test="user.name==null">
	<a href="<s:property value="user.loginUrl"/>">Login</a>
</s:if>
<s:elseif test="user.name!=null">
    Hey <s:property value="user.name"/> you can logout <a href="<s:property value="user.logoutUrl"/>">Here</a>
</s:elseif>
   
</body>
</html>