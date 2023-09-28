package com.skarvo.completedTodosService.jpa;

import com.skarvo.completedTodosService.models.CompletionStatus;
import org.springframework.data.repository.CrudRepository;

public interface CompletionStatusRepository extends CrudRepository<CompletionStatus, Integer> {
}
