// JavaScript Document
$(document).ready(function(e) {
	$('#reginr').on('submit', function(e) {
		$.ajax({
			type: 'post',
			url: 'intrest.php',
			data: new FormData(this),
			processData: false,
			contentType: false,
			success: function(data) {
			if(data=="S"){
				$('#submit').css("background-color", "#4caf50");
		    	$('#submit').attr("disabled", "true");
				$('#email').attr("disabled", "true");
				$('#submit').prop("value", "Done!");	
			}else{alert("Something has gone wrong /n"+data);}
		}});
	e.preventDefault();	
	});
});