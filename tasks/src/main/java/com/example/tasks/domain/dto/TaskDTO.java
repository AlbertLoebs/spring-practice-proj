package com.example.tasks.domain.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.example.tasks.domain.entities.TaskPriority;
import com.example.tasks.domain.entities.TaskStatus;

public record TaskDTO(UUID id, String title, String description, LocalDateTime dueDate, TaskPriority priority,
        TaskStatus status) {

}
