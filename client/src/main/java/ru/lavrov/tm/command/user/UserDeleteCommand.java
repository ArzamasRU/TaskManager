package ru.lavrov.tm.command.user;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.lavrov.tm.command.AbstractCommand;
import ru.lavrov.tm.endpoint.Role;
import ru.lavrov.tm.endpoint.UserEndpointService;

import java.util.Collection;

@NoArgsConstructor
public final class UserDeleteCommand extends AbstractCommand {
    private static final boolean SAFE = false;
    @Nullable
    private static final Collection<Role> ROLES = null;
    @NotNull
    private static final String COMMAND = "user-delete";
    @NotNull
    private static final String DESCRIPTION = "Delete account.";

    @NotNull
    @Override
    public String getCommand() {
        return COMMAND;
    }

    @NotNull
    @Override
    public String getDescription() {
        return DESCRIPTION;
    }

    @Override
    public void execute() {
        @NotNull final UserEndpointService userEndpointService = bootstrap.getUserEndpointService();
        if (userEndpointService.getUserEndpointPort().deleteUser(bootstrap.getCurrentSession()))
            System.out.println("[ok]");
        else
            System.out.println("[error]");
        System.out.println();
    }

    @Override
    public boolean isSafe() {
        return SAFE;
    }

    @Nullable
    @Override
    public Collection<Role> getRoles() {
        return ROLES;
    }
}