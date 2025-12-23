package com.example.tasks.services;

import java.util.List;

import com.example.tasks.domain.entities.TaskList;

public interface TaskListService {
    List<TaskList> listTaskLists();
}
