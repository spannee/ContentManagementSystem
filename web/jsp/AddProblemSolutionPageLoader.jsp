<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/WEB-INF/tags/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tags/struts-bean.tld" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function loadAdd()
{	 
	document.getElementsByName("mode")[0].value="doLoadTechnology";
		 	 document.forms[0].submit(); 
}
</script>
</head>
<%
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
response.setHeader("Pragma","no-cache"); //HTTP 1.0
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server

%>
<body onLoad="javascript:loadAdd()">
<form action="/Integration_iSR/loadAddProblemSolutionPage.do" name="addProblemSolutionForm" method="post">
<html:hidden property="mode" value="doLoadTechnology"/>
</form>
</body>
</html>
