package ru.lavrov.tm.command.general;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.lavrov.tm.command.AbstractCommand;
import ru.lavrov.tm.endpoint.GeneralCommandEndpointService;

public final class DataToXMLByJAXBСommand extends AbstractCommand {
    final boolean SAFE = false;
    @NotNull
    private static final String COMMAND = "to-XML-by-JAXB";
    @NotNull
    private static final String DESCRIPTION = "Externalize data to XML by JAXB.";

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
        System.out.println("[Externalization data to XML By JAXB]");
        @Nullable final String token = bootstrap.getCurrentToken();
        @NotNull final GeneralCommandEndpointService generalCommandEndpointService =
                bootstrap.getGeneralCommandEndpointService();
        if (generalCommandEndpointService.getGeneralCommandEndpointPort().dataToXMLByJAXB(token))
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
