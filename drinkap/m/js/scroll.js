// JavaScript Document
state=0;
phone_left=0
$(window).scroll(function () {
  if ( $(this).scrollTop() > 300 && !$('.phone').hasClass('open') ) {
		  $('.phone').animate({
    		opacity: 1,
    		left: phone_left+'%'},200);
			$('.body').animate({
    		opacity: 1,
    		left: "1%"},200);
			//Play Button
			$("#bottom").fadeOut();
    $('.phone').addClass('open');
   } else if ( $(this).scrollTop() <= 200 ) {
    $('.phone').removeClass('open');
	$('.phone').animate({
    opacity: 0,
    left: "-45%"},200);
	
	$('.body').animate({
    opacity: 0,
    right: "-100%"},200);
	//Play Button
			$("#bottom").fadeIn();}
});
$(document).ready(updatePointer);
$(window).resize(updatePointer);

function updatePointer() {
	$('.phone').height($('.container').width()*1.61166819);
	
	}
//States

function next (){
	switch (state){
		case 0:
		$('#drink1').animate({
    left: "10px", top: "10px" , width: "95%"},500);
	$('.phone > .container').animate({opacity:0},500);
		changeText ("Like what you see? Rate it out of five...");
		break;
		case 1:
		changeText ("Not sure what to have? Let us chose for you...");
		$('.phone > .container').css("background-image", "url(/img/phone2.png)");
		$('.phone > .container').animate({opacity:1},500);
		$('#drink1').animate({width: "57.4%",left: "21.5%", top: "47.21%"},500);
		
		break;	
		case 2:
		changeText ("Already got something in mind? Lock in your favourite ingredients and well do the rest...");
		$('#drink4').css("opacity", "1");
		$('#drink4').animate({left: "10px", top: "10px" , width: "95%"},500);
		$('.phone > .container').animate({opacity:0},500);
		$('#drink1').css("opacity", "0");
		break;
				case 3:
		changeText ("Got something to add? Go right ahead");
		$('.phone > .container').css("background-image", "url(/img/phone3.png)");
		$('.phone > .container').animate({opacity:1},500);
		$('#cursor').animate({opacity:1},500);
		$('#drink4').animate({width: "20.2%",left: "43.5%", top: "32%"},500);
		break;
		case 4:
		$('.body').fadeOut(500,function(){
		$('.phone > .container').css("background-image", "url(/img/frame.png)");
		$('#cursor').css("display", "none");
		$('#drink4').css("display", "none");
		$('.email').css("display", "block");
		$('#email0').animate({top: "23%",width: "11%",left: "20.5%",height: "8%",opacity:0},1000,"easeInCubic",function(){
			$('#email2').animate({top: "12%",width: "65.8%",left: "17.3%",height: "72.1%", opacity:1},1000,"easeInCubic",
			function (){$('#reginr').show()});
			
			
			});
		});
		break;	
	
	}
	state++;
}

function changeText (newString){
	$('.des').animate({opacity: 0},function(e){$(".des").html(newString);});
	$('.des').animate({opacity: 1});
	
}