<html>
<head>

</head>
<h1>News</h1>
<body>
    <#list news  as cur_news>
        <div class="news" style="border: darkgray">
            <div class="title">
                <input type="text" value="${cur_news.title}">
            </div>

            <div class="content">
                <textarea cols="100" rows="5">${cur_news.text}</textarea>
            </div>

            <div class="more_reference">
                <a href="/news/${cur_news.id}">edit</a>
                <a href="/news/more/${cur_news.id}">more</a>
            </div>
            <br>
        </div>
    </#list>

    <div class="pagination">
        <#list pageCount as pageNum>
            <#if currentPage == pageNum>
                [<a href="${pageNum}">${pageNum}</a>]
            <#else>
            <a href="${pageNum}">${pageNum}</a>
            </#if>
        </#list>
    </div>

</body>
</html>