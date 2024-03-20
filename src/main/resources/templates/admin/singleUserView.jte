@import de.lakinator.lakijtesite.persistence.model.User
@import java.util.Arrays

@param User user

<tr>
    <td>${user.getUsername()}</td>
    <td>${user.getDisplayName()}</td>
    <td>${user.getEmail()}</td>
    <td>${user.getPassword()}</td>
    <td>${Arrays.toString( user.getRoles().toArray() )}</td>
    <td>${user.getLastLogin().toString()}</td>
    <td>
        <button hx-get="/admin/user/${user.getUsername()}/edit">
            Edit
        </button>
    </td>
</tr>