//불러오기
$(function(){

	$.ajax({
		type: 'post',
		url: '/jaju/saleboard/getSaleboardView',
		data: {'sale_seq': $('#sale_seq').val()},
		dataType: 'json',
		success: function(data){
			//alert(JSON.stringify(data));
			
			$('#sale_subject').val(data.saleboardDTO.sale_subject);
			
			$('#sale_price').val(data.saleboardDTO.sale_price);
			
			if(data.saleboardDTO.sale_nego == 'on') {
				$("#sale_nego").attr("checked", true); 
			}
			
			$('#sale_category').val(data.saleboardDTO.sale_category);
			
			if(data.saleboardDTO.sale_condition == '새상품') {
				$('#new').attr("checked", true);
				
			}else if(data.saleboardDTO.sale_condition == '거의 새것') {
				$('#almostNew').attr("checked", true);
				
			}else if(data.saleboardDTO.sale_condition == '사용감있음') {
				$('#used').attr("checked", true);
				
			}else if(data.saleboardDTO.sale_condition == '사용감많음') {
				$('#veryused').attr("checked", true);
				
			}			
			
			var howTrade;
			if(data.saleboardDTO.sale_direct == 'on') {
				$("#sale_direct").prop("checked", true); 
			}
			if(data.saleboardDTO.sale_delivery == 'on') {
				$("#sale_delivery").prop("checked", true); 
			}
			if(data.saleboardDTO.sale_onlineTran == 'on') {
				$("#sale_onlineTran").prop("checked", true); 
			}
			$('#howTrade .desc').val(howTrade);
			
			$('#sale_content').val(data.saleboardDTO.sale_content);
			
			
			$('#sale_hide').val(data.saleboardDTO.sale_hide);
			
			let map = new Map();
			
			map.set("image1", data.saleboardDTO.sale_image1);
			map.set("image2", data.saleboardDTO.sale_image2);
			map.set("image3", data.saleboardDTO.sale_image3+''); //null값 방지
			map.set("image4", data.saleboardDTO.sale_image4+'');
			map.set("image5", data.saleboardDTO.sale_image5+'');
			map.set("image6", data.saleboardDTO.sale_image6+'');
			map.set("image7", data.saleboardDTO.sale_image7+'');
			map.set("image8", data.saleboardDTO.sale_image8+'');
			map.set("image9", data.saleboardDTO.sale_image9+'');
			map.set("image10", data.saleboardDTO.sale_image10+'');
			
			for(var i=1; i<=10; i++){
				if(map.get('image'+i) != 'null'){
					$('#imageTd').append($('<img/>',{
						width:"80",
						height:"80",
						class:"miniImg",
						src: '/jaju/storage/'+map.get('image'+i)
					}));
				}
			}
		},
		error: function(err){
			console.log(err);
		}
		
	});
	
});


$('#saleboardModifyBtn').click(function(){
	
	var formData = new FormData($('#saleboardModifyForm')[0]); //form 안에 있는 모든 것 다 넘김
	
	//유효성 검사
	$('#sale_subjectDiv').empty();
	$('#sale_priceDiv').empty();
	$('#sale_categoryDiv').empty();
	$('#sale_conditionDiv').empty();
	$('#sale_directDiv').empty();
	$('#sale_deliveryDiv').empty();
	$('#sale_onlineTranDiv').empty();
	$('#sale_contentDiv').empty();
	
	var whatcondition = document.getElementsByName('sale_condition'); //라디오박스
	
	var howdelivery = document.getElementsByName('howDelivery'); //체크박스
	var num = 0;
	
	//배송방법
	/*for(var i = 0; i<howdelivery.length; i++) {
		if(howdelivery[i].checked) {
			num++;
		}
	}*/
	
	//alert(!$('#sale_direct').prop('checked'))
	//false !==true &&  t,t,t 나오는 경우 걸리게 코드짜기   
	if(!$('#sale_direct').prop('checked')&&!$('#sale_delivery').prop('checked')&&!$('#sale_onlineTran').prop('checked')) {
		//alert('배송')
		$('#sale_directDiv').text('배송 방법을 선택해주세요');
		$('#sale_directDiv').css('color', 'red');
		$('#sale_directDiv').css('font-size', '10pt');
		$('#sale_directDiv').css('font-weight', 'bold');
	}
	else if($('#sale_subject').val() == ''){
        $('#sale_subjectDiv').text('제목을 입력하세요');
        $('#sale_subjectDiv').css('color', 'red');
        $('#sale_subjectDiv').css('font-size', '10pt');
        $('#sale_subjectDiv').css('font-weight', 'bold');
	}
	else if($('#sale_price').val() == ''){
        $('#sale_priceDiv').text('가격을 입력하세요');
        $('#sale_priceDiv').css('color', 'red');
        $('#sale_priceDiv').css('font-size', '10pt');
        $('#sale_priceDiv').css('font-weight', 'bold');
	}
	else if($('#sale_category').val() == '*'){
		$('#sale_categoryDiv').text('카테고리를 선택해주세요');
		$('#sale_categoryDiv').css('color', 'red');
        $('#sale_categoryDiv').css('font-size', '10pt');
        $('#sale_categoryDiv').css('font-weight', 'bold');
	}else if($('input[name=sale_condition]:radio:checked').length==0){ //선택해도 안 없어짐
		$('#sale_conditionDiv').text('상품 상태를 선택해주세요');
		$('#sale_conditionDiv').css('color', 'red');
        $('#sale_conditionDiv').css('font-size', '10pt');
        $('#sale_conditionDiv').css('font-weight', 'bold');
	}else if($('#sale_content').val() == ''){
		$('#sale_contentDiv').text('내용을 입력하세요');
		$('#sale_contentDiv').css('color', 'red');
		$('#sale_contentDiv').css('font-size', '10pt');
		$('#sale_contentDiv').css('font-weight', 'bold');
	}else{
	
	$.ajax({
		type: 'post',
		url: '/jaju/saleboard/saleboardModify',
		enctype: 'multipart/form-data',
		processData: false,
		contentType: false,
		data: formData,
		success: function(data) {
			alert("게시글수정 완료");
			location.href='/jaju/saleboard/saleboardList?pg=1&sortinSelect=sale_date';
		},
		error: function(err){
			console.log(err);
		}
	});
	}
});

$('#sale_state').change(function(){
	
	
	if($('#sale_state').val() == '판매완료'){
		$('.saleboardModifyTr').after($('<tr/>',{
			id : 'sale_state_com'
		}).append($('<th/>',{
			text: '구매자 선택'
		})).append($('<td/>',{
			
		}).append($('<select/>',{
			id : 'bayer_select',
			width : '200px',
			height : '50px'
		}).append($('<option/>',{
			value : '구매자선택',
			text : '구매자선택'
		}))).append($('<input/>',{
			type: 'button',
			value: '구매자 선택',
			class : 'bhs_button yb',
			id : 'bayer_selectBtn'
		}))))
		
		$.ajax({
				type : 'post',
				url : '/jaju/saleboard/salebuyerFindMessage',
				data : {
					'sale_seq' : $('#sale_seq').val()
				},
				dataType : 'json',
				async : false,
				success : function(data) {
					console.log(JSON.stringify(data));
					//$('#sale_category').append()

					$.each(data.list, function(index, items) {

						$('#bayer_select').append($('<option/>', {
							value : items.MESSAGE_WRITER,
							text : items.MESSAGE_WRITER,
							id : 'sale_buyer'
						}));

					});//each

				},
				error : function() {
					console.log("salebuyer1 error발생+err")
				}
			});//ajax
		
		$.ajax({
			type : 'post',
			url : '/jaju/saleboard/salebuyerFindComment',
			data : {
				'sale_seq' : $('#sale_seq').val()
			},
			dataType : 'json',
			async : false,
			success : function(data) {
				console.log(JSON.stringify(data));
				//$('#sale_category').append()

				$.each(data.list, function(index, items) {

					$('#bayer_select').append($('<option/>', {
						id : 'sale_buyer',
						value : items.MEMBER_ID,
						text : items.MEMBER_ID

					}));

				});//each
				alert("구매하신 분의 ID를 선택하고 완료버튼을 누르세요.")
				$('#select_buyer').show();
				$('#saleBuyerBtn').show(); //구매자 확정버튼 보이기 

			},
			error : function() {
				console.log("salebuyer2 error발생+err")
			}
		});//ajax
		
	} else{
		$('#sale_state_com').remove()
	}
		
		
		
		

	
});


$(document).on('click','#bayer_selectBtn', function(){

//	alert($("#bayer_select").val());
//	alert($('#sale_seq').val());
	
	if($("#bayer_select option:checked").text()=='구매자선택'){
		alert("구매자 ID를 선택해주세요.");
		return false;
	}else{
		

	$.ajax({
		type : 'post',
		url : '/jaju/saleboard/salebuyerConfirmation',
		data : {
			'sale_seq' : $('#sale_seq').val(),
			'sale_buyer' : $("#bayer_select").val()

		},
		//dataType: 'json',
		async : false,
		success : function() {
			//console.log(JSON.stringify(data));
			alert("구매자아이디 등록완료");
			$('#saleBuyerBtn').hide();
		},
		error : function() {
			console.log("salebuyer3 error발생+err")
		}
	});//ajax
	
	

	}//else
});




