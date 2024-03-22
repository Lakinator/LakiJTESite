@import de.lakinator.lakijtesite.persistence.model.User
@import de.lakinator.lakijtesite.security.UserRole

@param User user

<dialog id="editUserDialog" class="modal active">
    <h5>Modal</h5>
    <div>Some text here</div>
    <nav class="right-align no-space">
        <button class="transparent link"
                hx-trigger="click"
                hx-get="/admin/user/${user.getUsername()}/cancel-dialog"
                hx-target="#editUserDialog"
                hx-swap="delete">
            Cancel
        </button>
        <button class="transparent link">Confirm</button>
    </nav>
</dialog>