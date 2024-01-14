@import de.lakinator.lakijtesite.model.PageContext
@import de.lakinator.lakijtesite.model.UserDTO

@param PageContext pageContext
@param UserDTO user = null
@param String[] usernameErrors = new String[]{}
@param String[] passwordErrors = new String[]{}

@template.layout(pageContext = pageContext,
content = @`
    <form action="/registration" method="POST">
        <header>
            <h2>Registration Form</h2>
        </header>
        <%-- Username input --%>
        <label for="nameInput">Username:</label>
        <input class="${usernameErrors.length != 0 ? "invalid-field": ""}"
               value="${user != null ? user.getName() : ""}"
               type="text" id="nameInput" name="name" placeholder="Username"
               minlength="4" maxlength="32" required>
        @for(String usernameError : usernameErrors)
            <p class="invalid-message">${usernameError}</p>
        @endfor

        <%-- E-Mail input --%>
        <label for="mailInput">E-Mail</label>
        <input value="${user != null ? user.getEmail() : ""}"
               type="email" id="mailInput" name="email" placeholder="test@example.com" required>

        <%-- Password input --%>
        <label for="passwordInput">Password:</label>
        <input value="${user != null ? user.getPassword(): ""}" type="password" id="passwordInput" name="password"
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
`,
footer = @`
    <p>have fun registering!</p>
`
)