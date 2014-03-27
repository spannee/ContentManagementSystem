function validateFields()
{
	var keyword=document.getElementsByName("searchresultdto.keyword")[0].value;


	var technology=document.getElementsByName("searchresultdto.techCode")[0].value;
	
	if(keyword=="" && technology=="--Select--")
	{
		 alert('Please specify keyword or technology ');
		 return false;
	}
	else if(technology=="--Select--")
	{
		if(keyword.length>20)
		    {
		 		alert('Keyword cannot exceed 20 characters');
		 		document.getElementsByName("searchresultdto.keyword")[0].focus();
		 		return false;
		 	 
		    }
		if(!isValidKeyword(keyword))
			{
				alert('Keyword can contain only alphabets');
				document.getElementsByName("searchresultdto.keyword")[0].focus();
				return false;
			}	
	 
	}

		document.getElementsByName("mode")[0].value="doLoadSearchDetails";
		document.forms[0].submit();
		

	function isValidKeyword(keyword)
	{
		return /^[A-Za-z ]{1,20}$/.test(keyword);
	}
}
