/**
 * 
 */
function checkBillingAddress() {
	if($("#theSameAsShippingAddress").is(":checked")){
		$(".billingAddress").prop("disabled", true);
	}else{
		$(".billingAddress").prop("disabled", false);
	}
}

function checkPasswordMatch(){
	var password=$("#txtNewPassword").val();
	var confirmPassword=$("#txtConfirmPassword").val();
	
	if(password == "" && confirmPassword==""){
		$("#checkPasswordMatch").html("empty");
		$("#updateUserInfoButton").prop('disabled',false);
	}else{
		if(password != confirmPassword){
			$("#checkPasswordMatch").html("passwords do not match!");
			$("#updateUserInfoButton").prop('disabled', true);
		}else{
			$("#checkPasswordMatch").html("passwords match");
			$("#updateUserInfoButton").prop('disabled', false);
		}
	}
}
$(document).ready(function() {
	$(".cartItemQty").on('change', function() {
		var id=this.id;
		$('#update-item-'+id).css('display', 'inline-block');
		$('#update-item-'+id).css('float', 'right');
	});
	
	$("#theSameAsShippingAddress").on('click', checkBillingAddress);
	
	$("#txtConfirmPassword").keyup(checkPasswordMatch);
	$("#txtNewPassword").keyup(checkPasswordMatch);
	
});