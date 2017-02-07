$('#login-button1').click(function(){
  $('#login-button1').fadeOut("slow",function(){
    $("#container").fadeIn();
    TweenMax.from("#container", .4, { scale: 0, ease:Sine.easeInOut});
    TweenMax.to("#container", .4, { scale: 1, ease:Sine.easeInOut});
  });
});

$(".close-btn").click(function(){
  TweenMax.from("#container", .4, { scale: 1, ease:Sine.easeInOut});
  TweenMax.to("#container", .4, { left:"0px", scale: 0, ease:Sine.easeInOut});
  $("#register-container").fadeOut(800, function(){
    $("#login-button1").fadeIn(800);
  });
});

$('#login-button2').click(function(){
	  $('#login-button2').fadeOut("slow",function(){
	    $("#container").fadeIn();
	    TweenMax.from("#container", .4, { scale: 0, ease:Sine.easeInOut});
	    TweenMax.to("#container", .4, { scale: 1, ease:Sine.easeInOut});
	  });
	});

	$(".close-btn").click(function(){
	  TweenMax.from("#container", .4, { scale: 1, ease:Sine.easeInOut});
	  TweenMax.to("#container", .4, { left:"0px", scale: 0, ease:Sine.easeInOut});
	  $("#register-container").fadeOut(800, function(){
	    $("#login-button2").fadeIn(800);
	  });
	});
	
	$('#login-button3').click(function(){
		  $('#login-button3').fadeOut("slow",function(){
		    $("#container").fadeIn();
		    TweenMax.from("#container", .4, { scale: 0, ease:Sine.easeInOut});
		    TweenMax.to("#container", .4, { scale: 1, ease:Sine.easeInOut});
		  });
		});

		$(".close-btn").click(function(){
			
		  TweenMax.from("#container", .4, { scale: 1, ease:Sine.easeInOut});
		  TweenMax.to("#container", .4, { left:"0px", scale: 0, ease:Sine.easeInOut});
		  $("#register-container").fadeOut(800, function(){
		    $("#login-button3").fadeIn(800);
		  });
		});

/* Register User*/
$('#register').click(function(){
  $("#container").fadeOut(function(){
    $("#register-container").fadeIn();
  });
});

