package com.mcq.quizapp.controller;

import com.mcq.quizapp.dto.QuizAnswerDto;
import com.mcq.quizapp.dto.QuizQuestionDto;
import com.mcq.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("http://localhost:3000")
public class QuizController {

    @Autowired
    QuizService quizService;

    @GetMapping("/questions")
    public ResponseEntity<List<QuizQuestionDto>> getAllQuestions(){
        return ResponseEntity.status(HttpStatus.OK).body(quizService.getAllQuestions());
    }

    @GetMapping("/questions/{id}")
    public ResponseEntity<QuizQuestionDto> getQuestionById(@PathVariable("id") int id){
        return quizService.getQuestionById(id);
    }

    @PostMapping("/questions/{id}")
    public ResponseEntity<Boolean> singleAnswer(
            @PathVariable("id") int id,
            @RequestBody QuizAnswerDto answerDto){
        return quizService.checkAnswerById(id,answerDto);
    }
}
