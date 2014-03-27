function load()
{    
	  var empid=document.getElementsByName('logindto.empID')[0].value;
	  var password=document.getElementsByName('logindto.password')[0].value;
	  
	  if(empid=="" && password=="")
	  {
		  alert('Please enter employeeId and password to login');
		  document.getElementsByName('logindto.empID')[0].focus();
		  return false;
	  }
	  else if(empid==""){
	      alert('Please enter employee ID');
	      document.getElementsByName('logindto.empID')[0].focus();
	      return false;
		  }
	  else if(password==""){
	        alert('Please enter password');
	        document.getElementsByName('logindto.password')[0].focus();
	        return false;
	  }
	  else if(empid.length!=6){

		    alert("Invalid Employee ID and Password");
		    document.getElementsByName('logindto.empID')[0].focus();
		    return false;
		  }
	  else if(password.length<8 || password.length>25)
	  {
	       alert('Invalid Employee ID and Password');
	       document.getElementsByName('logindto.password')[0].focus();
	       return false;
	  }
	  else if(!isValidEmpID(empid))
		{
			alert("Invalid Employee ID and Password");
			document.getElementsByName('logindto.empID')[0].focus();
			return false;
		}
	  else if(!isValidPassword(password)){
		     alert("Invalid Employee ID and Password");
		     document.getElementsByName('logindto.empID')[0].focus();
			return false;
	  }
		else
			 document.forms[0].submit();

	  function isValidEmpID(empid)
	  {
	  	return /^\d{6}$/.test(empid);
	  }
	  function isValidPassword(password)
	  {
	  	return  /^[A-Za-z\d]{8,25}$/.test(password);
	  }
		
	}
function doReset(){
	window.location="/Integration_iSR/web/jsp/Login.jsp";
}

	

	