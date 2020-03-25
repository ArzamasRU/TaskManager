package ru.lavrov.tm.repository;

import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.lavrov.tm.api.IProjectRepository;
import ru.lavrov.tm.entity.Project;
import ru.lavrov.tm.enumerate.ColumnName;
import ru.lavrov.tm.exception.entity.EntityNameIsInvalidException;
import ru.lavrov.tm.exception.general.DescriptionIsInvalidException;
import ru.lavrov.tm.exception.general.NameIsInvalidException;
import ru.lavrov.tm.exception.project.ProjectNameExistsException;
import ru.lavrov.tm.exception.project.ProjectNameIsInvalidException;
import ru.lavrov.tm.exception.project.ProjectNotExistsException;
import ru.lavrov.tm.exception.user.UserIsNotAuthorizedException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

public final class ProjectRepositoryImpl extends AbstractRepository<Project> implements IProjectRepository {

    @NotNull
    private final Connection connection;

    public ProjectRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void renameProject(
            @Nullable final String userId, @Nullable final String oldName, @Nullable final String newName
    ) {
        if (newName == null || newName.isEmpty() || oldName == null || oldName.isEmpty())
            throw new ProjectNameIsInvalidException();
        if (userId == null || userId.isEmpty())
            throw new UserIsNotAuthorizedException();
        @Nullable Project project = findEntityByName(userId, newName);
        if (project != null)
            throw new ProjectNameExistsException();
        project = findEntityByName(userId, oldName);
        if (project != null)
            throw new ProjectNameExistsException();
        if (!project.getUserId().equals(userId))
            throw new ProjectNotExistsException();
        project.setName(newName);
    }

    @Nullable
    @Override
    public Collection<Project> findAll(@Nullable final String userId, @Nullable final Comparator<Project> comparator) {
        if (userId == null || userId.isEmpty())
            throw new UserIsNotAuthorizedException();
        @Nullable final Collection<Project> list = new ArrayList<>();
        for (@Nullable final Project entity : entities.values()) {
            if (entity == null)
                continue;
            if (entity.getUserId().equals(userId))
                list.add(entity);
        }
        if (comparator == null)
            return list;
        ((ArrayList<Project>) list).sort(comparator);
        return list;
    }

    @Nullable
    @Override
    public Collection<Project> findAllByNamePart(@Nullable final String userId, @Nullable final String name) {
        if (userId == null || userId.isEmpty())
            throw new UserIsNotAuthorizedException();
        if (name == null || name.isEmpty())
            throw new NameIsInvalidException();
        @Nullable final Collection<Project> list = new ArrayList<>();
        for (@Nullable final Project entity : entities.values()) {
            if (entity == null)
                continue;
            if (entity.getUserId().equals(userId) && entity.getName().contains(name))
                list.add(entity);
        }
        return list;
    }

    @Nullable
    @Override
    public Collection<Project> findAllByDescPart(@Nullable final String userId, @Nullable final String description) {
        if (userId == null || userId.isEmpty())
            throw new UserIsNotAuthorizedException();
        if (description == null || description.isEmpty())
            throw new DescriptionIsInvalidException();
        @Nullable final Collection<Project> list = new ArrayList<>();
        for (@Nullable final Project entity : entities.values()) {
            if (entity == null)
                continue;
            if (entity.getUserId().equals(userId) && entity.getDescription().contains(description))
                list.add(entity);
        }
        return list;
    }

    @Nullable
    @Override
    public Project findEntityByName(@Nullable final String userId, @Nullable final String entityName) {
        if (entityName == null || entityName.isEmpty())
            throw new EntityNameIsInvalidException();
        if (userId == null || userId.isEmpty())
            throw new UserIsNotAuthorizedException();
        @Nullable Project currentEntity = null;
        for (@Nullable final Project entity : entities.values()) {
            if (entity == null)
                continue;
            boolean isEntityNameEquals = entityName.equals(entity.getName());
            boolean isEntityUserIdEquals = entity.getUserId().equals(userId);
            if (isEntityNameEquals && isEntityUserIdEquals) {
                currentEntity = entity;
                break;
            }
        }
        return currentEntity;
    }

    @Nullable
    @Override
    public Project findOne(@NotNull final String userId, @NotNull final String projectId) {
        @NotNull final String query = "SELECT * FROM app_project WHERE user_id = ? AND id = ?;";
        @Nullable PreparedStatement preparedStatement = null;
        @Nullable ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, userId);
            preparedStatement.setString(2, projectId);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
                return fetch(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (preparedStatement == null)
            throw new NullPointerException();
        return null;
    }

    @Nullable
    private Project fetch(@Nullable final ResultSet row) {
        if (row == null)
            return null;
        @NotNull final Project project = new Project();
        try {
            project.setId(row.getString(ColumnName.ID.toString()));
            project.setUserId(row.getString(ColumnName.USER_ID.toString()));
            project.setName(row.getString(ColumnName.NAME.toString()));
            project.setDescription(row.getString(ColumnName.DESCRIPTION.toString()));
            project.setDateCreate(row.getDate(ColumnName.DATE_CREATE.toString()));
            project.getStartDate(row.getDate(ColumnName.DATE_START.toString()));
            project.setFinishDate(row.getDate(ColumnName.DATE_FINISH.toString()));
            project.setStatus(Status.valueOf(row.getString(ColumnName.STATUS.toString())));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return project;
    }
}
