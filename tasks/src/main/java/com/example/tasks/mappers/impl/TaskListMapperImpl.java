package com.example.tasks.mappers.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.example.tasks.domain.dto.TaskListDTO;
import com.example.tasks.domain.entities.Task;
import com.example.tasks.domain.entities.TaskList;
import com.example.tasks.domain.entities.TaskStatus;
import com.example.tasks.mappers.TaskListMapper;
import com.example.tasks.mappers.TaskMapper;

@Component
public class TaskListMapperImpl implements TaskListMapper {

    private final TaskMapper taskMapper;

    public TaskListMapperImpl(TaskMapper taskMapper){
        this.taskMapper = taskMapper;
    }

    @Override
    public TaskList fromDto(TaskListDTO taskListDTO) {
        return new TaskList(
            taskListDTO.id(),
            taskListDTO.title(),
            taskListDTO.description(),
            Optional.ofNullable(taskListDTO.tasks())
                                .map(tasks -> tasks.stream().map(taskMapper::fromDto)
                                .toList()
                            ).orElse(null),null,null
                                
        );
    }

    @Override
    public TaskListDTO toDto(TaskList taskList) {
        return new TaskListDTO(
            taskList.getId(),
            taskList.getTitle(),
            taskList.getDescription(),
            Optional.ofNullable(taskList.getTasks())
                                .map(List::size).orElse(0),calculateTaskListProgress(taskList.getTasks()),
                                Optional.ofNullable(taskList.getTasks())
                                .map(tasks -> tasks.stream().map(taskMapper::toDto).toList()
                            ).orElse(null)
        );
    }
    
    private Double calculateTaskListProgress(List<Task> tasks){
        if(null == tasks) {
            return null;
        }

        long closedTaskCount = tasks.stream().filter(task -> TaskStatus.CLOSED == task.getStatus()
        ).count();

        return (double) closedTaskCount / tasks.size();

    }

}
