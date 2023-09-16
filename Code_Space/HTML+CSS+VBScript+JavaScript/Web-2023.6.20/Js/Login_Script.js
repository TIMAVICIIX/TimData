// JavaScript Document

var user_id;
var user_pw;

document.onkeydown=function(event){
	
	if(event.keyCode==13){
		
		Intent_index();
		
	}
	
}

function Intent_index(){
	
	user_id=document.getElementById("user_id").value;
	user_pw=document.getElementById("user_pw").value;

	alert(user_id)
	
	if(user_id==""){
		
		alert("账号不能为空！")
		return;
		
	}
	
	if(user_pw==""){
			
			alert("密码不能为空！")
			return;
			
		}

		document.getElementById("LoginForm").submit();

			
}

function getUrlParameter(name) {
   name = name.replace(/[\[]/, '\\[').replace(/[\]]/, '\\]');
   var regex = new RegExp('[\\?&]' + name + '=([^&#]*)');
   var results = regex.exec(location.search);
   return results === null ? '' : decodeURIComponent(results[1].replace(/\+/g, ' '));
}

window.onload= function(){

	var UnLogin=getUrlParameter('state');

	

	if(UnLogin=="UnLogin"){

		alert("用户账号或密码错误！")

	}

}