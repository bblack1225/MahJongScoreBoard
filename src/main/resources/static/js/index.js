//我沒有使用input required的屬性，因為我覺得那個很醜，所以選擇自己寫，比較好看XDD

$(document).ready(function () {

    //一開始所有的欄位的錯誤訊息都先隱藏

    //登入
    $('.loginAccountEmpty').css('display','none')
    $('.loginPasswordEmpty').css('display','none')
    //註冊
    $('.errorAccount').css('display','none')
    $('.errorPassword').css('display','none')
    $('.errorAccountEmpty').css('display','none')
    $('.errorPasswordEmpty').css('display','none')
    $('.errorGroupEmpty').css('display','none')
    
    //檢查密碼是否相同
    $('#checkPswd').blur(function (e) {
        e.preventDefault();
        checkPswd();
    });

    //帳號blur完有沒有輸入
    $('.accountInput').blur(function (e) {
        e.preventDefault();
        var loginAccount = $('.accountInput').val();
        
        //如果帳號不是空的才去執行ajax檢查帳號的方法
        if(loginAccount != null){
        	checkSameAccount(loginAccount);
    	}
    });

    //團名blur完有沒有輸入
    $('.groupName').blur(function (e) {
        e.preventDefault();
        checkGroupEmpty();
    });

    //如果帳密input框在有空白錯誤的情況下blur開，如果有字了就離開
    $('.loginAccount').blur(function(){
    		blurloginEmpty();
    	})
    

    $('.loginpassword').blur(function(){
    	blurloginEmpty();
    })
    
});

//檢查帳號是否有重複
function checkSameAccount(loginAccount){
	xhr = new XMLHttpRequest();
	$.ajax({
	url : "/member/checkSameAccount?account=" + loginAccount,
	type : 'POST',
	success : function(response) {
		//如果從後端送來的資料為已重複，就顯示錯誤訊息
		if(response == '帳號已重複'){
			 $('.errorAccount').css('display','block');
		}else{
			$('.errorAccount').css('display','none');
		}
	}
});
}

//登入檢查
function goTologin(){
	checkloginEmpty();
}
//註冊檢查
function goRegister(){
	checkRegister();
}

//如果原本有錯誤訊息時，blur input視窗後座的檢查
function blurloginEmpty(){
    var loginAccount = $('.loginAccount').val();
    var loginPassword = $('.loginpassword').val();
    if(loginAccount != '' && $('.loginAccountEmpty').css('display') == 'block'){
        $('.loginAccountEmpty').css('display','none')
    }else if(loginPassword != '' && $('.loginPasswordEmpty').css('display') == 'block'){
        $('.loginPasswordEmpty').css('display','none')
    }
}

//登入鈕按下去後做的檢查
function checkloginEmpty(){
    var loginAccount = $('.loginAccount').val();
    var loginPassword = $('.loginpassword').val();
    if(loginAccount.trim() == ''){
        $('.loginAccountEmpty').css('display','block')
    }else{
        $('.loginAccountEmpty').css('display','none')
    }
    if(loginPassword.trim() == ''){
        $('.loginPasswordEmpty').css('display','block')
    }else{
        $('.loginPasswordEmpty').css('display','none')
    }
    
    if(loginAccount.trim() != '' && loginPassword.trim() != ''){
    	loginForm = document.getElementById('toLoginForm');
    	loginForm.action = "/member/checkLogin";
    	loginForm.method = "POST";
    	loginForm.submit();
    }
}

//註冊按下去時所做的檢查
function checkRegister(){
	var account = $('.accountInput').val();
	var password = $('.passwordInput').val();
    var checkPassword = $('#checkPswd').val();
    var groupName = $('.groupName').val();
    
    //如果帳號空白
    if(account.trim() == ''){
        $('.errorAccountEmpty').css('display','block')
    }else{
        $('.errorAccountEmpty').css('display','none')
    }
    //如果密碼空白
    if(password.trim() == '' || checkPassword.trim() == ''){
        $('.errorPassword').css('display','none');
        $('.errorPasswordEmpty').css('display','block')
    }else{
        $('.errorPasswordEmpty').css('display','none')
    }
    
    //如果團名空白
    if(groupName.trim() == ''){
        $('.errorGroupEmpty').css('display','block')
    }else{
        $('.errorGroupEmpty').css('display','none')
    }
    
    //如果去掉空白字元都沒有空白的話而且沒有錯誤的話，才會去註冊
    if(account.trim() != '' && password.trim() != '' && checkPassword.trim() != '' 
    	&& groupName.trim() != '' && $('.errorAccount').css('display') == 'none'){
    	registerForm = document.getElementById('registerForm');
	    registerForm.action = "/member/register";
	    registerForm.method = "POST";
	    registerForm.submit();
    }
}

//檢查兩個密碼輸入框是否相同的方法
function checkPswd(){
    var password = $('.passwordInput').val();
    var checkPassword = $('#checkPswd').val();

    if(password.trim() != '' && password != checkPassword){
        $('.errorPasswordEmpty').css('display','none')
        $('.errorPassword').css('display','block');
        $('#checkPswd').val('');
    }else{
    	 $('.errorPasswordEmpty').css('display','none')
        $('.errorPassword').css('display','none');
    }

}

//檢查帳號輸入框是否空白的方法
function checkAccountEmpty(){
    var account = $('.accountInput').val();

    if(account == ''){
        $('.errorAccountEmpty').css('display','block')
    }else{
        $('.errorAccountEmpty').css('display','none')
    }
}

//檢查密碼欄是否相同的方法，與比對密碼分開寫比較不會亂(我會亂)
function checkPswdEmpty(){
    var password = $('.passwordInput').val();
    var checkPassword = $('#checkPswd').val();

    if(password.trim() == '' || checkPassword.trim() == ''){
        $('.errorPassword').css('display','none');
        $('.errorPasswordEmpty').css('display','block')
    }else{
        $('.errorPasswordEmpty').css('display','none')
    }
}

//檢查團名是否空白
function checkGroupEmpty(){
    var groupName = $('.groupName').val();
    if(groupName.trim() == ''){
        $('.errorGroupEmpty').css('display','block')
    }else{
        $('.errorGroupEmpty').css('display','none')
    }
}