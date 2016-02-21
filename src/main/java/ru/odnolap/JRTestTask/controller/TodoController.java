package ru.odnolap.JRTestTask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.odnolap.JRTestTask.repository.TodoRepository;
import ru.odnolap.JRTestTask.validation.TodoValidator;
import ru.odnolap.JRTestTask.domain.Todo;

import java.util.List;

@Controller
public class TodoController {

    private TodoRepository todoRepository;
    private TodoValidator todoValidator;

    @Autowired
    public TodoController(TodoRepository todoRepository, TodoValidator todoValidator) {
        this.todoRepository = todoRepository;
        this.todoValidator = todoValidator;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getTodos(Model model) {
        List<Todo> todos = this.todoRepository.listAll();
        model.addAttribute("todos", todos);
        return "index";
    }

    @RequestMapping(value = "/filterCompleted", method = RequestMethod.GET)
    public String filterTodosGood(Model model) {
        List<Todo> todos = this.todoRepository.listFilteredCompleted();
        model.addAttribute("todos", todos);
        return "index";
    }

    @RequestMapping(value = "/filterUncompleted", method = RequestMethod.GET)
    public String filterTodosBad(Model model) {
        List<Todo> todos = this.todoRepository.listFilteredUncompleted();
        model.addAttribute("todos", todos);
        return "index";
    }

    @RequestMapping(value = "addTodo", method = RequestMethod.GET)
    public String addTodo(Model model){
        model.addAttribute("todo", new Todo());
        return "addTodo";
    }

    @RequestMapping(value = "addTodo", method = RequestMethod.POST)
    public String addTodo(@ModelAttribute("todo") Todo todo, BindingResult bindingResult){
        this.todoValidator.validate(todo, bindingResult);

        if (bindingResult.hasErrors()){
            return "addTodo";
        }

        this.todoRepository.addTodo(todo);
        return "redirect:/";
    }

    @RequestMapping(value = "editTodo/{id}", method = RequestMethod.GET)
    public String editTodo(@PathVariable Integer id, Model model){
        model.addAttribute("todo", this.todoRepository.getTodoById(id));
        return "editTodo";
    }

    @RequestMapping(value = "editTodo", method = RequestMethod.POST)
    public String editTodo(@ModelAttribute("todo") Todo todo, BindingResult bindingResult){
        this.todoValidator.validate(todo, bindingResult);

        if (bindingResult.hasErrors()){
            return "editTodo";
        }

        this.todoRepository.editTodo(todo);
        return "redirect:/";
    }


    @RequestMapping(value = "deleteTodo/{id}", method = RequestMethod.GET)
    public String deleteTodo(@PathVariable Integer id){
        this.todoRepository.removeTodo(id);
        return "redirect:/";
    }

    @RequestMapping(value = "completeTodo/{id}", method = RequestMethod.GET)
    public String moveTodoToGood(@PathVariable Integer id){
        this.todoRepository.completeTodo(id);
        return "redirect:/";
    }


}
