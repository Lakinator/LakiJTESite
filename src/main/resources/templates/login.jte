@import de.lakinator.lakijtesite.model.PageContext
@import de.lakinator.lakijtesite.model.AuthenticationUserDTO

@param PageContext pageContext
@param AuthenticationUserDTO user = null
@param String[] passwordErrors = new String[]{}

@template.layout(pageContext = pageContext,
content = @`
    <section>
        <form action="/login" method="POST">
            <header>
                <h2>Login Form</h2>
            </header>

            <%-- Username input --%>
            <label for="nameInput">Username:</label>
            <input value="${user != null ? user.username() : ""}"
                   type="text" id="nameInput" name="username" placeholder="Username"
                   minlength="4" maxlength="32" required>

            <%-- Password input --%>
            <label for="passwordInput">Password:</label>
            <input type="password" id="passwordInput" name="password"
                   minlength="6" maxlength="32" required>
            @for(String passwordError : passwordErrors)
                <p class="invalid-message">${passwordError}</p>
            @endfor

            <button type="submit">Submit</button>
        </form>
    </section>
`,
footer = @`
    <p>Have fun!</p>
`
)