var user_name;
var user_pw1;
var user_pw2;

function Intent_Register(){

	//alert("Click!")

	user_name=document.getElementById("UserName").value;
	user_pw1=document.getElementById("UserPW1").value;
	user_pw2=document.getElementById("UserPW2").value;

	/*alert("User_Name:"+user_name)
	alert("User_pw1:"+user_pw1)
	alert("User_pw2:"+user_pw2)*/

	if(user_pw1==""){
		alert("密码不能为空！")
		return;
	}

	if(user_name==""){
		alert("昵称不能为空！")
		return;
	}

	if(user_pw1!=user_pw2){

		alert("两次输入用户密码不一致，请重新输入！")
		document.getElementById("UserPW1").value="";
		document.getElementById("UserPW2").value="";
		return;

	}else{

		document.getElementById("RegisterForm").submit();

	}
}
