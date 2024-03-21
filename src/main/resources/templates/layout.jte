@import de.lakinator.lakijtesite.model.PageContext
@import de.lakinator.lakijtesite.model.UserDTO
@import gg.jte.Content

@param PageContext pageContext
@param Content content
@param Content footer

<%-- local variables --%>
!{UserDTO user = pageContext.user();}

<!DOCTYPE html>
<html lang="de">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <%--  HMTX  --%>
    <script src="https://unpkg.com/htmx.org@1.9.10"
            integrity="sha384-D1Kt99CQMDuVetoL1lrYwg5t+9QdHe7NLX/SoJYkXDFfX37iInKRy5xLSi8nO7UC"
            crossorigin="anonymous">
    </script>

    <%--  BeerCss  --%>
    <link href="https://cdn.jsdelivr.net/npm/beercss@3.5.1/dist/cdn/beer.min.css" rel="stylesheet"/>
    <script type="module" src="https://cdn.jsdelivr.net/npm/beercss@3.5.1/dist/cdn/beer.min.js"></script>
    <script type="module"
            src="https://cdn.jsdelivr.net/npm/material-dynamic-colors@1.1.0/dist/cdn/material-dynamic-colors.min.js"></script>

    <%--    <link rel="stylesheet" href="css/custom.css">--%>

    @if(pageContext.description() != null)
        <meta name="description" content="${pageContext.description()}">
    @endif
    <title>${pageContext.title()}</title>
</head>
<body class="dark">

<%-- App bar --%>

<%--<header>--%>
<%--    <nav>--%>
<%--        <h5 class="max center-align">${pageContext.title()}</h5>--%>
<%--        --%><%--        <button class="circle transparent">--%>
<%--        --%><%--            <img class="responsive" src="/favicon.png">--%>
<%--        --%><%--        </button>--%>
<%--    </nav>--%>
<%--</header>--%>

<%-- Sidebar vor large screens --%>

<nav class="left drawer l">
    <header>
        <nav>
            <%--            <img src="https://www.beercss.com/favicon.png" class="circle">--%>
            <h6>Laki</h6>
        </nav>
    </header>
    <a href="/">
        <i>home</i>
        <div>Home</div>
    </a>
    <a href="/visitors">
        <i>emoji_people</i>
        <div>Besucher</div>
    </a>
    <div class="divider"></div>
    <label>Nutzer</label>
    @if (user == null)
        <a href="/login">
            <i>login</i>
            <div>Login</div>
        </a>
        <a href="/registration">
            <i>app_registration</i>
            <div>Registrieren</div>
        </a>
    @else
        <a href="/logout">
            <i>logout</i>
            <div>Logout</div>
        </a>
    @endif
</nav>

<%-- Sidebar for small/medium screens --%>

<nav class="bottom m s">
    <a href="/">
        <i>home</i>
        <span>Home</span>
    </a>
    <a href="/visitors">
        <i>emoji_people</i>
        <span>Besucher</span>
    </a>
    @if (user == null)
        <a href="/login">
            <i>login</i>
            <span>Login</span>
        </a>
        <a href="/registration">
            <i>app_registration</i>
            <span>Registrieren</span>
        </a>
    @else
        <a href="/logout">
            <i>logout</i>
            <span>Logout</span>
        </a>
    @endif
</nav>

<%-- Content --%>

<main class="responsive">
    @if (content != null)
        ${content}
    @else
        <h3>Willkommen!</h3>
        <div class="row">
            <h5>Under construction</h5>
            <i class="extra">construction</i>
        </div>
    @endif
</main>

<%-- Footer --%>

<footer class="fixed responsive max">
    <div class="small-divider"></div>
    <div class="responsive">
        @if (footer != null)
            ${footer}
        @else
            <p>Here would be a footer if it wasn't empty!</p>
        @endif
    </div>
</footer>

</body>
</html>