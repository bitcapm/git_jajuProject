<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
@font-face {
	font-family: 'S-CoreDream-4Regular';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_six@1.2/S-CoreDream-4Regular.woff')
		format('woff');
	font-weight: normal;
	font-style: normal;
}

* {
	font-family: 'S-CoreDream-4Regular';
	-webkit-text-size-adjust: 100%;
}

html {
	-ms-text-size-adjust: 100%;
	-webkit-text-size-adjust: 100%
}

body {
	margin: 0
}

.slick-next:before, .slick-prev:before {
	font-family: slick;
	font-size: 20px;
	line-height: 1;
	opacity: .75;
	color: #333 !important;
	-webkit-font-smoothing: antialiased;
}

.slideWrap .col-md-12 {
	position: relative;
	min-height: 1px;
	padding-left: 15px;
	padding-right: 15px;
	text-align: center;
	
    margin-top: 50px;
	/*margin-bottom: 70px;*/
	width: 100%;
	height: 50px;
}

.slick-dotted.slick-slider {
    margin-bottom: 30px;
    margin-top: -25px;
}
h2 {
	font-family: 'S-CoreDream-4Regular';
	font-weight: 900;
	line-height: 1.1;
	color: #4457C0;
	margin-top: 25px;
	margin-bottom: 12.5px;
	font-size: 31px;
}

p {
	margin: 0 0 12.5px;
}

#slider-div div {
	margin-bottom: 10px;
	
}

#slider-div img {
	border: 1px solid #fff;
	border-radius: 6px;
}

#slider-div img {
	width: 100%;
	height: 100%;
}

.slideWrap {
	margin-top: -100px;
	width: 1505px;
	height: 560px;
	margin: 0 auto;
}

/*슬라이드 체크*/
.item-wrap{
	/*border: 1px solid #ededed;*/
	width:210px;
}
.item_image_div {
	position: relative;
	width: 100%;
	height: 220px;
}

.item_image_div>img {
	vertical-align: bottom;
}

.eKeqot {
	position: absolute;
	top: 0px;
	left: 0px;
	width: 100%;
	height: 100%;
}

.item_detail {
	padding: 15px 10px;
	height: 80px;
}

.item_subject {
	position: relative;
	font-size: 16px;
	padding-bottom: 5px;
	text-overflow: ellipsis;
	white-space: nowrap;
	overflow: hidden;
}

.item_price_div {
	display: flex;
	-webkit-box-pack: justify;
	justify-content: space-between;
	-webkit-box-align: center;
	align-items: center;
	height: 20px;
}

.item_price {
	font-size: 14px;
	font-weight: 600;
	text-overflow: ellipsis;
	white-space: nowrap;
	overflow: hidden;
}

.item_price::after {
	content: "원";
	font-size: 13px;
	margin-left: 3px;
}

*, ::before, ::after {
	box-sizing: border-box;
}

/* 
.slick-list {
	position: relative;
	display: block;
	overflow: hidden;
	margin: 0;
	padding: 0;
} */

/* slick 플러그인
.slick-slider .slick-list {
	display: block;
 	overflow-x: hidden;
	overflow-y: hidden; 
	position: relative
}

.slick-slider .slick-list.dragging {
	cursor: pointer
}

.slick-slider .slick-list .slick-track {
	display: block;
	position: relative;
	top: 0;
	left: 0
}

.slick-slider .slick-list .slick-track:before, .slick-slider .slick-list .slick-track:after
	{
	display: table;
	content: ''
}

.slick-slider .slick-list .slick-track:after {
	clear: both
}

.slick-slider .slick-list.slick-loading .slick-track {
	visibility: hidden
}

.slick-slider .slick-list .slick-track .slick-slide {
	display: none;
	float: left
}

.slick-slider[dir='rtl'] .slick-list .slick-track .slick-slide {
	float: right
}

.slick-slider .slick-list .slick-track .slick-slide img {
	display: inline-block
}

.slick-slider .slick-list .slick-track .slick-slide.slick-loading img {
	display: none
}

.slick-slider.slick-initialized .slick-list .slick-track .slick-slide {
	display: block
}

.slick-slider .slick-list .slick-track.slick-loading .slick-slide {
	visibility: hidden
}

.slick-slider .slick-arrow.slick-hidden {
	display: none
}
 */
</style>

<!-- 제이쿼리 불러오기 -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!-- Slick 불러오기 -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick-theme.min.css">
</head>
<body>
	<div class="slideWrap">
		<!-- stlye 은 slick 영역 확인용 -->
		<div class="col-xs-12 col-md-12">
			<h2>인기거래물품</h2>
			<p>지금 핫한 인기 거래 물품이에요.</p>
		</div>

		<div style="padding: 200px; background-color: #fff;">



			<div id="slider-div">
				<a id="s_a0" class="s_a">
					<div class="item-wrap">
						<div class="item_image_div">
							<img id="s_img0" src="">
						</div>
						<div class="item_detail">
							<div class="item_subject" id="s_subject0"></div>
							<div class="item_price_div">
								<div class="item_price" id="s_price0"></div>
							</div>
						</div>
					</div>
				</a>
				
				<a id="s_a1" class="s_a">
					<div class="item-wrap">
						<div class="item_image_div">
							<img id="s_img1" src="">
						</div>
						<div class="item_detail">
							<div class="item_subject" id="s_subject1"></div>
							<div class="item_price_div">
								<div class="item_price" id="s_price1"></div>
							</div>
						</div>
					</div>
				</a>
				
				<a id="s_a2" class="s_a">
					<div class="item-wrap">
						<div class="item_image_div">
							<img id="s_img2" src="">
						</div>
						<div class="item_detail">
							<div class="item_subject" id="s_subject2"></div>
							<div class="item_price_div">
								<div class="item_price" id="s_price2"></div>
							</div>
						</div>
					</div>
				</a>
				
				<a id="s_a3" class="s_a">
					<div class="item-wrap">
						<div class="item_image_div">
							<img id="s_img3" src="">
						</div>
						<div class="item_detail">
							<div class="item_subject" id="s_subject3"></div>
							<div class="item_price_div">
								<div class="item_price" id="s_price3"></div>
							</div>
						</div>
					</div>
				</a>
				
				<a id="s_a4" class="s_a">		
					<div class="item-wrap">
						<div class="item_image_div">
							<img id="s_img4" src="">
						</div>
						<div class="item_detail">
							<div class="item_subject" id="s_subject4"></div>
							<div class="item_price_div">
								<div class="item_price" id="s_price4"></div>
							</div>
						</div>
					</div>
				</a>
				
				<a id="s_a5" class="s_a">		
					<div class="item-wrap">
						<div class="item_image_div">
							<img id="s_img5" src="">
						</div>
						<div class="item_detail">
							<div class="item_subject" id="s_subject5"></div>
							<div class="item_price_div">
								<div class="item_price" id="s_price5"></div>
							</div>
						</div>
					</div>	
				</a>
				
				<a id="s_a6" class="s_a">
					<div class="item-wrap">
						<div class="item_image_div">
							<img id="s_img6" src="">
						</div>
						<div class="item_detail">
							<div class="item_subject" id="s_subject6"></div>
							<div class="item_price_div">
								<div class="item_price" id="s_price6">가격</div>
							</div>
						</div>
					</div>
				</a>
				
				<a id="s_a7" class="s_a">		
					<div class="item-wrap">
						<div class="item_image_div">
							<img id="s_img7" src="">
						</div>
						<div class="item_detail">
							<div class="item_subject" id="s_subject7"></div>
							<div class="item_price_div">
								<div class="item_price" id="s_price7"></div>
							</div>
						</div>
					</div>
				</a>
				
				<a id="s_a8" class="s_a">	
					<div class="item-wrap">
						<div class="item_image_div">
							<img id="s_img8" src="">
						</div>
						<div class="item_detail">
							<div class="item_subject" id="s_subject8"></div>
							<div class="item_price_div">
								<div class="item_price" id="s_price8"></div>
							</div>
						</div>
					</div>
				</a>
				
				<a id="s_a9" class="s_a">
					<div class="item-wrap">
						<div class="item_image_div">
							<img id="s_img9" src="">
						</div>
						<div class="item_detail">
							<div class="item_subject" id="s_subject9"></div>
							<div class="item_price_div">
								<div class="item_price" id="s_price9"></div>
							</div>
						</div>
					</div>
				</a>

			</div>
			
			<div class="s_no_data" style="padding: 150px 0 148px; border-top: 1px solid #e6e6e6; border-bottom: 1px solid #e6e6e6; font-size: 14px; color: #4c4c4c; text-align: center; margin-bottom: 50px;">
				등록된 상품이 없습니다.
			</div>
			
		</div>
	</div>

	<script>
		/*자동 재생 되는 슬라이드.
		 $(document).ready(function(){

		 $('#slider-div').slick({
		 slidesToShow: 4,
		 slidesToScroll: 1,
		 autoplay: true,
		 autoplaySpeed: 1000,
		 responsive: [
		 {
		 breakpoint: 1024,
		 settings: {
		 slidesToShow: 3,
		 slidesToScroll: 1
		 }
		 },
		 {
		 breakpoint: 600,
		 settings: {
		 slidesToShow: 2,
		 slidesToScroll: 1
		 }
		 },
		 {
		 breakpoint: 480,
		 settings: {
		 slidesToShow: 1,
		 slidesToScroll: 1
		 }
		 }
		 ]
		 });
		 });*/

		/* 이건 좌 우 스크롤 방향키 있는 슬라이드.  */
		$(function() {
			$('#slider-div')
					.slick(
							{
								slide : 'div', //슬라이드 되어야 할 태그 ex) div, li 
								infinite : false, //무한 반복 옵션     
								slidesToShow : 5, // 한 화면에 보여질 컨텐츠 개수
								slidesToScroll : 1, //스크롤 한번에 움직일 컨텐츠 개수
								speed : 500, // 다음 버튼 누르고 다음 화면 뜨는데까지 걸리는 시간(ms)
								arrows : true, // 옆으로 이동하는 화살표 표시 여부
								dots : true, // 스크롤바 아래 점으로 페이지네이션 여부
								autoplay : true, // 자동 스크롤 사용 여부
								autoplaySpeed : 3000, // 자동 스크롤 시 다음으로 넘어가는데 걸리는 시간 (ms)
								pauseOnHover : true, // 슬라이드 이동    시 마우스 호버하면 슬라이더 멈추게 설정
								vertical : false, // 세로 방향 슬라이드 옵션
								prevArrow : "<button type='button' class='slick-prev'>Previous</button>", // 이전 화살표 모양 설정
								nextArrow : "<button type='button' class='slick-next'>Next</button>", // 다음 화살표 모양 설정
								dotsClass : "slick-dots", //아래 나오는 페이지네이션(점) css class 지정
								draggable : true, //드래그 가능 여부 
								
								responsive : [ // 반응형 웹 구현 옵션
								{
									breakpoint : 960, //화면 사이즈 960px
									settings : {
										//위에 옵션이 디폴트 , 여기에 추가하면 그걸로 변경
										slidesToShow : 5
									}
								}, {
									breakpoint : 768, //화면 사이즈 768px
									settings : {
										//위에 옵션이 디폴트 , 여기에 추가하면 그걸로 변경
										slidesToShow : 5
									}
								} ]
							});
			
		});
	</script>


</body>
</html>