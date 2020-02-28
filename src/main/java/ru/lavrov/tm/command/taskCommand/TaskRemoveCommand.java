package ru.lavrov.tm.command.taskCommand;

import ru.lavrov.tm.bootstrap.Bootstrap;
import ru.lavrov.tm.command.AbstractCommand;
import ru.lavrov.tm.role.Role;
import ru.lavrov.tm.service.TaskService;

import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

public final class TaskRemoveCommand extends AbstractCommand {
    private final boolean isSafe = false;
    private final Collection<Role> roles = Arrays.asList(Role.Admin);

    public TaskRemoveCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    public TaskRemoveCommand() {
        super();
    }

    @Override
    public String command() {
        return "task-remove";
    }

    @Override
    public String description() {
        return "Remove selected task.";
    }

    @Override
    public void execute() throws RuntimeException {
        Scanner input = new Scanner(System.in);
        System.out.println("[task remove]");
        System.out.println("enter name:");
        String command = input.nextLine();
        TaskService taskService = bootstrap.getTaskService();
        taskService.removeTask(command);
        System.out.println("[Task removed]");
        System.out.println();
    }

    @Override
    public boolean isSafe() {
        return isSafe;
    }

    @Override
    public Collection<Role> getRoles() {
        return roles;
    }
}
