// JavaScript Document

function Delete_Forum(forum_id){

	alert("删除文章ID："+forum_id)

	var temp_form=document.getElementById(forum_id);

	temp_form.action="../asp/Delete_Forum.asp";

	//alert(temp_form.value)

	temp_form.submit();

}

function Change_State(forum_id){


	alert("修改状态ID："+forum_id)

	var temp_form=document.getElementById(forum_id);

	temp_form.action="../asp/Change_State.asp";

	//alert(temp_form.value)

	temp_form.submit();

}