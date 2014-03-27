
<%--  
 ***************************************************************************************
 * Description  :   Presentation Layer for iSolutions Repository
 * Functionality:	This is a Jsp, which will display problem and solutions to be approved by admin 
 * 
 * Models Used	:	
 
 * Restrictions:    			
 * Creation date:   6/12/10
 * Modifications:
 * Author:          		Date:          Change Description:
 *  Rushmitha			6/12/10	Initial Version
 ************************************************************************************** --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<%@ taglib uri="/WEB-INF/tags/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tags/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tags/struts-html.tld" prefix="html" %>

<%@ taglib uri="/WEB-INF/tags/struts-display.tld" prefix="display"%>
<head>
<title>Solution Approval</title>
<meta name="description" content="website description" />
<meta name="keywords" content="website keywords, website keywords" />
<meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
<link rel="stylesheet" type="text/css" href="/Integration_iSR/web/css/styleSolApp.css" />
<script type="text/javascript" src="/Integration_iSR/web/js/SolutionApproval.js"></script>
</head>
<%
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
response.setHeader("Pragma","no-cache"); //HTTP 1.0
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server

%>
<html:html>
<body>
<div id="main">
<jsp:include page="AdminHeader.jsp"></jsp:include>
</div>
 <h1>&nbsp;&nbsp;&nbsp;&nbsp;<span class="header_colour"><b>Solution Approval</b></span></h1>
 <div id="site_content" style="text-align: center">    
<html:form action="isr.do">


<center>
	 <font color="red" face="verdana" size="5"><html:messages id="messagesError" message="true" property="messagesError">
	  <b> <bean:write name="messagesError"/></b>
       </html:messages></font>
       <font color="#565051" face="verdana" size="5"><html:messages id="messagesResult" message="true" property="messagesResult">
	  <b> <bean:write name="messagesResult"/></b>
       </html:messages></font>
       <font color="green" face="verdana" size="5"> <html:messages id="messagesSuccess" message="true" property="messagesSuccess">
	  <b> <bean:write name="messagesSuccess"/></b>
       </html:messages></font></center>

	<logic:notEmpty name="submittedSolutions" scope="session"><center>
	<display:table id="data" name="sessionScope.submittedSolutions" length="500"  pagesize="2" style="width:90%" decorator="com.igate.isr.decorator.SolutionApprovalDecorator" class="displayTable">
		<tr><td><display:column property="problemId" title="<input type='checkbox' name='selectall' onclick='javascript:selectAll()' /> SelectAll"></display:column></td>
			<td><display:column property="empName" title="EmpName" sortable="true" class="displayTable"></display:column></td>
			<td><display:column property="empId" title="EmpId" sortable="true" class="displayTable"></display:column></td>
			<td><display:column property="technologyName" title="Technology" sortable="true" class="displayTable"></display:column></td>
			<td><display:column property="problem" title="Problem" sortable="true" class="displayTable"></display:column></td>
			<td><display:column property="solution" title="Solution" sortable="true" class="displayTable"></display:column></td>
			</tr>
	</display:table></center>
    <div class="form_settings">
	<center><html:button  styleClass="submit" onclick="javascript:approve()" property="approvebtn"><bean:message key="label.Approve" /></html:button>
	<html:button styleClass="submit"  onclick="javascript:reject()" property="rejectbtn"><bean:message key="label.Reject" /></html:button></center>
    <html:hidden property="check" value="1"/>
	<html:hidden property="mode" value="updateSolutionStatus"/>
    </div>	
	
	</logic:notEmpty>
	
       
</html:form>
</div>
<br></br>
<hr width="99%"></hr>
 <div id="footer">Copyright &copy; Group 7 & 8. All Rights Reserved.| Mock Project | Using Struts | Designed by Group 7 & 8</div>


</body>
</html:html>
</html>
