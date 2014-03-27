
<%--  
 ***************************************************************************************
 * Description  :   Presentation Layer for iSolutions Repository
 * Functionality:	This is a Jsp, which will display the problem solutions to be added 
 * 
 * Models Used	:	
 
 * Restrictions:    			
 * Creation date:   6/12/10
 * Modifications:
 * Author:          		Date:          Change Description:
 *  Jawahar			6/12/10	Initial Version
 ************************************************************************************** --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<%@ taglib uri="/WEB-INF/tags/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tags/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*" %>
<%@ page import="com.igate.isr.dto.*" %>
<head>
  <title>AddProblemSolutionPage</title>
  <meta name="description" content="website description" />
  <meta name="keywords" content="website keywords, website keywords" />
  <meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
  <link rel="stylesheet" type="text/css" href="/Integration_iSR/web/css/style.css" />
	<script type="text/javascript" src="/Integration_iSR/web/js/AddProblemSolution.js">
	
	</script>
</head>
<%
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
response.setHeader("Pragma","no-cache"); //HTTP 1.0
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server

%>
<body>
  <div id="main">
   <jsp:include page="RegisteredUserHeader.jsp"></jsp:include>
      </div>
               
        <div id="site_content">
        <div class="form_settings">
         <h1>&nbsp;&nbsp;&nbsp;<span class="header_colour"><b>Add Problem-Solution</b> </span></h1>
         <html:errors/>
         <center><font color="#565051" face="verdana" size="5"><html:messages id="emptyTechList" property="emptyTechList" message="true">
         <bean:write name="emptyTechList"/>
         </html:messages></font>
         <font color="red" face="verdana" size="5"><html:messages id="connectionError" property="connectionError" message="true">
         <bean:write name="connectionError"/>
         </html:messages></font>
         <font color="red" face="verdana" size="5"><html:messages id="databaseError" property="databaseError" message="true">
         <bean:write name="databaseError"/>
         </html:messages ></font>
         <font color="red" face="verdana" size="5"><html:messages id="submitFailure" property="submitFailure" message="true">
         <bean:write name="submitFailure"/>
         </html:messages></font>
         <font color="green" face="verdana" size="5"><html:messages id="submitSuccess" property="submitSuccess" message="true">
         <bean:write name="submitSuccess"/>
         </html:messages></font></center>
                
        
        <html:form action="addProblemSolution.do">
                
	    <table align="center">
	    <tr>
	    <td><bean:message key="label.technology" /></td><td><html:select property="problemSolutionDto.techCode" >
		<html:option value="--Select--" />
		<html:optionsCollection name="addProblemSolutionForm" property="technologyList"/>
		</html:select></td></tr>
		
		<html:hidden property="mode" value="doAddProblemSolution"/>
		<tr>
        <td><bean:message key="label.problem" /></td><td><html:textarea property="problemSolutionDto.problem" cols="40" rows="6"></html:textarea></td></tr>
        <tr>
	    <td><bean:message key="label.solution" /></td><td><html:textarea property="problemSolutionDto.solution" cols="40" rows="6"></html:textarea></td></tr>
	    <tr>
	    <td><bean:message key="label.key" /></td><td><html:text property="problemSolutionDto.keyword" ></html:text></td></tr>
	    </table>
	    <center>
        <html:button styleClass="submit" property="btnSubmit" onclick="return addprobsol()"><bean:message key="label.Submit" /></html:button>
        </br>
        <bean:message key="label.symbol"/></center>
        </html:form>
        </br>
        </div>
       </div>
       
    <hr width="99%"></hr>
 <div id="footer">Copyright &copy; Group 7 & 8.| Mock Project | Using Struts | Designed by Group 7 & 8</div>

</body>
</html>
