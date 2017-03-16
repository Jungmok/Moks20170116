<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
//출력이 아닌 실행될 자바코드.. 꽂아라..
String _x=request.getParameter("x");
String _y=request.getParameter("y");

//x,y가 필수 입력값이라면
/*int x=Integer.parseInt(_x);
int y=Integer.parseInt(_y);*/

//x,y가 필수가 아닌 옵션값이라면
int x=0;
int y=0;

if(_x!=null && !_x.equals("")) //x가 전달된 값이 있다면
	x=Integer.parseInt(_x);
if(_y!=null && !_x.equals(""))
	y=Integer.parseInt(_y);

//쿼리 스트링이 전달되는 방식 3가지..
/*/calc				x,y->null 0으로 안 바뀜->오류
/clac?x= & y=		x,y="" 빈문자열 0으로 안 바뀜->오류
/clac?x=1 & y=2		x=1*/
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>안녕 Jasper</title>
</head>
<body>
	<form action="calc" method="post">
		<p>
	      <label>x:</label><input id="txt-x" name="x" /> 
	      <label>y:</label><input id="txt-y" name="y"/>
	   </p>
	   <p>
	      sum = <input id="txt-sum" value="7"/>
	   </p>
	   <p>
	      <input id="btn-sum" type="submit" value="결과" />
	   </p>
   </form>
</body>
</html>