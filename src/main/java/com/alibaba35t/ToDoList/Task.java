package com.alibaba35t.ToDoList;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String taskName;


    private LocalDate taskDate;


    private LocalTime taskTime;

    private boolean completed;

    public Task(){

    }
    public Task(Integer id, String task_name, LocalDate task_date, LocalTime task_time, boolean is_completed)
    {
        this.id = id;
        this.taskName=task_name;
        this.taskDate= task_date;
        this.taskTime = task_time;
        this.completed =is_completed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String task_name) {
        this.taskName = task_name;
    }

    public LocalDate getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(LocalDate task_date) {
        this.taskDate = task_date;
    }

    public LocalTime getTaskTime() {
        return taskTime;
    }

    public void setTaskTime(LocalTime task_time) {
        this.taskTime = task_time;
    }

    public boolean Is_completed() {
        return completed;
    }

    public void setIs_completed(boolean is_completed) {
        this.completed = is_completed;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", task_name='" + taskName + '\'' +
                ", task_date=" + taskDate +
                ", task_time=" + taskTime +
                ", is_completed=" + completed +
                '}';
    }
}
