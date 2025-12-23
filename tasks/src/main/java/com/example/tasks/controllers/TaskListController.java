package com.example.tasks.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.tasks.domain.dto.TaskListDTO;
import com.example.tasks.mappers.TaskListMapper;
import com.example.tasks.services.TaskListService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping(path = "/task-lists")
public class TaskListController {

    private final TaskListService taskListService;
    private final TaskListMapper taskListMapper;

    public TaskListController(TaskListService taskListService, TaskListMapper taskListMapper){
        this.taskListService = taskListService;
        this.taskListMapper = taskListMapper;
    }

    @GetMapping
    public List<TaskListDTO> listTaskLists(){
        return taskListService.listTaskLists()
               .stream()
               .map(taskListMapper::toDto)
               .toList();
    }
}
