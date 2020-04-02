package ru.lavrov.tm.command.project;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.lavrov.tm.command.AbstractCommand;
import ru.lavrov.tm.endpoint.Project;
import ru.lavrov.tm.endpoint.ProjectEndpointService;

import java.util.Collection;

@NoArgsConstructor
public final class ProjectListByStartDateCommand extends AbstractCommand {
    private static final boolean SAFE = false;

    @NotNull
    private static final String COMMAND = "project-list-by-start-date";
    @NotNull
    private static final String DESCRIPTION = "Show all projects sorted by start date.";

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
        System.out.println("[PROJECT LIST]");
        @Nullable final String token = bootstrap.getCurrentToken();
        @NotNull final ProjectEndpointService projectEndpointService = bootstrap.getProjectEndpointService();
        @Nullable final Collection<Project> projectList =
                projectEndpointService.getProjectEndpointPort().findAllByStartDate(token);
        if (projectList == null)
            return;
        int index = 1;
        for (@Nullable final Project project : projectList) {
            if (project == null)
                continue;
            System.out.println(index++ + ". " + project);
        }
        System.out.println();
    }

    @Override
    public boolean isSafe() {
        return SAFE;
    }


}
