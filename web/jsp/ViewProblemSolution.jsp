
<%--  
 ***************************************************************************************
 * Description  :   Presentation Layer for iSolutions Repository
 * Functionality:	This is a Jsp, which will display the problem solutions
 * 
 * Models Used	:	
 
 * Restrictions:    			
 * Creation date:   6/12/10
 * Modifications:
 * Author:          		Date:          Change Description:
 *  chaitanya			6/12/10	Initial Version
 ************************************************************************************** --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<%@ taglib uri="/WEB-INF/tags/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tags/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tags/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tags/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/tags/displaytag-12.tld" prefix="display"%>

<head>
<title>ViewProblemSolution</title>
<meta name="description" content="website description" />
<meta name="keywords" content="website keywords, website keywords" />
<meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
<link rel="stylesheet" type="text/css"
	href="/Integration_iSR/web/css/style.css" />
	

</head>
<%
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
response.setHeader("Pragma","no-cache"); //HTTP 1.0
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server

%>
<body >
<div id="main"><jsp:include page="RegisteredUserHeader.jsp"></jsp:include>
</div>
<h1>&nbsp;&nbsp;&nbsp;&nbsp;<span class="header_colour"><b>Problem-Solutions Submitted</b> </span></h1>
<form action="/Integration_iSR/display.do"  method="post">




<logic:messagesPresent message="true">
    <font color="#565051" face="verdana" size="5">
	<html:messages id="messagesresult" message="true" property="messagesresult">
	<bean:write name="messagesresult" /></html:messages></font>
	<font color="red" face="verdana" size="5">
	<html:messages id="messageserror" message="true" property="messageserror">
	<bean:write name="messageserror" /></html:messages></font>
</logic:messagesPresent>
	
	
      

<center><logic:notEmpty name="viewdetails" scope="session" >
	<display:table id="data" name="sessionScope.viewdetails" length="500"
		pagesize="3" style="width:90%" decorator="com.igate.isr.decorator.ViewProblemSolutionDecorator" class="displayTable">
		<tr>
			<td><display:column property="addedDate" title="Added Date" sortable="true" class="displayTable"></display:column></td>
			<td><display:column property="problemStatement"
				title="Problem Statement" sortable="true" class="displayTable"></display:column></td>
			<td><display:column property="solution" title="Solution" sortable="true" class="displayTable"></display:column></td>
			<td><display:column property="status" title="Status" sortable="true" class="displayTable"></display:column></td>
			<td><display:column property="verifiedDate"
				title="Verified Date" sortable="true" class="displayTable"></display:column></td>

		</tr>
		

	</display:table>
</logic:notEmpty></center>
<html:hidden property="mode" value="viewProblemSolution"/>

</form>
<hr width="99%"></hr>
 <div id="footer">Copyright &copy; Group 7 & 8.| Mock Project | Using Struts | Designed by Group 7 & 8</div>

</body>
</html>
