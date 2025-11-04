package com.alibaba35t.ToDoList;

import org.springframework.cglib.core.Local;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/api")
public class TaskController {
    private final ITaskRepo taskRepo;

    public TaskController(ITaskRepo taskRepo)
    {
        this.taskRepo= taskRepo;
    }

    @PostMapping("/tasks")
    ResponseEntity<Void> add_task(@RequestBody Task new_task)
    {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("nnnnn"+now);
        LocalDateTime taskDateTime = LocalDateTime.of(new_task.getTaskDate(), new_task.getTaskTime());
        System.out.println("ttttt"+taskDateTime);
        if(taskDateTime.isAfter(now) || taskDateTime.isEqual(now)) {
            taskRepo.save(new_task);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/tasks")
    List<Task> get_all(){
        return taskRepo.findAllByCompleted(false,Sort.by("taskDate").and(Sort.by("taskTime")));
    }
    @GetMapping("/tasks/completed")
    List<Task> get_completed(){
        return taskRepo.findAllByCompleted(true, Sort.by("taskDate").and(Sort.by("taskTime")));
    }

    @PutMapping("/tasks/{id}")
    ResponseEntity<Task> toogle_completed(@PathVariable Integer id){
        Optional<Task> task_comp = taskRepo.findById(id);
        if(task_comp.isPresent())
        {
            Task task = task_comp.get();
            task.setIs_completed(!task.Is_completed());
            taskRepo.save(task);
            return ResponseEntity.ok(task);
        }
        else{
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/tasks/{id}")
    ResponseEntity<Task> task_delete(@PathVariable Integer id)
    {
    Optional<Task> deletion = taskRepo.findById(id);
    if(deletion.isPresent()){
        taskRepo.delete(deletion.get());
        return ResponseEntity.ok().build();
    }
    else{
        return ResponseEntity.notFound().build();
    }
    }
}
