// JavaScript Document
//----------侧边导航-----------------
$('.aside_help li').mouseenter(function(e) {
    $(this).children('.on').stop().animate({'right':'0'},200)
});
$('.aside_help li').mouseleave(function(e) {
    $(this).children('.on').stop().animate({'right':'-150px'},200)
});


//----------返回顶部-----------------
$(window).scroll(function(e) {
		var a=$(window).scrollTop();
		var b=$(window).height();
		
		if(a>b){
			$('.return').stop().fadeTo(500,1)
		}else{
			$('.return').stop().fadeTo(500,0)
		}
    });
$('.return').click(function(e) {
    $('html,body').animate({scrollTop:0},500)
});
//-----礼品篮鼠标移上效果-----
$('.goods_1').mouseenter(function(e) {
    $(this).css('background','#f6f6f6')
}).mouseleave(function(e) {
    $(this).css('background','none')
});