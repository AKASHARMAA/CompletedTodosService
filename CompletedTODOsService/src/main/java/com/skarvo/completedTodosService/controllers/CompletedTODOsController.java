package com.skarvo.completedTodosService.controllers;

import com.skarvo.completedTodosService.jpa.CompletionStatusRepository;
import com.skarvo.completedTodosService.models.CompletionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController("/")
public class CompletedTODOsController {

    @Autowired
    private CompletionStatusRepository repo;


    @GetMapping("{id}")
    public Boolean checkStatus(@PathVariable final Integer id) {
        final Optional<CompletionStatus> status = repo.findById(id);
        return status.isPresent() ? status.get().isCompleted() : false;
    }

    @PostMapping("/")
    public Boolean create(@ModelAttribute final CompletionStatus completionStatus){
        return repo.save(completionStatus) != null;
    }
}
