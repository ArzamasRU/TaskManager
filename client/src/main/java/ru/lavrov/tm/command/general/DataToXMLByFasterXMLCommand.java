package ru.lavrov.tm.command.general;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.lavrov.tm.command.AbstractCommand;
import ru.lavrov.tm.endpoint.GeneralCommandsEndpointService;
import ru.lavrov.tm.endpoint.Role;
import ru.lavrov.tm.endpoint.Session;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

public final class DataToXMLByFasterXMLCommand extends AbstractCommand {
    private static final boolean SAFE = true;
    @Nullable
    private static final Collection<Role> ROLES = Arrays.asList(Role.ADMIN, Role.USER);
    @NotNull
    private static final String COMMAND = "to-XML-by-fasterXML";
    @NotNull
    private static final String DESCRIPTION = "Externalize data to XML by fasterXML.";

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
        System.out.println("[Externalization data to XML By fasterXML]");
        @Nullable final Session currentSession = bootstrap.getCurrentSession();
        @NotNull final GeneralCommandsEndpointService generalCommandsEndpointService =
                bootstrap.getGeneralCommandsEndpointService();
        if (generalCommandsEndpointService.getGeneralCommandsEndpointPort().dataToXMLByFasterXML(currentSession))
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
