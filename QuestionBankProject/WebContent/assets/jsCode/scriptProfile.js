


$(document).ready(function() {
var mySelect = $('#first-disabled2');

$('#special').on('click', function() {
mySelect.find('option:selected').prop('disabled', true);
mySelect.selectpicker('refresh');
});

$('#special2').on('click', function() {
mySelect.find('option:disabled').prop('disabled', false);
mySelect.selectpicker('refresh');
});

$('#basic2').selectpicker({
liveSearch : true,
maxOptions : 1
});
});

function edit() {
	document.getElementById("edit-button").setAttribute('type', 'hidden');
	document.getElementById("name").disabled = false;
	document.getElementById("test-upload").disabled = false;
	document.getElementById("update-button").setAttribute('type', 'submit');
}


function readURL(input) {
	if (input.files && input.files[0]) {
		var reader = new FileReader();

		reader.onload = function(e) {
			$('#blah').attr('src', e.target.result).width(150).height(200);
		};

		reader.readAsDataURL(input.files[0]);
	}
}

function show() {
	var InvForm = document.forms.form;
	var SelBranchVal = "";
	var x = 0;
	for (x = 0; x < InvForm.relatedTag.length; x++) {
		if (InvForm.relatedTag[x].selected) {
			// alert(InvForm.tag[x].value);
			SelBranchVal = InvForm.relatedTag[x].value + "," + SelBranchVal;
		}
	}
	alert(SelBranchVal);
}
