$(document).ready(function () {
    $('.registerForm').css('display','none');


    $('#goToRegister').click(function (e) { 
        e.preventDefault();
        goToRegister();
    });

    $('#goToLogin').click(function (e) { 
        e.preventDefault();
        goToLogin();
    });
});

function goToRegister(){
    $('.loginForm').addClass('animate__fadeOut')
    setTimeout(() => {
        $('.loginForm').removeClass('animate__fadeOut')
        $('.loginForm').css('display','none');
        $('.registerForm').css('display','block');
        $('.registerForm').addClass('animate__fadeIn')
    },1000);
}

function goToLogin(){
    $('.registerForm').addClass('animate__fadeOut')
    setTimeout(() => {
        $('.registerForm').removeClass('animate__fadeOut')
        $('.registerForm').css('display','none');
        $('.loginForm').css('display','block');
        $('.loginForm').addClass('animate__fadeIn')
    },1000);
}