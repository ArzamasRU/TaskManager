package ru.lavrov.tm.command.task;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.lavrov.tm.command.AbstractCommand;
import ru.lavrov.tm.endpoint.Task;
import ru.lavrov.tm.endpoint.TaskEndpointService;
import ru.lavrov.tm.util.InputUtil;

import java.util.Collection;

public final class TaskFindByDescription extends AbstractCommand {
    private static final boolean SAFE = false;

    @NotNull
    private static final String COMMAND = "task-find-by-desc";
    @NotNull
    private static final String DESCRIPTION = "Show task by description.";

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
        System.out.println("[TASK LIST]");
        System.out.println("enter name:");
        @Nullable final String desc = InputUtil.INPUT.nextLine();
        @Nullable final String token = bootstrap.getCurrentToken();
        @NotNull final TaskEndpointService taskEndpointService = bootstrap.getTaskEndpointService();
        @Nullable final Collection<Task> taskList =
                taskEndpointService.getTaskEndpointPort().findAllTasksByDescPart(token, desc);
        if (taskList == null)
            return;
        int index = 1;
        for (@Nullable final Task task : taskList) {
            if (task == null)
                continue;
            System.out.println(index++ + ". " + task);
        }
        System.out.println();
    }

    @Override
    public boolean isSafe() {
        return SAFE;
    }


}
