
<%--  
 ***************************************************************************************
 * Description  :   Presentation Layer for iSolutions Repository
 * Functionality:	This is a Jsp, which will display the registration details
 * 
 * Models Used	:	
 
 * Restrictions:    			
 * Creation date:   6/12/10
 * Modifications:
 * Author:          		Date:          Change Description:
 *  Amudhan			6/12/10	Initial Version
 ************************************************************************************** --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<%@ taglib uri="/WEB-INF/tags/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tags/struts-html.tld" prefix="html"%>

<head>
<title>Sign Up</title>
<meta name="description" content="website description" />
<meta name="keywords" content="website keywords, website keywords" />
<meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
<link rel="stylesheet" type="text/css"
	href="/Integration_iSR/web/css/style.css" />
<script language="javascript" src="/Integration_iSR/web/js/Registration.js">

</script>
<script>
function setfocus(){
document.getElementsByName('registrationdto.firstName')[0].focus();

}
function Cancel()
{

	var message=confirm("Do you want to continue ?");
	if (message)
	{

		//document.getElementById("mode").value="doLoadProjects";
		//document.forms[0].submit();
		window.location.href="/Integration_iSR/web/jsp/MainPage.jsp";
	}
	else
	{
		//window.location="\Project_Tracker_1\web\JSP\editProject.jsp"
		//alert("hello world");

	}
	
}

</script>
</head>
<%
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
response.setHeader("Pragma","no-cache"); //HTTP 1.0
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server

%>
<body onload="setfocus()">
<div id="main">

<div id="links"></div>
<div id="header">
<div id="logo">
<div id="logo_text"><!-- class="yellow", allows you to change the colour of the text - other classes are: "blue", "orange", "red", "purple" and "green" -->
<h1><span class="alternate_colour">i</span>Solutions<span
	class="alternate_colour">Repository</span></h1>
</div>
</div>
<div id="menubar">
<ul id="menu">
	<!-- put class="tab_selected" in the li tag for the selected page - to highlight which page you're on -->

	<li><html:link page="/web/jsp/Registration.jsp">Sign Up</html:link></li>
</ul>
</div>
</div>
</div>
<div id="site_content">
<div class="form_settings">
<h1>&nbsp;&nbsp;&nbsp;<span class="header_colour"><b>User Registration</b> </span></h1>
<html:form action="/register.do">

	<center> <html:errors/> <html:messages
		id="msg" message="true">
		<font color="red" face="verdana" size="5"><b><bean:write name="msg" /></font>
		</b>
	</html:messages></center>
<table align="center">
	<tr><td><bean:message key="label.FirstName" /> </td>
	<td><html:text property="registrationdto.firstName" maxlength="30"></html:text></td></tr>

	<tr><td><bean:message key="label.LastName" /></td>
	<td> <html:text property="registrationdto.lastName" maxlength="30"></html:text></td></tr>


	<tr><td><bean:message key="label.Employeeid" /></td>
	<td> <html:text property="registrationdto.empID" maxlength="10"></html:text></td></tr>

	<tr><td><bean:message key="label.Emailid" /></td>
	<td>  <html:text property="registrationdto.emailid" maxlength="50"></html:text></td></tr>

	<tr><td><bean:message key="label.Password" /></td><td>
	<html:password property="registrationdto.password" maxlength="30"></html:password></td></tr>

	<tr><td><bean:message key="label.ConfirmPassword" /> </td>
	<td><html:password property="registrationdto.confirmPassword" maxlength="30"></html:password></td></tr>

	<tr><td><bean:message key="label.ProjectName" /></td><td><html:text
		property="registrationdto.projectName" maxlength="40"></html:text></td></tr>
	</table>
	
	<html:hidden property="mode" value="registerEmployee" /> 
	<center><html:button styleClass="submit" property="submitbtn" onclick="return load()"><bean:message key="label.Register" /></html:button>
		 
	<html:button styleClass="submit"  onclick="return Cancel()" property="btnName"><bean:message key="label.Cancel" /></html:button>

	<br></br>
	<bean:message key="label.symbol"/>
	</br>
    <bean:message key="label.condition"/></center>
    </br>
   
</html:form>
</div>
</div>
 <hr width="99%"></hr>
 <div id="footer">Copyright &copy; Group 7 & 8.| Mock Project | Using Struts | Designed by Group 7 & 8</div>

</body>
</html>
