<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
	<title>login</title>
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
	
	<meta charset="utf-8"/>
	<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
	<meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width"/>
	<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
	
    
</head>

<body>
<h1>
	소셜 로그인 실습
</h1>


아이디: <input type= "text" name="id"/> <br>
비밀번호: <input type= "password" name="pw"/>
<br><br>
<input type="submit" value = "로그인"/>
<br>

 <br>
	<!-- 구글 로그인 화면으로 이동 시키는 URL -->
	<!-- 구글 로그인 화면에서 ID, PW를 올바르게 입력하면 oauth2callback 메소드 실행 요청-->
	<div id="google_id_login" style="text-align:center"><a href="${url}">
	<img width="230" src="${pageContext.request.contextPath}/resources/sign-in-with-google.png"/>
	</a>
	</div> 



    
	<div id="kakao-login-btn" style="text-align:center"></a>
	<a href="http://developers.kakao.com/logout"></a>
	</div>
	<script type='text/javascript'>
	  //<![CDATA[
	    // 사용할 앱의 JavaScript 키를 설정해 주세요.
	    Kakao.init('22b76a338ca706224223f7826dccf04b');
	    // 카카오 로그인 버튼을 생성합니다.
	    Kakao.Auth.createLoginButton({
	      container: '#kakao-login-btn',
	      success: function(authObj) {
	        alert(JSON.stringify(authObj));
	      },
	      fail: function(err) {
	         alert(JSON.stringify(err));
	      }
	    });
	  //]]>
	</script>
</body>

</html>
