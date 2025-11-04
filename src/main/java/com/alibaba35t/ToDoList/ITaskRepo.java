package com.alibaba35t.ToDoList;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITaskRepo extends JpaRepository<Task,Integer> {
    List<Task> findAllByCompleted(boolean completed, Sort sort);
}
