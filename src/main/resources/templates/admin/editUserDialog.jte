@import de.lakinator.lakijtesite.persistence.model.User

@param User user

<dialog id="editUserDialog" class="modal active">
    <h5>Modal</h5>
    <div>Nutzer '${user.getUsername()}' bearbeiten</div>

    <%--  TODO: put in FORM  --%>
    <div class="grid">

        <div class="s6 field label border">
            <input type="text">
            <label>Anzeigename</label>
        </div>

    </div>

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