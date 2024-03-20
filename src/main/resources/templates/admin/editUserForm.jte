@import de.lakinator.lakijtesite.persistence.model.User
@import de.lakinator.lakijtesite.security.UserRole

@param User user

<tr>
    <td>${user.getUsername()}</td>
    <td><input name='displayName' value='${user.getDisplayName()}'></td>
    <td><input name='email' value='${user.getEmail()}'></td>
    <td><input name='password' value='${user.getPassword()}'></td>
    <td>
        <select multiple>
            @for(UserRole userRole : UserRole.values())
                <option selected="${user.getRoles().contains( userRole )}"
                        value="${userRole.name()}">${userRole.name()}</option>
            @endfor
        </select>
    </td>
    <td>${user.getLastLogin().toString()}</td>
    <td>
        <button hx-get="/admin/user/${user.getUsername()}">
            Cancel
        </button>
        <button hx-put="/admin/user/${user.getUsername()}" hx-include="closest tr">
            Save
        </button>
    </td>
</tr>