package ru.lavrov.tm.command.projectCommand;

import ru.lavrov.tm.bootstrap.Bootstrap;
import ru.lavrov.tm.command.AbstractCommand;
import ru.lavrov.tm.role.Role;
import ru.lavrov.tm.service.ProjectService;

import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

public final class ProjectRemoveCommand extends AbstractCommand {
    private final boolean isSafe = false;
    private final Collection<Role> roles = Arrays.asList(Role.Admin);

    public ProjectRemoveCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    public ProjectRemoveCommand() {
        super();
    }

    @Override
    public String command() {
        return "project-remove";
    }

    @Override
    public String description() {
        return "Remove selected project.";
    }

    @Override
    public void execute() throws RuntimeException {
        Scanner input = new Scanner(System.in);
        System.out.println("[project remove]");
        System.out.println("enter name:");
        String command = input.nextLine();
        ProjectService projectService = bootstrap.getProjectService();
        projectService.removeProject(command);
        System.out.println("[Project removed]");
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
