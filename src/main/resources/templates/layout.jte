@import de.lakinator.lakijtesite.model.PageContext
@import gg.jte.Content

@param PageContext pageContext
@param Content content
@param Content footer

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://unpkg.com/mvp.css">
    <link rel="stylesheet" href="css/custom.css">
    @if(pageContext.description() != null)
        <meta name="description" content="${pageContext.description()}">
    @endif
    <title>${pageContext.title()}</title>
</head>
<body>
<header>
    <h1>${pageContext.title()}</h1>
</header>
@if (content != null)
    <main>
        ${content}
    </main>
@else
    <main>
        <p>Got to the visitor page <a href="/visitors">here</a></p>
    </main>
@endif
@if (footer != null)
    <footer>
        ${footer}
    </footer>
@else
    <footer>
        <p>Here would be a footer if it wasn't empty!</p>
    </footer>
@endif
</body>
</html>