<%--
****************************************************************************************Description:PresentationLayerforiSolutionsRepository*Functionality:ThisisaJsp,whichwilldisplaytheDetailsoftechnology**ModelsUsed:*Restrictions:*Creationdate:6/12/10*Modifications:*Author:Date:ChangeDescription:*Santosh6/12/10InitialVersion**************************************************************************************--%><!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/WEB-INF/tags/struts-html.tld" prefix="html"%>
	<%@ taglib uri="/WEB-INF/tags/struts-bean.tld" prefix="bean"%>
	<%@ taglib uri="/WEB-INF/tags/struts-display.tld" prefix="display"%>
	<%@ taglib uri="/WEB-INF/tags/struts-logic.tld" prefix="logic"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
<head>
  <title>Add & View Technology</title>
  <meta name="description" content="website description" />
  <meta name="keywords" content="website keywords, website keywords" />
  <meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
  <link rel="stylesheet" type="text/css" href="/Integration_iSR/web/css/styleSubbu.css" />
  <script type="text/javascript" src="/Integration_iSR/web/js/Validator.js">
 	
  </script>
</head>
<%
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
response.setHeader("Pragma","no-cache"); //HTTP 1.0
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server

%>
<body onload="document.getElementsByName('viewAndAddTechnologydto.technologyName')[0].focus();">
<div id="main">
 <jsp:include page="AdminHeader.jsp"></jsp:include>
  </div>
 <h1>&nbsp;&nbsp;&nbsp;&nbsp;<span class="header_colour"><b>
View And Add technology </b></span></h1>
      
	<html:form action="add.do">
	<div id="site_content" style="text-align:center">
     
      </br>
		
		
		<html:errors/>
		<font color="red" face="verdana" size="5">
		<html:messages id="msgDBFailure" message="true" property="msgDBFailure">
 		<bean:write name="msgDBFailure"/>
 		</html:messages>
 		<html:messages id="msgViewFailure" message="true" property="msgViewFailure">
        <bean:write name="msgViewFailure"/>
        </html:messages>
        <html:messages id="msgFailure" message="true" property="msgFailure">
 		<bean:write name="msgFailure"/>
 		</html:messages>
 		<html:messages id="msgPKFailure" message="true" property="msgPKFailure">
 		<bean:write name="msgPKFailure"/>
 		</html:messages>
 		<html:messages id="msgInvalidTable" message="true" property="msgInvalidTable">
        <bean:write name="msgInvalidTable"/>
        </html:messages>
        <html:messages id="msgInvalidQuery" message="true" property="msgInvalidQuery">
        <bean:write name="msgInvalidQuery"/>
        </html:messages>
        </font>
        <font color="green" face="verdana" size="5">
        <html:messages id="msgSuccess" message="true" property="msgSuccess">
 	    <bean:write name="msgSuccess"/>
 	    </html:messages>
 		</font>

 		
		
        <center>
		<div class="form_settings">
		
		<bean:message key="label.technologyName"/> <html:text property="viewAndAddTechnologydto.technologyName" maxlength="30"></html:text>
 		<br></br>
		
		<html:button styleClass="submit" property="buttonAdd" onclick="return callInsert()"><bean:message key="label.AddTechnology" /></html:button>
		
		<html:hidden property="mode" value="addTechnology" /></div>
		</center>
	
		<br></br>
		
		<center>
		<display:table id="data" name="sessionScope.technologyList" requestURI="/display2.do"  pagesize="5" class="displayTable">  
		<tr>
		<td><display:column property="technologyCode" title="Technology Code" sortable="true" class="displayTable"/></td> 
		<td><display:column property="technologyName" title="Technology Name" sortable="true" class="displayTable"/> </td>
		<td><display:column property="dateAdded" title="Date Added" sortable="true" class="displayTable"/></td>
		</tr></display:table>
		</center>
		</div>
		
	</html:form>
	 <hr width="99%"></hr>
 <div id="footer">Copyright &copy; Group 7 & 8.| Mock Project | Using Struts | Designed by Group 7 & 8</div>


   
</body>
</html>
	
	
	