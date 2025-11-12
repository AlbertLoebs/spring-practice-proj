package com.example.tasks.mappers;

import com.example.tasks.domain.dto.TaskDTO;
import com.example.tasks.domain.entities.Task;

public interface TaskMapper {

    Task fromDto(TaskDTO taskDTO);

    TaskDTO toDto(Task task);

}
