package ru.lavrov.tm.service;


import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.lavrov.tm.api.*;
import ru.lavrov.tm.entity.User;
import ru.lavrov.tm.exception.user.*;
import ru.lavrov.tm.role.Role;

public final class UserServiceImpl extends AbstractService<User> implements IUserService {
    @NotNull protected final IProjectRepository projectRepository;
    @NotNull protected final ITaskRepository taskRepository;
    @NotNull protected final IUserRepository userRepository;

    public UserServiceImpl(final IUserRepository userRepository,
                           final IProjectRepository projectRepository,
                           final ITaskRepository taskRepository) {
        super(userRepository);
        this.projectRepository = projectRepository;
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    public void createByLogin(@Nullable final String login, @Nullable final String password, @Nullable final String role) {
        if (login == null || login.isEmpty())
            throw new UserLoginIsInvalidException();
        if (password == null || password.isEmpty())
            throw new UserPasswordIsInvalidException();
        if (role == null || role.isEmpty())
            throw new UserRoleIsInvalidException();
        final Role currentRole = Role.valueOf(role);
        if (currentRole == null)
            throw new UserRoleIsInvalidException();
        final User user = userRepository.findEntityByName(login, null);
        if (user != null)
            throw new UserLoginExistsException();
        persist(new User(login, password, currentRole));
    }

    public void updatePassword(@Nullable final String userId, @Nullable final String newPassword) {
        if (userId == null || userId.isEmpty())
            throw new UserIsNotAuthorizedException();
        if (newPassword == null || newPassword.isEmpty())
            throw new UserPasswordIsInvalidException();
        userRepository.updatePassword(userId, newPassword);
    }

    public void updateLogin(@Nullable final String userId, @Nullable final String newLogin) {
        if (userId == null || userId.isEmpty())
            throw new UserIsNotAuthorizedException();
        if (newLogin == null || newLogin.isEmpty())
            throw new UserLoginIsInvalidException();
        final User user =  userRepository.findEntityByName(newLogin, null);
        if (user != null)
            throw new UserLoginExistsException();
        userRepository.updateLogin(userId, newLogin);
    }
}
