package ru.lavrov.tm.exception.projectException;

public class ProjectNotExistsException extends RuntimeException{
    private static final String message = "user does not exist";
    public ProjectNotExistsException() {
        super(message);
    }
    public ProjectNotExistsException(String message) {
        super(message);
    }
}
