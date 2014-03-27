<html>
<head>
<script type="text/javascript">
function fun()
{     
	 document.forms[0].submit();
}
</script>
</head>
<%
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
response.setHeader("Pragma","no-cache"); //HTTP 1.0
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server

%>
<body onload="fun()">
<form action="/Integration_iSR/displaysearch.do" name="SearchpageForm" method="post">
<input type="hidden" value="doLoadTechnology" name="mode">
</form>
</body>
</html>