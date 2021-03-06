package ru.lavrov.tm.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.lavrov.tm.api.entity.IComparableEntity;
import ru.lavrov.tm.api.entity.IEntity;
import ru.lavrov.tm.enumerate.Status;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@XmlRootElement(name = "task")
public final class TaskDTO implements IEntity, IComparableEntity {

    @Nullable
    private String name;
    @NotNull
    private String id = UUID.randomUUID().toString();
    @Nullable
    private String description;
    @Nullable
    private Date creationDate = new Date();
    @Nullable
    private Date startDate = null;
    @Nullable
    private Date finishDate = null;
    @Nullable
    private String userId;
    @Nullable
    private String projectId = null;
    @Nullable
    private Status status = Status.PLANNED;

    public TaskDTO(@Nullable final String name, @Nullable final String projectId, @Nullable final String userId) {
        this.name = name;
        this.projectId = projectId;
        this.userId = userId;
    }

    @Nullable
    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", description=" + description +
                ", startDate=" + startDate +
                ", finishDate=" + finishDate +
                ", projectId='" + projectId + '\'' +
                ", userId='" + userId + '\'';
    }
}
