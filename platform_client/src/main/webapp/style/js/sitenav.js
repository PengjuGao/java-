// JavaScript Document
//------直通车 ---------------------
$('.addr').mouseenter(function(e) {
	$(this).children('.header_t').css({"background":"#fff","border-left":"1px solid #e0e0e0","border-right":"1px solid #e0e0e0","padding":"0 10px 0 19px"});
    $(this).children('.header_b').stop().slideDown(100);
});
$('.addr').mouseleave(function(e) {
    $(this).children('.header_b').stop().slideUp(100);
	$(this).children('.header_t').css({"background":"none","border-left":"none","border-right":"none","padding":"0 10px 0 20px"});
});

$('.sitenav_r_m').mouseenter(function(e) {
	$(this).children('.header_t').css({"background":"#fff","border-left":"1px solid #e0e0e0","border-right":"1px solid #e0e0e0","padding":"0 33px 0 7px"});
    $(this).children('.header_b').stop().slideDown(100);
});
$('.sitenav_r_m').mouseleave(function(e) {
    $(this).children('.header_b').stop().slideUp(100);
	$(this).children('.header_t').css({"background":"none","border":"none","padding":"0 34px 0 8px"});
});

$('.shop_car').mouseenter(function(e) {
	$(this).children('.header_t').css({"background":"#fff","border-left":"1px solid #e0e0e0","border-right":"1px solid #e0e0e0","padding":"0 29px"});
	$(this).children('.header_t').children().children('b').hide();
    $(this).children('.shop_car_b').stop().slideDown(100);
});

$('.shop_car').mouseleave(function(e) {
	$(this).children('.header_t').css({"background":"none","border":"none","padding":"0 30px"});
	$(this).children('.header_t').children().children('b').show();
    $(this).children('.shop_car_b').stop().slideUp(100);
});

$('.phone').mouseenter(function(e) {
	$(this).children('.header_t').css({"background":"#fff","border-left":"1px solid #e0e0e0","border-right":"1px solid #e0e0e0","padding":"0 18px 0 13px"});
    $(this).children('.shop_car_b').stop().slideDown(100);
	$('.sitenav_r li.shop_car em').css('background','none')
});
$('.phone').mouseleave(function(e) {
	$(this).children('.header_t').css({"background":"none","border":"none","padding":"0 19px 0 14px"});
    $(this).children('.shop_car_b').stop().slideUp(100);
	$('.sitenav_r li.shop_car em').css('background','#e0e0e0')
});

$('.shop').mouseenter(function(e) {
	$(this).children('.header_t').css({"background":"#fff","border-left":"1px solid #e0e0e0","border-right":"1px solid #e0e0e0","padding":"0 33px 0 7px"});
    $(this).children('.sitenav_r li .shop_b').stop().slideDown(100);
});
$('.shop').mouseleave(function(e) {
	$(this).children('.header_t').css({"background":"none","border":"none","padding":"0 34px 0 8px"});
    $(this).children('.sitenav_r li .shop_b').stop().slideUp(100);
});

//-------选择地址------
$('.addr .header_b a').click(function(e) {
    $(this).addClass('now').siblings().removeClass('now');
	$('.addr .header_t em').html($(this).html());
});


document.getElementById('search').onfocus = function(){
	if(document.getElementById('search').value=='请输入关键字'){
		document.getElementById('search').value= '';
		document.getElementById('search').style.color = '#000';
		}
}
document.getElementById('search').onblur = function(){
		if(document.getElementById('search').value==''){
		document.getElementById('search').value= '请输入关键字';
		document.getElementById('search').style.color = '#dadada';
		}
}


//----------二级菜单效果-----------------
$('.nav_title').mouseenter(function(e) {
    $('.aside_nav').stop().slideDown(200);
}).mouseleave(function(e) {
    $('.aside_nav').stop().slideUp(200);
});
$('.aside_nav').mouseenter(function(e) {
    $(this).stop().slideDown(200);
}).mouseleave(function(e) {
    $(this).stop().slideUp(200);
});

$('.aside_nav li').mouseenter(function(e) {
	var navI = $(this).index();
    $(this).addClass('hover');
	$(this).children('b').show();
	$('.aside_nav2>div').eq(navI).show()
	$('.aside_nav2').show();
});
$('.aside_nav li').mouseleave(function(e) {
	var navI = $(this).index();
    $(this).removeClass('hover');
	$(this).children('b').hide();
	$('.aside_nav2>div').eq(navI).hide();
	$('.aside_nav2').hide();
});

$('.aside_nav2>div').mouseenter(function(e) {
    var navI = $(this).index();
	$(this).show();
	$('.aside_nav li').eq(navI).children('b').show();
	$('.aside_nav li').eq(navI).addClass('hover');
	$('.aside_nav2').show();
});
$('.aside_nav2>div').mouseleave(function(e) {
    var navI = $(this).index();
	$(this).hide();
	$('.aside_nav li').eq(navI).children('b').hide();
	$('.aside_nav li').eq(navI).removeClass('hover');
	$('.aside_nav2').hide();
});


















