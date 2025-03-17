package com.app.todoapp.todoapp.Controller;

import com.app.todoapp.models.Task;
import com.app.todoapp.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;  // <-- Correct import
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public String getTasks(Model model) {
        List<Task> tasks = taskService.getAlltasks();
        model.addAttribute("tasks", tasks);
        return "task";
    }

    @PostMapping
    public String createTask(@RequestParam String title) {
        taskService.createTask(title);
        return "redirect:/task";
    }

    @GetMapping("/{id}/delete")
    public String deleteTasks(@PathVariable Long id) {

        taskService.deleteTask(id);
        return "redirect:/task";
    }

    @GetMapping("/{id}/toggle")
    public String toggeleTasks(@PathVariable Long id) {
        taskService.toggeleTasks(id);
        return "redirect:/task";
    }
}
