@import de.lakinator.lakijtesite.registration.AuthenticationUserDTO
@import de.lakinator.lakijtesite.model.PageContext

@param PageContext pageContext
@param AuthenticationUserDTO user = null
@param String[] usernameErrors = new String[]{}
@param String[] passwordErrors = new String[]{}

@template.layout(pageContext = pageContext,
content = @`
    <section>
        <form action="/registration" method="POST">
            <header>
                <h2>Registration Form</h2>
                <p>Du kannst deinen Anzeigenamen später ändern!</p>
            </header>

            <%-- Username input --%>
            <label for="nameInput">Username:</label>
            <input class="${usernameErrors.length != 0 ? "invalid-field": ""}"
                   value="${user != null ? user.username() : ""}"
                   type="text" id="nameInput" name="username" placeholder="Username"
                   minlength="4" maxlength="32" required>
            @for(String usernameError : usernameErrors)
                <p class="invalid-message">${usernameError}</p>
            @endfor

            <%-- E-Mail input --%>
            <label for="mailInput">E-Mail</label>
            <input value="${user != null ? user.email() : ""}"
                   type="email" id="mailInput" name="email" placeholder="test@example.com" required>

            <%-- Password input --%>
            <label for="passwordInput">Password:</label>
            <input value="${user != null ? user.password(): ""}" type="password" id="passwordInput" name="password"
                   minlength="6" maxlength="32" required>

            <%-- Password confirmation input --%>
            <label for="passwordConfirmInput">Confirm password:</label>
            <input class="${passwordErrors.length != 0 ? "invalid-field": ""}"
                   type="password" id="passwordConfirmInput" name="passwordConfirm"
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