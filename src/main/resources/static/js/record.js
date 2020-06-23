//$(document).ready(function () {
//	$('.member').click(function(){
//		let name = $(this).find('.name').text()
//		alert(name)
//	})
//}

//新增會員
function addMembers() {
	let memberName = $('#newMemberName').val();
	alert(memberName);
	xhr = new XMLHttpRequest();
	$.ajax({
		url : '/record/addMembers?memberName=' + memberName,
		method : 'POST',
		contentType : "application/json",
		dataType : 'JSON',
		success : function(response) {
			$('#newMemberName').val('');
			showMembers(response);
		}
	});
}

// 新增一筆紀錄
function addRecord() {
	let score = $('.addScore').val();
	let memberId = $('.memberOption').val();
	let type = $('.typeOption').val();
	let groupId = $('.hiddenGroupId').val();
	xhr = new XMLHttpRequest();
	$.ajax({
		url : '/record/addRecord?memberId=' + memberId + "&score=" + score
				+ "&typeId=" + type + "&groupId=" + groupId,
		method : 'POST',
		contentType : "application/json",
		dataType : 'JSON',
		success : function(response) {
			// 刷新input框框內的資料
			$('.addScore').val('');
			$('.memberOption').val('請選擇隊員');
			$('.typeOption').val('紀錄');
			showMembers(response);
		},
		error : function(data) {
			alert("發生錯誤")
		}
	});
}

function showRecords(memberId, score) {
	// let name = $(this).find('.name').text();
	// alert(name)
	xhr = new XMLHttpRequest();
	$.ajax({
		url : '/record/showRecords?memberId=' + memberId,
		method : 'POST',
		contentType : "application/json",
		dataType : 'JSON',
		success : function(response) {
			showMemberRecords(response, score);
		},
		error : function(data) {
			alert("發生錯誤")
		}
	});
}

// 重新呈現排行榜
function showMembers(response) {
	// response = JSON.parse(response);
	let scoreBox = $('.scoreBox');
	let inner = "";
	for (i = 0; i < response.length; i++) {
		// response[i].XXXX ---> 對應memberBean的性質
		inner += `<div class='member animate__animated animate__fadeIn' onclick="showRecords(`
				+ response[i].memberId + `,` + response[i].score + `)">`;
		inner += `<div class="name" id=` + response[i].memberId + `>`
				+ response[i].memberName + `</div>`;
		inner += `<div class='score animate__animated'>` + response[i].score
				+ `</div>`;
		inner += `</div>`
	}
	scoreBox.html(inner);
}

// 該名成員的紀錄
function showMemberRecords(response, score) {
	let recordBox = $('#memberBox');
	let inner = "";
//	let map = response;
	inner += `<div id="memberName">` + "安安" + `</div>`;
	inner += `<div id="memberScore">` + score + `</div>`;
//	inner += `<div id="specialType">`
//	for(i = 0 ;i<response.length;i++){
//		alert(response[i])
//		inner += `<div class="singleType">`;
//		inner += `<div class="typeName">` + "測試" + `:</div>`;
//		inner += `<div id="typeCount">` + response[i] + `次</div>`;
//		inner += `</div>`;
//	}
	// key為種類 value為次數
	inner += `<div id="specialType">`
	$.map(response, function(value, key) {
//		alert(key + " " + value);
//	$.each(JSON.parse(list), function(i, record) {
			inner += `<div class="singleType">`;
			inner += `<div class="typeName">` + key+ `:</div>`;
			inner += `<div id="typeCount">` + value + `次</div>`;
			inner += `</div>`;
	})
	 inner += `</div>`;
	 recordBox.html(inner);
}
