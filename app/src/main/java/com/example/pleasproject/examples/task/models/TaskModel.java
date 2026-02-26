package com.example.pleasproject.examples.task.models;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.time.LocalDate;

public class TaskModel {
    public LocalDate createBy;
    public LocalDate deadlineBy;
    public String description;
    public Boolean isSuccess;

    public TaskModel(@NonNull String description,
                     @NonNull LocalDate createBy,
                     @Nullable LocalDate deadlineBy)
    {
        this.description    = description;
        this.createBy       = createBy;
        this.deadlineBy     = deadlineBy;
    }
}
