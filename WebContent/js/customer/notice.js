/**
 * 
 */
window.addEventListener("load", function(){
	var btnResult=document.getElementById("btn-result");
	btnResult.onclick=result;
	
	function result(){
 		var x,y;
 	 	x=prompt("x값을 입력하세요");
 	 	y=prompt("y값을 입력하세요");
 	 	x=parseInt(x);
 	 	y=parseInt(y);
 	 	btnResult.value=x+y;		
 	}
});
/* window.onload=function(){
var h1=document.querySelector("#header > div:first-child > h1");
h1.onclick=function(){
	/* alert("hello"); */
/* 	h1.style.border="1px solid red";
};
} */ 
/* var x;
alert(x== undefined); */
/* var exam =new Object(); */
/* var exam={}; */
/* var student = {
	name : "홍길동",
	age : 19,
	"취미" : ["코딩","공부","수학"]
}; */
/* exam.kor=30; 
/*expand object*/
/* exam.eng=30; */
/*exam.math=30; */
/* alert(exam.kor); /*유효하면 이걸로*/
/* alert(exam["kor a"]);  */
/* alert(student["취미"][1]); */
/* alert(3+4.5); */
/* alert(3.5-"2"); */
/* alert("32">"4"); */
/* alert(32>"4"); */
/* var exam={
kor:30,
eng:40,
math:50
};
var ar=["철수","영희","맹구","동찬"];
for(var i in exam)
alert(exam[i]); //exam["kor"] */
/* var add= new Function("x,y","return x+y;");

alert(add(3,4)); */

/* var add = function(x,y){
return x+y; /*argument[0]+argument[1];*/
/* } */
/* alert(add(3,4));

*//* function add(x,y){
return x+y;
}
alert(add(3,4)); ->이건 최악.. */
/* alert(add(3)); /* NaN*/
/* alert(add(3,4,5,6,7)); */
/* var add=function(){
var sum=0;
for(var i in arguments)
	sum+=arguments[i];

return sum;
}
alert(add(3,6,9)); */

/* alert(a);
var a=1; */ //undefined
/* a=1; */
/*alert(a);*/
/* alert(a);
a=1; *///이러면 error....변수 선언된게 아니니..
/* var a=1;
var a=2;
alert(a); */ //에러 안 남 또선언해도 된다는거
/* {
var a=1;
}
alert(a); */ //자바같음 에러인데;;
/* function f1(){
a=1;
} */
//f1();
//alert(a);  //(var있으면)에러  a는 함수 안에서만 선언된..
/* function f1(){
var a=1;
return function f2(){
	return a; //앞의 return으로 사라진다해도 이 return때문에 죽지않고 살아 남는..->f2 function 때문 이걸ㅋㅋ 클로저(Closure)라고 한다ㅏ.ㄴ
}
}
var f=f1(); //f는 function f2(객체)를 받은격
var a=f();
alert(a); //??에러가 아니네 ㅋㅋ

function f1(){
var a=1;
return a;
}		

var a=f1();
alert(a);
*/

/* var x=3;
document.write(x); */ // == window.document.write(x);

/* function result(){
	var x,y;
	x=prompt("x값을 입력하세요");
	y=prompt("y값을 입력하세요");
	/* alert(typeof x); */
	//x=parseInt(x);
	//y=parseInt(y);
	/* alert(typeof x); */
	//dd.value=x+y; //prompt는 문자로 인식되네 	 	 		
//} */
