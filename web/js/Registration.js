function load(){


var firstname=document.getElementsByName("registrationdto.firstName")[0].value;
var lastname=document.getElementsByName("registrationdto.lastName")[0].value;
var empid=document.getElementsByName("registrationdto.empID")[0].value;
var emailid=document.getElementsByName("registrationdto.emailid")[0].value;
var password=document.getElementsByName("registrationdto.password")[0].value;
var confirmpassword=document.getElementsByName("registrationdto.confirmPassword")[0].value;
var projectname=document.getElementsByName("registrationdto.projectName")[0].value;
if(firstname=="" && lastname=="" && empid=="" && emailid=="" && password=="" && confirmpassword=="" && projectname=="")
{
	alert("Please enter all the fields to register");
	document.getElementsByName('registrationdto.firstName')[0].focus();
	return false;
}
else if(firstname==""){
	
	alert("Please enter First name");
	document.getElementsByName('registrationdto.firstName')[0].focus();
	return false;
}
else if(lastname==""){
	
	alert("Please enter Last name");
	document.getElementsByName('registrationdto.lastName')[0].focus();
	return false;
}
else if(empid==""){
	
	alert("Please enter Employee ID");
	document.getElementsByName('registrationdto.empID')[0].focus();
	return false;
	
}
else if(emailid==""){
	alert("Please enter Email ID");
	document.getElementsByName('registrationdto.emailid')[0].focus();
	return false;
	
}
else if(password==""){
	
	alert("Please enter Password");
	document.getElementsByName('registrationdto.password')[0].focus();
	return false;
}
else if(confirmpassword==""){
	
	alert("Please enter Confirm Password");
	document.getElementsByName('registrationdto.confirmPassword')[0].focus();
	return false;
	
}
else if(projectname==""){
	
	alert("Please enter Project name");
	document.getElementsByName('registrationdto.projectName')[0].focus();
	return false;
}
else if(firstname.length>20){
	alert("First name should not exceed 20 characters");
	document.getElementsByName('registrationdto.firstName')[0].focus();
	return false;
}
else if(lastname.length>20){
	
	alert("Last name should not exceed 20 characters");
	document.getElementsByName('registrationdto.lastName')[0].focus();
	return false;
}
else if(empid.length!=6){
	
	
	alert("Employee ID should have 6 digits only");
	document.getElementsByName('registrationdto.empID')[0].focus();
	return false;
}

else if(password.length<8 || password.length>25){
 alert("Password should have minimum 8 characters and maximum 25 characters");
 document.getElementsByName('registrationdto.password')[0].focus();
 return false;
}
else if(projectname.length>30){
	 alert("Project name should not exceed 30 characters");
	 document.getElementsByName('registrationdto.password')[0].focus();
	 return false;
	}
else if(!isValidFirstName(firstname))
{
	alert("First name should contain only alphabets");
	document.getElementsByName('registrationdto.firstName')[0].focus();
	return false;
}
else if(!isValidLastName(lastname))
{
	alert("Last name should contain only alphabets");
	document.getElementsByName('registrationdto.lastName')[0].focus();
	return false;
}


else if(!isValidEmpID(empid))
{
	alert("Employee ID should have 6 digits only");
	document.getElementsByName('registrationdto.empID')[0].focus();
	return false;
}

else if(!isValidEmailid(emailid))
{
	alert("Invalid email ID");
	return false;
}
else if(!isValidPassword(password))
{
   alert("Password should contain alphabets and numbers only");
   return false;
}
else if(!isValidProjectName(projectname))
{
	alert("Project name should contain alphabets only");
	return false;
}

else if(!(confirmpassword==password)){

   alert("Password Mismatch");
   return false;
}

else

	document.forms[0].submit();


function isValidEmpID(empid)
{
	return /^\d{6}$/.test(empid);
}
function isValidFirstName(firstname)
{
	return /^[A-Za-z]+([A-Za-z '.]*)[A-Za-z]+$/.test(firstname);
}
function isValidLastName(lastname)
{
	return /^[A-Za-z]+([A-Za-z '.]*)[A-Za-z]+$/.test(lastname);
}
function isValidProjectName(projectname)
{   return /^[A-Za-z]+([A-Za-z '.]*)[A-Za-z]+$/.test(projectname);
}
function isValidPassword(password){

	  return /^[A-Za-z0-9]{8,25}$/.test(password);

}


function isValidEmailid(emailid){
return /^([a-zA-Z0-9_\.]+)@[a-z0-9]+(\.[a-z0-9]+)*(\.[a-z]{2,})$/.test(emailid);


}



}

	


