package com.example.tasks.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.tasks.domain.entities.TaskList;
import com.example.tasks.repositories.TaskListRepository;
import com.example.tasks.services.TaskListService;

@Service
public class TaskListServiceImpl implements TaskListService {

    private final TaskListRepository taskListRepository;

    public TaskListServiceImpl(TaskListRepository taskListRepository){
        this.taskListRepository = taskListRepository;
    }

    @Override
    public List<TaskList> listTaskLists() {
        return taskListRepository.findAll();
    }

}
