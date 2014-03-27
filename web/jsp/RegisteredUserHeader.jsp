


<%--  
 ***************************************************************************************
 * Description  :   Presentation Layer for iSolutions Repository
 * Functionality:	This is a Jsp, which will display the header for registered user
 * 
 * Models Used	:	
 
 * Restrictions:    			
 * Creation date:   6/12/10
 * Modifications:
 * Author:          		Date:          Change Description:
 *  subash			6/12/10	Initial Version
 ************************************************************************************** --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/tags/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tags/struts-html.tld" prefix="html"%> 
 
 <div id="links"></div>
    <div id="header">
      <div id="logo">
        <div id="logo_text">
          <!-- class="yellow", allows you to change the colour of the text - other classes are: "blue", "orange", "red", "purple" and "green" -->
          <h1><span class="alternate_colour">i</span>Solutions<span class="alternate_colour">Repository</span></h1>
        </div></div>
      <div id="menubar">
        <ul id="menu">
         <li><div><i><span class="alternate_colour">Hi
         <bean:write name="UserName"/>!</i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
	    
      </div></li> <!-- put class="tab_selected" in the li tag for the selected page - to highlight which page you're on -->
  <li><html:link page="/registeredUserNavigation.do?mode=home"><bean:message key="label.Home"/></html:link></li>
  <li><html:link page="/registeredUserNavigation.do?mode=addProblemSolution"><bean:message key="label.AddProblemSolution"/></html:link></li>
  <li><html:link page="/registeredUserNavigation.do?mode=viewProblemSolution"><bean:message key="label.ViewProblemSolution"/></html:link></li>
  <li><html:link page="/registeredUserNavigation.do?mode=logout"><bean:message key="label.Logout"/></html:link></li>
  </ul>
      </div>
    </div>