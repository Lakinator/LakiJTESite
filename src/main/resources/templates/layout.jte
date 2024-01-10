@import de.lakinator.lakijtesite.model.PageContext
@import gg.jte.Content

@param PageContext pageContext
@param Content content
@param Content footer

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../static/css/mvp.css">
    <link rel="stylesheet" href="../static/css/custom.css">
    @if(pageContext.description() != null)
        <meta name="description" content="${pageContext.description()}">
    @endif
    <title>${pageContext.title()}</title>
</head>
<body>
<h1>${pageContext.title()}</h1>
@if (content != null)
    <div class="content">
        ${content}
    </div>
@else
    <div>
        <p>Got to the visitor page <a href="/visitors">here</a></p>
    </div>
@endif
@if (footer != null)
    <div class="footer">
        ${footer}
    </div>
@else
    <div class="footer">
        <p>Here would be a footer if it wasn't empty!</p>
    </div>
@endif
</body>
</html>