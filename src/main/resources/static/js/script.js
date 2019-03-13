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
$(document).ready(function() {
	$(".cartItemQty").on('change', function() {
		var id=this.id;
		$('#update-item-'+id).css('display', 'inline-block');
		$('#update-item-'+id).css('float', 'right');
	});
	
	$("#theSameAsShippingAddress").on('click', checkBillingAddress);
});