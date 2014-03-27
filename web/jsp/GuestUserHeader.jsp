
<%--  
 ***************************************************************************************
 * Description  :   Presentation Layer for iSolutions Repository
 * Functionality:	This is a Jsp, which will display the header for guest user 
 * 
 * Models Used	:	
 
 * Restrictions:    			
 * Creation date:   6/12/10
 * Modifications:
 * Author:          		Date:          Change Description:
 *  Subash			6/12/10	Initial Version
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
        </div>
      </div>
      <div id="menubar">
        <ul id="menu">
          <!-- put class="tab_selected" in the li tag for the selected page - to highlight which page you're on -->
  <li><html:link page="/guestUserNavigation.do?mode=signin"><bean:message key="label.SignIn"/></html:link></li>
   <li><html:link page="/guestUserNavigation.do?mode=signup"><bean:message key="label.SignUp"/></html:link></li>
  
  </ul>
      </div>
    </div>
      
      
      
      
      
      
	
      
      
      
      
      
      
      
      
	