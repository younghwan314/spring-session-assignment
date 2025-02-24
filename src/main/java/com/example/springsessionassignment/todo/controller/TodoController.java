package com.example.springsessionassignment.todo.controller;

import com.example.springsessionassignment.todo.dto.TodoResponseDto;
import com.example.springsessionassignment.todo.dto.TodoSaveRequestDto;
import com.example.springsessionassignment.todo.dto.TodoUpdateRequestDto;
import com.example.springsessionassignment.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping("/todos")
    public ResponseEntity<TodoSaveRequestDto> save(
            @SessionAttribute(name = Const.LOGIN_MEMBER) Long memberId,
            @RequestBody TodoSaveRequestDto dto
    ) {
        return ResponseEntity.ok(todoService.save(memberId, dto));
    }

    @GetMapping("/todos")
    public ResponseEntity<List<TodoResponseDto>> getAll() {
        return ResponseEntity.ok(todoService.findAll());
    }

    @GetMapping("/todos/{todoId}")
    public ResponseEntity<TodoResponseDto> getOne(
            @PathVariable Long todoId
    ) {
        return ResponseEntity.ok(todoService.findById(todoId));
    }

    @PutMapping("/todos/{todoId}")
    public void update(
            @SessionAttribute(name = Const.LOGIN_MEMBER) Long memberId,
            @PathVariable Long todoId,
            @RequestBody TodoUpdateRequestDto dto
            ) {
        return ResponseEntity.ok(todoService.update(memberId, todoId, dto));
    }

    @DeleteMapping("/todos/{todoId}")
    public void delete(
            @SessionAttribute(name = Const.LOGIN_MEMBER) Long memberId,
            @PathVariable Long todoId
    ) {
        todoService.deleteById(memberId, todoId);
    }
}
