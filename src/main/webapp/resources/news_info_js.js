$(document).ready(function () {

        var xhr = new XMLHttpRequest();
        xhr.open('GET', '/news/ajax/' + getRequestParam(), true);
        xhr.send();
        xhr.onreadystatechange = function () {
            if (this.readyState != 4) {
                return;
            }
            if (this.status != 200) {
                alert('ошибка: ' + (this.status ? this.statusText : 'запрос не удался'));
                return;
            }
            if (this.responseText !== '') {
                var responce = JSON.parse(this.responseText);
                $('#id').attr('value', responce.id);
                $('#title').html('Change for "' + responce.title + '"');
                $('#title_news').attr('value', responce.title);
                $('#text_news').html(responce.text);
                $('#author').attr('value', responce.author.name);
                var date = new Date(responce.date);
                var month = ('0' + (date.getMonth() + 1)).slice(-2);
                var days = ('0' + (date.getDate())).slice(-2);
                $('#date_news').attr('value', date.getFullYear() + '-' + month + '-' + days);

            } else {
                $('#title').html('Add news');
            }
        };

    function getRequestParam() {
        var href = window.location.pathname;
        var arrayVar = [];
        arrayVar = href.substr(1).split('/');
        return arrayVar[1];
    }
});