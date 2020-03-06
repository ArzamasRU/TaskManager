package ru.lavrov.tm.repository;

import org.jetbrains.annotations.Nullable;
import ru.lavrov.tm.api.IEntity;
import ru.lavrov.tm.api.IProjectRepository;
import ru.lavrov.tm.api.IRepository;
import ru.lavrov.tm.entity.Project;
import ru.lavrov.tm.exception.entity.EntityNotExistsException;
import ru.lavrov.tm.exception.project.ProjectNameExistsException;
import ru.lavrov.tm.exception.project.ProjectNameIsInvalidException;
import ru.lavrov.tm.exception.project.ProjectNotExistsException;
import ru.lavrov.tm.exception.user.UserIsNotAuthorizedException;

public final class ProjectRepositoryImpl extends AbstractRepository<Project> implements IProjectRepository {
    @Override
    public void renameProject(@Nullable final String oldName, @Nullable final String newName,
                              @Nullable final String userId) {
        if (newName == null || newName.isEmpty() || oldName == null || oldName.isEmpty())
            throw new ProjectNameIsInvalidException();
        if (userId == null || userId.isEmpty())
            throw new UserIsNotAuthorizedException();
        Project project = findEntityByName(newName, userId);
        if (project != null)
            throw new ProjectNameExistsException();
        project = findEntityByName(oldName, userId);
        if (!project.getUserId().equals(userId))
            throw new ProjectNotExistsException();
        project.setName(newName);
    }
}
