<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/default.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	function formCheck(){
		if (!passwdCheck()) return;
		if (!nameCheck()) return;
		if (!birthCheck()) return;

		$("form").submit();
	}

	function passwdCheck(){
		var passwd = $("#passwd").val();
		var passwd2 = $("#passwd2").val();

		if (passwd.length < 1 && passwd2.length < 1) return true;
		
		if (passwd.length < 4 || passwd.length > 20){
			$("#passwdCheck").text("패스워드는 4~20자리로 입력해 주세요.");
			$("#passwd").focus();
			return false;
		}
		
		if (passwd != passwd2) {
			$("#passwdCheck").text("패스워드와 패스워드 확인이 일치하지 않습니다.");
			$("#passwd").focus();
			return false;
		}

		$("#passwdCheck").text("");
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
</head>
<body>
<div id="container">
	<h1>[ 회원정보 수정 ]</h1>
	<form action="updateMember" method="post">
		<table>
			<tr>
				<th>아이디</th>
				<td>
					${member.id }
				</td>
			</tr>
			<tr>
				<th>패스워드</th>
				<td>
					<input type="password" id="passwd" name="passwd">
					<div id="passwdCheck" class="txt_red"></div>	
				</td>
			</tr>
			<tr>
				<th>패스워드 확인</th>
				<td><input type="password" id="passwd2" name="passwd2"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td>
					<input type="text" id="name" name="name" value="${member.name }">
					<div id="nameCheck" class="txt_red"></div>
				</td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td>
					<input type="date" id="birth" name="birth" value="${member.birth }">
					<div id="birthCheck" class="txt_red"></div>
				</td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td><input type="number" id="phone" name="phone" value="${member.phone }"></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="text" id="email" name="email" value="${member.email }"></td>
			</tr>
			<tr>
				<td class="center" colspan="2">
					<input type="button" value="회원정보 수정" onclick="formCheck()">
				</td>
			</tr>
		</table>	
	</form>
</div>
</body>
</html>