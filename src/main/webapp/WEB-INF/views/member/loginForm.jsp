<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
<link rel="stylesheet" type="text/css" href="css/default.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">

	$(function(){
		$("#btn_login").click(function(){
			// 유효성 검사 추가 필요
			var id = $("#id").val();
			var passwd = $("#passwd").val();
			//debugger;
			if(id.length < 1){
				$("#txt_login").text("아이디를 입력해주세요");
				
				return false;
			}
			
			if(passwd.length < 1){
				$("#txt_login").text("패스워드를 입력해주세요");
				
				return false;
			}
						
			//debugger;
			$.ajax({
				url : "login",
				type : "post",
				//async : false,
				data : {"id" : id, 
						"passwd" : passwd},
				success : function(rec_data){
					if (rec_data) {
						location.href = "/db";			
					} else {
						$("#txt_login").text("아이디/패스워드가 일치하지 않습니다.");
					}
				},
				error : function(rec_data){
					$("#txt_login").text("서버 통신에 실패했습니다.");		
				}
			});	
		});
		
		$("#passwd").keypress(function(event){
			if(event.which == 13){
				$("#btn_login").click();
			}
		});
	});
	
</script>
</head>
<body>
<div id="container">
	<h1>[ 로그인 ]</h1>
	<form id="login" action="login" method="post">
		<table>
			<tr>
				<th>아이디</th>
				<td><input type="text" id="id" name="id" required="required"></td>
			</tr>
			<tr>
				<th>패스워드</th>
				<td><input type="password" id="passwd" name="passwd" required="required"></td>
			</tr>
		</table>
		<div id="txt_login" class="center txt_red"></div>
		<div class="center"><input type="button" id="btn_login" value="로그인"></div>
	</form>
</div>
</body>
</html>