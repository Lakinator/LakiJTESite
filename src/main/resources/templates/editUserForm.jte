@import de.lakinator.lakijtesite.persistence.model.User

@param User user

<tr>
    <td><input name='name' value='${user.getUsername()}'></td>
    <td><input name='email' value='${user.getEmail()}'></td>
    <td>
        <button hx-get="/admin/user/${user.getUsername()}">
            Cancel
        </button>
        <button hx-put="/admin/user/${user.getUsername()}" hx-include="closest tr">
            Save
        </button>
    </td>
</tr>