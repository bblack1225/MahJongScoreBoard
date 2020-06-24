//$(document).ready(function () {
//	$('#editMember').click(function(){
//		alert("edit")
//	})
//})

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
			showMemberRecords(response, score,memberId);
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
		if(i == 0){
			inner += `<span><i class="fas fa-crown" style="color: yellow;"></i></span>`;
		}
		if(i == 1){
			inner += `<span><i class="fas fa-medal" style="color: silver;></i></span>`;
		}
		if(i == response.length - 1){
			inner += `<span><i class="fas fa-poop" style="color: brown; padding-left:5px;"></i></span>`;
		}
		inner += `<div class="name" id=` + response[i].memberId + `>`
				+ response[i].memberName + `</div>`;
		inner += `<div class='score animate__animated'>` + response[i].score
				+ `</div>`;
		inner += `</div>`
	}
	scoreBox.html(inner);
}

// 該名成員的紀錄
function showMemberRecords(response, score,memberId) {
	let memberName = $('#' + memberId).text();
	let recordBox = $('#memberBox');
	let inner = "";
	inner += `<div id="memberNameBox">`
	inner += `<div id="memberName">` + memberName + `</div>`;
	inner += `<a href="#" onclick='editMember( `+memberId +`)' id="edit">`+ "編輯" +`</a><a href="#" onclick="confirmMember(`+memberId+`)" id="confirm" style="display:none;">`+ "確定" +`</a></div>`;
	inner += `<div id="memberScore">` + "分數: " +score + `</div>`;
	// key為種類 value為次數
	inner += `<div id="specialType">`
	$.map(response, function(value, key) {
			inner += `<div class="singleType">`;
			inner += `<div class="typeName">` + key+ `:</div>`;
			inner += `<div id="typeCount">` + value + `次</div>`;
			inner += `</div>`;
	})
	 inner += `</div>`;
	 recordBox.html(inner);
}

//編輯個人檔案(改名及刪除隊員)
function editMember(memberId){
	let memberName = document.getElementById('memberName');
	let editButton = document.getElementById('edit');
	let confirmButton = document.getElementById('confirm');
	memberName.innerHTML = '<input type="text" id="editInput" value="'+ memberName.innerText +'" style="font-size:18px;">';
	editButton.style.display = 'none';
	confirmButton.style.display = 'block';
}

//確認 有設計兩個按鈕 一個是編輯、一個是確定，在不同狀態下切換
function confirmMember(memberId){
//	let memberId = 
	let memberName = document.getElementById('memberName');
	let editInput = document.getElementById('editInput');
	let newName = editInput.value;
	let editButton = document.getElementById('edit');
	let confirmButton = document.getElementById('confirm');
	//把原本的input框改為原本的div
	memberName.innerText = newName;
	confirmButton.style.display = 'none';
	editButton.style.display = 'block';
	xhr = new XMLHttpRequest();
	$.ajax({
		url : '/member/editMemberName/' + newName + '/' + memberId,
		method : 'POST',
		success : function() {
		},
		error : function(data) {
			alert("發生錯誤")
		}
	});
}
