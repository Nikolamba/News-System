<html>
<head>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script type="text/javascript" src="/news/resources/news_info_js.js"></script>
</head>

<body>
<h1 id="title"></h1>

    <form action="/news/addnews" method="post">
        <input id="id" name="id" type="hidden" value="">
        <div>
            Title news:
            <br>
            <input id="title_news" name="title" type="text" value="" maxlength="255">
        </div>
        <div>
            Content of news:
            <br>
            <textarea id="text_news" name="text" cols="100" rows="5"></textarea>
        </div>
        <div>
            Author:
            <br>
            <input id="author" name="author" type="text" value="">
        </div>
        <div>
            Date:
            <br>
            <input id="date_news" name="date" type="date" value="">
        </div>
        <br>
        <input type="submit">
    </form>

</body>
</html>
