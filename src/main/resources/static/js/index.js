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
        checkAccountEmpty();
        checkPswd();
    });

    //帳號blur完有沒有輸入
    $('.accountInput').blur(function (e) {
        e.preventDefault();
        checkAccountEmpty();
    });

    //團名blur完有沒有輸入
    $('.groupName').blur(function (e) {
        e.preventDefault();
        checkGroupEmpty();
    });

    //檢查是不是都有輸入，或是帳號重複的部分
    $('.submitBtn').click(function (e) { 
        e.preventDefault();
        checkPswdEmpty();
        checkAccountEmpty();
        checkGroupEmpty();
    });

    //登入檢查
    $('#loginBtn').click(function(e){
        e.preventDefault();
        checkloginEmpty();
    })

    $('.loginAccount').blur(function(){
    	blurloginEmpty();
    })

    $('.loginpassword').blur(function(){
    	blurloginEmpty();
    })
});

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
    if(loginAccount == ''){
        $('.loginAccountEmpty').css('display','block')
    }else{
        $('.loginAccountEmpty').css('display','none')
    }
    if(loginPassword == ''){
        $('.loginPasswordEmpty').css('display','block')
    }else{
        $('.loginPasswordEmpty').css('display','none')
    }
}

//檢查兩個密碼輸入框是否相同的方法
function checkPswd(){
    var password = $('.passwordInput').val();
    var checkPassword = $('#checkPswd').val();

    if(password != '' && password != checkPassword){
        $('.errorPasswordEmpty').css('display','none')
        $('.errorPassword').css('display','block');
        $('#checkPswd').val('');
    }else{
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

    if(password == '' || checkPassword == ''){
        $('.errorPassword').css('display','none');
        $('.errorPasswordEmpty').css('display','block')
    }else{
        $('.errorPasswordEmpty').css('display','none')
    }
}

//檢查團名是否空白
function checkGroupEmpty(){
    var groupName = $('.groupName').val();
    if(groupName == ''){
        $('.errorGroupEmpty').css('display','block')
    }else{
        $('.errorGroupEmpty').css('display','none')
    }
}