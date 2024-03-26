@import de.lakinator.lakijtesite.persistence.model.User

@param User user

<p>Nutzername: ${user.getUsername()}</p>
<p>Passwort: ***</p>
<button class="transparent circle small"
        hx-trigger="click"
        hx-get="/admin/user/${user.getUsername()}/password"
        hx-target="closest div"
        hx-swap="innerHTML">
    <i>lock</i>
</button>