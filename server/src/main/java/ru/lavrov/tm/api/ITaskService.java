package ru.lavrov.tm.api;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.lavrov.tm.entity.Task;

import java.util.Collection;
import java.util.Comparator;

public interface ITaskService extends IService<Task> {
    void createByTaskName(@Nullable String userId, @NotNull String taskName, @NotNull String projectName);

    void removeTaskByName(@Nullable String userId, @Nullable String taskName);

    void removeTask(@Nullable String userId, @Nullable String taskId);

    void renameTask(
            @Nullable String userId, @Nullable String projectName, @Nullable String oldName, @Nullable String newName
    );

    Collection<Task> findAll(@Nullable String userId, @Nullable Comparator<Task> comparator);

    Collection<Task> findAllByNamePart(@Nullable String userId, @Nullable String name);

    Collection<Task> findAllByDescPart(@Nullable String userId, @Nullable String description);
}