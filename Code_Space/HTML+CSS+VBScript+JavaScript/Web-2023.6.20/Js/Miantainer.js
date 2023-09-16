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



function Transfrom(index){
	
	var iframeUrl=index+'?User_Account='+user_id;

	document.getElementById("Center_frame").src=iframeUrl;
	
}

//监听Login界面发送的href
window.addEventListener('DOMContentLoaded',function(){

	var urlParams=new URLSearchParams(window.location.search);
	user_id=urlParams.get('user_id');
	user_name=urlParams.get('user_name');
	forumed_num=urlParams.get('user_forumed')

	var upload_state=urlParams.get('upload')
	var delete_state=urlParams.get('delete')
	var intent_view=urlParams.get('intent_view')


	var miantainer_id=urlParams.get('maintainer_id')

	alert(miantainer_id)

	if(upload_state=="success"){
		alert("上传成功")
	}

	if(delete_state=="sucess"){
		alert("删除成功")
	}

	if(miantainer_id=="success"){
		user_id=miantainer_id;

		alert("欢迎来到管理界面")
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
