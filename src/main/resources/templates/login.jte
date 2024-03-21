@import de.lakinator.lakijtesite.model.PageContext
@import de.lakinator.lakijtesite.registration.AuthenticationUserDTO

@param PageContext pageContext
@param AuthenticationUserDTO user = null
@param String[] passwordErrors = new String[]{}
@param Boolean loginError = false

@template.layout(pageContext = pageContext,
content = @`
    <article>

        <div class="row">
            <i class="large">login</i>
            <div class="max">
                <h5>Login</h5>
                @if(loginError)
                    <p class="error">Falsches Passwort!</p>
                @endif
            </div>
        </div>

        <div class="medium-space"></div>

        <form action="/login" method="POST">

            <%-- Username input --%>
            <div class="s12 field label border">
                <input value="${user != null ? user.username() : ""}"
                       type="text" id="nameInput" name="username"
                       minlength="4" maxlength="32" required>
                <label for="nameInput">Nutzername</label>
            </div>

            <%-- Password input --%>
            <div class="field label border ${passwordErrors.length > 0 ? "invalid" : ""}">
                <input type="password" id="passwordInput" name="password"
                       minlength="6" maxlength="32" required>
                <label for="passwordInput">Passwort</label>
                @for(String passwordError : passwordErrors)
                    <span class="error">${passwordError}</span>
                @endfor
            </div>

            <button type="submit">Submit</button>
        </form>

    </article>
`,
footer = @`
    <p>Have fun!</p>
`
)