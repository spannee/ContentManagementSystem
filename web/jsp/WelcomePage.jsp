
<%--  
 ***************************************************************************************
 * Description  :   Presentation Layer for iSolutions Repository
 * Functionality:	This is a Jsp, which will display the Welcome search page
 * 
 * Models Used	:	
 
 * Restrictions:    			
 * Creation date:   6/12/10
 * Modifications:
 * Author:          		Date:          Change Description:
 *  Subasri			6/12/10	Initial Version
 ************************************************************************************** --%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<%@ taglib uri="/WEB-INF/tags/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tags/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tags/struts-logic.tld" prefix="logic"%>

<head>
  <title>iSolutions Repository</title>
  <meta name="description" content="website description" />
  <meta name="keywords" content="website keywords, website keywords" />
  <meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
  <link rel="stylesheet" type="text/css" href="/Integration_iSR/web/css/style.css"/>
 <script type="text/javascript" src="/Integration_iSR/web/js/Validation.js"></script>

  
</head>
 <%
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
response.setHeader("Pragma","no-cache"); //HTTP 1.0
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server

%>
<body onload="document.getElementsByName('searchresultdto.keyword')[0].focus();">
  <div id="main">
    <logic:present scope="session"  name="UserName" >
  <jsp:include page="RegisteredUserHeader.jsp"></jsp:include>
  </logic:present>
  <logic:notPresent scope="session" name="UserName">
 <jsp:include page="GuestUserHeader.jsp"></jsp:include>
  </logic:notPresent>
   
   
    </div>
 
    <div id="site_content">
      <div id="panel"><img src="/Integration_iSR/web/images/k3.jpg" alt="tree tops" /></div>
     <div align ="center"> <html:errors/></div>
      <html:form action="searchSolution.do" onsubmit="searchvalidationfn()">
          <div class="form_settings">
          
     
          <div align ="center"><font color="#565051" face="verdana" size="5"><html:messages id="msgEmpty" message="true" property="msgEmpty"><bean:write name="msgEmpty"/></html:messages></font></div>
         <div align ="center"> <font color=red face="verdana" size="5"><html:messages id="msgConnect" message="true" property="msgConnect"><bean:write name="msgConnect"/></html:messages></font></div>
       <div align ="center"><font color="#565051" face="verdana" size="5"><b><bean:message key="LABEL_THEREARE"></bean:message>  <bean:write name="SearchpageForm" property="countDTO.solutionCount"></bean:write> <bean:message key="LABEL_SOLUTIONSFOR"></bean:message>  
		<bean:write name="SearchpageForm" property="countDTO.techCount"></bean:write> <bean:message key="LABEL_TECHNOLOGIES"></bean:message></b></font></div>
		  
		<br></br>
     
      
   
	      <div align ="center">
	           <bean:message key="LABEL_KEYWORD" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<html:text property="searchresultdto.keyword" maxlength="20"></html:text>
	      </div>
	       <br></br>
              <div align ="center">
              
	                <bean:message key="LABEL_TECHNAME" />
	                  <html:select property="searchresultdto.techCode">
				<html:option value="--Select--" />
				<html:optionsCollection name="SearchpageForm" property="technologyList"/>

			</html:select>
	   	    
	        </div>
	        
	        <br></br>
   <div align ="center">
            
            <html:hidden property="mode" value="searchSolution"/>
            <html:submit property="btnSubmit" styleClass="submit" onclick="return searchvalidationfn()" ><bean:message key="label.Search"/></html:submit>
  </div>
  
             
                        
	   
          </div>
        </html:form>
<br></br>  
<br></br>
 
 
</div>  
  <hr width="99%"></hr>
 <div id="footer">Copyright &copy; Group 7 & 8.| Mock Project | Using Struts | Designed by Group 7 & 8</div>


 
</body>
</html>
      
      
      
      
      
      
      
      
      
      
	