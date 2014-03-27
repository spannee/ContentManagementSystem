<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/WEB-INF/tags/struts-html.tld" prefix="html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<head>
<script language="javascript">
function fun()
{
	document.getElementsByName("mode").value="viewProblemSolution";
	testForm.submit();
}
</script>
</head>
<%
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
response.setHeader("Pragma","no-cache"); //HTTP 1.0
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server

%>
<body onLoad="javascript:fun()">
<form action="/Integration_iSR/display.do" name="testForm" method="post">
<html:hidden property="mode" value="viewProblemSolution"/>
</form>
</body>
</html>