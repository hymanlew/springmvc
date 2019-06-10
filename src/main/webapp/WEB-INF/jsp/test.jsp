<%@ page
    language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 
<link rel="stylesheet" href="../css/reg.css"/>
 -->
 <style type="text/css">

h1{
  margin-left:250px;
 }
 #c form {
  font-size:24px;
  border: 1px solid red;
  width: 360px;
  padding: 20px;
  right: 120px;
  color: #fff;
  background-color: rgba(0,0,0,0.3);
    margin:auto;
}

#p1 input{
 margin-left:50px;
}
#p3 input{
 margin-left:8px;
}
#p2 input{
 margin-left:45px;
}
.core input{
 
  width:100px;
}
 </style>
</head>
<body>
  <h1>register</h1>
  <div id="c">
    <form action="">
      <p id="p1">
        <label>name</label>
        <input name="name" type="text" placeholder="name">
      </p>
      <p id="p3">
        <label>password</label>
        <input name="password" type="password" placeholder="password">
      </p>
      <p id="p2">
        <label>salary</label>
        <input name="salary" type="text" placeholder="salary">
      </p>
      <p >
        <input name="submib" type="submit" placeholder="name">
      </p>
    </form>
  </div>
</body>
</html>