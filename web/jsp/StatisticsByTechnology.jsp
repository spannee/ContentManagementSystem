
<%--  
 ***************************************************************************************
 * Description  :   Presentation Layer for iSolutions Repository
 * Functionality:	This is a Jsp, which will display the Statistics By tech
 * 
 * Models Used	:	
 
 * Restrictions:    			
 * Creation date:   6/12/10
 * Modifications:
 * Author:          		Date:          Change Description:
 *  supriya			6/12/10	Initial Version
 ************************************************************************************** --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<%@taglib uri="/WEB-INF/tags/struts-html.tld" prefix="html"%>
 <%@taglib uri="/WEB-INF/tags/struts-bean.tld" prefix="bean"%>
 <%@taglib uri="/WEB-INF/tags/struts-logic.tld" prefix="logic"%>
 <%@taglib uri="/WEB-INF/tags/struts-display.tld" prefix="display"%>

<head>
  <title>Statistics by Tech</title>
  <meta name="description" content="website description" />
  <meta name="keywords" content="website keywords, website keywords" />
  <meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
  <link rel="stylesheet" type="text/css" href="/Integration_iSR/web/css/styleSubbu.css" />
  <script>

</script>
</head>
<%
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
response.setHeader("Pragma","no-cache"); //HTTP 1.0
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server

%>
<body >


  <div id="main">
    <jsp:include page="AdminHeader.jsp"></jsp:include>
    </div>
    <h1>&nbsp;&nbsp;&nbsp;&nbsp;<span class="header_colour"><b> Statistics of Problem-Solutions submitted in Technologies available </b></span></h1>
    
     
    <html:form action="display1.do">
    <div id="site_content" style="text-align:center">
    <font color="red" face="verdana" size="5">
     <html:messages id="msgfailure" message="true" property="msgfailure">
      <bean:write name="msgfailure" />
      </html:messages></font>
      <font color="#565051" face="verdana" size="5">
     <html:messages id="msgresult" message="true" property="msgresult">
      <bean:write name="msgresult" />
      </html:messages></font>
    <logic:notEmpty name="Stats"  scope="session">
	<center><display:table id="data" name="sessionScope.Stats"  pagesize="5" style="width:80%" class="displayTable">
		<tr>
			<td><display:column property="techName" title="Technology Name" sortable="true" class="displayTable"></display:column></td>
			<td><display:column property="submitted" title="Total Submitted" sortable="true" class="displayTable"></display:column></td>
			<td><display:column property="appr" title="Approved" sortable="true" class="displayTable"></display:column></td>
			<td><display:column property="rej" title="Rejected" sortable="true" class="displayTable"></display:column></td>
			
			
	   </tr>
	</display:table></center>
   </logic:notEmpty>
    <html:hidden property="mode" value="doLoadTechnologyStatistics" />

  </div>
  </html:form>
  <hr width="99%"></hr>
 <div id="footer">Copyright &copy; Group 7 & 8.| Mock Project | Using Struts | Designed by Group 7 & 8</div>


</body>
</html>
