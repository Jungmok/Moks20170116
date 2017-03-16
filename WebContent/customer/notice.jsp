<%@page import="com.newlecture.web.data.view.NoticeView"%>
<%@page import="java.util.List"%>
<%@page import="com.newlecture.web.data.dao.NoticeDao"%>
<%@page import="com.newlecture.web.dao.mysql.MySQLNoticeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	// ../notice.jsp?p=5&?&?-->
	String _page=request.getParameter("p"); //_는 임시변수
	String _field=request.getParameter("f");
	String _query=request.getParameter("q");
	
	int pg=1;
	String field = "TITLE";
	String query = "";
	
	if(_page!=null && !_page.equals("")) //값이 넘겨진것이 있다면
		pg=Integer.parseInt(_page);
	if(_field!=null && !_field.equals(""))
		field=_field;
	if(_query!=null && !_query.equals(""))
		query=_query;

	/* System.out.println(query); */
	
	NoticeDao noticeDao = new MySQLNoticeDao();
	List<NoticeView> list = noticeDao.getList(pg,field,query);
	
	int size = noticeDao.getSize(field, query);
%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/customer/style.css" type="text/css" rel="stylesheet" />
<script src="../js/customer/notice.js"></script>
<!-- <script>
	//notice.js 에 있는 window와 같아서..
	window.addEventListener("load",function(){
		alert("hello");
	}); 
</script> -->
</head>

<body>

	<!-- ---------header-------------------------------------------------------- -->
	<header id="header">
		<div class = "content-container">
			<h1 id="logo">
				<img src="../images/logo.png"="뉴렉처온라인"/>
			</h1>
			
			<section>
				<h1 class="hidden">Header</h1>
				
				<nav id="main-menu"class="hr-menu">
					<h1>메인메뉴
					<input type="button" value="클릭" id="btn-result"/>
					</h1>
					<ul>
						<li><a herf="">학습가이드</a></li>
						<li><a herf="">뉴렉과정</a></li>
						<li><a herf="">강좌선택</a></li>
					</ul>
				</nav>
				
				<div id="lecture-search-form">
					<h3 class="hidden">강좌검색폼</h3>
						<form>
							<fieldset>
							<legend class="hidden">검색필드</legend>
							<label>과정검색</label> <input type="text"/>
							<input class="lecture-search-button" type="submit" value="검색"/>
							</fieldset>
						</form>
				</div>
				 
				<nav id="account-menu"class="hr-menu">
					<h1 class="hidden">계정메뉴</h1>
					<ul>
						<li class="first"><a href="../index.html">HOME</a></li>
						<li><a href="../joinus/login.html">로그인</a> </li>
						<li><a href="../joinus/agree.html">회원가입</a></li>
					</ul>
				</nav>
				
				<nav id="member-menu"class="hr-menu">
					<h1 class="hidden">회원메뉴</h1>
					<ul>
						<li ><a href="">마이페이지</li>
						<li ><a href="">고객센터</a></li>
					</ul>
				</nav>
				
			</section>
		</div>
	</header>

	<!-- -------visual----------------------------------------------------------- -->
	<div id="visual">
		<div class = "content-container">
		<!-- visual -->
		</div>
	</div>

	<!-- -------body------------------------------------------------------------ -->
	<div id="body">
		<div class = "content-container clearfix">
		
			<aside id="aside">
				<h1 class="aside-title aside-main-title aside-margin">고객센터</h1>
		
				<nav>
					<h1 class="hidden" class="aside-title">고객센터메뉴</h1>
					<ul>
						<li class="aside-menu-item"><a class = "aside-menu-item-link" herf="">공지사항</a></li>
						<li class ="aside-menu-item"><a class = "aside-menu-item-link" herf="">1:1고객문의</a></li>
						<li class ="aside-menu-item"><a class = "aside-menu-item-link" herf="">학습안내</a></li>
					</ul>
				</nav>
			
				<nav>
					<h1 class="aside-title margin">추천사이트</h1>
					<ul class="margin">
						<li><a herf=""><img src="../images/answeris.png" alt="앤서이즈"/></a></li>
						<li><a herf=""><img src="../images/w3c.png" alt="W3C"/></a></li>
						<li><a herf=""><img src="../images/microsoft.png" alt="마이크로소프트"/></a></li>
					</ul>
				</nav>
			</aside>
	
			<main id="main">
			
				<h2 class="main-title">공지사항[<%=size %>]</h2>
				
				<div class="breadcrumb">
					<h3 class="hidden">현재경로</h3>
					<ul>
						<li>home</li>
						<li>고객센터</li>
						<li>공지사항</li>
					</ul>
				</div>
					
			 <form>
	             <fieldset>
	                <legend class="hidden">검색필드</legend>
	                <label class="hidden">검색분류</label>
	                <select name="f">                                          
	                   <option value="TITLE" <%if(field.equals("TITLE")){ %>selected<%} %>>제목</option>
	                   <option value="CONTENT"<%if(field.equals("CONTENT")){ %>selected<%} %>>내용</option>                     
	                </select>
	                <label class="hidden">검색어</label>
	                <input name="q" type="text" value="<%=query %>" placeholder="검색어를 입력하세요"/>
	                <input class="btn btn-search" type="submit" value="검색" />
	             	<input type="hidden" name="p" value="1"/>
	             </fieldset>               
	          </form>
          
	          <div class="notice margin">
				<h3 class="hidden">공지목록</h3>
					<script type="text/javascript">
						window.addEventListener("load",function(e){
							
							var moreButton = document.querySelector("#more-button");
							
							var notices = [
								{code:"1",title:"아"},
								{code:"2",title:"ㅅㅂ"},
								{code:"3",title:"ㅈ같다"}
							];
							
							moreButton.onclick=function(){
								var template =document.querySelector("#notice-row");
								
								for(var i in notices){
								var tbody = document.querySelector(".notice-table tbody");
								var tds=template.content.querySelectorAll("td");
								
								tds[0].innerText = notices[i].code;
								tds[1].innerText = notices[i].title;
								
								var clone = document.importNode(template.content, true);
								tbody.appendChild(clone);
								}
							};
														
						});
					</script>
					<table class="table notice-table">
						<thead>
							<tr>
								<td>번호</td>
								<td>제목</td>
								<td>내용</td>
								<td>작성자</td>
								<td>작성일</td>
								<td>조회수</td>
							</tr>
						</thead>
						<tbody>
						<template id="notice-row">
							<tr>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
						</template>
						<%for(NoticeView v: list){ %>
							<tr>
								<td><%=v.getCode() %> </td>
								<td><%=v.getTitle() %> </td>
								<td><%=v.getContent() %></td>
								<td><%=v.getWriter() %></td>
								<td><%=v.getRegDate() %> </td>
								<td><%=v.getHit() %> </td>
							</tr>
							<%} %>
 						</tbody>
					</table>
				</div>
			
				<%
					int last = (size%10)>0 ? size/10+1 : size/10;
				
				%>
				
				<div class="margin"><%=pg %>/<%=last %> pages</div>
				
				<div class="margin">
               	<div><a href="">이전</a></div>
	               <ul>
	                  <%for(int i=0;i<last;i++){ %>
	                  <li><a href="?p=<%=i+1 %>&f=<%=field %>&q=<%=query %>"><%=i+1 %></a></li>
	                  <%} %>
	               </ul>
	             <div><a href="">다음</a></div>
            	</div> 
            	
            	<div>
            		<a href="notice-reg.jsp">글쓰기</a>
            		<span id="more-button">더보기</span>
            	</div>
			</main>
			
		</div>
	</div>

	<!-- -------footer----------------------------------------------------------- -->
	<footer id="footer">
		<div class = "content-container">
		<h2>회사정보</h2>
	
		<div>주소서울특별시 마포구 토정로35길 11, 인우빌딩 5층 266호관리자메일admin@newlecture.com사업자 등록번호132-18-46763 통신 판매업 신고제 2013-서울강동-0969 호 상호뉴렉처대표박용우전화번호070-4206-4084 [죄송합니다. 당분간 문의내용은 고개센터 메뉴에서 1:1 문의를 이용해주시기 바랍니다]</div>
		<div>Copyright ⓒ newlecture.com 2012-2014 All Right Reserved. Contact admin@newlecture.com for more information</div>
		</div>
	</footer>
	
	<!-- <section id = "quick-menu">
					<h2>퀵메뉴</h2>
				</section> -->


</body>
</html>

