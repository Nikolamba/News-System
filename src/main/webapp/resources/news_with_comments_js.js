$(document).ready(function () {
    getComments();
});

function getComments() {
    var xhr = new XMLHttpRequest();
    xhr.open('GET', '/news/ajax/' + getRequestParam(), true);
    xhr.send();
    xhr.onreadystatechange = function () {
        if (this.readyState !== 4) {
            return;
        }
        if (this.status !== 200) {
            alert('ошибка: ' + (this.status ? this.statusText : 'запрос не удался'));
            return;
        }
        var responce = JSON.parse(this.responseText);
        $('#title_news').attr('value', responce.title);
        $('#text_news').html(responce.text);
        $('#author').attr('value', responce.author.name);
        var date = new Date(responce.date);
        var month = ('0' + (date.getMonth() + 1)).slice(-2);
        var days = ('0' + (date.getDate())).slice(-2);
        $('#date_news').attr('value', date.getFullYear() + '-' + month + '-' + days);

        $.each(responce.comments, function () {
            $('#comments').append("<textarea cols='100' rows='3' disabled>" + this.text + "</textarea><br><br>");
        });
    };
}

function getRequestParam() {
    var href = window.location.pathname;
    var arrayVar = [];
    arrayVar = href.substr(1).split('/');
    return arrayVar[2];
}

function addComment() {
    $('#comments').prepend("<textarea id='text' name='text' cols='100' rows='5'/>"
        + "<input id='newsId' type='hidden' name='newsId' value='" + getRequestParam() + "'>"
        + "<br><input type='button' id='sendComment' value='Send comment' onclick='sendComment()'><br>");
}

function sendComment() {
    var xhr = new XMLHttpRequest();
    var params = 'newsId=' + $('#newsId').val() + '&text=' + $('#text').val();
    xhr.open('POST', '/news/addcomment/', true);
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send(params);
    xhr.onreadystatechange = function () {
        if (this.readyState !== 4) {
            return;
        }
        if (this.status !== 200) {
            alert('ошибка: ' + (this.status ? this.statusText : 'запрос не удался'));
            return;
        }
        $('#comments').empty();
        getComments();
    }
}

