@import de.lakinator.lakijtesite.model.PageContext
@import de.lakinator.lakijtesite.model.UserDTO
@import gg.jte.Content

@param PageContext pageContext
@param Content content
@param Content footer

<%-- local variables --%>
!{UserDTO user = pageContext.user();}

<!DOCTYPE html>
<html lang="en" color-mode="user">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://unpkg.com/mvp.css">
    <link rel="stylesheet" href="css/custom.css">
    @if(pageContext.description() != null)
        <meta name="description" content="${pageContext.description()}">
    @endif
    <title>${pageContext.title()}</title>
</head>
<body>
<header>
    <nav>
        <a href="/">Home</a>
        <ul>
            <li><a href="/visitors">Visitors</a></li>
            @if (user != null)
                <li>Logged in as ${user.username()}</li>
                <li><a href="/logout"><b>Logout →</b></a></li>
            @else
                <li><a href="/registration">Register</a></li>
                <li><a href="/login"><b>Login</b></a></li>
            @endif
        </ul>
    </nav>
    <h1>${pageContext.title()}</h1>
</header>
@if (content != null)
    <main>
        ${content}
    </main>
@else
    <main>
        <p>Got to the login page <a href="/login">here</a></p>
        <p>Got to the registration page <a href="/registration">here</a></p>
        <p>Got to the visitor page <a href="/visitors">here</a></p>
    </main>
@endif
@if (footer != null)
    <footer>
        <hr>
        ${footer}
    </footer>
@else
    <footer>
        <hr>
        <p>Here would be a footer if it wasn't empty!</p>
    </footer>
@endif
</body>
</html>