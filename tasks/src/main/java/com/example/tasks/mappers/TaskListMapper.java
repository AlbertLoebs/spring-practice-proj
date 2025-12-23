package com.example.tasks.mappers;

import com.example.tasks.domain.dto.TaskListDTO;
import com.example.tasks.domain.entities.TaskList;

public interface TaskListMapper {
    
    TaskList fromDto(TaskListDTO taskListDTO);

    TaskListDTO toDto(TaskList taskList);

}
