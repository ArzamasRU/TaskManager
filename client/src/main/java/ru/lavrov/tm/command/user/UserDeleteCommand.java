package ru.lavrov.tm.command.user;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import ru.lavrov.tm.command.AbstractCommand;
import ru.lavrov.tm.endpoint.UserEndpointService;

@NoArgsConstructor
public final class UserDeleteCommand extends AbstractCommand {
    private static final boolean SAFE = false;
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
        if (userEndpointService.getUserEndpointPort().deleteUser(bootstrap.getCurrentToken()))
            System.out.println("[ok]");
        else
            System.out.println("[error]");
        System.out.println();
    }

    @Override
    public boolean isSafe() {
        return SAFE;
    }


}