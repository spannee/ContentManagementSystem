<%--  
 ***************************************************************************************
 * Description  :   Presentation Layer for iSolutions Repository
 * Functionality:	This is a Jsp, which will display the search results
 * 
 * Models Used	:	
 
 * Restrictions:    			
 * Creation date:   6/12/10
 * Modifications:
 * Author:          		Date:          Change Description:
 *  Buddha			6/12/10	Initial Version
 ************************************************************************************** --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/tags/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tags/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tags/struts-display.tld" prefix="display"%>
<%@ taglib uri="/WEB-INF/tags/struts-logic.tld" prefix="logic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
  <title>iSolutions Repository</title>
  <meta name="description" content="website description" />
  <meta name="keywords" content="website keywords, website keywords" />
  <meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
  <link rel="stylesheet" type="text/css" href="/Integration_iSR/web/css/style.css"/>
 <script type="text/javascript" src="/Integration_iSR/web/js/SearchResultValidation.js"></script>

  
</head>
 
<%
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
response.setHeader("Pragma","no-cache"); //HTTP 1.0
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server

%>
<body onload="document.getElementsByName('searchresultDto.keyword')[0].focus()">

<div id="main">
   <logic:present scope="session"  name="UserName" >
  <jsp:include page="RegisteredUserHeader.jsp"></jsp:include>
  </logic:present>
  <logic:notPresent scope="session" name="UserName">
  <jsp:include page="GuestUserHeader.jsp"></jsp:include>
  </logic:notPresent>
   
   
    </div>
    <div id="site_content" style="text-align:center">
   
    <html:form action="result.do" onsubmit="validateFields()">
    	 <div class="form_settings">    	
	     <center>
	       
	       <p><span><bean:message key="LABEL_KEYWORD" /></span>
		   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<html:text property="searchresultdto.keyword" maxlength="20"></html:text></p>
		   
		   <p><span><bean:message key="LABEL_TECHNAME" /></span>
		   <html:select property="searchresultdto.techCode">
				<html:option value="--Select--" />
				<html:optionsCollection name="SearchpageForm" property="technologyList" />
			    </html:select></p></br>
	         	
	         <html:submit styleClass="submit" property="buttonName" onclick="return validateFields()"><bean:message key="label.Search" /></html:submit>
	      </center>
             <html:hidden property="mode" value="doLoadTechnology" />
  		</div>
  		</html:form></br>
  		</div> 


<hr></hr>
</br>
<center>
		<logic:messagesPresent message="true">
    	<html:messages id="msg" message="true"><font color="#565051" face="verdana" size="5"><bean:write name="msg"></bean:write></font></html:messages>
    	</logic:messagesPresent>
		</br>
		<logic:notEmpty name="searchdetailsList" scope="session">
		<display:table id="searchdetails" name="sessionScope.searchdetailsList" pagesize="2" decorator="com.igate.isr.decorator.SearchResultDecorator" class="displayTable">
		<tr>  
		<td><display:column property="techName" title="Technology Name" sortable="true" class="displayTable"/></td> 
		<td><display:column property="problem" title="Problem Statement" sortable="true" class="displayTable"/></td> 
		<td><display:column property="solution" title="Solution" sortable="true" class="displayTable"/></td>
		</tr> 
		</display:table>
		</logic:notEmpty>
</center>
</br>
	
 <hr></hr>
 <div id="footer">Copyright &copy; Group 7 & 8.| Mock Project | Using Struts | Designed by Group 7 & 8</div>

 

</body>
</html:html>