<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	function formCheck(){
		if (!idDuplicateCheck()) return;
		if (!passwordCheck()) return;
		if (!nameCheck()) return;
		if (!birthCheck()) return;

		$("form").submit();
	}

	function idDuplicateCheck(){

		var result = false;
		var id = $("#id").val();
	
		if (id.length < 4 || id.length > 20) {
			$("#idCheck").text("ID는 4~20자리로 입력해 주세요");
			$("#id").focus()
			return false;
		}
		
		$.ajax({
			url : "idDuplicateCheck",
			type : "post",
			async : false,
			data : {"id" : id},
			success : function(rec_data){
				if (rec_data) {
					$("#idCheck").text("사용 가능한 ID 입니다.");
					result = true;
				}		
			},
			error : function(err_data){
				console.log(err_data);
				$("#idCheck").text("이미 사용중인 ID 입니다.");
				result = false;
			}
		});

		return result;
	}

	function passwordCheck(){
		var password = $("#password").val();
		var password2 = $("#password2").val();

		if (password.length < 4 || password.length > 20){
			$("#passwordCheck").text("패스워드는 4~20자리로 입력해 주세요.");
			$("#password").focus();
			return false;
		}
		
		if (password != password2) {
			$("#passwordCheck").text("패스워드와 패스워드 확인이 일치하지 않습니다.");
			$("#password").focus();
			return false;
		}

		$("#passwordCheck").text("");
		return true;
	}

	function nameCheck(){
		var name = $("#name").val();

		if (name.length < 2 || name.length > 20) {
			$("#nameCheck").text("이름은 2~20자리로 입력해 주세요");
			$("#name").focus();
			return false;
		}

		$("#nameCheck").text("");
		return true;
	}

	function birthCheck() {
		var birth = $("#birth").val();

		if (birth == "" || birth == null) {
			$("#birthCheck").text("생년월일을 입력해 주세요");
			$("#birth").focus();
			return false;
		}

		$("#birthCheck").text("");
		return true;
	}

</script>
<style type="text/css">
	.txt_red {
		color: red;
	}
</style>
</head>
<body>
<div>
	<h1>[ 회원가입 ]</h1>
	<form action="joinMember" method="post">
		<table>
			<tr>
				<th>아이디</th>
				<td>
					<input type="text" id="id" name="id">
					<input type="button" value="중복확인" onclick="idDuplicateCheck()">
					<div id="idCheck" class="txt_red"></div>
				</td>
			</tr>
			<tr>
				<th>패스워드</th>
				<td>
					<input type="password" id="password" name="password">
					<div id="passwordCheck" class="txt_red"></div>	
				</td>
			</tr>
			<tr>
				<th>패스워드 확인</th>
				<td><input type="password" id="password2" name="password2"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td>
					<input type="text" id="name" name="name">
					<div id="nameCheck" class="txt_red"></div>
				</td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td>
					<input type="date" id="birth" name="birth">
					<div id="birthCheck" class="txt_red"></div>
				</td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td><input type="number" id="phone" name="phone"></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="text" id="email" name="email"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value="회원가입" onclick="formCheck()">
					<input type="reset" value="다시 작성">	
				</td>
			</tr>
		</table>	
	</form>
</div>
</body>
</html>