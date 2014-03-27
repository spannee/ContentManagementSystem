
<%--  
 ***************************************************************************************
 * Description  :   Presentation Layer for iSolutions Repository
 * Functionality:	This is a Jsp, which will display the login 
 * 
 * Models Used	:	
 
 * Restrictions:    			
 * Creation date:   6/12/10
 * Modifications:
 * Author:          		Date:          Change Description:
 * Amudhan			6/12/10	Initial Version
 ************************************************************************************** --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<%@ taglib uri="/WEB-INF/tags/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tags/struts-html.tld" prefix="html"%>


<head>
  <title>iSolutions Repository</title>
  <meta name="description" content="website description" />
  <meta name="keywords" content="website keywords, website keywords" />
  <meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
  <link rel="stylesheet" type="text/css" href="/Integration_iSR/web/css/style.css"/>
 <script type="text/javascript" src="/Integration_iSR/web/js/Login.js">
 
</script>

<script>
function setfocus(){
	document.getElementsByName('logindto.empID')[0].focus();
}

</script>
  
</head>
 <%
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
response.setHeader("Pragma","no-cache"); //HTTP 1.0
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server

%>
<body onload="setfocus()" >
  <div id="main">
   <jsp:include page="Header.jsp"></jsp:include>
 
    <div id="site_content">
      <div id="panel"><img src="/Integration_iSR/web/images/k3.jpg" alt="tree tops" /></div>
      <h1>&nbsp;&nbsp;&nbsp;&nbsp;<span class="header_colour"><b>Login to Continue</b></span></h1>
     
      <html:form action="/loadLogin.do" onsubmit="load()">
          <div class="form_settings">
          
	 <center>
	   <html:errors/>
	   <html:messages id="msg" message="true">
	    <font color="red" face="verdana" size="3"><b><bean:write name="msg"/></font></b>
       </html:messages>
	  
	    <p><span><bean:message key="label.Employeeid"/>
</span>&nbsp;<html:text  property="logindto.empID"></html:text></p>
	    <p><span><bean:message key="label.password"/></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<html:password property="logindto.password"></html:password></p>
         <html:hidden property="mode"  value="doLogin"/></br>
	     &nbsp;&nbsp;&nbsp;<html:submit styleClass="submit" property="submitbtn" onclick="return load()" ><bean:message key="label.Login" /></html:submit>
	     
	     <html:reset styleClass="submit"  onclick="doReset()"><bean:message key="label.Reset" /> 
</html:reset>
        <br></br>
           
        <bean:message key="label.symbol"/>   
	  </center>  
	  
            
	    
	             
	   
          </div>
        </html:form>
<br></br>  
<br></br>
 
 
</div>  
 
     <hr width="99%"></hr>
 <div id="footer">Copyright &copy; Group 7 & 8.| Mock Project | Using Struts | Designed by Group 7 & 8</div>

  </div>
 
</body>
</html>
      