<%--
  Created by IntelliJ IDEA.
  User: K
  Date: 2021-02-03
  Time: 오후 3:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>회원가입</title>
</head>
<body>
    <h2>회원 정보 입력</h2>
    <form action="step3" method="post">
        <p><label>이메일:<br/><input type="text" name="email" id="email"></label></p>
        <p><label>이름:<br/><input type="text" name="name" id="name"></label></p>
        <p><label>비밀번호:<br/><input type="password" name="password" id="password"></label></p>
        <p><label>비밀번호 확인:<br/><input type="password" name="confirmPassword" id="confirmPassword"></label></p>
        <input type="submit" value="가입 완료">
    </form>
</body>
</html>
