function searchvalidationfn()
{
	//document.getElementsByName('searchpagedto.keyword')[0].focus();
    var key=document.getElementsByName("searchresultdto.keyword")[0].value;
    var technology=document.getElementsByName("searchresultdto.techCode")[0].value;

    if(key=="" && technology=="--Select--")
     {
	  alert('Please specify keyword or technology ');
	  return false;
}
else if(technology=="--Select--")
{
 
	if(key.length>20)
	  {
	 		alert('Keyword cannot exceed 20 characters');
	 		document.getElementsByName("searchresultdto.keyword")[0].focus();
	 		return false;
	 	 
	 }
  
	else if(!isValidKeyword(key))
      {
  	alert('Keyword can contain only alphabets');
  	document.getElementsByName("searchresultdto.keyword")[0].focus();
  	return false;
  }	
	
  
  
}

else
	{
	     document.getElementsByName("mode")[0].value="searchSolution"    
         document.forms[0].submit(); 
         
	}
function isValidKeyword(key)
{
	
return /^[A-Za-z ]{1,20}$/.test(key);
}
}










