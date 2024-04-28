package com.mcq.quizapp.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class QuizQuestionDto {
    int id;
    String question;
    List<String> options= new ArrayList<>();

}
