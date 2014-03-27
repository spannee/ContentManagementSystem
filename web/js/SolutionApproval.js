function approve() {

	TotSelected = 0;
	TotRecords = document.getElementsByName("selectedProblemId");
	size = TotRecords.length;
	for (count = 0; count < size; count++) {
		if (TotRecords[count].checked == true) {

			TotSelected = TotSelected + 1;
		}
	}
	if (TotSelected == 0) {
		alert("Select atleast one record");
	} else {
		document.getElementsByName("check")[0].value = "1";
		document.getElementsByName("mode")[0].value = "updateSolutionStatus";
		testForm2.submit();
	}
}
function reject() {

	TotalSelected = 0;
	TotalRecords = document.getElementsByName("selectedProblemId");
	size = TotalRecords.length;
	for (count = 0; count < size; count++) {
		if (TotalRecords[count].checked == true) {

			TotalSelected = TotalSelected + 1;
		}
	}
	if (TotalSelected == 0) {
		alert("Select atleast one record");
	} else {
		document.getElementsByName("check")[0].value = "0";
		document.getElementsByName("mode")[0].value = "updateSolutionStatus";
		testForm2.submit();

	}
}
function selectAll() {

	TotRecords = document.getElementsByName("selectedProblemId");
	size = TotRecords.length;
	if (document.getElementsByName("selectall")[0].checked == true) {

		for (count = 0; count < size; count++) {
			TotRecords[count].checked = true;
		}
	} else {
		for (count = 0; count < size; count++) {
			TotRecords[count].checked = false;
		}
	}

}