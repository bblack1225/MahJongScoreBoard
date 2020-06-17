$(document).ready(function () {

    checkRank();
   
    $('.checkBtn').click(function (e) { 
        e.preventDefault();
        changeRecord();
    });
});

//改變數值
function changeRecord(){
    var score = parseInt($('.addScore').val())
    var memberOption = $('.memberOption option:selected').val()

    var memberScore = parseInt($('#' + memberOption).next().text())
    var newScore = (memberScore + score)
    $('#' + memberOption).next().text(newScore);
}

function checkRank(){
    var members = new Array();
    var score = new Array();
    var map = new Map();

    $('.member').each(function () {
        var name = $(this).find('.name').text();
        var scores = $(this).find('.score').text();
        members.push(name);
        score.push(scores);
    });
}