$(function(){
   opener.parent.location.reload();
   $.ajax({
      //먼저 기존의 이미지, 아이디 (아이디는 세션값으로 처리), 매너온도, 현재 위치 addr1,2만 받아오기 행정동법정동 까지만. 
      url:'/jaju/mypage/getMyProfileInfo',
      type:'post',
      data:
      {
         'id':$('#id').val(),
         
      },
      dataType:'json',
      success:function(data){
         //console.log(data.memberDTO);
         //성공하면 , 기존 span태그에 붙여주기 
         //이미지먼저 붙여주고. 
         if(data.memberDTO.member_image==null || data.memberDTO.member_image=="" ){
            $('#image1').attr('src','/jaju/storage/unnamed.png');
         }
         else{
            $('#image1').attr('src','/jaju/storage/'+data.memberDTO.member_image);
         }
         
         $('#member_name_span').text(data.memberDTO.member_name);
         $('#member_manner_span').text(data.memberDTO.member_manner.toFixed(1)+' ℃');
         $('#member_location_span').text(data.memberDTO.member_sido+' '+data.memberDTO.member_sigungu);
         
      },error:function(err){
         console.log("myPageChangeImg.js error 발생"+err);
      }
   });
   		
   		//console.log("js id값"+$('#id').val())
		//console.log("js pg값"+$('#pg').val())
   		$.ajax({
   			
	      //아이디 (아이디는 세션값으로 처리),제목만 받아오기
	      url:'/jaju/mypage/getMyProfileReviewList',
	      type:'post',
	      data:
	      {
	         'id':$('#id').val(),
	         'pg':$('#pg').val(),
	      },
	      dataType:'json',
	      success:function(data){
	         //console.log(data.memberDTO);
	         //성공하면 , 기존 span태그에 붙여주기 
	    	  if(JSON.stringify(data.list)=='[]'){
					//$('.title').remove();
					$('<tr/>').append($('<td/>',{
						align:'center',
						text:'판매 후기가 없습니다.',
						style:'height:200px;'
					})).appendTo($('#historyTable'));
				}
				
	    	  else {
	    		  $.each(data.list, function(index, items){
	    			 $('<tr/>').append($('<td/>',{
							align:'center',
							style:'width:100%; cursor: pointer; text-align-last: left;',
							id:'subject_' 
					}).append($('<a/>',{
						text:' 제 목: '+items.review_subject+' ',
						style:"margin-right: 200px;",
						class:'subject_'+items.review_seq //글제목 부분
					}))).appendTo($('#historyTable'));
					
	    			 $(document).on("click",".subject_"+items.review_seq,function(){			    					
	    				 window.opener.location.href="/jaju/reviewboard/reviewboardView?review_seq="+items.review_seq+"&pg=1";    					
	    				 });
	    			 //페이징처리
	    			 $('#getMyProfileReviewListPagingDiv').html(data.getMyProfileReviewListPage.pagingHTML); 
	    		  });//each
	     	  }//else
	      },error:function(err){
	         console.log("getMyProfileReviewList.js error 발생"+err);
	      }

   	});
});




function readURL(input) {
    if (input.files && input.files[0]) {
     var reader = new FileReader();
     
     reader.onload = function (e) {
      $('#image1').attr('src', e.target.result);  
     }
     
     reader.readAsDataURL(input.files[0]);
     }
   }
    
   // 이벤트를 바인딩해서 input에 파일이 올라올때 위의 함수를 this context로 실행합니다.
   $("#member_image").change(function(){
      readURL(this);
      
});
   
//만약 
$('#update_btn').click(function(){
   
   var formData= new FormData($('#myPageChangeImgForm')[0]);
   //forms 객체 생성. [0]번째 form 안에 있는 내용 넘기기
   //alert(formData);
   $.ajax({
      url:'/jaju/mypage/updateProfileImage',
      type:'post',
      endtype:'multipart/form-data',
      processData:false,
      contentType:false,
      async : false,
      data:formData,
      success:function(){
         //window.close();
         //opener.window.location.reload();
         //location.href="/jaju/mypage/mypageMain";
         //self.close();
         //window.close();
         //window.opener.parent.location.reload(); // 부모창 새로고침 
         //window.self.close(); // 현재 팝업 닫기
    	 location.reload();
    	 window.opener.parent.location.reload(); 
         alert("이미지 수정을 성공하였습니다.");
         window.self.close(); 
      },      error:function(err){
         console.log("error발생"+err);
      }
      
   });
   
});