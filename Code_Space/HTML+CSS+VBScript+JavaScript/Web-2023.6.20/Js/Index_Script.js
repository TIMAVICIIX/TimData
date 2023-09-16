// JavaScript Document

var user_name;
var user_id;

var forumed_num;

/*class Contents{
	
	constructor(author,title,content,type,state,bool){
		
		this.author=author;
		this.title=title;
		this.content=content;
		this.type=type;
		this.state=state;
		this.bool=bool;
		
	}
	
}*/


function reLogin(){

	//alert("ReLogin!")
	
	var re_user_id=document.getElementById("re_user_id").value;
	var re_user_pw=document.getElementById("re_user_pw").value;
	
	if(re_user_id==""){
		alert("用户名不能为空")
		return;
	}

	if(re_user_pw==""){
		alert("用户密码不能为空")
		return;

	}
	
	document.getElementById("Login_Form").submit();
}


//修改发布内容到数据库
 function Upload_Forum(){

	//alert("uploading!")
	
	var forum_title=document.getElementById("forum_title").value;
	
	var forum_type=$('input[name="PassageORTip"]:checked').val();
	
	var forum_state=$('input[name="publish_state"]:checked').val();
	
	var forum_content=document.getElementById("Create_Content").value;
	
	
	
	if(forum_title==""){
		alert("标题不能为空")
		return;
	}
	
	if(forum_state==null||forum_type==null){
		alert("请选择完整的选项")
		return;
	}
	
	if(forum_content==""){
		alert("请输入内容")
		return;
	}
 
	if(user_name==null){
		alert("请登录后再操作")
		Create_Visible(0);
		Create_Visible(1);
		Create_Visible(1);
		return;
 }


	var form_intent=document.getElementById("Upload");
	//alert("Jump")
	form_intent.submit();
	
	
}

//改为上传数据库并刷新Frame页面
//author,title,content,type,state,bool
function reFresh_Index(){


	Loading_Info();
	
}


function Transfrom(index){
	
	var iframeUrl=index+'?User_Account='+user_id;

	document.getElementById("Center_frame").src=iframeUrl;
	
}

function Create_Visible(state){
	
	switch(state){
			
		case 0:
	
		var t0 = document.getElementById("Create_new_Forum");

				if(t0.style.visibility === 'hidden') {

					t0.style.visibility = 'visible';

				} else {

					t0.style.visibility = 'hidden';

				}
			
			break;
			
		case 1:
			
			var t1 = document.getElementById("Re_Login");

				if(t1.style.visibility === 'hidden') {

					t1.style.visibility = 'visible';

				} else {

					t1.style.visibility = 'hidden';

				}
			
			break;
			
		
	}
	
}


//监听Login界面发送的href
window.addEventListener('DOMContentLoaded',function(){

	var urlParams=new URLSearchParams(window.location.search);
	user_id=urlParams.get('user_id');
	user_name=urlParams.get('user_name');
	forumed_num=urlParams.get('user_forumed')

	var upload_state=urlParams.get('upload')
	var delete_state=urlParams.get('delete')
	var change_state=urlParams.get('update_state')

	var intent_view=urlParams.get('intent_view')

	if(upload_state=="success"){
		alert("上传成功")
	}

	if(delete_state=="sucess"){
		alert("删除成功")
	}

	if(change_state=="sucess"){
		alert("修改成功")
	}

	if(intent_view!=null){

	var iframeUrl=intent_view+'?User_Account='+user_id;

	document.getElementById("Center_frame").src=iframeUrl;

	}

	/*alert("user_name:"+user_name);
	alert("user_id:"+user_id);
	alert("forumed_num:"+forumed_num);*/

	Loading_Info();

	refresh_frame();


});


function refresh_frame() {

		

}

//加载界面
function Loading_Info(){

	document.getElementById("User_Name").innerHTML=user_name;
	document.getElementById("User_ID").innerHTML="账号:"+user_id;
	document.getElementById("Upload_id").value=user_id;
	document.getElementById("Forum_Count").innerHTML="上传数量："+forumed_num;

}
