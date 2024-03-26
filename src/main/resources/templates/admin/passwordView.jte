@import de.lakinator.lakijtesite.persistence.model.User

@param User user

<p>Nutzername: ${user.getUsername()}</p>
<p>Passwort: ${user.getPassword()}</p>
<button class="transparent circle small"
        hx-trigger="click"
        hx-get="/admin/user/${user.getUsername()}/password-obscured"
        hx-target="closest div"
        hx-swap="innerHTML">
    <i>lock_open</i>
</button>