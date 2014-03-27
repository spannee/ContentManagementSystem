function addprobsol()
	{
          document.getElementsByName('problemSolutionDto.techCode')[0].focus();
		  var techCode=document.getElementsByName('problemSolutionDto.techCode')[0].value;
		  
		  var problem=document.getElementsByName('problemSolutionDto.problem')[0].value;
		  var solution=document.getElementsByName('problemSolutionDto.solution')[0].value;
		  var keyword=document.getElementsByName('problemSolutionDto.keyword')[0].value;
		
		  var problemLength=document.getElementsByName('problemSolutionDto.problem')[0].value.length;
		  var solutionLength=document.getElementsByName('problemSolutionDto.solution')[0].value.length;
		  var keywordLength=document.getElementsByName('problemSolutionDto.keyword')[0].value.length;
		  var key="-";
		  var space=" ";
		  if(techCode=="--Select--")
		  {
		
			  alert('Please select a technology');
			  document.getElementsByName('problemSolutionDto.techCode')[0].focus();
			  return false;
		  }
		  else if(problem=="")
		  {
			
			 	 alert('Please enter a problem');
			 	  document.getElementsByName('problemSolutionDto.problem')[0].focus();
				  
				  return false;
			
		  }
		  else if(problemLength<5)
		  {
			
			 	 alert('Problem should contain minimum of 5 characters');
			 	  document.getElementsByName('problemSolutionDto.problem')[0].focus();
				  
				  return false;
			
		  }
		  else if(problemLength>500)
		  {
			
			 	 alert('Problem cannot exceed 500 characters');
			 	  document.getElementsByName('problemSolutionDto.problem')[0].focus();
				  
				  return false;
			
		  }
		  
		  else if(problem.substring(0,1)==" ")
		  {
				  alert('Problem should not start with spaces');
			  document.getElementsByName('problemSolutionDto.problem')[0].focus();
		    			return false;
	       }
		   else if(solution.substring(0,1)==space)
		  {
				  alert('Solution should not start with spaces.');
			  document.getElementsByName('problemSolutionDto.solution')[0].focus();
		    			return false;
	       }
		  else if(solution=="") 
		  {
		
			  alert('Please enter a solution');
			  document.getElementsByName('problemSolutionDto.solution')[0].focus();
			  
			  return false;
		  }
		  else if(solutionLength<5)
		  {
			
			 	 alert('Solution should contain minimum of 5 characters');
			 	  document.getElementsByName('problemSolutionDto.problem')[0].focus();
				  
				  return false;
			
		  }
		  else if(solutionLength>500)
		  {
			  alert('Solution cannot exceed 500 characters');
			  document.getElementsByName('problemSolutionDto.solution')[0].focus();
			  
			  return false;
		  }  
		  else if(keyword=="") 
		  {			
			  alert('Please enter a keyword');
			  document.getElementsByName('problemSolutionDto.keyword')[0].focus();
			 
			  return false;
		  }
		  
		  else if(keywordLength>20)
		  {
				
			  alert('Keyword cannot exceed 20 characters');
			  document.getElementsByName('problemSolutionDto.keyword')[0].focus();
			 
			  return false;
		  }
		  else if(keyword.substring(0,1)==key)
		  {
				  alert('Keyword can be alphabets and - as delimiter');
			  document.getElementsByName('problemSolutionDto.keyword')[0].focus();
		    			return false;
	       }
		  
		  else if(!isValidKeyword(keyword))
			  {
			 	 alert('Keyword can be alphabets and - as delimiter');
			 	document.getElementsByName('problemSolutionDto.keyword')[0].focus();
			    
				return false;
		  }
		 
		  else{
			  document.getElementsByName('btnSubmit')[0].focus();
				document.getElementsByName("mode")[0].value="doAddProblemSolution";
			  document.forms[0].submit();
		  }  
		  function isValidKeyword(keyword)
		  {
		  	return  /^[A-Za-z- ]{1,20}$/.test(keyword);
		  }	 
		 
		 
	}