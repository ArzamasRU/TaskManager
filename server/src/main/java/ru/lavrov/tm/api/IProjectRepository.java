package ru.lavrov.tm.api;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.lavrov.tm.entity.Project;

import java.util.Collection;
import java.util.Comparator;

public interface IProjectRepository extends IRepository<Project> {
    void renameProject(@Nullable String userId, @Nullable String oldName, @Nullable String newName);

    Project findEntityByName(@Nullable String userId, @Nullable String entityName);

    Collection<Project> findAll(@Nullable String userId, @Nullable Comparator<Project> comparator);

    Collection<Project> findAllByNamePart(@Nullable String userId, @Nullable String name);

    Collection<Project> findAllByDescPart(@Nullable String userId, @Nullable String description);

    Project findOne(@NotNull String userId, @NotNull String projectId);

    void removeProject(@Nullable final String userId, @Nullable final String entityId);
}