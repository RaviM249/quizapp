package com.mcq.quizapp.service;

import com.mcq.quizapp.dto.QuizAnswerDto;
import com.mcq.quizapp.dto.QuizQuestionDto;
import com.mcq.quizapp.entity.QuizEntity;
import com.mcq.quizapp.repository.QuizRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;

@Component
public class QuizService {

    private final QuizRepository quizRepository;

    public QuizService(QuizRepository quizRepository){
        this.quizRepository=quizRepository;
    }

    public List<QuizQuestionDto> getAllQuestions(){
        List<QuizEntity> quizEntities=  quizRepository.findAll();
        List<QuizQuestionDto> quizDtos = new ArrayList<>();
        for(QuizEntity quizEntity: quizEntities){
            quizDtos.add(toQuizDto(quizEntity));
        }
        return quizDtos;
    }

    public ResponseEntity<QuizQuestionDto> getQuestionById(int id){
        QuizEntity quizEntity =  quizRepository.findById(id).orElse(null);
        if(nonNull(quizEntity)){
            return ResponseEntity.status(HttpStatus.OK).body(toQuizDto(quizEntity));
        } return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    public ResponseEntity<Boolean> checkAnswerById(int id, QuizAnswerDto answer){
        QuizEntity quizEntity = quizRepository.findById(id).orElse(null);
        if(!(quizEntity ==null) && quizEntity.getAnswer().equals(answer.getAnswer())){
            return ResponseEntity.status(HttpStatus.OK).body(true);
        } return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
    }

    private QuizQuestionDto toQuizDto(QuizEntity quizEntity){
        QuizQuestionDto quizDto = new QuizQuestionDto();
        quizDto.setId(quizEntity.getId());
        quizDto.setQuestion(quizEntity.getQuestion());
        quizDto.setOptions(quizEntity.getOptions());

        return quizDto;
    }
}
