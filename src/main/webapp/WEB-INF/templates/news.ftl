<html>
<head>

</head>
<h1>News</h1>
<body>
    <#list news  as cur_news>
        <div class="news" style="border: darkgray">
            <div class="title">
                ${cur_news.title}
            </div>

            <div class="content">
                ${cur_news.text}
            </div>
            <br>
        </div>
    </#list>

    <div class="pagination">
        <#list pageCount as pageNum>
            <#if currentPage == pageNum>
                [<a href="/news/index/${pageNum}">${pageNum}</a>]
            <#else>
            <a href="/news/index/${pageNum}">${pageNum}</a>
            </#if>
        </#list>
    </div>

</body>
</html>