package ru.lavrov.tm.exception.commandException;

public class CommandDescriptionIsInvalidException extends RuntimeException{
    private static final String message = "command description is empty or null!";
    public CommandDescriptionIsInvalidException() {
        super(message);
    }
    public CommandDescriptionIsInvalidException(String message) {
        super(message);
    }
}
