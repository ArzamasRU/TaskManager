package ru.lavrov.tm.command.userCommand;

import ru.lavrov.tm.bootstrap.Bootstrap;
import ru.lavrov.tm.command.AbstractCommand;
import ru.lavrov.tm.exception.utilException.UtilAlgorithmNotExistsException;
import ru.lavrov.tm.util.HashUtil;

import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public final class UserLoginCommand extends AbstractCommand {
    public UserLoginCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    public UserLoginCommand() {
        super();
    }

    @Override
    public String command() {
        return "login";
    }

    @Override
    public String description() {
        return "authorization";
    }

    @Override
    public void execute() {
        Scanner input = new Scanner(System.in);
        System.out.println("[Please Log in]");
        System.out.println("enter login:");
        String login = input.nextLine();
        System.out.println("enter password:");
        String password = input.nextLine();
        try {
            password = HashUtil.getHash(password);
        } catch (NoSuchAlgorithmException e) {
            throw new UtilAlgorithmNotExistsException();
        }
        bootstrap.login(login, password);
        System.out.println();
    }
}