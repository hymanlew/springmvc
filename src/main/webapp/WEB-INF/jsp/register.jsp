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
*{
  padding:0;
  margin:0;
  font-family:"微软雅黑";
}
body{
  background:#eee;
  font-size:22px;
  margin:15px;
  padding:10px;
}
#content-w{
  text-align:center;
}
#content{
  background:#fff;
  width:960px;
  margin:20px auto;
  text-align:left;
  padding:20px;
}
#content h2{
  
}
#reg-form{
  margin:20px 0 0 0;
}
#reg-form .item{
 margin:0 0 15px 0; 
 }

#reg-form .item b {
 display:block;
 width:80px; 
 float:left; 
 font-size:23px;
 font-weight:normal;
 line-height:30px;
 margin-right:16px;
 }
#reg-form .item p {
 float:left;
  }
#reg-form .item .inp {
 height:28px;
 width:280px; 
 padding:0 10px;
 font-size:20px;
 border:1px solid #999;
 border-radius:5px;
 background:#f0f0f0;
  }
 #reg-form .item .inp:focus{
  background:#fff;
 }
#reg-form .item .bt {
  width:80px;
  height:30px;
  background:#0278c2;
  border:0;
  color:#fff;
  font-size:18px;
  border-left:1px solid #fff;
 }
</style>
</head>
<body>

  <div id="content-w">
    <div id="content">
      <h2>用户注册</h2>
      <form method="post" action="handlerReg.do">
        <div id="reg-form">
          <div class="item">
            <b>name</b>
            <p><input name="name" type="text" placeholder="name" class="inp"></p>
            <div style="clear:both;"></div>
          </div>
          <div class="item">
            <b>password</b>
            <p><input name="password" type="password" placeholder="password" class="inp"></p>
            <div style="clear:both;"></div>
          </div>
          <div class="item">
            <b>salary</b>
            <p><input name="salary" type="text" placeholder="salary" class="inp"></p>
            <div style="clear:both;"></div>
          </div>
          <div class="item">
            <input name="submib" type="submit" placeholder="name" class="bt">
          </div>
        </div>
      </form>
    </div>
  </div>
</body>
</html>