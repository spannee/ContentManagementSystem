
  	function callInsert(){
		var techName = document.getElementsByName('viewAndAddTechnologydto.technologyName')[0].value;
		var techNameLength = techName.length;
		var check = /^[a-zA-Z ]{1,30}$/;
		var firstChar = techName.charAt(0);
		var lastChar = techName.charAt(techNameLength-1);
				
		if(techName == ""){
			alert('Please Enter Technology Name');
			document.getElementsByName('viewAndAddTechnologydto.technologyName')[0].focus();
			return false;
		}else if(!check.test(techName)){
			alert("Please Enter Valid Technology Name");
			document.getElementsByName('viewAndAddTechnologydto.technologyName')[0].focus();
			return false;
		}else if(firstChar == " "){
			alert("Please Enter Valid Technology Name");
			document.getElementsByName('viewAndAddTechnologydto.technologyName')[0].focus();
			return false;
		}else if(lastChar == " "){
			alert("Please Enter Valid Technology Name");
			document.getElementsByName('viewAndAddTechnologydto.technologyName')[0].focus();
			return false;
		}else{
			document.getElementsByName("mode")[0].value="addTechnology";
			document.forms[0].submit();
		}		
  	}	