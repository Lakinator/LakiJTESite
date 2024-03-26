@import de.lakinator.lakijtesite.admin.AdminDetailDTO
@import de.lakinator.lakijtesite.model.PageContext
@import de.lakinator.lakijtesite.persistence.model.User

@param PageContext pageContext
@param AdminDetailDTO details

@template.layout(pageContext = pageContext,
content = @`
    <header>
        <h2>Admin view</h2>
        <p>lmao</p>
    </header>
    <div class="grid">
        @for(User user : details.userList())
            @template.admin.singleUserView(user = user)
        @endfor
    </div>
    <div id="editUserDialogContainer"></div>
`,
footer = @`
    <p>Thanks for visiting, come again soon!</p>
`
)