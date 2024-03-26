@import de.lakinator.lakijtesite.persistence.model.User
@import java.util.Arrays

@param User user

<div class="s12 m6 s3">
    <article>
        <div>
            <nav>
                <h5>${user.getDisplayName()}</h5>
                <div class="max"></div>
                <button class="border circle"
                        hx-trigger="click"
                        hx-get="/admin/user/${user.getUsername()}/edit-dialog"
                        hx-target="#editUserDialogContainer">
                    <i>edit</i>
                </button>
                <button class="border circle"
                        hx-trigger="click"
                        hx-get="/admin/user/${user.getUsername()}/delete-dialog"
                        hx-target="#editUserDialogContainer">
                    <i>delete</i>
                </button>
            </nav>
            <div class="row">
                @template.admin.passwordObscuredView(user = user)
            </div>
            <p>E-Mail: ${user.getEmail()}</p>
            <p>Rollen: ${Arrays.toString( user.getRoles().toArray() )}</p>
            <p>Letzter Login: ${user.getLastLogin().toString()}</p>
        </div>
    </article>
</div>