<html>
<head>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script type="text/javascript" src="/news/resources/news_with_comments_js.js"></script>
</head>
<body>
    <div>
        Title news:
        <br>
        <input id="title_news" name="title" type="text" value="" maxlength="255" disabled>
    </div>
    <div>
        Content of news:
        <br>
        <textarea id="text_news" name="text" cols="100" rows="5" disabled></textarea>
    </div>
    <div>
        Author:
        <br>
        <input id="author" name="author" type="text" value="" disabled>
    </div>
    <div>
        Date:
        <br>
        <input id="date_news" name="date" type="date" value="" disabled>
    </div>
    <br><br>
    <h3>Comments</h3>
        <input type="button" id="add-comment-button" value="Add comment" onclick="addComment();"/>
        <br>
        <div id="comments">

        </div>
</body>
</html>
