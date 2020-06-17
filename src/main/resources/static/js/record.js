//$(document).ready(function () {
//	
//	
//})

//新增會員
function addMembers(){
	let memberName = $('#newMemberName').val();
	alert(memberName);
	xhr = new XMLHttpRequest();
	$.ajax({
	url : '/member/addMembers?memberName=' + memberName,
	type : 'POST',
	success : function(response) {
		 $('#newMemberName').val('');
	}
});
}

//新增一筆紀錄
function addRecord(){
	alert("123")
	xhr = new XMLHttpRequest();
	$.ajax({
	url : '/record/addRecord',
	type : 'POST',
	success : function(response) {
		//如果從後端送來的資料為已重複，就顯示錯誤訊息
		
	}
});
}