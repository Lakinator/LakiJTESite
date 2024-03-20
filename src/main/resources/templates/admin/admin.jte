@import de.lakinator.lakijtesite.admin.AdminDetailDTO
@import de.lakinator.lakijtesite.model.PageContext
@import de.lakinator.lakijtesite.persistence.model.User
@import java.util.Arrays

@param PageContext pageContext
@param AdminDetailDTO details

@template.layout(pageContext = pageContext,
content = @`
    <hr>
    <section>
        <header>
            <h2>Admin view</h2>
            <p>lmao</p>
        </header>
        <table>
            <thead>
            <tr>
                <th>Username</th>
                <th>Display Name</th>
                <th>E-Mail</th>
                <th>Passwort</th>
                <th>Rollen</th>
                <th>Letzter Login</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody hx-target="closest tr" hx-swap="outerHTML">
            @for(User user : details.userList())
                @template.admin.singleUserView(user = user)
            @endfor
            </tbody>
        </table>
    </section>
`,
footer = @`
    <p>Thanks for visiting, come again soon!</p>
`
)